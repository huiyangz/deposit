package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class RbAcctExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbAcctExample() {
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

        public Criteria andInternalKeyEqualTo(Integer value) {
            addCriterion("INTERNAL_KEY =", value, "internalKey");
            return (Criteria) this;
        }

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andClientTypeEqualTo(String value) {
            addCriterion("CLIENT_TYPE =", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andIndividualFlagEqualTo(String value) {
            addCriterion("INDIVIDUAL_FLAG =", value, "individualFlag");
            return (Criteria) this;
        }

        public Criteria andDocumentIdEqualTo(String value) {
            addCriterion("DOCUMENT_ID =", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeEqualTo(String value) {
            addCriterion("DOCUMENT_TYPE =", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andIssCountryEqualTo(String value) {
            addCriterion("ISS_COUNTRY =", value, "issCountry");
            return (Criteria) this;
        }

        public Criteria andAcctClassEqualTo(String value) {
            addCriterion("ACCT_CLASS =", value, "acctClass");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("CARD_NO =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andBaseAcctNoEqualTo(String value) {
            addCriterion("BASE_ACCT_NO =", value, "baseAcctNo");
            return (Criteria) this;
        }

        public Criteria andProdTypeEqualTo(String value) {
            addCriterion("PROD_TYPE =", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andAcctCcyEqualTo(String value) {
            addCriterion("ACCT_CCY =", value, "acctCcy");
            return (Criteria) this;
        }

        public Criteria andProfitCenterEqualTo(String value) {
            addCriterion("PROFIT_CENTER =", value, "profitCenter");
            return (Criteria) this;
        }

        public Criteria andAcctNameEqualTo(String value) {
            addCriterion("ACCT_NAME =", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAltAcctNameEqualTo(String value) {
            addCriterion("ALT_ACCT_NAME =", value, "altAcctName");
            return (Criteria) this;
        }

        public Criteria andAcctBranchEqualTo(String value) {
            addCriterion("ACCT_BRANCH =", value, "acctBranch");
            return (Criteria) this;
        }

        public Criteria andAcctDescEqualTo(String value) {
            addCriterion("ACCT_DESC =", value, "acctDesc");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(String value) {
            addCriterion("SOURCE_TYPE =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andAcctOpenDateEqualTo(Date value) {
            addCriterion("ACCT_OPEN_DATE =", value, "acctOpenDate");
            return (Criteria) this;
        }

        public Criteria andEffectDateEqualTo(Date value) {
            addCriterion("EFFECT_DATE =", value, "effectDate");
            return (Criteria) this;
        }

        public Criteria andOpenTranDateEqualTo(Date value) {
            addCriterion("OPEN_TRAN_DATE =", value, "openTranDate");
            return (Criteria) this;
        }

        public Criteria andAcctStatusEqualTo(String value) {
            addCriterion("ACCT_STATUS =", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusPrevEqualTo(String value) {
            addCriterion("ACCT_STATUS_PREV =", value, "acctStatusPrev");
            return (Criteria) this;
        }

        public Criteria andAcctStatusUpdDateEqualTo(Date value) {
            addCriterion("ACCT_STATUS_UPD_DATE =", value, "acctStatusUpdDate");
            return (Criteria) this;
        }

        public Criteria andAcctCloseDateEqualTo(Date value) {
            addCriterion("ACCT_CLOSE_DATE =", value, "acctCloseDate");
            return (Criteria) this;
        }

        public Criteria andAcctCloseUserIdEqualTo(String value) {
            addCriterion("ACCT_CLOSE_USER_ID =", value, "acctCloseUserId");
            return (Criteria) this;
        }

        public Criteria andAcctCloseReasonEqualTo(String value) {
            addCriterion("ACCT_CLOSE_REASON =", value, "acctCloseReason");
            return (Criteria) this;
        }

        public Criteria andAcctTypeEqualTo(String value) {
            addCriterion("ACCT_TYPE =", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andTermEqualTo(String value) {
            addCriterion("TERM =", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermTypeEqualTo(String value) {
            addCriterion("TERM_TYPE =", value, "termType");
            return (Criteria) this;
        }

        public Criteria andMaturityDateEqualTo(Date value) {
            addCriterion("MATURITY_DATE =", value, "maturityDate");
            return (Criteria) this;
        }

        public Criteria andOriMaturityDateEqualTo(Date value) {
            addCriterion("ORI_MATURITY_DATE =", value, "oriMaturityDate");
            return (Criteria) this;
        }

        public Criteria andOrigAcctOpenDateEqualTo(Date value) {
            addCriterion("ORIG_ACCT_OPEN_DATE =", value, "origAcctOpenDate");
            return (Criteria) this;
        }

        public Criteria andAcctNatureEqualTo(String value) {
            addCriterion("ACCT_NATURE =", value, "acctNature");
            return (Criteria) this;
        }

        public Criteria andAcctDueDateEqualTo(Date value) {
            addCriterion("ACCT_DUE_DATE =", value, "acctDueDate");
            return (Criteria) this;
        }

        public Criteria andAcctRealFlagEqualTo(String value) {
            addCriterion("ACCT_REAL_FLAG =", value, "acctRealFlag");
            return (Criteria) this;
        }

        public Criteria andAcctResStatusEqualTo(String value) {
            addCriterion("ACCT_RES_STATUS =", value, "acctResStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStopPayEqualTo(String value) {
            addCriterion("ACCT_STOP_PAY =", value, "acctStopPay");
            return (Criteria) this;
        }

        public Criteria andAllDepIndEqualTo(String value) {
            addCriterion("ALL_DEP_IND =", value, "allDepInd");
            return (Criteria) this;
        }

        public Criteria andAllDraIndEqualTo(String value) {
            addCriterion("ALL_DRA_IND =", value, "allDraInd");
            return (Criteria) this;
        }

        public Criteria andFixedCallEqualTo(String value) {
            addCriterion("FIXED_CALL =", value, "fixedCall");
            return (Criteria) this;
        }

        public Criteria andLeadAcctFlagEqualTo(String value) {
            addCriterion("LEAD_ACCT_FLAG =", value, "leadAcctFlag");
            return (Criteria) this;
        }

        public Criteria andAcctLicenseDateEqualTo(Date value) {
            addCriterion("ACCT_LICENSE_DATE =", value, "acctLicenseDate");
            return (Criteria) this;
        }

        public Criteria andAcctLicenseNoEqualTo(String value) {
            addCriterion("ACCT_LICENSE_NO =", value, "acctLicenseNo");
            return (Criteria) this;
        }

        public Criteria andMainProdTypeEqualTo(String value) {
            addCriterion("MAIN_PROD_TYPE =", value, "mainProdType");
            return (Criteria) this;
        }

        public Criteria andMainBalFlagEqualTo(String value) {
            addCriterion("MAIN_BAL_FLAG =", value, "mainBalFlag");
            return (Criteria) this;
        }

        public Criteria andMainIntFlagEqualTo(String value) {
            addCriterion("MAIN_INT_FLAG =", value, "mainIntFlag");
            return (Criteria) this;
        }

        public Criteria andParentInternalKeyEqualTo(Integer value) {
            addCriterion("PARENT_INTERNAL_KEY =", value, "parentInternalKey");
            return (Criteria) this;
        }

        public Criteria andReasonCodeEqualTo(String value) {
            addCriterion("REASON_CODE =", value, "reasonCode");
            return (Criteria) this;
        }

        public Criteria andAccountingStatusUpdDateEqualTo(Date value) {
            addCriterion("ACCOUNTING_STATUS_UPD_DATE =", value, "accountingStatusUpdDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateEqualTo(Date value) {
            addCriterion("APPROVAL_DATE =", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andAutoRenewRolloverEqualTo(String value) {
            addCriterion("AUTO_RENEW_ROLLOVER =", value, "autoRenewRollover");
            return (Criteria) this;
        }

        public Criteria andPartialRenewRollEqualTo(String value) {
            addCriterion("PARTIAL_RENEW_ROLL =", value, "partialRenewRoll");
            return (Criteria) this;
        }

        public Criteria andTimesRenewedEqualTo(Integer value) {
            addCriterion("TIMES_RENEWED =", value, "timesRenewed");
            return (Criteria) this;
        }

        public Criteria andRenewNoEqualTo(Integer value) {
            addCriterion("RENEW_NO =", value, "renewNo");
            return (Criteria) this;
        }

        public Criteria andRolloverNoEqualTo(Integer value) {
            addCriterion("ROLLOVER_NO =", value, "rolloverNo");
            return (Criteria) this;
        }

        public Criteria andTimesRolledoverEqualTo(Integer value) {
            addCriterion("TIMES_ROLLEDOVER =", value, "timesRolledover");
            return (Criteria) this;
        }

        public Criteria andAddtlPrincipalEqualTo(String value) {
            addCriterion("ADDTL_PRINCIPAL =", value, "addtlPrincipal");
            return (Criteria) this;
        }

        public Criteria andDormantDateEqualTo(Date value) {
            addCriterion("DORMANT_DATE =", value, "dormantDate");
            return (Criteria) this;
        }

        public Criteria andLastTranDateEqualTo(Date value) {
            addCriterion("LAST_TRAN_DATE =", value, "lastTranDate");
            return (Criteria) this;
        }

        public Criteria andApplyBranchEqualTo(String value) {
            addCriterion("APPLY_BRANCH =", value, "applyBranch");
            return (Criteria) this;
        }

        public Criteria andHomeBranchEqualTo(String value) {
            addCriterion("HOME_BRANCH =", value, "homeBranch");
            return (Criteria) this;
        }

        public Criteria andApprLetterNoEqualTo(String value) {
            addCriterion("APPR_LETTER_NO =", value, "apprLetterNo");
            return (Criteria) this;
        }

        public Criteria andIntIndFlagEqualTo(String value) {
            addCriterion("INT_IND_FLAG =", value, "intIndFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSettleFlagEqualTo(String value) {
            addCriterion("AUTO_SETTLE_FLAG =", value, "autoSettleFlag");
            return (Criteria) this;
        }

        public Criteria andBalTypeEqualTo(String value) {
            addCriterion("BAL_TYPE =", value, "balType");
            return (Criteria) this;
        }

        public Criteria andGlTypeEqualTo(String value) {
            addCriterion("GL_TYPE =", value, "glType");
            return (Criteria) this;
        }

        public Criteria andOsaFlagEqualTo(String value) {
            addCriterion("OSA_FLAG =", value, "osaFlag");
            return (Criteria) this;
        }

        public Criteria andOwnershipTypeEqualTo(String value) {
            addCriterion("OWNERSHIP_TYPE =", value, "ownershipType");
            return (Criteria) this;
        }

        public Criteria andRegionFlagEqualTo(String value) {
            addCriterion("REGION_FLAG =", value, "regionFlag");
            return (Criteria) this;
        }

        public Criteria andAccountingStatusEqualTo(String value) {
            addCriterion("ACCOUNTING_STATUS =", value, "accountingStatus");
            return (Criteria) this;
        }

        public Criteria andAccountingStatusPrevEqualTo(String value) {
            addCriterion("ACCOUNTING_STATUS_PREV =", value, "accountingStatusPrev");
            return (Criteria) this;
        }

        public Criteria andAcctExecEqualTo(String value) {
            addCriterion("ACCT_EXEC =", value, "acctExec");
            return (Criteria) this;
        }

        public Criteria andCheckedFlagEqualTo(String value) {
            addCriterion("CHECKED_FLAG =", value, "checkedFlag");
            return (Criteria) this;
        }

        public Criteria andManagementFreeFlagEqualTo(String value) {
            addCriterion("MANAGEMENT_FREE_FLAG =", value, "managementFreeFlag");
            return (Criteria) this;
        }

        public Criteria andOldProdTypeEqualTo(String value) {
            addCriterion("OLD_PROD_TYPE =", value, "oldProdType");
            return (Criteria) this;
        }

        public Criteria andImpoundFadEqualTo(String value) {
            addCriterion("IMPOUND_FAD =", value, "impoundFad");
            return (Criteria) this;
        }

        public Criteria andBusinessUnitEqualTo(String value) {
            addCriterion("BUSINESS_UNIT =", value, "businessUnit");
            return (Criteria) this;
        }

        public Criteria andDacValueEqualTo(String value) {
            addCriterion("DAC_VALUE =", value, "dacValue");
            return (Criteria) this;
        }

        public Criteria andSourceModuleEqualTo(String value) {
            addCriterion("SOURCE_MODULE =", value, "sourceModule");
            return (Criteria) this;
        }

        public Criteria andTerminalIdEqualTo(String value) {
            addCriterion("TERMINAL_ID =", value, "terminalId");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(String value) {
            addCriterion("CREATE_TIMESTAMP =", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andApprUserIdEqualTo(String value) {
            addCriterion("APPR_USER_ID =", value, "apprUserId");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andLastChangeDateEqualTo(Date value) {
            addCriterion("LAST_CHANGE_DATE =", value, "lastChangeDate");
            return (Criteria) this;
        }

        public Criteria andLastChangeUserIdEqualTo(String value) {
            addCriterion("LAST_CHANGE_USER_ID =", value, "lastChangeUserId");
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

        public Criteria andRecoverFlagEqualTo(String value) {
            addCriterion("RECOVER_FLAG =", value, "recoverFlag");
            return (Criteria) this;
        }

        public Criteria andJointAcctFlagEqualTo(String value) {
            addCriterion("JOINT_ACCT_FLAG =", value, "jointAcctFlag");
            return (Criteria) this;
        }

        public Criteria andAgreementIdEqualTo(String value) {
            addCriterion("AGREEMENT_ID =", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreProdTypeEqualTo(String value) {
            addCriterion("AGRE_PROD_TYPE =", value, "agreProdType");
            return (Criteria) this;
        }

        public Criteria andAcctNameEnEqualTo(String value) {
            addCriterion("ACCT_NAME_EN =", value, "acctNameEn");
            return (Criteria) this;
        }

        public Criteria andAmendDateEqualTo(Date value) {
            addCriterion("AMEND_DATE =", value, "amendDate");
            return (Criteria) this;
        }

        public Criteria andOpenUserIdEqualTo(String value) {
            addCriterion("OPEN_USER_ID =", value, "openUserId");
            return (Criteria) this;
        }

        public Criteria andInnerAcctNoEqualTo(String value) {
            addCriterion("INNER_ACCT_NO =", value, "innerAcctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoEqualTo(String value) {
            addCriterion("ACCT_NO =", value, "acctNo");
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