package com.dcits.depsit.step;

import com.dcits.depsit.enums.CheckObjType;
import com.dcits.depsit.facade.bo.ST108InputBO;
import com.dcits.depsit.facade.bo.ST108OutputBO;
import com.dcits.depsit.facade.components.IRbLimitSceneDefBcc;
import com.dcits.depsit.facade.components.IRbLimitSumInfoBcc;
import com.dcits.depsit.facade.eo.RbLimitSceneDefEO;
import com.dcits.depsit.facade.eo.RbLimitSumInfoEO;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ST108 登记累计限额 步骤实现。
 *
 * <p>单一平铺子步骤：条件成立时按正式 Spec（docs/specs/ST108.md）REQ-002～REQ-006 登记 1 条
 * 【限额累计信息表（RB_LIMIT_SUM_INFO）】记录，并按 REQ-007 回填 5 个可确定输出字段。</p>
 *
 * <p>登记触发条件（REQ-002）：[限额检查结果]等于「未超限」，且（limitSumAmt 等于 0 或
 * limitSumCnt 等于 0）；条件不成立时登记动作整体不发生，仍按正常结果返回（REQ-008）。</p>
 *
 * <p>限额检查对象值（REQ-004）：以 limitSceneNo 查【限额场景定义表（RB_LIMIT_SCENE_DEF）】取检查
 * 对象类型，账户级别（ACCT）取 baseAcctNo、客户级别（CUST）取 clientNo。卡片级别（CARD）／卡组
 * （CDGROUP）的取值来源源需求未写明（Spec「验收范围与明确不覆盖的事项」第 3 项），本步骤不推断、
 * 不以账号或客户号兜底、不跳过查询。</p>
 *
 * <p>未定义的路径：失效日期（expireDate）的周期配置来源未写明（Spec 第 2 项），本步骤不赋值；
 * 正文「其他字段的取值按照系统规则自动生成」所指各列的系统规则未定义（Spec 第 5 项），本步骤不
 * 赋值、也不要求调用方上送；必填输入为空、limitSceneNo 查无场景配置的行为源需求未定义
 * （Spec 第 4 项），本步骤不生成默认值、校验、兜底或业务失败分支。</p>
 *
 * <p>本步骤不定义业务失败与错误码（REQ-008）：正常完成与条件不成立均返回 succeed=true；失败仅由
 * 技术异常按工程既有方式向上传播，不捕获、不转换为业务失败、不以默认值或空记录兜底。</p>
 */
@Service
public class ST108Pbc implements IST108 {

    /** 日志。 */
    private static final Logger LOGGER = LoggerFactory.getLogger(ST108Pbc.class);

    /** 登记触发条件：[限额检查结果]的规范判定字面量。 */
    private static final String CHECK_RESULT_NOT_EXCEEDED = "未超限";

    /** 登记的限额累计笔数规范常量，与任何输入取值无关（REQ-005）。 */
    private static final Integer REGISTER_LIMIT_SUM_CNT = Integer.valueOf(1);

    /** 【限额场景定义（RB_LIMIT_SCENE_DEF）】数据服务：只读查询检查对象类型。 */
    @Autowired
    private IRbLimitSceneDefBcc rbLimitSceneDefBcc;

    /** 【限额累计信息表（RB_LIMIT_SUM_INFO）】数据服务：登记写入。 */
    @Autowired
    private IRbLimitSumInfoBcc rbLimitSumInfoBcc;

    @Override
    @Transactional
    public ST108OutputBO execute(ST108InputBO input) {
        ST108OutputBO output = new ST108OutputBO();

        // 子步骤1：登记累计限额——若[限额检查结果]为「未超限」且（[限额累计金额]等于0 或[限额累计笔数]等于0），则登记限额信息
        if (isRegisterConditionSatisfied(input)) {
            // 按[限额场景编码]查【限额场景定义表】，取检查对象类型确定限额检查对象值（REQ-004）
            RbLimitSceneDefEO sceneDef = rbLimitSceneDefBcc.findByPrimaryKey(input.getLimitSceneNo());
            RbLimitSumInfoEO limitSumInfo = buildLimitSumInfo(input, sceneDef);
            // 登记落点：仅新增 1 条记录，不修改或删除既有记录（REQ-003）
            rbLimitSumInfoBcc.createSelective(limitSumInfo);
            LOGGER.info("ST108 登记累计限额：限额场景编码={}，已登记 1 条限额累计信息", input.getLimitSceneNo());
            // 输出的前 5 个字段与本次登记写入的对应列一致（REQ-007）
            writeBackOutput(output, limitSumInfo);
        } else {
            LOGGER.debug("ST108 登记累计限额：触发条件不成立，不登记限额累计信息");
        }

        // 无业务失败场景：正常完成与条件不成立均返回成功（REQ-008）
        output.setSucceed(true);
        return output;
    }

