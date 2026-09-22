package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbAcctSettleExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbAcctSettleExample() {
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

        public Criteria andInternalKeyEqualTo(Integer value) {
            addCriterion("INTERNAL_KEY =", value, "internalKey");
            return (Criteria) this;
        }

        public Criteria andSettleNoEqualTo(String value) {
            addCriterion("SETTLE_NO =", value, "settleNo");
            return (Criteria) this;
        }

        public Criteria andResSeqNoEqualTo(String value) {
            addCriterion("RES_SEQ_NO =", value, "resSeqNo");
            return (Criteria) this;
        }

        public Criteria andEventTypeEqualTo(String value) {
            addCriterion("EVENT_TYPE =", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andReferenceEqualTo(String value) {
            addCriterion("REFERENCE =", value, "reference");
            return (Criteria) this;
        }

        public Criteria andSettleAcctClassEqualTo(String value) {
            addCriterion("SETTLE_ACCT_CLASS =", value, "settleAcctClass");
            return (Criteria) this;
        }

        public Criteria andSettleMethodEqualTo(String value) {
            addCriterion("SETTLE_METHOD =", value, "settleMethod");
            return (Criteria) this;
        }

        public Criteria andPayRecIndEqualTo(String value) {
            addCriterion("PAY_REC_IND =", value, "payRecInd");
            return (Criteria) this;
        }

        public Criteria andAmtTypeEqualTo(String value) {
            addCriterion("AMT_TYPE =", value, "amtType");
            return (Criteria) this;
        }

        public Criteria andSettleClientEqualTo(String value) {
            addCriterion("SETTLE_CLIENT =", value, "settleClient");
            return (Criteria) this;
        }

        public Criteria andBankInOutEqualTo(String value) {
            addCriterion("BANK_IN_OUT =", value, "bankInOut");
            return (Criteria) this;
        }

        public Criteria andSettleBankFlagEqualTo(String value) {
            addCriterion("SETTLE_BANK_FLAG =", value, "settleBankFlag");
            return (Criteria) this;
        }

        public Criteria andSettleBankNameEqualTo(String value) {
            addCriterion("SETTLE_BANK_NAME =", value, "settleBankName");
            return (Criteria) this;
        }

        public Criteria andSettleAcctInternalKeyEqualTo(Integer value) {
            addCriterion("SETTLE_ACCT_INTERNAL_KEY =", value, "settleAcctInternalKey");
            return (Criteria) this;
        }

        public Criteria andSettleBaseAcctNoEqualTo(String value) {
            addCriterion("SETTLE_BASE_ACCT_NO =", value, "settleBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andSettleProdTypeEqualTo(String value) {
            addCriterion("SETTLE_PROD_TYPE =", value, "settleProdType");
            return (Criteria) this;
        }

        public Criteria andSettleAcctCcyEqualTo(String value) {
            addCriterion("SETTLE_ACCT_CCY =", value, "settleAcctCcy");
            return (Criteria) this;
        }

        public Criteria andSettleAcctSeqNoEqualTo(String value) {
            addCriterion("SETTLE_ACCT_SEQ_NO =", value, "settleAcctSeqNo");
            return (Criteria) this;
        }

        public Criteria andSettleAcctNameEqualTo(String value) {
            addCriterion("SETTLE_ACCT_NAME =", value, "settleAcctName");
            return (Criteria) this;
        }

        public Criteria andSettleMobilePhoneEqualTo(String value) {
            addCriterion("SETTLE_MOBILE_PHONE =", value, "settleMobilePhone");
            return (Criteria) this;
        }

        public Criteria andSettleBranchEqualTo(String value) {
            addCriterion("SETTLE_BRANCH =", value, "settleBranch");
            return (Criteria) this;
        }

        public Criteria andSettleWeightEqualTo(BigDecimal value) {
            addCriterion("SETTLE_WEIGHT =", value, "settleWeight");
            return (Criteria) this;
        }

        public Criteria andSettleCcyEqualTo(String value) {
            addCriterion("SETTLE_CCY =", value, "settleCcy");
            return (Criteria) this;
        }

        public Criteria andSettleAmtEqualTo(BigDecimal value) {
            addCriterion("SETTLE_AMT =", value, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
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

        public Criteria andDacValueEqualTo(String value) {
            addCriterion("DAC_VALUE =", value, "dacValue");
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

        public Criteria andBindAcctBranchEqualTo(String value) {
            addCriterion("BIND_ACCT_BRANCH =", value, "bindAcctBranch");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
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