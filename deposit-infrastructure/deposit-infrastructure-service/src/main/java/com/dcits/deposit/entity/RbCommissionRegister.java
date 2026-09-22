package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbCommissionRegister {
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 交易参考号 */
    private String reference;
    /** 交易代码 */
    private String programId;
    /** 交易日期 */
    private Date tranDate;
    /** 交易机构号 */
    private String tranBranch;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 账户币种 */
    private String acctCcy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 账户名称 */
    private String acctName;
    /** 交易类型 */
    private String tranType;
    /** 事件类型 */
    private String eventType;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 凭证类型 */
    private String docType;
    /** 凭证前缀编码 */
    private String prefix;
    /** 凭证号 */
    private String voucherNo;
    /** 客户号 */
    private String clientNo;
    /** 代办人名称 */
    private String commissionClientName;
    /** 代办人客户号 */
    private String commissionClientNo;
    /** 代办人证件号码 */
    private String commissionDocumentId;
    /** 代办人证件类型 */
    private String commissionDocumentType;
    /** 国家 */
    private String country;
    /** 代办人证件开始日期 */
    private Date commissionStartDate;
    /** 代办人证件到期日期 */
    private Date commissionExpireDate;
    /** 代办人电话 */
    private String commissionClientTel;
    /** 代办原因 */
    private String commissionReason;
    /** 代办人关系类型 */
    private String commissionRelation;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 代办核实员工号1 */
    private String commissionConfirmUserIdKey1;
    /** 代办核实员工号2 */
    private String commissionConfirmUserIdKey2;
    /** 核实电话号码 */
    private String commissionConfirmTel;
    /** 代办核实时间 */
    private String commissionConfirmTime;
    /** 核实结果 */
    private String commissionConfirmResult;
    /** 代理类型 */
    private String commissionFlag;
    /** 代办人标志 */
    private String isCommission;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;

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

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
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

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getCommissionClientName() {
        return commissionClientName;
    }

    public void setCommissionClientName(String commissionClientName) {
        this.commissionClientName = commissionClientName;
    }

    public String getCommissionClientNo() {
        return commissionClientNo;
    }

    public void setCommissionClientNo(String commissionClientNo) {
        this.commissionClientNo = commissionClientNo;
    }

    public String getCommissionDocumentId() {
        return commissionDocumentId;
    }

    public void setCommissionDocumentId(String commissionDocumentId) {
        this.commissionDocumentId = commissionDocumentId;
    }

    public String getCommissionDocumentType() {
        return commissionDocumentType;
    }

    public void setCommissionDocumentType(String commissionDocumentType) {
        this.commissionDocumentType = commissionDocumentType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getCommissionStartDate() {
        return commissionStartDate;
    }

    public void setCommissionStartDate(Date commissionStartDate) {
        this.commissionStartDate = commissionStartDate;
    }

    public Date getCommissionExpireDate() {
        return commissionExpireDate;
    }

    public void setCommissionExpireDate(Date commissionExpireDate) {
        this.commissionExpireDate = commissionExpireDate;
    }

    public String getCommissionClientTel() {
        return commissionClientTel;
    }

    public void setCommissionClientTel(String commissionClientTel) {
        this.commissionClientTel = commissionClientTel;
    }

    public String getCommissionReason() {
        return commissionReason;
    }

    public void setCommissionReason(String commissionReason) {
        this.commissionReason = commissionReason;
    }

    public String getCommissionRelation() {
        return commissionRelation;
    }

    public void setCommissionRelation(String commissionRelation) {
        this.commissionRelation = commissionRelation;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCommissionConfirmUserIdKey1() {
        return commissionConfirmUserIdKey1;
    }

    public void setCommissionConfirmUserIdKey1(String commissionConfirmUserIdKey1) {
        this.commissionConfirmUserIdKey1 = commissionConfirmUserIdKey1;
    }

    public String getCommissionConfirmUserIdKey2() {
        return commissionConfirmUserIdKey2;
    }

    public void setCommissionConfirmUserIdKey2(String commissionConfirmUserIdKey2) {
        this.commissionConfirmUserIdKey2 = commissionConfirmUserIdKey2;
    }

    public String getCommissionConfirmTel() {
        return commissionConfirmTel;
    }

    public void setCommissionConfirmTel(String commissionConfirmTel) {
        this.commissionConfirmTel = commissionConfirmTel;
    }

    public String getCommissionConfirmTime() {
        return commissionConfirmTime;
    }

    public void setCommissionConfirmTime(String commissionConfirmTime) {
        this.commissionConfirmTime = commissionConfirmTime;
    }

    public String getCommissionConfirmResult() {
        return commissionConfirmResult;
    }

    public void setCommissionConfirmResult(String commissionConfirmResult) {
        this.commissionConfirmResult = commissionConfirmResult;
    }

    public String getCommissionFlag() {
        return commissionFlag;
    }

    public void setCommissionFlag(String commissionFlag) {
        this.commissionFlag = commissionFlag;
    }

    public String getIsCommission() {
        return isCommission;
    }

    public void setIsCommission(String isCommission) {
        this.isCommission = isCommission;
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
}