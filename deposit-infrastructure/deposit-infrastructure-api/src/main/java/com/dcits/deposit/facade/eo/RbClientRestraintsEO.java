package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.TranBranch;
import jakarta.validation.constraints.NotNull;

public class RbClientRestraintsEO {
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 摘要 */
    private String narrative;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 开始日期 */
    private java.util.Date startDate;
    /** 交易机构号 */
    private TranBranch tranBranch;
    /** 冻结级别 */
    private String resPriority;
    /** 限制状态 */
    private RestraintsStatus restraintsStatus;
    /** 结束日期 */
    private java.util.Date endDate;
    /** 限制编号 */
    @NotNull
    private String resSeqNo;
    /** 交易柜员号 */
    private String userId;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 授权柜员号 */
    private String authUserId;
    /** 账户限制类型 */
    @NotNull
    private RestraintType restraintType;
    /** 存期期限 */
    private String term;
    /** 周期类型 */
    private TermType termType;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 交易日期 */
    private java.util.Date tranDate;

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

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public TranBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(TranBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getResPriority() {
        return resPriority;
    }

    public void setResPriority(String resPriority) {
        this.resPriority = resPriority;
    }

    public RestraintsStatus getRestraintsStatus() {
        return restraintsStatus;
    }

    public void setRestraintsStatus(RestraintsStatus restraintsStatus) {
        this.restraintsStatus = restraintsStatus;
    }

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
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

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
        this.restraintType = restraintType;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public TermType getTermType() {
        return termType;
    }

    public void setTermType(TermType termType) {
        this.termType = termType;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }
}