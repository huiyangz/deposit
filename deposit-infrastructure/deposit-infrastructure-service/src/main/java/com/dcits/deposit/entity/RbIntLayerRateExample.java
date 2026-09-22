package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbIntLayerRateExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbIntLayerRateExample() {
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

        public Criteria andIrlSeqNoEqualTo(String value) {
            addCriterion("IRL_SEQ_NO =", value, "irlSeqNo");
            return (Criteria) this;
        }

        public Criteria andAgreementIdEqualTo(String value) {
            addCriterion("AGREEMENT_ID =", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andInternalKeyEqualTo(Integer value) {
            addCriterion("INTERNAL_KEY =", value, "internalKey");
            return (Criteria) this;
        }

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
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

        public Criteria andNearPeriodEqualTo(String value) {
            addCriterion("NEAR_PERIOD =", value, "nearPeriod");
            return (Criteria) this;
        }

        public Criteria andNearPeriodTypeEqualTo(String value) {
            addCriterion("NEAR_PERIOD_TYPE =", value, "nearPeriodType");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("START_DATE =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andAccrDaysEqualTo(Integer value) {
            addCriterion("ACCR_DAYS =", value, "accrDays");
            return (Criteria) this;
        }

        public Criteria andAccrAmtEqualTo(BigDecimal value) {
            addCriterion("ACCR_AMT =", value, "accrAmt");
            return (Criteria) this;
        }

        public Criteria andNearAmtEqualTo(BigDecimal value) {
            addCriterion("NEAR_AMT =", value, "nearAmt");
            return (Criteria) this;
        }

        public Criteria andIntClassEqualTo(String value) {
            addCriterion("INT_CLASS =", value, "intClass");
            return (Criteria) this;
        }

        public Criteria andIntTypeEqualTo(String value) {
            addCriterion("INT_TYPE =", value, "intType");
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

        public Criteria andFloatRateEqualTo(BigDecimal value) {
            addCriterion("FLOAT_RATE =", value, "floatRate");
            return (Criteria) this;
        }

        public Criteria andMonthBasisEqualTo(String value) {
            addCriterion("MONTH_BASIS =", value, "monthBasis");
            return (Criteria) this;
        }

        public Criteria andYearBasisEqualTo(String value) {
            addCriterion("YEAR_BASIS =", value, "yearBasis");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(String value) {
            addCriterion("SYSTEM_ID =", value, "systemId");
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

        public Criteria andLastChangeDateEqualTo(Date value) {
            addCriterion("LAST_CHANGE_DATE =", value, "lastChangeDate");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(String value) {
            addCriterion("CREATE_TIMESTAMP =", value, "createTimestamp");
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