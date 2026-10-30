package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AccountingStatus;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.AcctSetType;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctTranFlag;
import com.dcits.deposit.enums.AmtCalcType;
import com.dcits.deposit.enums.ApprIndicator;
import com.dcits.deposit.enums.AutoReversalFlag;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.CashItem;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.FromRateFlag;
import com.dcits.deposit.enums.IntCalcAmtType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.MediumFlag;
import com.dcits.deposit.enums.MediumType;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.RateType;
import com.dcits.deposit.enums.RcrRcdInd;
import com.dcits.deposit.enums.RemainTerm;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.State;
import com.dcits.deposit.enums.ToId;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranMethod;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.WithdrawalType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbBusTranJnlEO {
    /** 代办人电话 */
    private String commissionClientTel;
    /** 冲正日期 */
    private java.util.Date reversalDate;
    /** 冲正交易类型 */
    private TranType reversalTranType;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 冻结流水号 */
    private String fhSeqNo;
    /** 原交易业务模块 */
    private SourceModule origSystem;
    /** 对手证件号码 */
    private String othDocumentId;
    /** 交易前余额 */
    private BigDecimal previousBalAmt;
    /** 交易国家 */
    private IssCountry tranCountry;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 交易附言 */
    private String tranNote;
    /** 他行账户币种 */
    private Ccy contraAcctCcy;
    /** 限额编码集合 */
    private String limitRefList;
    /** 授权柜员号 */
    private String authUserId;
    /** 冲正标志 */
    private String reversalFlag;
    /** 现钞来源代码 */
    private String cashFromCode;
    /** 对手交易业务流水号 */
    private String othReference;
    /** 实际对手机构行政区划代码 */
    private State othRealBranchRegionCode;
    /** 交易类型 */
    private TranType tranType;
    /** 实际对手交易名称 */
    private String othRealTranName;
    /** 凭证号 */
    private String voucherNo;
    /** 对账代码 */
    private String reaccountCd;
    /** 主交易流水号 */
    private String primaryTranSeqNo;
    /** 基础币种金额1 */
    private BigDecimal baseCcyAmountOne;
    /** 有介质标志 */
    private MediumFlag mediumFlag;
    /** 折算后金额 */
    private BigDecimal ovToAmount;
    /** 买方交易汇率标识 */
    private FromRateFlag fromRateFlag;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 卖方交易汇率标志 */
    private FromRateFlag toRateFlag;
    /** 摘要 */
    private String narrative;
    /** 实际对手账号 */
    private String othRealBaseAcctNo;
    /** 对方账户描述 */
    private String othAcctDesc;
    /** 代办人名称 */
    private String commissionClientName;
    /** 打印标志 */
    private String printIndicator;
    /** 是否理财子账户标志 */
    private String isFinSubAcct;
    /** 实际余额 */
    private BigDecimal actualBal;
    /** 交叉汇率 */
    private BigDecimal crossRate;
    /** 事件类型 */
    private String eventType;
    /** 他行等值金额 */
    private BigDecimal contraEquivAmt;
    /** 汇率类型 */
    private RateType rateType;
    /** 生效日期 */
    private java.util.Date effectDate;
    /** 账套类型 */
    private AcctSetType acctSetType;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 现金凭证预约复核柜员号 */
    private String apprUserId;
    /** 基础币种2汇率中间价 */
    private BigDecimal tackOverCcyRateTwo;
    /** 渠道 */
    private SourceType channel;
    /** 对手证明类型 */
    private DocumentType othDocumentType;
    /** 实际对手证件类型 */
    private DocumentType othRealDocumentType;
    /** 贷款产品编号 */
    private String loanProdNo;
    /** 卖方牌价类型 */
    private ToId toId;
    /** 对客汇率 */
    private BigDecimal custRate;
    /** 余额类型 */
    private BalType balType;
    /** 子账号 */
    private String subAcctNo;
    /** 业务流水号 */
    private String busSeqNo;
    /** 账户状态 */
    private AcctStatus acctStatus;
    /** 红字处理标志 */
    private RcrRcdInd rcrRcdInd;
    /** 结售汇收入方交易编码 */
    private String exchangeTranCode;
    /** 客户名称 */
    private String clientName;
    /** 服务费收取标志 */
    private String servCharge;
    /** 账户序号 */
    private String acctSeqNo;
    /** 复核标识 */
    private ApprIndicator apprIndicator;
    /** 证件类型 */
    private DocumentType documentType;
    /** 账户开立行行号 */
    private TranBranch acctBranch;
    /** 交易对手名称 */
    private String othTranName;
    /** 是否通用记账标志 */
    private String isCommTran;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 基础币种金额2 */
    private BigDecimal baseCcyAmountTwo;
    /** 账户虚实标志 */
    private String acctRealFlag;
    /** 对手方银行行政区划代码 */
    private State othBranchRegionalismCode;
    /** 源金额 */
    private BigDecimal fromAmount;
    /** 源模块 */
    private SourceModule sourceModule;
    /** 对手汇率 */
    private BigDecimal toXrate;
    /** 利润中心 */
    private ProfitCenter profitCenter;
    /** 现钞去向国家 */
    private IssCountry cashToCountry;
    /** 银行交易序号 */
    private String bankSeqNo;
    /** 现钞去向代码 */
    private String cashToCode;
    /** 主事件类型 */
    private String primaryEventType;
    /** 到账方式 */
    private TranMethod tranMethod;
    /** 贷款人编号 */
    private String lender;
    /** 交易代码 */
    private String programId;
    /** 现金来源国家 */
    private IssCountry cashFromCountry;
    /** 实际对手产品编号 */
    private String othRealProdNo;
    /** 打印次数 */
    private Integer printCnt;
    /** 支付记账处理代码 */
    private String dealCode;
    /** 产品编号 */
    private String prodNo;
    /** 对手银行行号 */
    private String othBankCode;
    /** 对手账号 */
    private String othBaseAcctNo;
    /** 现金项目编号 */
    private CashItem cashItem;
    /** 批次号 */
    private String batchNo;
    /** 渠道日期 */
    private java.util.Date channelDate;
    /** 票据号码 */
    private String billNo;
    /** 序号 */
    @NotNull
    private String seqNo;
    /** 回收流水号 */
    private String receiptNo;
    /** 执行交叉汇率 */
    private BigDecimal ovCrossRate;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 对方账户开户行行号 */
    private TranBranch othBranch;
    /** 交易参考号 */
    private String reference;
    /** 报价类型 */
    private ToId quoteType;
    /** 现钞来源国家 */
    private IssCountry cashSourceCountry;
    /** 自动冲正标志 */
    private AutoReversalFlag autoReversalFlag;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 过账标志 */
    private String glPostedFlag;
    /** 账户类别 */
    private AcctClass acctClass;
    /** 补登存折标志 */
    private String pbkUpdFlag;
    /** 科目编号 */
    private String glNo;
    /** 实际加转开账户余额 */
    private BigDecimal actualBalAmtFin;
    /** 交易机构号 */
    private TranBranch tranBranch;
    /** 凭证前缀编码 */
    private String prefix;
    /** 现钞使用地区代码 */
    private IssCountry cashUsePlaceCode;
    /** 清算日期 */
    private java.util.Date settlementDate;
    /** 买方汇率 */
    private BigDecimal fromXrate;
    /** 结售汇支出方交易编码 */
    private String exchangeTranCodet;
    /** 转入币种 */
    private Ccy toCcy;
    /** 对手银行名称 */
    private String othBankName;
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 对手交易流水号 */
    private String othSeqNo;
    /** 实际对手交易地址 */
    private String othRealTranAddr;
    /** 金额类型 */
    private IntCalcAmtType amtType;
    /** 客户类型 */
    private ClientType clientType;
    /** 自动交易标志 */
    private String autoTradeFlag;
    /** 交易柜员号 */
    private String userId;
    /** 账户描述 */
    private String acctDesc;
    /** 实际对手身份证件号码 */
    private String othRealDocumentId;
    /** 账户交易标志 */
    private AcctTranFlag acctTranFlag;
    /** 金额计算规则 */
    private AmtCalcType amtCalcType;
    /** 实际对手机构号 */
    private String othRealBankCode;
    /** 本币交易金额 */
    private BigDecimal lcyTranAmt;
    /** 对手账户币种 */
    private AcctCcy othAcctCcy;
    /** 发送系统编号 */
    private String sendSystem;
    /** 对手产品编号 */
    private String othProdNo;
    /** 基础币种1汇率中间价 */
    private BigDecimal tackOverCcyRateOne;
    /** 对方账户序号 */
    private String othAcctSeqNo;
    /** 核算状态 */
    private AccountingStatus accountingStatus;
    /** 子流水号 */
    private String subSeqNo;
    /** 交易发生地 */
    private String othTranAddr;
    /** 摘要码 */
    private String narrativeCode;
    /** 交易日期 */
    @NotNull
    private java.util.Date tranDate;
    /** 基础等值金额 */
    private BigDecimal baseEquivAmt;
    /** 币种 */
    private Ccy ccy;
    /** 账号 */
    private String baseAcctNo;
    /** 付款单位名称 */
    private String payUnit;
    /** 真实对方金融机构名称 */
    private String othRealBankName;
    /** 定期账户剩余期限 */
    private RemainTerm remainTerm;
    /** 转出币种 */
    private Ccy fromCcy;
    /** 冲正流水号 */
    private String reversalSeqNo;
    /** 交易描述 */
    private String tranDesc;
    /** 介质类型 */
    private MediumType mediumType;
    /** 借贷标志 */
    private CrDrInd crDrInd;
    /** 移入金额 */
    private BigDecimal toAmount;
    /** 证件号码 */
    private String documentId;
    /** 业务处理状态 */
    private TranStatus tranStatus;
    /** 凭证类型 */
    private DocType docType;
    /** 支取方式 */
    private WithdrawalType withdrawalType;
    /** 对手账户内部键 */
    @NotNull
    private Integer othInternalKey;
    /** 他行交易日期 */
    private java.util.Date contraTranDate;
    /** 优先级 */
    private String priority;
    /** 平盘汇率 */
    private BigDecimal flatRate;

    public String getCommissionClientTel() {
        return commissionClientTel;
    }

    public void setCommissionClientTel(String commissionClientTel) {
        this.commissionClientTel = commissionClientTel;
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

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public String getFhSeqNo() {
        return fhSeqNo;
    }

    public void setFhSeqNo(String fhSeqNo) {
        this.fhSeqNo = fhSeqNo;
    }

    public SourceModule getOrigSystem() {
        return origSystem;
    }

    public void setOrigSystem(SourceModule origSystem) {
        this.origSystem = origSystem;
    }

    public String getOthDocumentId() {
        return othDocumentId;
    }

    public void setOthDocumentId(String othDocumentId) {
        this.othDocumentId = othDocumentId;
    }

    public BigDecimal getPreviousBalAmt() {
        return previousBalAmt;
    }

    public void setPreviousBalAmt(BigDecimal previousBalAmt) {
        this.previousBalAmt = previousBalAmt;
    }

    public IssCountry getTranCountry() {
        return tranCountry;
    }

    public void setTranCountry(IssCountry tranCountry) {
        this.tranCountry = tranCountry;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getTranNote() {
        return tranNote;
    }

    public void setTranNote(String tranNote) {
        this.tranNote = tranNote;
    }

    public Ccy getContraAcctCcy() {
        return contraAcctCcy;
    }

    public void setContraAcctCcy(Ccy contraAcctCcy) {
        this.contraAcctCcy = contraAcctCcy;
    }

    public String getLimitRefList() {
        return limitRefList;
    }

    public void setLimitRefList(String limitRefList) {
        this.limitRefList = limitRefList;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    public String getReversalFlag() {
        return reversalFlag;
    }

    public void setReversalFlag(String reversalFlag) {
        this.reversalFlag = reversalFlag;
    }

    public String getCashFromCode() {
        return cashFromCode;
    }

    public void setCashFromCode(String cashFromCode) {
        this.cashFromCode = cashFromCode;
    }

    public String getOthReference() {
        return othReference;
    }

    public void setOthReference(String othReference) {
        this.othReference = othReference;
    }

    public State getOthRealBranchRegionCode() {
        return othRealBranchRegionCode;
    }

    public void setOthRealBranchRegionCode(State othRealBranchRegionCode) {
        this.othRealBranchRegionCode = othRealBranchRegionCode;
    }

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public String getOthRealTranName() {
        return othRealTranName;
    }

    public void setOthRealTranName(String othRealTranName) {
        this.othRealTranName = othRealTranName;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getReaccountCd() {
        return reaccountCd;
    }

    public void setReaccountCd(String reaccountCd) {
        this.reaccountCd = reaccountCd;
    }

    public String getPrimaryTranSeqNo() {
        return primaryTranSeqNo;
    }

    public void setPrimaryTranSeqNo(String primaryTranSeqNo) {
        this.primaryTranSeqNo = primaryTranSeqNo;
    }

    public BigDecimal getBaseCcyAmountOne() {
        return baseCcyAmountOne;
    }

    public void setBaseCcyAmountOne(BigDecimal baseCcyAmountOne) {
        this.baseCcyAmountOne = baseCcyAmountOne;
    }

    public MediumFlag getMediumFlag() {
        return mediumFlag;
    }

    public void setMediumFlag(MediumFlag mediumFlag) {
        this.mediumFlag = mediumFlag;
    }

    public BigDecimal getOvToAmount() {
        return ovToAmount;
    }

    public void setOvToAmount(BigDecimal ovToAmount) {
        this.ovToAmount = ovToAmount;
    }

    public FromRateFlag getFromRateFlag() {
        return fromRateFlag;
    }

    public void setFromRateFlag(FromRateFlag fromRateFlag) {
        this.fromRateFlag = fromRateFlag;
    }

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
        this.acctCcy = acctCcy;
    }

    public FromRateFlag getToRateFlag() {
        return toRateFlag;
    }

    public void setToRateFlag(FromRateFlag toRateFlag) {
        this.toRateFlag = toRateFlag;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getOthRealBaseAcctNo() {
        return othRealBaseAcctNo;
    }

    public void setOthRealBaseAcctNo(String othRealBaseAcctNo) {
        this.othRealBaseAcctNo = othRealBaseAcctNo;
    }

    public String getOthAcctDesc() {
        return othAcctDesc;
    }

    public void setOthAcctDesc(String othAcctDesc) {
        this.othAcctDesc = othAcctDesc;
    }

    public String getCommissionClientName() {
        return commissionClientName;
    }

    public void setCommissionClientName(String commissionClientName) {
        this.commissionClientName = commissionClientName;
    }

    public String getPrintIndicator() {
        return printIndicator;
    }

    public void setPrintIndicator(String printIndicator) {
        this.printIndicator = printIndicator;
    }

    public String getIsFinSubAcct() {
        return isFinSubAcct;
    }

    public void setIsFinSubAcct(String isFinSubAcct) {
        this.isFinSubAcct = isFinSubAcct;
    }

    public BigDecimal getActualBal() {
        return actualBal;
    }

    public void setActualBal(BigDecimal actualBal) {
        this.actualBal = actualBal;
    }

    public BigDecimal getCrossRate() {
        return crossRate;
    }

    public void setCrossRate(BigDecimal crossRate) {
        this.crossRate = crossRate;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public BigDecimal getContraEquivAmt() {
        return contraEquivAmt;
    }

    public void setContraEquivAmt(BigDecimal contraEquivAmt) {
        this.contraEquivAmt = contraEquivAmt;
    }

    public RateType getRateType() {
        return rateType;
    }

    public void setRateType(RateType rateType) {
        this.rateType = rateType;
    }

    public java.util.Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(java.util.Date effectDate) {
        this.effectDate = effectDate;
    }

    public AcctSetType getAcctSetType() {
        return acctSetType;
    }

    public void setAcctSetType(AcctSetType acctSetType) {
        this.acctSetType = acctSetType;
    }

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public String getApprUserId() {
        return apprUserId;
    }

    public void setApprUserId(String apprUserId) {
        this.apprUserId = apprUserId;
    }

    public BigDecimal getTackOverCcyRateTwo() {
        return tackOverCcyRateTwo;
    }

    public void setTackOverCcyRateTwo(BigDecimal tackOverCcyRateTwo) {
        this.tackOverCcyRateTwo = tackOverCcyRateTwo;
    }

    public SourceType getChannel() {
        return channel;
    }

    public void setChannel(SourceType channel) {
        this.channel = channel;
    }

    public DocumentType getOthDocumentType() {
        return othDocumentType;
    }

    public void setOthDocumentType(DocumentType othDocumentType) {
        this.othDocumentType = othDocumentType;
    }

    public DocumentType getOthRealDocumentType() {
        return othRealDocumentType;
    }

    public void setOthRealDocumentType(DocumentType othRealDocumentType) {
        this.othRealDocumentType = othRealDocumentType;
    }

    public String getLoanProdNo() {
        return loanProdNo;
    }

    public void setLoanProdNo(String loanProdNo) {
        this.loanProdNo = loanProdNo;
    }

    public ToId getToId() {
        return toId;
    }

    public void setToId(ToId toId) {
        this.toId = toId;
    }

    public BigDecimal getCustRate() {
        return custRate;
    }

    public void setCustRate(BigDecimal custRate) {
        this.custRate = custRate;
    }

    public BalType getBalType() {
        return balType;
    }

    public void setBalType(BalType balType) {
        this.balType = balType;
    }

    public String getSubAcctNo() {
        return subAcctNo;
    }

    public void setSubAcctNo(String subAcctNo) {
        this.subAcctNo = subAcctNo;
    }

    public String getBusSeqNo() {
        return busSeqNo;
    }

    public void setBusSeqNo(String busSeqNo) {
        this.busSeqNo = busSeqNo;
    }

    public AcctStatus getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(AcctStatus acctStatus) {
        this.acctStatus = acctStatus;
    }

    public RcrRcdInd getRcrRcdInd() {
        return rcrRcdInd;
    }

    public void setRcrRcdInd(RcrRcdInd rcrRcdInd) {
        this.rcrRcdInd = rcrRcdInd;
    }

    public String getExchangeTranCode() {
        return exchangeTranCode;
    }

    public void setExchangeTranCode(String exchangeTranCode) {
        this.exchangeTranCode = exchangeTranCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getServCharge() {
        return servCharge;
    }

    public void setServCharge(String servCharge) {
        this.servCharge = servCharge;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public ApprIndicator getApprIndicator() {
        return apprIndicator;
    }

    public void setApprIndicator(ApprIndicator apprIndicator) {
        this.apprIndicator = apprIndicator;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public TranBranch getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(TranBranch acctBranch) {
        this.acctBranch = acctBranch;
    }

    public String getOthTranName() {
        return othTranName;
    }

    public void setOthTranName(String othTranName) {
        this.othTranName = othTranName;
    }

    public String getIsCommTran() {
        return isCommTran;
    }

    public void setIsCommTran(String isCommTran) {
        this.isCommTran = isCommTran;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public BigDecimal getBaseCcyAmountTwo() {
        return baseCcyAmountTwo;
    }

    public void setBaseCcyAmountTwo(BigDecimal baseCcyAmountTwo) {
        this.baseCcyAmountTwo = baseCcyAmountTwo;
    }

    public String getAcctRealFlag() {
        return acctRealFlag;
    }

    public void setAcctRealFlag(String acctRealFlag) {
        this.acctRealFlag = acctRealFlag;
    }

    public State getOthBranchRegionalismCode() {
        return othBranchRegionalismCode;
    }

    public void setOthBranchRegionalismCode(State othBranchRegionalismCode) {
        this.othBranchRegionalismCode = othBranchRegionalismCode;
    }

    public BigDecimal getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(BigDecimal fromAmount) {
        this.fromAmount = fromAmount;
    }

    public SourceModule getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(SourceModule sourceModule) {
        this.sourceModule = sourceModule;
    }

    public BigDecimal getToXrate() {
        return toXrate;
    }

    public void setToXrate(BigDecimal toXrate) {
        this.toXrate = toXrate;
    }

    public ProfitCenter getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(ProfitCenter profitCenter) {
        this.profitCenter = profitCenter;
    }

    public IssCountry getCashToCountry() {
        return cashToCountry;
    }

    public void setCashToCountry(IssCountry cashToCountry) {
        this.cashToCountry = cashToCountry;
    }

    public String getBankSeqNo() {
        return bankSeqNo;
    }

    public void setBankSeqNo(String bankSeqNo) {
        this.bankSeqNo = bankSeqNo;
    }

    public String getCashToCode() {
        return cashToCode;
    }

    public void setCashToCode(String cashToCode) {
        this.cashToCode = cashToCode;
    }

    public String getPrimaryEventType() {
        return primaryEventType;
    }

    public void setPrimaryEventType(String primaryEventType) {
        this.primaryEventType = primaryEventType;
    }

    public TranMethod getTranMethod() {
        return tranMethod;
    }

    public void setTranMethod(TranMethod tranMethod) {
        this.tranMethod = tranMethod;
    }

    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public IssCountry getCashFromCountry() {
        return cashFromCountry;
    }

    public void setCashFromCountry(IssCountry cashFromCountry) {
        this.cashFromCountry = cashFromCountry;
    }

    public String getOthRealProdNo() {
        return othRealProdNo;
    }

    public void setOthRealProdNo(String othRealProdNo) {
        this.othRealProdNo = othRealProdNo;
    }

    public Integer getPrintCnt() {
        return printCnt;
    }

    public void setPrintCnt(Integer printCnt) {
        this.printCnt = printCnt;
    }

    public String getDealCode() {
        return dealCode;
    }

    public void setDealCode(String dealCode) {
        this.dealCode = dealCode;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getOthBankCode() {
        return othBankCode;
    }

    public void setOthBankCode(String othBankCode) {
        this.othBankCode = othBankCode;
    }

    public String getOthBaseAcctNo() {
        return othBaseAcctNo;
    }

    public void setOthBaseAcctNo(String othBaseAcctNo) {
        this.othBaseAcctNo = othBaseAcctNo;
    }

    public CashItem getCashItem() {
        return cashItem;
    }

    public void setCashItem(CashItem cashItem) {
        this.cashItem = cashItem;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public java.util.Date getChannelDate() {
        return channelDate;
    }

    public void setChannelDate(java.util.Date channelDate) {
        this.channelDate = channelDate;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public BigDecimal getOvCrossRate() {
        return ovCrossRate;
    }

    public void setOvCrossRate(BigDecimal ovCrossRate) {
        this.ovCrossRate = ovCrossRate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public TranBranch getOthBranch() {
        return othBranch;
    }

    public void setOthBranch(TranBranch othBranch) {
        this.othBranch = othBranch;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public ToId getQuoteType() {
        return quoteType;
    }

    public void setQuoteType(ToId quoteType) {
        this.quoteType = quoteType;
    }

    public IssCountry getCashSourceCountry() {
        return cashSourceCountry;
    }

    public void setCashSourceCountry(IssCountry cashSourceCountry) {
        this.cashSourceCountry = cashSourceCountry;
    }

    public AutoReversalFlag getAutoReversalFlag() {
        return autoReversalFlag;
    }

    public void setAutoReversalFlag(AutoReversalFlag autoReversalFlag) {
        this.autoReversalFlag = autoReversalFlag;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public String getGlPostedFlag() {
        return glPostedFlag;
    }

    public void setGlPostedFlag(String glPostedFlag) {
        this.glPostedFlag = glPostedFlag;
    }

    public AcctClass getAcctClass() {
        return acctClass;
    }

    public void setAcctClass(AcctClass acctClass) {
        this.acctClass = acctClass;
    }

    public String getPbkUpdFlag() {
        return pbkUpdFlag;
    }

    public void setPbkUpdFlag(String pbkUpdFlag) {
        this.pbkUpdFlag = pbkUpdFlag;
    }

    public String getGlNo() {
        return glNo;
    }

    public void setGlNo(String glNo) {
        this.glNo = glNo;
    }

    public BigDecimal getActualBalAmtFin() {
        return actualBalAmtFin;
    }

    public void setActualBalAmtFin(BigDecimal actualBalAmtFin) {
        this.actualBalAmtFin = actualBalAmtFin;
    }

    public TranBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(TranBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public IssCountry getCashUsePlaceCode() {
        return cashUsePlaceCode;
    }

    public void setCashUsePlaceCode(IssCountry cashUsePlaceCode) {
        this.cashUsePlaceCode = cashUsePlaceCode;
    }

    public java.util.Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(java.util.Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public BigDecimal getFromXrate() {
        return fromXrate;
    }

    public void setFromXrate(BigDecimal fromXrate) {
        this.fromXrate = fromXrate;
    }

    public String getExchangeTranCodet() {
        return exchangeTranCodet;
    }

    public void setExchangeTranCodet(String exchangeTranCodet) {
        this.exchangeTranCodet = exchangeTranCodet;
    }

    public Ccy getToCcy() {
        return toCcy;
    }

    public void setToCcy(Ccy toCcy) {
        this.toCcy = toCcy;
    }

    public String getOthBankName() {
        return othBankName;
    }

    public void setOthBankName(String othBankName) {
        this.othBankName = othBankName;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getOthSeqNo() {
        return othSeqNo;
    }

    public void setOthSeqNo(String othSeqNo) {
        this.othSeqNo = othSeqNo;
    }

    public String getOthRealTranAddr() {
        return othRealTranAddr;
    }

    public void setOthRealTranAddr(String othRealTranAddr) {
        this.othRealTranAddr = othRealTranAddr;
    }

    public IntCalcAmtType getAmtType() {
        return amtType;
    }

    public void setAmtType(IntCalcAmtType amtType) {
        this.amtType = amtType;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getAutoTradeFlag() {
        return autoTradeFlag;
    }

    public void setAutoTradeFlag(String autoTradeFlag) {
        this.autoTradeFlag = autoTradeFlag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAcctDesc() {
        return acctDesc;
    }

    public void setAcctDesc(String acctDesc) {
        this.acctDesc = acctDesc;
    }

    public String getOthRealDocumentId() {
        return othRealDocumentId;
    }

    public void setOthRealDocumentId(String othRealDocumentId) {
        this.othRealDocumentId = othRealDocumentId;
    }

    public AcctTranFlag getAcctTranFlag() {
        return acctTranFlag;
    }

    public void setAcctTranFlag(AcctTranFlag acctTranFlag) {
        this.acctTranFlag = acctTranFlag;
    }

    public AmtCalcType getAmtCalcType() {
        return amtCalcType;
    }

    public void setAmtCalcType(AmtCalcType amtCalcType) {
        this.amtCalcType = amtCalcType;
    }

    public String getOthRealBankCode() {
        return othRealBankCode;
    }

    public void setOthRealBankCode(String othRealBankCode) {
        this.othRealBankCode = othRealBankCode;
    }

    public BigDecimal getLcyTranAmt() {
        return lcyTranAmt;
    }

    public void setLcyTranAmt(BigDecimal lcyTranAmt) {
        this.lcyTranAmt = lcyTranAmt;
    }

    public AcctCcy getOthAcctCcy() {
        return othAcctCcy;
    }

    public void setOthAcctCcy(AcctCcy othAcctCcy) {
        this.othAcctCcy = othAcctCcy;
    }

    public String getSendSystem() {
        return sendSystem;
    }

    public void setSendSystem(String sendSystem) {
        this.sendSystem = sendSystem;
    }

    public String getOthProdNo() {
        return othProdNo;
    }

    public void setOthProdNo(String othProdNo) {
        this.othProdNo = othProdNo;
    }

    public BigDecimal getTackOverCcyRateOne() {
        return tackOverCcyRateOne;
    }

    public void setTackOverCcyRateOne(BigDecimal tackOverCcyRateOne) {
        this.tackOverCcyRateOne = tackOverCcyRateOne;
    }

    public String getOthAcctSeqNo() {
        return othAcctSeqNo;
    }

    public void setOthAcctSeqNo(String othAcctSeqNo) {
        this.othAcctSeqNo = othAcctSeqNo;
    }

    public AccountingStatus getAccountingStatus() {
        return accountingStatus;
    }

    public void setAccountingStatus(AccountingStatus accountingStatus) {
        this.accountingStatus = accountingStatus;
    }

    public String getSubSeqNo() {
        return subSeqNo;
    }

    public void setSubSeqNo(String subSeqNo) {
        this.subSeqNo = subSeqNo;
    }

    public String getOthTranAddr() {
        return othTranAddr;
    }

    public void setOthTranAddr(String othTranAddr) {
        this.othTranAddr = othTranAddr;
    }

    public String getNarrativeCode() {
        return narrativeCode;
    }

    public void setNarrativeCode(String narrativeCode) {
        this.narrativeCode = narrativeCode;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public BigDecimal getBaseEquivAmt() {
        return baseEquivAmt;
    }

    public void setBaseEquivAmt(BigDecimal baseEquivAmt) {
        this.baseEquivAmt = baseEquivAmt;
    }

    public Ccy getCcy() {
        return ccy;
    }

    public void setCcy(Ccy ccy) {
        this.ccy = ccy;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getPayUnit() {
        return payUnit;
    }

    public void setPayUnit(String payUnit) {
        this.payUnit = payUnit;
    }

    public String getOthRealBankName() {
        return othRealBankName;
    }

    public void setOthRealBankName(String othRealBankName) {
        this.othRealBankName = othRealBankName;
    }

    public RemainTerm getRemainTerm() {
        return remainTerm;
    }

    public void setRemainTerm(RemainTerm remainTerm) {
        this.remainTerm = remainTerm;
    }

    public Ccy getFromCcy() {
        return fromCcy;
    }

    public void setFromCcy(Ccy fromCcy) {
        this.fromCcy = fromCcy;
    }

    public String getReversalSeqNo() {
        return reversalSeqNo;
    }

    public void setReversalSeqNo(String reversalSeqNo) {
        this.reversalSeqNo = reversalSeqNo;
    }

    public String getTranDesc() {
        return tranDesc;
    }

    public void setTranDesc(String tranDesc) {
        this.tranDesc = tranDesc;
    }

    public MediumType getMediumType() {
        return mediumType;
    }

    public void setMediumType(MediumType mediumType) {
        this.mediumType = mediumType;
    }

    public CrDrInd getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(CrDrInd crDrInd) {
        this.crDrInd = crDrInd;
    }

    public BigDecimal getToAmount() {
        return toAmount;
    }

    public void setToAmount(BigDecimal toAmount) {
        this.toAmount = toAmount;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public TranStatus getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(TranStatus tranStatus) {
        this.tranStatus = tranStatus;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public WithdrawalType getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(WithdrawalType withdrawalType) {
        this.withdrawalType = withdrawalType;
    }

    public Integer getOthInternalKey() {
        return othInternalKey;
    }

    public void setOthInternalKey(Integer othInternalKey) {
        this.othInternalKey = othInternalKey;
    }

    public java.util.Date getContraTranDate() {
        return contraTranDate;
    }

    public void setContraTranDate(java.util.Date contraTranDate) {
        this.contraTranDate = contraTranDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public BigDecimal getFlatRate() {
        return flatRate;
    }

    public void setFlatRate(BigDecimal flatRate) {
        this.flatRate = flatRate;
    }
}