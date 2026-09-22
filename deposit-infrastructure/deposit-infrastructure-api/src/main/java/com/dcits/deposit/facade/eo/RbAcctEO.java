package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AccountingStatus;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctType;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.AutoRenewRollover;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.BusinessUnit;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.FixedCall;
import com.dcits.deposit.enums.GlType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IntIndFlag;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.OsaFlag;
import com.dcits.deposit.enums.OwnershipType;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.ReasonCode;
import com.dcits.deposit.enums.RegionFlag;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TermType;
import jakarta.validation.constraints.NotNull;

public class RbAcctEO {
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 客户类型 */
    private ClientType clientType;
    /** 对公对私标志 */
    private IndividualFlag individualFlag;
    /** 证件号码 */
    private String documentId;
    /** 证件类型 */
    private DocumentType documentType;
    /** 发证国家 */
    private IssCountry issCountry;
    /** 账户类别 */
    private AcctClass acctClass;
    /** 卡号 */
    private String cardNo;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 利润中心 */
    private ProfitCenter profitCenter;
    /** 账户名称 */
    private String acctName;
    /** 备用账户名称 */
    private String altAcctName;
    /** 账户开立行行号 */
    private AcctBranch acctBranch;
    /** 账户描述 */
    private String acctDesc;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 账户开户日期 */
    private java.util.Date acctOpenDate;
    /** 生效日期 */
    private java.util.Date effectDate;
    /** 首次交易日期 */
    private java.util.Date openTranDate;
    /** 账户状态 */
    private AcctStatus acctStatus;
    /** 账户上一状态 */
    private AcctStatus acctStatusPrev;
    /** 账户状态更新日期 */
    private java.util.Date acctStatusUpdDate;
    /** 销户日期 */
    private java.util.Date acctCloseDate;
    /** 销户柜员号 */
    private String acctCloseUserId;
    /** 销户原因 */
    private String acctCloseReason;
    /** 账户类型 */
    private AcctType acctType;
    /** 存期期限 */
    private String term;
    /** 周期类型 */
    private TermType termType;
    /** 到期日期 */
    private java.util.Date maturityDate;
    /** 账户原始到期日期 */
    private java.util.Date oriMaturityDate;
    /** 原账户开立日期 */
    private java.util.Date origAcctOpenDate;
    /** 账户属性 */
    private AcctNature acctNature;
    /** 账户到期日期 */
    private java.util.Date acctDueDate;
    /** 账户虚实标志 */
    private IndividualFlag acctRealFlag;
    /** 账户限制状态标志 */
    private IndividualFlag acctResStatus;
    /** 账户余额止付标志 */
    private IndividualFlag acctStopPay;
    /** 通存标志 */
    private IndividualFlag allDepInd;
    /** 通兑标志 */
    private AllDraInd allDraInd;
    /** 定期账户细类 */
    private FixedCall fixedCall;
    /** 主账户标志 */
    private IndividualFlag leadAcctFlag;
    /** 账户许可证日期 */
    private java.util.Date acctLicenseDate;
    /** 开户许可证编号 */
    private String acctLicenseNo;
    /** 卡产品编号 */
    private String mainProdType;
    /** 主账户余额标志 */
    private IndividualFlag mainBalFlag;
    /** 主账户利息标志 */
    private IndividualFlag mainIntFlag;
    /** 上级账户内部键 */
    private Integer parentInternalKey;
    /** 账户用途 */
    private ReasonCode reasonCode;
    /** 核算状态变更日期 */
    private java.util.Date accountingStatusUpdDate;
    /** 复核日期 */
    private java.util.Date approvalDate;
    /** 自动转存类型 */
    private AutoRenewRollover autoRenewRollover;
    /** 部分本金转存标志 */
    private IndividualFlag partialRenewRoll;
    /** 本金已转存次数 */
    private Integer timesRenewed;
    /** 本金转存次数 */
    private Integer renewNo;
    /** 本息转存次数 */
    private Integer rolloverNo;
    /** 利息已转存次数 */
    private Integer timesRolledover;
    /** 允许增加本金标志 */
    private IndividualFlag addtlPrincipal;
    /** 转不动户日期 */
    private java.util.Date dormantDate;
    /** 上一交易日期 */
    private java.util.Date lastTranDate;
    /** 现金凭证预约申请机构号 */
    private AcctBranch applyBranch;
    /** 管理机构号 */
    private AcctBranch homeBranch;
    /** 核准件编号 */
    private String apprLetterNo;
    /** 计息标志 */
    private IntIndFlag intIndFlag;
    /** 自动结清标志 */
    private IndividualFlag autoSettleFlag;
    /** 余额类型 */
    private BalType balType;
    /** 总账类型 */
    private GlType glType;
    /** 离岸标志 */
    private OsaFlag osaFlag;
    /** 归属种类 */
    private OwnershipType ownershipType;
    /** 自贸区区内区外 */
    private RegionFlag regionFlag;
    /** 核算状态 */
    private AccountingStatus accountingStatus;
    /** 上日核算状态 */
    private AccountingStatus accountingStatusPrev;
    /** 客户经理 */
    private String acctExec;
    /** 黑名单已检查标志 */
    private IndividualFlag checkedFlag;
    /** 免收费标志 */
    private IndividualFlag managementFreeFlag;
    /** 原产品类型 */
    private String oldProdType;
    /** 强制扣划违约标志 */
    private IndividualFlag impoundFad;
    /** 账套编号 */
    private BusinessUnit businessUnit;
    /** DAC值防篡改加密 */
    private String dacValue;
    /** 源模块 */
    private SourceModule sourceModule;
    /** 终端编号 */
    private String terminalId;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 现金凭证预约复核柜员号 */
    private String apprUserId;
    /** 交易柜员号 */
    private String userId;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 实时追缴标志 */
    private IndividualFlag recoverFlag;
    /** 联合账户标志 */
    private IndividualFlag jointAcctFlag;
    /** 协议编号 */
    private String agreementId;
    /** 签约主产品类型 */
    private String agreProdType;
    /** 账户英文名称 */
    private String acctNameEn;
    /** 变更日期 */
    private java.util.Date amendDate;
    /** 开户柜员号 */
    private String openUserId;
    /** 内部账号 */
    private String innerAcctNo;
    /** 客户账号 */
    private String acctNo;

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public IndividualFlag getIndividualFlag() {
        return individualFlag;
    }

