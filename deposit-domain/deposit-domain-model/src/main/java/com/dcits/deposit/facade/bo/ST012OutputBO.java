package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

import com.dcits.common.step.StepResult;

/**
 * ST012 更新存入后账户余额 输出BO
 */
public class ST012OutputBO extends StepResult {
    /**汇总金额（对公存款账户余额表 RB_BUS_ACCT_BALANCE）*/
    private BigDecimal totalAmount;
    /**账户可用余额（对公存款账户余额表 RB_BUS_ACCT_BALANCE）*/
    private BigDecimal acctAvailBal;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getAcctAvailBal() {
        return acctAvailBal;
    }

    public void setAcctAvailBal(BigDecimal acctAvailBal) {
        this.acctAvailBal = acctAvailBal;
    }
}
