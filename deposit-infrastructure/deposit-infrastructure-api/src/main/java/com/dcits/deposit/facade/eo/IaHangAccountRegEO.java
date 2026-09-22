package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.HangDealType;
import com.dcits.deposit.enums.HangStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class IaHangAccountRegEO {
    /** 挂账编号 */
    @NotNull
    private String hangSeqNo;
    /** 追加挂账编号 */
    @NotNull
    private String subHangSeqNo;
    /** 挂账金额 */
    private BigDecimal hangAmt;
    /** 挂账余额 */
    private BigDecimal hangBal;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 币种 */
    private AcctCcy ccy;
    /** 挂销账处理类型 */
    private HangDealType hangDealType;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 挂账状态 */
    private HangStatus hangStatus;
    /** 挂销账时间 */
    private String hangWriteOffTime;
    /** 挂账到期日期 */
    private java.util.Date hangEndDate;
    /** 借贷标志 */
    private CrDrInd crDrInd;
    /** 交易机构号 */
    private AcctBranch tranBranch;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 摘要 */
    private String narrative;
    /** 挂账原因 */
    private String hangReason;
    /** 对手账号 */
    private String othBaseAcctNo;
    /** 对手账户名称 */
    private String othAcctName;
    /** 对方账户开户行行号 */
    private AcctBranch othBranch;
    /** 对手行标志 */
    private IndividualFlag othBankFlag;
    /** 交易参考号 */
    private String reference;
    /** 真实对方金融机构名称 */
    private String othRealBankName;
    /** 实际对手账号 */
    private String othRealBaseAcctNo;
    /** 实际对手产品编号 */
    private String othRealProdType;
    /** 实际对手证件类型 */
    private DocumentType othRealDocumentType;
    /** 实际对手身份证件号码 */
    private String othRealDocumentId;
    /** 实际对手机构号 */
    private String othRealBankCode;
    /** 实际对手交易名称 */
    private String othRealTranName;
    /** 实际对手交易地址 */
    private String othRealTranAddr;
    /** 实际对手机构行政区划代码 */
    private OthBranchRegionalismCode othRealBranchRegionCode;
    /** 交易柜员号 */
    private String userId;
    /** 授权柜员号 */
    private String authUserId;
    /** 法人 */
    private Company company;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 上次变更时间 */
    private String lastChangeTime;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;

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

    public AcctCcy getCcy() {
        return ccy;
    }

    public void setCcy(AcctCcy ccy) {
        this.ccy = ccy;
    }

    public HangDealType getHangDealType() {
        return hangDealType;
    }

    public void setHangDealType(HangDealType hangDealType) {
        this.hangDealType = hangDealType;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public HangStatus getHangStatus() {
        return hangStatus;
    }

    public void setHangStatus(HangStatus hangStatus) {
        this.hangStatus = hangStatus;
    }

    public String getHangWriteOffTime() {
        return hangWriteOffTime;
    }

    public void setHangWriteOffTime(String hangWriteOffTime) {
        this.hangWriteOffTime = hangWriteOffTime;
    }

    public java.util.Date getHangEndDate() {
        return hangEndDate;
    }

    public void setHangEndDate(java.util.Date hangEndDate) {
        this.hangEndDate = hangEndDate;
    }

    public CrDrInd getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(CrDrInd crDrInd) {
        this.crDrInd = crDrInd;
    }

    public AcctBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(AcctBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
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

    public AcctBranch getOthBranch() {
        return othBranch;
    }

    public void setOthBranch(AcctBranch othBranch) {
        this.othBranch = othBranch;
    }

    public IndividualFlag getOthBankFlag() {
        return othBankFlag;
    }

    public void setOthBankFlag(IndividualFlag othBankFlag) {
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

    public DocumentType getOthRealDocumentType() {
        return othRealDocumentType;
    }

    public void setOthRealDocumentType(DocumentType othRealDocumentType) {
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

    public OthBranchRegionalismCode getOthRealBranchRegionCode() {
        return othRealBranchRegionCode;
    }

    public void setOthRealBranchRegionCode(OthBranchRegionalismCode othRealBranchRegionCode) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
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

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}