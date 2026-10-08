package com.dcits.depsit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbBusAgreementOverdraftExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbBusAgreementOverdraftExample() {
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

        public Criteria andRbBusAgreementTypeEqualTo(String value) {
            addCriterion("RB_BUS_AGREEMENT_TYPE =", value, "rbBusAgreementType");
            return (Criteria) this;
        }

        public Criteria andGreementSignStatusEqualTo(String value) {
            addCriterion("GREEMENT_SIGN_STATUS =", value, "greementSignStatus");
            return (Criteria) this;
        }

        public Criteria andAmortizeDayEqualTo(String value) {
            addCriterion("AMORTIZE_DAY =", value, "amortizeDay");
            return (Criteria) this;
        }

        public Criteria andLoanInternalKeyEqualTo(Integer value) {
            addCriterion("LOAN_INTERNAL_KEY =", value, "loanInternalKey");
            return (Criteria) this;
        }

        public Criteria andIntBasisRateEqualTo(BigDecimal value) {
            addCriterion("INT_BASIS_RATE =", value, "intBasisRate");
            return (Criteria) this;
        }

        public Criteria andOdAmtEqualTo(BigDecimal value) {
            addCriterion("OD_AMT =", value, "odAmt");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andOdModeEqualTo(String value) {
            addCriterion("OD_MODE =", value, "odMode");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("START_DATE =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andOdTermTypeEqualTo(String value) {
            addCriterion("OD_TERM_TYPE =", value, "odTermType");
            return (Criteria) this;
        }

        public Criteria andAmortizeStartDateEqualTo(Date value) {
            addCriterion("AMORTIZE_START_DATE =", value, "amortizeStartDate");
            return (Criteria) this;
        }

        public Criteria andProdNoEqualTo(String value) {
            addCriterion("PROD_NO =", value, "prodNo");
            return (Criteria) this;
        }

        public Criteria andOdMethodEqualTo(String value) {
            addCriterion("OD_METHOD =", value, "odMethod");
            return (Criteria) this;
        }

        public Criteria andOdMaturityRuleEqualTo(String value) {
            addCriterion("OD_MATURITY_RULE =", value, "odMaturityRule");
            return (Criteria) this;
        }

        public Criteria andAmortizeTimeTypeEqualTo(String value) {
            addCriterion("AMORTIZE_TIME_TYPE =", value, "amortizeTimeType");
            return (Criteria) this;
        }

        public Criteria andWhiteClientNameEqualTo(String value) {
            addCriterion("WHITE_CLIENT_NAME =", value, "whiteClientName");
            return (Criteria) this;
        }

        public Criteria andFeeTypeEqualTo(String value) {
            addCriterion("FEE_TYPE =", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeRateEqualTo(BigDecimal value) {
            addCriterion("FEE_RATE =", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeTakenModeEqualTo(String value) {
            addCriterion("FEE_TAKEN_MODE =", value, "feeTakenMode");
            return (Criteria) this;
        }

        public Criteria andOdProdNoEqualTo(String value) {
            addCriterion("OD_PROD_NO =", value, "odProdNo");
            return (Criteria) this;
        }

        public Criteria andAmortizeMonthEqualTo(String value) {
            addCriterion("AMORTIZE_MONTH =", value, "amortizeMonth");
            return (Criteria) this;
        }

        public Criteria andAmortizeEndDateEqualTo(Date value) {
            addCriterion("AMORTIZE_END_DATE =", value, "amortizeEndDate");
            return (Criteria) this;
        }

        public Criteria andCrossPeriodRateEqualTo(BigDecimal value) {
            addCriterion("CROSS_PERIOD_RATE =", value, "crossPeriodRate");
            return (Criteria) this;
        }

        public Criteria andOdPayMethodEqualTo(String value) {
            addCriterion("OD_PAY_METHOD =", value, "odPayMethod");
            return (Criteria) this;
        }

        public Criteria andOdCcyEqualTo(String value) {
            addCriterion("OD_CCY =", value, "odCcy");
            return (Criteria) this;
        }

        public Criteria andAcctSeqNoEqualTo(String value) {
            addCriterion("ACCT_SEQ_NO =", value, "acctSeqNo");
            return (Criteria) this;
        }

        public Criteria andAgreementIdEqualTo(String value) {
            addCriterion("AGREEMENT_ID =", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andPastDueRateEqualTo(BigDecimal value) {
            addCriterion("PAST_DUE_RATE =", value, "pastDueRate");
            return (Criteria) this;
        }

        public Criteria andOdTermEqualTo(String value) {
            addCriterion("OD_TERM =", value, "odTerm");
            return (Criteria) this;
        }

        public Criteria andOdStartAmtEqualTo(BigDecimal value) {
            addCriterion("OD_START_AMT =", value, "odStartAmt");
            return (Criteria) this;
        }

        public Criteria andAcctCcyEqualTo(String value) {
            addCriterion("ACCT_CCY =", value, "acctCcy");
            return (Criteria) this;
        }

        public Criteria andChargePeriodFreqEqualTo(String value) {
            addCriterion("CHARGE_PERIOD_FREQ =", value, "chargePeriodFreq");
            return (Criteria) this;
        }

        public Criteria andAmortizePeriodFreqEqualTo(String value) {
            addCriterion("AMORTIZE_PERIOD_FREQ =", value, "amortizePeriodFreq");
            return (Criteria) this;
        }

        public Criteria andBaseAcctNoEqualTo(String value) {
            addCriterion("BASE_ACCT_NO =", value, "baseAcctNo");
            return (Criteria) this;
        }

        public Criteria andProfitAmortizeFlagEqualTo(String value) {
            addCriterion("PROFIT_AMORTIZE_FLAG =", value, "profitAmortizeFlag");
            return (Criteria) this;
        }

        public Criteria andOdGracePeriodEqualTo(String value) {
            addCriterion("OD_GRACE_PERIOD =", value, "odGracePeriod");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(String value) {
            addCriterion("CREATE_TIMESTAMP =", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andAgreementSignEffectStatusEqualTo(String value) {
            addCriterion("AGREEMENT_SIGN_EFFECT_STATUS =", value, "agreementSignEffectStatus");
            return (Criteria) this;
        }

        public Criteria andFeeChargeTypeEqualTo(String value) {
            addCriterion("FEE_CHARGE_TYPE =", value, "feeChargeType");
            return (Criteria) this;
        }

        public Criteria andIsOverMonthSeasonOdEqualTo(String value) {
            addCriterion("IS_OVER_MONTH_SEASON_OD =", value, "isOverMonthSeasonOd");
            return (Criteria) this;
        }

        public Criteria andRealRateEqualTo(BigDecimal value) {
            addCriterion("REAL_RATE =", value, "realRate");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimestampEqualTo(String value) {
            addCriterion("LAST_UPD_TIMESTAMP =", value, "lastUpdTimestamp");
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