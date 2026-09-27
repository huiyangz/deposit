package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import java.util.Date;

/**
 * ST001 检查账户到期日 输出BO
 */
public class ST001OutputBO extends StepResult {

    /** 账户到期日期（来源实体：对公存款账户主表 RB_BUS_ACCT） */
    private Date acctDueDate;

    /** 账户到期日期（来源实体：对公存款账户主表 RB_BUS_ACCT） */
    public Date getAcctDueDate() {
        return acctDueDate;
    }

    /** 账户到期日期（来源实体：对公存款账户主表 RB_BUS_ACCT） */
    public void setAcctDueDate(Date acctDueDate) {
        this.acctDueDate = acctDueDate;
    }
}
