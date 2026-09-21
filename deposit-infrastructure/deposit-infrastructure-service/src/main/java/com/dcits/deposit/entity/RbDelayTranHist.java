package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbDelayTranHist {
    /** 序号 */
    private String seqNo;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 限制编号 */
    private String resSeqNo;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 卡号 */
    private String cardNo;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 账户币种 */
    private String acctCcy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 产品类型 */
    private String prodType;
    /** 客户号 */
    private String clientNo;
    /** 客户名称 */
    private String clientName;
    /** 对手账户内部键 */
    private Integer othInternalKey;
    /** 对手卡号 */
    private String othCardNo;
    /** 对手账号 */
    private String othBaseAcctNo;
    /** 对手账户币种 */
    private String othAcctCcy;
    /** 对方账户序号 */
    private String othAcctSeqNo;
    /** 对手产品编号 */
    private String othProdType;
    /** 对手账户名称 */
    private String othAcctName;
    /** 对方账户描述 */
    private String othAcctDesc;
    /** 单位结算卡转账标志 */
    private String settleCardFlag;
    /** 币种 */
    private String ccy;
    /** 到账方式 */
    private String tranMethod;
    /** 延迟到账发起交易时间 */
    private String signTimestamp;
    /** 交易类型 */
    private String tranType;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 交易日期 */
    private Date tranDate;
    /** 交易机构号 */
    private String tranBranch;
    /** 凭证类型 */
    private String docType;
    /** 凭证前缀编码 */
    private String prefix;
    /** 凭证号 */
    private String voucherNo;
    /** 到账状态 */
    private String arrivalStatus;
    /** 交易参考号 */
    private String reference;
    /** 渠道类型 */
    private String sourceType;
    /** 结售汇收入方交易编码 */
    private String exchangeTranCode;
    /** 结售汇支出方交易编码 */
    private String exchangeTranCodet;
    /** 交易描述 */
    private String tranDesc;
    /** 交易附言 */
    private String tranNote;
    /** 现金项目编号 */
    private String cashItem;
    /** 摘要 */
    private String narrative;
    /** 代办人名称 */
    private String commissionClientName;
    /** 代办人电话 */
    private String commissionClientTel;
    /** 付款单位名称 */
    private String payUnit;
    /** 取消原因 */
    private String cancelReason;
    /** 终端编号 */
    private String terminalId;
    /** 卡二磁道 */
    private String track2;
    /** 卡三磁道 */
    private String track3;
    /** 授权柜员号 */
    private String authUserId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 交易柜员号 */
    private String userId;
    /** 法人 */
    private String company;
    /** 子流水号 */
    private String subSeqNo;
    /** 定期产品转让转入账号 */
    private String innerBaseAcctNo;
    /** 内部户产品编号 */
    private String innerProdType;
    /** 内部户序号 */
    private String innerAcctSeqNo;
    /** 内部户币种 */
    private String innerAcctCcy;
    /** 内部户账户内部键值 */
    private Integer innerInternalKey;
    /** 内部户名称 */
    private String innerAcctName;
    /** 内部户客户号 */
    private String innerClientNo;
    /** 挂账编号 */
    private String hangSeqNo;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 对手客户号 */
    private String othClientNo;
    /** 银行内外标志 */
    private String bankInOut;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
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

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getOthInternalKey() {
        return othInternalKey;
    }

    public void setOthInternalKey(Integer othInternalKey) {
        this.othInternalKey = othInternalKey;
    }

    public String getOthCardNo() {
        return othCardNo;
    }

    public void setOthCardNo(String othCardNo) {
        this.othCardNo = othCardNo;
    }

    public String getOthBaseAcctNo() {
        return othBaseAcctNo;
    }

    public void setOthBaseAcctNo(String othBaseAcctNo) {
        this.othBaseAcctNo = othBaseAcctNo;
    }

    public String getOthAcctCcy() {
        return othAcctCcy;
    }

    public void setOthAcctCcy(String othAcctCcy) {
        this.othAcctCcy = othAcctCcy;
    }

    public String getOthAcctSeqNo() {
        return othAcctSeqNo;
    }

    public void setOthAcctSeqNo(String othAcctSeqNo) {
        this.othAcctSeqNo = othAcctSeqNo;
    }

    public String getOthProdType() {
        return othProdType;
    }

    public void setOthProdType(String othProdType) {
        this.othProdType = othProdType;
    }

    public String getOthAcctName() {
        return othAcctName;
    }

    public void setOthAcctName(String othAcctName) {
        this.othAcctName = othAcctName;
    }

    public String getOthAcctDesc() {
        return othAcctDesc;
    }

    public void setOthAcctDesc(String othAcctDesc) {
        this.othAcctDesc = othAcctDesc;
    }

    public String getSettleCardFlag() {
        return settleCardFlag;
    }

    public void setSettleCardFlag(String settleCardFlag) {
        this.settleCardFlag = settleCardFlag;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getTranMethod() {
        return tranMethod;
    }

    public void setTranMethod(String tranMethod) {
        this.tranMethod = tranMethod;
    }

    public String getSignTimestamp() {
        return signTimestamp;
    }

    public void setSignTimestamp(String signTimestamp) {
        this.signTimestamp = signTimestamp;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
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

    public String getArrivalStatus() {
        return arrivalStatus;
    }

    public void setArrivalStatus(String arrivalStatus) {
        this.arrivalStatus = arrivalStatus;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
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

    public String getTranDesc() {
        return tranDesc;
    }

    public void setTranDesc(String tranDesc) {
        this.tranDesc = tranDesc;
    }

    public String getTranNote() {
        return tranNote;
    }

    public void setTranNote(String tranNote) {
        this.tranNote = tranNote;
    }

    public String getCashItem() {
        return cashItem;
    }

    public void setCashItem(String cashItem) {
        this.cashItem = cashItem;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getCommissionClientName() {
        return commissionClientName;
    }

    public void setCommissionClientName(String commissionClientName) {
        this.commissionClientName = commissionClientName;
    }

    public String getCommissionClientTel() {
        return commissionClientTel;
    }

    public void setCommissionClientTel(String commissionClientTel) {
        this.commissionClientTel = commissionClientTel;
    }

    public String getPayUnit() {
        return payUnit;
    }

    public void setPayUnit(String payUnit) {
        this.payUnit = payUnit;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTrack2() {
        return track2;
    }

    public void setTrack2(String track2) {
        this.track2 = track2;
    }

    public String getTrack3() {
        return track3;
    }

    public void setTrack3(String track3) {
        this.track3 = track3;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
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

    public String getSubSeqNo() {
        return subSeqNo;
    }

    public void setSubSeqNo(String subSeqNo) {
        this.subSeqNo = subSeqNo;
    }

    public String getInnerBaseAcctNo() {
        return innerBaseAcctNo;
    }

    public void setInnerBaseAcctNo(String innerBaseAcctNo) {
        this.innerBaseAcctNo = innerBaseAcctNo;
    }

    public String getInnerProdType() {
        return innerProdType;
    }

    public void setInnerProdType(String innerProdType) {
        this.innerProdType = innerProdType;
    }

    public String getInnerAcctSeqNo() {
        return innerAcctSeqNo;
    }

    public void setInnerAcctSeqNo(String innerAcctSeqNo) {
        this.innerAcctSeqNo = innerAcctSeqNo;
    }

    public String getInnerAcctCcy() {
        return innerAcctCcy;
    }

    public void setInnerAcctCcy(String innerAcctCcy) {
        this.innerAcctCcy = innerAcctCcy;
    }

    public Integer getInnerInternalKey() {
        return innerInternalKey;
    }

    public void setInnerInternalKey(Integer innerInternalKey) {
        this.innerInternalKey = innerInternalKey;
    }

    public String getInnerAcctName() {
        return innerAcctName;
    }

    public void setInnerAcctName(String innerAcctName) {
        this.innerAcctName = innerAcctName;
    }

    public String getInnerClientNo() {
        return innerClientNo;
    }

    public void setInnerClientNo(String innerClientNo) {
        this.innerClientNo = innerClientNo;
    }

    public String getHangSeqNo() {
        return hangSeqNo;
    }

    public void setHangSeqNo(String hangSeqNo) {
        this.hangSeqNo = hangSeqNo;
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

    public String getOthClientNo() {
        return othClientNo;
    }

    public void setOthClientNo(String othClientNo) {
        this.othClientNo = othClientNo;
    }

    public String getBankInOut() {
        return bankInOut;
    }

    public void setBankInOut(String bankInOut) {
        this.bankInOut = bankInOut;
    }
}