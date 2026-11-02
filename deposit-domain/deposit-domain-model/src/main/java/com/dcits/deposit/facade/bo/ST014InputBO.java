package com.dcits.deposit.facade.bo;

/**
 * ST014 检查对手账户类型 输入 BO。
 */
public class ST014InputBO {
    /** 对手账号，必填，用于定位对手账户的账户信息 */
    private String othBaseAcctNo;

    public String getOthBaseAcctNo() {
        return othBaseAcctNo;
    }

    public void setOthBaseAcctNo(String othBaseAcctNo) {
        this.othBaseAcctNo = othBaseAcctNo;
    }
}
