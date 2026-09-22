package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class RbAgreementYhtExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbAgreementYhtExample() {
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

        public Criteria andMainAgreementIdEqualTo(String value) {
            addCriterion("MAIN_AGREEMENT_ID =", value, "mainAgreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementStatusEqualTo(String value) {
            addCriterion("AGREEMENT_STATUS =", value, "agreementStatus");
            return (Criteria) this;
        }

        public Criteria andInternalKeyEqualTo(Integer value) {
            addCriterion("INTERNAL_KEY =", value, "internalKey");
            return (Criteria) this;
        }

        public Criteria andParentInternalKeyEqualTo(Integer value) {
            addCriterion("PARENT_INTERNAL_KEY =", value, "parentInternalKey");
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

        public Criteria andAltAcctNameEqualTo(String value) {
            addCriterion("ALT_ACCT_NAME =", value, "altAcctName");
            return (Criteria) this;
        }

        public Criteria andAcctRealFlagEqualTo(String value) {
            addCriterion("ACCT_REAL_FLAG =", value, "acctRealFlag");
            return (Criteria) this;
        }

        public Criteria andNextMaxSeqNoEqualTo(String value) {
            addCriterion("NEXT_MAX_SEQ_NO =", value, "nextMaxSeqNo");
            return (Criteria) this;
        }

        public Criteria andSelfFlagEqualTo(String value) {
            addCriterion("SELF_FLAG =", value, "selfFlag");
            return (Criteria) this;
        }

        public Criteria andIntFlagEqualTo(String value) {
            addCriterion("INT_FLAG =", value, "intFlag");
            return (Criteria) this;
        }

        public Criteria andSettleIndEqualTo(String value) {
            addCriterion("SETTLE_IND =", value, "settleInd");
            return (Criteria) this;
        }

        public Criteria andYhtProdTypeEqualTo(String value) {
            addCriterion("YHT_PROD_TYPE =", value, "yhtProdType");
            return (Criteria) this;
        }

        public Criteria andYhtAcctFlagEqualTo(String value) {
            addCriterion("YHT_ACCT_FLAG =", value, "yhtAcctFlag");
            return (Criteria) this;
        }

        public Criteria andYhtAcctLevelEqualTo(String value) {
            addCriterion("YHT_ACCT_LEVEL =", value, "yhtAcctLevel");
            return (Criteria) this;
        }

        public Criteria andYhtAcctMainFlagEqualTo(String value) {
            addCriterion("YHT_ACCT_MAIN_FLAG =", value, "yhtAcctMainFlag");
            return (Criteria) this;
        }

        public Criteria andYhtAcctOrgSchemaEqualTo(String value) {
            addCriterion("YHT_ACCT_ORG_SCHEMA =", value, "yhtAcctOrgSchema");
            return (Criteria) this;
        }

        public Criteria andIssOdFlagEqualTo(String value) {
            addCriterion("ISS_OD_FLAG =", value, "issOdFlag");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(String value) {
            addCriterion("SOURCE_TYPE =", value, "sourceType");
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

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("COMPANY =", value, "company");
            return (Criteria) this;
        }

        public Criteria andNonTransplantFlagEqualTo(String value) {
            addCriterion("NON_TRANSPLANT_FLAG =", value, "nonTransplantFlag");
            return (Criteria) this;
        }

        public Criteria andAcctSettleMethodEqualTo(String value) {
            addCriterion("ACCT_SETTLE_METHOD =", value, "acctSettleMethod");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(String value) {
            addCriterion("CREATE_TIMESTAMP =", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastChangeDateEqualTo(Date value) {
            addCriterion("LAST_CHANGE_DATE =", value, "lastChangeDate");
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