package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbAcctAttachExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbAcctAttachExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.isEmpty()) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        return new Criteria();
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return !criteria.isEmpty();
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCounterCroBrchDebtFlagEqualTo(String value) {
            addCriterion("COUNTER_CRO_BRCH_DEBT_FLAG =", value, "counterCroBrchDebtFlag");
            return (Criteria) this;
        }

        public Criteria andCounterCroBrchCretFlagEqualTo(String value) {
            addCriterion("COUNTER_CRO_BRCH_CRET_FLAG =", value, "counterCroBrchCretFlag");
            return (Criteria) this;
        }

        public Criteria andInternalKeyEqualTo(Integer value) {
            addCriterion("INTERNAL_KEY =", value, "internalKey");
            return (Criteria) this;
        }

        public Criteria andGlCodeEqualTo(String value) {
            addCriterion("GL_CODE =", value, "glCode");
            return (Criteria) this;
        }

        public Criteria andAcctProofReasonEqualTo(String value) {
            addCriterion("ACCT_PROOF_REASON =", value, "acctProofReason");
            return (Criteria) this;
        }

        public Criteria andAcctPropertyEqualTo(String value) {
            addCriterion("ACCT_PROPERTY =", value, "acctProperty");
            return (Criteria) this;
        }

        public Criteria andBalChgIndEqualTo(String value) {
            addCriterion("BAL_CHG_IND =", value, "balChgInd");
            return (Criteria) this;
        }

        public Criteria andBalUpdTypeEqualTo(String value) {
            addCriterion("BAL_UPD_TYPE =", value, "balUpdType");
            return (Criteria) this;
        }

        public Criteria andBalanceWayEqualTo(String value) {
            addCriterion("BALANCE_WAY =", value, "balanceWay");
            return (Criteria) this;
        }

        public Criteria andOdFacilityEqualTo(String value) {
            addCriterion("OD_FACILITY =", value, "odFacility");
            return (Criteria) this;
        }

        public Criteria andCycleIntFlagEqualTo(String value) {
            addCriterion("CYCLE_INT_FLAG =", value, "cycleIntFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSettleFlagEqualTo(String value) {
            addCriterion("AUTO_SETTLE_FLAG =", value, "autoSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoDepEqualTo(String value) {
            addCriterion("AUTO_DEP =", value, "autoDep");
            return (Criteria) this;
        }

        public Criteria andManualAccountFlagEqualTo(String value) {
            addCriterion("MANUAL_ACCOUNT_FLAG =", value, "manualAccountFlag");
            return (Criteria) this;
        }

        public Criteria andFtaAcctFlagEqualTo(String value) {
            addCriterion("FTA_ACCT_FLAG =", value, "ftaAcctFlag");
            return (Criteria) this;
        }

        public Criteria andFtaCodeEqualTo(String value) {
            addCriterion("FTA_CODE =", value, "ftaCode");
            return (Criteria) this;
        }

        public Criteria andHangWriteOffFlagEqualTo(String value) {
            addCriterion("HANG_WRITE_OFF_FLAG =", value, "hangWriteOffFlag");
            return (Criteria) this;
        }

        public Criteria andHangTermEqualTo(String value) {
            addCriterion("HANG_TERM =", value, "hangTerm");
            return (Criteria) this;
        }

        public Criteria andUnBindDepFlagEqualTo(String value) {
            addCriterion("UN_BIND_DEP_FLAG =", value, "unBindDepFlag");
            return (Criteria) this;
        }

        public Criteria andProdClassEqualTo(String value) {
            addCriterion("PROD_CLASS =", value, "prodClass");
            return (Criteria) this;
        }

        public Criteria andSpecialProdClassEqualTo(String value) {
            addCriterion("SPECIAL_PROD_CLASS =", value, "specialProdClass");
            return (Criteria) this;
        }

        public Criteria andStageCodeEqualTo(String value) {
            addCriterion("STAGE_CODE =", value, "stageCode");
            return (Criteria) this;
        }

        public Criteria andAnnualFlagEqualTo(String value) {
            addCriterion("ANNUAL_FLAG =", value, "annualFlag");
            return (Criteria) this;
        }

        public Criteria andAnnualStatusEqualTo(String value) {
            addCriterion("ANNUAL_STATUS =", value, "annualStatus");
            return (Criteria) this;
        }

        public Criteria andLastResetDateEqualTo(Date value) {
            addCriterion("LAST_RESET_DATE =", value, "lastResetDate");
            return (Criteria) this;
        }

        public Criteria andLastStopDateEqualTo(Date value) {
            addCriterion("LAST_STOP_DATE =", value, "lastStopDate");
            return (Criteria) this;
        }

        public Criteria andBlacklistStatusEqualTo(String value) {
            addCriterion("BLACKLIST_STATUS =", value, "blacklistStatus");
            return (Criteria) this;
        }

        public Criteria andLastBlacklistDateEqualTo(Date value) {
            addCriterion("LAST_BLACKLIST_DATE =", value, "lastBlacklistDate");
            return (Criteria) this;
        }

        public Criteria andFreeSumEqualTo(Integer value) {
            addCriterion("FREE_SUM =", value, "freeSum");
            return (Criteria) this;
        }

        public Criteria andMsgStatusEqualTo(String value) {
            addCriterion("MSG_STATUS =", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andTranTimestampEqualTo(String value) {
            addCriterion("TRAN_TIMESTAMP =", value, "tranTimestamp");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("COMPANY =", value, "company");
            return (Criteria) this;
        }

        public Criteria andAutoRenewTermEqualTo(String value) {
            addCriterion("AUTO_RENEW_TERM =", value, "autoRenewTerm");
            return (Criteria) this;
        }

        public Criteria andAutoRenewTermTypeEqualTo(String value) {
            addCriterion("AUTO_RENEW_TERM_TYPE =", value, "autoRenewTermType");
            return (Criteria) this;
        }

        public Criteria andTotalDrawAmtEqualTo(BigDecimal value) {
            addCriterion("TOTAL_DRAW_AMT =", value, "totalDrawAmt");
            return (Criteria) this;
        }

        public Criteria andAllDraIntBranchEqualTo(String value) {
            addCriterion("ALL_DRA_INT_BRANCH =", value, "allDraIntBranch");
            return (Criteria) this;
        }

        public Criteria andAllowSuspendFlagEqualTo(String value) {
            addCriterion("ALLOW_SUSPEND_FLAG =", value, "allowSuspendFlag");
            return (Criteria) this;
        }

        public Criteria andDepositNatureEqualTo(String value) {
            addCriterion("DEPOSIT_NATURE =", value, "depositNature");
            return (Criteria) this;
        }

        public Criteria andIsSellChequeEqualTo(String value) {
            addCriterion("IS_SELL_CHEQUE =", value, "isSellCheque");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedFlagEqualTo(String value) {
            addCriterion("CASE_INVOLVED_FLAG =", value, "caseInvolvedFlag");
            return (Criteria) this;
        }

        public Criteria andPreDebtDateEqualTo(Date value) {
            addCriterion("PRE_DEBT_DATE =", value, "preDebtDate");
            return (Criteria) this;
        }

        public Criteria andApprovalNoEqualTo(String value) {
            addCriterion("APPROVAL_NO =", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andAgreementIdEqualTo(String value) {
            addCriterion("AGREEMENT_ID =", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAcctOpenModeEqualTo(String value) {
            addCriterion("ACCT_OPEN_MODE =", value, "acctOpenMode");
            return (Criteria) this;
        }

        public Criteria andAgreementDepositTypeEqualTo(String value) {
            addCriterion("AGREEMENT_DEPOSIT_TYPE =", value, "agreementDepositType");
            return (Criteria) this;
        }

        public Criteria andNextDepDayEqualTo(String value) {
            addCriterion("NEXT_DEP_DAY =", value, "nextDepDay");
            return (Criteria) this;
        }

        public Criteria andReOpenDateEqualTo(Date value) {
            addCriterion("RE_OPEN_DATE =", value, "reOpenDate");
            return (Criteria) this;
        }

        public Criteria andAcctOpenTypeEqualTo(String value) {
            addCriterion("ACCT_OPEN_TYPE =", value, "acctOpenType");
            return (Criteria) this;
        }

        public Criteria andTaxRateEqualTo(BigDecimal value) {
            addCriterion("TAX_RATE =", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andManageFlagEqualTo(String value) {
            addCriterion("MANAGE_FLAG =", value, "manageFlag");
            return (Criteria) this;
        }

        public Criteria andIntTaxLevyEqualTo(String value) {
            addCriterion("INT_TAX_LEVY =", value, "intTaxLevy");
            return (Criteria) this;
        }

        public Criteria andAcctRiskLevelEqualTo(String value) {
            addCriterion("ACCT_RISK_LEVEL =", value, "acctRiskLevel");
            return (Criteria) this;
        }

        public Criteria andFarmerFlagEqualTo(String value) {
            addCriterion("FARMER_FLAG =", value, "farmerFlag");
            return (Criteria) this;
        }

        public Criteria andLastChangeDateEqualTo(Date value) {
            addCriterion("LAST_CHANGE_DATE =", value, "lastChangeDate");
            return (Criteria) this;
        }

        public Criteria andCheckCertificateAmtEqualTo(BigDecimal value) {
            addCriterion("CHECK_CERTIFICATE_AMT =", value, "checkCertificateAmt");
            return (Criteria) this;
        }

        public Criteria andManageContentEqualTo(String value) {
            addCriterion("MANAGE_CONTENT =", value, "manageContent");
            return (Criteria) this;
        }

        public Criteria andTaxDiscountMaturityDateEqualTo(Date value) {
            addCriterion("TAX_DISCOUNT_MATURITY_DATE =", value, "taxDiscountMaturityDate");
            return (Criteria) this;
        }

        public Criteria andAmountNatureEqualTo(String value) {
            addCriterion("AMOUNT_NATURE =", value, "amountNature");
            return (Criteria) this;
        }

        public Criteria andManageTypeEqualTo(String value) {
            addCriterion("MANAGE_TYPE =", value, "manageType");
            return (Criteria) this;
        }

        public Criteria andAcctChannelFlagEqualTo(String value) {
            addCriterion("ACCT_CHANNEL_FLAG =", value, "acctChannelFlag");
            return (Criteria) this;
        }

        public Criteria andAcctProperty2EqualTo(String value) {
            addCriterion("ACCT_PROPERTY2 =", value, "acctProperty2");
            return (Criteria) this;
        }

        public Criteria andCheckCertificateTypeEqualTo(String value) {
            addCriterion("CHECK_CERTIFICATE_TYPE =", value, "checkCertificateType");
            return (Criteria) this;
        }

        public Criteria andDelayPayIntEqualTo(String value) {
            addCriterion("DELAY_PAY_INT =", value, "delayPayInt");
            return (Criteria) this;
        }

        public Criteria andFastOpenAcctFlagEqualTo(String value) {
            addCriterion("FAST_OPEN_ACCT_FLAG =", value, "fastOpenAcctFlag");
            return (Criteria) this;
        }

        public Criteria andFirstDrawDateEqualTo(Date value) {
            addCriterion("FIRST_DRAW_DATE =", value, "firstDrawDate");
            return (Criteria) this;
        }

        public Criteria andOnlineFlagEqualTo(String value) {
            addCriterion("ONLINE_FLAG =", value, "onlineFlag");
            return (Criteria) this;
        }

        public Criteria andSpecDayEqualTo(String value) {
            addCriterion("SPEC_DAY =", value, "specDay");
            return (Criteria) this;
        }

        public Criteria andTreatmentEqualTo(String value) {
            addCriterion("TREATMENT =", value, "treatment");
            return (Criteria) this;
        }

        public Criteria andBackToDateEqualTo(Date value) {
            addCriterion("BACK_TO_DATE =", value, "backToDate");
            return (Criteria) this;
        }

        public Criteria andBothLimitFlagEqualTo(String value) {
            addCriterion("BOTH_LIMIT_FLAG =", value, "bothLimitFlag");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedDateEqualTo(Date value) {
            addCriterion("CASE_INVOLVED_DATE =", value, "caseInvolvedDate");
            return (Criteria) this;
        }

        public Criteria andCaseInvolvedReasonEqualTo(String value) {
            addCriterion("CASE_INVOLVED_REASON =", value, "caseInvolvedReason");
            return (Criteria) this;
        }

        public Criteria andPrivateAcctFlagEqualTo(String value) {
            addCriterion("PRIVATE_ACCT_FLAG =", value, "privateAcctFlag");
            return (Criteria) this;
        }

        public Criteria andAnnualDateEqualTo(Date value) {
            addCriterion("ANNUAL_DATE =", value, "annualDate");
            return (Criteria) this;
        }

        public Criteria andSecretAcctEqualTo(String value) {
            addCriterion("SECRET_ACCT =", value, "secretAcct");
            return (Criteria) this;
        }

        public Criteria andPromoterNameEqualTo(String value) {
            addCriterion("PROMOTER_NAME =", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterCodeEqualTo(String value) {
            addCriterion("PROMOTER_CODE =", value, "promoterCode");
            return (Criteria) this;
        }

        public Criteria andAcctExecNameEqualTo(String value) {
            addCriterion("ACCT_EXEC_NAME =", value, "acctExecName");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(String value) {
            addCriterion("CREATE_TIMESTAMP =", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andAcctExecCodeEqualTo(String value) {
            addCriterion("ACCT_EXEC_CODE =", value, "acctExecCode");
            return (Criteria) this;
        }

        public Criteria andLineOwnerShipEqualTo(String value) {
            addCriterion("LINE_OWNER_SHIP =", value, "lineOwnerShip");
            return (Criteria) this;
        }

        public Criteria andIsAllowCloseEqualTo(String value) {
            addCriterion("IS_ALLOW_CLOSE =", value, "isAllowClose");
            return (Criteria) this;
        }

        public Criteria andStageLimitClassEqualTo(String value) {
            addCriterion("STAGE_LIMIT_CLASS =", value, "stageLimitClass");
            return (Criteria) this;
        }

        public Criteria andTermLackEqualTo(Integer value) {
            addCriterion("TERM_LACK =", value, "termLack");
            return (Criteria) this;
        }

        public Criteria andAddTotalTermEqualTo(Integer value) {
            addCriterion("ADD_TOTAL_TERM =", value, "addTotalTerm");
            return (Criteria) this;
        }

        public Criteria andSimpleAcctEqualTo(String value) {
            addCriterion("SIMPLE_ACCT =", value, "simpleAcct");
            return (Criteria) this;
        }

        public Criteria andLoanFundFlagEqualTo(String value) {
            addCriterion("LOAN_FUND_FLAG =", value, "loanFundFlag");
            return (Criteria) this;
        }

        public Criteria andCollatIndEqualTo(String value) {
            addCriterion("COLLAT_IND =", value, "collatInd");
            return (Criteria) this;
        }

        public Criteria andAcctVerifyFlagEqualTo(String value) {
            addCriterion("ACCT_VERIFY_FLAG =", value, "acctVerifyFlag");
            return (Criteria) this;
        }

        public Criteria andAcctVerifyResultEqualTo(String value) {
            addCriterion("ACCT_VERIFY_RESULT =", value, "acctVerifyResult");
            return (Criteria) this;
        }

        public Criteria andAcctProofFlagEqualTo(String value) {
            addCriterion("ACCT_PROOF_FLAG =", value, "acctProofFlag");
            return (Criteria) this;
        }

        public Criteria andAcctTellerSignFlagEqualTo(String value) {
            addCriterion("ACCT_TELLER_SIGN_FLAG =", value, "acctTellerSignFlag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;
        private Object value;
        private Object secondValue;
        private boolean noValue;
        private boolean singleValue;
        private boolean betweenValue;
        private boolean listValue;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        protected Criterion(String condition) {
            this.condition = condition;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value) {
            this.condition = condition;
            this.value = value;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.betweenValue = true;
        }
    }
}