    /**
     * 判定登记触发条件：{@code 限额检查结果 == "未超限" && (limitSumAmt == 0 || limitSumCnt == 0)}。
     *
     * <p>或关系只作用于金额与笔数两项；8 个输入字段在「## 输入」表均标必填，其为空时的行为源需求
     * 未定义（Spec「验收范围与明确不覆盖的事项」第 4 项），此处不设默认值、校验或兜底分支。</p>
     */
    private boolean isRegisterConditionSatisfied(ST108InputBO input) {
        if (!CHECK_RESULT_NOT_EXCEEDED.equals(input.get限额检查结果())) {
            return false;
        }
        return isZero(input.getLimitSumAmt()) || isZero(input.getLimitSumCnt());
    }

    /** 判断金额是否等于 0（按数值比较，标度与尾随零不影响判定）。 */
    private boolean isZero(BigDecimal amount) {
        return BigDecimal.ZERO.compareTo(amount) == 0;
    }

    /** 判断笔数是否等于 0。 */
    private boolean isZero(Integer count) {
        return count.intValue() == 0;
    }

    /**
     * 构造本次登记记录：写入正文列举且可唯一确定的 5 项（REQ-003～REQ-006），取值与对应输入或规范
     * 常量逐位一致，不换算、不舍入、不截断、不改写。
     *
     * <p>其余列（含 clientNo、tranCcy、reference、preReference、limitSumContent、createTimestamp、
     * lastUpdTimestamp）由系统规则自动生成，该规则源需求未定义（Spec 第 5 项），本步骤不赋值；
     * 失效日期（expireDate）的推算口径未写明（Spec 第 2 项），本步骤不赋值。</p>
     */
    private RbLimitSumInfoEO buildLimitSumInfo(ST108InputBO input, RbLimitSceneDefEO sceneDef) {
        RbLimitSumInfoEO limitSumInfo = new RbLimitSumInfoEO();
        // $限额场景编码$ 等于[限额场景编码]
        limitSumInfo.setLimitSceneNo(input.getLimitSceneNo());
        // $限额检查对象值$ 根据[限额场景编码]配置的检查对象类型赋值为{账号}或者{客户号}
        limitSumInfo.setCheckObjVal(resolveCheckObjVal(input, sceneDef));
        // $限额累计金额$ 等于{交易金额}
        limitSumInfo.setLimitSumAmt(input.getTranAmt());
        // $限额累计笔数$ 等于1
        limitSumInfo.set否(REGISTER_LIMIT_SUM_CNT);
        // $生效日期$ 等于{系统日期}
        limitSumInfo.setEffectDate(input.getRunDate());
        return limitSumInfo;
    }

    /**
     * 按查询所得检查对象类型确定限额检查对象值：账户级别（ACCT）取账号、客户级别（CUST）取客户号。
     *
     * <p>卡片级别（CARD）／卡组（CDGROUP）的取值来源源需求未写明，本步骤不推断取值、不以账号或
     * 客户号之外的字段兜底，该分支不作可断言结果（Spec 第 3 项）。</p>
     */
    private String resolveCheckObjVal(ST108InputBO input, RbLimitSceneDefEO sceneDef) {
        CheckObjType checkObjType = sceneDef.getCheckObjType();
        if (CheckObjType.ACCT.equals(checkObjType)) {
            return input.getBaseAcctNo();
        }
        if (CheckObjType.CUST.equals(checkObjType)) {
            return input.getClientNo();
        }
        return null;
    }

    /** 输出前 5 个字段，取值与本次登记写入的对应列一致（REQ-007）；expireDate 不赋值、不作断言。 */
    private void writeBackOutput(ST108OutputBO output, RbLimitSumInfoEO limitSumInfo) {
        output.setLimitSceneNo(limitSumInfo.getLimitSceneNo());
        output.setCheckObjVal(limitSumInfo.getCheckObjVal());
        output.setLimitSumAmt(limitSumInfo.getLimitSumAmt());
        output.set否(limitSumInfo.get否());
        output.setEffectDate(limitSumInfo.getEffectDate());
    }
}
