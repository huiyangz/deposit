package com.dcits.depsit.facade.bo;

/**
 * ST120 检查是否存在转账不收不付限制 - 输入。
 */
public class ST120InputBO {
    /** 账号 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
