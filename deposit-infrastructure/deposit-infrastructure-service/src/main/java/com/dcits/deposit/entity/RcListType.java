package com.dcits.deposit.entity;

public class RcListType {
    /** 名单类型代码 */
    private String listType;
    /** 名单类型描述 */
    private String listTypeDesc;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 名单种类 */
    private String listCategory;
    /** 黑名单检查规则编号 */
    private String ruleId;

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getListTypeDesc() {
        return listTypeDesc;
    }

    public void setListTypeDesc(String listTypeDesc) {
        this.listTypeDesc = listTypeDesc;
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

    public String getListCategory() {
        return listCategory;
    }

    public void setListCategory(String listCategory) {
        this.listCategory = listCategory;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }
}