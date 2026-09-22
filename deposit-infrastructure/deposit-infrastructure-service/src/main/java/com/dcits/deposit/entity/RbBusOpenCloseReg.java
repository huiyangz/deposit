package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbBusOpenCloseReg {
    /** 对公存款账户用途 */
    private String rbBusAcctPurpose;
    /** 开立机构号 */
    private String openBranch;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 账户属性 */
    private String acctNatureNo;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 开户模式 */
    private String acctOpenMode;
    /** 登记类型 */
    private String regType;
    /** 激活日期 */
    private Date activeDate;
    /** 卡号 */
    private String cardNo;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 开户金额 */
    private BigDecimal openAmount;
    /** 交易日期 */
    private Date tranDate;
    /** 存款账户类型 */
    private String rbAcctType;
    /** 视同本人标志 */
    private String isSelf;
    /** 摘要 */
    private String narrative;
    /** 账户用途描述 */
    private String acctPurposeDesc;
    /** 账户序号 */
    private String acctSeqNo;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 账号 */
    private String baseAcctNo;
    /** 账户开立行行号 */
    private String acctBranch;
    /** 通知人行标志 */
    private String informBankFlag;
    /** 审批单号 */
    private String approvalNo;
    /** 客户号 */
    private String clientNo;
    /** 证件号码 */
    private String documentId;
    /** 账户状态 */
    private String acctStatus;
    /** 账户币种 */
    private String acctCcy;
    /** 交易参考号 */
    private String reference;
    /** 摘要码 */
    private String narrativeCode;
    /** 产品编号 */
    private String prodNo;
    /** 社会统一信用代码标志 */
    private String sucFlag;
    /** 开销户方式 */
    private String opMethod;
    /** 序号 */
    private String seqNo;

    public String getRbBusAcctPurpose() {
        return rbBusAcctPurpose;
    }

    public void setRbBusAcctPurpose(String rbBusAcctPurpose) {
        this.rbBusAcctPurpose = rbBusAcctPurpose;
    }

    public String getOpenBranch() {
        return openBranch;
    }

    public void setOpenBranch(String openBranch) {
        this.openBranch = openBranch;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getAcctNatureNo() {
        return acctNatureNo;
    }

    public void setAcctNatureNo(String acctNatureNo) {
        this.acctNatureNo = acctNatureNo;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getAcctOpenMode() {
        return acctOpenMode;
    }

    public void setAcctOpenMode(String acctOpenMode) {
        this.acctOpenMode = acctOpenMode;
    }

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public BigDecimal getOpenAmount() {
        return openAmount;
    }

    public void setOpenAmount(BigDecimal openAmount) {
        this.openAmount = openAmount;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getRbAcctType() {
        return rbAcctType;
    }

    public void setRbAcctType(String rbAcctType) {
        this.rbAcctType = rbAcctType;
    }

    public String getIsSelf() {
        return isSelf;
    }

    public void setIsSelf(String isSelf) {
        this.isSelf = isSelf;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getAcctPurposeDesc() {
        return acctPurposeDesc;
    }

    public void setAcctPurposeDesc(String acctPurposeDesc) {
        this.acctPurposeDesc = acctPurposeDesc;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(String acctBranch) {
        this.acctBranch = acctBranch;
    }

    public String getInformBankFlag() {
        return informBankFlag;
    }

    public void setInformBankFlag(String informBankFlag) {
        this.informBankFlag = informBankFlag;
    }

    public String getApprovalNo() {
        return approvalNo;
    }

    public void setApprovalNo(String approvalNo) {
        this.approvalNo = approvalNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(String acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNarrativeCode() {
        return narrativeCode;
    }

    public void setNarrativeCode(String narrativeCode) {
        this.narrativeCode = narrativeCode;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getSucFlag() {
        return sucFlag;
    }

    public void setSucFlag(String sucFlag) {
        this.sucFlag = sucFlag;
    }

    public String getOpMethod() {
        return opMethod;
    }

    public void setOpMethod(String opMethod) {
        this.opMethod = opMethod;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }
}