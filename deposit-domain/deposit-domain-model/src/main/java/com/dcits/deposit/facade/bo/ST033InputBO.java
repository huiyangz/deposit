package com.dcits.deposit.facade.bo;

/**
 * ST033 检查账户余额类型一致性 输入 BO。
 */
public class ST033InputBO {
    /** 账号（转出账户） */
    private String baseAcctNo;
    /** 对手账号（转入账户） */
    private String othBaseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getOthBaseAcctNo() {
        return othBaseAcctNo;
    }

    public void setOthBaseAcctNo(String othBaseAcctNo) {
        this.othBaseAcctNo = othBaseAcctNo;
    }
}
