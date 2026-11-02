package com.dcits.deposit.facade.bo;

/**
 * ST055 检查是否存在止付限制 输入。
 */
public class ST055InputBO {

    /** 账号（必填） */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
