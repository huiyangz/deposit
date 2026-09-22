package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbDelayTranHistExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbDelayTranHistExample() {
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

        public Criteria andChannelSeqNoEqualTo(String value) {
            addCriterion("CHANNEL_SEQ_NO =", value, "channelSeqNo");
            return (Criteria) this;
        }

        public Criteria andResSeqNoEqualTo(String value) {
            addCriterion("RES_SEQ_NO =", value, "resSeqNo");
            return (Criteria) this;
        }

        public Criteria andInternalKeyEqualTo(Integer value) {
            addCriterion("INTERNAL_KEY =", value, "internalKey");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("CARD_NO =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andBaseAcctNoEqualTo(String value) {
            addCriterion("BASE_ACCT_NO =", value, "baseAcctNo");
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

        public Criteria andProdTypeEqualTo(String value) {
            addCriterion("PROD_TYPE =", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andClientNameEqualTo(String value) {
            addCriterion("CLIENT_NAME =", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andOthInternalKeyEqualTo(Integer value) {
            addCriterion("OTH_INTERNAL_KEY =", value, "othInternalKey");
            return (Criteria) this;
        }

        public Criteria andOthCardNoEqualTo(String value) {
            addCriterion("OTH_CARD_NO =", value, "othCardNo");
            return (Criteria) this;
        }

        public Criteria andOthBaseAcctNoEqualTo(String value) {
            addCriterion("OTH_BASE_ACCT_NO =", value, "othBaseAcctNo");
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

        public Criteria andOthProdTypeEqualTo(String value) {
            addCriterion("OTH_PROD_TYPE =", value, "othProdType");
            return (Criteria) this;
        }

        public Criteria andOthAcctNameEqualTo(String value) {
            addCriterion("OTH_ACCT_NAME =", value, "othAcctName");
            return (Criteria) this;
        }

        public Criteria andOthAcctDescEqualTo(String value) {
            addCriterion("OTH_ACCT_DESC =", value, "othAcctDesc");
            return (Criteria) this;
        }

        public Criteria andSettleCardFlagEqualTo(String value) {
            addCriterion("SETTLE_CARD_FLAG =", value, "settleCardFlag");
            return (Criteria) this;
        }

        public Criteria andCcyEqualTo(String value) {
            addCriterion("CCY =", value, "ccy");
            return (Criteria) this;
        }

        public Criteria andTranMethodEqualTo(String value) {
            addCriterion("TRAN_METHOD =", value, "tranMethod");
            return (Criteria) this;
        }

        public Criteria andSignTimestampEqualTo(String value) {
            addCriterion("SIGN_TIMESTAMP =", value, "signTimestamp");
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

        public Criteria andTranDateEqualTo(Date value) {
            addCriterion("TRAN_DATE =", value, "tranDate");
            return (Criteria) this;
        }

        public Criteria andTranBranchEqualTo(String value) {
            addCriterion("TRAN_BRANCH =", value, "tranBranch");
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

        public Criteria andArrivalStatusEqualTo(String value) {
            addCriterion("ARRIVAL_STATUS =", value, "arrivalStatus");
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

        public Criteria andExchangeTranCodeEqualTo(String value) {
            addCriterion("EXCHANGE_TRAN_CODE =", value, "exchangeTranCode");
            return (Criteria) this;
        }

        public Criteria andExchangeTranCodetEqualTo(String value) {
            addCriterion("EXCHANGE_TRAN_CODET =", value, "exchangeTranCodet");
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

        public Criteria andCashItemEqualTo(String value) {
            addCriterion("CASH_ITEM =", value, "cashItem");
            return (Criteria) this;
        }

        public Criteria andNarrativeEqualTo(String value) {
            addCriterion("NARRATIVE =", value, "narrative");
            return (Criteria) this;
        }

        public Criteria andCommissionClientNameEqualTo(String value) {
            addCriterion("COMMISSION_CLIENT_NAME =", value, "commissionClientName");
            return (Criteria) this;
        }

        public Criteria andCommissionClientTelEqualTo(String value) {
            addCriterion("COMMISSION_CLIENT_TEL =", value, "commissionClientTel");
            return (Criteria) this;
        }

        public Criteria andPayUnitEqualTo(String value) {
            addCriterion("PAY_UNIT =", value, "payUnit");
            return (Criteria) this;
        }

        public Criteria andCancelReasonEqualTo(String value) {
            addCriterion("CANCEL_REASON =", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andTerminalIdEqualTo(String value) {
            addCriterion("TERMINAL_ID =", value, "terminalId");
            return (Criteria) this;
        }

        public Criteria andTrack2EqualTo(String value) {
            addCriterion("TRACK2 =", value, "track2");
            return (Criteria) this;
        }

        public Criteria andTrack3EqualTo(String value) {
            addCriterion("TRACK3 =", value, "track3");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdEqualTo(String value) {
            addCriterion("AUTH_USER_ID =", value, "authUserId");
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

        public Criteria andSubSeqNoEqualTo(String value) {
            addCriterion("SUB_SEQ_NO =", value, "subSeqNo");
            return (Criteria) this;
        }

        public Criteria andInnerBaseAcctNoEqualTo(String value) {
            addCriterion("INNER_BASE_ACCT_NO =", value, "innerBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andInnerProdTypeEqualTo(String value) {
            addCriterion("INNER_PROD_TYPE =", value, "innerProdType");
            return (Criteria) this;
        }

        public Criteria andInnerAcctSeqNoEqualTo(String value) {
            addCriterion("INNER_ACCT_SEQ_NO =", value, "innerAcctSeqNo");
            return (Criteria) this;
        }

        public Criteria andInnerAcctCcyEqualTo(String value) {
            addCriterion("INNER_ACCT_CCY =", value, "innerAcctCcy");
            return (Criteria) this;
        }

        public Criteria andInnerInternalKeyEqualTo(Integer value) {
            addCriterion("INNER_INTERNAL_KEY =", value, "innerInternalKey");
            return (Criteria) this;
        }

        public Criteria andInnerAcctNameEqualTo(String value) {
            addCriterion("INNER_ACCT_NAME =", value, "innerAcctName");
            return (Criteria) this;
        }

        public Criteria andInnerClientNoEqualTo(String value) {
            addCriterion("INNER_CLIENT_NO =", value, "innerClientNo");
            return (Criteria) this;
        }

        public Criteria andHangSeqNoEqualTo(String value) {
            addCriterion("HANG_SEQ_NO =", value, "hangSeqNo");
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

        public Criteria andOthClientNoEqualTo(String value) {
            addCriterion("OTH_CLIENT_NO =", value, "othClientNo");
            return (Criteria) this;
        }

        public Criteria andBankInOutEqualTo(String value) {
            addCriterion("BANK_IN_OUT =", value, "bankInOut");
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