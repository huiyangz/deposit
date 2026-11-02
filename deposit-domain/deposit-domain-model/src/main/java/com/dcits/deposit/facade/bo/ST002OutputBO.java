package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

import java.util.Date;

/**
 * ST002 检查账户到期日 输出 BO。
 *
 * <p>继承 {@link StepResult}，成功/失败状态与错误字段由基类提供。业务字段来自正式 Spec
 * ST002 输出表：账户到期日期（acctDueDate，非必填，来源实体：对公存款账户主表（RB_BUS_ACCT））。</p>
 */
public class ST002OutputBO extends StepResult {

    /** 账户到期日期（非必填，来源实体：对公存款账户主表（RB_BUS_ACCT）） */
    private Date acctDueDate;

    public Date getAcctDueDate() {
        return acctDueDate;
    }

    public void setAcctDueDate(Date acctDueDate) {
        this.acctDueDate = acctDueDate;
    }
}
