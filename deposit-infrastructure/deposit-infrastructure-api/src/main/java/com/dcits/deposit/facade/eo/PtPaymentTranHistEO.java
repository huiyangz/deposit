package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctPaymentStatus;
import com.dcits.deposit.enums.AcglFlag;
import com.dcits.deposit.enums.BillType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.Direction;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.HangStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PtPaymentTranHistEO {
    /** 渠道流水号 */
    @NotNull
    private String channelSeqNo;
    /** 渠道子流水号 */
    @NotNull
    private String channelSubSeqNo;
    /** 渠道 */
    private SourceType channel;
    /** 交易参考号 */
    private String reference;
    /** 支付操作类型 */
    private String ptOperateType;
    /** 交易方向 */
    private Direction direction;
    /** 记账种类 */
    private AcglFlag acglFlag;
    /** 记账步骤 */
    private Integer settleStep;
    /** 交易日期 */
    @NotNull
    private java.util.Date tranDate;
    /** 交易机构号 */
    private AcctBranch tranBranch;
    /** 交易类型 */
    private TranType tranType;
    /** 借贷标志 */
    private CrDrInd crDrInd;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 币种 */
    private AcctCcy ccy;
    /** 序号 */
    private String seqNo;
    /** 产品类型 */
    private String prodType;
    /** 账户名称 */
    private String acctName;
    /** 账户开立行行号 */
    private AcctBranch acctBranch;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 凭证类型 */
    private DocType docType;
    /** 凭证号 */
    private String voucherNo;
    /** 票据类型 */
    private BillType billType;
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
    private java.util.Date collateDate;
    /** 账户支付状态 */
    private AcctPaymentStatus acctPaymentStatus;
    /** 入账成功标志 */
    private IndividualFlag entrySuccessFlag;
    /** 挂账状态 */
    private HangStatus hangStatus;
    /** 响应状态编码 */
    private String retCode;
    /** 服务状态描述 */
    private String retMsg;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 交易柜员号 */
    private String userId;
    /** 法人 */
    private Company company;
    /** 对账批次号 */
    private String collateBatchNo;
    /** 挂账编号 */
    private String hangSeqNo;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;

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

    public SourceType getChannel() {
        return channel;
    }

    public void setChannel(SourceType channel) {
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public AcglFlag getAcglFlag() {
        return acglFlag;
    }

    public void setAcglFlag(AcglFlag acglFlag) {
        this.acglFlag = acglFlag;
    }

    public Integer getSettleStep() {
        return settleStep;
    }

    public void setSettleStep(Integer settleStep) {
        this.settleStep = settleStep;
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

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public CrDrInd getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(CrDrInd crDrInd) {
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

    public AcctCcy getCcy() {
        return ccy;
    }

    public void setCcy(AcctCcy ccy) {
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

    public AcctBranch getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(AcctBranch acctBranch) {
        this.acctBranch = acctBranch;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public BillType getBillType() {
        return billType;
    }

    public void setBillType(BillType billType) {
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

    public java.util.Date getCollateDate() {
        return collateDate;
    }

    public void setCollateDate(java.util.Date collateDate) {
        this.collateDate = collateDate;
    }

    public AcctPaymentStatus getAcctPaymentStatus() {
        return acctPaymentStatus;
    }

    public void setAcctPaymentStatus(AcctPaymentStatus acctPaymentStatus) {
        this.acctPaymentStatus = acctPaymentStatus;
    }

    public IndividualFlag getEntrySuccessFlag() {
        return entrySuccessFlag;
    }

    public void setEntrySuccessFlag(IndividualFlag entrySuccessFlag) {
        this.entrySuccessFlag = entrySuccessFlag;
    }

    public HangStatus getHangStatus() {
        return hangStatus;
    }

    public void setHangStatus(HangStatus hangStatus) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
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

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}