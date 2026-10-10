package com.dcits.depsit.facade.bo;

/**
 * ST116 检查是否存在转账止付限制 输入BO。
 *
 * <p>入参按 Spec「### 输入」表行序：仅 1 个入参 {@code baseAcctNo}（账号，必填）。</p>
 */
public class ST116InputBO {

    /** 账号（必填） */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
