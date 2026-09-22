package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class MbIntMatrixExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MbIntMatrixExample() {
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

        public Criteria andMatrixNoEqualTo(String value) {
            addCriterion("MATRIX_NO =", value, "matrixNo");
            return (Criteria) this;
        }

        public Criteria andBranchEqualTo(String value) {
            addCriterion("BRANCH =", value, "branch");
            return (Criteria) this;
        }

        public Criteria andCcyEqualTo(String value) {
            addCriterion("CCY =", value, "ccy");
            return (Criteria) this;
        }

        public Criteria andIntTypeEqualTo(String value) {
            addCriterion("INT_TYPE =", value, "intType");
            return (Criteria) this;
        }

        public Criteria andYearBasisEqualTo(String value) {
            addCriterion("YEAR_BASIS =", value, "yearBasis");
            return (Criteria) this;
        }

        public Criteria andEffectDateEqualTo(Date value) {
            addCriterion("EFFECT_DATE =", value, "effectDate");
            return (Criteria) this;
        }

        public Criteria andIntBasisEqualTo(String value) {
            addCriterion("INT_BASIS =", value, "intBasis");
            return (Criteria) this;
        }

        public Criteria andBaseRateEqualTo(BigDecimal value) {
            addCriterion("BASE_RATE =", value, "baseRate");
            return (Criteria) this;
        }

        public Criteria andPeriodFreqEqualTo(String value) {
            addCriterion("PERIOD_FREQ =", value, "periodFreq");
            return (Criteria) this;
        }

        public Criteria andDayNumEqualTo(Integer value) {
            addCriterion("DAY_NUM =", value, "dayNum");
            return (Criteria) this;
        }

        public Criteria andMatrixAmtEqualTo(BigDecimal value) {
            addCriterion("MATRIX_AMT =", value, "matrixAmt");
            return (Criteria) this;
        }

        public Criteria andActualRateEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_RATE =", value, "actualRate");
            return (Criteria) this;
        }

        public Criteria andDiscRateEqualTo(BigDecimal value) {
            addCriterion("DISC_RATE =", value, "discRate");
            return (Criteria) this;
        }

        public Criteria andSpreadPercentEqualTo(BigDecimal value) {
            addCriterion("SPREAD_PERCENT =", value, "spreadPercent");
            return (Criteria) this;
        }

        public Criteria andSpreadRateEqualTo(BigDecimal value) {
            addCriterion("SPREAD_RATE =", value, "spreadRate");
            return (Criteria) this;
        }

        public Criteria andMaxPercentEqualTo(BigDecimal value) {
            addCriterion("MAX_PERCENT =", value, "maxPercent");
            return (Criteria) this;
        }

        public Criteria andMinPercentEqualTo(BigDecimal value) {
            addCriterion("MIN_PERCENT =", value, "minPercent");
            return (Criteria) this;
        }

        public Criteria andMinRateEqualTo(BigDecimal value) {
            addCriterion("MIN_RATE =", value, "minRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateEqualTo(BigDecimal value) {
            addCriterion("MAX_RATE =", value, "maxRate");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("COMPANY =", value, "company");
            return (Criteria) this;
        }

        public Criteria andTranTimestampEqualTo(String value) {
            addCriterion("TRAN_TIMESTAMP =", value, "tranTimestamp");
            return (Criteria) this;
        }

        public Criteria andMinSpreadRateEqualTo(BigDecimal value) {
            addCriterion("MIN_SPREAD_RATE =", value, "minSpreadRate");
            return (Criteria) this;
        }

        public Criteria andMinSpreadPercentEqualTo(BigDecimal value) {
            addCriterion("MIN_SPREAD_PERCENT =", value, "minSpreadPercent");
            return (Criteria) this;
        }

        public Criteria andMaxSpreadRateEqualTo(BigDecimal value) {
            addCriterion("MAX_SPREAD_RATE =", value, "maxSpreadRate");
            return (Criteria) this;
        }

        public Criteria andMaxSpreadPercentEqualTo(BigDecimal value) {
            addCriterion("MAX_SPREAD_PERCENT =", value, "maxSpreadPercent");
            return (Criteria) this;
        }

        public Criteria andPeggedIntTypeEqualTo(String value) {
            addCriterion("PEGGED_INT_TYPE =", value, "peggedIntType");
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