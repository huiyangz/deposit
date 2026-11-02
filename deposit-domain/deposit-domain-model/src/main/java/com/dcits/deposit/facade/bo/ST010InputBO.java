package com.dcits.deposit.facade.bo;

/**
 * ST010 检查资金管控标识 步骤输入。
 *
 * <p>字段来自正式 Spec「输入」表：账号 {@code baseAcctNo}（必填），用于定位对公存款
 * 账户主表（RB_BUS_ACCT）账户信息。</p>
 */
public class ST010InputBO {

    /** 账号（必填），用于定位账户信息 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
