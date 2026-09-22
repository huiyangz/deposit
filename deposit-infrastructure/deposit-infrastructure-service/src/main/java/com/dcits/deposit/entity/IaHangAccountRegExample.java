package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class IaHangAccountRegExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public IaHangAccountRegExample() {
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

        public Criteria andHangSeqNoEqualTo(String value) {
            addCriterion("HANG_SEQ_NO =", value, "hangSeqNo");
            return (Criteria) this;
        }

        public Criteria andSubHangSeqNoEqualTo(String value) {
            addCriterion("SUB_HANG_SEQ_NO =", value, "subHangSeqNo");
            return (Criteria) this;
        }

        public Criteria andHangAmtEqualTo(BigDecimal value) {
            addCriterion("HANG_AMT =", value, "hangAmt");
            return (Criteria) this;
        }

        public Criteria andHangBalEqualTo(BigDecimal value) {
            addCriterion("HANG_BAL =", value, "hangBal");
            return (Criteria) this;
        }

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andCcyEqualTo(String value) {
            addCriterion("CCY =", value, "ccy");
            return (Criteria) this;
        }

        public Criteria andHangDealTypeEqualTo(String value) {
            addCriterion("HANG_DEAL_TYPE =", value, "hangDealType");
            return (Criteria) this;
        }

        public Criteria andBaseAcctNoEqualTo(String value) {
            addCriterion("BASE_ACCT_NO =", value, "baseAcctNo");
            return (Criteria) this;
        }

        public Criteria andHangStatusEqualTo(String value) {
            addCriterion("HANG_STATUS =", value, "hangStatus");
            return (Criteria) this;
        }

        public Criteria andHangWriteOffTimeEqualTo(String value) {
            addCriterion("HANG_WRITE_OFF_TIME =", value, "hangWriteOffTime");
            return (Criteria) this;
        }

        public Criteria andHangEndDateEqualTo(Date value) {
            addCriterion("HANG_END_DATE =", value, "hangEndDate");
            return (Criteria) this;
        }

        public Criteria andCrDrIndEqualTo(String value) {
            addCriterion("CR_DR_IND =", value, "crDrInd");
            return (Criteria) this;
        }

        public Criteria andTranBranchEqualTo(String value) {
            addCriterion("TRAN_BRANCH =", value, "tranBranch");
            return (Criteria) this;
        }

        public Criteria andTranDateEqualTo(Date value) {
            addCriterion("TRAN_DATE =", value, "tranDate");
            return (Criteria) this;
        }

        public Criteria andNarrativeEqualTo(String value) {
            addCriterion("NARRATIVE =", value, "narrative");
            return (Criteria) this;
        }

        public Criteria andHangReasonEqualTo(String value) {
            addCriterion("HANG_REASON =", value, "hangReason");
            return (Criteria) this;
        }

        public Criteria andOthBaseAcctNoEqualTo(String value) {
            addCriterion("OTH_BASE_ACCT_NO =", value, "othBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andOthAcctNameEqualTo(String value) {
            addCriterion("OTH_ACCT_NAME =", value, "othAcctName");
            return (Criteria) this;
        }

        public Criteria andOthBranchEqualTo(String value) {
            addCriterion("OTH_BRANCH =", value, "othBranch");
            return (Criteria) this;
        }

        public Criteria andOthBankFlagEqualTo(String value) {
            addCriterion("OTH_BANK_FLAG =", value, "othBankFlag");
            return (Criteria) this;
        }

        public Criteria andReferenceEqualTo(String value) {
            addCriterion("REFERENCE =", value, "reference");
            return (Criteria) this;
        }

        public Criteria andOthRealBankNameEqualTo(String value) {
            addCriterion("OTH_REAL_BANK_NAME =", value, "othRealBankName");
            return (Criteria) this;
        }

        public Criteria andOthRealBaseAcctNoEqualTo(String value) {
            addCriterion("OTH_REAL_BASE_ACCT_NO =", value, "othRealBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andOthRealProdTypeEqualTo(String value) {
            addCriterion("OTH_REAL_PROD_TYPE =", value, "othRealProdType");
            return (Criteria) this;
        }

        public Criteria andOthRealDocumentTypeEqualTo(String value) {
            addCriterion("OTH_REAL_DOCUMENT_TYPE =", value, "othRealDocumentType");
            return (Criteria) this;
        }

        public Criteria andOthRealDocumentIdEqualTo(String value) {
            addCriterion("OTH_REAL_DOCUMENT_ID =", value, "othRealDocumentId");
            return (Criteria) this;
        }

        public Criteria andOthRealBankCodeEqualTo(String value) {
            addCriterion("OTH_REAL_BANK_CODE =", value, "othRealBankCode");
            return (Criteria) this;
        }

        public Criteria andOthRealTranNameEqualTo(String value) {
            addCriterion("OTH_REAL_TRAN_NAME =", value, "othRealTranName");
            return (Criteria) this;
        }

        public Criteria andOthRealTranAddrEqualTo(String value) {
            addCriterion("OTH_REAL_TRAN_ADDR =", value, "othRealTranAddr");
            return (Criteria) this;
        }

        public Criteria andOthRealBranchRegionCodeEqualTo(String value) {
            addCriterion("OTH_REAL_BRANCH_REGION_CODE =", value, "othRealBranchRegionCode");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdEqualTo(String value) {
            addCriterion("AUTH_USER_ID =", value, "authUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("COMPANY =", value, "company");
            return (Criteria) this;
        }

        public Criteria andLastChangeUserIdEqualTo(String value) {
            addCriterion("LAST_CHANGE_USER_ID =", value, "lastChangeUserId");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeEqualTo(String value) {
            addCriterion("LAST_CHANGE_TIME =", value, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andTranTimestampEqualTo(String value) {
            addCriterion("TRAN_TIMESTAMP =", value, "tranTimestamp");
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