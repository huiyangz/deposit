package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TermType;
import jakarta.validation.constraints.NotNull;

public class RbClientRestraintsEO {
    /** 限制编号 */
    @NotNull
    private String resSeqNo;
    /** 账户限制类型 */
    private RestraintType restraintType;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 交易机构号 */
    private AcctBranch tranBranch;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 开始日期 */
    private java.util.Date startDate;
    /** 存期期限 */
    private String term;
    /** 周期类型 */
    private TermType termType;
    /** 结束日期 */
    private java.util.Date endDate;
    /** 限制状态 */
    private RestraintsStatus restraintsStatus;
    /** 摘要 */
    private String narrative;
    /** 交易柜员号 */
    private String userId;
    /** 授权柜员号 */
    private String authUserId;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 冻结级别 */
    private String resPriority;

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
    }

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
        this.restraintType = restraintType;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public AcctBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(AcctBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
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

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    public RestraintsStatus getRestraintsStatus() {
        return restraintsStatus;
    }

    public void setRestraintsStatus(RestraintsStatus restraintsStatus) {
        this.restraintsStatus = restraintsStatus;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getLastChangeUserId() {
        return lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getResPriority() {
        return resPriority;
    }

    public void setResPriority(String resPriority) {
        this.resPriority = resPriority;
    }
}