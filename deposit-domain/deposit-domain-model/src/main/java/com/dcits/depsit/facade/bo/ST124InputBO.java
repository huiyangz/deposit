package com.dcits.depsit.facade.bo;

/**
 * ST124 检查是否存在现金不收不付限制 - 输入。
 */
public class ST124InputBO {
    /** 账号 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
