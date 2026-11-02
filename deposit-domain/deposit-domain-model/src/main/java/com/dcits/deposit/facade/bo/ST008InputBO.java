package com.dcits.deposit.facade.bo;

/**
 * ST008 检查支取账户凭证状态 输入 BO。
 */
public class ST008InputBO {
    /** 账号（必填） */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
