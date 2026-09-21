package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.LimitBranchRange;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.Status;
import jakarta.validation.constraints.NotNull;

public class RbRestraintControlDetailsEO {
    /** 账户限制类型 */
    @NotNull
    private RestraintType restraintType;
    /** 产品类型 */
    @NotNull
    private String prodType;
    /** 渠道集合 */
    private String channelMuster;
    /** 多交易类型 */
    @NotNull
    private String tranTypeLink;
    /** 摘要码 */
    private String narrativeCode;
    /** 是否批量 */
    @NotNull
    private String batchFlag;
    /** 限制机构范围 */
    @NotNull
    private LimitBranchRange resBranchRange;
    /** 柜面标志 */
    @NotNull
    private IndividualFlag counterFlag;
    /** 表达式 */
    private String expression;
    /** 状态 */
    private Status status;
    /** 法人 */
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
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

    public LimitBranchRange getResBranchRange() {
        return resBranchRange;
    }

    public void setResBranchRange(LimitBranchRange resBranchRange) {
        this.resBranchRange = resBranchRange;
    }

    public IndividualFlag getCounterFlag() {
        return counterFlag;
    }

    public void setCounterFlag(IndividualFlag counterFlag) {
        this.counterFlag = counterFlag;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}