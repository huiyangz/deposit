package com.dcits.deposit.entity;

public class ClAcctNatureDef {
    /** 账户属性 */
    private String acctNature;
    /** 账户属性描述 */
    private String acctNatureDesc;
    /** 账户属性分类 */
    private String natureClass;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 结构属性描述 */
    private String description;

    public String getAcctNature() {
        return acctNature;
    }

    public void setAcctNature(String acctNature) {
        this.acctNature = acctNature;
    }

    public String getAcctNatureDesc() {
        return acctNatureDesc;
    }

    public void setAcctNatureDesc(String acctNatureDesc) {
        this.acctNatureDesc = acctNatureDesc;
    }

    public String getNatureClass() {
        return natureClass;
    }

    public void setNatureClass(String natureClass) {
        this.natureClass = natureClass;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}