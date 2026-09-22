package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbDcPrecontractExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbDcPrecontractExample() {
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

        public Criteria andPrecontractNoEqualTo(String value) {
            addCriterion("PRECONTRACT_NO =", value, "precontractNo");
            return (Criteria) this;
        }

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andStageCodeEqualTo(String value) {
            addCriterion("STAGE_CODE =", value, "stageCode");
            return (Criteria) this;
        }

        public Criteria andIssueYearEqualTo(String value) {
            addCriterion("ISSUE_YEAR =", value, "issueYear");
            return (Criteria) this;
        }

        public Criteria andPrecontractTypeEqualTo(String value) {
            addCriterion("PRECONTRACT_TYPE =", value, "precontractType");
            return (Criteria) this;
        }

        public Criteria andPrecontractStatusEqualTo(String value) {
            addCriterion("PRECONTRACT_STATUS =", value, "precontractStatus");
            return (Criteria) this;
        }

        public Criteria andInternalKeyEqualTo(Integer value) {
            addCriterion("INTERNAL_KEY =", value, "internalKey");
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

        public Criteria andAcctSeqNoEqualTo(String value) {
            addCriterion("ACCT_SEQ_NO =", value, "acctSeqNo");
            return (Criteria) this;
        }

        public Criteria andAcctCcyEqualTo(String value) {
            addCriterion("ACCT_CCY =", value, "acctCcy");
            return (Criteria) this;
        }

        public Criteria andAcctNameEqualTo(String value) {
            addCriterion("ACCT_NAME =", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNatureEqualTo(String value) {
            addCriterion("ACCT_NATURE =", value, "acctNature");
            return (Criteria) this;
        }

        public Criteria andAcctStatusEqualTo(String value) {
            addCriterion("ACCT_STATUS =", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andBranchEqualTo(String value) {
            addCriterion("BRANCH =", value, "branch");
            return (Criteria) this;
        }

        public Criteria andPrecontractBranchEqualTo(String value) {
            addCriterion("PRECONTRACT_BRANCH =", value, "precontractBranch");
            return (Criteria) this;
        }

        public Criteria andPrecontractDateEqualTo(Date value) {
            addCriterion("PRECONTRACT_DATE =", value, "precontractDate");
            return (Criteria) this;
        }

        public Criteria andPrecontractCcyEqualTo(String value) {
            addCriterion("PRECONTRACT_CCY =", value, "precontractCcy");
            return (Criteria) this;
        }

        public Criteria andPrecontractAmtEqualTo(BigDecimal value) {
            addCriterion("PRECONTRACT_AMT =", value, "precontractAmt");
            return (Criteria) this;
        }

        public Criteria andPrecontractOpenDateEqualTo(Date value) {
            addCriterion("PRECONTRACT_OPEN_DATE =", value, "precontractOpenDate");
            return (Criteria) this;
        }

        public Criteria andStageLimitClassEqualTo(String value) {
            addCriterion("STAGE_LIMIT_CLASS =", value, "stageLimitClass");
            return (Criteria) this;
        }

        public Criteria andIntStartDateEqualTo(Date value) {
            addCriterion("INT_START_DATE =", value, "intStartDate");
            return (Criteria) this;
        }

        public Criteria andAutoSettleFlagEqualTo(String value) {
            addCriterion("AUTO_SETTLE_FLAG =", value, "autoSettleFlag");
            return (Criteria) this;
        }

        public Criteria andCycleIntFlagEqualTo(String value) {
            addCriterion("CYCLE_INT_FLAG =", value, "cycleIntFlag");
            return (Criteria) this;
        }

        public Criteria andPayIntModeEqualTo(String value) {
            addCriterion("PAY_INT_MODE =", value, "payIntMode");
            return (Criteria) this;
        }

        public Criteria andCycleFreqEqualTo(String value) {
            addCriterion("CYCLE_FREQ =", value, "cycleFreq");
            return (Criteria) this;
        }

        public Criteria andIntDayEqualTo(String value) {
            addCriterion("INT_DAY =", value, "intDay");
            return (Criteria) this;
        }

        public Criteria andHangSeqNoEqualTo(String value) {
            addCriterion("HANG_SEQ_NO =", value, "hangSeqNo");
            return (Criteria) this;
        }

        public Criteria andSubHangSeqNoEqualTo(String value) {
            addCriterion("SUB_HANG_SEQ_NO =", value, "subHangSeqNo");
            return (Criteria) this;
        }

        public Criteria andTranAmtEqualTo(BigDecimal value) {
            addCriterion("TRAN_AMT =", value, "tranAmt");
            return (Criteria) this;
        }

        public Criteria andIssueStartDateEqualTo(Date value) {
            addCriterion("ISSUE_START_DATE =", value, "issueStartDate");
            return (Criteria) this;
        }

        public Criteria andIssueEndDateEqualTo(Date value) {
            addCriterion("ISSUE_END_DATE =", value, "issueEndDate");
            return (Criteria) this;
        }

        public Criteria andIssueAmtEqualTo(BigDecimal value) {
            addCriterion("ISSUE_AMT =", value, "issueAmt");
            return (Criteria) this;
        }

        public Criteria andIntTypeEqualTo(String value) {
            addCriterion("INT_TYPE =", value, "intType");
            return (Criteria) this;
        }

        public Criteria andFloatRateEqualTo(BigDecimal value) {
            addCriterion("FLOAT_RATE =", value, "floatRate");
            return (Criteria) this;
        }

        public Criteria andRealRateEqualTo(BigDecimal value) {
            addCriterion("REAL_RATE =", value, "realRate");
            return (Criteria) this;
        }

        public Criteria andActualRateEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_RATE =", value, "actualRate");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(String value) {
            addCriterion("SOURCE_TYPE =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andNarrativeEqualTo(String value) {
            addCriterion("NARRATIVE =", value, "narrative");
            return (Criteria) this;
        }

        public Criteria andReferenceEqualTo(String value) {
            addCriterion("REFERENCE =", value, "reference");
            return (Criteria) this;
        }

        public Criteria andOthInternalKeyEqualTo(Integer value) {
            addCriterion("OTH_INTERNAL_KEY =", value, "othInternalKey");
            return (Criteria) this;
        }

        public Criteria andOthBaseAcctNoEqualTo(String value) {
            addCriterion("OTH_BASE_ACCT_NO =", value, "othBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andOthProdTypeEqualTo(String value) {
            addCriterion("OTH_PROD_TYPE =", value, "othProdType");
            return (Criteria) this;
        }

        public Criteria andOthCcyEqualTo(String value) {
            addCriterion("OTH_CCY =", value, "othCcy");
            return (Criteria) this;
        }

        public Criteria andOthAcctSeqNoEqualTo(String value) {
            addCriterion("OTH_ACCT_SEQ_NO =", value, "othAcctSeqNo");
            return (Criteria) this;
        }

        public Criteria andOthAcctNameEqualTo(String value) {
            addCriterion("OTH_ACCT_NAME =", value, "othAcctName");
            return (Criteria) this;
        }

        public Criteria andSubsInternalKeyEqualTo(Integer value) {
            addCriterion("SUBS_INTERNAL_KEY =", value, "subsInternalKey");
            return (Criteria) this;
        }

        public Criteria andIntInternalKeyEqualTo(Integer value) {
            addCriterion("INT_INTERNAL_KEY =", value, "intInternalKey");
            return (Criteria) this;
        }

        public Criteria andPledgedFlagEqualTo(String value) {
            addCriterion("PLEDGED_FLAG =", value, "pledgedFlag");
            return (Criteria) this;
        }

        public Criteria andResSeqNoEqualTo(String value) {
            addCriterion("RES_SEQ_NO =", value, "resSeqNo");
            return (Criteria) this;
        }

        public Criteria andTrfNoEqualTo(String value) {
            addCriterion("TRF_NO =", value, "trfNo");
            return (Criteria) this;
        }

        public Criteria andTrfTotalSettleAmtEqualTo(BigDecimal value) {
            addCriterion("TRF_TOTAL_SETTLE_AMT =", value, "trfTotalSettleAmt");
            return (Criteria) this;
        }

        public Criteria andRedeemDateEqualTo(Date value) {
            addCriterion("REDEEM_DATE =", value, "redeemDate");
            return (Criteria) this;
        }

        public Criteria andExpRedeemIntAmtEqualTo(BigDecimal value) {
            addCriterion("EXP_REDEEM_INT_AMT =", value, "expRedeemIntAmt");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTypeEqualTo(String value) {
            addCriterion("WITHDRAWAL_TYPE =", value, "withdrawalType");
            return (Criteria) this;
        }

        public Criteria andVoucherNoEqualTo(String value) {
            addCriterion("VOUCHER_NO =", value, "voucherNo");
            return (Criteria) this;
        }

        public Criteria andPrintCntEqualTo(Integer value) {
            addCriterion("PRINT_CNT =", value, "printCnt");
            return (Criteria) this;
        }

        public Criteria andStageProdClassEqualTo(String value) {
            addCriterion("STAGE_PROD_CLASS =", value, "stageProdClass");
            return (Criteria) this;
        }

        public Criteria andIntCalcTypeEqualTo(String value) {
            addCriterion("INT_CALC_TYPE =", value, "intCalcType");
            return (Criteria) this;
        }

        public Criteria andIntTaxLevyEqualTo(String value) {
            addCriterion("INT_TAX_LEVY =", value, "intTaxLevy");
            return (Criteria) this;
        }

        public Criteria andFailureReasonEqualTo(String value) {
            addCriterion("FAILURE_REASON =", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andDeleteDateEqualTo(Date value) {
            addCriterion("DELETE_DATE =", value, "deleteDate");
            return (Criteria) this;
        }

        public Criteria andDelReasonEqualTo(String value) {
            addCriterion("DEL_REASON =", value, "delReason");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdEqualTo(String value) {
            addCriterion("AUTH_USER_ID =", value, "authUserId");
            return (Criteria) this;
        }

        public Criteria andDelUserIdEqualTo(String value) {
            addCriterion("DEL_USER_ID =", value, "delUserId");
            return (Criteria) this;
        }

        public Criteria andDelAuthUserIdEqualTo(String value) {
            addCriterion("DEL_AUTH_USER_ID =", value, "delAuthUserId");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(String value) {
            addCriterion("CREATE_TIMESTAMP =", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andTranTimestampEqualTo(String value) {
            addCriterion("TRAN_TIMESTAMP =", value, "tranTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastChangeDateEqualTo(Date value) {
            addCriterion("LAST_CHANGE_DATE =", value, "lastChangeDate");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("COMPANY =", value, "company");
            return (Criteria) this;
        }

        public Criteria andSettleInternalKeyEqualTo(Integer value) {
            addCriterion("SETTLE_INTERNAL_KEY =", value, "settleInternalKey");
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