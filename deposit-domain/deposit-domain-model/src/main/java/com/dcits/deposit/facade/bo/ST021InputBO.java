package com.dcits.deposit.facade.bo;

/**
 * ST021 检查支取账户类型 输入。
 *
 * <p>必填输入 baseAcctNo（账号），用于按账号查询【账户信息】（对公存款账户主表）
 * 取得存款账户类型。</p>
 */
public class ST021InputBO {

    /** 账号（必填），用于查询账户信息 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
