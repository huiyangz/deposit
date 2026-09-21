package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbCommissionRegisterExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbCommissionRegisterExample() {
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

        public Criteria andChannelSeqNoEqualTo(String value) {
            addCriterion("CHANNEL_SEQ_NO =", value, "channelSeqNo");
            return (Criteria) this;
        }

        public Criteria andReferenceEqualTo(String value) {
            addCriterion("REFERENCE =", value, "reference");
            return (Criteria) this;
        }

        public Criteria andProgramIdEqualTo(String value) {
            addCriterion("PROGRAM_ID =", value, "programId");
            return (Criteria) this;
        }

        public Criteria andTranDateEqualTo(Date value) {
            addCriterion("TRAN_DATE =", value, "tranDate");
            return (Criteria) this;
        }

        public Criteria andTranBranchEqualTo(String value) {
            addCriterion("TRAN_BRANCH =", value, "tranBranch");
            return (Criteria) this;
        }

        public Criteria andInternalKeyEqualTo(Integer value) {
            addCriterion("INTERNAL_KEY =", value, "internalKey");
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

        public Criteria andTranTypeEqualTo(String value) {
            addCriterion("TRAN_TYPE =", value, "tranType");
            return (Criteria) this;
        }

        public Criteria andEventTypeEqualTo(String value) {
            addCriterion("EVENT_TYPE =", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andTranAmtEqualTo(BigDecimal value) {
            addCriterion("TRAN_AMT =", value, "tranAmt");
            return (Criteria) this;
        }

        public Criteria andDocTypeEqualTo(String value) {
            addCriterion("DOC_TYPE =", value, "docType");
            return (Criteria) this;
        }

        public Criteria andPrefixEqualTo(String value) {
            addCriterion("PREFIX =", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andVoucherNoEqualTo(String value) {
            addCriterion("VOUCHER_NO =", value, "voucherNo");
            return (Criteria) this;
        }

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andCommissionClientNameEqualTo(String value) {
            addCriterion("COMMISSION_CLIENT_NAME =", value, "commissionClientName");
            return (Criteria) this;
        }

        public Criteria andCommissionClientNoEqualTo(String value) {
            addCriterion("COMMISSION_CLIENT_NO =", value, "commissionClientNo");
            return (Criteria) this;
        }

        public Criteria andCommissionDocumentIdEqualTo(String value) {
            addCriterion("COMMISSION_DOCUMENT_ID =", value, "commissionDocumentId");
            return (Criteria) this;
        }

        public Criteria andCommissionDocumentTypeEqualTo(String value) {
            addCriterion("COMMISSION_DOCUMENT_TYPE =", value, "commissionDocumentType");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("COUNTRY =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCommissionStartDateEqualTo(Date value) {
            addCriterion("COMMISSION_START_DATE =", value, "commissionStartDate");
            return (Criteria) this;
        }

        public Criteria andCommissionExpireDateEqualTo(Date value) {
            addCriterion("COMMISSION_EXPIRE_DATE =", value, "commissionExpireDate");
            return (Criteria) this;
        }

        public Criteria andCommissionClientTelEqualTo(String value) {
            addCriterion("COMMISSION_CLIENT_TEL =", value, "commissionClientTel");
            return (Criteria) this;
        }

        public Criteria andCommissionReasonEqualTo(String value) {
            addCriterion("COMMISSION_REASON =", value, "commissionReason");
            return (Criteria) this;
        }

        public Criteria andCommissionRelationEqualTo(String value) {
            addCriterion("COMMISSION_RELATION =", value, "commissionRelation");
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

        public Criteria andCommissionConfirmUserIdKey1EqualTo(String value) {
            addCriterion("COMMISSION_CONFIRM_USER_ID_KEY1 =", value, "commissionConfirmUserIdKey1");
            return (Criteria) this;
        }

        public Criteria andCommissionConfirmUserIdKey2EqualTo(String value) {
            addCriterion("COMMISSION_CONFIRM_USER_ID_KEY2 =", value, "commissionConfirmUserIdKey2");
            return (Criteria) this;
        }

        public Criteria andCommissionConfirmTelEqualTo(String value) {
            addCriterion("COMMISSION_CONFIRM_TEL =", value, "commissionConfirmTel");
            return (Criteria) this;
        }

        public Criteria andCommissionConfirmTimeEqualTo(String value) {
            addCriterion("COMMISSION_CONFIRM_TIME =", value, "commissionConfirmTime");
            return (Criteria) this;
        }

        public Criteria andCommissionConfirmResultEqualTo(String value) {
            addCriterion("COMMISSION_CONFIRM_RESULT =", value, "commissionConfirmResult");
            return (Criteria) this;
        }

        public Criteria andCommissionFlagEqualTo(String value) {
            addCriterion("COMMISSION_FLAG =", value, "commissionFlag");
            return (Criteria) this;
        }

        public Criteria andIsCommissionEqualTo(String value) {
            addCriterion("IS_COMMISSION =", value, "isCommission");
            return (Criteria) this;
        }

        public Criteria andLastChangeDateEqualTo(Date value) {
            addCriterion("LAST_CHANGE_DATE =", value, "lastChangeDate");
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