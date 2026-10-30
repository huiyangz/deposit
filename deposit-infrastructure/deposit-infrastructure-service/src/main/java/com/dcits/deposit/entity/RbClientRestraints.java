package com.dcits.deposit.entity;

import java.util.Date;

public class RbClientRestraints {
    /** 创建时间戳 */
    private String createTimestamp;
    /** 摘要 */
    private String narrative;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 开始日期 */
    private Date startDate;
    /** 交易机构号 */
    private String tranBranch;
    /** 冻结级别 */
    private String resPriority;
    /** 限制状态 */
    private String restraintsStatus;
    /** 结束日期 */
    private Date endDate;
    /** 限制编号 */
    private String resSeqNo;
    /** 交易柜员号 */
    private String userId;
    /** 渠道类型 */
    private String sourceType;
    /** 授权柜员号 */
    private String authUserId;
    /** 账户限制类型 */
    private String restraintType;
    /** 存期期限 */
    private String term;
    /** 周期类型 */
    private String termType;
    /** 客户号 */
    private String clientNo;
    /** 交易日期 */
    private Date tranDate;

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(String tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getResPriority() {
        return resPriority;
    }

    public void setResPriority(String resPriority) {
        this.resPriority = resPriority;
    }

    public String getRestraintsStatus() {
        return restraintsStatus;
    }

    public void setRestraintsStatus(String restraintsStatus) {
        this.restraintsStatus = restraintsStatus;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    public String getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(String restraintType) {
        this.restraintType = restraintType;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }
}