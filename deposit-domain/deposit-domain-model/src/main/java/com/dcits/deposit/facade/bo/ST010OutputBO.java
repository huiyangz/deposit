package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST010 检查资金管控标识 步骤输出。
 *
 * <p>继承 {@link StepResult}，业务字段来自正式 Spec「输出」表：贷款资金管控标志
 * {@code loanFundFlag}（非必填，来源对公存款账户主表 RB_BUS_ACCT）。</p>
 *
 * <p>{@code gotoStepName} 为步骤执行机制字段（非业务输出）：按
 * {@link com.dcits.common.step.GotoStepCondition} 机制，运行时根据步骤返回结果的
 * {@code gotoStepName} 值决定是否跳转以及跳转到哪个候选步骤。本步骤检查为「Y-是」时
 * 携带跳转目标《检查账户客户一致性》。</p>
 */
public class ST010OutputBO extends StepResult {

    /** 贷款资金管控标志（非必填，来源对公存款账户主表 RB_BUS_ACCT） */
    private String loanFundFlag;

    /** 步骤执行机制字段（非业务输出）：运行时跳转目标步骤名称，不发生跳转时为 null */
    private String gotoStepName;

    public String getLoanFundFlag() {
        return loanFundFlag;
    }

    public void setLoanFundFlag(String loanFundFlag) {
        this.loanFundFlag = loanFundFlag;
    }

    public String getGotoStepName() {
        return gotoStepName;
    }

    public void setGotoStepName(String gotoStepName) {
        this.gotoStepName = gotoStepName;
    }
}
