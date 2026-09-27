package com.dcits.deposit.facade.bo;

import java.util.Date;

import com.dcits.common.step.StepResult;

/**
 * ST044 设置账户开户日期 输出BO
 */
public class ST044OutputBO extends StepResult {

    /** 账户开户日期，非必填，来源对公存款账户主表（RB_BUS_ACCT） */
    private Date acctOpenDate;

    public Date getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(Date acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }
}
