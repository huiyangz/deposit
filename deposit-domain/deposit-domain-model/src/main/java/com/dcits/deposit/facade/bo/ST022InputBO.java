package com.dcits.deposit.facade.bo;

/**
 * ST022 检查对手账户限额 输入。
 *
 * <p>输入字段按正式 Spec（ST022）输入表声明：othBaseAcctNo（对手账号）、因子名称、othClientNo（对手客户号）、
 * tranDate（交易日期）、tranTimestamp（交易时间戳），均标记必填。对手账号、对手客户号分别作为组件内步骤
 * 调用中 {对手账号}、{对手客户号} 参数的数据来源（REQ-001）。</p>
 */
public class ST022InputBO {

    /** 对手账号（必填） */
    private String othBaseAcctNo;

    /** 因子名称（必填） */
    private String 因子名称;

    /** 对手客户号（必填） */
    private String othClientNo;

    /** 交易日期（必填） */
    private java.util.Date tranDate;

    /** 交易时间戳（必填） */
    private String tranTimestamp;

    public String getOthBaseAcctNo() {
        return othBaseAcctNo;
    }

    public void setOthBaseAcctNo(String othBaseAcctNo) {
        this.othBaseAcctNo = othBaseAcctNo;
    }

    public String get因子名称() {
        return 因子名称;
    }

    public void set因子名称(String 因子名称) {
        this.因子名称 = 因子名称;
    }

    public String getOthClientNo() {
        return othClientNo;
    }

    public void setOthClientNo(String othClientNo) {
        this.othClientNo = othClientNo;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}
