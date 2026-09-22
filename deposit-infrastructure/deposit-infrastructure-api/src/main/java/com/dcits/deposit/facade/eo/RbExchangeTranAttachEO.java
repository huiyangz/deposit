package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.ExchangeAmountNature;
import com.dcits.deposit.enums.ExchangeAmountType;
import com.dcits.deposit.enums.ExchangeCancelReason;
import com.dcits.deposit.enums.ExchangeChangeReason;
import com.dcits.deposit.enums.ExchangeClass;
import com.dcits.deposit.enums.ExchangeReportType;
import com.dcits.deposit.enums.ExchangeSupplyReason;
import com.dcits.deposit.enums.ExchangeTranStatus;
import com.dcits.deposit.enums.ExchangeType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.SourceModule;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbExchangeTranAttachEO {
    /** 序号 */
    @NotNull
    private String seqNo;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 外汇账号 */
    private String foreAcct;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 证件号码 */
    private String documentId;
    /** 结售汇补录原因 */
    private ExchangeSupplyReason exchangeSupplyReason;
    /** 结售汇资金属性 */
    private ExchangeAmountNature exchangeAmountNature;
    /** 代理企业名称 */
    private String agencyCorpName;
    /** 人民币账号 */
    private String cnyAcctNo;
    /** 结售汇修改原因 */
    private ExchangeChangeReason exchangeChangeReason;
    /** 证件类型 */
    private DocumentType documentType;
    /** 发证国家 */
    private IssCountry issCountry;
    /** 结售汇撤销原因 */
    private ExchangeCancelReason exchangeCancelReason;
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
    private ExchangeAmountType exchangeAmountType;
    /** 结售汇申请分类 */
    private ExchangeClass exchangeClass;
    /** 结售汇报汇客户类型 */
    private ExchangeReportType exchangeReportType;
    /** 结售汇报汇序号 */
    private String exchangeReportNo;
    /** 结售汇收入方交易编码 */
    private String exchangeTranCode;
    /** 结售汇支出方交易编码 */
    private String exchangeTranCodet;
    /** 结售汇类型 */
    private ExchangeType exchangeType;
    /** 结售汇交易状态 */
    private ExchangeTranStatus exchangeTranStatus;
    /** 结售汇用途 */
    private String exchangePurpose;
    /** 结售汇用途明细描述 */
    private String exchangePurposeDetails;
    /** 源模块 */
    private SourceModule sourceModule;
    /** 现金凭证预约复核柜员号 */
    private String apprUserId;
    /** 复核日期 */
    private java.util.Date approvalDate;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 汇率优惠值 */
    private BigDecimal discountValue;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 法人 */
    private Company company;
    /** 现钞来源代码 */
    private String cashFromCode;
    /** 现金来源国家 */
    private IssCountry cashFromCountry;
    /** 现钞去向代码 */
    private String cashToCode;
    /** 现钞去向国家 */
    private IssCountry cashToCountry;
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

    public ExchangeSupplyReason getExchangeSupplyReason() {
        return exchangeSupplyReason;
    }

    public void setExchangeSupplyReason(ExchangeSupplyReason exchangeSupplyReason) {
        this.exchangeSupplyReason = exchangeSupplyReason;
    }

    public ExchangeAmountNature getExchangeAmountNature() {
        return exchangeAmountNature;
    }

    public void setExchangeAmountNature(ExchangeAmountNature exchangeAmountNature) {
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

    public ExchangeChangeReason getExchangeChangeReason() {
        return exchangeChangeReason;
    }

    public void setExchangeChangeReason(ExchangeChangeReason exchangeChangeReason) {
        this.exchangeChangeReason = exchangeChangeReason;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public IssCountry getIssCountry() {
        return issCountry;
    }

    public void setIssCountry(IssCountry issCountry) {
        this.issCountry = issCountry;
    }

    public ExchangeCancelReason getExchangeCancelReason() {
        return exchangeCancelReason;
    }

    public void setExchangeCancelReason(ExchangeCancelReason exchangeCancelReason) {
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

    public ExchangeAmountType getExchangeAmountType() {
        return exchangeAmountType;
    }

    public void setExchangeAmountType(ExchangeAmountType exchangeAmountType) {
        this.exchangeAmountType = exchangeAmountType;
    }

    public ExchangeClass getExchangeClass() {
        return exchangeClass;
    }

    public void setExchangeClass(ExchangeClass exchangeClass) {
        this.exchangeClass = exchangeClass;
    }

    public ExchangeReportType getExchangeReportType() {
        return exchangeReportType;
    }

    public void setExchangeReportType(ExchangeReportType exchangeReportType) {
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

    public ExchangeType getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(ExchangeType exchangeType) {
        this.exchangeType = exchangeType;
    }

    public ExchangeTranStatus getExchangeTranStatus() {
        return exchangeTranStatus;
    }

    public void setExchangeTranStatus(ExchangeTranStatus exchangeTranStatus) {
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

    public SourceModule getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(SourceModule sourceModule) {
        this.sourceModule = sourceModule;
    }

    public String getApprUserId() {
        return apprUserId;
    }

    public void setApprUserId(String apprUserId) {
        this.apprUserId = apprUserId;
    }

    public java.util.Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(java.util.Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCashFromCode() {
        return cashFromCode;
    }

    public void setCashFromCode(String cashFromCode) {
        this.cashFromCode = cashFromCode;
    }

    public IssCountry getCashFromCountry() {
        return cashFromCountry;
    }

    public void setCashFromCountry(IssCountry cashFromCountry) {
        this.cashFromCountry = cashFromCountry;
    }

    public String getCashToCode() {
        return cashToCode;
    }

    public void setCashToCode(String cashToCode) {
        this.cashToCode = cashToCode;
    }

    public IssCountry getCashToCountry() {
        return cashToCountry;
    }

    public void setCashToCountry(IssCountry cashToCountry) {
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