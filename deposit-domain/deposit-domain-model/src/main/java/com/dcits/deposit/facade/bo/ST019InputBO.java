package com.dcits.deposit.facade.bo;

/**
 * ST019 检查账户支取方式 输入 BO。
 *
 * <p>必填输入：账号 {@code baseAcctNo}，来源为调用方/交易流程提供。</p>
 */
public class ST019InputBO {
    /** 账号（必填） */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
