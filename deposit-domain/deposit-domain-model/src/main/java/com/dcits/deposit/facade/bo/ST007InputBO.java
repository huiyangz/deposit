package com.dcits.deposit.facade.bo;

/** ST007 检查对手账户是否存在 输入 */
public class ST007InputBO {

    /** 对手账号 */
    private String othBaseAcctNo;

    public String getOthBaseAcctNo() {
        return othBaseAcctNo;
    }

    public void setOthBaseAcctNo(String othBaseAcctNo) {
        this.othBaseAcctNo = othBaseAcctNo;
    }
}
