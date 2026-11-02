package com.dcits.deposit.facade.bo;

/**
 * ST054 检查是否存在现金止收限制 步骤输入。
 *
 * <p>字段来自正式 Spec ST054「输入」表（REQ-001）。</p>
 */
public class ST054InputBO {

    /** 账号（必填，业务含义"账号"，由调用方提供） */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
