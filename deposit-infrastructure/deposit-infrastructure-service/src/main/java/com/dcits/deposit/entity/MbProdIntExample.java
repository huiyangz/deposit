package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class MbProdIntExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MbProdIntExample() {
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

        public Criteria andVoucherIdEqualTo(Integer value) {
            addCriterion("VOUCHER_ID =", value, "voucherId");
            return (Criteria) this;
        }

        public Criteria andAcctRateFlagEqualTo(String value) {
            addCriterion("ACCT_RATE_FLAG =", value, "acctRateFlag");
            return (Criteria) this;
        }

        public Criteria andRoundDownFlagEqualTo(String value) {
            addCriterion("ROUND_DOWN_FLAG =", value, "roundDownFlag");
            return (Criteria) this;
        }

        public Criteria andVoucherStartNoEqualTo(String value) {
            addCriterion("VOUCHER_START_NO =", value, "voucherStartNo");
            return (Criteria) this;
        }

        public Criteria andYearBasisTypeEqualTo(String value) {
            addCriterion("YEAR_BASIS_TYPE =", value, "yearBasisType");
            return (Criteria) this;
        }

        public Criteria andMaxRateEqualTo(BigDecimal value) {
            addCriterion("MAX_RATE =", value, "maxRate");
            return (Criteria) this;
        }

        public Criteria andVoucherStatusEqualTo(String value) {
            addCriterion("VOUCHER_STATUS =", value, "voucherStatus");
            return (Criteria) this;
        }

        public Criteria andTailboxIdEqualTo(String value) {
            addCriterion("TAILBOX_ID =", value, "tailboxId");
            return (Criteria) this;
        }

        public Criteria andEopdVoucherSumEqualTo(Integer value) {
            addCriterion("EOPD_VOUCHER_SUM =", value, "eopdVoucherSum");
            return (Criteria) this;
        }

        public Criteria andSpreadRateEqualTo(BigDecimal value) {
            addCriterion("SPREAD_RATE =", value, "spreadRate");
            return (Criteria) this;
        }

        public Criteria andIntMatchRuleEqualTo(String value) {
            addCriterion("INT_MATCH_RULE =", value, "intMatchRule");
            return (Criteria) this;
        }

        public Criteria andMonthBasisTypeEqualTo(String value) {
            addCriterion("MONTH_BASIS_TYPE =", value, "monthBasisType");
            return (Criteria) this;
        }

        public Criteria andStartNoIntEqualTo(Integer value) {
            addCriterion("START_NO_INT =", value, "startNoInt");
            return (Criteria) this;
        }

        public Criteria andMaxRateExpEqualTo(String value) {
            addCriterion("MAX_RATE_EXP =", value, "maxRateExp");
            return (Criteria) this;
        }

        public Criteria andPrefixEqualTo(String value) {
            addCriterion("PREFIX =", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andMinRateExpEqualTo(String value) {
            addCriterion("MIN_RATE_EXP =", value, "minRateExp");
            return (Criteria) this;
        }

        public Criteria andGearAmtMethodEqualTo(String value) {
            addCriterion("GEAR_AMT_METHOD =", value, "gearAmtMethod");
            return (Criteria) this;
        }

        public Criteria andRollDayEqualTo(String value) {
            addCriterion("ROLL_DAY =", value, "rollDay");
            return (Criteria) this;
        }

        public Criteria andProdNoEqualTo(String value) {
            addCriterion("PROD_NO =", value, "prodNo");
            return (Criteria) this;
        }

        public Criteria andIntCalcMethodEqualTo(String value) {
            addCriterion("INT_CALC_METHOD =", value, "intCalcMethod");
            return (Criteria) this;
        }

        public Criteria andLastUserIdEqualTo(String value) {
            addCriterion("LAST_USER_ID =", value, "lastUserId");
            return (Criteria) this;
        }

        public Criteria andBranchEqualTo(String value) {
            addCriterion("BRANCH =", value, "branch");
            return (Criteria) this;
        }

        public Criteria andGearDaysIndEqualTo(String value) {
            addCriterion("GEAR_DAYS_IND =", value, "gearDaysInd");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andIntTypeEqualTo(String value) {
            addCriterion("INT_TYPE =", value, "intType");
            return (Criteria) this;
        }

        public Criteria andGearAmtIndEqualTo(String value) {
            addCriterion("GEAR_AMT_IND =", value, "gearAmtInd");
            return (Criteria) this;
        }

        public Criteria andDaysGearTypeEqualTo(String value) {
            addCriterion("DAYS_GEAR_TYPE =", value, "daysGearType");
            return (Criteria) this;
        }

        public Criteria andIntChangeTypeEqualTo(String value) {
            addCriterion("INT_CHANGE_TYPE =", value, "intChangeType");
            return (Criteria) this;
        }

        public Criteria andMinRateEqualTo(BigDecimal value) {
            addCriterion("MIN_RATE =", value, "minRate");
            return (Criteria) this;
        }

        public Criteria andEffectDateCalcMethodEqualTo(String value) {
            addCriterion("EFFECT_DATE_CALC_METHOD =", value, "effectDateCalcMethod");
            return (Criteria) this;
        }

        public Criteria andGroupRuleTypeExpEqualTo(String value) {
            addCriterion("GROUP_RULE_TYPE_EXP =", value, "groupRuleTypeExp");
            return (Criteria) this;
        }

        public Criteria andRateLayerRuleEqualTo(String value) {
            addCriterion("RATE_LAYER_RULE =", value, "rateLayerRule");
            return (Criteria) this;
        }

        public Criteria andGroupRuleTypeEqualTo(String value) {
            addCriterion("GROUP_RULE_TYPE =", value, "groupRuleType");
            return (Criteria) this;
        }

        public Criteria andRollFreqEqualTo(String value) {
            addCriterion("ROLL_FREQ =", value, "rollFreq");
            return (Criteria) this;
        }

        public Criteria andIntCalcAmtTypeEqualTo(String value) {
            addCriterion("INT_CALC_AMT_TYPE =", value, "intCalcAmtType");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(String value) {
            addCriterion("CREATE_TIMESTAMP =", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andDocTypeEqualTo(String value) {
            addCriterion("DOC_TYPE =", value, "docType");
            return (Criteria) this;
        }

        public Criteria andSopdVoucherSumEqualTo(Integer value) {
            addCriterion("SOPD_VOUCHER_SUM =", value, "sopdVoucherSum");
            return (Criteria) this;
        }

        public Criteria andSpreadPercentEqualTo(BigDecimal value) {
            addCriterion("SPREAD_PERCENT =", value, "spreadPercent");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimestampEqualTo(String value) {
            addCriterion("LAST_UPD_TIMESTAMP =", value, "lastUpdTimestamp");
            return (Criteria) this;
        }

        public Criteria andIntRecalcMethodEqualTo(String value) {
            addCriterion("INT_RECALC_METHOD =", value, "intRecalcMethod");
            return (Criteria) this;
        }

        public Criteria andTaxTypeNoEqualTo(String value) {
            addCriterion("TAX_TYPE_NO =", value, "taxTypeNo");
            return (Criteria) this;
        }

        public Criteria andEventTypeEqualTo(String value) {
            addCriterion("EVENT_TYPE =", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andCalcByIntEqualTo(String value) {
            addCriterion("CALC_BY_INT =", value, "calcByInt");
            return (Criteria) this;
        }

        public Criteria andVoucherEndNoEqualTo(String value) {
            addCriterion("VOUCHER_END_NO =", value, "voucherEndNo");
            return (Criteria) this;
        }

        public Criteria andGearDaysMethodEqualTo(String value) {
            addCriterion("GEAR_DAYS_METHOD =", value, "gearDaysMethod");
            return (Criteria) this;
        }

        public Criteria andMonthBasisExpEqualTo(String value) {
            addCriterion("MONTH_BASIS_EXP =", value, "monthBasisExp");
            return (Criteria) this;
        }

        public Criteria andRateGearAmtTypeEqualTo(String value) {
            addCriterion("RATE_GEAR_AMT_TYPE =", value, "rateGearAmtType");
            return (Criteria) this;
        }

        public Criteria andVoucherSumEqualTo(Integer value) {
            addCriterion("VOUCHER_SUM =", value, "voucherSum");
            return (Criteria) this;
        }

        public Criteria andIntClassEqualTo(String value) {
            addCriterion("INT_CLASS =", value, "intClass");
            return (Criteria) this;
        }

        public Criteria andIntCalcAmtTypeExpEqualTo(String value) {
            addCriterion("INT_CALC_AMT_TYPE_EXP =", value, "intCalcAmtTypeExp");
            return (Criteria) this;
        }

        public Criteria andIntCalcMethodExpEqualTo(String value) {
            addCriterion("INT_CALC_METHOD_EXP =", value, "intCalcMethodExp");
            return (Criteria) this;
        }

        public Criteria andEndNoIntEqualTo(Integer value) {
            addCriterion("END_NO_INT =", value, "endNoInt");
            return (Criteria) this;
        }

        public Criteria andIntTypeExpEqualTo(String value) {
            addCriterion("INT_TYPE_EXP =", value, "intTypeExp");
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