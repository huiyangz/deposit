package com.dcits.deposit.facade.bo;

/**
 * ST030 检查对手账户是否能够入账 输入 BO。
 *
 * <p>业务输入：对手账号（othBaseAcctNo，必填，需求输入表未指定来源实体，由调用方提供）。</p>
 */
public class ST030InputBO {

    /** 对手账号 */
    private String othBaseAcctNo;

    public String getOthBaseAcctNo() {
        return othBaseAcctNo;
    }

    public void setOthBaseAcctNo(String othBaseAcctNo) {
        this.othBaseAcctNo = othBaseAcctNo;
    }
}
