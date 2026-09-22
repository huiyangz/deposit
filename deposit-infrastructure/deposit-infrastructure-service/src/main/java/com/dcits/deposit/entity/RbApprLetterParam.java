package com.dcits.deposit.entity;

public class RbApprLetterParam {
    /** 参数名称 */
    private String paraKey;
    /** 参数描述 */
    private String paraDesc;
    /** 参数值 */
    private String paraValue;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;

    public String getParaKey() {
        return paraKey;
    }

    public void setParaKey(String paraKey) {
        this.paraKey = paraKey;
    }

    public String getParaDesc() {
        return paraDesc;
    }

    public void setParaDesc(String paraDesc) {
        this.paraDesc = paraDesc;
    }

    public String getParaValue() {
        return paraValue;
    }

    public void setParaValue(String paraValue) {
        this.paraValue = paraValue;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}