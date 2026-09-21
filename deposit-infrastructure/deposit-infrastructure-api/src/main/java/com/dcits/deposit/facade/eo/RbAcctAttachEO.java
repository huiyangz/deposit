package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.AcctOpenMode;
import com.dcits.deposit.enums.AcctOpenType;
import com.dcits.deposit.enums.AcctProperty2;
import com.dcits.deposit.enums.AcctRiskLevel;
import com.dcits.deposit.enums.AcctTellerSignFlag;
import com.dcits.deposit.enums.AcctVerifyResult;
import com.dcits.deposit.enums.AgreementDepositType;
import com.dcits.deposit.enums.AmountNature;
import com.dcits.deposit.enums.AnnualStatus;
import com.dcits.deposit.enums.BalanceWay;
import com.dcits.deposit.enums.BalUpdType;
import com.dcits.deposit.enums.BlacklistStatus;
import com.dcits.deposit.enums.CaseInvolvedFlag;
import com.dcits.deposit.enums.CheckCertificateType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DepositNature;
import com.dcits.deposit.enums.FarmerFlag;
import com.dcits.deposit.enums.HangWriteOffFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.LoanFundFlag;
import com.dcits.deposit.enums.ManageType;
import com.dcits.deposit.enums.MsgStatus;
import com.dcits.deposit.enums.ProdClass;
import com.dcits.deposit.enums.SimpleAcct;
import com.dcits.deposit.enums.SpecialProdClass;
import com.dcits.deposit.enums.StageLimitClass;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.Treatment;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbAcctAttachEO {
    /** 柜面跨机构支取标志 */
    private IndividualFlag counterCroBrchDebtFlag;
    /** 柜面跨机构存入标志 */
    private IndividualFlag counterCroBrchCretFlag;
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 科目代码 */
    private String glCode;
    /** 账户验证失败原因 */
    private String acctProofReason;
    /** 账户性质 */
    private AcctNature acctProperty;
    /** 余额联动变动标志 */
    private IndividualFlag balChgInd;
    /** 余额更新类型 */
    private BalUpdType balUpdType;
    /** 余额方向 */
    private BalanceWay balanceWay;
    /** 可透支标志 */
    private IndividualFlag odFacility;
    /** 按频率付息标志 */
    private IndividualFlag cycleIntFlag;
    /** 自动结清标志 */
    private IndividualFlag autoSettleFlag;
    /** 自动续存标志 */
    private IndividualFlag autoDep;
    /** 允许手工记账标志 */
    private IndividualFlag manualAccountFlag;
    /** 自贸区账户标志 */
    private IndividualFlag ftaAcctFlag;
    /** 自贸区代码 */
    private String ftaCode;
    /** 挂销账标志 */
    private HangWriteOffFlag hangWriteOffFlag;
    /** 挂账期限 */
    private String hangTerm;
    /** 非绑定存入标志 */
    private IndividualFlag unBindDepFlag;
    /** 产品分类 */
    private ProdClass prodClass;
    /** 特色产品签约分类 */
    private SpecialProdClass specialProdClass;
    /** 期次代码 */
    private String stageCode;
    /** 年检标志 */
    private IndividualFlag annualFlag;
    /** 年检状态标志 */
    private AnnualStatus annualStatus;
    /** 对公账户年检上一重置日期 */
    private java.util.Date lastResetDate;
    /** 上一年检截止日期 */
    private java.util.Date lastStopDate;
    /** 黑名单状态 */
    private BlacklistStatus blacklistStatus;
    /** 上一登记黑名单日期 */
    private java.util.Date lastBlacklistDate;
    /** 费用免费次数 */
    private Integer freeSum;
    /** 短信签约状态 */
    private MsgStatus msgStatus;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 账户转存期限 */
    private String autoRenewTerm;
    /** 账户转存存期类型 */
    private TermType autoRenewTermType;
    /** 累计可支取本金 */
    private BigDecimal totalDrawAmt;
    /** 通兑机构 */
    private AcctBranch allDraIntBranch;
    /** 允许账户转久悬标志 */
    private IndividualFlag allowSuspendFlag;
    /** 存款性质 */
    private DepositNature depositNature;
    /** 允许出售支票标志 */
    private IndividualFlag isSellCheque;
    /** 涉案标识 */
    private CaseInvolvedFlag caseInvolvedFlag;
    /** 提前支取日期 */
    private java.util.Date preDebtDate;
    /** 审批单号 */
    private String approvalNo;
    /** 协议编号 */
    private String agreementId;
    /** 开户模式 */
    private AcctOpenMode acctOpenMode;
    /** 协议存款类型 */
    private AgreementDepositType agreementDepositType;
    /** 下一续存日 */
    private String nextDepDay;
    /** 销户重开日期 */
    private java.util.Date reOpenDate;
    /** 开户方式 */
    private AcctOpenType acctOpenType;
    /** 税率 */
    private BigDecimal taxRate;
    /** 监管账户标志 */
    private IndividualFlag manageFlag;
    /** 利息税征收标志 */
    private IndividualFlag intTaxLevy;
    /** 账户风险级别 */
    private AcctRiskLevel acctRiskLevel;
    /** 农户标志 */
    private FarmerFlag farmerFlag;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 查证金额 */
    private BigDecimal checkCertificateAmt;
    /** 监管原因 */
    private String manageContent;
    /** 优惠利息税率到期日期 */
    private java.util.Date taxDiscountMaturityDate;
    /** 资金性质 */
    private AmountNature amountNature;
    /** 监管账户类型 */
    private ManageType manageType;
    /** 账户渠道标识 */
    private String acctChannelFlag;
    /** 账户性质2 */
    private AcctProperty2 acctProperty2;
    /** 查证类型 */
    private CheckCertificateType checkCertificateType;
    /** 延期付息标志 */
    private IndividualFlag delayPayInt;
    /** 快捷开户标志 */
    private IndividualFlag fastOpenAcctFlag;
    /** 最早支取日期 */
    private java.util.Date firstDrawDate;
    /** 是否联机 */
    private String onlineFlag;
    /** 延期付息指定日 */
    private String specDay;
    /** 处置方式 */
    private Treatment treatment;
    /** 转回日期 */
    private java.util.Date backToDate;
    /** 双边限额限制标志 */
    private IndividualFlag bothLimitFlag;
    /** 涉案日期 */
    private java.util.Date caseInvolvedDate;
    /** 涉案原因 */
    private String caseInvolvedReason;
    /** 隐私账户标志 */
    private IndividualFlag privateAcctFlag;
    /** 年检日期 */
    private java.util.Date annualDate;
    /** 账户机密标志 */
    private IndividualFlag secretAcct;
    /** 推介人名称 */
    private String promoterName;
    /** 推介人编号 */
    private String promoterCode;
    /** 客户经理名称 */
    private String acctExecName;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 客户经理工号 */
    private String acctExecCode;
    /** 归属条线名称 */
    private String lineOwnerShip;
    /** 允许自动销户标志 */
    private IndividualFlag isAllowClose;
    /** 额度扣减类型 */
    private StageLimitClass stageLimitClass;
    /** 漏存次数 */
    private Integer termLack;
    /** 续存总期数 */
    private Integer addTotalTerm;
    /** 简易账户标志 */
    private SimpleAcct simpleAcct;
    /** 贷款资金管控标志 */
    private LoanFundFlag loanFundFlag;
    /** 抵质押标志 */
    private IndividualFlag collatInd;
    /** 账户核实标志 */
    private IndividualFlag acctVerifyFlag;
    /** 账户核实结果 */
    private AcctVerifyResult acctVerifyResult;
    /** 账户验证标志 */
    private String acctProofFlag;
    /** 账户面签标志 */
    private AcctTellerSignFlag acctTellerSignFlag;

    public IndividualFlag getCounterCroBrchDebtFlag() {
        return counterCroBrchDebtFlag;
    }

    public void setCounterCroBrchDebtFlag(IndividualFlag counterCroBrchDebtFlag) {
        this.counterCroBrchDebtFlag = counterCroBrchDebtFlag;
    }

    public IndividualFlag getCounterCroBrchCretFlag() {
        return counterCroBrchCretFlag;
    }

    public void setCounterCroBrchCretFlag(IndividualFlag counterCroBrchCretFlag) {
        this.counterCroBrchCretFlag = counterCroBrchCretFlag;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getGlCode() {
        return glCode;
    }

    public void setGlCode(String glCode) {
        this.glCode = glCode;
    }

    public String getAcctProofReason() {
        return acctProofReason;
    }

    public void setAcctProofReason(String acctProofReason) {
        this.acctProofReason = acctProofReason;
    }

    public AcctNature getAcctProperty() {
        return acctProperty;
    }

    public void setAcctProperty(AcctNature acctProperty) {
        this.acctProperty = acctProperty;
    }

    public IndividualFlag getBalChgInd() {
        return balChgInd;
    }

    public void setBalChgInd(IndividualFlag balChgInd) {
        this.balChgInd = balChgInd;
    }

    public BalUpdType getBalUpdType() {
        return balUpdType;
    }

    public void setBalUpdType(BalUpdType balUpdType) {
        this.balUpdType = balUpdType;
    }

    public BalanceWay getBalanceWay() {
        return balanceWay;
    }

    public void setBalanceWay(BalanceWay balanceWay) {
        this.balanceWay = balanceWay;
    }

    public IndividualFlag getOdFacility() {
        return odFacility;
    }

    public void setOdFacility(IndividualFlag odFacility) {
        this.odFacility = odFacility;
    }

    public IndividualFlag getCycleIntFlag() {
        return cycleIntFlag;
    }

    public void setCycleIntFlag(IndividualFlag cycleIntFlag) {
        this.cycleIntFlag = cycleIntFlag;
    }

    public IndividualFlag getAutoSettleFlag() {
        return autoSettleFlag;
    }

    public void setAutoSettleFlag(IndividualFlag autoSettleFlag) {
        this.autoSettleFlag = autoSettleFlag;
    }

    public IndividualFlag getAutoDep() {
        return autoDep;
    }

    public void setAutoDep(IndividualFlag autoDep) {
        this.autoDep = autoDep;
    }

    public IndividualFlag getManualAccountFlag() {
        return manualAccountFlag;
    }

    public void setManualAccountFlag(IndividualFlag manualAccountFlag) {
        this.manualAccountFlag = manualAccountFlag;
    }

    public IndividualFlag getFtaAcctFlag() {
        return ftaAcctFlag;
    }

    public void setFtaAcctFlag(IndividualFlag ftaAcctFlag) {
        this.ftaAcctFlag = ftaAcctFlag;
    }

    public String getFtaCode() {
        return ftaCode;
    }

    public void setFtaCode(String ftaCode) {
        this.ftaCode = ftaCode;
    }

    public HangWriteOffFlag getHangWriteOffFlag() {
        return hangWriteOffFlag;
    }

    public void setHangWriteOffFlag(HangWriteOffFlag hangWriteOffFlag) {
        this.hangWriteOffFlag = hangWriteOffFlag;
    }

    public String getHangTerm() {
        return hangTerm;
    }

    public void setHangTerm(String hangTerm) {
        this.hangTerm = hangTerm;
    }

    public IndividualFlag getUnBindDepFlag() {
        return unBindDepFlag;
    }

    public void setUnBindDepFlag(IndividualFlag unBindDepFlag) {
        this.unBindDepFlag = unBindDepFlag;
    }

    public ProdClass getProdClass() {
        return prodClass;
    }

    public void setProdClass(ProdClass prodClass) {
        this.prodClass = prodClass;
    }

    public SpecialProdClass getSpecialProdClass() {
        return specialProdClass;
    }

    public void setSpecialProdClass(SpecialProdClass specialProdClass) {
        this.specialProdClass = specialProdClass;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public IndividualFlag getAnnualFlag() {
        return annualFlag;
    }

    public void setAnnualFlag(IndividualFlag annualFlag) {
        this.annualFlag = annualFlag;
    }

    public AnnualStatus getAnnualStatus() {
        return annualStatus;
    }

    public void setAnnualStatus(AnnualStatus annualStatus) {
        this.annualStatus = annualStatus;
    }

    public java.util.Date getLastResetDate() {
        return lastResetDate;
    }

    public void setLastResetDate(java.util.Date lastResetDate) {
        this.lastResetDate = lastResetDate;
    }

    public java.util.Date getLastStopDate() {
        return lastStopDate;
    }

    public void setLastStopDate(java.util.Date lastStopDate) {
        this.lastStopDate = lastStopDate;
    }

    public BlacklistStatus getBlacklistStatus() {
        return blacklistStatus;
    }

    public void setBlacklistStatus(BlacklistStatus blacklistStatus) {
        this.blacklistStatus = blacklistStatus;
    }

    public java.util.Date getLastBlacklistDate() {
        return lastBlacklistDate;
    }

    public void setLastBlacklistDate(java.util.Date lastBlacklistDate) {
        this.lastBlacklistDate = lastBlacklistDate;
    }

    public Integer getFreeSum() {
        return freeSum;
    }

    public void setFreeSum(Integer freeSum) {
        this.freeSum = freeSum;
    }

    public MsgStatus getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(MsgStatus msgStatus) {
        this.msgStatus = msgStatus;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
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

    public String getAutoRenewTerm() {
        return autoRenewTerm;
    }

    public void setAutoRenewTerm(String autoRenewTerm) {
        this.autoRenewTerm = autoRenewTerm;
    }

    public TermType getAutoRenewTermType() {
        return autoRenewTermType;
    }

    public void setAutoRenewTermType(TermType autoRenewTermType) {
        this.autoRenewTermType = autoRenewTermType;
    }

    public BigDecimal getTotalDrawAmt() {
        return totalDrawAmt;
    }

    public void setTotalDrawAmt(BigDecimal totalDrawAmt) {
        this.totalDrawAmt = totalDrawAmt;
    }

    public AcctBranch getAllDraIntBranch() {
        return allDraIntBranch;
    }

    public void setAllDraIntBranch(AcctBranch allDraIntBranch) {
        this.allDraIntBranch = allDraIntBranch;
    }

    public IndividualFlag getAllowSuspendFlag() {
        return allowSuspendFlag;
    }

    public void setAllowSuspendFlag(IndividualFlag allowSuspendFlag) {
        this.allowSuspendFlag = allowSuspendFlag;
    }

    public DepositNature getDepositNature() {
        return depositNature;
    }

    public void setDepositNature(DepositNature depositNature) {
        this.depositNature = depositNature;
    }

    public IndividualFlag getIsSellCheque() {
        return isSellCheque;
    }

    public void setIsSellCheque(IndividualFlag isSellCheque) {
        this.isSellCheque = isSellCheque;
    }

    public CaseInvolvedFlag getCaseInvolvedFlag() {
        return caseInvolvedFlag;
    }

    public void setCaseInvolvedFlag(CaseInvolvedFlag caseInvolvedFlag) {
        this.caseInvolvedFlag = caseInvolvedFlag;
    }

    public java.util.Date getPreDebtDate() {
        return preDebtDate;
    }

    public void setPreDebtDate(java.util.Date preDebtDate) {
        this.preDebtDate = preDebtDate;
    }

    public String getApprovalNo() {
        return approvalNo;
    }

    public void setApprovalNo(String approvalNo) {
        this.approvalNo = approvalNo;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public AcctOpenMode getAcctOpenMode() {
        return acctOpenMode;
    }

    public void setAcctOpenMode(AcctOpenMode acctOpenMode) {
        this.acctOpenMode = acctOpenMode;
    }

    public AgreementDepositType getAgreementDepositType() {
        return agreementDepositType;
    }

    public void setAgreementDepositType(AgreementDepositType agreementDepositType) {
        this.agreementDepositType = agreementDepositType;
    }

    public String getNextDepDay() {
        return nextDepDay;
    }

    public void setNextDepDay(String nextDepDay) {
        this.nextDepDay = nextDepDay;
    }

    public java.util.Date getReOpenDate() {
        return reOpenDate;
    }

    public void setReOpenDate(java.util.Date reOpenDate) {
        this.reOpenDate = reOpenDate;
    }

    public AcctOpenType getAcctOpenType() {
        return acctOpenType;
    }

    public void setAcctOpenType(AcctOpenType acctOpenType) {
        this.acctOpenType = acctOpenType;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public IndividualFlag getManageFlag() {
        return manageFlag;
    }

    public void setManageFlag(IndividualFlag manageFlag) {
        this.manageFlag = manageFlag;
    }

    public IndividualFlag getIntTaxLevy() {
        return intTaxLevy;
    }

    public void setIntTaxLevy(IndividualFlag intTaxLevy) {
        this.intTaxLevy = intTaxLevy;
    }

    public AcctRiskLevel getAcctRiskLevel() {
        return acctRiskLevel;
    }

    public void setAcctRiskLevel(AcctRiskLevel acctRiskLevel) {
        this.acctRiskLevel = acctRiskLevel;
    }

    public FarmerFlag getFarmerFlag() {
        return farmerFlag;
    }

    public void setFarmerFlag(FarmerFlag farmerFlag) {
        this.farmerFlag = farmerFlag;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public BigDecimal getCheckCertificateAmt() {
        return checkCertificateAmt;
    }

    public void setCheckCertificateAmt(BigDecimal checkCertificateAmt) {
        this.checkCertificateAmt = checkCertificateAmt;
    }

    public String getManageContent() {
        return manageContent;
    }

    public void setManageContent(String manageContent) {
        this.manageContent = manageContent;
    }

    public java.util.Date getTaxDiscountMaturityDate() {
        return taxDiscountMaturityDate;
    }

    public void setTaxDiscountMaturityDate(java.util.Date taxDiscountMaturityDate) {
        this.taxDiscountMaturityDate = taxDiscountMaturityDate;
    }

    public AmountNature getAmountNature() {
        return amountNature;
    }

    public void setAmountNature(AmountNature amountNature) {
        this.amountNature = amountNature;
    }

    public ManageType getManageType() {
        return manageType;
    }

    public void setManageType(ManageType manageType) {
        this.manageType = manageType;
    }

    public String getAcctChannelFlag() {
        return acctChannelFlag;
    }

    public void setAcctChannelFlag(String acctChannelFlag) {
        this.acctChannelFlag = acctChannelFlag;
    }

    public AcctProperty2 getAcctProperty2() {
        return acctProperty2;
    }

    public void setAcctProperty2(AcctProperty2 acctProperty2) {
        this.acctProperty2 = acctProperty2;
    }

    public CheckCertificateType getCheckCertificateType() {
        return checkCertificateType;
    }

    public void setCheckCertificateType(CheckCertificateType checkCertificateType) {
        this.checkCertificateType = checkCertificateType;
    }

    public IndividualFlag getDelayPayInt() {
        return delayPayInt;
    }

    public void setDelayPayInt(IndividualFlag delayPayInt) {
        this.delayPayInt = delayPayInt;
    }

    public IndividualFlag getFastOpenAcctFlag() {
        return fastOpenAcctFlag;
    }

    public void setFastOpenAcctFlag(IndividualFlag fastOpenAcctFlag) {
        this.fastOpenAcctFlag = fastOpenAcctFlag;
    }

    public java.util.Date getFirstDrawDate() {
        return firstDrawDate;
    }

    public void setFirstDrawDate(java.util.Date firstDrawDate) {
        this.firstDrawDate = firstDrawDate;
    }

    public String getOnlineFlag() {
        return onlineFlag;
    }

    public void setOnlineFlag(String onlineFlag) {
        this.onlineFlag = onlineFlag;
    }

    public String getSpecDay() {
        return specDay;
    }

    public void setSpecDay(String specDay) {
        this.specDay = specDay;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public java.util.Date getBackToDate() {
        return backToDate;
    }

    public void setBackToDate(java.util.Date backToDate) {
        this.backToDate = backToDate;
    }

    public IndividualFlag getBothLimitFlag() {
        return bothLimitFlag;
    }

    public void setBothLimitFlag(IndividualFlag bothLimitFlag) {
        this.bothLimitFlag = bothLimitFlag;
    }

    public java.util.Date getCaseInvolvedDate() {
        return caseInvolvedDate;
    }

    public void setCaseInvolvedDate(java.util.Date caseInvolvedDate) {
        this.caseInvolvedDate = caseInvolvedDate;
    }

    public String getCaseInvolvedReason() {
        return caseInvolvedReason;
    }

    public void setCaseInvolvedReason(String caseInvolvedReason) {
        this.caseInvolvedReason = caseInvolvedReason;
    }

    public IndividualFlag getPrivateAcctFlag() {
        return privateAcctFlag;
    }

    public void setPrivateAcctFlag(IndividualFlag privateAcctFlag) {
        this.privateAcctFlag = privateAcctFlag;
    }

    public java.util.Date getAnnualDate() {
        return annualDate;
    }

    public void setAnnualDate(java.util.Date annualDate) {
        this.annualDate = annualDate;
    }

    public IndividualFlag getSecretAcct() {
        return secretAcct;
    }

    public void setSecretAcct(IndividualFlag secretAcct) {
        this.secretAcct = secretAcct;
    }

    public String getPromoterName() {
        return promoterName;
    }

    public void setPromoterName(String promoterName) {
        this.promoterName = promoterName;
    }

    public String getPromoterCode() {
        return promoterCode;
    }

    public void setPromoterCode(String promoterCode) {
        this.promoterCode = promoterCode;
    }

    public String getAcctExecName() {
        return acctExecName;
    }

    public void setAcctExecName(String acctExecName) {
        this.acctExecName = acctExecName;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getAcctExecCode() {
        return acctExecCode;
    }

    public void setAcctExecCode(String acctExecCode) {
        this.acctExecCode = acctExecCode;
    }

    public String getLineOwnerShip() {
        return lineOwnerShip;
    }

    public void setLineOwnerShip(String lineOwnerShip) {
        this.lineOwnerShip = lineOwnerShip;
    }

    public IndividualFlag getIsAllowClose() {
        return isAllowClose;
    }

    public void setIsAllowClose(IndividualFlag isAllowClose) {
        this.isAllowClose = isAllowClose;
    }

    public StageLimitClass getStageLimitClass() {
        return stageLimitClass;
    }

    public void setStageLimitClass(StageLimitClass stageLimitClass) {
        this.stageLimitClass = stageLimitClass;
    }

    public Integer getTermLack() {
        return termLack;
    }

    public void setTermLack(Integer termLack) {
        this.termLack = termLack;
    }

    public Integer getAddTotalTerm() {
        return addTotalTerm;
    }

    public void setAddTotalTerm(Integer addTotalTerm) {
        this.addTotalTerm = addTotalTerm;
    }

    public SimpleAcct getSimpleAcct() {
        return simpleAcct;
    }

    public void setSimpleAcct(SimpleAcct simpleAcct) {
        this.simpleAcct = simpleAcct;
    }

    public LoanFundFlag getLoanFundFlag() {
        return loanFundFlag;
    }

    public void setLoanFundFlag(LoanFundFlag loanFundFlag) {
        this.loanFundFlag = loanFundFlag;
    }

    public IndividualFlag getCollatInd() {
        return collatInd;
    }

    public void setCollatInd(IndividualFlag collatInd) {
        this.collatInd = collatInd;
    }

    public IndividualFlag getAcctVerifyFlag() {
        return acctVerifyFlag;
    }

    public void setAcctVerifyFlag(IndividualFlag acctVerifyFlag) {
        this.acctVerifyFlag = acctVerifyFlag;
    }

    public AcctVerifyResult getAcctVerifyResult() {
        return acctVerifyResult;
    }

    public void setAcctVerifyResult(AcctVerifyResult acctVerifyResult) {
        this.acctVerifyResult = acctVerifyResult;
    }

    public String getAcctProofFlag() {
        return acctProofFlag;
    }

    public void setAcctProofFlag(String acctProofFlag) {
        this.acctProofFlag = acctProofFlag;
    }

    public AcctTellerSignFlag getAcctTellerSignFlag() {
        return acctTellerSignFlag;
    }

    public void setAcctTellerSignFlag(AcctTellerSignFlag acctTellerSignFlag) {
        this.acctTellerSignFlag = acctTellerSignFlag;
    }
}