package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbBusDelayTransferDtl {
    /** 内部户序号 */
    private String innerAcctSeqNo;
    /** 限制编号 */
    private String resSeqNo;
    /** 现金项目编号 */
    private String cashItem;
    /** 摘要 */
    private String narrative;
    /** 定期产品转让转入账号 */
    private String innerBaseAcctNo;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 结售汇收入方交易编码 */
    private String exchangeTranCode;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 银行内外标志 */
    private String bankInOut;
    /** 币种 */
    private String ccy;
    /** 付款单位名称 */
    private String payUnit;
    /** 产品编号 */
    private String prodNo;
    /** 对手账户名称 */
    private String othAcctName;
    /** 客户名称 */
    private String clientName;
    /** 对手账户内部键 */
    private Integer othInternalKey;
    /** 凭证类型 */
    private String docType;
    /** 账号 */
    private String baseAcctNo;
    /** 到账方式 */
    private String tranMethod;
    /** 内部户客户号 */
    private String innerClientNo;
    /** 代办人电话 */
    private String commissionClientTel;
    /** 子流水号 */
    private String subSeqNo;
    /** 序号 */
    private String seqNo;
    /** 凭证号 */
    private String voucherNo;
    /** 交易附言 */
    private String tranNote;
    /** 凭证前缀编码 */
    private String prefix;
    /** 卡二磁道 */
    private String track2;
    /** 交易机构号 */
    private String tranBranch;
    /** 对手客户号 */
    private String othClientNo;
    /** 到账状态 */
    private String arrivalStatus;
    /** 对方账户描述 */
    private String othAcctDesc;
    /** 对手产品编号 */
    private String othProdNo;
    /** 内部户账户内部键值 */
    private Integer innerInternalKey;
    /** 卡三磁道 */
    private String track3;
    /** 内部户产品编号 */
    private String innerProdNo;
    /** 延迟到账发起交易时间 */
    private String signTimestamp;
    /** 交易参考号 */
    private String reference;
    /** 内部户名称 */
    private String innerAcctName;
    /** 对方账户序号 */
    private String othAcctSeqNo;
    /** 卡号 */
    private String cardNo;
    /** 对手卡号 */
    private String othCardNo;
    /** 取消原因 */
    private String cancelReason;
    /** 终端编号 */
    private String terminalId;
    /** 对手账号 */
    private String othBaseAcctNo;
    /** 对手账户币种 */
    private String othAcctCcy;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 挂账编号 */
    private String hangSeqNo;
    /** 单位结算卡转账标志 */
    private String settleCardFlag;
    /** 交易描述 */
    private String tranDesc;
    /** 账户序号 */
    private String acctSeqNo;
    /** 渠道类型 */
    private String sourceType;
    /** 内部户币种 */
    private String innerAcctCcy;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 代办人名称 */
    private String commissionClientName;
    /** 结售汇支出方交易编码 */
    private String exchangeTranCodet;
    /** 交易日期 */
    private Date tranDate;
    /** 账户币种 */
    private String acctCcy;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 交易类型 */
    private String tranType;

    public String getInnerAcctSeqNo() {
        return innerAcctSeqNo;
    }

    public void setInnerAcctSeqNo(String innerAcctSeqNo) {
        this.innerAcctSeqNo = innerAcctSeqNo;
    }

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
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

    public String getInnerBaseAcctNo() {
        return innerBaseAcctNo;
    }

    public void setInnerBaseAcctNo(String innerBaseAcctNo) {
        this.innerBaseAcctNo = innerBaseAcctNo;
    }

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public String getExchangeTranCode() {
        return exchangeTranCode;
    }

    public void setExchangeTranCode(String exchangeTranCode) {
        this.exchangeTranCode = exchangeTranCode;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public String getBankInOut() {
        return bankInOut;
    }

    public void setBankInOut(String bankInOut) {
        this.bankInOut = bankInOut;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getPayUnit() {
        return payUnit;
    }

    public void setPayUnit(String payUnit) {
        this.payUnit = payUnit;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getOthAcctName() {
        return othAcctName;
    }

    public void setOthAcctName(String othAcctName) {
        this.othAcctName = othAcctName;
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

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getTranMethod() {
        return tranMethod;
    }

    public void setTranMethod(String tranMethod) {
        this.tranMethod = tranMethod;
    }

    public String getInnerClientNo() {
        return innerClientNo;
    }

    public void setInnerClientNo(String innerClientNo) {
        this.innerClientNo = innerClientNo;
    }

    public String getCommissionClientTel() {
        return commissionClientTel;
    }

    public void setCommissionClientTel(String commissionClientTel) {
        this.commissionClientTel = commissionClientTel;
    }

    public String getSubSeqNo() {
        return subSeqNo;
    }

    public void setSubSeqNo(String subSeqNo) {
        this.subSeqNo = subSeqNo;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getTranNote() {
        return tranNote;
    }

    public void setTranNote(String tranNote) {
        this.tranNote = tranNote;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getTrack2() {
        return track2;
    }

    public void setTrack2(String track2) {
        this.track2 = track2;
    }

    public String getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(String tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getOthClientNo() {
        return othClientNo;
    }

    public void setOthClientNo(String othClientNo) {
        this.othClientNo = othClientNo;
    }

    public String getArrivalStatus() {
        return arrivalStatus;
    }

    public void setArrivalStatus(String arrivalStatus) {
        this.arrivalStatus = arrivalStatus;
    }

    public String getOthAcctDesc() {
        return othAcctDesc;
    }

    public void setOthAcctDesc(String othAcctDesc) {
        this.othAcctDesc = othAcctDesc;
    }

    public String getOthProdNo() {
        return othProdNo;
    }

    public void setOthProdNo(String othProdNo) {
        this.othProdNo = othProdNo;
    }

    public Integer getInnerInternalKey() {
        return innerInternalKey;
    }

    public void setInnerInternalKey(Integer innerInternalKey) {
        this.innerInternalKey = innerInternalKey;
    }

    public String getTrack3() {
        return track3;
    }

    public void setTrack3(String track3) {
        this.track3 = track3;
    }

    public String getInnerProdNo() {
        return innerProdNo;
    }

    public void setInnerProdNo(String innerProdNo) {
        this.innerProdNo = innerProdNo;
    }

    public String getSignTimestamp() {
        return signTimestamp;
    }

    public void setSignTimestamp(String signTimestamp) {
        this.signTimestamp = signTimestamp;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getInnerAcctName() {
        return innerAcctName;
    }

    public void setInnerAcctName(String innerAcctName) {
        this.innerAcctName = innerAcctName;
    }

    public String getOthAcctSeqNo() {
        return othAcctSeqNo;
    }

    public void setOthAcctSeqNo(String othAcctSeqNo) {
        this.othAcctSeqNo = othAcctSeqNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getOthCardNo() {
        return othCardNo;
    }

    public void setOthCardNo(String othCardNo) {
        this.othCardNo = othCardNo;
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

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getHangSeqNo() {
        return hangSeqNo;
    }

    public void setHangSeqNo(String hangSeqNo) {
        this.hangSeqNo = hangSeqNo;
    }

    public String getSettleCardFlag() {
        return settleCardFlag;
    }

    public void setSettleCardFlag(String settleCardFlag) {
        this.settleCardFlag = settleCardFlag;
    }

    public String getTranDesc() {
        return tranDesc;
    }

    public void setTranDesc(String tranDesc) {
        this.tranDesc = tranDesc;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getInnerAcctCcy() {
        return innerAcctCcy;
    }

    public void setInnerAcctCcy(String innerAcctCcy) {
        this.innerAcctCcy = innerAcctCcy;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getCommissionClientName() {
        return commissionClientName;
    }

    public void setCommissionClientName(String commissionClientName) {
        this.commissionClientName = commissionClientName;
    }

    public String getExchangeTranCodet() {
        return exchangeTranCodet;
    }

    public void setExchangeTranCodet(String exchangeTranCodet) {
        this.exchangeTranCodet = exchangeTranCodet;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(String acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }
}