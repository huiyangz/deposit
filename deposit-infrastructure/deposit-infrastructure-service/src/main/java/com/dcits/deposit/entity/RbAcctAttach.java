package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbAcctAttach {
    /** 柜面跨机构支取标志 */
    private String counterCroBrchDebtFlag;
    /** 柜面跨机构存入标志 */
    private String counterCroBrchCretFlag;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 科目代码 */
    private String glCode;
    /** 账户验证失败原因 */
    private String acctProofReason;
    /** 账户性质 */
    private String acctProperty;
    /** 余额联动变动标志 */
    private String balChgInd;
    /** 余额更新类型 */
    private String balUpdType;
    /** 余额方向 */
    private String balanceWay;
    /** 可透支标志 */
    private String odFacility;
    /** 按频率付息标志 */
    private String cycleIntFlag;
    /** 自动结清标志 */
    private String autoSettleFlag;
    /** 自动续存标志 */
    private String autoDep;
    /** 允许手工记账标志 */
    private String manualAccountFlag;
    /** 自贸区账户标志 */
    private String ftaAcctFlag;
    /** 自贸区代码 */
    private String ftaCode;
    /** 挂销账标志 */
    private String hangWriteOffFlag;
    /** 挂账期限 */
    private String hangTerm;
    /** 非绑定存入标志 */
    private String unBindDepFlag;
    /** 产品分类 */
    private String prodClass;
    /** 特色产品签约分类 */
    private String specialProdClass;
    /** 期次代码 */
    private String stageCode;
    /** 年检标志 */
    private String annualFlag;
    /** 年检状态标志 */
    private String annualStatus;
    /** 对公账户年检上一重置日期 */
    private Date lastResetDate;
    /** 上一年检截止日期 */
    private Date lastStopDate;
    /** 黑名单状态 */
    private String blacklistStatus;
    /** 上一登记黑名单日期 */
    private Date lastBlacklistDate;
    /** 费用免费次数 */
    private Integer freeSum;
    /** 短信签约状态 */
    private String msgStatus;
    /** 客户号 */
    private String clientNo;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 账户转存期限 */
    private String autoRenewTerm;
    /** 账户转存存期类型 */
    private String autoRenewTermType;
    /** 累计可支取本金 */
    private BigDecimal totalDrawAmt;
    /** 通兑机构 */
    private String allDraIntBranch;
    /** 允许账户转久悬标志 */
    private String allowSuspendFlag;
    /** 存款性质 */
    private String depositNature;
    /** 允许出售支票标志 */
    private String isSellCheque;
    /** 涉案标识 */
    private String caseInvolvedFlag;
    /** 提前支取日期 */
    private Date preDebtDate;
    /** 审批单号 */
    private String approvalNo;
    /** 协议编号 */
    private String agreementId;
    /** 开户模式 */
    private String acctOpenMode;
    /** 协议存款类型 */
    private String agreementDepositType;
    /** 下一续存日 */
    private String nextDepDay;
    /** 销户重开日期 */
    private Date reOpenDate;
    /** 开户方式 */
    private String acctOpenType;
    /** 税率 */
    private BigDecimal taxRate;
    /** 监管账户标志 */
    private String manageFlag;
    /** 利息税征收标志 */
    private String intTaxLevy;
    /** 账户风险级别 */
    private String acctRiskLevel;
    /** 农户标志 */
    private String farmerFlag;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 查证金额 */
    private BigDecimal checkCertificateAmt;
    /** 监管原因 */
    private String manageContent;
    /** 优惠利息税率到期日期 */
    private Date taxDiscountMaturityDate;
    /** 资金性质 */
    private String amountNature;
    /** 监管账户类型 */
    private String manageType;
    /** 账户渠道标识 */
    private String acctChannelFlag;
    /** 账户性质2 */
    private String acctProperty2;
    /** 查证类型 */
    private String checkCertificateType;
    /** 延期付息标志 */
    private String delayPayInt;
    /** 快捷开户标志 */
    private String fastOpenAcctFlag;
    /** 最早支取日期 */
    private Date firstDrawDate;
    /** 是否联机 */
    private String onlineFlag;
    /** 延期付息指定日 */
    private String specDay;
    /** 处置方式 */
    private String treatment;
    /** 转回日期 */
    private Date backToDate;
    /** 双边限额限制标志 */
    private String bothLimitFlag;
    /** 涉案日期 */
    private Date caseInvolvedDate;
    /** 涉案原因 */
    private String caseInvolvedReason;
    /** 隐私账户标志 */
    private String privateAcctFlag;
    /** 年检日期 */
    private Date annualDate;
    /** 账户机密标志 */
    private String secretAcct;
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
    private String isAllowClose;
    /** 额度扣减类型 */
    private String stageLimitClass;
    /** 漏存次数 */
    private Integer termLack;
    /** 续存总期数 */
    private Integer addTotalTerm;
    /** 简易账户标志 */
    private String simpleAcct;
    /** 贷款资金管控标志 */
    private String loanFundFlag;
    /** 抵质押标志 */
    private String collatInd;
    /** 账户核实标志 */
    private String acctVerifyFlag;
    /** 账户核实结果 */
    private String acctVerifyResult;
    /** 账户验证标志 */
    private String acctProofFlag;
    /** 账户面签标志 */
    private String acctTellerSignFlag;

    public String getCounterCroBrchDebtFlag() {
        return counterCroBrchDebtFlag;
    }

    public void setCounterCroBrchDebtFlag(String counterCroBrchDebtFlag) {
        this.counterCroBrchDebtFlag = counterCroBrchDebtFlag;
    }

    public String getCounterCroBrchCretFlag() {
        return counterCroBrchCretFlag;
    }

    public void setCounterCroBrchCretFlag(String counterCroBrchCretFlag) {
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

    public String getAcctProperty() {
        return acctProperty;
    }

    public void setAcctProperty(String acctProperty) {
        this.acctProperty = acctProperty;
    }

    public String getBalChgInd() {
        return balChgInd;
    }

    public void setBalChgInd(String balChgInd) {
        this.balChgInd = balChgInd;
    }

    public String getBalUpdType() {
        return balUpdType;
    }

    public void setBalUpdType(String balUpdType) {
        this.balUpdType = balUpdType;
    }

    public String getBalanceWay() {
        return balanceWay;
    }

    public void setBalanceWay(String balanceWay) {
        this.balanceWay = balanceWay;
    }

    public String getOdFacility() {
        return odFacility;
    }

    public void setOdFacility(String odFacility) {
        this.odFacility = odFacility;
    }

    public String getCycleIntFlag() {
        return cycleIntFlag;
    }

    public void setCycleIntFlag(String cycleIntFlag) {
        this.cycleIntFlag = cycleIntFlag;
    }

    public String getAutoSettleFlag() {
        return autoSettleFlag;
    }

    public void setAutoSettleFlag(String autoSettleFlag) {
        this.autoSettleFlag = autoSettleFlag;
    }

    public String getAutoDep() {
        return autoDep;
    }

    public void setAutoDep(String autoDep) {
        this.autoDep = autoDep;
    }

    public String getManualAccountFlag() {
        return manualAccountFlag;
    }

    public void setManualAccountFlag(String manualAccountFlag) {
        this.manualAccountFlag = manualAccountFlag;
    }

    public String getFtaAcctFlag() {
        return ftaAcctFlag;
    }

    public void setFtaAcctFlag(String ftaAcctFlag) {
        this.ftaAcctFlag = ftaAcctFlag;
    }

    public String getFtaCode() {
        return ftaCode;
    }

    public void setFtaCode(String ftaCode) {
        this.ftaCode = ftaCode;
    }

    public String getHangWriteOffFlag() {
        return hangWriteOffFlag;
    }

    public void setHangWriteOffFlag(String hangWriteOffFlag) {
        this.hangWriteOffFlag = hangWriteOffFlag;
    }

    public String getHangTerm() {
        return hangTerm;
    }

    public void setHangTerm(String hangTerm) {
        this.hangTerm = hangTerm;
    }

    public String getUnBindDepFlag() {
        return unBindDepFlag;
    }

    public void setUnBindDepFlag(String unBindDepFlag) {
        this.unBindDepFlag = unBindDepFlag;
    }

    public String getProdClass() {
        return prodClass;
    }

    public void setProdClass(String prodClass) {
        this.prodClass = prodClass;
    }

    public String getSpecialProdClass() {
        return specialProdClass;
    }

    public void setSpecialProdClass(String specialProdClass) {
        this.specialProdClass = specialProdClass;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public String getAnnualFlag() {
        return annualFlag;
    }

    public void setAnnualFlag(String annualFlag) {
        this.annualFlag = annualFlag;
    }

    public String getAnnualStatus() {
        return annualStatus;
    }

    public void setAnnualStatus(String annualStatus) {
        this.annualStatus = annualStatus;
    }

    public Date getLastResetDate() {
        return lastResetDate;
    }

    public void setLastResetDate(Date lastResetDate) {
        this.lastResetDate = lastResetDate;
    }

    public Date getLastStopDate() {
        return lastStopDate;
    }

    public void setLastStopDate(Date lastStopDate) {
        this.lastStopDate = lastStopDate;
    }

    public String getBlacklistStatus() {
        return blacklistStatus;
    }

    public void setBlacklistStatus(String blacklistStatus) {
        this.blacklistStatus = blacklistStatus;
    }

    public Date getLastBlacklistDate() {
        return lastBlacklistDate;
    }

    public void setLastBlacklistDate(Date lastBlacklistDate) {
        this.lastBlacklistDate = lastBlacklistDate;
    }

    public Integer getFreeSum() {
        return freeSum;
    }

    public void setFreeSum(Integer freeSum) {
        this.freeSum = freeSum;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAutoRenewTerm() {
        return autoRenewTerm;
    }

    public void setAutoRenewTerm(String autoRenewTerm) {
        this.autoRenewTerm = autoRenewTerm;
    }

    public String getAutoRenewTermType() {
        return autoRenewTermType;
    }

    public void setAutoRenewTermType(String autoRenewTermType) {
        this.autoRenewTermType = autoRenewTermType;
    }

    public BigDecimal getTotalDrawAmt() {
        return totalDrawAmt;
    }

    public void setTotalDrawAmt(BigDecimal totalDrawAmt) {
        this.totalDrawAmt = totalDrawAmt;
    }

    public String getAllDraIntBranch() {
        return allDraIntBranch;
    }

    public void setAllDraIntBranch(String allDraIntBranch) {
        this.allDraIntBranch = allDraIntBranch;
    }

    public String getAllowSuspendFlag() {
        return allowSuspendFlag;
    }

    public void setAllowSuspendFlag(String allowSuspendFlag) {
        this.allowSuspendFlag = allowSuspendFlag;
    }

    public String getDepositNature() {
        return depositNature;
    }

    public void setDepositNature(String depositNature) {
        this.depositNature = depositNature;
    }

    public String getIsSellCheque() {
        return isSellCheque;
    }

    public void setIsSellCheque(String isSellCheque) {
        this.isSellCheque = isSellCheque;
    }

    public String getCaseInvolvedFlag() {
        return caseInvolvedFlag;
    }

    public void setCaseInvolvedFlag(String caseInvolvedFlag) {
        this.caseInvolvedFlag = caseInvolvedFlag;
    }

    public Date getPreDebtDate() {
        return preDebtDate;
    }

    public void setPreDebtDate(Date preDebtDate) {
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

    public String getAcctOpenMode() {
        return acctOpenMode;
    }

    public void setAcctOpenMode(String acctOpenMode) {
        this.acctOpenMode = acctOpenMode;
    }

    public String getAgreementDepositType() {
        return agreementDepositType;
    }

    public void setAgreementDepositType(String agreementDepositType) {
        this.agreementDepositType = agreementDepositType;
    }

    public String getNextDepDay() {
        return nextDepDay;
    }

    public void setNextDepDay(String nextDepDay) {
        this.nextDepDay = nextDepDay;
    }

    public Date getReOpenDate() {
        return reOpenDate;
    }

    public void setReOpenDate(Date reOpenDate) {
        this.reOpenDate = reOpenDate;
    }

    public String getAcctOpenType() {
        return acctOpenType;
    }

    public void setAcctOpenType(String acctOpenType) {
        this.acctOpenType = acctOpenType;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getManageFlag() {
        return manageFlag;
    }

    public void setManageFlag(String manageFlag) {
        this.manageFlag = manageFlag;
    }

    public String getIntTaxLevy() {
        return intTaxLevy;
    }

    public void setIntTaxLevy(String intTaxLevy) {
        this.intTaxLevy = intTaxLevy;
    }

    public String getAcctRiskLevel() {
        return acctRiskLevel;
    }

    public void setAcctRiskLevel(String acctRiskLevel) {
        this.acctRiskLevel = acctRiskLevel;
    }

    public String getFarmerFlag() {
        return farmerFlag;
    }

    public void setFarmerFlag(String farmerFlag) {
        this.farmerFlag = farmerFlag;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
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

    public Date getTaxDiscountMaturityDate() {
        return taxDiscountMaturityDate;
    }

    public void setTaxDiscountMaturityDate(Date taxDiscountMaturityDate) {
        this.taxDiscountMaturityDate = taxDiscountMaturityDate;
    }

    public String getAmountNature() {
        return amountNature;
    }

    public void setAmountNature(String amountNature) {
        this.amountNature = amountNature;
    }

    public String getManageType() {
        return manageType;
    }

    public void setManageType(String manageType) {
        this.manageType = manageType;
    }

    public String getAcctChannelFlag() {
        return acctChannelFlag;
    }

    public void setAcctChannelFlag(String acctChannelFlag) {
        this.acctChannelFlag = acctChannelFlag;
    }

    public String getAcctProperty2() {
        return acctProperty2;
    }

    public void setAcctProperty2(String acctProperty2) {
        this.acctProperty2 = acctProperty2;
    }

    public String getCheckCertificateType() {
        return checkCertificateType;
    }

    public void setCheckCertificateType(String checkCertificateType) {
        this.checkCertificateType = checkCertificateType;
    }

    public String getDelayPayInt() {
        return delayPayInt;
    }

    public void setDelayPayInt(String delayPayInt) {
        this.delayPayInt = delayPayInt;
    }

    public String getFastOpenAcctFlag() {
        return fastOpenAcctFlag;
    }

    public void setFastOpenAcctFlag(String fastOpenAcctFlag) {
        this.fastOpenAcctFlag = fastOpenAcctFlag;
    }

    public Date getFirstDrawDate() {
        return firstDrawDate;
    }

    public void setFirstDrawDate(Date firstDrawDate) {
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

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Date getBackToDate() {
        return backToDate;
    }

    public void setBackToDate(Date backToDate) {
        this.backToDate = backToDate;
    }

    public String getBothLimitFlag() {
        return bothLimitFlag;
    }

    public void setBothLimitFlag(String bothLimitFlag) {
        this.bothLimitFlag = bothLimitFlag;
    }

    public Date getCaseInvolvedDate() {
        return caseInvolvedDate;
    }

    public void setCaseInvolvedDate(Date caseInvolvedDate) {
        this.caseInvolvedDate = caseInvolvedDate;
    }

    public String getCaseInvolvedReason() {
        return caseInvolvedReason;
    }

    public void setCaseInvolvedReason(String caseInvolvedReason) {
        this.caseInvolvedReason = caseInvolvedReason;
    }

    public String getPrivateAcctFlag() {
        return privateAcctFlag;
    }

    public void setPrivateAcctFlag(String privateAcctFlag) {
        this.privateAcctFlag = privateAcctFlag;
    }

    public Date getAnnualDate() {
        return annualDate;
    }

    public void setAnnualDate(Date annualDate) {
        this.annualDate = annualDate;
    }

    public String getSecretAcct() {
        return secretAcct;
    }

    public void setSecretAcct(String secretAcct) {
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

    public String getIsAllowClose() {
        return isAllowClose;
    }

    public void setIsAllowClose(String isAllowClose) {
        this.isAllowClose = isAllowClose;
    }

    public String getStageLimitClass() {
        return stageLimitClass;
    }

    public void setStageLimitClass(String stageLimitClass) {
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

    public String getSimpleAcct() {
        return simpleAcct;
    }

    public void setSimpleAcct(String simpleAcct) {
        this.simpleAcct = simpleAcct;
    }

    public String getLoanFundFlag() {
        return loanFundFlag;
    }

    public void setLoanFundFlag(String loanFundFlag) {
        this.loanFundFlag = loanFundFlag;
    }

    public String getCollatInd() {
        return collatInd;
    }

    public void setCollatInd(String collatInd) {
        this.collatInd = collatInd;
    }

    public String getAcctVerifyFlag() {
        return acctVerifyFlag;
    }

    public void setAcctVerifyFlag(String acctVerifyFlag) {
        this.acctVerifyFlag = acctVerifyFlag;
    }

    public String getAcctVerifyResult() {
        return acctVerifyResult;
    }

    public void setAcctVerifyResult(String acctVerifyResult) {
        this.acctVerifyResult = acctVerifyResult;
    }

    public String getAcctProofFlag() {
        return acctProofFlag;
    }

    public void setAcctProofFlag(String acctProofFlag) {
        this.acctProofFlag = acctProofFlag;
    }

    public String getAcctTellerSignFlag() {
        return acctTellerSignFlag;
    }

    public void setAcctTellerSignFlag(String acctTellerSignFlag) {
        this.acctTellerSignFlag = acctTellerSignFlag;
    }
}