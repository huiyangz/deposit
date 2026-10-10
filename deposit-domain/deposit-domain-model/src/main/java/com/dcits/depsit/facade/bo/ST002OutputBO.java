package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import java.util.Date;

/**
 * ST002 检查账户到期日 输出 BO。
 *
 * <p>继承步骤执行结果 {@link StepResult}：检查结果「通过」由 {@code succeed = true} 且错误字段为空承载，
 * 返回错误码由 {@code succeed = false} 且 {@code errorCode} 承载。业务输出只有
 * {@code acctDueDate}（账户到期日期，标记「非必填」，允许为空）。
 */
public class ST002OutputBO extends StepResult {

    /** 账户到期日期：子步骤 1 从【账户信息】记录取得的值，可为空 */
    private Date acctDueDate;

    public Date getAcctDueDate() {
        return acctDueDate;
    }

    public void setAcctDueDate(Date acctDueDate) {
        this.acctDueDate = acctDueDate;
    }
}
