package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.AcctNatureNo;

/**
 * ST048 检查存入账户账户属性 步骤输出。
 *
 * <p>业务字段来自 Spec「### 输出」表：{@code acctNatureNo}（账户属性，{@link AcctNatureNo}，非必填，
 * 来源实体「对公存款账户主表（RB_BUS_ACCT）」）。检查结果与跳转结论由继承的
 * {@link StepResult} 承载，不另设输出字段。</p>
 */
public class ST048OutputBO extends StepResult {

    /** 账户属性 */
    private AcctNatureNo acctNatureNo;

    public AcctNatureNo getAcctNatureNo() {
        return acctNatureNo;
    }

    public void setAcctNatureNo(AcctNatureNo acctNatureNo) {
        this.acctNatureNo = acctNatureNo;
    }
}
