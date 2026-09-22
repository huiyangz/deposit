package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PtPaymentTranHist {
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 渠道子流水号 */
    private String channelSubSeqNo;
    /** 渠道 */
    private String channel;
    /** 交易参考号 */
    private String reference;
    /** 支付操作类型 */
    private String ptOperateType;
    /** 交易方向 */
    private String direction;
    /** 记账种类 */
    private String acglFlag;
    /** 记账步骤 */
    private Integer settleStep;
    /** 交易日期 */
    private Date tranDate;
    /** 交易机构号 */
    private String tranBranch;
    /** 交易类型 */
    private String tranType;
    /** 借贷标志 */
    private String crDrInd;
    /** 客户号 */
    private String clientNo;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 币种 */
    private String ccy;
    /** 序号 */
    private String seqNo;
    /** 产品类型 */
    private String prodType;
    /** 账户名称 */
    private String acctName;
    /** 账户开立行行号 */
    private String acctBranch;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 凭证类型 */
    private String docType;
    /** 凭证号 */
    private String voucherNo;
    /** 票据类型 */
    private String billType;
    /** 票据号码 */
    private String billNo;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 费用金额 */
    private BigDecimal feeAmt;
    /** 对手银行行号 */
    private String othBankCode;
    /** 对手银行名称 */
    private String othBankName;
    /** 他行账号 */
    private String contraBaseAcctNo;
    /** 他行账户名称 */
    private String contraAcctName;
    /** 结算编号 */
    private String settleNo;
    /** 限制编号 */
    private String resSeqNo;
    /** 受托支付编号 */
    private String trustedPayNo;
    /** 原始交易参考号 */
    private String origReference;
    /** 对账日期 */
    private Date collateDate;
    /** 账户支付状态 */
    private String acctPaymentStatus;
    /** 入账成功标志 */
    private String entrySuccessFlag;
    /** 挂账状态 */
    private String hangStatus;
    /** 响应状态编码 */
    private String retCode;
    /** 服务状态描述 */
    private String retMsg;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 交易柜员号 */
    private String userId;
    /** 法人 */
    private String company;
    /** 对账批次号 */
    private String collateBatchNo;
    /** 挂账编号 */
    private String hangSeqNo;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public String getChannelSubSeqNo() {
        return channelSubSeqNo;
    }

    public void setChannelSubSeqNo(String channelSubSeqNo) {
        this.channelSubSeqNo = channelSubSeqNo;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPtOperateType() {
        return ptOperateType;
    }

    public void setPtOperateType(String ptOperateType) {
        this.ptOperateType = ptOperateType;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getAcglFlag() {
        return acglFlag;
    }

    public void setAcglFlag(String acglFlag) {
        this.acglFlag = acglFlag;
    }

    public Integer getSettleStep() {
        return settleStep;
    }

    public void setSettleStep(Integer settleStep) {
        this.settleStep = settleStep;
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

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(String crDrInd) {
        this.crDrInd = crDrInd;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(String acctBranch) {
        this.acctBranch = acctBranch;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public BigDecimal getFeeAmt() {
        return feeAmt;
    }

    public void setFeeAmt(BigDecimal feeAmt) {
        this.feeAmt = feeAmt;
    }

    public String getOthBankCode() {
        return othBankCode;
    }

    public void setOthBankCode(String othBankCode) {
        this.othBankCode = othBankCode;
    }

    public String getOthBankName() {
        return othBankName;
    }

    public void setOthBankName(String othBankName) {
        this.othBankName = othBankName;
    }

    public String getContraBaseAcctNo() {
        return contraBaseAcctNo;
    }

    public void setContraBaseAcctNo(String contraBaseAcctNo) {
        this.contraBaseAcctNo = contraBaseAcctNo;
    }

    public String getContraAcctName() {
        return contraAcctName;
    }

    public void setContraAcctName(String contraAcctName) {
        this.contraAcctName = contraAcctName;
    }

    public String getSettleNo() {
        return settleNo;
    }

    public void setSettleNo(String settleNo) {
        this.settleNo = settleNo;
    }

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
    }

    public String getTrustedPayNo() {
        return trustedPayNo;
    }

    public void setTrustedPayNo(String trustedPayNo) {
        this.trustedPayNo = trustedPayNo;
    }

    public String getOrigReference() {
        return origReference;
    }

    public void setOrigReference(String origReference) {
        this.origReference = origReference;
    }

    public Date getCollateDate() {
        return collateDate;
    }

    public void setCollateDate(Date collateDate) {
        this.collateDate = collateDate;
    }

    public String getAcctPaymentStatus() {
        return acctPaymentStatus;
    }

    public void setAcctPaymentStatus(String acctPaymentStatus) {
        this.acctPaymentStatus = acctPaymentStatus;
    }

    public String getEntrySuccessFlag() {
        return entrySuccessFlag;
    }

    public void setEntrySuccessFlag(String entrySuccessFlag) {
        this.entrySuccessFlag = entrySuccessFlag;
    }

    public String getHangStatus() {
        return hangStatus;
    }

    public void setHangStatus(String hangStatus) {
        this.hangStatus = hangStatus;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
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

    public String getCollateBatchNo() {
        return collateBatchNo;
    }

    public void setCollateBatchNo(String collateBatchNo) {
        this.collateBatchNo = collateBatchNo;
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
}