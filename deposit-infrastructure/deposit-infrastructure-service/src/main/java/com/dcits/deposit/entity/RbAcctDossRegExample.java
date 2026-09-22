package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbAcctDossRegExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbAcctDossRegExample() {
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

        public Criteria andDossOperateTypeEqualTo(String value) {
            addCriterion("DOSS_OPERATE_TYPE =", value, "dossOperateType");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("BATCH_NO =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andHandFlagEqualTo(String value) {
            addCriterion("HAND_FLAG =", value, "handFlag");
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

        public Criteria andIndividualFlagEqualTo(String value) {
            addCriterion("INDIVIDUAL_FLAG =", value, "individualFlag");
            return (Criteria) this;
        }

        public Criteria andAmtTypeEqualTo(String value) {
            addCriterion("AMT_TYPE =", value, "amtType");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("BALANCE =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andIntAmtEqualTo(BigDecimal value) {
            addCriterion("INT_AMT =", value, "intAmt");
            return (Criteria) this;
        }

        public Criteria andPorIntTotEqualTo(BigDecimal value) {
            addCriterion("POR_INT_TOT =", value, "porIntTot");
            return (Criteria) this;
        }

        public Criteria andTranAmtEqualTo(BigDecimal value) {
            addCriterion("TRAN_AMT =", value, "tranAmt");
            return (Criteria) this;
        }

        public Criteria andRecordAmtEqualTo(BigDecimal value) {
            addCriterion("RECORD_AMT =", value, "recordAmt");
            return (Criteria) this;
        }

        public Criteria andTaxScEqualTo(BigDecimal value) {
            addCriterion("TAX_SC =", value, "taxSc");
            return (Criteria) this;
        }

        public Criteria andDossStatusEqualTo(String value) {
            addCriterion("DOSS_STATUS =", value, "dossStatus");
            return (Criteria) this;
        }

        public Criteria andPrevDossStatusEqualTo(String value) {
            addCriterion("PREV_DOSS_STATUS =", value, "prevDossStatus");
            return (Criteria) this;
        }

        public Criteria andDossDateEqualTo(Date value) {
            addCriterion("DOSS_DATE =", value, "dossDate");
            return (Criteria) this;
        }

        public Criteria andDossBranchEqualTo(String value) {
            addCriterion("DOSS_BRANCH =", value, "dossBranch");
            return (Criteria) this;
        }

        public Criteria andDossUserIdEqualTo(String value) {
            addCriterion("DOSS_USER_ID =", value, "dossUserId");
            return (Criteria) this;
        }

        public Criteria andTodossReasonEqualTo(String value) {
            addCriterion("TODOSS_REASON =", value, "todossReason");
            return (Criteria) this;
        }

        public Criteria andActiveDateEqualTo(Date value) {
            addCriterion("ACTIVE_DATE =", value, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveBranchEqualTo(String value) {
            addCriterion("ACTIVE_BRANCH =", value, "activeBranch");
            return (Criteria) this;
        }

        public Criteria andActiveUserIdEqualTo(String value) {
            addCriterion("ACTIVE_USER_ID =", value, "activeUserId");
            return (Criteria) this;
        }

        public Criteria andOutBusiDateEqualTo(Date value) {
            addCriterion("OUT_BUSI_DATE =", value, "outBusiDate");
            return (Criteria) this;
        }

        public Criteria andOutBusiUserIdEqualTo(String value) {
            addCriterion("OUT_BUSI_USER_ID =", value, "outBusiUserId");
            return (Criteria) this;
        }

        public Criteria andWithdrawalDateEqualTo(Date value) {
            addCriterion("WITHDRAWAL_DATE =", value, "withdrawalDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawalBranchEqualTo(String value) {
            addCriterion("WITHDRAWAL_BRANCH =", value, "withdrawalBranch");
            return (Criteria) this;
        }

        public Criteria andWithdrawalUserIdEqualTo(String value) {
            addCriterion("WITHDRAWAL_USER_ID =", value, "withdrawalUserId");
            return (Criteria) this;
        }

        public Criteria andWithdrawalReasonEqualTo(String value) {
            addCriterion("WITHDRAWAL_REASON =", value, "withdrawalReason");
            return (Criteria) this;
        }

        public Criteria andToBaseAcctNoEqualTo(String value) {
            addCriterion("TO_BASE_ACCT_NO =", value, "toBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andToCcyEqualTo(String value) {
            addCriterion("TO_CCY =", value, "toCcy");
            return (Criteria) this;
        }

        public Criteria andToAcctSeqNoEqualTo(String value) {
            addCriterion("TO_ACCT_SEQ_NO =", value, "toAcctSeqNo");
            return (Criteria) this;
        }

        public Criteria andToAcctNameEqualTo(String value) {
            addCriterion("TO_ACCT_NAME =", value, "toAcctName");
            return (Criteria) this;
        }

        public Criteria andToProdTypeEqualTo(String value) {
            addCriterion("TO_PROD_TYPE =", value, "toProdType");
            return (Criteria) this;
        }

        public Criteria andToAcctTypeEqualTo(String value) {
            addCriterion("TO_ACCT_TYPE =", value, "toAcctType");
            return (Criteria) this;
        }

        public Criteria andToBankIndEqualTo(String value) {
            addCriterion("TO_BANK_IND =", value, "toBankInd");
            return (Criteria) this;
        }

        public Criteria andResSeqNoEqualTo(String value) {
            addCriterion("RES_SEQ_NO =", value, "resSeqNo");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andReferenceEqualTo(String value) {
            addCriterion("REFERENCE =", value, "reference");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdEqualTo(String value) {
            addCriterion("AUTH_USER_ID =", value, "authUserId");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(String value) {
            addCriterion("SOURCE_TYPE =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andBranchEqualTo(String value) {
            addCriterion("BRANCH =", value, "branch");
            return (Criteria) this;
        }

        public Criteria andTranDateEqualTo(Date value) {
            addCriterion("TRAN_DATE =", value, "tranDate");
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