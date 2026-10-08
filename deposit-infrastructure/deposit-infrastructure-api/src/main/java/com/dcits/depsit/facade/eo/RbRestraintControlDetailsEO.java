package com.dcits.depsit.facade.eo;

import com.dcits.depsit.enums.ResBranchRange;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;
import jakarta.validation.constraints.NotNull;

public class RbRestraintControlDetailsEO {
    /** 渠道集合 */
    @NotNull
    private String channelMuster;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 产品编号 */
    @NotNull
    private String prodNo;
    /** 摘要码 */
    @NotNull
    private String narrativeCode;
    /** 表达式 */
    @NotNull
    private String expression;
    /** 状态 */
    @NotNull
    private Status status;
    /** 限制机构范围 */
    @NotNull
    private ResBranchRange resBranchRange;
    /** 多交易类型 */
    @NotNull
    private String tranTypeLink;
    /** 账户限制类型 */
    @NotNull
    private RestraintType restraintType;
    /** 是否批量 */
    @NotNull
    private String batchFlag;
    /** 柜面标志 */
    @NotNull
    private String counterFlag;
    /** 最后修改时间戳 */
    @NotNull
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ResBranchRange getResBranchRange() {
        return resBranchRange;
    }

    public void setResBranchRange(ResBranchRange resBranchRange) {
        this.resBranchRange = resBranchRange;
    }

    public String getTranTypeLink() {
        return tranTypeLink;
    }

    public void setTranTypeLink(String tranTypeLink) {
        this.tranTypeLink = tranTypeLink;
    }

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
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