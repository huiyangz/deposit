package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbFeeAmortizeExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbFeeAmortizeExample() {
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

        public Criteria andOsdSeqNoEqualTo(String value) {
            addCriterion("OSD_SEQ_NO =", value, "osdSeqNo");
            return (Criteria) this;
        }

        public Criteria andEffectDateEqualTo(Date value) {
            addCriterion("EFFECT_DATE =", value, "effectDate");
            return (Criteria) this;
        }

        public Criteria andAmortizePeriodTypeEqualTo(String value) {
            addCriterion("AMORTIZE_PERIOD_TYPE =", value, "amortizePeriodType");
            return (Criteria) this;
        }

        public Criteria andChargeModeEqualTo(String value) {
            addCriterion("CHARGE_MODE =", value, "chargeMode");
            return (Criteria) this;
        }

        public Criteria andAmortizeMonthEqualTo(String value) {
            addCriterion("AMORTIZE_MONTH =", value, "amortizeMonth");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andAmortizeNameEqualTo(String value) {
            addCriterion("AMORTIZE_NAME =", value, "amortizeName");
            return (Criteria) this;
        }

        public Criteria andNextAmortizeDateEqualTo(Date value) {
            addCriterion("NEXT_AMORTIZE_DATE =", value, "nextAmortizeDate");
            return (Criteria) this;
        }

        public Criteria andAmortizeStatusEqualTo(String value) {
            addCriterion("AMORTIZE_STATUS =", value, "amortizeStatus");
            return (Criteria) this;
        }

        public Criteria andTranTypeEqualTo(String value) {
            addCriterion("TRAN_TYPE =", value, "tranType");
            return (Criteria) this;
        }

        public Criteria andChannelSeqNoEqualTo(String value) {
            addCriterion("CHANNEL_SEQ_NO =", value, "channelSeqNo");
            return (Criteria) this;
        }

        public Criteria andTranBranchEqualTo(String value) {
            addCriterion("TRAN_BRANCH =", value, "tranBranch");
            return (Criteria) this;
        }

        public Criteria andAmortizeDayEqualTo(String value) {
            addCriterion("AMORTIZE_DAY =", value, "amortizeDay");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(String value) {
            addCriterion("CREATE_TIMESTAMP =", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andBusiNoEqualTo(String value) {
            addCriterion("BUSI_NO =", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andAmortizeTotalCntEqualTo(Integer value) {
            addCriterion("AMORTIZE_TOTAL_CNT =", value, "amortizeTotalCnt");
            return (Criteria) this;
        }

        public Criteria andRemainAmortizeCntEqualTo(Integer value) {
            addCriterion("REMAIN_AMORTIZE_CNT =", value, "remainAmortizeCnt");
            return (Criteria) this;
        }

        public Criteria andAmortizeCcyEqualTo(String value) {
            addCriterion("AMORTIZE_CCY =", value, "amortizeCcy");
            return (Criteria) this;
        }

        public Criteria andContractNoEqualTo(String value) {
            addCriterion("CONTRACT_NO =", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andReferenceEqualTo(String value) {
            addCriterion("REFERENCE =", value, "reference");
            return (Criteria) this;
        }

        public Criteria andAmortizeTotalAmtEqualTo(BigDecimal value) {
            addCriterion("AMORTIZE_TOTAL_AMT =", value, "amortizeTotalAmt");
            return (Criteria) this;
        }

        public Criteria andFeeTypeEqualTo(String value) {
            addCriterion("FEE_TYPE =", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimestampEqualTo(String value) {
            addCriterion("LAST_UPD_TIMESTAMP =", value, "lastUpdTimestamp");
            return (Criteria) this;
        }

        public Criteria andAmortizedCntEqualTo(Integer value) {
            addCriterion("AMORTIZED_CNT =", value, "amortizedCnt");
            return (Criteria) this;
        }

        public Criteria andAmortizedAmtEqualTo(BigDecimal value) {
            addCriterion("AMORTIZED_AMT =", value, "amortizedAmt");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(String value) {
            addCriterion("SOURCE_TYPE =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andAmortizeIdEqualTo(String value) {
            addCriterion("AMORTIZE_ID =", value, "amortizeId");
            return (Criteria) this;
        }

        public Criteria andAmortizeTimeTypeEqualTo(String value) {
            addCriterion("AMORTIZE_TIME_TYPE =", value, "amortizeTimeType");
            return (Criteria) this;
        }

        public Criteria andBankSeqNoEqualTo(String value) {
            addCriterion("BANK_SEQ_NO =", value, "bankSeqNo");
            return (Criteria) this;
        }

        public Criteria andInternalKeyEqualTo(Integer value) {
            addCriterion("INTERNAL_KEY =", value, "internalKey");
            return (Criteria) this;
        }

        public Criteria andLastAmortizeDateEqualTo(Date value) {
            addCriterion("LAST_AMORTIZE_DATE =", value, "lastAmortizeDate");
            return (Criteria) this;
        }

        public Criteria andRemainAmortizeAmtEqualTo(BigDecimal value) {
            addCriterion("REMAIN_AMORTIZE_AMT =", value, "remainAmortizeAmt");
            return (Criteria) this;
        }

        public Criteria andTranDateEqualTo(Date value) {
            addCriterion("TRAN_DATE =", value, "tranDate");
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