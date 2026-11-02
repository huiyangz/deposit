package com.dcits.deposit.facade.bo;

/**
 * ST028 检查支取账户属性 输入 BO。
 *
 * <p>字段来自正式 Spec ST028 输入表：账号（baseAcctNo，必填）。</p>
 */
public class ST028InputBO {

    /** 账号（必填） */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
