package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbAgreementSweepExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbAgreementSweepExample() {
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

        public Criteria andAgreementIdEqualTo(String value) {
            addCriterion("AGREEMENT_ID =", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andSeqNoEqualTo(String value) {
            addCriterion("SEQ_NO =", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSchedNoEqualTo(String value) {
            addCriterion("SCHED_NO =", value, "schedNo");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeEqualTo(String value) {
            addCriterion("AGREEMENT_TYPE =", value, "agreementType");
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

        public Criteria andAcctCcyEqualTo(String value) {
            addCriterion("ACCT_CCY =", value, "acctCcy");
            return (Criteria) this;
        }

        public Criteria andAcctSeqNoEqualTo(String value) {
            addCriterion("ACCT_SEQ_NO =", value, "acctSeqNo");
            return (Criteria) this;
        }

        public Criteria andAcctNameEqualTo(String value) {
            addCriterion("ACCT_NAME =", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctFixedRateEqualTo(BigDecimal value) {
            addCriterion("ACCT_FIXED_RATE =", value, "acctFixedRate");
            return (Criteria) this;
        }

        public Criteria andAcctPercentRateEqualTo(BigDecimal value) {
            addCriterion("ACCT_PERCENT_RATE =", value, "acctPercentRate");
            return (Criteria) this;
        }

        public Criteria andAcctSpreadRateEqualTo(BigDecimal value) {
            addCriterion("ACCT_SPREAD_RATE =", value, "acctSpreadRate");
            return (Criteria) this;
        }

        public Criteria andRenewMinAmtEqualTo(BigDecimal value) {
            addCriterion("RENEW_MIN_AMT =", value, "renewMinAmt");
            return (Criteria) this;
        }

        public Criteria andRenewTypeEqualTo(String value) {
            addCriterion("RENEW_TYPE =", value, "renewType");
            return (Criteria) this;
        }

        public Criteria andRenewMethodEqualTo(String value) {
            addCriterion("RENEW_METHOD =", value, "renewMethod");
            return (Criteria) this;
        }

        public Criteria andRenewMultipleEqualTo(Integer value) {
            addCriterion("RENEW_MULTIPLE =", value, "renewMultiple");
            return (Criteria) this;
        }

        public Criteria andTranAmtEqualTo(BigDecimal value) {
            addCriterion("TRAN_AMT =", value, "tranAmt");
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

        public Criteria andOthAcctCcyEqualTo(String value) {
            addCriterion("OTH_ACCT_CCY =", value, "othAcctCcy");
            return (Criteria) this;
        }

        public Criteria andOthAcctSeqNoEqualTo(String value) {
            addCriterion("OTH_ACCT_SEQ_NO =", value, "othAcctSeqNo");
            return (Criteria) this;
        }

        public Criteria andOthBankCodeEqualTo(String value) {
            addCriterion("OTH_BANK_CODE =", value, "othBankCode");
            return (Criteria) this;
        }

        public Criteria andOthAcctDescEqualTo(String value) {
            addCriterion("OTH_ACCT_DESC =", value, "othAcctDesc");
            return (Criteria) this;
        }

        public Criteria andOthAcctSortEqualTo(String value) {
            addCriterion("OTH_ACCT_SORT =", value, "othAcctSort");
            return (Criteria) this;
        }

        public Criteria andReasonCodeEqualTo(String value) {
            addCriterion("REASON_CODE =", value, "reasonCode");
            return (Criteria) this;
        }

        public Criteria andBalRatioEqualTo(BigDecimal value) {
            addCriterion("BAL_RATIO =", value, "balRatio");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(String value) {
            addCriterion("PRIORITY =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andSignDateEqualTo(Date value) {
            addCriterion("SIGN_DATE =", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("START_DATE =", value, "startDate");
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

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStatusEqualTo(String value) {
            addCriterion("AGREEMENT_STATUS =", value, "agreementStatus");
            return (Criteria) this;
        }

        public Criteria andSumAmtEqualTo(BigDecimal value) {
            addCriterion("SUM_AMT =", value, "sumAmt");
            return (Criteria) this;
        }

        public Criteria andTranBaseAmtEqualTo(BigDecimal value) {
            addCriterion("TRAN_BASE_AMT =", value, "tranBaseAmt");
            return (Criteria) this;
        }

        public Criteria andSumConCountEqualTo(Integer value) {
            addCriterion("SUM_CON_COUNT =", value, "sumConCount");
            return (Criteria) this;
        }

        public Criteria andSumCountEqualTo(Integer value) {
            addCriterion("SUM_COUNT =", value, "sumCount");
            return (Criteria) this;
        }

        public Criteria andConTransferCountEqualTo(Integer value) {
            addCriterion("CON_TRANSFER_COUNT =", value, "conTransferCount");
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

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("COMPANY =", value, "company");
            return (Criteria) this;
        }

        public Criteria andNarrativeEqualTo(String value) {
            addCriterion("NARRATIVE =", value, "narrative");
            return (Criteria) this;
        }

        public Criteria andRenewAcctTypeEqualTo(String value) {
            addCriterion("RENEW_ACCT_TYPE =", value, "renewAcctType");
            return (Criteria) this;
        }

        public Criteria andOpenNumTypeEqualTo(String value) {
            addCriterion("OPEN_NUM_TYPE =", value, "openNumType");
            return (Criteria) this;
        }

        public Criteria andAutoSettleFlagEqualTo(String value) {
            addCriterion("AUTO_SETTLE_FLAG =", value, "autoSettleFlag");
            return (Criteria) this;
        }

        public Criteria andPriintBaseAcctNoEqualTo(String value) {
            addCriterion("PRIINT_BASE_ACCT_NO =", value, "priintBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andPriintAcctSeqNoEqualTo(String value) {
            addCriterion("PRIINT_ACCT_SEQ_NO =", value, "priintAcctSeqNo");
            return (Criteria) this;
        }

        public Criteria andPriintProdTypeEqualTo(String value) {
            addCriterion("PRIINT_PROD_TYPE =", value, "priintProdType");
            return (Criteria) this;
        }

        public Criteria andPriintCcyEqualTo(String value) {
            addCriterion("PRIINT_CCY =", value, "priintCcy");
            return (Criteria) this;
        }

        public Criteria andFinFixedAmtEqualTo(BigDecimal value) {
            addCriterion("FIN_FIXED_AMT =", value, "finFixedAmt");
            return (Criteria) this;
        }

        public Criteria andLowestAmtEqualTo(BigDecimal value) {
            addCriterion("LOWEST_AMT =", value, "lowestAmt");
            return (Criteria) this;
        }

        public Criteria andSettleBaseAcctNoEqualTo(String value) {
            addCriterion("SETTLE_BASE_ACCT_NO =", value, "settleBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andSettleProdTypeEqualTo(String value) {
            addCriterion("SETTLE_PROD_TYPE =", value, "settleProdType");
            return (Criteria) this;
        }

        public Criteria andSettleAcctCcyEqualTo(String value) {
            addCriterion("SETTLE_ACCT_CCY =", value, "settleAcctCcy");
            return (Criteria) this;
        }

        public Criteria andSettleAcctSeqNoEqualTo(String value) {
            addCriterion("SETTLE_ACCT_SEQ_NO =", value, "settleAcctSeqNo");
            return (Criteria) this;
        }

        public Criteria andLimitAmtOutDayEqualTo(BigDecimal value) {
            addCriterion("LIMIT_AMT_OUT_DAY =", value, "limitAmtOutDay");
            return (Criteria) this;
        }

        public Criteria andMonthLimitEqualTo(BigDecimal value) {
            addCriterion("MONTH_LIMIT =", value, "monthLimit");
            return (Criteria) this;
        }

        public Criteria andLastChangeDateEqualTo(Date value) {
            addCriterion("LAST_CHANGE_DATE =", value, "lastChangeDate");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(String value) {
            addCriterion("CREATE_TIMESTAMP =", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andOthClientNoEqualTo(String value) {
            addCriterion("OTH_CLIENT_NO =", value, "othClientNo");
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