package com.dcits.deposit.facade.bo;

/**
 * ST058 检查是否存在不收不付限制 输入 BO。
 *
 * <p>输入字段 baseAcctNo（账号）为必填，来源为调用方交易流程传入。</p>
 */
public class ST058InputBO {

    /** 账号（必填） */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
