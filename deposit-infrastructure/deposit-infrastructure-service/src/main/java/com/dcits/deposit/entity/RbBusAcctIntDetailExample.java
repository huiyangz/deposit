package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbBusAcctIntDetailExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbBusAcctIntDetailExample() {
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

        public Criteria andNextCycleDateEqualTo(Date value) {
            addCriterion("NEXT_CYCLE_DATE =", value, "nextCycleDate");
            return (Criteria) this;
        }

        public Criteria andIntPastDueEqualTo(BigDecimal value) {
            addCriterion("INT_PAST_DUE =", value, "intPastDue");
            return (Criteria) this;
        }

        public Criteria andIntTypeEqualTo(String value) {
            addCriterion("INT_TYPE =", value, "intType");
            return (Criteria) this;
        }

        public Criteria andIntAdjCtdEqualTo(BigDecimal value) {
            addCriterion("INT_ADJ_CTD =", value, "intAdjCtd");
            return (Criteria) this;
        }

        public Criteria andSpreadRateEqualTo(BigDecimal value) {
            addCriterion("SPREAD_RATE =", value, "spreadRate");
            return (Criteria) this;
        }

        public Criteria andFloatTypeEqualTo(String value) {
            addCriterion("FLOAT_TYPE =", value, "floatType");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(String value) {
            addCriterion("SYSTEM_ID =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andDiscntIntPrevEqualTo(BigDecimal value) {
            addCriterion("DISCNT_INT_PREV =", value, "discntIntPrev");
            return (Criteria) this;
        }

        public Criteria andYearBasisTypeEqualTo(String value) {
            addCriterion("YEAR_BASIS_TYPE =", value, "yearBasisType");
            return (Criteria) this;
        }

        public Criteria andSplitRateFlagEqualTo(String value) {
            addCriterion("SPLIT_RATE_FLAG =", value, "splitRateFlag");
            return (Criteria) this;
        }

        public Criteria andIntAccruedEqualTo(BigDecimal value) {
            addCriterion("INT_ACCRUED =", value, "intAccrued");
            return (Criteria) this;
        }

        public Criteria andLastIntPastDueEqualTo(BigDecimal value) {
            addCriterion("LAST_INT_PAST_DUE =", value, "lastIntPastDue");
            return (Criteria) this;
        }

        public Criteria andAcctSpreadRateEqualTo(BigDecimal value) {
            addCriterion("ACCT_SPREAD_RATE =", value, "acctSpreadRate");
            return (Criteria) this;
        }

        public Criteria andTaxTypeNoEqualTo(String value) {
            addCriterion("TAX_TYPE_NO =", value, "taxTypeNo");
            return (Criteria) this;
        }

        public Criteria andCalcBeginDateEqualTo(Date value) {
            addCriterion("CALC_BEGIN_DATE =", value, "calcBeginDate");
            return (Criteria) this;
        }

        public Criteria andIntAccruedCtdEqualTo(BigDecimal value) {
            addCriterion("INT_ACCRUED_CTD =", value, "intAccruedCtd");
            return (Criteria) this;
        }

        public Criteria andInternalKeyEqualTo(Integer value) {
            addCriterion("INTERNAL_KEY =", value, "internalKey");
            return (Criteria) this;
        }

        public Criteria andIntPostedEqualTo(BigDecimal value) {
            addCriterion("INT_POSTED =", value, "intPosted");
            return (Criteria) this;
        }

        public Criteria andIntFlagEqualTo(String value) {
            addCriterion("INT_FLAG =", value, "intFlag");
            return (Criteria) this;
        }

        public Criteria andRealRateEqualTo(BigDecimal value) {
            addCriterion("REAL_RATE =", value, "realRate");
            return (Criteria) this;
        }

        public Criteria andLastAccrualDateEqualTo(Date value) {
            addCriterion("LAST_ACCRUAL_DATE =", value, "lastAccrualDate");
            return (Criteria) this;
        }

        public Criteria andIntCalcBalEqualTo(String value) {
            addCriterion("INT_CALC_BAL =", value, "intCalcBal");
            return (Criteria) this;
        }

        public Criteria andNextAccrDateEqualTo(Date value) {
            addCriterion("NEXT_ACCR_DATE =", value, "nextAccrDate");
            return (Criteria) this;
        }

        public Criteria andCycleFreqEqualTo(String value) {
            addCriterion("CYCLE_FREQ =", value, "cycleFreq");
            return (Criteria) this;
        }

        public Criteria andCycleFlagEqualTo(String value) {
            addCriterion("CYCLE_FLAG =", value, "cycleFlag");
            return (Criteria) this;
        }

        public Criteria andMonthBasisTypeEqualTo(String value) {
            addCriterion("MONTH_BASIS_TYPE =", value, "monthBasisType");
            return (Criteria) this;
        }

        public Criteria andAgreeAggEqualTo(BigDecimal value) {
            addCriterion("AGREE_AGG =", value, "agreeAgg");
            return (Criteria) this;
        }

        public Criteria andIntCapFlagEqualTo(String value) {
            addCriterion("INT_CAP_FLAG =", value, "intCapFlag");
            return (Criteria) this;
        }

        public Criteria andTaxRateEqualTo(BigDecimal value) {
            addCriterion("TAX_RATE =", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andIntAccruedPrevEqualTo(BigDecimal value) {
            addCriterion("INT_ACCRUED_PREV =", value, "intAccruedPrev");
            return (Criteria) this;
        }

        public Criteria andDiscntUiFlagEqualTo(String value) {
            addCriterion("DISCNT_UI_FLAG =", value, "discntUiFlag");
            return (Criteria) this;
        }

        public Criteria andIntAmtEqualTo(BigDecimal value) {
            addCriterion("INT_AMT =", value, "intAmt");
            return (Criteria) this;
        }

        public Criteria andSpreadPercentEqualTo(BigDecimal value) {
            addCriterion("SPREAD_PERCENT =", value, "spreadPercent");
            return (Criteria) this;
        }

        public Criteria andAcctPercentRateEqualTo(BigDecimal value) {
            addCriterion("ACCT_PERCENT_RATE =", value, "acctPercentRate");
            return (Criteria) this;
        }

        public Criteria andIntAdjPrevEqualTo(BigDecimal value) {
            addCriterion("INT_ADJ_PREV =", value, "intAdjPrev");
            return (Criteria) this;
        }

        public Criteria andIntDayEqualTo(String value) {
            addCriterion("INT_DAY =", value, "intDay");
            return (Criteria) this;
        }

        public Criteria andFloatRateEqualTo(BigDecimal value) {
            addCriterion("FLOAT_RATE =", value, "floatRate");
            return (Criteria) this;
        }

        public Criteria andActualRateEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_RATE =", value, "actualRate");
            return (Criteria) this;
        }

        public Criteria andRetryFlagEqualTo(String value) {
            addCriterion("RETRY_FLAG =", value, "retryFlag");
            return (Criteria) this;
        }

        public Criteria andIntChangeTypeEqualTo(String value) {
            addCriterion("INT_CHANGE_TYPE =", value, "intChangeType");
            return (Criteria) this;
        }

        public Criteria andAcctFixedRateEqualTo(BigDecimal value) {
            addCriterion("ACCT_FIXED_RATE =", value, "acctFixedRate");
            return (Criteria) this;
        }

        public Criteria andAggEqualTo(BigDecimal value) {
            addCriterion("AGG =", value, "agg");
            return (Criteria) this;
        }

        public Criteria andPastFadRateEqualTo(BigDecimal value) {
            addCriterion("PAST_FAD_RATE =", value, "pastFadRate");
            return (Criteria) this;
        }

        public Criteria andLayerAgreementEqualTo(String value) {
            addCriterion("LAYER_AGREEMENT =", value, "layerAgreement");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimestampEqualTo(String value) {
            addCriterion("LAST_UPD_TIMESTAMP =", value, "lastUpdTimestamp");
            return (Criteria) this;
        }

        public Criteria andCalcEndDateEqualTo(Date value) {
            addCriterion("CALC_END_DATE =", value, "calcEndDate");
            return (Criteria) this;
        }

        public Criteria andIntPostedCtdEqualTo(BigDecimal value) {
            addCriterion("INT_POSTED_CTD =", value, "intPostedCtd");
            return (Criteria) this;
        }

        public Criteria andDiscntRetainIntEqualTo(BigDecimal value) {
            addCriterion("DISCNT_RETAIN_INT =", value, "discntRetainInt");
            return (Criteria) this;
        }

        public Criteria andDiscntIntEqualTo(BigDecimal value) {
            addCriterion("DISCNT_INT =", value, "discntInt");
            return (Criteria) this;
        }

        public Criteria andIntAdjEqualTo(BigDecimal value) {
            addCriterion("INT_ADJ =", value, "intAdj");
            return (Criteria) this;
        }

        public Criteria andIntClassEqualTo(String value) {
            addCriterion("INT_CLASS =", value, "intClass");
            return (Criteria) this;
        }

        public Criteria andIntAccruedCalcCtdEqualTo(BigDecimal value) {
            addCriterion("INT_ACCRUED_CALC_CTD =", value, "intAccruedCalcCtd");
            return (Criteria) this;
        }

        public Criteria andLastCycleDateEqualTo(Date value) {
            addCriterion("LAST_CYCLE_DATE =", value, "lastCycleDate");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(String value) {
            addCriterion("CREATE_TIMESTAMP =", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andTotalAggEqualTo(BigDecimal value) {
            addCriterion("TOTAL_AGG =", value, "totalAgg");
            return (Criteria) this;
        }

        public Criteria andIntAccruedDiffEqualTo(BigDecimal value) {
            addCriterion("INT_ACCRUED_DIFF =", value, "intAccruedDiff");
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