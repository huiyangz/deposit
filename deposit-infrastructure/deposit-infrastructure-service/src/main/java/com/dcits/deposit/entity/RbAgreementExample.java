package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbAgreementExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbAgreementExample() {
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

        public Criteria andSignBranchEqualTo(String value) {
            addCriterion("SIGN_BRANCH =", value, "signBranch");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeEqualTo(String value) {
            addCriterion("AGREEMENT_TYPE =", value, "agreementType");
            return (Criteria) this;
        }

        public Criteria andAgreementClassEqualTo(String value) {
            addCriterion("AGREEMENT_CLASS =", value, "agreementClass");
            return (Criteria) this;
        }

        public Criteria andAgreementKeyTypeEqualTo(String value) {
            addCriterion("AGREEMENT_KEY_TYPE =", value, "agreementKeyType");
            return (Criteria) this;
        }

        public Criteria andAgreementKeyEqualTo(String value) {
            addCriterion("AGREEMENT_KEY =", value, "agreementKey");
            return (Criteria) this;
        }

        public Criteria andAgreementAmtEqualTo(BigDecimal value) {
            addCriterion("AGREEMENT_AMT =", value, "agreementAmt");
            return (Criteria) this;
        }

        public Criteria andAgreProdTypeEqualTo(String value) {
            addCriterion("AGRE_PROD_TYPE =", value, "agreProdType");
            return (Criteria) this;
        }

        public Criteria andSignChannelEqualTo(String value) {
            addCriterion("SIGN_CHANNEL =", value, "signChannel");
            return (Criteria) this;
        }

        public Criteria andTranBranchEqualTo(String value) {
            addCriterion("TRAN_BRANCH =", value, "tranBranch");
            return (Criteria) this;
        }

        public Criteria andSignDateEqualTo(Date value) {
            addCriterion("SIGN_DATE =", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignUserIdEqualTo(String value) {
            addCriterion("SIGN_USER_ID =", value, "signUserId");
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

        public Criteria andAgreementStatusEqualTo(String value) {
            addCriterion("AGREEMENT_STATUS =", value, "agreementStatus");
            return (Criteria) this;
        }

        public Criteria andAgreementCloseAcctFlagEqualTo(String value) {
            addCriterion("AGREEMENT_CLOSE_ACCT_FLAG =", value, "agreementCloseAcctFlag");
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

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andClientShortEqualTo(String value) {
            addCriterion("CLIENT_SHORT =", value, "clientShort");
            return (Criteria) this;
        }

        public Criteria andOppositeInternalKeyEqualTo(Integer value) {
            addCriterion("OPPOSITE_INTERNAL_KEY =", value, "oppositeInternalKey");
            return (Criteria) this;
        }

        public Criteria andAgreementOpenDateEqualTo(Date value) {
            addCriterion("AGREEMENT_OPEN_DATE =", value, "agreementOpenDate");
            return (Criteria) this;
        }

        public Criteria andOutSignBranchEqualTo(String value) {
            addCriterion("OUT_SIGN_BRANCH =", value, "outSignBranch");
            return (Criteria) this;
        }

        public Criteria andOutSignChannelEqualTo(String value) {
            addCriterion("OUT_SIGN_CHANNEL =", value, "outSignChannel");
            return (Criteria) this;
        }

        public Criteria andOutSignDateEqualTo(Date value) {
            addCriterion("OUT_SIGN_DATE =", value, "outSignDate");
            return (Criteria) this;
        }

        public Criteria andOutSignUserIdEqualTo(String value) {
            addCriterion("OUT_SIGN_USER_ID =", value, "outSignUserId");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andLastChangeDateEqualTo(Date value) {
            addCriterion("LAST_CHANGE_DATE =", value, "lastChangeDate");
            return (Criteria) this;
        }

        public Criteria andLastChangeUserIdEqualTo(String value) {
            addCriterion("LAST_CHANGE_USER_ID =", value, "lastChangeUserId");
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