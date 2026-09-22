package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;

public class RbTranDefExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbTranDefExample() {
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

        public Criteria andTranTypeEqualTo(String value) {
            addCriterion("TRAN_TYPE =", value, "tranType");
            return (Criteria) this;
        }

        public Criteria andTranClassEqualTo(String value) {
            addCriterion("TRAN_CLASS =", value, "tranClass");
            return (Criteria) this;
        }

        public Criteria andTranTypeDescEqualTo(String value) {
            addCriterion("TRAN_TYPE_DESC =", value, "tranTypeDesc");
            return (Criteria) this;
        }

        public Criteria andPrintTranDescEqualTo(String value) {
            addCriterion("PRINT_TRAN_DESC =", value, "printTranDesc");
            return (Criteria) this;
        }

        public Criteria andCrDrIndEqualTo(String value) {
            addCriterion("CR_DR_IND =", value, "crDrInd");
            return (Criteria) this;
        }

        public Criteria andBalanceFlagEqualTo(String value) {
            addCriterion("BALANCE_FLAG =", value, "balanceFlag");
            return (Criteria) this;
        }

        public Criteria andCashTranFlagEqualTo(String value) {
            addCriterion("CASH_TRAN_FLAG =", value, "cashTranFlag");
            return (Criteria) this;
        }

        public Criteria andUpdTailboxFlagEqualTo(String value) {
            addCriterion("UPD_TAILBOX_FLAG =", value, "updTailboxFlag");
            return (Criteria) this;
        }

        public Criteria andResPriorityEqualTo(String value) {
            addCriterion("RES_PRIORITY =", value, "resPriority");
            return (Criteria) this;
        }

        public Criteria andRecalcAcctStopPayFlagEqualTo(String value) {
            addCriterion("RECALC_ACCT_STOP_PAY_FLAG =", value, "recalcAcctStopPayFlag");
            return (Criteria) this;
        }

        public Criteria andRecalcResAmtFlagEqualTo(String value) {
            addCriterion("RECALC_RES_AMT_FLAG =", value, "recalcResAmtFlag");
            return (Criteria) this;
        }

        public Criteria andAvailbalCalcTypeEqualTo(String value) {
            addCriterion("AVAILBAL_CALC_TYPE =", value, "availbalCalcType");
            return (Criteria) this;
        }

        public Criteria andOthTranTypeEqualTo(String value) {
            addCriterion("OTH_TRAN_TYPE =", value, "othTranType");
            return (Criteria) this;
        }

        public Criteria andReversalEqualTo(String value) {
            addCriterion("REVERSAL =", value, "reversal");
            return (Criteria) this;
        }

        public Criteria andReversalTranTypeEqualTo(String value) {
            addCriterion("REVERSAL_TRAN_TYPE =", value, "reversalTranType");
            return (Criteria) this;
        }

        public Criteria andProgramIdGroupEqualTo(String value) {
            addCriterion("PROGRAM_ID_GROUP =", value, "programIdGroup");
            return (Criteria) this;
        }

        public Criteria andBalTypePriorityEqualTo(String value) {
            addCriterion("BAL_TYPE_PRIORITY =", value, "balTypePriority");
            return (Criteria) this;
        }

        public Criteria andCorrectFlagEqualTo(String value) {
            addCriterion("CORRECT_FLAG =", value, "correctFlag");
            return (Criteria) this;
        }

        public Criteria andMultiRvsTranTypeFlagEqualTo(String value) {
            addCriterion("MULTI_RVS_TRAN_TYPE_FLAG =", value, "multiRvsTranTypeFlag");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(String value) {
            addCriterion("SOURCE_TYPE =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andIsInitParamEqualTo(String value) {
            addCriterion("IS_INIT_PARAM =", value, "isInitParam");
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

        public Criteria andChequeBookFlagEqualTo(String value) {
            addCriterion("CHEQUE_BOOK_FLAG =", value, "chequeBookFlag");
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