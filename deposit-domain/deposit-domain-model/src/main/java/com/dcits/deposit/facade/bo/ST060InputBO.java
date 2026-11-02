package com.dcits.deposit.facade.bo;

/**
 * ST060 检查是否存在现金不收不付限制 步骤输入。
 */
public class ST060InputBO {

    /** 账号（必填），由调用方（交易输入）提供，作为查询对公存款账户限制表的账号条件 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
