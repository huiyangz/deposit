package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.ChargeWay;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.DiscType;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.FeeType;
import com.dcits.deposit.enums.OsdStatus;
import com.dcits.deposit.enums.RbBusAgreementType;
import com.dcits.deposit.enums.RollFreq;
import com.dcits.deposit.enums.TranBranch;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbBusOsdServChargeEO {
    /** 分润标志 */
    private String profitAllotFlag;
    /** 交易机构分润比例 */
    private BigDecimal tranBranchPercent;
    /** 收费账户内部键值 */
    private Integer chargeToInternalKey;
    /** 交易机构号 */
    @NotNull
    private TranBranch tranBranch;
    /** 账号 */
    private String baseAcctNo;
    /** 冲正日期 */
    private java.util.Date reversalDate;
    /** 费用折扣金额 */
    private BigDecimal discFeeAmt;
    /** 协议编号 */
    private String agreementId;
    /** 凭证数量 */
    private Integer voucherNum;
    /** 延期动账标志 */
    private String delayFlag;
    /** 收费币种 */
    private AcctCcy chargeToCcy;
    /** 单价 */
    private BigDecimal unitPrice;
    /** 利率折扣比例 */
    private BigDecimal discRate;
    /** 冲正授权柜员号 */
    private String reversalAuthUserId;
    /** 凭证类型 */
    private DocType docType;
    /** 税率 */
    private BigDecimal taxRate;
    /** 冲正标志 */
    private String reversalFlag;
    /** 生效日期 */
    @NotNull
    private java.util.Date effectDate;
    /** 原费用金额 */
    private BigDecimal origFeeAmt;
    /** 上一收费日期 */
    private java.util.Date lastChargeDate;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 冲正机构号 */
    private TranBranch reversalBranch;
    /** 费用币种 */
    private Ccy feeCcy;
    /** 凭证终止号码 */
    private String voucherEndNo;
    /** 交易收费金额 */
    private BigDecimal tranFeeAmt;
    /** 收费频率 */
    private RollFreq chargePeriodFreq;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 交易柜员号 */
    @NotNull
    private String userId;
    /** 对公存款合约类型 */
    private RbBusAgreementType rbBusAgreementType;
    /** 交易机构分润金额 */
    private BigDecimal tranProfitAmt;
    /** 收费账户序号 */
    private String chargeToAcctSeqNo;
    /** 收费账号 */
    private String chargeToBaseAcctNo;
    /** 主交易流水号 */
    private String primaryTranSeqNo;
    /** 账户名称 */
    private String acctName;
    /** 人工折扣金额 */
    private BigDecimal manualDiscFee;
    /** 对手业务编号 */
    private String othBusinessNo;
    /** 费用金额 */
    @NotNull
    private BigDecimal feeAmt;
    /** 对手名称 */
    private String othName;
    /** 费用摊销账户行比例 */
    private BigDecimal openBranchPercent;
    /** 税金 */
    private BigDecimal taxAmt;
    /** 收费日 */
    private String chargeDay;
    /** 回收金额 */
    private BigDecimal recAmt;
    /** 账户开立行行号 */
    private TranBranch acctBranch;
    /** 欠费状态 */
    private OsdStatus osdStatus;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 应收费序号 */
    @NotNull
    private String osdSeqNo;
    /** 税率类型编号 */
    private String taxTypeNo;
    /** 下一收费日期 */
    private java.util.Date nextChargeDate;
    /** 账户行分润金额 */
    private BigDecimal openProfitAmt;
    /** 凭证起始号码 */
    private String voucherStartNo;
    /** 折扣类型 */
    private DiscType discType;
    /** 凭证前缀编码 */
    private String prefix;
    /** 批处理收费合并标志 */
    private String batchFeeMergeFlag;
    /** 冲正柜员号 */
    private String reversalUserId;
    /** 交易日期 */
    @NotNull
    private java.util.Date tranDate;
    /** 费用类型 */
    @NotNull
    private FeeType feeType;
    /** 日终/联机标志 */
    @NotNull
    private String boInd;
    /** 收费方式 */
    private ChargeWay chargeWay;
    /** 客户类型 */
    private ClientType clientType;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 交易参考号 */
    private String reference;
    /** 收费账户产品编号 */
    private String chargeToProdNo;
    /** 序号 */
    private String seqNo;

    public String getProfitAllotFlag() {
        return profitAllotFlag;
    }

    public void setProfitAllotFlag(String profitAllotFlag) {
        this.profitAllotFlag = profitAllotFlag;
    }

    public BigDecimal getTranBranchPercent() {
        return tranBranchPercent;
    }

    public void setTranBranchPercent(BigDecimal tranBranchPercent) {
        this.tranBranchPercent = tranBranchPercent;
    }

    public Integer getChargeToInternalKey() {
        return chargeToInternalKey;
    }

    public void setChargeToInternalKey(Integer chargeToInternalKey) {
        this.chargeToInternalKey = chargeToInternalKey;
    }

    public TranBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(TranBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public java.util.Date getReversalDate() {
        return reversalDate;
    }

    public void setReversalDate(java.util.Date reversalDate) {
        this.reversalDate = reversalDate;
    }

    public BigDecimal getDiscFeeAmt() {
        return discFeeAmt;
    }

    public void setDiscFeeAmt(BigDecimal discFeeAmt) {
        this.discFeeAmt = discFeeAmt;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public Integer getVoucherNum() {
        return voucherNum;
    }

    public void setVoucherNum(Integer voucherNum) {
        this.voucherNum = voucherNum;
    }

    public String getDelayFlag() {
        return delayFlag;
    }

    public void setDelayFlag(String delayFlag) {
        this.delayFlag = delayFlag;
    }

    public AcctCcy getChargeToCcy() {
        return chargeToCcy;
    }

    public void setChargeToCcy(AcctCcy chargeToCcy) {
        this.chargeToCcy = chargeToCcy;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getDiscRate() {
        return discRate;
    }

    public void setDiscRate(BigDecimal discRate) {
        this.discRate = discRate;
    }

    public String getReversalAuthUserId() {
        return reversalAuthUserId;
    }

    public void setReversalAuthUserId(String reversalAuthUserId) {
        this.reversalAuthUserId = reversalAuthUserId;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getReversalFlag() {
        return reversalFlag;
    }

    public void setReversalFlag(String reversalFlag) {
        this.reversalFlag = reversalFlag;
    }

    public java.util.Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(java.util.Date effectDate) {
        this.effectDate = effectDate;
    }

    public BigDecimal getOrigFeeAmt() {
        return origFeeAmt;
    }

    public void setOrigFeeAmt(BigDecimal origFeeAmt) {
        this.origFeeAmt = origFeeAmt;
    }

    public java.util.Date getLastChargeDate() {
        return lastChargeDate;
    }

    public void setLastChargeDate(java.util.Date lastChargeDate) {
        this.lastChargeDate = lastChargeDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public TranBranch getReversalBranch() {
        return reversalBranch;
    }

    public void setReversalBranch(TranBranch reversalBranch) {
        this.reversalBranch = reversalBranch;
    }

    public Ccy getFeeCcy() {
        return feeCcy;
    }

    public void setFeeCcy(Ccy feeCcy) {
        this.feeCcy = feeCcy;
    }

    public String getVoucherEndNo() {
        return voucherEndNo;
    }

    public void setVoucherEndNo(String voucherEndNo) {
        this.voucherEndNo = voucherEndNo;
    }

    public BigDecimal getTranFeeAmt() {
        return tranFeeAmt;
    }

    public void setTranFeeAmt(BigDecimal tranFeeAmt) {
        this.tranFeeAmt = tranFeeAmt;
    }

    public RollFreq getChargePeriodFreq() {
        return chargePeriodFreq;
    }

    public void setChargePeriodFreq(RollFreq chargePeriodFreq) {
        this.chargePeriodFreq = chargePeriodFreq;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public RbBusAgreementType getRbBusAgreementType() {
        return rbBusAgreementType;
    }

    public void setRbBusAgreementType(RbBusAgreementType rbBusAgreementType) {
        this.rbBusAgreementType = rbBusAgreementType;
    }

    public BigDecimal getTranProfitAmt() {
        return tranProfitAmt;
    }

    public void setTranProfitAmt(BigDecimal tranProfitAmt) {
        this.tranProfitAmt = tranProfitAmt;
    }

    public String getChargeToAcctSeqNo() {
        return chargeToAcctSeqNo;
    }

    public void setChargeToAcctSeqNo(String chargeToAcctSeqNo) {
        this.chargeToAcctSeqNo = chargeToAcctSeqNo;
    }

    public String getChargeToBaseAcctNo() {
        return chargeToBaseAcctNo;
    }

    public void setChargeToBaseAcctNo(String chargeToBaseAcctNo) {
        this.chargeToBaseAcctNo = chargeToBaseAcctNo;
    }

    public String getPrimaryTranSeqNo() {
        return primaryTranSeqNo;
    }

    public void setPrimaryTranSeqNo(String primaryTranSeqNo) {
        this.primaryTranSeqNo = primaryTranSeqNo;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public BigDecimal getManualDiscFee() {
        return manualDiscFee;
    }

    public void setManualDiscFee(BigDecimal manualDiscFee) {
        this.manualDiscFee = manualDiscFee;
    }

    public String getOthBusinessNo() {
        return othBusinessNo;
    }

    public void setOthBusinessNo(String othBusinessNo) {
        this.othBusinessNo = othBusinessNo;
    }

    public BigDecimal getFeeAmt() {
        return feeAmt;
    }

    public void setFeeAmt(BigDecimal feeAmt) {
        this.feeAmt = feeAmt;
    }

    public String getOthName() {
        return othName;
    }

    public void setOthName(String othName) {
        this.othName = othName;
    }

    public BigDecimal getOpenBranchPercent() {
        return openBranchPercent;
    }

    public void setOpenBranchPercent(BigDecimal openBranchPercent) {
        this.openBranchPercent = openBranchPercent;
    }

    public BigDecimal getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(BigDecimal taxAmt) {
        this.taxAmt = taxAmt;
    }

    public String getChargeDay() {
        return chargeDay;
    }

    public void setChargeDay(String chargeDay) {
        this.chargeDay = chargeDay;
    }

    public BigDecimal getRecAmt() {
        return recAmt;
    }

    public void setRecAmt(BigDecimal recAmt) {
        this.recAmt = recAmt;
    }

    public TranBranch getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(TranBranch acctBranch) {
        this.acctBranch = acctBranch;
    }

    public OsdStatus getOsdStatus() {
        return osdStatus;
    }

    public void setOsdStatus(OsdStatus osdStatus) {
        this.osdStatus = osdStatus;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getOsdSeqNo() {
        return osdSeqNo;
    }

    public void setOsdSeqNo(String osdSeqNo) {
        this.osdSeqNo = osdSeqNo;
    }

    public String getTaxTypeNo() {
        return taxTypeNo;
    }

    public void setTaxTypeNo(String taxTypeNo) {
        this.taxTypeNo = taxTypeNo;
    }

    public java.util.Date getNextChargeDate() {
        return nextChargeDate;
    }

    public void setNextChargeDate(java.util.Date nextChargeDate) {
        this.nextChargeDate = nextChargeDate;
    }

    public BigDecimal getOpenProfitAmt() {
        return openProfitAmt;
    }

    public void setOpenProfitAmt(BigDecimal openProfitAmt) {
        this.openProfitAmt = openProfitAmt;
    }

    public String getVoucherStartNo() {
        return voucherStartNo;
    }

    public void setVoucherStartNo(String voucherStartNo) {
        this.voucherStartNo = voucherStartNo;
    }

    public DiscType getDiscType() {
        return discType;
    }

    public void setDiscType(DiscType discType) {
        this.discType = discType;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getBatchFeeMergeFlag() {
        return batchFeeMergeFlag;
    }

    public void setBatchFeeMergeFlag(String batchFeeMergeFlag) {
        this.batchFeeMergeFlag = batchFeeMergeFlag;
    }

    public String getReversalUserId() {
        return reversalUserId;
    }

    public void setReversalUserId(String reversalUserId) {
        this.reversalUserId = reversalUserId;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public FeeType getFeeType() {
        return feeType;
    }

    public void setFeeType(FeeType feeType) {
        this.feeType = feeType;
    }

    public String getBoInd() {
        return boInd;
    }

    public void setBoInd(String boInd) {
        this.boInd = boInd;
    }

    public ChargeWay getChargeWay() {
        return chargeWay;
    }

    public void setChargeWay(ChargeWay chargeWay) {
        this.chargeWay = chargeWay;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getChargeToProdNo() {
        return chargeToProdNo;
    }

    public void setChargeToProdNo(String chargeToProdNo) {
        this.chargeToProdNo = chargeToProdNo;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }
}