package com.dcits.depsit.entity;

public class RbRestraintControlDetails {
    /** 渠道集合 */
    private String channelMuster;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 产品编号 */
    private String prodNo;
    /** 摘要码 */
    private String narrativeCode;
    /** 表达式 */
    private String expression;
    /** 状态 */
    private String status;
    /** 限制机构范围 */
    private String resBranchRange;
    /** 多交易类型 */
    private String tranTypeLink;
    /** 账户限制类型 */
    private String restraintType;
    /** 是否批量 */
    private String batchFlag;
    /** 柜面标志 */
    private String counterFlag;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;

    public String getChannelMuster() {
        return channelMuster;
    }

    public void setChannelMuster(String channelMuster) {
        this.channelMuster = channelMuster;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getNarrativeCode() {
        return narrativeCode;
    }

    public void setNarrativeCode(String narrativeCode) {
        this.narrativeCode = narrativeCode;
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

    public String getResBranchRange() {
        return resBranchRange;
    }

    public void setResBranchRange(String resBranchRange) {
        this.resBranchRange = resBranchRange;
    }

    public String getTranTypeLink() {
        return tranTypeLink;
    }

    public void setTranTypeLink(String tranTypeLink) {
        this.tranTypeLink = tranTypeLink;
    }

    public String getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(String restraintType) {
        this.restraintType = restraintType;
    }

    public String getBatchFlag() {
        return batchFlag;
    }

    public void setBatchFlag(String batchFlag) {
        this.batchFlag = batchFlag;
    }

    public String getCounterFlag() {
        return counterFlag;
    }

    public void setCounterFlag(String counterFlag) {
        this.counterFlag = counterFlag;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }
}