package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.AcctStatus;

/**
 * ST007 检查对手账户是否存在 —— 输出 BO。
 *
 * <p>按 Spec「### 输出」表声明 3 个业务字段，均为「非必填」。源需求未说明这三个字段的
 * 取值来源与出现条件（Spec 不覆盖事项第 4 项），故本类只照录声明，不作取值约定，
 * 也不新增「检查结果」字段——检查结论由继承自 {@link StepResult} 的
 * {@code succeed}／{@code errorCode} 承载（Spec「### 承载口径」）。</p>
 */
public class ST007OutputBO extends StepResult {

    /** 账户内部键值 */
    private Integer internalKey;

    /** 账号 */
    private String baseAcctNo;

    /** 账户状态 */
    private AcctStatus acctStatus;

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public AcctStatus getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(AcctStatus acctStatus) {
        this.acctStatus = acctStatus;
    }
}
