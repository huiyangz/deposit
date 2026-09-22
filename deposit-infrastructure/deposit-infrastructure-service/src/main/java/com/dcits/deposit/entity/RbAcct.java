package com.dcits.deposit.entity;

import java.util.Date;

public class RbAcct {
    /** 账户内部键值 */
    private Integer internalKey;
    /** 客户号 */
    private String clientNo;
    /** 客户类型 */
    private String clientType;
    /** 对公对私标志 */
    private String individualFlag;
    /** 证件号码 */
    private String documentId;
    /** 证件类型 */
    private String documentType;
    /** 发证国家 */
    private String issCountry;
    /** 账户类别 */
    private String acctClass;
    /** 卡号 */
    private String cardNo;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 账户币种 */
    private String acctCcy;
    /** 利润中心 */
    private String profitCenter;
    /** 账户名称 */
    private String acctName;
    /** 备用账户名称 */
    private String altAcctName;
    /** 账户开立行行号 */
    private String acctBranch;
    /** 账户描述 */
    private String acctDesc;
    /** 渠道类型 */
    private String sourceType;
    /** 账户开户日期 */
    private Date acctOpenDate;
    /** 生效日期 */
    private Date effectDate;
    /** 首次交易日期 */
    private Date openTranDate;
    /** 账户状态 */
    private String acctStatus;
    /** 账户上一状态 */
    private String acctStatusPrev;
    /** 账户状态更新日期 */
    private Date acctStatusUpdDate;
    /** 销户日期 */
    private Date acctCloseDate;
    /** 销户柜员号 */
    private String acctCloseUserId;
    /** 销户原因 */
    private String acctCloseReason;
    /** 账户类型 */
    private String acctType;
    /** 存期期限 */
    private String term;
    /** 周期类型 */
    private String termType;
    /** 到期日期 */
    private Date maturityDate;
    /** 账户原始到期日期 */
    private Date oriMaturityDate;
    /** 原账户开立日期 */
    private Date origAcctOpenDate;
    /** 账户属性 */
    private String acctNature;
    /** 账户到期日期 */
    private Date acctDueDate;
    /** 账户虚实标志 */
    private String acctRealFlag;
    /** 账户限制状态标志 */
    private String acctResStatus;
    /** 账户余额止付标志 */
    private String acctStopPay;
    /** 通存标志 */
    private String allDepInd;
    /** 通兑标志 */
    private String allDraInd;
    /** 定期账户细类 */
    private String fixedCall;
    /** 主账户标志 */
    private String leadAcctFlag;
    /** 账户许可证日期 */
    private Date acctLicenseDate;
    /** 开户许可证编号 */
    private String acctLicenseNo;
    /** 卡产品编号 */
    private String mainProdType;
    /** 主账户余额标志 */
    private String mainBalFlag;
    /** 主账户利息标志 */
    private String mainIntFlag;
    /** 上级账户内部键 */
    private Integer parentInternalKey;
    /** 账户用途 */
    private String reasonCode;
    /** 核算状态变更日期 */
    private Date accountingStatusUpdDate;
    /** 复核日期 */
    private Date approvalDate;
    /** 自动转存类型 */
    private String autoRenewRollover;
    /** 部分本金转存标志 */
    private String partialRenewRoll;
    /** 本金已转存次数 */
    private Integer timesRenewed;
    /** 本金转存次数 */
    private Integer renewNo;
    /** 本息转存次数 */
    private Integer rolloverNo;
    /** 利息已转存次数 */
    private Integer timesRolledover;
    /** 允许增加本金标志 */
    private String addtlPrincipal;
    /** 转不动户日期 */
    private Date dormantDate;
    /** 上一交易日期 */
    private Date lastTranDate;
    /** 现金凭证预约申请机构号 */
    private String applyBranch;
    /** 管理机构号 */
    private String homeBranch;
    /** 核准件编号 */
    private String apprLetterNo;
    /** 计息标志 */
    private String intIndFlag;
    /** 自动结清标志 */
    private String autoSettleFlag;
    /** 余额类型 */
    private String balType;
    /** 总账类型 */
    private String glType;
    /** 离岸标志 */
    private String osaFlag;
    /** 归属种类 */
    private String ownershipType;
    /** 自贸区区内区外 */
    private String regionFlag;
    /** 核算状态 */
    private String accountingStatus;
    /** 上日核算状态 */
    private String accountingStatusPrev;
    /** 客户经理 */
    private String acctExec;
    /** 黑名单已检查标志 */
    private String checkedFlag;
    /** 免收费标志 */
    private String managementFreeFlag;
    /** 原产品类型 */
    private String oldProdType;
    /** 强制扣划违约标志 */
    private String impoundFad;
    /** 账套编号 */
    private String businessUnit;
    /** DAC值防篡改加密 */
    private String dacValue;
    /** 源模块 */
    private String sourceModule;
    /** 终端编号 */
    private String terminalId;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 现金凭证预约复核柜员号 */
    private String apprUserId;
    /** 交易柜员号 */
    private String userId;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 实时追缴标志 */
    private String recoverFlag;
    /** 联合账户标志 */
    private String jointAcctFlag;
    /** 协议编号 */
    private String agreementId;
    /** 签约主产品类型 */
    private String agreProdType;
    /** 账户英文名称 */
    private String acctNameEn;
    /** 变更日期 */
    private Date amendDate;
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

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getIndividualFlag() {
        return individualFlag;
    }

