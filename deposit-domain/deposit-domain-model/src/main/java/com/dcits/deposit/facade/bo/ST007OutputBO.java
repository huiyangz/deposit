package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.AcctStatus;

/** ST007 检查对手账户是否存在 输出 */
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
