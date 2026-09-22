package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IaHangAccountReg {
    /** 挂账编号 */
    private String hangSeqNo;
    /** 追加挂账编号 */
    private String subHangSeqNo;
    /** 挂账金额 */
    private BigDecimal hangAmt;
    /** 挂账余额 */
    private BigDecimal hangBal;
    /** 客户号 */
    private String clientNo;
    /** 币种 */
    private String ccy;
    /** 挂销账处理类型 */
    private String hangDealType;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 挂账状态 */
    private String hangStatus;
    /** 挂销账时间 */
    private String hangWriteOffTime;
    /** 挂账到期日期 */
    private Date hangEndDate;
    /** 借贷标志 */
    private String crDrInd;
    /** 交易机构号 */
    private String tranBranch;
    /** 交易日期 */
    private Date tranDate;
    /** 摘要 */
    private String narrative;
    /** 挂账原因 */
    private String hangReason;
    /** 对手账号 */
    private String othBaseAcctNo;
    /** 对手账户名称 */
    private String othAcctName;
    /** 对方账户开户行行号 */
    private String othBranch;
    /** 对手行标志 */
    private String othBankFlag;
    /** 交易参考号 */
    private String reference;
    /** 真实对方金融机构名称 */
    private String othRealBankName;
    /** 实际对手账号 */
    private String othRealBaseAcctNo;
    /** 实际对手产品编号 */
    private String othRealProdType;
    /** 实际对手证件类型 */
    private String othRealDocumentType;
    /** 实际对手身份证件号码 */
    private String othRealDocumentId;
    /** 实际对手机构号 */
    private String othRealBankCode;
    /** 实际对手交易名称 */
    private String othRealTranName;
    /** 实际对手交易地址 */
    private String othRealTranAddr;
    /** 实际对手机构行政区划代码 */
    private String othRealBranchRegionCode;
    /** 交易柜员号 */
    private String userId;
    /** 授权柜员号 */
    private String authUserId;
    /** 法人 */
    private String company;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 上次变更时间 */
    private String lastChangeTime;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;

    public String getHangSeqNo() {
        return hangSeqNo;
    }

    public void setHangSeqNo(String hangSeqNo) {
        this.hangSeqNo = hangSeqNo;
    }

    public String getSubHangSeqNo() {
        return subHangSeqNo;
    }

    public void setSubHangSeqNo(String subHangSeqNo) {
        this.subHangSeqNo = subHangSeqNo;
    }

    public BigDecimal getHangAmt() {
        return hangAmt;
    }

    public void setHangAmt(BigDecimal hangAmt) {
        this.hangAmt = hangAmt;
    }

    public BigDecimal getHangBal() {
        return hangBal;
    }

    public void setHangBal(BigDecimal hangBal) {
        this.hangBal = hangBal;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getHangDealType() {
        return hangDealType;
    }

    public void setHangDealType(String hangDealType) {
        this.hangDealType = hangDealType;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getHangStatus() {
        return hangStatus;
    }

    public void setHangStatus(String hangStatus) {
        this.hangStatus = hangStatus;
    }

    public String getHangWriteOffTime() {
        return hangWriteOffTime;
    }

    public void setHangWriteOffTime(String hangWriteOffTime) {
        this.hangWriteOffTime = hangWriteOffTime;
    }

    public Date getHangEndDate() {
        return hangEndDate;
    }

    public void setHangEndDate(Date hangEndDate) {
        this.hangEndDate = hangEndDate;
    }

    public String getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(String crDrInd) {
        this.crDrInd = crDrInd;
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

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getHangReason() {
        return hangReason;
    }

    public void setHangReason(String hangReason) {
        this.hangReason = hangReason;
    }

    public String getOthBaseAcctNo() {
        return othBaseAcctNo;
    }

    public void setOthBaseAcctNo(String othBaseAcctNo) {
        this.othBaseAcctNo = othBaseAcctNo;
    }

    public String getOthAcctName() {
        return othAcctName;
    }

    public void setOthAcctName(String othAcctName) {
        this.othAcctName = othAcctName;
    }

    public String getOthBranch() {
        return othBranch;
    }

    public void setOthBranch(String othBranch) {
        this.othBranch = othBranch;
    }

    public String getOthBankFlag() {
        return othBankFlag;
    }

    public void setOthBankFlag(String othBankFlag) {
        this.othBankFlag = othBankFlag;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getOthRealBankName() {
        return othRealBankName;
    }

    public void setOthRealBankName(String othRealBankName) {
        this.othRealBankName = othRealBankName;
    }

    public String getOthRealBaseAcctNo() {
        return othRealBaseAcctNo;
    }

    public void setOthRealBaseAcctNo(String othRealBaseAcctNo) {
        this.othRealBaseAcctNo = othRealBaseAcctNo;
    }

    public String getOthRealProdType() {
        return othRealProdType;
    }

    public void setOthRealProdType(String othRealProdType) {
        this.othRealProdType = othRealProdType;
    }

    public String getOthRealDocumentType() {
        return othRealDocumentType;
    }

    public void setOthRealDocumentType(String othRealDocumentType) {
        this.othRealDocumentType = othRealDocumentType;
    }

    public String getOthRealDocumentId() {
        return othRealDocumentId;
    }

    public void setOthRealDocumentId(String othRealDocumentId) {
        this.othRealDocumentId = othRealDocumentId;
    }

    public String getOthRealBankCode() {
        return othRealBankCode;
    }

    public void setOthRealBankCode(String othRealBankCode) {
        this.othRealBankCode = othRealBankCode;
    }

    public String getOthRealTranName() {
        return othRealTranName;
    }

    public void setOthRealTranName(String othRealTranName) {
        this.othRealTranName = othRealTranName;
    }

    public String getOthRealTranAddr() {
        return othRealTranAddr;
    }

    public void setOthRealTranAddr(String othRealTranAddr) {
        this.othRealTranAddr = othRealTranAddr;
    }

    public String getOthRealBranchRegionCode() {
        return othRealBranchRegionCode;
    }

    public void setOthRealBranchRegionCode(String othRealBranchRegionCode) {
        this.othRealBranchRegionCode = othRealBranchRegionCode;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLastChangeUserId() {
        return lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
    }

    public String getLastChangeTime() {
        return lastChangeTime;
    }

    public void setLastChangeTime(String lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}