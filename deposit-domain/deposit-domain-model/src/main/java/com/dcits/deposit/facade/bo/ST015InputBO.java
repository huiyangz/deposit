package com.dcits.deposit.facade.bo;

/**
 * ST015 检查靠档标识 步骤输入。
 *
 * <p>依据必填输入 baseAcctNo（账号）查询【法透协议信息】（对公透支签约表
 * RB_BUS_AGREEMENT_OVERDRAFT）取得靠档跨月季标识，并据此确定后续流转。</p>
 */
public class ST015InputBO {

    /** 账号（必填），作为查询对公透支签约记录取得靠档跨月季标识的依据 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