    public void setIndividualFlag(IndividualFlag individualFlag) {
        this.individualFlag = individualFlag;
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

    public IssCountry getIssCountry() {
        return issCountry;
    }

    public void setIssCountry(IssCountry issCountry) {
        this.issCountry = issCountry;
    }

    public AcctClass getAcctClass() {
        return acctClass;
    }

    public void setAcctClass(AcctClass acctClass) {
        this.acctClass = acctClass;
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

    public ProfitCenter getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(ProfitCenter profitCenter) {
        this.profitCenter = profitCenter;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getAltAcctName() {
        return altAcctName;
    }

    public void setAltAcctName(String altAcctName) {
        this.altAcctName = altAcctName;
    }

    public AcctBranch getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(AcctBranch acctBranch) {
        this.acctBranch = acctBranch;
    }

    public String getAcctDesc() {
        return acctDesc;
    }

    public void setAcctDesc(String acctDesc) {
        this.acctDesc = acctDesc;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public java.util.Date getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(java.util.Date acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }

    public java.util.Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(java.util.Date effectDate) {
        this.effectDate = effectDate;
    }

    public java.util.Date getOpenTranDate() {
        return openTranDate;
    }

    public void setOpenTranDate(java.util.Date openTranDate) {
        this.openTranDate = openTranDate;
    }

    public AcctStatus getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(AcctStatus acctStatus) {
        this.acctStatus = acctStatus;
    }

    public AcctStatus getAcctStatusPrev() {
        return acctStatusPrev;
    }

    public void setAcctStatusPrev(AcctStatus acctStatusPrev) {
        this.acctStatusPrev = acctStatusPrev;
    }

    public java.util.Date getAcctStatusUpdDate() {
        return acctStatusUpdDate;
    }

    public void setAcctStatusUpdDate(java.util.Date acctStatusUpdDate) {
        this.acctStatusUpdDate = acctStatusUpdDate;
    }

    public java.util.Date getAcctCloseDate() {
        return acctCloseDate;
    }

    public void setAcctCloseDate(java.util.Date acctCloseDate) {
        this.acctCloseDate = acctCloseDate;
    }

    public String getAcctCloseUserId() {
        return acctCloseUserId;
    }

    public void setAcctCloseUserId(String acctCloseUserId) {
        this.acctCloseUserId = acctCloseUserId;
    }

    public String getAcctCloseReason() {
        return acctCloseReason;
    }

    public void setAcctCloseReason(String acctCloseReason) {
        this.acctCloseReason = acctCloseReason;
    }

    public AcctType getAcctType() {
        return acctType;
    }

    public void setAcctType(AcctType acctType) {
        this.acctType = acctType;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public TermType getTermType() {
        return termType;
    }

    public void setTermType(TermType termType) {
        this.termType = termType;
    }

    public java.util.Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.util.Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public java.util.Date getOriMaturityDate() {
        return oriMaturityDate;
    }

    public void setOriMaturityDate(java.util.Date oriMaturityDate) {
        this.oriMaturityDate = oriMaturityDate;
    }

    public java.util.Date getOrigAcctOpenDate() {
        return origAcctOpenDate;
    }

    public void setOrigAcctOpenDate(java.util.Date origAcctOpenDate) {
        this.origAcctOpenDate = origAcctOpenDate;
    }

    public AcctNature getAcctNature() {
        return acctNature;
    }

    public void setAcctNature(AcctNature acctNature) {
        this.acctNature = acctNature;
    }

    public java.util.Date getAcctDueDate() {
        return acctDueDate;
    }

    public void setAcctDueDate(java.util.Date acctDueDate) {
        this.acctDueDate = acctDueDate;
    }

    public IndividualFlag getAcctRealFlag() {
        return acctRealFlag;
    }

    public void setAcctRealFlag(IndividualFlag acctRealFlag) {
        this.acctRealFlag = acctRealFlag;
    }

    public IndividualFlag getAcctResStatus() {
        return acctResStatus;
    }

    public void setAcctResStatus(IndividualFlag acctResStatus) {
        this.acctResStatus = acctResStatus;
    }

    public IndividualFlag getAcctStopPay() {
        return acctStopPay;
    }

    public void setAcctStopPay(IndividualFlag acctStopPay) {
        this.acctStopPay = acctStopPay;
    }

    public IndividualFlag getAllDepInd() {
        return allDepInd;
    }

    public void setAllDepInd(IndividualFlag allDepInd) {
        this.allDepInd = allDepInd;
    }

    public AllDraInd getAllDraInd() {
        return allDraInd;
    }

    public void setAllDraInd(AllDraInd allDraInd) {
        this.allDraInd = allDraInd;
    }

    public FixedCall getFixedCall() {
        return fixedCall;
    }

    public void setFixedCall(FixedCall fixedCall) {
        this.fixedCall = fixedCall;
    }

    public IndividualFlag getLeadAcctFlag() {
        return leadAcctFlag;
    }

    public void setLeadAcctFlag(IndividualFlag leadAcctFlag) {
        this.leadAcctFlag = leadAcctFlag;
    }

    public java.util.Date getAcctLicenseDate() {
        return acctLicenseDate;
    }

    public void setAcctLicenseDate(java.util.Date acctLicenseDate) {
        this.acctLicenseDate = acctLicenseDate;
    }

    public String getAcctLicenseNo() {
        return acctLicenseNo;
    }

    public void setAcctLicenseNo(String acctLicenseNo) {
        this.acctLicenseNo = acctLicenseNo;
    }

    public String getMainProdType() {
        return mainProdType;
    }

    public void setMainProdType(String mainProdType) {
        this.mainProdType = mainProdType;
    }

    public IndividualFlag getMainBalFlag() {
        return mainBalFlag;
    }

    public void setMainBalFlag(IndividualFlag mainBalFlag) {
        this.mainBalFlag = mainBalFlag;
    }

    public IndividualFlag getMainIntFlag() {
        return mainIntFlag;
    }

    public void setMainIntFlag(IndividualFlag mainIntFlag) {
        this.mainIntFlag = mainIntFlag;
    }

    public Integer getParentInternalKey() {
        return parentInternalKey;
    }

    public void setParentInternalKey(Integer parentInternalKey) {
        this.parentInternalKey = parentInternalKey;
    }

    public ReasonCode getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(ReasonCode reasonCode) {
        this.reasonCode = reasonCode;
    }

    public java.util.Date getAccountingStatusUpdDate() {
        return accountingStatusUpdDate;
    }

    public void setAccountingStatusUpdDate(java.util.Date accountingStatusUpdDate) {
        this.accountingStatusUpdDate = accountingStatusUpdDate;
    }

    public java.util.Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(java.util.Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public AutoRenewRollover getAutoRenewRollover() {
        return autoRenewRollover;
    }

    public void setAutoRenewRollover(AutoRenewRollover autoRenewRollover) {
        this.autoRenewRollover = autoRenewRollover;
    }

    public IndividualFlag getPartialRenewRoll() {
        return partialRenewRoll;
    }

    public void setPartialRenewRoll(IndividualFlag partialRenewRoll) {
        this.partialRenewRoll = partialRenewRoll;
    }

    public Integer getTimesRenewed() {
        return timesRenewed;
    }

    public void setTimesRenewed(Integer timesRenewed) {
        this.timesRenewed = timesRenewed;
    }

    public Integer getRenewNo() {
        return renewNo;
    }

    public void setRenewNo(Integer renewNo) {
        this.renewNo = renewNo;
    }

    public Integer getRolloverNo() {
        return rolloverNo;
    }

    public void setRolloverNo(Integer rolloverNo) {
        this.rolloverNo = rolloverNo;
    }

    public Integer getTimesRolledover() {
        return timesRolledover;
    }

    public void setTimesRolledover(Integer timesRolledover) {
        this.timesRolledover = timesRolledover;
    }

    public IndividualFlag getAddtlPrincipal() {
        return addtlPrincipal;
    }

    public void setAddtlPrincipal(IndividualFlag addtlPrincipal) {
        this.addtlPrincipal = addtlPrincipal;
    }

    public java.util.Date getDormantDate() {
        return dormantDate;
    }

    public void setDormantDate(java.util.Date dormantDate) {
        this.dormantDate = dormantDate;
    }

    public java.util.Date getLastTranDate() {
        return lastTranDate;
    }

    public void setLastTranDate(java.util.Date lastTranDate) {
        this.lastTranDate = lastTranDate;
    }

    public AcctBranch getApplyBranch() {
        return applyBranch;
    }

    public void setApplyBranch(AcctBranch applyBranch) {
        this.applyBranch = applyBranch;
    }

    public AcctBranch getHomeBranch() {
        return homeBranch;
    }

    public void setHomeBranch(AcctBranch homeBranch) {
        this.homeBranch = homeBranch;
    }

    public String getApprLetterNo() {
        return apprLetterNo;
    }

    public void setApprLetterNo(String apprLetterNo) {
        this.apprLetterNo = apprLetterNo;
    }

    public IntIndFlag getIntIndFlag() {
        return intIndFlag;
    }

    public void setIntIndFlag(IntIndFlag intIndFlag) {
        this.intIndFlag = intIndFlag;
    }

    public IndividualFlag getAutoSettleFlag() {
        return autoSettleFlag;
    }

    public void setAutoSettleFlag(IndividualFlag autoSettleFlag) {
        this.autoSettleFlag = autoSettleFlag;
    }

    public BalType getBalType() {
        return balType;
    }

    public void setBalType(BalType balType) {
        this.balType = balType;
    }

    public GlType getGlType() {
        return glType;
    }

    public void setGlType(GlType glType) {
        this.glType = glType;
    }

    public OsaFlag getOsaFlag() {
        return osaFlag;
    }

    public void setOsaFlag(OsaFlag osaFlag) {
        this.osaFlag = osaFlag;
    }

    public OwnershipType getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(OwnershipType ownershipType) {
        this.ownershipType = ownershipType;
    }

    public RegionFlag getRegionFlag() {
        return regionFlag;
    }

    public void setRegionFlag(RegionFlag regionFlag) {
        this.regionFlag = regionFlag;
    }

    public AccountingStatus getAccountingStatus() {
        return accountingStatus;
    }

    public void setAccountingStatus(AccountingStatus accountingStatus) {
        this.accountingStatus = accountingStatus;
    }

    public AccountingStatus getAccountingStatusPrev() {
        return accountingStatusPrev;
    }

    public void setAccountingStatusPrev(AccountingStatus accountingStatusPrev) {
        this.accountingStatusPrev = accountingStatusPrev;
    }

    public String getAcctExec() {
        return acctExec;
    }

    public void setAcctExec(String acctExec) {
        this.acctExec = acctExec;
    }

    public IndividualFlag getCheckedFlag() {
        return checkedFlag;
    }

    public void setCheckedFlag(IndividualFlag checkedFlag) {
        this.checkedFlag = checkedFlag;
    }

    public IndividualFlag getManagementFreeFlag() {
        return managementFreeFlag;
    }

    public void setManagementFreeFlag(IndividualFlag managementFreeFlag) {
        this.managementFreeFlag = managementFreeFlag;
    }

    public String getOldProdType() {
        return oldProdType;
    }

    public void setOldProdType(String oldProdType) {
        this.oldProdType = oldProdType;
    }

    public IndividualFlag getImpoundFad() {
        return impoundFad;
    }

    public void setImpoundFad(IndividualFlag impoundFad) {
        this.impoundFad = impoundFad;
    }

    public BusinessUnit getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(BusinessUnit businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getDacValue() {
        return dacValue;
    }

    public void setDacValue(String dacValue) {
        this.dacValue = dacValue;
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

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getApprUserId() {
        return apprUserId;
    }

    public void setApprUserId(String apprUserId) {
        this.apprUserId = apprUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getLastChangeUserId() {
        return lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
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

    public IndividualFlag getRecoverFlag() {
        return recoverFlag;
    }

    public void setRecoverFlag(IndividualFlag recoverFlag) {
        this.recoverFlag = recoverFlag;
    }

    public IndividualFlag getJointAcctFlag() {
        return jointAcctFlag;
    }

    public void setJointAcctFlag(IndividualFlag jointAcctFlag) {
        this.jointAcctFlag = jointAcctFlag;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getAgreProdType() {
        return agreProdType;
    }

    public void setAgreProdType(String agreProdType) {
        this.agreProdType = agreProdType;
    }

    public String getAcctNameEn() {
        return acctNameEn;
    }

    public void setAcctNameEn(String acctNameEn) {
        this.acctNameEn = acctNameEn;
    }

    public java.util.Date getAmendDate() {
        return amendDate;
    }

    public void setAmendDate(java.util.Date amendDate) {
        this.amendDate = amendDate;
    }

    public String getOpenUserId() {
        return openUserId;
    }

    public void setOpenUserId(String openUserId) {
        this.openUserId = openUserId;
    }

    public String getInnerAcctNo() {
        return innerAcctNo;
    }

    public void setInnerAcctNo(String innerAcctNo) {
        this.innerAcctNo = innerAcctNo;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }
}