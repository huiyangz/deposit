package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.CommissionFlag;
import com.dcits.deposit.enums.CommissionRelation;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbCommissionRegisterEO {
    /** 代办人客户号 */
    private String commissionClientNo;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 凭证号 */
    private String voucherNo;
    /** 产品编号 */
    private String prodNo;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 代办人关系类型 */
    private CommissionRelation commissionRelation;
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 账户名称 */
    private String acctName;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 渠道流水号 */
    @NotNull
    private String channelSeqNo;
    /** 交易参考号 */
    private String reference;
    /** 交易代码 */
    private String programId;
    /** 代办人证件类型 */
    private DocumentType commissionDocumentType;
    /** 代办核实员工号2 */
    private String commissionConfirmUserIdKey2;
    /** 事件类型 */
    private String eventType;
    /** 代办人名称 */
    private String commissionClientName;
    /** 代办原因 */
    private String commissionReason;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 代理类型 */
    private CommissionFlag commissionFlag;
    /** 代办人证件到期日期 */
    private java.util.Date commissionExpireDate;
    /** 代办人证件开始日期 */
    private java.util.Date commissionStartDate;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 代办核实时间 */
    private String commissionConfirmTime;
    /** 凭证类型 */
    private DocType docType;
    /** 国家 */
    private IssCountry country;
    /** 代办人标志 */
    private String isCommission;
    /** 凭证前缀编码 */
    private String prefix;
    /** 代办人核实结果 */
    private String commissionConfirmResult;
    /** 账号 */
    private String baseAcctNo;
    /** 交易机构号 */
    private TranBranch tranBranch;
    /** 账户序号 */
    private String acctSeqNo;
    /** 代办人证件号码 */
    private String commissionDocumentId;
    /** 代办人电话 */
    private String commissionClientTel;
    /** 核实电话号码 */
    private String commissionConfirmTel;
    /** 交易类型 */
    private TranType tranType;
    /** 代办核实员工号1 */
    private String commissionConfirmUserIdKey1;

    public String getCommissionClientNo() {
        return commissionClientNo;
    }

    public void setCommissionClientNo(String commissionClientNo) {
        this.commissionClientNo = commissionClientNo;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
        this.acctCcy = acctCcy;
    }

    public CommissionRelation getCommissionRelation() {
        return commissionRelation;
    }

    public void setCommissionRelation(CommissionRelation commissionRelation) {
        this.commissionRelation = commissionRelation;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public DocumentType getCommissionDocumentType() {
        return commissionDocumentType;
    }

    public void setCommissionDocumentType(DocumentType commissionDocumentType) {
        this.commissionDocumentType = commissionDocumentType;
    }

    public String getCommissionConfirmUserIdKey2() {
        return commissionConfirmUserIdKey2;
    }

    public void setCommissionConfirmUserIdKey2(String commissionConfirmUserIdKey2) {
        this.commissionConfirmUserIdKey2 = commissionConfirmUserIdKey2;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getCommissionClientName() {
        return commissionClientName;
    }

    public void setCommissionClientName(String commissionClientName) {
        this.commissionClientName = commissionClientName;
    }

    public String getCommissionReason() {
        return commissionReason;
    }

    public void setCommissionReason(String commissionReason) {
        this.commissionReason = commissionReason;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public CommissionFlag getCommissionFlag() {
        return commissionFlag;
    }

    public void setCommissionFlag(CommissionFlag commissionFlag) {
        this.commissionFlag = commissionFlag;
    }

    public java.util.Date getCommissionExpireDate() {
        return commissionExpireDate;
    }

    public void setCommissionExpireDate(java.util.Date commissionExpireDate) {
        this.commissionExpireDate = commissionExpireDate;
    }

    public java.util.Date getCommissionStartDate() {
        return commissionStartDate;
    }

    public void setCommissionStartDate(java.util.Date commissionStartDate) {
        this.commissionStartDate = commissionStartDate;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getCommissionConfirmTime() {
        return commissionConfirmTime;
    }

    public void setCommissionConfirmTime(String commissionConfirmTime) {
        this.commissionConfirmTime = commissionConfirmTime;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public IssCountry getCountry() {
        return country;
    }

    public void setCountry(IssCountry country) {
        this.country = country;
    }

    public String getIsCommission() {
        return isCommission;
    }

    public void setIsCommission(String isCommission) {
        this.isCommission = isCommission;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getCommissionConfirmResult() {
        return commissionConfirmResult;
    }

    public void setCommissionConfirmResult(String commissionConfirmResult) {
        this.commissionConfirmResult = commissionConfirmResult;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public TranBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(TranBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public String getCommissionDocumentId() {
        return commissionDocumentId;
    }

    public void setCommissionDocumentId(String commissionDocumentId) {
        this.commissionDocumentId = commissionDocumentId;
    }

    public String getCommissionClientTel() {
        return commissionClientTel;
    }

    public void setCommissionClientTel(String commissionClientTel) {
        this.commissionClientTel = commissionClientTel;
    }

    public String getCommissionConfirmTel() {
        return commissionConfirmTel;
    }

    public void setCommissionConfirmTel(String commissionConfirmTel) {
        this.commissionConfirmTel = commissionConfirmTel;
    }

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public String getCommissionConfirmUserIdKey1() {
        return commissionConfirmUserIdKey1;
    }

    public void setCommissionConfirmUserIdKey1(String commissionConfirmUserIdKey1) {
        this.commissionConfirmUserIdKey1 = commissionConfirmUserIdKey1;
    }
}