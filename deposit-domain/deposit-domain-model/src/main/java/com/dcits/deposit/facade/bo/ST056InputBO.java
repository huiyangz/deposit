package com.dcits.deposit.facade.bo;

/**
 * ST056 检查是否存在转账不收不付限制 输入。
 */
public class ST056InputBO {

    /** 账号（必填） */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
