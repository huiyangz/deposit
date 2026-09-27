package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.AcctOpenMode;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.InformBankFlag;
import com.dcits.deposit.enums.IsSelf;
import com.dcits.deposit.enums.OpMethod;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.enums.RbBusAcctPurpose;
import com.dcits.deposit.enums.RegType;
import com.dcits.deposit.enums.SucFlag;
import com.dcits.deposit.enums.TranBranch;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbBusOpenCloseRegEO {
    /** 对公存款账户用途 */
    private RbBusAcctPurpose rbBusAcctPurpose;
    /** 开立机构号 */
    private String openBranch;
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 账户属性 */
    private AcctNatureNo acctNatureNo;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 开户模式 */
    private AcctOpenMode acctOpenMode;
    /** 登记类型 */
    private RegType regType;
    /** 激活日期 */
    private java.util.Date activeDate;
    /** 卡号 */
    private String cardNo;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 开户金额 */
    private BigDecimal openAmount;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 存款账户类型 */
    private RbAcctType rbAcctType;
    /** 视同本人标志 */
    private IsSelf isSelf;
    /** 摘要 */
    private String narrative;
    /** 账户用途描述 */
    private String acctPurposeDesc;
    /** 账户序号 */
    private String acctSeqNo;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 账号 */
    @NotNull
    private String baseAcctNo;
    /** 账户开立行行号 */
    private TranBranch acctBranch;
    /** 通知人行标志 */
    private InformBankFlag informBankFlag;
    /** 审批单号 */
    private String approvalNo;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 证件号码 */
    private String documentId;
    /** 账户状态 */
    private AcctStatus acctStatus;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 交易参考号 */
    private String reference;
    /** 摘要码 */
    private String narrativeCode;
    /** 产品编号 */
    private String prodNo;
    /** 社会统一信用代码标志 */
    private SucFlag sucFlag;
    /** 开销户方式 */
    private OpMethod opMethod;
    /** 序号 */
    @NotNull
    private String seqNo;

    public RbBusAcctPurpose getRbBusAcctPurpose() {
        return rbBusAcctPurpose;
    }

    public void setRbBusAcctPurpose(RbBusAcctPurpose rbBusAcctPurpose) {
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

    public AcctNatureNo getAcctNatureNo() {
        return acctNatureNo;
    }

    public void setAcctNatureNo(AcctNatureNo acctNatureNo) {
        this.acctNatureNo = acctNatureNo;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public AcctOpenMode getAcctOpenMode() {
        return acctOpenMode;
    }

    public void setAcctOpenMode(AcctOpenMode acctOpenMode) {
        this.acctOpenMode = acctOpenMode;
    }

    public RegType getRegType() {
        return regType;
    }

    public void setRegType(RegType regType) {
        this.regType = regType;
    }

    public java.util.Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(java.util.Date activeDate) {
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

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public RbAcctType getRbAcctType() {
        return rbAcctType;
    }

    public void setRbAcctType(RbAcctType rbAcctType) {
        this.rbAcctType = rbAcctType;
    }

    public IsSelf getIsSelf() {
        return isSelf;
    }

    public void setIsSelf(IsSelf isSelf) {
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

    public TranBranch getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(TranBranch acctBranch) {
        this.acctBranch = acctBranch;
    }

    public InformBankFlag getInformBankFlag() {
        return informBankFlag;
    }

    public void setInformBankFlag(InformBankFlag informBankFlag) {
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

    public AcctStatus getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(AcctStatus acctStatus) {
        this.acctStatus = acctStatus;
    }

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
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

    public SucFlag getSucFlag() {
        return sucFlag;
    }

    public void setSucFlag(SucFlag sucFlag) {
        this.sucFlag = sucFlag;
    }

    public OpMethod getOpMethod() {
        return opMethod;
    }

    public void setOpMethod(OpMethod opMethod) {
        this.opMethod = opMethod;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }
}