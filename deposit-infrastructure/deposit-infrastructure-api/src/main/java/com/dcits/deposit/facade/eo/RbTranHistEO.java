package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AccountingStatus;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctTranFlag;
import com.dcits.deposit.enums.AmtCalcType;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.ApprIndicator;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.BusinessUnit;
import com.dcits.deposit.enums.CashItem;
import com.dcits.deposit.enums.CashSourceRemark;
import com.dcits.deposit.enums.CashUseRemark;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.FinType;
import com.dcits.deposit.enums.FromRateFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.MediumType;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.QuoteType;
import com.dcits.deposit.enums.RateType;
import com.dcits.deposit.enums.RemainTerm;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TellerTerminalType;
import com.dcits.deposit.enums.TranCategory;
import com.dcits.deposit.enums.TranMethod;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.WithdrawalType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbTranHistEO {
    /** 序号 */
    @NotNull
    private String seqNo;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 子流水号 */
    private String subSeqNo;
    /** TAE子流水号 */
    private String taeSubSeqNo;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 交易参考号 */
    private String reference;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 子账号 */
    private String subAcctNo;
    /** 账户类别 */
    private AcctClass acctClass;
    /** 账户状态 */
    private AcctStatus acctStatus;
    /** 账户虚实标志 */
    private IndividualFlag acctRealFlag;
    /** 账户交易标志 */
    private AcctTranFlag acctTranFlag;
    /** 账户描述 */
    private String acctDesc;
    /** 账户开立行行号 */
    private AcctBranch acctBranch;
    /** 事件类型 */
    private String eventType;
    /** 交易日期 */
    @NotNull
    private java.util.Date tranDate;
    /** 交易机构号 */
    private AcctBranch tranBranch;
    /** 借贷标志 */
    private CrDrInd crDrInd;
    /** 币种 */
    private AcctCcy ccy;
    /** 交易类型 */
    private TranType tranType;
    /** 交易描述 */
    private String tranDesc;
    /** 交易前余额 */
    private BigDecimal previousBalAmt;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 实际余额 */
    private BigDecimal actualBal;
    /** 计价方式 */
    private TranCategory tranCategory;
    /** 科目代码 */
    private String glCode;
    /** 对手交易业务流水号 */
    private String othReference;
    /** 对手账户内部键 */
    private Integer othInternalKey;
    /** 对手账号 */
    private String othBaseAcctNo;
    /** 对手账户币种 */
    private AcctCcy othAcctCcy;
    /** 对方账户序号 */
    private String othAcctSeqNo;
    /** 冻结流水号 */
    private String fhSeqNo;
    /** 对手产品编号 */
    private String othProdType;
    /** 对方账户描述 */
    private String othAcctDesc;
    /** 对手银行行号 */
    private String othBankCode;
    /** 对手银行名称 */
    private String othBankName;
    /** 对方账户开户行行号 */
    private AcctBranch othBranch;
    /** 实际对手机构号 */
    private String othRealBankCode;
    /** 真实对方金融机构名称 */
    private String othRealBankName;
    /** 实际对手产品编号 */
    private String othRealProdType;
    /** 实际对手账号 */
    private String othRealBaseAcctNo;
    /** 他行账户币种 */
    private AcctCcy contraAcctCcy;
    /** 转出币种 */
    private AcctCcy fromCcy;
    /** 对手交易流水号 */
    private String othSeqNo;
    /** 主交易流水号 */
    private String primaryTranSeqNo;
    /** 转入币种 */
    private AcctCcy toCcy;
    /** 源金额 */
    private BigDecimal fromAmount;
    /** 移入金额 */
    private BigDecimal toAmount;
    /** 凭证类型 */
    private DocType docType;
    /** 凭证前缀编码 */
    private String prefix;
    /** 凭证号 */
    private String voucherNo;
    /** 证件号码 */
    private String documentId;
    /** 证件类型 */
    private DocumentType documentType;
    /** 客户名称 */
    private String clientName;
    /** 客户类型 */
    private ClientType clientType;
    /** 票据号码 */
    private String billNo;
    /** 账套编号 */
    private BusinessUnit businessUnit;
    /** 现金项目编号 */
    private CashItem cashItem;
    /** 交易附言 */
    private String tranNote;
    /** 业务处理状态 */
    private TranStatus tranStatus;
    /** 自动冲正标志 */
    private IndividualFlag autoReversalFlag;
    /** 金额计算规则 */
    private AmtCalcType amtCalcType;
    /** 渠道 */
    private SourceType channel;
    /** 金额类型 */
    private AmtType amtType;
    /** 余额类型 */
    private BalType balType;
    /** 他行等值金额 */
    private BigDecimal contraEquivAmt;
    /** 实际加转开账户余额 */
    private BigDecimal actualBalAmtFin;
    /** 基础等值金额 */
    private BigDecimal baseEquivAmt;
    /** 平盘汇率 */
    private BigDecimal flatRate;
    /** 折算后金额 */
    private BigDecimal ovToAmount;
    /** 交叉汇率 */
    private BigDecimal crossRate;
    /** 买方交易汇率标识 */
    private FromRateFlag fromRateFlag;
    /** 买方汇率 */
    private BigDecimal fromXrate;
    /** 执行交叉汇率 */
    private BigDecimal ovCrossRate;
    /** 卖方交易汇率标志 */
    private FromRateFlag toRateFlag;
    /** 对手汇率 */
    private BigDecimal toXrate;
    /** 中间业务类型 */
    private String bizType;
    /** 理财类型 */
    private FinType finType;
    /** 报价类型 */
    private QuoteType quoteType;
    /** 有介质标志 */
    private IndividualFlag mediumFlag;
    /** 介质类型 */
    private MediumType mediumType;
    /** 原交易业务模块 */
    private SourceModule origSystem;
    /** 对手证明类型 */
    private DocumentType othDocumentType;
    /** 补登存折标志 */
    private IndividualFlag pbkUpdFlag;
    /** 主事件类型 */
    private String primaryEventType;
    /** 汇率类型 */
    private RateType rateType;
    /** 到账方式 */
    private TranMethod tranMethod;
    /** 支取方式 */
    private WithdrawalType withdrawalType;
    /** 批次号 */
    private String batchNo;
    /** 银行交易序号 */
    private String bankSeqNo;
    /** 代办人电话 */
    private String commissionClientTel;
    /** 贷款人编号 */
    private String lender;
    /** 限额编码集合 */
    private String limitRefList;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 对手方银行行政区划代码 */
    private OthBranchRegionalismCode othBranchRegionalismCode;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 对手证件号码 */
    private String othDocumentId;
    /** 实际对手机构行政区划代码 */
    private OthBranchRegionalismCode othRealBranchRegionCode;
    /** 实际对手身份证件号码 */
    private String othRealDocumentId;
    /** 实际对手证件类型 */
    private DocumentType othRealDocumentType;
    /** 交易发生地 */
    private String othTranAddr;
    /** 实际对手交易地址 */
    private String othRealTranAddr;
    /** 交易对手名称 */
    private String othTranName;
    /** 实际对手交易名称 */
    private String othRealTranName;
    /** 付款单位名称 */
    private String payUnit;
    /** 打印次数 */
    private Integer printCnt;
    /** 回收流水号 */
    private String receiptNo;
    /** 发送系统编号 */
    private String sendSystem;
    /** 优先级 */
    private String priority;
    /** 卖方牌价类型 */
    private QuoteType toId;
    /** 服务费收取标志 */
    private IndividualFlag servCharge;
    /** 代办人名称 */
    private String commissionClientName;
    /** 利润中心 */
    private ProfitCenter profitCenter;
    /** 交易代码 */
    private String programId;
    /** 源模块 */
    private SourceModule sourceModule;
    /** 生效日期 */
    private java.util.Date effectDate;
    /** 系统编码 */
    private String systemCode;
    /** 冲正流水号 */
    private String reversalSeqNo;
    /** 终端编号 */
    private String terminalId;
    /** 跟踪ID */
    private String traceId;
    /** 冲正交易类型 */
    private TranType reversalTranType;
    /** 冲正标志 */
    private IndividualFlag reversalFlag;
    /** 冲正日期 */
    private java.util.Date reversalDate;
    /** 渠道日期 */
    private java.util.Date channelDate;
    /** 清算日期 */
    private java.util.Date settlementDate;
    /** 核算状态 */
    private AccountingStatus accountingStatus;
    /** 过账标志 */
    private IndividualFlag glPostedFlag;
    /** 摘要 */
    private String narrative;
    /** 现金凭证预约复核柜员号 */
    private String apprUserId;
    /** 授权柜员号 */
    private String authUserId;
    /** 原始交易时间戳 */
    private String origTranTimestamp;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 交易柜员号 */
    private String userId;
    /** 法人 */
    private Company company;
    /** 支票出票日期 */
    private java.util.Date chequeDate;
    /** 备注 */
    private String remark;
    /** 现钞使用地区代码 */
    private IssCountry cashUsePlaceCode;
    /** 现钞使用 */
    private CashUseRemark cashUseRemark;
    /** 现钞来源国家 */
    private IssCountry cashSourceCountry;
    /** 现钞来源说明 */
    private CashSourceRemark cashSourceRemark;
    /** tae记账标志 */
    private IndividualFlag taeFlag;
    /** 传输代码 */
    private String tranCode;
    /** 处理流水号 */
    private String dealNo;
    /** 支付记账处理代码 */
    private String dealCode;
    /** 输入程序ID */
    private String inputMediumId;
    /** 柜面终端类型 */
    private TellerTerminalType tellerTerminalType;
    /** 复核标识 */
    private ApprIndicator apprIndicator;
    /** 复核终端ID */
    private String apprTerminalId;
    /** 打印标志 */
    private IndividualFlag printIndicator;
    /** 定期账户剩余期限 */
    private RemainTerm remainTerm;
    /** 输入终端类型 */
    private TellerTerminalType inputMediumType;
    /** 交易国家 */
    private IssCountry tranCountry;
    /** 本币交易金额 */
    private BigDecimal lcyTranAmt;
    /** 对客汇率 */
    private BigDecimal custRate;
    /** 自动交易标志 */
    private IndividualFlag autoTradeFlag;
    /** Treats系统渠道编号 */
    private String treatsChannelNo;
    /** Treats交易流水号 */
    private String treatsReference;
    /** 基础币种1汇率中间价 */
    private BigDecimal tackOverCcyRateOne;
    /** 基础币种2汇率中间价 */
    private BigDecimal tackOverCcyRateTwo;
    /** 到期说明1 */
    private String maturityNarrative1;
    /** 到期说明2 */
    private String maturityNarrative2;
    /** 到期说明3 */
    private String maturityNarrative3;
    /** 到期说明4 */
    private String maturityNarrative4;
    /** 基础币种金额1 */
    private BigDecimal baseCcyAmountOne;
    /** 基础币种金额2 */
    private BigDecimal baseCcyAmountTwo;
    /** 业务流水号 */
    private String busSeqNo;
    /** 现钞来源代码 */
    private String cashFromCode;
    /** 现金来源国家 */
    private IssCountry cashFromCountry;
    /** 现钞去向代码 */
    private String cashToCode;
    /** 现钞去向国家 */
    private IssCountry cashToCountry;
    /** 他行交易日期 */
    private java.util.Date contraTranDate;
    /** 贷款产品类型 */
    private String loanProdType;
    /** 摘要码 */
    private String narrativeCode;
    /** 小额免密标志 */
    private IndividualFlag piFlag;
    /** 对账代码 */
    private String reaccountCd;
    /** 主源模块 */
    private SourceModule mainSourceModule;
    /** 老系统交易备注 */
    private String oldDataRemark;
    /** 结售汇收入方交易编码 */
    private String exchangeTranCode;
    /** 结售汇支出方交易编码 */
    private String exchangeTranCodet;

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

    public String getSubSeqNo() {
        return subSeqNo;
    }

    public void setSubSeqNo(String subSeqNo) {
        this.subSeqNo = subSeqNo;
    }

    public String getTaeSubSeqNo() {
        return taeSubSeqNo;
    }

    public void setTaeSubSeqNo(String taeSubSeqNo) {
        this.taeSubSeqNo = taeSubSeqNo;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
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

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public String getSubAcctNo() {
        return subAcctNo;
    }

    public void setSubAcctNo(String subAcctNo) {
        this.subAcctNo = subAcctNo;
    }

    public AcctClass getAcctClass() {
        return acctClass;
    }

    public void setAcctClass(AcctClass acctClass) {
        this.acctClass = acctClass;
    }

    public AcctStatus getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(AcctStatus acctStatus) {
        this.acctStatus = acctStatus;
    }

    public IndividualFlag getAcctRealFlag() {
        return acctRealFlag;
    }

    public void setAcctRealFlag(IndividualFlag acctRealFlag) {
        this.acctRealFlag = acctRealFlag;
    }

    public AcctTranFlag getAcctTranFlag() {
        return acctTranFlag;
    }

    public void setAcctTranFlag(AcctTranFlag acctTranFlag) {
        this.acctTranFlag = acctTranFlag;
    }

    public String getAcctDesc() {
        return acctDesc;
    }

    public void setAcctDesc(String acctDesc) {
        this.acctDesc = acctDesc;
    }

    public AcctBranch getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(AcctBranch acctBranch) {
        this.acctBranch = acctBranch;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
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

    public CrDrInd getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(CrDrInd crDrInd) {
        this.crDrInd = crDrInd;
    }

    public AcctCcy getCcy() {
        return ccy;
    }

    public void setCcy(AcctCcy ccy) {
        this.ccy = ccy;
    }

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public String getTranDesc() {
        return tranDesc;
    }

    public void setTranDesc(String tranDesc) {
        this.tranDesc = tranDesc;
    }

    public BigDecimal getPreviousBalAmt() {
        return previousBalAmt;
    }

    public void setPreviousBalAmt(BigDecimal previousBalAmt) {
        this.previousBalAmt = previousBalAmt;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public BigDecimal getActualBal() {
        return actualBal;
    }

    public void setActualBal(BigDecimal actualBal) {
        this.actualBal = actualBal;
    }

    public TranCategory getTranCategory() {
        return tranCategory;
    }

    public void setTranCategory(TranCategory tranCategory) {
        this.tranCategory = tranCategory;
    }

    public String getGlCode() {
        return glCode;
    }

    public void setGlCode(String glCode) {
        this.glCode = glCode;
    }

    public String getOthReference() {
        return othReference;
    }

    public void setOthReference(String othReference) {
        this.othReference = othReference;
    }

    public Integer getOthInternalKey() {
        return othInternalKey;
    }

    public void setOthInternalKey(Integer othInternalKey) {
        this.othInternalKey = othInternalKey;
    }

    public String getOthBaseAcctNo() {
        return othBaseAcctNo;
    }

    public void setOthBaseAcctNo(String othBaseAcctNo) {
        this.othBaseAcctNo = othBaseAcctNo;
    }

    public AcctCcy getOthAcctCcy() {
        return othAcctCcy;
    }

    public void setOthAcctCcy(AcctCcy othAcctCcy) {
        this.othAcctCcy = othAcctCcy;
    }

    public String getOthAcctSeqNo() {
        return othAcctSeqNo;
    }

    public void setOthAcctSeqNo(String othAcctSeqNo) {
        this.othAcctSeqNo = othAcctSeqNo;
    }

    public String getFhSeqNo() {
        return fhSeqNo;
    }

    public void setFhSeqNo(String fhSeqNo) {
        this.fhSeqNo = fhSeqNo;
    }

    public String getOthProdType() {
        return othProdType;
    }

    public void setOthProdType(String othProdType) {
        this.othProdType = othProdType;
    }

    public String getOthAcctDesc() {
        return othAcctDesc;
    }

    public void setOthAcctDesc(String othAcctDesc) {
        this.othAcctDesc = othAcctDesc;
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

    public AcctBranch getOthBranch() {
        return othBranch;
    }

    public void setOthBranch(AcctBranch othBranch) {
        this.othBranch = othBranch;
    }

    public String getOthRealBankCode() {
        return othRealBankCode;
    }

    public void setOthRealBankCode(String othRealBankCode) {
        this.othRealBankCode = othRealBankCode;
    }

    public String getOthRealBankName() {
        return othRealBankName;
    }

    public void setOthRealBankName(String othRealBankName) {
        this.othRealBankName = othRealBankName;
    }

    public String getOthRealProdType() {
        return othRealProdType;
    }

    public void setOthRealProdType(String othRealProdType) {
        this.othRealProdType = othRealProdType;
    }

    public String getOthRealBaseAcctNo() {
        return othRealBaseAcctNo;
    }

    public void setOthRealBaseAcctNo(String othRealBaseAcctNo) {
        this.othRealBaseAcctNo = othRealBaseAcctNo;
    }

    public AcctCcy getContraAcctCcy() {
        return contraAcctCcy;
    }

    public void setContraAcctCcy(AcctCcy contraAcctCcy) {
        this.contraAcctCcy = contraAcctCcy;
    }

    public AcctCcy getFromCcy() {
        return fromCcy;
    }

    public void setFromCcy(AcctCcy fromCcy) {
        this.fromCcy = fromCcy;
    }

    public String getOthSeqNo() {
        return othSeqNo;
    }

    public void setOthSeqNo(String othSeqNo) {
        this.othSeqNo = othSeqNo;
    }

    public String getPrimaryTranSeqNo() {
        return primaryTranSeqNo;
    }

    public void setPrimaryTranSeqNo(String primaryTranSeqNo) {
        this.primaryTranSeqNo = primaryTranSeqNo;
    }

    public AcctCcy getToCcy() {
        return toCcy;
    }

    public void setToCcy(AcctCcy toCcy) {
        this.toCcy = toCcy;
    }

    public BigDecimal getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(BigDecimal fromAmount) {
        this.fromAmount = fromAmount;
    }

    public BigDecimal getToAmount() {
        return toAmount;
    }

    public void setToAmount(BigDecimal toAmount) {
        this.toAmount = toAmount;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public BusinessUnit getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(BusinessUnit businessUnit) {
        this.businessUnit = businessUnit;
    }

    public CashItem getCashItem() {
        return cashItem;
    }

    public void setCashItem(CashItem cashItem) {
        this.cashItem = cashItem;
    }

    public String getTranNote() {
        return tranNote;
    }

    public void setTranNote(String tranNote) {
        this.tranNote = tranNote;
    }

    public TranStatus getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(TranStatus tranStatus) {
        this.tranStatus = tranStatus;
    }

    public IndividualFlag getAutoReversalFlag() {
        return autoReversalFlag;
    }

    public void setAutoReversalFlag(IndividualFlag autoReversalFlag) {
        this.autoReversalFlag = autoReversalFlag;
    }

    public AmtCalcType getAmtCalcType() {
        return amtCalcType;
    }

    public void setAmtCalcType(AmtCalcType amtCalcType) {
        this.amtCalcType = amtCalcType;
    }

    public SourceType getChannel() {
        return channel;
    }

    public void setChannel(SourceType channel) {
        this.channel = channel;
    }

    public AmtType getAmtType() {
        return amtType;
    }

    public void setAmtType(AmtType amtType) {
        this.amtType = amtType;
    }

    public BalType getBalType() {
        return balType;
    }

    public void setBalType(BalType balType) {
        this.balType = balType;
    }

    public BigDecimal getContraEquivAmt() {
        return contraEquivAmt;
    }

    public void setContraEquivAmt(BigDecimal contraEquivAmt) {
        this.contraEquivAmt = contraEquivAmt;
    }

    public BigDecimal getActualBalAmtFin() {
        return actualBalAmtFin;
    }

    public void setActualBalAmtFin(BigDecimal actualBalAmtFin) {
        this.actualBalAmtFin = actualBalAmtFin;
    }

    public BigDecimal getBaseEquivAmt() {
        return baseEquivAmt;
    }

    public void setBaseEquivAmt(BigDecimal baseEquivAmt) {
        this.baseEquivAmt = baseEquivAmt;
    }

    public BigDecimal getFlatRate() {
        return flatRate;
    }

    public void setFlatRate(BigDecimal flatRate) {
        this.flatRate = flatRate;
    }

    public BigDecimal getOvToAmount() {
        return ovToAmount;
    }

    public void setOvToAmount(BigDecimal ovToAmount) {
        this.ovToAmount = ovToAmount;
    }

    public BigDecimal getCrossRate() {
        return crossRate;
    }

    public void setCrossRate(BigDecimal crossRate) {
        this.crossRate = crossRate;
    }

    public FromRateFlag getFromRateFlag() {
        return fromRateFlag;
    }

    public void setFromRateFlag(FromRateFlag fromRateFlag) {
        this.fromRateFlag = fromRateFlag;
    }

    public BigDecimal getFromXrate() {
        return fromXrate;
    }

    public void setFromXrate(BigDecimal fromXrate) {
        this.fromXrate = fromXrate;
    }

    public BigDecimal getOvCrossRate() {
        return ovCrossRate;
    }

    public void setOvCrossRate(BigDecimal ovCrossRate) {
        this.ovCrossRate = ovCrossRate;
    }

    public FromRateFlag getToRateFlag() {
        return toRateFlag;
    }

    public void setToRateFlag(FromRateFlag toRateFlag) {
        this.toRateFlag = toRateFlag;
    }

    public BigDecimal getToXrate() {
        return toXrate;
    }

    public void setToXrate(BigDecimal toXrate) {
        this.toXrate = toXrate;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public FinType getFinType() {
        return finType;
    }

    public void setFinType(FinType finType) {
        this.finType = finType;
    }

    public QuoteType getQuoteType() {
        return quoteType;
    }

    public void setQuoteType(QuoteType quoteType) {
        this.quoteType = quoteType;
    }

    public IndividualFlag getMediumFlag() {
        return mediumFlag;
    }

    public void setMediumFlag(IndividualFlag mediumFlag) {
        this.mediumFlag = mediumFlag;
    }

    public MediumType getMediumType() {
        return mediumType;
    }

    public void setMediumType(MediumType mediumType) {
        this.mediumType = mediumType;
    }

    public SourceModule getOrigSystem() {
        return origSystem;
    }

    public void setOrigSystem(SourceModule origSystem) {
        this.origSystem = origSystem;
    }

    public DocumentType getOthDocumentType() {
        return othDocumentType;
    }

    public void setOthDocumentType(DocumentType othDocumentType) {
        this.othDocumentType = othDocumentType;
    }

    public IndividualFlag getPbkUpdFlag() {
        return pbkUpdFlag;
    }

    public void setPbkUpdFlag(IndividualFlag pbkUpdFlag) {
        this.pbkUpdFlag = pbkUpdFlag;
    }

    public String getPrimaryEventType() {
        return primaryEventType;
    }

    public void setPrimaryEventType(String primaryEventType) {
        this.primaryEventType = primaryEventType;
    }

    public RateType getRateType() {
        return rateType;
    }

    public void setRateType(RateType rateType) {
        this.rateType = rateType;
    }

    public TranMethod getTranMethod() {
        return tranMethod;
    }

    public void setTranMethod(TranMethod tranMethod) {
        this.tranMethod = tranMethod;
    }

    public WithdrawalType getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(WithdrawalType withdrawalType) {
        this.withdrawalType = withdrawalType;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getBankSeqNo() {
        return bankSeqNo;
    }

    public void setBankSeqNo(String bankSeqNo) {
        this.bankSeqNo = bankSeqNo;
    }

    public String getCommissionClientTel() {
        return commissionClientTel;
    }

    public void setCommissionClientTel(String commissionClientTel) {
        this.commissionClientTel = commissionClientTel;
    }

    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }

    public String getLimitRefList() {
        return limitRefList;
    }

    public void setLimitRefList(String limitRefList) {
        this.limitRefList = limitRefList;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public OthBranchRegionalismCode getOthBranchRegionalismCode() {
        return othBranchRegionalismCode;
    }

    public void setOthBranchRegionalismCode(OthBranchRegionalismCode othBranchRegionalismCode) {
        this.othBranchRegionalismCode = othBranchRegionalismCode;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getOthDocumentId() {
        return othDocumentId;
    }

    public void setOthDocumentId(String othDocumentId) {
        this.othDocumentId = othDocumentId;
    }

    public OthBranchRegionalismCode getOthRealBranchRegionCode() {
        return othRealBranchRegionCode;
    }

    public void setOthRealBranchRegionCode(OthBranchRegionalismCode othRealBranchRegionCode) {
        this.othRealBranchRegionCode = othRealBranchRegionCode;
    }

    public String getOthRealDocumentId() {
        return othRealDocumentId;
    }

    public void setOthRealDocumentId(String othRealDocumentId) {
        this.othRealDocumentId = othRealDocumentId;
    }

    public DocumentType getOthRealDocumentType() {
        return othRealDocumentType;
    }

    public void setOthRealDocumentType(DocumentType othRealDocumentType) {
        this.othRealDocumentType = othRealDocumentType;
    }

    public String getOthTranAddr() {
        return othTranAddr;
    }

    public void setOthTranAddr(String othTranAddr) {
        this.othTranAddr = othTranAddr;
    }

    public String getOthRealTranAddr() {
        return othRealTranAddr;
    }

    public void setOthRealTranAddr(String othRealTranAddr) {
        this.othRealTranAddr = othRealTranAddr;
    }

    public String getOthTranName() {
        return othTranName;
    }

    public void setOthTranName(String othTranName) {
        this.othTranName = othTranName;
    }

    public String getOthRealTranName() {
        return othRealTranName;
    }

    public void setOthRealTranName(String othRealTranName) {
        this.othRealTranName = othRealTranName;
    }

    public String getPayUnit() {
        return payUnit;
    }

    public void setPayUnit(String payUnit) {
        this.payUnit = payUnit;
    }

    public Integer getPrintCnt() {
        return printCnt;
    }

    public void setPrintCnt(Integer printCnt) {
        this.printCnt = printCnt;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getSendSystem() {
        return sendSystem;
    }

    public void setSendSystem(String sendSystem) {
        this.sendSystem = sendSystem;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public QuoteType getToId() {
        return toId;
    }

    public void setToId(QuoteType toId) {
        this.toId = toId;
    }

    public IndividualFlag getServCharge() {
        return servCharge;
    }

    public void setServCharge(IndividualFlag servCharge) {
        this.servCharge = servCharge;
    }

    public String getCommissionClientName() {
        return commissionClientName;
    }

    public void setCommissionClientName(String commissionClientName) {
        this.commissionClientName = commissionClientName;
    }

    public ProfitCenter getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(ProfitCenter profitCenter) {
        this.profitCenter = profitCenter;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public SourceModule getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(SourceModule sourceModule) {
        this.sourceModule = sourceModule;
    }

    public java.util.Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(java.util.Date effectDate) {
        this.effectDate = effectDate;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getReversalSeqNo() {
        return reversalSeqNo;
    }

    public void setReversalSeqNo(String reversalSeqNo) {
        this.reversalSeqNo = reversalSeqNo;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public TranType getReversalTranType() {
        return reversalTranType;
    }

    public void setReversalTranType(TranType reversalTranType) {
        this.reversalTranType = reversalTranType;
    }

    public IndividualFlag getReversalFlag() {
        return reversalFlag;
    }

    public void setReversalFlag(IndividualFlag reversalFlag) {
        this.reversalFlag = reversalFlag;
    }

    public java.util.Date getReversalDate() {
        return reversalDate;
    }

    public void setReversalDate(java.util.Date reversalDate) {
        this.reversalDate = reversalDate;
    }

    public java.util.Date getChannelDate() {
        return channelDate;
    }

    public void setChannelDate(java.util.Date channelDate) {
        this.channelDate = channelDate;
    }

    public java.util.Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(java.util.Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public AccountingStatus getAccountingStatus() {
        return accountingStatus;
    }

    public void setAccountingStatus(AccountingStatus accountingStatus) {
        this.accountingStatus = accountingStatus;
    }

    public IndividualFlag getGlPostedFlag() {
        return glPostedFlag;
    }

    public void setGlPostedFlag(IndividualFlag glPostedFlag) {
        this.glPostedFlag = glPostedFlag;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getApprUserId() {
        return apprUserId;
    }

    public void setApprUserId(String apprUserId) {
        this.apprUserId = apprUserId;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    public String getOrigTranTimestamp() {
        return origTranTimestamp;
    }

    public void setOrigTranTimestamp(String origTranTimestamp) {
        this.origTranTimestamp = origTranTimestamp;
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

    public java.util.Date getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(java.util.Date chequeDate) {
        this.chequeDate = chequeDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public IssCountry getCashUsePlaceCode() {
        return cashUsePlaceCode;
    }

    public void setCashUsePlaceCode(IssCountry cashUsePlaceCode) {
        this.cashUsePlaceCode = cashUsePlaceCode;
    }

    public CashUseRemark getCashUseRemark() {
        return cashUseRemark;
    }

    public void setCashUseRemark(CashUseRemark cashUseRemark) {
        this.cashUseRemark = cashUseRemark;
    }

    public IssCountry getCashSourceCountry() {
        return cashSourceCountry;
    }

    public void setCashSourceCountry(IssCountry cashSourceCountry) {
        this.cashSourceCountry = cashSourceCountry;
    }

    public CashSourceRemark getCashSourceRemark() {
        return cashSourceRemark;
    }

    public void setCashSourceRemark(CashSourceRemark cashSourceRemark) {
        this.cashSourceRemark = cashSourceRemark;
    }

    public IndividualFlag getTaeFlag() {
        return taeFlag;
    }

    public void setTaeFlag(IndividualFlag taeFlag) {
        this.taeFlag = taeFlag;
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getDealNo() {
        return dealNo;
    }

    public void setDealNo(String dealNo) {
        this.dealNo = dealNo;
    }

    public String getDealCode() {
        return dealCode;
    }

    public void setDealCode(String dealCode) {
        this.dealCode = dealCode;
    }

    public String getInputMediumId() {
        return inputMediumId;
    }

    public void setInputMediumId(String inputMediumId) {
        this.inputMediumId = inputMediumId;
    }

    public TellerTerminalType getTellerTerminalType() {
        return tellerTerminalType;
    }

    public void setTellerTerminalType(TellerTerminalType tellerTerminalType) {
        this.tellerTerminalType = tellerTerminalType;
    }

    public ApprIndicator getApprIndicator() {
        return apprIndicator;
    }

    public void setApprIndicator(ApprIndicator apprIndicator) {
        this.apprIndicator = apprIndicator;
    }

    public String getApprTerminalId() {
        return apprTerminalId;
    }

    public void setApprTerminalId(String apprTerminalId) {
        this.apprTerminalId = apprTerminalId;
    }

    public IndividualFlag getPrintIndicator() {
        return printIndicator;
    }

    public void setPrintIndicator(IndividualFlag printIndicator) {
        this.printIndicator = printIndicator;
    }

    public RemainTerm getRemainTerm() {
        return remainTerm;
    }

    public void setRemainTerm(RemainTerm remainTerm) {
        this.remainTerm = remainTerm;
    }

    public TellerTerminalType getInputMediumType() {
        return inputMediumType;
    }

    public void setInputMediumType(TellerTerminalType inputMediumType) {
        this.inputMediumType = inputMediumType;
    }

    public IssCountry getTranCountry() {
        return tranCountry;
    }

    public void setTranCountry(IssCountry tranCountry) {
        this.tranCountry = tranCountry;
    }

    public BigDecimal getLcyTranAmt() {
        return lcyTranAmt;
    }

    public void setLcyTranAmt(BigDecimal lcyTranAmt) {
        this.lcyTranAmt = lcyTranAmt;
    }

    public BigDecimal getCustRate() {
        return custRate;
    }

    public void setCustRate(BigDecimal custRate) {
        this.custRate = custRate;
    }

    public IndividualFlag getAutoTradeFlag() {
        return autoTradeFlag;
    }

    public void setAutoTradeFlag(IndividualFlag autoTradeFlag) {
        this.autoTradeFlag = autoTradeFlag;
    }

    public String getTreatsChannelNo() {
        return treatsChannelNo;
    }

    public void setTreatsChannelNo(String treatsChannelNo) {
        this.treatsChannelNo = treatsChannelNo;
    }

    public String getTreatsReference() {
        return treatsReference;
    }

    public void setTreatsReference(String treatsReference) {
        this.treatsReference = treatsReference;
    }

    public BigDecimal getTackOverCcyRateOne() {
        return tackOverCcyRateOne;
    }

    public void setTackOverCcyRateOne(BigDecimal tackOverCcyRateOne) {
        this.tackOverCcyRateOne = tackOverCcyRateOne;
    }

    public BigDecimal getTackOverCcyRateTwo() {
        return tackOverCcyRateTwo;
    }

    public void setTackOverCcyRateTwo(BigDecimal tackOverCcyRateTwo) {
        this.tackOverCcyRateTwo = tackOverCcyRateTwo;
    }

    public String getMaturityNarrative1() {
        return maturityNarrative1;
    }

    public void setMaturityNarrative1(String maturityNarrative1) {
        this.maturityNarrative1 = maturityNarrative1;
    }

    public String getMaturityNarrative2() {
        return maturityNarrative2;
    }

    public void setMaturityNarrative2(String maturityNarrative2) {
        this.maturityNarrative2 = maturityNarrative2;
    }

    public String getMaturityNarrative3() {
        return maturityNarrative3;
    }

    public void setMaturityNarrative3(String maturityNarrative3) {
        this.maturityNarrative3 = maturityNarrative3;
    }

    public String getMaturityNarrative4() {
        return maturityNarrative4;
    }

    public void setMaturityNarrative4(String maturityNarrative4) {
        this.maturityNarrative4 = maturityNarrative4;
    }

    public BigDecimal getBaseCcyAmountOne() {
        return baseCcyAmountOne;
    }

    public void setBaseCcyAmountOne(BigDecimal baseCcyAmountOne) {
        this.baseCcyAmountOne = baseCcyAmountOne;
    }

    public BigDecimal getBaseCcyAmountTwo() {
        return baseCcyAmountTwo;
    }

    public void setBaseCcyAmountTwo(BigDecimal baseCcyAmountTwo) {
        this.baseCcyAmountTwo = baseCcyAmountTwo;
    }

    public String getBusSeqNo() {
        return busSeqNo;
    }

    public void setBusSeqNo(String busSeqNo) {
        this.busSeqNo = busSeqNo;
    }

    public String getCashFromCode() {
        return cashFromCode;
    }

    public void setCashFromCode(String cashFromCode) {
        this.cashFromCode = cashFromCode;
    }

    public IssCountry getCashFromCountry() {
        return cashFromCountry;
    }

    public void setCashFromCountry(IssCountry cashFromCountry) {
        this.cashFromCountry = cashFromCountry;
    }

    public String getCashToCode() {
        return cashToCode;
    }

    public void setCashToCode(String cashToCode) {
        this.cashToCode = cashToCode;
    }

    public IssCountry getCashToCountry() {
        return cashToCountry;
    }

    public void setCashToCountry(IssCountry cashToCountry) {
        this.cashToCountry = cashToCountry;
    }

    public java.util.Date getContraTranDate() {
        return contraTranDate;
    }

    public void setContraTranDate(java.util.Date contraTranDate) {
        this.contraTranDate = contraTranDate;
    }

    public String getLoanProdType() {
        return loanProdType;
    }

    public void setLoanProdType(String loanProdType) {
        this.loanProdType = loanProdType;
    }

    public String getNarrativeCode() {
        return narrativeCode;
    }

    public void setNarrativeCode(String narrativeCode) {
        this.narrativeCode = narrativeCode;
    }

    public IndividualFlag getPiFlag() {
        return piFlag;
    }

    public void setPiFlag(IndividualFlag piFlag) {
        this.piFlag = piFlag;
    }

    public String getReaccountCd() {
        return reaccountCd;
    }

    public void setReaccountCd(String reaccountCd) {
        this.reaccountCd = reaccountCd;
    }

    public SourceModule getMainSourceModule() {
        return mainSourceModule;
    }

    public void setMainSourceModule(SourceModule mainSourceModule) {
        this.mainSourceModule = mainSourceModule;
    }

    public String getOldDataRemark() {
        return oldDataRemark;
    }

    public void setOldDataRemark(String oldDataRemark) {
        this.oldDataRemark = oldDataRemark;
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
}