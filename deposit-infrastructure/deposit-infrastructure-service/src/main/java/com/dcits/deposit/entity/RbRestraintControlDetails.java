package com.dcits.deposit.entity;

public class RbRestraintControlDetails {
    /** 账户限制类型 */
    private String restraintType;
    /** 产品类型 */
    private String prodType;
    /** 渠道集合 */
    private String channelMuster;
    /** 多交易类型 */
    private String tranTypeLink;
    /** 摘要码 */
    private String narrativeCode;
    /** 是否批量 */
    private String batchFlag;
    /** 限制机构范围 */
    private String resBranchRange;
    /** 柜面标志 */
    private String counterFlag;
    /** 表达式 */
    private String expression;
    /** 状态 */
    private String status;
    /** 法人 */
    private String company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public String getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(String restraintType) {
        this.restraintType = restraintType;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getChannelMuster() {
        return channelMuster;
    }

    public void setChannelMuster(String channelMuster) {
        this.channelMuster = channelMuster;
    }

    public String getTranTypeLink() {
        return tranTypeLink;
    }

    public void setTranTypeLink(String tranTypeLink) {
        this.tranTypeLink = tranTypeLink;
    }

    public String getNarrativeCode() {
        return narrativeCode;
    }

    public void setNarrativeCode(String narrativeCode) {
        this.narrativeCode = narrativeCode;
    }

    public String getBatchFlag() {
        return batchFlag;
    }

    public void setBatchFlag(String batchFlag) {
        this.batchFlag = batchFlag;
    }

    public String getResBranchRange() {
        return resBranchRange;
    }

    public void setResBranchRange(String resBranchRange) {
        this.resBranchRange = resBranchRange;
    }

    public String getCounterFlag() {
        return counterFlag;
    }

    public void setCounterFlag(String counterFlag) {
        this.counterFlag = counterFlag;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}