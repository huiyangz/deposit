package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST110InputBO;
import com.dcits.depsit.facade.bo.ST110OutputBO;
import com.dcits.depsit.facade.components.IRbLimitSumInfoBcc;
import com.dcits.depsit.facade.eo.RbLimitSumInfoEO;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ST110 更新累计限额的步骤实现（条件触发的更新类步骤，单条编排、无业务失败分支）。
 *
 * <p>执行顺序为「先判定触发条件、命中后写入」的两段式：
 * 触发条件不成立时 MUST NOT 发起定位或写入；条件成立时按主键定位，命中后写回两列，未命中则不改动该表。
 * 两种不更新情形均正常结束（{@code succeed = true}）。</p>
 *
 * <p>本步骤无业务错误码；定位或写入调用本身的技术异常按框架传播，本步骤不捕获、不重试、不降级，
 * 也不把技术异常转换为业务结果。</p>
 */
@Service
public class ST110Pbc implements IST110 {

    /** 触发条件中「限额检查结果」的判定字面值（源需求原文用词）。 */
    private static final String CHECK_RESULT_NOT_EXCEED = "未超限";

    /** 数值 0，用于「大于 0」的严格比较。 */
    private static final BigDecimal ZERO = BigDecimal.ZERO;

    /** 限额累计信息表数据服务接口。 */
    private final IRbLimitSumInfoBcc rbLimitSumInfoBcc;

    public ST110Pbc(IRbLimitSumInfoBcc rbLimitSumInfoBcc) {
        this.rbLimitSumInfoBcc = rbLimitSumInfoBcc;
    }

    /**
     * 执行更新累计限额。
     *
     * @param input 步骤输入
     * @return 步骤输出：正常结束时 {@code succeed = true} 且错误字段为 null
     */
    @Override
    @Transactional
    public ST110OutputBO execute(ST110InputBO input) {
        ST110OutputBO output = new ST110OutputBO();

        // REQ-002 触发条件：限额检查结果＝「未超限」且（限额累计金额大于 0 或 限额累计笔数大于 0）
        if (isTriggered(input)) {
            // REQ-003 定位：以账号作为限额检查对象值（取自入参 baseAcctNo），连同限额场景编码（limitSceneNo）按主键定位
            RbLimitSumInfoEO record =
                    rbLimitSumInfoBcc.findByPrimaryKey(input.getBaseAcctNo(), input.getLimitSceneNo());
            if (record != null) {
                // REQ-003 写回：仅写 $累计限额$、$限额累计笔数$ 两列，取值唯一取自本次入参
                RbLimitSumInfoEO updateEo = new RbLimitSumInfoEO();
                updateEo.setCheckObjVal(input.getBaseAcctNo());
                updateEo.setLimitSceneNo(input.getLimitSceneNo());
                updateEo.setLimitSumAmt(input.getLimitSumAmt());
                updateEo.set否(input.getLimitSumNum());
                // selective 更新：入参中不为空的属性才写回，故写入字段范围即上述两列
                rbLimitSumInfoBcc.modifyByPrimaryKeySelective(updateEo);
                // REQ-005 输出＝本次写入的限额累计金额
                output.setLimitSumAmt(input.getLimitSumAmt());
            }
            // REQ-004 匹配不到记录：不更新本表、不新增、不删除，步骤正常结束
        }

        // 无业务失败场景（REQ-006）：触发条件不成立、匹配不到记录与更新成功均正常结束
        output.setSucceed(true);
        return output;
    }

    /**
     * 判定 REQ-002 的触发条件。
     *
     * <p>(a) 限额检查结果等于字面值「未超限」；(b) 限额累计金额大于 0 或 限额累计笔数大于 0，
     * 两者满足其一即可。「大于 0」为严格大于，取值等于 0 不满足。</p>
     *
     * <p>必填输入取空时的行为源需求未定义（Spec 不覆盖第 2 项），此处仅作空值保护以避免空指针，
     * 取空时不满足数值条件，不构成业务规则。</p>
     */
    private boolean isTriggered(ST110InputBO input) {
        if (!CHECK_RESULT_NOT_EXCEED.equals(input.get限额检查结果())) {
            return false;
        }
        boolean amtGreaterThanZero =
                input.getLimitSumAmt() != null && input.getLimitSumAmt().compareTo(ZERO) > 0;
        boolean numGreaterThanZero = input.getLimitSumNum() != null && input.getLimitSumNum() > 0;
        return amtGreaterThanZero || numGreaterThanZero;
    }
}
