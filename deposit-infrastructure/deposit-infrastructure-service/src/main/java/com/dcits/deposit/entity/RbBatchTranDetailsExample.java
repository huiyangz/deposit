package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbBatchTranDetailsExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbBatchTranDetailsExample() {
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

        public Criteria andBatchSeqNoEqualTo(String value) {
            addCriterion("BATCH_SEQ_NO =", value, "batchSeqNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("BATCH_NO =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoEqualTo(String value) {
            addCriterion("SEQ_NO =", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andJobRunIdEqualTo(String value) {
            addCriterion("JOB_RUN_ID =", value, "jobRunId");
            return (Criteria) this;
        }

        public Criteria andChannelSeqNoEqualTo(String value) {
            addCriterion("CHANNEL_SEQ_NO =", value, "channelSeqNo");
            return (Criteria) this;
        }

        public Criteria andReferenceEqualTo(String value) {
            addCriterion("REFERENCE =", value, "reference");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(String value) {
            addCriterion("SOURCE_TYPE =", value, "sourceType");
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

        public Criteria andAcctBranchEqualTo(String value) {
            addCriterion("ACCT_BRANCH =", value, "acctBranch");
            return (Criteria) this;
        }

        public Criteria andClientTypeEqualTo(String value) {
            addCriterion("CLIENT_TYPE =", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andAcctDescEqualTo(String value) {
            addCriterion("ACCT_DESC =", value, "acctDesc");
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

        public Criteria andSettlementDateEqualTo(Date value) {
            addCriterion("SETTLEMENT_DATE =", value, "settlementDate");
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

        public Criteria andChannelEqualTo(String value) {
            addCriterion("CHANNEL =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andTranTypeEqualTo(String value) {
            addCriterion("TRAN_TYPE =", value, "tranType");
            return (Criteria) this;
        }

        public Criteria andTranAmtEqualTo(BigDecimal value) {
            addCriterion("TRAN_AMT =", value, "tranAmt");
            return (Criteria) this;
        }

        public Criteria andCcyEqualTo(String value) {
            addCriterion("CCY =", value, "ccy");
            return (Criteria) this;
        }

        public Criteria andServChargeEqualTo(String value) {
            addCriterion("SERV_CHARGE =", value, "servCharge");
            return (Criteria) this;
        }

        public Criteria andTranDescEqualTo(String value) {
            addCriterion("TRAN_DESC =", value, "tranDesc");
            return (Criteria) this;
        }

        public Criteria andTranNoteEqualTo(String value) {
            addCriterion("TRAN_NOTE =", value, "tranNote");
            return (Criteria) this;
        }

        public Criteria andGlCodeEqualTo(String value) {
            addCriterion("GL_CODE =", value, "glCode");
            return (Criteria) this;
        }

        public Criteria andFhSeqNoEqualTo(String value) {
            addCriterion("FH_SEQ_NO =", value, "fhSeqNo");
            return (Criteria) this;
        }

        public Criteria andNarrativeEqualTo(String value) {
            addCriterion("NARRATIVE =", value, "narrative");
            return (Criteria) this;
        }

        public Criteria andOthTranTypeEqualTo(String value) {
            addCriterion("OTH_TRAN_TYPE =", value, "othTranType");
            return (Criteria) this;
        }

        public Criteria andOthReferenceEqualTo(String value) {
            addCriterion("OTH_REFERENCE =", value, "othReference");
            return (Criteria) this;
        }

        public Criteria andOthSeqNoEqualTo(String value) {
            addCriterion("OTH_SEQ_NO =", value, "othSeqNo");
            return (Criteria) this;
        }

        public Criteria andOthGlCodeEqualTo(String value) {
            addCriterion("OTH_GL_CODE =", value, "othGlCode");
            return (Criteria) this;
        }

        public Criteria andOthTranNameEqualTo(String value) {
            addCriterion("OTH_TRAN_NAME =", value, "othTranName");
            return (Criteria) this;
        }

        public Criteria andOthBranchEqualTo(String value) {
            addCriterion("OTH_BRANCH =", value, "othBranch");
            return (Criteria) this;
        }

        public Criteria andOthBaseAcctNoEqualTo(String value) {
            addCriterion("OTH_BASE_ACCT_NO =", value, "othBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andOthProdTypeEqualTo(String value) {
            addCriterion("OTH_PROD_TYPE =", value, "othProdType");
            return (Criteria) this;
        }

        public Criteria andOthAcctCcyEqualTo(String value) {
            addCriterion("OTH_ACCT_CCY =", value, "othAcctCcy");
            return (Criteria) this;
        }

        public Criteria andOthAcctSeqNoEqualTo(String value) {
            addCriterion("OTH_ACCT_SEQ_NO =", value, "othAcctSeqNo");
            return (Criteria) this;
        }

        public Criteria andOthAcctDescEqualTo(String value) {
            addCriterion("OTH_ACCT_DESC =", value, "othAcctDesc");
            return (Criteria) this;
        }

        public Criteria andOthBankCodeEqualTo(String value) {
            addCriterion("OTH_BANK_CODE =", value, "othBankCode");
            return (Criteria) this;
        }

        public Criteria andOthBankNameEqualTo(String value) {
            addCriterion("OTH_BANK_NAME =", value, "othBankName");
            return (Criteria) this;
        }

        public Criteria andBatchStatusEqualTo(String value) {
            addCriterion("BATCH_STATUS =", value, "batchStatus");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("REMARK1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark2EqualTo(String value) {
            addCriterion("REMARK2 =", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark3EqualTo(String value) {
            addCriterion("REMARK3 =", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark4EqualTo(String value) {
            addCriterion("REMARK4 =", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark5EqualTo(String value) {
            addCriterion("REMARK5 =", value, "remark5");
            return (Criteria) this;
        }

        public Criteria andRetMsgEqualTo(String value) {
            addCriterion("RET_MSG =", value, "retMsg");
            return (Criteria) this;
        }

        public Criteria andErrorCodeEqualTo(String value) {
            addCriterion("ERROR_CODE =", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorDescEqualTo(String value) {
            addCriterion("ERROR_DESC =", value, "errorDesc");
            return (Criteria) this;
        }

        public Criteria andTranTimestampEqualTo(String value) {
            addCriterion("TRAN_TIMESTAMP =", value, "tranTimestamp");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("COMPANY =", value, "company");
            return (Criteria) this;
        }

        public Criteria andNarrativeCodeEqualTo(String value) {
            addCriterion("NARRATIVE_CODE =", value, "narrativeCode");
            return (Criteria) this;
        }

        public Criteria andOthRealBankNameEqualTo(String value) {
            addCriterion("OTH_REAL_BANK_NAME =", value, "othRealBankName");
            return (Criteria) this;
        }

        public Criteria andOthRealBankCodeEqualTo(String value) {
            addCriterion("OTH_REAL_BANK_CODE =", value, "othRealBankCode");
            return (Criteria) this;
        }

        public Criteria andOthRealBaseAcctNoEqualTo(String value) {
            addCriterion("OTH_REAL_BASE_ACCT_NO =", value, "othRealBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andOthRealDocumentIdEqualTo(String value) {
            addCriterion("OTH_REAL_DOCUMENT_ID =", value, "othRealDocumentId");
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

        public Criteria andOthRealTranAddrEqualTo(String value) {
            addCriterion("OTH_REAL_TRAN_ADDR =", value, "othRealTranAddr");
            return (Criteria) this;
        }

        public Criteria andOthRealTranNameEqualTo(String value) {
            addCriterion("OTH_REAL_TRAN_NAME =", value, "othRealTranName");
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

        public Criteria andTranStatusEqualTo(String value) {
            addCriterion("TRAN_STATUS =", value, "tranStatus");
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