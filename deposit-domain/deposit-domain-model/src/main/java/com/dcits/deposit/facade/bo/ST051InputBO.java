package com.dcits.deposit.facade.bo;

/**
 * ST051 检查账户是否存在限制 - 步骤输入。
 */
public class ST051InputBO {
    /** 账号（必填） */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
