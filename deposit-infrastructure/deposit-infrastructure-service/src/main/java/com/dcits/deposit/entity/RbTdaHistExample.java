package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbTdaHistExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbTdaHistExample() {
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

        public Criteria andSeqNoEqualTo(String value) {
            addCriterion("SEQ_NO =", value, "seqNo");
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

        public Criteria andAcctOpenDateEqualTo(Date value) {
            addCriterion("ACCT_OPEN_DATE =", value, "acctOpenDate");
            return (Criteria) this;
        }

        public Criteria andMaturityDateEqualTo(Date value) {
            addCriterion("MATURITY_DATE =", value, "maturityDate");
            return (Criteria) this;
        }

        public Criteria andAcctMovtDateEqualTo(Date value) {
            addCriterion("ACCT_MOVT_DATE =", value, "acctMovtDate");
            return (Criteria) this;
        }

        public Criteria andMovtStatusEqualTo(String value) {
            addCriterion("MOVT_STATUS =", value, "movtStatus");
            return (Criteria) this;
        }

        public Criteria andAddTermEqualTo(Integer value) {
            addCriterion("ADD_TERM =", value, "addTerm");
            return (Criteria) this;
        }

        public Criteria andTermEqualTo(String value) {
            addCriterion("TERM =", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermTypeEqualTo(String value) {
            addCriterion("TERM_TYPE =", value, "termType");
            return (Criteria) this;
        }

        public Criteria andAutoRenewRolloverEqualTo(String value) {
            addCriterion("AUTO_RENEW_ROLLOVER =", value, "autoRenewRollover");
            return (Criteria) this;
        }

        public Criteria andPartialRenewRollEqualTo(String value) {
            addCriterion("PARTIAL_RENEW_ROLL =", value, "partialRenewRoll");
            return (Criteria) this;
        }

        public Criteria andPartialRenewAmtEqualTo(BigDecimal value) {
            addCriterion("PARTIAL_RENEW_AMT =", value, "partialRenewAmt");
            return (Criteria) this;
        }

        public Criteria andAddtlPrincipalEqualTo(String value) {
            addCriterion("ADDTL_PRINCIPAL =", value, "addtlPrincipal");
            return (Criteria) this;
        }

        public Criteria andRolloverNoEqualTo(Integer value) {
            addCriterion("ROLLOVER_NO =", value, "rolloverNo");
            return (Criteria) this;
        }

        public Criteria andRenewNoEqualTo(Integer value) {
            addCriterion("RENEW_NO =", value, "renewNo");
            return (Criteria) this;
        }

        public Criteria andTdaStatusEqualTo(String value) {
            addCriterion("TDA_STATUS =", value, "tdaStatus");
            return (Criteria) this;
        }

        public Criteria andRenewTimesEqualTo(Integer value) {
            addCriterion("RENEW_TIMES =", value, "renewTimes");
            return (Criteria) this;
        }

        public Criteria andRevSeqNoEqualTo(String value) {
            addCriterion("REV_SEQ_NO =", value, "revSeqNo");
            return (Criteria) this;
        }

        public Criteria andTranSeqNoEqualTo(String value) {
            addCriterion("TRAN_SEQ_NO =", value, "tranSeqNo");
            return (Criteria) this;
        }

        public Criteria andTdaCertificateNoEqualTo(String value) {
            addCriterion("TDA_CERTIFICATE_NO =", value, "tdaCertificateNo");
            return (Criteria) this;
        }

        public Criteria andAcctLevelIntRateEqualTo(BigDecimal value) {
            addCriterion("ACCT_LEVEL_INT_RATE =", value, "acctLevelIntRate");
            return (Criteria) this;
        }

        public Criteria andLostNoEqualTo(String value) {
            addCriterion("LOST_NO =", value, "lostNo");
            return (Criteria) this;
        }

        public Criteria andReferenceEqualTo(String value) {
            addCriterion("REFERENCE =", value, "reference");
            return (Criteria) this;
        }

        public Criteria andTaxAmtEqualTo(BigDecimal value) {
            addCriterion("TAX_AMT =", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andDebtAmtEqualTo(BigDecimal value) {
            addCriterion("DEBT_AMT =", value, "debtAmt");
            return (Criteria) this;
        }

        public Criteria andPrincipalAmtEqualTo(BigDecimal value) {
            addCriterion("PRINCIPAL_AMT =", value, "principalAmt");
            return (Criteria) this;
        }

        public Criteria andPrincipalAmtActualEqualTo(BigDecimal value) {
            addCriterion("PRINCIPAL_AMT_ACTUAL =", value, "principalAmtActual");
            return (Criteria) this;
        }

        public Criteria andGrossInterestAmtEqualTo(BigDecimal value) {
            addCriterion("GROSS_INTEREST_AMT =", value, "grossInterestAmt");
            return (Criteria) this;
        }

        public Criteria andIntAdjEqualTo(BigDecimal value) {
            addCriterion("INT_ADJ =", value, "intAdj");
            return (Criteria) this;
        }

        public Criteria andIntAdjCtdEqualTo(BigDecimal value) {
            addCriterion("INT_ADJ_CTD =", value, "intAdjCtd");
            return (Criteria) this;
        }

        public Criteria andNetInterestAmtEqualTo(BigDecimal value) {
            addCriterion("NET_INTEREST_AMT =", value, "netInterestAmt");
            return (Criteria) this;
        }

        public Criteria andSpreadRateEqualTo(BigDecimal value) {
            addCriterion("SPREAD_RATE =", value, "spreadRate");
            return (Criteria) this;
        }

        public Criteria andDebtIntRateEqualTo(BigDecimal value) {
            addCriterion("DEBT_INT_RATE =", value, "debtIntRate");
            return (Criteria) this;
        }

        public Criteria andTranSceneEqualTo(String value) {
            addCriterion("TRAN_SCENE =", value, "tranScene");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(String value) {
            addCriterion("CREATE_TIMESTAMP =", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andTranTimestampEqualTo(String value) {
            addCriterion("TRAN_TIMESTAMP =", value, "tranTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastChangeDateEqualTo(Date value) {
            addCriterion("LAST_CHANGE_DATE =", value, "lastChangeDate");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("COMPANY =", value, "company");
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