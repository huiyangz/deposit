package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbOpenCloseReg {
    /** 开立机构号 */
    private String openBranch;
    /** 序号 */
    private String seqNo;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 账户币种 */
    private String acctCcy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 产品类型 */
    private String prodType;
    /** 卡号 */
    private String cardNo;
    /** 账户开立行行号 */
    private String acctBranch;
    /** 账户状态 */
    private String acctStatus;
    /** 账户类型 */
    private String acctType;
    /** 账户属性 */
    private String acctNature;
    /** 激活日期 */
    private Date activeDate;
    /** 交易参考号 */
    private String reference;
    /** 通知人行标志 */
    private String informBankFlag;
    /** 开销户方式 */
    private String opMethod;
    /** 登记类型 */
    private String regType;
    /** 社会统一信用代码标志 */
    private String sucFlag;
    /** 视同本人标志 */
    private String isSelf;
    /** 证件号码 */
    private String documentId;
    /** 客户号 */
    private String clientNo;
    /** 摘要 */
    private String narrative;
    /** 交易日期 */
    private Date tranDate;
    /** 交易机构号 */
    private String tranBranch;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 交易柜员号 */
    private String userId;
    /** 法人 */
    private String company;
    /** 摘要码 */
    private String narrativeCode;
    /** 审批单号 */
    private String approvalNo;
    /** 开户金额 */
    private BigDecimal openAmount;
    /** 开户模式 */
    private String acctOpenMode;
    /** 授权柜员号 */
    private String authUserId;
    /** 账户类别 */
    private String acctClass;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 账户用途 */
    private String reasonCode;
    /** 原因代码描述 */
    private String reasonCodeDesc;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 源模块 */
    private String sourceModule;

    public String getOpenBranch() {
        return openBranch;
    }

    public void setOpenBranch(String openBranch) {
        this.openBranch = openBranch;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(String acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(String acctBranch) {
        this.acctBranch = acctBranch;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getAcctNature() {
        return acctNature;
    }

    public void setAcctNature(String acctNature) {
        this.acctNature = acctNature;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getInformBankFlag() {
        return informBankFlag;
    }

    public void setInformBankFlag(String informBankFlag) {
        this.informBankFlag = informBankFlag;
    }

    public String getOpMethod() {
        return opMethod;
    }

    public void setOpMethod(String opMethod) {
        this.opMethod = opMethod;
    }

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType;
    }

    public String getSucFlag() {
        return sucFlag;
    }

    public void setSucFlag(String sucFlag) {
        this.sucFlag = sucFlag;
    }

    public String getIsSelf() {
        return isSelf;
    }

    public void setIsSelf(String isSelf) {
        this.isSelf = isSelf;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(String tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNarrativeCode() {
        return narrativeCode;
    }

    public void setNarrativeCode(String narrativeCode) {
        this.narrativeCode = narrativeCode;
    }

    public String getApprovalNo() {
        return approvalNo;
    }

    public void setApprovalNo(String approvalNo) {
        this.approvalNo = approvalNo;
    }

    public BigDecimal getOpenAmount() {
        return openAmount;
    }

    public void setOpenAmount(BigDecimal openAmount) {
        this.openAmount = openAmount;
    }

    public String getAcctOpenMode() {
        return acctOpenMode;
    }

    public void setAcctOpenMode(String acctOpenMode) {
        this.acctOpenMode = acctOpenMode;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    public String getAcctClass() {
        return acctClass;
    }

    public void setAcctClass(String acctClass) {
        this.acctClass = acctClass;
    }

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getReasonCodeDesc() {
        return reasonCodeDesc;
    }

    public void setReasonCodeDesc(String reasonCodeDesc) {
        this.reasonCodeDesc = reasonCodeDesc;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(String sourceModule) {
        this.sourceModule = sourceModule;
    }
}