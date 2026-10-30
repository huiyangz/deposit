package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class TbTailboxExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public TbTailboxExample() {
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

        public Criteria andCashEqualTimestampEqualTo(String value) {
            addCriterion("CASH_EQUAL_TIMESTAMP =", value, "cashEqualTimestamp");
            return (Criteria) this;
        }

        public Criteria andEodCashEqualEqualTo(String value) {
            addCriterion("EOD_CASH_EQUAL =", value, "eodCashEqual");
            return (Criteria) this;
        }

        public Criteria andTailboxIdEqualTo(String value) {
            addCriterion("TAILBOX_ID =", value, "tailboxId");
            return (Criteria) this;
        }

        public Criteria andLastUserIdEqualTo(String value) {
            addCriterion("LAST_USER_ID =", value, "lastUserId");
            return (Criteria) this;
        }

        public Criteria andTailboxSubTypeEqualTo(String value) {
            addCriterion("TAILBOX_SUB_TYPE =", value, "tailboxSubType");
            return (Criteria) this;
        }

        public Criteria andBranchEqualTo(String value) {
            addCriterion("BRANCH =", value, "branch");
            return (Criteria) this;
        }

        public Criteria andVoucherEqualTimestampEqualTo(String value) {
            addCriterion("VOUCHER_EQUAL_TIMESTAMP =", value, "voucherEqualTimestamp");
            return (Criteria) this;
        }

        public Criteria andTranTimestampEqualTo(String value) {
            addCriterion("TRAN_TIMESTAMP =", value, "tranTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("COMPANY =", value, "company");
            return (Criteria) this;
        }

        public Criteria andAssignUserIdEqualTo(String value) {
            addCriterion("ASSIGN_USER_ID =", value, "assignUserId");
            return (Criteria) this;
        }

        public Criteria andTellerBindTypeEqualTo(String value) {
            addCriterion("TELLER_BIND_TYPE =", value, "tellerBindType");
            return (Criteria) this;
        }

        public Criteria andLastChangeDateEqualTo(Date value) {
            addCriterion("LAST_CHANGE_DATE =", value, "lastChangeDate");
            return (Criteria) this;
        }

        public Criteria andSodVoucherEqualEqualTo(String value) {
            addCriterion("SOD_VOUCHER_EQUAL =", value, "sodVoucherEqual");
            return (Criteria) this;
        }

        public Criteria andEodVoucherEqualEqualTo(String value) {
            addCriterion("EOD_VOUCHER_EQUAL =", value, "eodVoucherEqual");
            return (Criteria) this;
        }

        public Criteria andTailboxStatusEqualTo(String value) {
            addCriterion("TAILBOX_STATUS =", value, "tailboxStatus");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andMidVoucherEqualEqualTo(String value) {
            addCriterion("MID_VOUCHER_EQUAL =", value, "midVoucherEqual");
            return (Criteria) this;
        }

        public Criteria andMidCashEqualEqualTo(String value) {
            addCriterion("MID_CASH_EQUAL =", value, "midCashEqual");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(String value) {
            addCriterion("CREATE_TIMESTAMP =", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andTailboxTypeEqualTo(String value) {
            addCriterion("TAILBOX_TYPE =", value, "tailboxType");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andSodCashEqualEqualTo(String value) {
            addCriterion("SOD_CASH_EQUAL =", value, "sodCashEqual");
            return (Criteria) this;
        }

        public Criteria andTailboxPropertyEqualTo(String value) {
            addCriterion("TAILBOX_PROPERTY =", value, "tailboxProperty");
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