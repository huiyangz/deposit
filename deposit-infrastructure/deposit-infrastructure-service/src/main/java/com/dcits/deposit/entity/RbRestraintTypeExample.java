package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;

public class RbRestraintTypeExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbRestraintTypeExample() {
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

        public Criteria andRestraintTypeEqualTo(String value) {
            addCriterion("RESTRAINT_TYPE =", value, "restraintType");
            return (Criteria) this;
        }

        public Criteria andRestraintTypeDescEqualTo(String value) {
            addCriterion("RESTRAINT_TYPE_DESC =", value, "restraintTypeDesc");
            return (Criteria) this;
        }

        public Criteria andResPriorityEqualTo(String value) {
            addCriterion("RES_PRIORITY =", value, "resPriority");
            return (Criteria) this;
        }

        public Criteria andSystemUseFlagEqualTo(String value) {
            addCriterion("SYSTEM_USE_FLAG =", value, "systemUseFlag");
            return (Criteria) this;
        }

        public Criteria andAhBuFlagEqualTo(String value) {
            addCriterion("AH_BU_FLAG =", value, "ahBuFlag");
            return (Criteria) this;
        }

        public Criteria andManualResFlagEqualTo(String value) {
            addCriterion("MANUAL_RES_FLAG =", value, "manualResFlag");
            return (Criteria) this;
        }

        public Criteria andManualUnresFlagEqualTo(String value) {
            addCriterion("MANUAL_UNRES_FLAG =", value, "manualUnresFlag");
            return (Criteria) this;
        }

        public Criteria andDrCrCtlFlagEqualTo(String value) {
            addCriterion("DR_CR_CTL_FLAG =", value, "drCrCtlFlag");
            return (Criteria) this;
        }

        public Criteria andCashFlagEqualTo(String value) {
            addCriterion("CASH_FLAG =", value, "cashFlag");
            return (Criteria) this;
        }

        public Criteria andTransferFlagEqualTo(String value) {
            addCriterion("TRANSFER_FLAG =", value, "transferFlag");
            return (Criteria) this;
        }

        public Criteria andStopFlagEqualTo(String value) {
            addCriterion("STOP_FLAG =", value, "stopFlag");
            return (Criteria) this;
        }

        public Criteria andRestraintAmtFlagEqualTo(String value) {
            addCriterion("RESTRAINT_AMT_FLAG =", value, "restraintAmtFlag");
            return (Criteria) this;
        }

        public Criteria andResBranchRangeEqualTo(String value) {
            addCriterion("RES_BRANCH_RANGE =", value, "resBranchRange");
            return (Criteria) this;
        }

        public Criteria andUnMaintBranchRangeEqualTo(String value) {
            addCriterion("UN_MAINT_BRANCH_RANGE =", value, "unMaintBranchRange");
            return (Criteria) this;
        }

        public Criteria andAllowRepeatFlagEqualTo(String value) {
            addCriterion("ALLOW_REPEAT_FLAG =", value, "allowRepeatFlag");
            return (Criteria) this;
        }

        public Criteria andCloseAcctFlagEqualTo(String value) {
            addCriterion("CLOSE_ACCT_FLAG =", value, "closeAcctFlag");
            return (Criteria) this;
        }

        public Criteria andPledgedFlagEqualTo(String value) {
            addCriterion("PLEDGED_FLAG =", value, "pledgedFlag");
            return (Criteria) this;
        }

        public Criteria andFinFrozenFlagEqualTo(String value) {
            addCriterion("FIN_FROZEN_FLAG =", value, "finFrozenFlag");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
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