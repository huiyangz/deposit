package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.PwdType;

/**
 * ST011 检查支取密码状态 输入 BO。
 *
 * <p>字段来自正式 Spec「输入」表：baseAcctNo（账号，必填）、pwdType（密码类型，必填，
 * 本步骤查询的密码类型为「支取密码」）。</p>
 */
public class ST011InputBO {
    /** 账号 */
    private String baseAcctNo;
    /** 密码类型；本步骤查询的密码类型为「支取密码」 */
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
