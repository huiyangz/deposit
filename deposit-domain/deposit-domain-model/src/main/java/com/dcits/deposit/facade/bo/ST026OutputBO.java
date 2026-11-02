package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.AllDepInd;

/**
 * ST026 检查对手账户通存标志 输出。
 *
 * <p>继承 {@link com.dcits.common.step.StepResult}，正常完成时 succeed=true 且错误字段为空；
 * 业务失败时 succeed=false、errorCode=ER0055、errorMessage=「ER0055::当前交易机构不是账户的通存机构」。</p>
 *
 * <p>业务字段通存标识 {@code allDepInd}（非必填，来源对公存款账户主表 RB_BUS_ACCT）。
 * 「Y-是」检查条件与 {@link AllDepInd} 枚举取值的映射待确认（Spec 待确认事项 TBD-2，
 * 见 {@code ST026Pbc} 中 FIXME）。</p>
 */
public class ST026OutputBO extends StepResult {

    /** 通存标识（非必填，来源对公存款账户主表 RB_BUS_ACCT） */
    private AllDepInd allDepInd;

    public AllDepInd getAllDepInd() {
        return allDepInd;
    }

    public void setAllDepInd(AllDepInd allDepInd) {
        this.allDepInd = allDepInd;
    }
}
