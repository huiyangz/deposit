package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbTranHist {
    /** 序号 */
    private String seqNo;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 子流水号 */
    private String subSeqNo;
    /** TAE子流水号 */
    private String taeSubSeqNo;
    /** 渠道类型 */
    private String sourceType;
    /** 交易参考号 */
    private String reference;
    /** 客户号 */
    private String clientNo;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 账户币种 */
    private String acctCcy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 子账号 */
    private String subAcctNo;
    /** 账户类别 */
    private String acctClass;
    /** 账户状态 */
    private String acctStatus;
    /** 账户虚实标志 */
    private String acctRealFlag;
    /** 账户交易标志 */
    private String acctTranFlag;
    /** 账户描述 */
    private String acctDesc;
    /** 账户开立行行号 */
    private String acctBranch;
    /** 事件类型 */
    private String eventType;
    /** 交易日期 */
    private Date tranDate;
    /** 交易机构号 */
    private String tranBranch;
    /** 借贷标志 */
    private String crDrInd;
    /** 币种 */
    private String ccy;
    /** 交易类型 */
    private String tranType;
    /** 交易描述 */
    private String tranDesc;
    /** 交易前余额 */
    private BigDecimal previousBalAmt;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 实际余额 */
    private BigDecimal actualBal;
    /** 计价方式 */
    private String tranCategory;
    /** 科目代码 */
    private String glCode;
    /** 对手交易业务流水号 */
    private String othReference;
    /** 对手账户内部键 */
    private Integer othInternalKey;
    /** 对手账号 */
    private String othBaseAcctNo;
    /** 对手账户币种 */
    private String othAcctCcy;
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
    private String othBranch;
    /** 实际对手机构号 */
    private String othRealBankCode;
    /** 真实对方金融机构名称 */
    private String othRealBankName;
    /** 实际对手产品编号 */
    private String othRealProdType;
    /** 实际对手账号 */
    private String othRealBaseAcctNo;
    /** 他行账户币种 */
    private String contraAcctCcy;
    /** 转出币种 */
    private String fromCcy;
    /** 对手交易流水号 */
    private String othSeqNo;
    /** 主交易流水号 */
    private String primaryTranSeqNo;
    /** 转入币种 */
    private String toCcy;
    /** 源金额 */
    private BigDecimal fromAmount;
    /** 移入金额 */
    private BigDecimal toAmount;
    /** 凭证类型 */
    private String docType;
    /** 凭证前缀编码 */
    private String prefix;
    /** 凭证号 */
    private String voucherNo;
    /** 证件号码 */
    private String documentId;
    /** 证件类型 */
    private String documentType;
    /** 客户名称 */
    private String clientName;
    /** 客户类型 */
    private String clientType;
    /** 票据号码 */
    private String billNo;
    /** 账套编号 */
    private String businessUnit;
    /** 现金项目编号 */
    private String cashItem;
    /** 交易附言 */
    private String tranNote;
    /** 业务处理状态 */
    private String tranStatus;
    /** 自动冲正标志 */
    private String autoReversalFlag;
    /** 金额计算规则 */
    private String amtCalcType;
    /** 渠道 */
    private String channel;
    /** 金额类型 */
    private String amtType;
    /** 余额类型 */
    private String balType;
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
    private String fromRateFlag;
    /** 买方汇率 */
    private BigDecimal fromXrate;
    /** 执行交叉汇率 */
    private BigDecimal ovCrossRate;
    /** 卖方交易汇率标志 */
    private String toRateFlag;
    /** 对手汇率 */
    private BigDecimal toXrate;
    /** 中间业务类型 */
    private String bizType;
    /** 理财类型 */
    private String finType;
    /** 报价类型 */
    private String quoteType;
    /** 有介质标志 */
    private String mediumFlag;
    /** 介质类型 */
    private String mediumType;
    /** 原交易业务模块 */
    private String origSystem;
    /** 对手证明类型 */
    private String othDocumentType;
    /** 补登存折标志 */
    private String pbkUpdFlag;
    /** 主事件类型 */
    private String primaryEventType;
    /** 汇率类型 */
    private String rateType;
    /** 到账方式 */
    private String tranMethod;
    /** 支取方式 */
    private String withdrawalType;
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
    private String othBranchRegionalismCode;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 对手证件号码 */
    private String othDocumentId;
    /** 实际对手机构行政区划代码 */
    private String othRealBranchRegionCode;
    /** 实际对手身份证件号码 */
    private String othRealDocumentId;
    /** 实际对手证件类型 */
    private String othRealDocumentType;
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
    private String toId;
    /** 服务费收取标志 */
    private String servCharge;
    /** 代办人名称 */
    private String commissionClientName;
    /** 利润中心 */
    private String profitCenter;
    /** 交易代码 */
    private String programId;
    /** 源模块 */
    private String sourceModule;
    /** 生效日期 */
    private Date effectDate;
    /** 系统编码 */
    private String systemCode;
    /** 冲正流水号 */
    private String reversalSeqNo;
    /** 终端编号 */
    private String terminalId;
    /** 跟踪ID */
    private String traceId;
    /** 冲正交易类型 */
    private String reversalTranType;
    /** 冲正标志 */
    private String reversalFlag;
    /** 冲正日期 */
    private Date reversalDate;
    /** 渠道日期 */
    private Date channelDate;
    /** 清算日期 */
    private Date settlementDate;
    /** 核算状态 */
    private String accountingStatus;
    /** 过账标志 */
    private String glPostedFlag;
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
    private String company;
    /** 支票出票日期 */
    private Date chequeDate;
    /** 备注 */
    private String remark;
    /** 现钞使用地区代码 */
    private String cashUsePlaceCode;
    /** 现钞使用 */
    private String cashUseRemark;
    /** 现钞来源国家 */
    private String cashSourceCountry;
    /** 现钞来源说明 */
    private String cashSourceRemark;
    /** tae记账标志 */
    private String taeFlag;
    /** 传输代码 */
    private String tranCode;
    /** 处理流水号 */
    private String dealNo;
    /** 支付记账处理代码 */
    private String dealCode;
    /** 输入程序ID */
    private String inputMediumId;
    /** 柜面终端类型 */
    private String tellerTerminalType;
    /** 复核标识 */
    private String apprIndicator;
    /** 复核终端ID */
    private String apprTerminalId;
    /** 打印标志 */
    private String printIndicator;
    /** 定期账户剩余期限 */
    private String remainTerm;
    /** 输入终端类型 */
    private String inputMediumType;
    /** 交易国家 */
    private String tranCountry;
    /** 本币交易金额 */
    private BigDecimal lcyTranAmt;
    /** 对客汇率 */
    private BigDecimal custRate;
    /** 自动交易标志 */
    private String autoTradeFlag;
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
    private String cashFromCountry;
    /** 现钞去向代码 */
    private String cashToCode;
    /** 现钞去向国家 */
    private String cashToCountry;
    /** 他行交易日期 */
    private Date contraTranDate;
    /** 贷款产品类型 */
    private String loanProdType;
    /** 摘要码 */
    private String narrativeCode;
    /** 小额免密标志 */
    private String piFlag;
    /** 对账代码 */
    private String reaccountCd;
    /** 主源模块 */
    private String mainSourceModule;
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

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
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

    public String getSubAcctNo() {
        return subAcctNo;
    }

    public void setSubAcctNo(String subAcctNo) {
        this.subAcctNo = subAcctNo;
    }

    public String getAcctClass() {
        return acctClass;
    }

    public void setAcctClass(String acctClass) {
        this.acctClass = acctClass;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getAcctRealFlag() {
        return acctRealFlag;
    }

    public void setAcctRealFlag(String acctRealFlag) {
        this.acctRealFlag = acctRealFlag;
    }

    public String getAcctTranFlag() {
        return acctTranFlag;
    }

    public void setAcctTranFlag(String acctTranFlag) {
        this.acctTranFlag = acctTranFlag;
    }

    public String getAcctDesc() {
        return acctDesc;
    }

    public void setAcctDesc(String acctDesc) {
        this.acctDesc = acctDesc;
    }

    public String getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(String acctBranch) {
        this.acctBranch = acctBranch;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
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

    public String getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(String crDrInd) {
        this.crDrInd = crDrInd;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
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

    public String getTranCategory() {
        return tranCategory;
    }

    public void setTranCategory(String tranCategory) {
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

    public String getOthBranch() {
        return othBranch;
    }

    public void setOthBranch(String othBranch) {
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

    public String getContraAcctCcy() {
        return contraAcctCcy;
    }

    public void setContraAcctCcy(String contraAcctCcy) {
        this.contraAcctCcy = contraAcctCcy;
    }

    public String getFromCcy() {
        return fromCcy;
    }

    public void setFromCcy(String fromCcy) {
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

    public String getToCcy() {
        return toCcy;
    }

    public void setToCcy(String toCcy) {
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

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getCashItem() {
        return cashItem;
    }

    public void setCashItem(String cashItem) {
        this.cashItem = cashItem;
    }

    public String getTranNote() {
        return tranNote;
    }

    public void setTranNote(String tranNote) {
        this.tranNote = tranNote;
    }

    public String getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(String tranStatus) {
        this.tranStatus = tranStatus;
    }

    public String getAutoReversalFlag() {
        return autoReversalFlag;
    }

    public void setAutoReversalFlag(String autoReversalFlag) {
        this.autoReversalFlag = autoReversalFlag;
    }

    public String getAmtCalcType() {
        return amtCalcType;
    }

    public void setAmtCalcType(String amtCalcType) {
        this.amtCalcType = amtCalcType;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getAmtType() {
        return amtType;
    }

    public void setAmtType(String amtType) {
        this.amtType = amtType;
    }

    public String getBalType() {
        return balType;
    }

    public void setBalType(String balType) {
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

    public String getFromRateFlag() {
        return fromRateFlag;
    }

    public void setFromRateFlag(String fromRateFlag) {
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

    public String getToRateFlag() {
        return toRateFlag;
    }

    public void setToRateFlag(String toRateFlag) {
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

    public String getFinType() {
        return finType;
    }

    public void setFinType(String finType) {
        this.finType = finType;
    }

    public String getQuoteType() {
        return quoteType;
    }

    public void setQuoteType(String quoteType) {
        this.quoteType = quoteType;
    }

    public String getMediumFlag() {
        return mediumFlag;
    }

    public void setMediumFlag(String mediumFlag) {
        this.mediumFlag = mediumFlag;
    }

    public String getMediumType() {
        return mediumType;
    }

    public void setMediumType(String mediumType) {
        this.mediumType = mediumType;
    }

    public String getOrigSystem() {
        return origSystem;
    }

    public void setOrigSystem(String origSystem) {
        this.origSystem = origSystem;
    }

    public String getOthDocumentType() {
        return othDocumentType;
    }

    public void setOthDocumentType(String othDocumentType) {
        this.othDocumentType = othDocumentType;
    }

    public String getPbkUpdFlag() {
        return pbkUpdFlag;
    }

    public void setPbkUpdFlag(String pbkUpdFlag) {
        this.pbkUpdFlag = pbkUpdFlag;
    }

    public String getPrimaryEventType() {
        return primaryEventType;
    }

    public void setPrimaryEventType(String primaryEventType) {
        this.primaryEventType = primaryEventType;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getTranMethod() {
        return tranMethod;
    }

    public void setTranMethod(String tranMethod) {
        this.tranMethod = tranMethod;
    }

    public String getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(String withdrawalType) {
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

    public String getOthBranchRegionalismCode() {
        return othBranchRegionalismCode;
    }

    public void setOthBranchRegionalismCode(String othBranchRegionalismCode) {
        this.othBranchRegionalismCode = othBranchRegionalismCode;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getOthDocumentId() {
        return othDocumentId;
    }

    public void setOthDocumentId(String othDocumentId) {
        this.othDocumentId = othDocumentId;
    }

    public String getOthRealBranchRegionCode() {
        return othRealBranchRegionCode;
    }

    public void setOthRealBranchRegionCode(String othRealBranchRegionCode) {
        this.othRealBranchRegionCode = othRealBranchRegionCode;
    }

    public String getOthRealDocumentId() {
        return othRealDocumentId;
    }

    public void setOthRealDocumentId(String othRealDocumentId) {
        this.othRealDocumentId = othRealDocumentId;
    }

    public String getOthRealDocumentType() {
        return othRealDocumentType;
    }

    public void setOthRealDocumentType(String othRealDocumentType) {
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

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getServCharge() {
        return servCharge;
    }

    public void setServCharge(String servCharge) {
        this.servCharge = servCharge;
    }

    public String getCommissionClientName() {
        return commissionClientName;
    }

    public void setCommissionClientName(String commissionClientName) {
        this.commissionClientName = commissionClientName;
    }

    public String getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(String profitCenter) {
        this.profitCenter = profitCenter;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(String sourceModule) {
        this.sourceModule = sourceModule;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
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

    public String getReversalTranType() {
        return reversalTranType;
    }

    public void setReversalTranType(String reversalTranType) {
        this.reversalTranType = reversalTranType;
    }

    public String getReversalFlag() {
        return reversalFlag;
    }

    public void setReversalFlag(String reversalFlag) {
        this.reversalFlag = reversalFlag;
    }

    public Date getReversalDate() {
        return reversalDate;
    }

    public void setReversalDate(Date reversalDate) {
        this.reversalDate = reversalDate;
    }

    public Date getChannelDate() {
        return channelDate;
    }

    public void setChannelDate(Date channelDate) {
        this.channelDate = channelDate;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public String getAccountingStatus() {
        return accountingStatus;
    }

    public void setAccountingStatus(String accountingStatus) {
        this.accountingStatus = accountingStatus;
    }

    public String getGlPostedFlag() {
        return glPostedFlag;
    }

    public void setGlPostedFlag(String glPostedFlag) {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(Date chequeDate) {
        this.chequeDate = chequeDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCashUsePlaceCode() {
        return cashUsePlaceCode;
    }

    public void setCashUsePlaceCode(String cashUsePlaceCode) {
        this.cashUsePlaceCode = cashUsePlaceCode;
    }

    public String getCashUseRemark() {
        return cashUseRemark;
    }

    public void setCashUseRemark(String cashUseRemark) {
        this.cashUseRemark = cashUseRemark;
    }

    public String getCashSourceCountry() {
        return cashSourceCountry;
    }

    public void setCashSourceCountry(String cashSourceCountry) {
        this.cashSourceCountry = cashSourceCountry;
    }

    public String getCashSourceRemark() {
        return cashSourceRemark;
    }

    public void setCashSourceRemark(String cashSourceRemark) {
        this.cashSourceRemark = cashSourceRemark;
    }

    public String getTaeFlag() {
        return taeFlag;
    }

    public void setTaeFlag(String taeFlag) {
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

    public String getTellerTerminalType() {
        return tellerTerminalType;
    }

    public void setTellerTerminalType(String tellerTerminalType) {
        this.tellerTerminalType = tellerTerminalType;
    }

    public String getApprIndicator() {
        return apprIndicator;
    }

    public void setApprIndicator(String apprIndicator) {
        this.apprIndicator = apprIndicator;
    }

    public String getApprTerminalId() {
        return apprTerminalId;
    }

    public void setApprTerminalId(String apprTerminalId) {
        this.apprTerminalId = apprTerminalId;
    }

    public String getPrintIndicator() {
        return printIndicator;
    }

    public void setPrintIndicator(String printIndicator) {
        this.printIndicator = printIndicator;
    }

    public String getRemainTerm() {
        return remainTerm;
    }

    public void setRemainTerm(String remainTerm) {
        this.remainTerm = remainTerm;
    }

    public String getInputMediumType() {
        return inputMediumType;
    }

    public void setInputMediumType(String inputMediumType) {
        this.inputMediumType = inputMediumType;
    }

    public String getTranCountry() {
        return tranCountry;
    }

    public void setTranCountry(String tranCountry) {
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

    public String getAutoTradeFlag() {
        return autoTradeFlag;
    }

    public void setAutoTradeFlag(String autoTradeFlag) {
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

    public String getCashFromCountry() {
        return cashFromCountry;
    }

    public void setCashFromCountry(String cashFromCountry) {
        this.cashFromCountry = cashFromCountry;
    }

    public String getCashToCode() {
        return cashToCode;
    }

    public void setCashToCode(String cashToCode) {
        this.cashToCode = cashToCode;
    }

    public String getCashToCountry() {
        return cashToCountry;
    }

    public void setCashToCountry(String cashToCountry) {
        this.cashToCountry = cashToCountry;
    }

    public Date getContraTranDate() {
        return contraTranDate;
    }

    public void setContraTranDate(Date contraTranDate) {
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

    public String getPiFlag() {
        return piFlag;
    }

    public void setPiFlag(String piFlag) {
        this.piFlag = piFlag;
    }

    public String getReaccountCd() {
        return reaccountCd;
    }

    public void setReaccountCd(String reaccountCd) {
        this.reaccountCd = reaccountCd;
    }

    public String getMainSourceModule() {
        return mainSourceModule;
    }

    public void setMainSourceModule(String mainSourceModule) {
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