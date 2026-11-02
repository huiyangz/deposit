package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.PwdType;

/**
 * ST031 验证密码 步骤输入。
 *
 * <p>字段定义来源：正式 Spec ST031「输入」表（baseAcctNo 账号、pwdType 密码类型）。</p>
 */
public class ST031InputBO {

    /** 账号（必填） */
    private String baseAcctNo;

    /** 密码类型（必填，取值属于枚举 {@link PwdType}） */
    private PwdType pwdType;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public PwdType getPwdType() {
        return pwdType;
    }

    public void setPwdType(PwdType pwdType) {
        this.pwdType = pwdType;
    }
}
