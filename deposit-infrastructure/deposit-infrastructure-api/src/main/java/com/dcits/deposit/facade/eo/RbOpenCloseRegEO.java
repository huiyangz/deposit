package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.AcctOpenMode;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.OpMethod;
import com.dcits.deposit.enums.ReasonCode;
import com.dcits.deposit.enums.RegType;
import com.dcits.deposit.enums.SourceModule;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbOpenCloseRegEO {
    /** 开立机构号 */
    private AcctBranch openBranch;
    /** 序号 */
    @NotNull
    private String seqNo;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 产品类型 */
    private String prodType;
    /** 卡号 */
    private String cardNo;
    /** 账户开立行行号 */
    private AcctBranch acctBranch;
    /** 账户状态 */
    private AcctStatus acctStatus;
    /** 账户类型 */
    private AcctType acctType;
    /** 账户属性 */
    private AcctNature acctNature;
    /** 激活日期 */
    private java.util.Date activeDate;
    /** 交易参考号 */
    private String reference;
    /** 通知人行标志 */
    private IndividualFlag informBankFlag;
    /** 开销户方式 */
    private OpMethod opMethod;
    /** 登记类型 */
    private RegType regType;
    /** 社会统一信用代码标志 */
    private IndividualFlag sucFlag;
    /** 视同本人标志 */
    private IndividualFlag isSelf;
    /** 证件号码 */
    private String documentId;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 摘要 */
    private String narrative;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 交易机构号 */
    private AcctBranch tranBranch;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 交易柜员号 */
    private String userId;
    /** 法人 */
    private Company company;
    /** 摘要码 */
    private String narrativeCode;
    /** 审批单号 */
    private String approvalNo;
    /** 开户金额 */
    private BigDecimal openAmount;
    /** 开户模式 */
    private AcctOpenMode acctOpenMode;
    /** 授权柜员号 */
    private String authUserId;
    /** 账户类别 */
    private AcctClass acctClass;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 账户用途 */
    private ReasonCode reasonCode;
    /** 原因代码描述 */
    private String reasonCodeDesc;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 源模块 */
    private SourceModule sourceModule;

    public AcctBranch getOpenBranch() {
        return openBranch;
    }

    public void setOpenBranch(AcctBranch openBranch) {
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

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
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

    public AcctBranch getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(AcctBranch acctBranch) {
        this.acctBranch = acctBranch;
    }

    public AcctStatus getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(AcctStatus acctStatus) {
        this.acctStatus = acctStatus;
    }

    public AcctType getAcctType() {
        return acctType;
    }

    public void setAcctType(AcctType acctType) {
        this.acctType = acctType;
    }

    public AcctNature getAcctNature() {
        return acctNature;
    }

    public void setAcctNature(AcctNature acctNature) {
        this.acctNature = acctNature;
    }

    public java.util.Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(java.util.Date activeDate) {
        this.activeDate = activeDate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public IndividualFlag getInformBankFlag() {
        return informBankFlag;
    }

    public void setInformBankFlag(IndividualFlag informBankFlag) {
        this.informBankFlag = informBankFlag;
    }

    public OpMethod getOpMethod() {
        return opMethod;
    }

    public void setOpMethod(OpMethod opMethod) {
        this.opMethod = opMethod;
    }

    public RegType getRegType() {
        return regType;
    }

    public void setRegType(RegType regType) {
        this.regType = regType;
    }

    public IndividualFlag getSucFlag() {
        return sucFlag;
    }

    public void setSucFlag(IndividualFlag sucFlag) {
        this.sucFlag = sucFlag;
    }

    public IndividualFlag getIsSelf() {
        return isSelf;
    }

    public void setIsSelf(IndividualFlag isSelf) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
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

    public AcctOpenMode getAcctOpenMode() {
        return acctOpenMode;
    }

    public void setAcctOpenMode(AcctOpenMode acctOpenMode) {
        this.acctOpenMode = acctOpenMode;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    public AcctClass getAcctClass() {
        return acctClass;
    }

    public void setAcctClass(AcctClass acctClass) {
        this.acctClass = acctClass;
    }

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public ReasonCode getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(ReasonCode reasonCode) {
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

    public SourceModule getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(SourceModule sourceModule) {
        this.sourceModule = sourceModule;
    }
}