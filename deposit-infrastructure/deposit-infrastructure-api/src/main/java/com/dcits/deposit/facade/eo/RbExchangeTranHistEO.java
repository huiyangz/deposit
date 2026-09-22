package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.BaseQuoteType;
import com.dcits.deposit.enums.BaseRateType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CouponRateType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.ExchangeTranStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.QuoteType;
import com.dcits.deposit.enums.RateType;
import com.dcits.deposit.enums.SellBuyInd;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.UncStatus;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbExchangeTranHistEO {
    /** 序号 */
    @NotNull
    private String seqNo;
    /** 现金交易流水号 */
    private String cashSeqNo;
    /** TAE子流水号 */
    private String taeSubSeqNo;
    /** 结售汇序号 */
    private String exchangeSeqNo;
    /** 贷方账户主键 */
    private Integer depositInternalKey;
    /** 结售汇贷方账号 */
    private String depositBaseAcctNo;
    /** 贷方账户序列号 */
    private String depositAcctSeqNo;
    /** 贷方账户产品类型名称 */
    private String depositProdType;
    /** 贷方余额类型 */
    private BalType depositBalanceType;
    /** 贷方交易序号 */
    private String depositSeqNo;
    /** 借方账户内部键 */
    private Integer withdrawInternalKey;
    /** 借方账户账号 */
    private String withdrawBaseAcctNo;
    /** 借方账户币种 */
    private AcctCcy withdrawAcctCcy;
    /** 结售汇借方账户序号 */
    private String withdrawAcctSeqNo;
    /** 借方账户产品类型 */
    private String withdrawProdType;
    /** 借方余额类型 */
    private BalType withdrawBalanceType;
    /** 借方交易序号 */
    private String withdrawSeqNo;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 交易类型 */
    private TranType tranType;
    /** 交易日期 */
    @NotNull
    private java.util.Date tranDate;
    /** 交易机构号 */
    private AcctBranch tranBranch;
    /** 冲正日期 */
    private java.util.Date reversalDate;
    /** 冲正交易类型 */
    private TranType reversalTranType;
    /** 结售汇交易状态 */
    private ExchangeTranStatus exchangeTranStatus;
    /** 买卖固定方类型 */
    private SellBuyInd sellBuyInd;
    /** 报价类型 */
    private QuoteType quoteType;
    /** 汇率类型 */
    private RateType rateType;
    /** 买入金额 */
    private BigDecimal buyAmount;
    /** 买入币种 */
    private AcctCcy buyCcy;
    /** 结售汇买方汇率 */
    private BigDecimal buyRate;
    /** 卖出币种 */
    private AcctCcy sellCcy;
    /** 卖出金额 */
    private BigDecimal sellAmount;
    /** 卖方汇率 */
    private BigDecimal sellRate;
    /** 执行汇率 */
    private BigDecimal exchRate;
    /** 浮动利率 */
    private BigDecimal floatRate;
    /** 基础报价方式 */
    private BaseQuoteType baseQuoteType;
    /** 基础汇率类型 */
    private BaseRateType baseRateType;
    /** 基础汇率 */
    private BigDecimal baseRate;
    /** 基础等值金额 */
    private BigDecimal baseEquivAmt;
    /** 交叉汇率 */
    private BigDecimal crossRate;
    /** 交叉汇率属性 */
    private String crossRateAttr;
    /** 平盘交叉汇率 */
    private BigDecimal uncCrossRate;
    /** 结售汇内部汇率 */
    private BigDecimal innerRate;
    /** 找零等值金额 */
    private BigDecimal changeBaseEquivAmt;
    /** 找零人民币金额 */
    private BigDecimal changeCnyAmount;
    /** 外币找零汇率 */
    private BigDecimal changeRate;
    /** 找零基础报价类型 */
    private BaseQuoteType changeBaseQuoteType;
    /** 外币找零报价类型 */
    private BaseQuoteType changeQuoteType;
    /** 外币找零汇率类型 */
    private RateType changeRateType;
    /** 交易参考号 */
    private String reference;
    /** 跟踪参考号 */
    private String traceRefNo;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 银行交易序号 */
    private String bankSeqNo;
    /** 备注 */
    private String remark;
    /** 源模块 */
    private SourceModule sourceModule;
    /** 终端编号 */
    private String terminalId;
    /** 跟踪编码 */
    private String traceRefCode;
    /** 复核日期 */
    private java.util.Date approvalDate;
    /** 记账日期 */
    private java.util.Date valueDate;
    /** 现金凭证预约复核柜员号 */
    private String apprUserId;
    /** 复核授权柜员号 */
    private String apprAuthUserId;
    /** 交易柜员号 */
    private String userId;
    /** 授权柜员号 */
    private String authUserId;
    /** 冲正授权柜员号 */
    private String reversalAuthUserId;
    /** 冲正柜员号 */
    private String reversalUserId;
    /** 利润中心 */
    private ProfitCenter profitCenter;
    /** 外币系统内平盘控制金额 */
    private BigDecimal fcyCtrlIbuncAmt;
    /** 平盘状态 */
    private UncStatus uncStatus;
    /** 系统内平盘流水号 */
    private String ibuncReference;
    /** 交易市场平盘流水号 */
    private String obuncReference;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 买入平盘汇率 */
    private BigDecimal buyUncRate;
    /** 国籍 */
    private IssCountry countryLoc;
    /** 优惠券汇率类型 */
    private CouponRateType couponRateType;
    /** 生效日期 */
    private java.util.Date effectDate;
    /** 生效时间 */
    private String effectTime;
    /** 浮动点差 */
    private BigDecimal floatPoint;
    /** 尾零处理标志 */
    private IndividualFlag minAmtFlag;
    /** 结售汇卖出平盘汇率 */
    private BigDecimal sellUncRate;
    /** 归属机构号 */
    private AcctBranch branch;
    /** 证件号码 */
    private String documentId;
    /** 证件类型 */
    private DocumentType documentType;
    /** 地区码 */
    private String areaCode;
    /** 客户名称 */
    private String clientName;
    /** 对私客户标志 */
    private IndividualFlag isIndividual;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getCashSeqNo() {
        return cashSeqNo;
    }

    public void setCashSeqNo(String cashSeqNo) {
        this.cashSeqNo = cashSeqNo;
    }

    public String getTaeSubSeqNo() {
        return taeSubSeqNo;
    }

    public void setTaeSubSeqNo(String taeSubSeqNo) {
        this.taeSubSeqNo = taeSubSeqNo;
    }

    public String getExchangeSeqNo() {
        return exchangeSeqNo;
    }

    public void setExchangeSeqNo(String exchangeSeqNo) {
        this.exchangeSeqNo = exchangeSeqNo;
    }

    public Integer getDepositInternalKey() {
        return depositInternalKey;
    }

    public void setDepositInternalKey(Integer depositInternalKey) {
        this.depositInternalKey = depositInternalKey;
    }

    public String getDepositBaseAcctNo() {
        return depositBaseAcctNo;
    }

    public void setDepositBaseAcctNo(String depositBaseAcctNo) {
        this.depositBaseAcctNo = depositBaseAcctNo;
    }

    public String getDepositAcctSeqNo() {
        return depositAcctSeqNo;
    }

    public void setDepositAcctSeqNo(String depositAcctSeqNo) {
        this.depositAcctSeqNo = depositAcctSeqNo;
    }

    public String getDepositProdType() {
        return depositProdType;
    }

    public void setDepositProdType(String depositProdType) {
        this.depositProdType = depositProdType;
    }

    public BalType getDepositBalanceType() {
        return depositBalanceType;
    }

    public void setDepositBalanceType(BalType depositBalanceType) {
        this.depositBalanceType = depositBalanceType;
    }

    public String getDepositSeqNo() {
        return depositSeqNo;
    }

    public void setDepositSeqNo(String depositSeqNo) {
        this.depositSeqNo = depositSeqNo;
    }

    public Integer getWithdrawInternalKey() {
        return withdrawInternalKey;
    }

    public void setWithdrawInternalKey(Integer withdrawInternalKey) {
        this.withdrawInternalKey = withdrawInternalKey;
    }

    public String getWithdrawBaseAcctNo() {
        return withdrawBaseAcctNo;
    }

    public void setWithdrawBaseAcctNo(String withdrawBaseAcctNo) {
        this.withdrawBaseAcctNo = withdrawBaseAcctNo;
    }

    public AcctCcy getWithdrawAcctCcy() {
        return withdrawAcctCcy;
    }

    public void setWithdrawAcctCcy(AcctCcy withdrawAcctCcy) {
        this.withdrawAcctCcy = withdrawAcctCcy;
    }

    public String getWithdrawAcctSeqNo() {
        return withdrawAcctSeqNo;
    }

    public void setWithdrawAcctSeqNo(String withdrawAcctSeqNo) {
        this.withdrawAcctSeqNo = withdrawAcctSeqNo;
    }

    public String getWithdrawProdType() {
        return withdrawProdType;
    }

    public void setWithdrawProdType(String withdrawProdType) {
        this.withdrawProdType = withdrawProdType;
    }

    public BalType getWithdrawBalanceType() {
        return withdrawBalanceType;
    }

    public void setWithdrawBalanceType(BalType withdrawBalanceType) {
        this.withdrawBalanceType = withdrawBalanceType;
    }

    public String getWithdrawSeqNo() {
        return withdrawSeqNo;
    }

    public void setWithdrawSeqNo(String withdrawSeqNo) {
        this.withdrawSeqNo = withdrawSeqNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
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

    public java.util.Date getReversalDate() {
        return reversalDate;
    }

    public void setReversalDate(java.util.Date reversalDate) {
        this.reversalDate = reversalDate;
    }

    public TranType getReversalTranType() {
        return reversalTranType;
    }

    public void setReversalTranType(TranType reversalTranType) {
        this.reversalTranType = reversalTranType;
    }

    public ExchangeTranStatus getExchangeTranStatus() {
        return exchangeTranStatus;
    }

    public void setExchangeTranStatus(ExchangeTranStatus exchangeTranStatus) {
        this.exchangeTranStatus = exchangeTranStatus;
    }

    public SellBuyInd getSellBuyInd() {
        return sellBuyInd;
    }

    public void setSellBuyInd(SellBuyInd sellBuyInd) {
        this.sellBuyInd = sellBuyInd;
    }

    public QuoteType getQuoteType() {
        return quoteType;
    }

    public void setQuoteType(QuoteType quoteType) {
        this.quoteType = quoteType;
    }

    public RateType getRateType() {
        return rateType;
    }

    public void setRateType(RateType rateType) {
        this.rateType = rateType;
    }

    public BigDecimal getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(BigDecimal buyAmount) {
        this.buyAmount = buyAmount;
    }

    public AcctCcy getBuyCcy() {
        return buyCcy;
    }

    public void setBuyCcy(AcctCcy buyCcy) {
        this.buyCcy = buyCcy;
    }

    public BigDecimal getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(BigDecimal buyRate) {
        this.buyRate = buyRate;
    }

    public AcctCcy getSellCcy() {
        return sellCcy;
    }

    public void setSellCcy(AcctCcy sellCcy) {
        this.sellCcy = sellCcy;
    }

    public BigDecimal getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(BigDecimal sellAmount) {
        this.sellAmount = sellAmount;
    }

    public BigDecimal getSellRate() {
        return sellRate;
    }

    public void setSellRate(BigDecimal sellRate) {
        this.sellRate = sellRate;
    }

    public BigDecimal getExchRate() {
        return exchRate;
    }

    public void setExchRate(BigDecimal exchRate) {
        this.exchRate = exchRate;
    }

    public BigDecimal getFloatRate() {
        return floatRate;
    }

    public void setFloatRate(BigDecimal floatRate) {
        this.floatRate = floatRate;
    }

    public BaseQuoteType getBaseQuoteType() {
        return baseQuoteType;
    }

    public void setBaseQuoteType(BaseQuoteType baseQuoteType) {
        this.baseQuoteType = baseQuoteType;
    }

    public BaseRateType getBaseRateType() {
        return baseRateType;
    }

    public void setBaseRateType(BaseRateType baseRateType) {
        this.baseRateType = baseRateType;
    }

    public BigDecimal getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(BigDecimal baseRate) {
        this.baseRate = baseRate;
    }

    public BigDecimal getBaseEquivAmt() {
        return baseEquivAmt;
    }

    public void setBaseEquivAmt(BigDecimal baseEquivAmt) {
        this.baseEquivAmt = baseEquivAmt;
    }

    public BigDecimal getCrossRate() {
        return crossRate;
    }

    public void setCrossRate(BigDecimal crossRate) {
        this.crossRate = crossRate;
    }

    public String getCrossRateAttr() {
        return crossRateAttr;
    }

    public void setCrossRateAttr(String crossRateAttr) {
        this.crossRateAttr = crossRateAttr;
    }

    public BigDecimal getUncCrossRate() {
        return uncCrossRate;
    }

    public void setUncCrossRate(BigDecimal uncCrossRate) {
        this.uncCrossRate = uncCrossRate;
    }

    public BigDecimal getInnerRate() {
        return innerRate;
    }

    public void setInnerRate(BigDecimal innerRate) {
        this.innerRate = innerRate;
    }

    public BigDecimal getChangeBaseEquivAmt() {
        return changeBaseEquivAmt;
    }

    public void setChangeBaseEquivAmt(BigDecimal changeBaseEquivAmt) {
        this.changeBaseEquivAmt = changeBaseEquivAmt;
    }

    public BigDecimal getChangeCnyAmount() {
        return changeCnyAmount;
    }

    public void setChangeCnyAmount(BigDecimal changeCnyAmount) {
        this.changeCnyAmount = changeCnyAmount;
    }

    public BigDecimal getChangeRate() {
        return changeRate;
    }

    public void setChangeRate(BigDecimal changeRate) {
        this.changeRate = changeRate;
    }

    public BaseQuoteType getChangeBaseQuoteType() {
        return changeBaseQuoteType;
    }

    public void setChangeBaseQuoteType(BaseQuoteType changeBaseQuoteType) {
        this.changeBaseQuoteType = changeBaseQuoteType;
    }

    public BaseQuoteType getChangeQuoteType() {
        return changeQuoteType;
    }

    public void setChangeQuoteType(BaseQuoteType changeQuoteType) {
        this.changeQuoteType = changeQuoteType;
    }

    public RateType getChangeRateType() {
        return changeRateType;
    }

    public void setChangeRateType(RateType changeRateType) {
        this.changeRateType = changeRateType;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTraceRefNo() {
        return traceRefNo;
    }

    public void setTraceRefNo(String traceRefNo) {
        this.traceRefNo = traceRefNo;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public String getBankSeqNo() {
        return bankSeqNo;
    }

    public void setBankSeqNo(String bankSeqNo) {
        this.bankSeqNo = bankSeqNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public SourceModule getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(SourceModule sourceModule) {
        this.sourceModule = sourceModule;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTraceRefCode() {
        return traceRefCode;
    }

    public void setTraceRefCode(String traceRefCode) {
        this.traceRefCode = traceRefCode;
    }

    public java.util.Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(java.util.Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public java.util.Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(java.util.Date valueDate) {
        this.valueDate = valueDate;
    }

    public String getApprUserId() {
        return apprUserId;
    }

    public void setApprUserId(String apprUserId) {
        this.apprUserId = apprUserId;
    }

    public String getApprAuthUserId() {
        return apprAuthUserId;
    }

    public void setApprAuthUserId(String apprAuthUserId) {
        this.apprAuthUserId = apprAuthUserId;
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

    public String getReversalAuthUserId() {
        return reversalAuthUserId;
    }

    public void setReversalAuthUserId(String reversalAuthUserId) {
        this.reversalAuthUserId = reversalAuthUserId;
    }

    public String getReversalUserId() {
        return reversalUserId;
    }

    public void setReversalUserId(String reversalUserId) {
        this.reversalUserId = reversalUserId;
    }

    public ProfitCenter getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(ProfitCenter profitCenter) {
        this.profitCenter = profitCenter;
    }

    public BigDecimal getFcyCtrlIbuncAmt() {
        return fcyCtrlIbuncAmt;
    }

    public void setFcyCtrlIbuncAmt(BigDecimal fcyCtrlIbuncAmt) {
        this.fcyCtrlIbuncAmt = fcyCtrlIbuncAmt;
    }

    public UncStatus getUncStatus() {
        return uncStatus;
    }

    public void setUncStatus(UncStatus uncStatus) {
        this.uncStatus = uncStatus;
    }

    public String getIbuncReference() {
        return ibuncReference;
    }

    public void setIbuncReference(String ibuncReference) {
        this.ibuncReference = ibuncReference;
    }

    public String getObuncReference() {
        return obuncReference;
    }

    public void setObuncReference(String obuncReference) {
        this.obuncReference = obuncReference;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public BigDecimal getBuyUncRate() {
        return buyUncRate;
    }

    public void setBuyUncRate(BigDecimal buyUncRate) {
        this.buyUncRate = buyUncRate;
    }

    public IssCountry getCountryLoc() {
        return countryLoc;
    }

    public void setCountryLoc(IssCountry countryLoc) {
        this.countryLoc = countryLoc;
    }

    public CouponRateType getCouponRateType() {
        return couponRateType;
    }

    public void setCouponRateType(CouponRateType couponRateType) {
        this.couponRateType = couponRateType;
    }

    public java.util.Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(java.util.Date effectDate) {
        this.effectDate = effectDate;
    }

    public String getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(String effectTime) {
        this.effectTime = effectTime;
    }

    public BigDecimal getFloatPoint() {
        return floatPoint;
    }

    public void setFloatPoint(BigDecimal floatPoint) {
        this.floatPoint = floatPoint;
    }

    public IndividualFlag getMinAmtFlag() {
        return minAmtFlag;
    }

    public void setMinAmtFlag(IndividualFlag minAmtFlag) {
        this.minAmtFlag = minAmtFlag;
    }

    public BigDecimal getSellUncRate() {
        return sellUncRate;
    }

    public void setSellUncRate(BigDecimal sellUncRate) {
        this.sellUncRate = sellUncRate;
    }

    public AcctBranch getBranch() {
        return branch;
    }

    public void setBranch(AcctBranch branch) {
        this.branch = branch;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public IndividualFlag getIsIndividual() {
        return isIndividual;
    }

    public void setIsIndividual(IndividualFlag isIndividual) {
        this.isIndividual = isIndividual;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}