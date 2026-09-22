package com.dcits.deposit.entity;

import java.util.Date;

public class IaBatchOpenDetail {
    /** 序号 */
    private String seqNo;
    /** 批次号 */
    private String batchNo;
    /** 批处理任务ID */
    private String jobRunId;
    /** 定制账户标志 */
    private String specAcctFlag;
    /** 指定开户序号 */
    private String specSeqNo;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 账户序号 */
    private String acctSeqNo;
    /** 账户币种 */
    private String acctCcy;
    /** 账户名称 */
    private String acctName;
    /** 账户开立行行号 */
    private String acctBranch;
    /** 客户号 */
    private String clientNo;
    /** 审批单号 */
    private String approvalNo;
    /** 科目编号 */
    private String subjectCode;
    /** 挂销账标志 */
    private String hangWriteOffFlag;
    /** 挂账期限 */
    private String hangTerm;
    /** 可透支标志 */
    private String odFacility;
    /** 柜面跨机构存入标志 */
    private String counterCroBrchCretFlag;
    /** 柜面跨机构支取标志 */
    private String counterCroBrchDebtFlag;
    /** 业务处理状态 */
    private String tranStatus;
    /** 交易日期 */
    private Date tranDate;
    /** 错误码 */
    private String errorCode;
    /** 错误描述 */
    private String errorDesc;
    /** 法人 */
    private String company;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 批量明细序号 */
    private String batchSeqNo;
    /** 交易参考号 */
    private String reference;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getJobRunId() {
        return jobRunId;
    }

    public void setJobRunId(String jobRunId) {
        this.jobRunId = jobRunId;
    }

    public String getSpecAcctFlag() {
        return specAcctFlag;
    }

    public void setSpecAcctFlag(String specAcctFlag) {
        this.specAcctFlag = specAcctFlag;
    }

    public String getSpecSeqNo() {
        return specSeqNo;
    }

    public void setSpecSeqNo(String specSeqNo) {
        this.specSeqNo = specSeqNo;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public String getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(String acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(String acctBranch) {
        this.acctBranch = acctBranch;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getApprovalNo() {
        return approvalNo;
    }

    public void setApprovalNo(String approvalNo) {
        this.approvalNo = approvalNo;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getHangWriteOffFlag() {
        return hangWriteOffFlag;
    }

    public void setHangWriteOffFlag(String hangWriteOffFlag) {
        this.hangWriteOffFlag = hangWriteOffFlag;
    }

    public String getHangTerm() {
        return hangTerm;
    }

    public void setHangTerm(String hangTerm) {
        this.hangTerm = hangTerm;
    }

    public String getOdFacility() {
        return odFacility;
    }

    public void setOdFacility(String odFacility) {
        this.odFacility = odFacility;
    }

    public String getCounterCroBrchCretFlag() {
        return counterCroBrchCretFlag;
    }

    public void setCounterCroBrchCretFlag(String counterCroBrchCretFlag) {
        this.counterCroBrchCretFlag = counterCroBrchCretFlag;
    }

    public String getCounterCroBrchDebtFlag() {
        return counterCroBrchDebtFlag;
    }

    public void setCounterCroBrchDebtFlag(String counterCroBrchDebtFlag) {
        this.counterCroBrchDebtFlag = counterCroBrchDebtFlag;
    }

    public String getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(String tranStatus) {
        this.tranStatus = tranStatus;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
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

    public String getBatchSeqNo() {
        return batchSeqNo;
    }

    public void setBatchSeqNo(String batchSeqNo) {
        this.batchSeqNo = batchSeqNo;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}