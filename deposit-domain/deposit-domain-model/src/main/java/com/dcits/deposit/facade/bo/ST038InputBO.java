package com.dcits.deposit.facade.bo;

/**
 * ST038 检查账户机构是否可匹配到限额场景配置 输入 BO。
 *
 * <p>按正式 Spec「输入」表登记，必填输入 baseAcctNo（账号，java.lang.String）。</p>
 */
public class ST038InputBO {

    /** 账号（必填） */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