    public void setIndividualFlag(String individualFlag) {
        this.individualFlag = individualFlag;
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

    public String getIssCountry() {
        return issCountry;
    }

    public void setIssCountry(String issCountry) {
        this.issCountry = issCountry;
    }

    public String getAcctClass() {
        return acctClass;
    }

    public void setAcctClass(String acctClass) {
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

    public String getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(String acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(String profitCenter) {
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

    public String getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(String acctBranch) {
        this.acctBranch = acctBranch;
    }

    public String getAcctDesc() {
        return acctDesc;
    }

    public void setAcctDesc(String acctDesc) {
        this.acctDesc = acctDesc;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public Date getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(Date acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public Date getOpenTranDate() {
        return openTranDate;
    }

    public void setOpenTranDate(Date openTranDate) {
        this.openTranDate = openTranDate;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getAcctStatusPrev() {
        return acctStatusPrev;
    }

    public void setAcctStatusPrev(String acctStatusPrev) {
        this.acctStatusPrev = acctStatusPrev;
    }

    public Date getAcctStatusUpdDate() {
        return acctStatusUpdDate;
    }

    public void setAcctStatusUpdDate(Date acctStatusUpdDate) {
        this.acctStatusUpdDate = acctStatusUpdDate;
    }

    public Date getAcctCloseDate() {
        return acctCloseDate;
    }

    public void setAcctCloseDate(Date acctCloseDate) {
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

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getOriMaturityDate() {
        return oriMaturityDate;
    }

    public void setOriMaturityDate(Date oriMaturityDate) {
        this.oriMaturityDate = oriMaturityDate;
    }

    public Date getOrigAcctOpenDate() {
        return origAcctOpenDate;
    }

    public void setOrigAcctOpenDate(Date origAcctOpenDate) {
        this.origAcctOpenDate = origAcctOpenDate;
    }

    public String getAcctNature() {
        return acctNature;
    }

    public void setAcctNature(String acctNature) {
        this.acctNature = acctNature;
    }

    public Date getAcctDueDate() {
        return acctDueDate;
    }

    public void setAcctDueDate(Date acctDueDate) {
        this.acctDueDate = acctDueDate;
    }

    public String getAcctRealFlag() {
        return acctRealFlag;
    }

    public void setAcctRealFlag(String acctRealFlag) {
        this.acctRealFlag = acctRealFlag;
    }

    public String getAcctResStatus() {
        return acctResStatus;
    }

    public void setAcctResStatus(String acctResStatus) {
        this.acctResStatus = acctResStatus;
    }

    public String getAcctStopPay() {
        return acctStopPay;
    }

    public void setAcctStopPay(String acctStopPay) {
        this.acctStopPay = acctStopPay;
    }

    public String getAllDepInd() {
        return allDepInd;
    }

    public void setAllDepInd(String allDepInd) {
        this.allDepInd = allDepInd;
    }

    public String getAllDraInd() {
        return allDraInd;
    }

    public void setAllDraInd(String allDraInd) {
        this.allDraInd = allDraInd;
    }

    public String getFixedCall() {
        return fixedCall;
    }

    public void setFixedCall(String fixedCall) {
        this.fixedCall = fixedCall;
    }

    public String getLeadAcctFlag() {
        return leadAcctFlag;
    }

    public void setLeadAcctFlag(String leadAcctFlag) {
        this.leadAcctFlag = leadAcctFlag;
    }

    public Date getAcctLicenseDate() {
        return acctLicenseDate;
    }

    public void setAcctLicenseDate(Date acctLicenseDate) {
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

    public String getMainBalFlag() {
        return mainBalFlag;
    }

    public void setMainBalFlag(String mainBalFlag) {
        this.mainBalFlag = mainBalFlag;
    }

    public String getMainIntFlag() {
        return mainIntFlag;
    }

    public void setMainIntFlag(String mainIntFlag) {
        this.mainIntFlag = mainIntFlag;
    }

    public Integer getParentInternalKey() {
        return parentInternalKey;
    }

    public void setParentInternalKey(Integer parentInternalKey) {
        this.parentInternalKey = parentInternalKey;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public Date getAccountingStatusUpdDate() {
        return accountingStatusUpdDate;
    }

    public void setAccountingStatusUpdDate(Date accountingStatusUpdDate) {
        this.accountingStatusUpdDate = accountingStatusUpdDate;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getAutoRenewRollover() {
        return autoRenewRollover;
    }

    public void setAutoRenewRollover(String autoRenewRollover) {
        this.autoRenewRollover = autoRenewRollover;
    }

    public String getPartialRenewRoll() {
        return partialRenewRoll;
    }

    public void setPartialRenewRoll(String partialRenewRoll) {
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

    public String getAddtlPrincipal() {
        return addtlPrincipal;
    }

    public void setAddtlPrincipal(String addtlPrincipal) {
        this.addtlPrincipal = addtlPrincipal;
    }

    public Date getDormantDate() {
        return dormantDate;
    }

    public void setDormantDate(Date dormantDate) {
        this.dormantDate = dormantDate;
    }

    public Date getLastTranDate() {
        return lastTranDate;
    }

    public void setLastTranDate(Date lastTranDate) {
        this.lastTranDate = lastTranDate;
    }

    public String getApplyBranch() {
        return applyBranch;
    }

    public void setApplyBranch(String applyBranch) {
        this.applyBranch = applyBranch;
    }

    public String getHomeBranch() {
        return homeBranch;
    }

    public void setHomeBranch(String homeBranch) {
        this.homeBranch = homeBranch;
    }

    public String getApprLetterNo() {
        return apprLetterNo;
    }

    public void setApprLetterNo(String apprLetterNo) {
        this.apprLetterNo = apprLetterNo;
    }

    public String getIntIndFlag() {
        return intIndFlag;
    }

    public void setIntIndFlag(String intIndFlag) {
        this.intIndFlag = intIndFlag;
    }

    public String getAutoSettleFlag() {
        return autoSettleFlag;
    }

    public void setAutoSettleFlag(String autoSettleFlag) {
        this.autoSettleFlag = autoSettleFlag;
    }

    public String getBalType() {
        return balType;
    }

    public void setBalType(String balType) {
        this.balType = balType;
    }

    public String getGlType() {
        return glType;
    }

    public void setGlType(String glType) {
        this.glType = glType;
    }

    public String getOsaFlag() {
        return osaFlag;
    }

    public void setOsaFlag(String osaFlag) {
        this.osaFlag = osaFlag;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
    }

    public String getRegionFlag() {
        return regionFlag;
    }

    public void setRegionFlag(String regionFlag) {
        this.regionFlag = regionFlag;
    }

    public String getAccountingStatus() {
        return accountingStatus;
    }

    public void setAccountingStatus(String accountingStatus) {
        this.accountingStatus = accountingStatus;
    }

    public String getAccountingStatusPrev() {
        return accountingStatusPrev;
    }

    public void setAccountingStatusPrev(String accountingStatusPrev) {
        this.accountingStatusPrev = accountingStatusPrev;
    }

    public String getAcctExec() {
        return acctExec;
    }

    public void setAcctExec(String acctExec) {
        this.acctExec = acctExec;
    }

    public String getCheckedFlag() {
        return checkedFlag;
    }

    public void setCheckedFlag(String checkedFlag) {
        this.checkedFlag = checkedFlag;
    }

    public String getManagementFreeFlag() {
        return managementFreeFlag;
    }

    public void setManagementFreeFlag(String managementFreeFlag) {
        this.managementFreeFlag = managementFreeFlag;
    }

    public String getOldProdType() {
        return oldProdType;
    }

    public void setOldProdType(String oldProdType) {
        this.oldProdType = oldProdType;
    }

    public String getImpoundFad() {
        return impoundFad;
    }

    public void setImpoundFad(String impoundFad) {
        this.impoundFad = impoundFad;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getDacValue() {
        return dacValue;
    }

    public void setDacValue(String dacValue) {
        this.dacValue = dacValue;
    }

    public String getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(String sourceModule) {
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

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRecoverFlag() {
        return recoverFlag;
    }

    public void setRecoverFlag(String recoverFlag) {
        this.recoverFlag = recoverFlag;
    }

    public String getJointAcctFlag() {
        return jointAcctFlag;
    }

    public void setJointAcctFlag(String jointAcctFlag) {
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

    public Date getAmendDate() {
        return amendDate;
    }

    public void setAmendDate(Date amendDate) {
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