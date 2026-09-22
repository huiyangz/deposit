package com.dcits.deposit.entity;

public class FmFtaBranch {
    /** 自贸区代码 */
    private String ftaCode;
    /** 自贸区名称 */
    private String ftaDesc;
    /** 自贸区类型 */
    private String ftaType;
    /** 自贸区汇率类型 */
    private String ftaRateType;
    /** 自贸区属性 */
    private String ftaNature;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;

    public String getFtaCode() {
        return ftaCode;
    }

    public void setFtaCode(String ftaCode) {
        this.ftaCode = ftaCode;
    }

    public String getFtaDesc() {
        return ftaDesc;
    }

    public void setFtaDesc(String ftaDesc) {
        this.ftaDesc = ftaDesc;
    }

    public String getFtaType() {
        return ftaType;
    }

    public void setFtaType(String ftaType) {
        this.ftaType = ftaType;
    }

    public String getFtaRateType() {
        return ftaRateType;
    }

    public void setFtaRateType(String ftaRateType) {
        this.ftaRateType = ftaRateType;
    }

    public String getFtaNature() {
        return ftaNature;
    }

    public void setFtaNature(String ftaNature) {
        this.ftaNature = ftaNature;
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