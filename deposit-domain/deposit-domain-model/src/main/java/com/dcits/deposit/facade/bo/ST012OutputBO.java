package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

import com.dcits.common.step.StepResult;

/**
 * ST012 检查账户余额 步骤输出。
 *
 * <p>业务字段来自正式 Spec ST012「输出」表，来源实体为对公存款账户余额表
 * （RB_BUS_ACCT_BALANCE），均非必填；gotoStepName 为流程路由载体，由步骤按
 * 可用余额与交易金额的比较结果赋值，取值见 {@code @GotoStepCondition} 声明。</p>
 */
public class ST012OutputBO extends StepResult {

    /** 汇总金额 */
    private BigDecimal totalAmount;

    /** 冻结金额 */
    private BigDecimal pldAmount;

    /** 系统内理财余额 */
    private BigDecimal finregAmount;

    /** 透支金额 */
    private BigDecimal odAmount;

    /** 账户可用余额 */
    private BigDecimal acctAvailBal;

    /** 跳转目标步骤业务名称 */
    private String gotoStepName;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPldAmount() {
        return pldAmount;
    }

    public void setPldAmount(BigDecimal pldAmount) {
        this.pldAmount = pldAmount;
    }

    public BigDecimal getFinregAmount() {
        return finregAmount;
    }

    public void setFinregAmount(BigDecimal finregAmount) {
        this.finregAmount = finregAmount;
    }

    public BigDecimal getOdAmount() {
        return odAmount;
    }

    public void setOdAmount(BigDecimal odAmount) {
        this.odAmount = odAmount;
    }

    public BigDecimal getAcctAvailBal() {
        return acctAvailBal;
    }

    public void setAcctAvailBal(BigDecimal acctAvailBal) {
        this.acctAvailBal = acctAvailBal;
    }

    public String getGotoStepName() {
        return gotoStepName;
    }

    public void setGotoStepName(String gotoStepName) {
        this.gotoStepName = gotoStepName;
    }
}
