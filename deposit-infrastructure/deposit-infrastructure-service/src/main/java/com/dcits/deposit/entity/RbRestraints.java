package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbRestraints {
    /** 限制编号 */
    private String resSeqNo;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 账户内部键类型 */
    private String acctInternalKeyType;
    /** 客户号 */
    private String clientNo;
    /** 账户限制类型 */
    private String restraintType;
    /** 渠道日期 */
    private Date channelDate;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 开始日期 */
    private Date startDate;
    /** 结束日期 */
    private Date endDate;
    /** 限制结束时间 */
    private String restraintEndTime;
    /** 存期期限 */
    private String term;
    /** 周期类型 */
    private String termType;
    /** 限制金额 */
    private BigDecimal pledgedAmt;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 轮候冻结序号 */
    private String waitSeq;
    /** 交易参考号 */
    private String reference;
    /** 交易机构号 */
    private String tranBranch;
    /** 交易日期 */
    private Date tranDate;
    /** 清算日期 */
    private Date settlementDate;
    /** 执法人1证件类型 */
    private String judiciaryDocumentType;
    /** 执法人证件类型2 */
    private String judiciaryDocumentType2;
    /** 执法人2证件类型 */
    private String judiciaryOthDocumentType;
    /** 执法人2证件类型2 */
    private String judiciaryOthDocumentType2;
    /** 有权机关名称 */
    private String deductionJudiciaryName;
    /** 扣划法律文书号 */
    private String deductionLawNo;
    /** 限制来源 */
    private String restraintSource;
    /** 执法人1证件号码 */
    private String judiciaryDocumentId;
    /** 执法人证件号码2 */
    private String judiciaryDocumentId2;
    /** 执法人2证件号码 */
    private String judiciaryOthDocumentId;
    /** 执法人2证件号码2 */
    private String judiciaryOthDocumentId2;
    /** 解冻机关名称 */
    private String releaseJudiciaryName;
    /** 解冻机关法律文书号 */
    private String releaseLawNo;
    /** 冻结机关名称 */
    private String restraintJudiciaryName;
    /** 冻结机关法律文书号 */
    private String resLawNo;
    /** 限制账户层级 */
    private String resAcctRange;
    /** 冻结级别 */
    private String resPriority;
    /** 限制状态 */
    private String restraintsStatus;
    /** 源模块 */
    private String sourceModule;
    /** 限制级别 */
    private String restraintLevel;
    /** 抵质押标志 */
    private String underLien;
    /** 冲正标志 */
    private String reserveFlag;
    /** 是否司法预冻结标志 */
    private String preFrozenFlag;
    /** 有权机关冻结标志 */
    private String ahBuFlag;
    /** 继续冻结标志 */
    private String continueFreezeFlag;
    /** 执法人1名称 */
    private String judiciaryOfficerName;
    /** 执法人2名称 */
    private String judiciaryOthOfficerName;
    /** 解冻执法人1证件号码 */
    private String thawDocumentId;
    /** 解冻执法人1证件号码2 */
    private String thawDocumentId2;
    /** 解冻执法人1姓名 */
    private String thawOfficerName;
    /** 其他解冻执法人证件号码 */
    private String thawOthDocumentId;
    /** 其他解冻执法人证件号码2 */
    private String thawOthDocumentId2;
    /** 其他解冻执法人证件类型 */
    private String thawOthDocumentType;
    /** 其他解冻执法人证件类型2 */
    private String thawOthDocumentType2;
    /** 其他解冻执法人姓名 */
    private String thawOthOfficerName;
    /** 解冻执法人1证件类型2 */
    private String thawDocumentType2;
    /** 解冻执法人1证件类型1 */
    private String thawDocumentType;
    /** 业务申请编号 */
    private String businessApplicationId;
    /** 原始业务申请编号 */
    private String originalApplicationId;
    /** 扣划法律文书类型名称 */
    private String deductionLawType;
    /** 备注 */
    private String remark;
    /** 摘要 */
    private String narrative;
    /** 法人 */
    private String company;
    /** 交易柜员号 */
    private String userId;
    /** 授权柜员号 */
    private String authUserId;
    /** 交易代码 */
    private String programId;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 交易时间戳 */
    private String tranTimestamp;

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getAcctInternalKeyType() {
        return acctInternalKeyType;
    }

    public void setAcctInternalKeyType(String acctInternalKeyType) {
        this.acctInternalKeyType = acctInternalKeyType;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(String restraintType) {
        this.restraintType = restraintType;
    }

    public Date getChannelDate() {
        return channelDate;
    }

    public void setChannelDate(Date channelDate) {
        this.channelDate = channelDate;
    }

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRestraintEndTime() {
        return restraintEndTime;
    }

    public void setRestraintEndTime(String restraintEndTime) {
        this.restraintEndTime = restraintEndTime;
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

    public BigDecimal getPledgedAmt() {
        return pledgedAmt;
    }

    public void setPledgedAmt(BigDecimal pledgedAmt) {
        this.pledgedAmt = pledgedAmt;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public String getWaitSeq() {
        return waitSeq;
    }

    public void setWaitSeq(String waitSeq) {
        this.waitSeq = waitSeq;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(String tranBranch) {
        this.tranBranch = tranBranch;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public String getJudiciaryDocumentType() {
        return judiciaryDocumentType;
    }

    public void setJudiciaryDocumentType(String judiciaryDocumentType) {
        this.judiciaryDocumentType = judiciaryDocumentType;
    }

    public String getJudiciaryDocumentType2() {
        return judiciaryDocumentType2;
    }

    public void setJudiciaryDocumentType2(String judiciaryDocumentType2) {
        this.judiciaryDocumentType2 = judiciaryDocumentType2;
    }

    public String getJudiciaryOthDocumentType() {
        return judiciaryOthDocumentType;
    }

    public void setJudiciaryOthDocumentType(String judiciaryOthDocumentType) {
        this.judiciaryOthDocumentType = judiciaryOthDocumentType;
    }

    public String getJudiciaryOthDocumentType2() {
        return judiciaryOthDocumentType2;
    }

    public void setJudiciaryOthDocumentType2(String judiciaryOthDocumentType2) {
        this.judiciaryOthDocumentType2 = judiciaryOthDocumentType2;
    }

    public String getDeductionJudiciaryName() {
        return deductionJudiciaryName;
    }

    public void setDeductionJudiciaryName(String deductionJudiciaryName) {
        this.deductionJudiciaryName = deductionJudiciaryName;
    }

    public String getDeductionLawNo() {
        return deductionLawNo;
    }

    public void setDeductionLawNo(String deductionLawNo) {
        this.deductionLawNo = deductionLawNo;
    }

    public String getRestraintSource() {
        return restraintSource;
    }

    public void setRestraintSource(String restraintSource) {
        this.restraintSource = restraintSource;
    }

    public String getJudiciaryDocumentId() {
        return judiciaryDocumentId;
    }

    public void setJudiciaryDocumentId(String judiciaryDocumentId) {
        this.judiciaryDocumentId = judiciaryDocumentId;
    }

    public String getJudiciaryDocumentId2() {
        return judiciaryDocumentId2;
    }

    public void setJudiciaryDocumentId2(String judiciaryDocumentId2) {
        this.judiciaryDocumentId2 = judiciaryDocumentId2;
    }

    public String getJudiciaryOthDocumentId() {
        return judiciaryOthDocumentId;
    }

    public void setJudiciaryOthDocumentId(String judiciaryOthDocumentId) {
        this.judiciaryOthDocumentId = judiciaryOthDocumentId;
    }

    public String getJudiciaryOthDocumentId2() {
        return judiciaryOthDocumentId2;
    }

    public void setJudiciaryOthDocumentId2(String judiciaryOthDocumentId2) {
        this.judiciaryOthDocumentId2 = judiciaryOthDocumentId2;
    }

    public String getReleaseJudiciaryName() {
        return releaseJudiciaryName;
    }

    public void setReleaseJudiciaryName(String releaseJudiciaryName) {
        this.releaseJudiciaryName = releaseJudiciaryName;
    }

    public String getReleaseLawNo() {
        return releaseLawNo;
    }

    public void setReleaseLawNo(String releaseLawNo) {
        this.releaseLawNo = releaseLawNo;
    }

    public String getRestraintJudiciaryName() {
        return restraintJudiciaryName;
    }

    public void setRestraintJudiciaryName(String restraintJudiciaryName) {
        this.restraintJudiciaryName = restraintJudiciaryName;
    }

    public String getResLawNo() {
        return resLawNo;
    }

    public void setResLawNo(String resLawNo) {
        this.resLawNo = resLawNo;
    }

    public String getResAcctRange() {
        return resAcctRange;
    }

    public void setResAcctRange(String resAcctRange) {
        this.resAcctRange = resAcctRange;
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

    public String getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(String sourceModule) {
        this.sourceModule = sourceModule;
    }

    public String getRestraintLevel() {
        return restraintLevel;
    }

    public void setRestraintLevel(String restraintLevel) {
        this.restraintLevel = restraintLevel;
    }

    public String getUnderLien() {
        return underLien;
    }

    public void setUnderLien(String underLien) {
        this.underLien = underLien;
    }

    public String getReserveFlag() {
        return reserveFlag;
    }

    public void setReserveFlag(String reserveFlag) {
        this.reserveFlag = reserveFlag;
    }

    public String getPreFrozenFlag() {
        return preFrozenFlag;
    }

    public void setPreFrozenFlag(String preFrozenFlag) {
        this.preFrozenFlag = preFrozenFlag;
    }

    public String getAhBuFlag() {
        return ahBuFlag;
    }

    public void setAhBuFlag(String ahBuFlag) {
        this.ahBuFlag = ahBuFlag;
    }

    public String getContinueFreezeFlag() {
        return continueFreezeFlag;
    }

    public void setContinueFreezeFlag(String continueFreezeFlag) {
        this.continueFreezeFlag = continueFreezeFlag;
    }

    public String getJudiciaryOfficerName() {
        return judiciaryOfficerName;
    }

    public void setJudiciaryOfficerName(String judiciaryOfficerName) {
        this.judiciaryOfficerName = judiciaryOfficerName;
    }

    public String getJudiciaryOthOfficerName() {
        return judiciaryOthOfficerName;
    }

    public void setJudiciaryOthOfficerName(String judiciaryOthOfficerName) {
        this.judiciaryOthOfficerName = judiciaryOthOfficerName;
    }

    public String getThawDocumentId() {
        return thawDocumentId;
    }

    public void setThawDocumentId(String thawDocumentId) {
        this.thawDocumentId = thawDocumentId;
    }

    public String getThawDocumentId2() {
        return thawDocumentId2;
    }

    public void setThawDocumentId2(String thawDocumentId2) {
        this.thawDocumentId2 = thawDocumentId2;
    }

    public String getThawOfficerName() {
        return thawOfficerName;
    }

    public void setThawOfficerName(String thawOfficerName) {
        this.thawOfficerName = thawOfficerName;
    }

    public String getThawOthDocumentId() {
        return thawOthDocumentId;
    }

    public void setThawOthDocumentId(String thawOthDocumentId) {
        this.thawOthDocumentId = thawOthDocumentId;
    }

    public String getThawOthDocumentId2() {
        return thawOthDocumentId2;
    }

    public void setThawOthDocumentId2(String thawOthDocumentId2) {
        this.thawOthDocumentId2 = thawOthDocumentId2;
    }

    public String getThawOthDocumentType() {
        return thawOthDocumentType;
    }

    public void setThawOthDocumentType(String thawOthDocumentType) {
        this.thawOthDocumentType = thawOthDocumentType;
    }

    public String getThawOthDocumentType2() {
        return thawOthDocumentType2;
    }

    public void setThawOthDocumentType2(String thawOthDocumentType2) {
        this.thawOthDocumentType2 = thawOthDocumentType2;
    }

    public String getThawOthOfficerName() {
        return thawOthOfficerName;
    }

    public void setThawOthOfficerName(String thawOthOfficerName) {
        this.thawOthOfficerName = thawOthOfficerName;
    }

    public String getThawDocumentType2() {
        return thawDocumentType2;
    }

    public void setThawDocumentType2(String thawDocumentType2) {
        this.thawDocumentType2 = thawDocumentType2;
    }

    public String getThawDocumentType() {
        return thawDocumentType;
    }

    public void setThawDocumentType(String thawDocumentType) {
        this.thawDocumentType = thawDocumentType;
    }

    public String getBusinessApplicationId() {
        return businessApplicationId;
    }

    public void setBusinessApplicationId(String businessApplicationId) {
        this.businessApplicationId = businessApplicationId;
    }

    public String getOriginalApplicationId() {
        return originalApplicationId;
    }

    public void setOriginalApplicationId(String originalApplicationId) {
        this.originalApplicationId = originalApplicationId;
    }

    public String getDeductionLawType() {
        return deductionLawType;
    }

    public void setDeductionLawType(String deductionLawType) {
        this.deductionLawType = deductionLawType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getLastChangeUserId() {
        return lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}