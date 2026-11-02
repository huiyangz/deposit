package com.dcits.deposit.facade.bo;

/**
 * ST003 检查对手账户属性 输入 BO。
 *
 * <p>字段来自正式 Spec ST003 输入表：对手账号（othBaseAcctNo，必填，类型 java.lang.String）。</p>
 */
public class ST003InputBO {

    /** 对手账号（必填） */
    private String othBaseAcctNo;

    public String getOthBaseAcctNo() {
        return othBaseAcctNo;
    }

    public void setOthBaseAcctNo(String othBaseAcctNo) {
        this.othBaseAcctNo = othBaseAcctNo;
    }
}
