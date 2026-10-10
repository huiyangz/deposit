package com.dcits.depsit.step;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.depsit.facade.bo.ST104InputBO;
import com.dcits.depsit.facade.bo.ST104OutputBO;
import com.dcits.depsit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.depsit.facade.eo.RbLimitCtrlConfEO;

/**
 * ST104 检查限额 步骤实现。
 *
 * <p>整体意图：按 [限额场景编码] 查询【限额控制配置(RB_LIMIT_CTRL_CONF)】取得 [限额控制金额] 与
 * [限额控制笔数]，将 [限额累计金额]、[限额累计笔数] 分别与两个控制值作严格「大于」比较，
 * 任一维度超出返回「超限」，否则返回「未超限」，并按控制值的可空性裁剪比较维度。</p>
 *
 * <ul>
 *   <li>子步骤1（实体查询类）：以仅置 {@code limitSceneNo} 的 {@link RbLimitCtrlConfEO} 调用
 *       {@code findByEo} 查询配置记录，取得命中记录上的 {@code limitCtrlAmt} 与 {@code limitCtrlNum}。</li>
 *   <li>子步骤2（逻辑判断类）：[限额控制金额] 有值时比较金额维度、[限额控制笔数] 有值时比较笔数维度，
 *       两维度为「或」关系且为严格大于；两个控制值都无值时不做任何比较，结论为「未超限」。</li>
 * </ul>
 *
 * <p>本步骤为纯读取动作，无写库，故不加事务。本步骤无业务失败场景，正常结束一律
 * {@code succeed = true} 且不置错误码；技术异常按技术异常向上传播，不转换为「超限」／「未超限」。</p>
 */
@Service
public class ST104Pbc implements IST104 {

    /** 限额检查结果——超限（源需求书写的字面值，全工程无该结果的枚举或码值定义） */
    private static final String CHECK_RESULT_EXCEEDED = "超限";

    /** 限额检查结果——未超限（源需求书写的字面值） */
    private static final String CHECK_RESULT_NOT_EXCEEDED = "未超限";

    private final IRbLimitCtrlConfBcc rbLimitCtrlConfBcc;

    public ST104Pbc(IRbLimitCtrlConfBcc rbLimitCtrlConfBcc) {
        this.rbLimitCtrlConfBcc = rbLimitCtrlConfBcc;
    }

    @Override
    public ST104OutputBO execute(ST104InputBO input) {
        ST104OutputBO output = new ST104OutputBO();

        // 子步骤1：按 [限额场景编码] 查询【限额控制配置】，查询条件仅含限额场景编码，
        // 不要求也不携带「限额机构编码」等额外条件。
        RbLimitCtrlConfEO queryEo = new RbLimitCtrlConfEO();
        queryEo.setLimitSceneNo(input.getLimitSceneNo());
        List<RbLimitCtrlConfEO> confList = rbLimitCtrlConfBcc.findByEo(queryEo);

        // 取命中配置行的 [限额控制金额]、[限额控制笔数]。该表主键为「限额机构编码＋限额场景编码」，
        // 本步骤输入只含限额场景编码，多条记录的取舍口径与查无记录的返回结果均属源需求已放行的
        // 事项（Spec「验收范围与明确不覆盖的事项」第 1 项）：实现在此只按查询结果取用首个配置行的
        // 两个控制值，不据此另立取舍规则；查无记录时两个控制值取不到值（保持 null），
        // 由子步骤2 的空值裁剪口径归入「不比较、未超限」，不新增失败分支、不置错误码。
        BigDecimal limitCtrlAmt = null;
        Integer limitCtrlNum = null;
        if (confList != null && !confList.isEmpty()) {
            RbLimitCtrlConfEO conf = confList.get(0);
            limitCtrlAmt = conf.getLimitCtrlAmt();
            limitCtrlNum = conf.getLimitCtrlNum();
        }
        output.setLimitCtrlAmt(limitCtrlAmt);
        output.setLimitCtrlNum(limitCtrlNum);

        // REQ-005：累计金额与累计笔数回显本次输入，不查询也不写入【限额累计信息表】。
        output.setLimitSumAmt(input.getLimitSumAmt());
        output.set否(input.getLimitSumNum());

        // 子步骤2：检查限额。[限额控制金额] 为空时不比较金额维度、[限额控制笔数] 为空时不比较笔数维度
        // （以控制值非空为前置条件，被裁剪的维度不参与比较、不视为超限、不抛出异常）；
        // 两维度为并列「或」关系，任一维度严格「大于」其控制值即返回「超限」；两个控制值都为空时
        // 两个条件均被裁剪、直接落到「未超限」。
        // 累计值取到空值（必填输入未按契约提供）时的行为源需求未定义（Spec 不覆盖事项第 3 项），
        // 此处不为其臆造默认值或比较结论：控制值有值时按输入原值参与比较，由上层按技术异常处理。
        boolean amountExceeded = limitCtrlAmt != null
                && input.getLimitSumAmt().compareTo(limitCtrlAmt) > 0;
        boolean numExceeded = limitCtrlNum != null
                && input.getLimitSumNum().compareTo(limitCtrlNum) > 0;

        if (amountExceeded || numExceeded) {
            output.setLimitCheckResult(CHECK_RESULT_EXCEEDED);
        } else {
            output.setLimitCheckResult(CHECK_RESULT_NOT_EXCEEDED);
        }

        // 本步骤无业务失败场景：结论为「超限」不构成业务失败，正常结束一律置 succeed=true 且不置错误码。
        output.setSucceed(true);
        return output;
    }
}
