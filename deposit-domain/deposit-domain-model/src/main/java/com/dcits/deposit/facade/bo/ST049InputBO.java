package com.dcits.deposit.facade.bo;

/**
 * ST049 检查转账止收限制 输入。
 *
 * <p>输入契约见正式 Spec ST049「输入」表。</p>
 */
public class ST049InputBO {

    /** 账号（必填） */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
