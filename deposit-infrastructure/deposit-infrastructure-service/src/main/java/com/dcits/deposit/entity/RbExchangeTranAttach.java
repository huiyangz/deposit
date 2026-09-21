package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbExchangeTranAttach {
    /** 序号 */
    private String seqNo;
    /** 客户号 */
    private String clientNo;
    /** 外汇账号 */
    private String foreAcct;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 证件号码 */
    private String documentId;
    /** 结售汇补录原因 */
    private String exchangeSupplyReason;
    /** 结售汇资金属性 */
    private String exchangeAmountNature;
    /** 代理企业名称 */
    private String agencyCorpName;
    /** 人民币账号 */
    private String cnyAcctNo;
    /** 结售汇修改原因 */
    private String exchangeChangeReason;
    /** 证件类型 */
    private String documentType;
    /** 发证国家 */
    private String issCountry;
    /** 结售汇撤销原因 */
    private String exchangeCancelReason;
    /** 补录说明 */
    private String supplyRemark;
    /** 核准件编号 */
    private String apprLetterNo;
    /** 个体工商户组织机构代码 */
    private String individualBusiOrgCode;
    /** 个体工商户名称 */
    private String individualBusiName;
    /** 客户名称 */
    private String clientName;
    /** 补充证件号码 */
    private String supplyDocumentId;
    /** 代理企业组织机构代码 */
    private String agencyCorpOrgCode;
    /** 结汇资金形态 */
    private String exchangeAmountType;
    /** 结售汇申请分类 */
    private String exchangeClass;
    /** 结售汇报汇客户类型 */
    private String exchangeReportType;
    /** 结售汇报汇序号 */
    private String exchangeReportNo;
    /** 结售汇收入方交易编码 */
    private String exchangeTranCode;
    /** 结售汇支出方交易编码 */
    private String exchangeTranCodet;
    /** 结售汇类型 */
    private String exchangeType;
    /** 结售汇交易状态 */
    private String exchangeTranStatus;
    /** 结售汇用途 */
    private String exchangePurpose;
    /** 结售汇用途明细描述 */
    private String exchangePurposeDetails;
    /** 源模块 */
    private String sourceModule;
    /** 现金凭证预约复核柜员号 */
    private String apprUserId;
    /** 复核日期 */
    private Date approvalDate;
    /** 交易日期 */
    private Date tranDate;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 汇率优惠值 */
    private BigDecimal discountValue;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 法人 */
    private String company;
    /** 现钞来源代码 */
    private String cashFromCode;
    /** 现金来源国家 */
    private String cashFromCountry;
    /** 现钞去向代码 */
    private String cashToCode;
    /** 现钞去向国家 */
    private String cashToCountry;
    /** 备注 */
    private String remark;
    /** 创建时间戳 */
    private String createTimestamp;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getForeAcct() {
        return foreAcct;
    }

    public void setForeAcct(String foreAcct) {
        this.foreAcct = foreAcct;
    }

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getExchangeSupplyReason() {
        return exchangeSupplyReason;
    }

    public void setExchangeSupplyReason(String exchangeSupplyReason) {
        this.exchangeSupplyReason = exchangeSupplyReason;
    }

    public String getExchangeAmountNature() {
        return exchangeAmountNature;
    }

    public void setExchangeAmountNature(String exchangeAmountNature) {
        this.exchangeAmountNature = exchangeAmountNature;
    }

    public String getAgencyCorpName() {
        return agencyCorpName;
    }

    public void setAgencyCorpName(String agencyCorpName) {
        this.agencyCorpName = agencyCorpName;
    }

    public String getCnyAcctNo() {
        return cnyAcctNo;
    }

    public void setCnyAcctNo(String cnyAcctNo) {
        this.cnyAcctNo = cnyAcctNo;
    }

    public String getExchangeChangeReason() {
        return exchangeChangeReason;
    }

    public void setExchangeChangeReason(String exchangeChangeReason) {
        this.exchangeChangeReason = exchangeChangeReason;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getIssCountry() {
        return issCountry;
    }

    public void setIssCountry(String issCountry) {
        this.issCountry = issCountry;
    }

    public String getExchangeCancelReason() {
        return exchangeCancelReason;
    }

    public void setExchangeCancelReason(String exchangeCancelReason) {
        this.exchangeCancelReason = exchangeCancelReason;
    }

    public String getSupplyRemark() {
        return supplyRemark;
    }

    public void setSupplyRemark(String supplyRemark) {
        this.supplyRemark = supplyRemark;
    }

    public String getApprLetterNo() {
        return apprLetterNo;
    }

    public void setApprLetterNo(String apprLetterNo) {
        this.apprLetterNo = apprLetterNo;
    }

    public String getIndividualBusiOrgCode() {
        return individualBusiOrgCode;
    }

    public void setIndividualBusiOrgCode(String individualBusiOrgCode) {
        this.individualBusiOrgCode = individualBusiOrgCode;
    }

    public String getIndividualBusiName() {
        return individualBusiName;
    }

    public void setIndividualBusiName(String individualBusiName) {
        this.individualBusiName = individualBusiName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getSupplyDocumentId() {
        return supplyDocumentId;
    }

    public void setSupplyDocumentId(String supplyDocumentId) {
        this.supplyDocumentId = supplyDocumentId;
    }

    public String getAgencyCorpOrgCode() {
        return agencyCorpOrgCode;
    }

    public void setAgencyCorpOrgCode(String agencyCorpOrgCode) {
        this.agencyCorpOrgCode = agencyCorpOrgCode;
    }

    public String getExchangeAmountType() {
        return exchangeAmountType;
    }

    public void setExchangeAmountType(String exchangeAmountType) {
        this.exchangeAmountType = exchangeAmountType;
    }

    public String getExchangeClass() {
        return exchangeClass;
    }

    public void setExchangeClass(String exchangeClass) {
        this.exchangeClass = exchangeClass;
    }

    public String getExchangeReportType() {
        return exchangeReportType;
    }

    public void setExchangeReportType(String exchangeReportType) {
        this.exchangeReportType = exchangeReportType;
    }

    public String getExchangeReportNo() {
        return exchangeReportNo;
    }

    public void setExchangeReportNo(String exchangeReportNo) {
        this.exchangeReportNo = exchangeReportNo;
    }

    public String getExchangeTranCode() {
        return exchangeTranCode;
    }

    public void setExchangeTranCode(String exchangeTranCode) {
        this.exchangeTranCode = exchangeTranCode;
    }

    public String getExchangeTranCodet() {
        return exchangeTranCodet;
    }

    public void setExchangeTranCodet(String exchangeTranCodet) {
        this.exchangeTranCodet = exchangeTranCodet;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getExchangeTranStatus() {
        return exchangeTranStatus;
    }

    public void setExchangeTranStatus(String exchangeTranStatus) {
        this.exchangeTranStatus = exchangeTranStatus;
    }

    public String getExchangePurpose() {
        return exchangePurpose;
    }

    public void setExchangePurpose(String exchangePurpose) {
        this.exchangePurpose = exchangePurpose;
    }

    public String getExchangePurposeDetails() {
        return exchangePurposeDetails;
    }

    public void setExchangePurposeDetails(String exchangePurposeDetails) {
        this.exchangePurposeDetails = exchangePurposeDetails;
    }

    public String getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(String sourceModule) {
        this.sourceModule = sourceModule;
    }

    public String getApprUserId() {
        return apprUserId;
    }

    public void setApprUserId(String apprUserId) {
        this.apprUserId = apprUserId;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
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

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public String getLastChangeUserId() {
        return lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCashFromCode() {
        return cashFromCode;
    }

    public void setCashFromCode(String cashFromCode) {
        this.cashFromCode = cashFromCode;
    }

    public String getCashFromCountry() {
        return cashFromCountry;
    }

    public void setCashFromCountry(String cashFromCountry) {
        this.cashFromCountry = cashFromCountry;
    }

    public String getCashToCode() {
        return cashToCode;
    }

    public void setCashToCode(String cashToCode) {
        this.cashToCode = cashToCode;
    }

    public String getCashToCountry() {
        return cashToCountry;
    }

    public void setCashToCountry(String cashToCountry) {
        this.cashToCountry = cashToCountry;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}