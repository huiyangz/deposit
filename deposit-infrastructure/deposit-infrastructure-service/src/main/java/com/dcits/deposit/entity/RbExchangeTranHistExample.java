package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbExchangeTranHistExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbExchangeTranHistExample() {
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

        public Criteria andCashSeqNoEqualTo(String value) {
            addCriterion("CASH_SEQ_NO =", value, "cashSeqNo");
            return (Criteria) this;
        }

        public Criteria andTaeSubSeqNoEqualTo(String value) {
            addCriterion("TAE_SUB_SEQ_NO =", value, "taeSubSeqNo");
            return (Criteria) this;
        }

        public Criteria andExchangeSeqNoEqualTo(String value) {
            addCriterion("EXCHANGE_SEQ_NO =", value, "exchangeSeqNo");
            return (Criteria) this;
        }

        public Criteria andDepositInternalKeyEqualTo(Integer value) {
            addCriterion("DEPOSIT_INTERNAL_KEY =", value, "depositInternalKey");
            return (Criteria) this;
        }

        public Criteria andDepositBaseAcctNoEqualTo(String value) {
            addCriterion("DEPOSIT_BASE_ACCT_NO =", value, "depositBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andDepositAcctSeqNoEqualTo(String value) {
            addCriterion("DEPOSIT_ACCT_SEQ_NO =", value, "depositAcctSeqNo");
            return (Criteria) this;
        }

        public Criteria andDepositProdTypeEqualTo(String value) {
            addCriterion("DEPOSIT_PROD_TYPE =", value, "depositProdType");
            return (Criteria) this;
        }

        public Criteria andDepositBalanceTypeEqualTo(String value) {
            addCriterion("DEPOSIT_BALANCE_TYPE =", value, "depositBalanceType");
            return (Criteria) this;
        }

        public Criteria andDepositSeqNoEqualTo(String value) {
            addCriterion("DEPOSIT_SEQ_NO =", value, "depositSeqNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawInternalKeyEqualTo(Integer value) {
            addCriterion("WITHDRAW_INTERNAL_KEY =", value, "withdrawInternalKey");
            return (Criteria) this;
        }

        public Criteria andWithdrawBaseAcctNoEqualTo(String value) {
            addCriterion("WITHDRAW_BASE_ACCT_NO =", value, "withdrawBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawAcctCcyEqualTo(String value) {
            addCriterion("WITHDRAW_ACCT_CCY =", value, "withdrawAcctCcy");
            return (Criteria) this;
        }

        public Criteria andWithdrawAcctSeqNoEqualTo(String value) {
            addCriterion("WITHDRAW_ACCT_SEQ_NO =", value, "withdrawAcctSeqNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawProdTypeEqualTo(String value) {
            addCriterion("WITHDRAW_PROD_TYPE =", value, "withdrawProdType");
            return (Criteria) this;
        }

        public Criteria andWithdrawBalanceTypeEqualTo(String value) {
            addCriterion("WITHDRAW_BALANCE_TYPE =", value, "withdrawBalanceType");
            return (Criteria) this;
        }

        public Criteria andWithdrawSeqNoEqualTo(String value) {
            addCriterion("WITHDRAW_SEQ_NO =", value, "withdrawSeqNo");
            return (Criteria) this;
        }

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andTranTypeEqualTo(String value) {
            addCriterion("TRAN_TYPE =", value, "tranType");
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

        public Criteria andReversalDateEqualTo(Date value) {
            addCriterion("REVERSAL_DATE =", value, "reversalDate");
            return (Criteria) this;
        }

        public Criteria andReversalTranTypeEqualTo(String value) {
            addCriterion("REVERSAL_TRAN_TYPE =", value, "reversalTranType");
            return (Criteria) this;
        }

        public Criteria andExchangeTranStatusEqualTo(String value) {
            addCriterion("EXCHANGE_TRAN_STATUS =", value, "exchangeTranStatus");
            return (Criteria) this;
        }

        public Criteria andSellBuyIndEqualTo(String value) {
            addCriterion("SELL_BUY_IND =", value, "sellBuyInd");
            return (Criteria) this;
        }

        public Criteria andQuoteTypeEqualTo(String value) {
            addCriterion("QUOTE_TYPE =", value, "quoteType");
            return (Criteria) this;
        }

        public Criteria andRateTypeEqualTo(String value) {
            addCriterion("RATE_TYPE =", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andBuyAmountEqualTo(BigDecimal value) {
            addCriterion("BUY_AMOUNT =", value, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyCcyEqualTo(String value) {
            addCriterion("BUY_CCY =", value, "buyCcy");
            return (Criteria) this;
        }

        public Criteria andBuyRateEqualTo(BigDecimal value) {
            addCriterion("BUY_RATE =", value, "buyRate");
            return (Criteria) this;
        }

        public Criteria andSellCcyEqualTo(String value) {
            addCriterion("SELL_CCY =", value, "sellCcy");
            return (Criteria) this;
        }

        public Criteria andSellAmountEqualTo(BigDecimal value) {
            addCriterion("SELL_AMOUNT =", value, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellRateEqualTo(BigDecimal value) {
            addCriterion("SELL_RATE =", value, "sellRate");
            return (Criteria) this;
        }

        public Criteria andExchRateEqualTo(BigDecimal value) {
            addCriterion("EXCH_RATE =", value, "exchRate");
            return (Criteria) this;
        }

        public Criteria andFloatRateEqualTo(BigDecimal value) {
            addCriterion("FLOAT_RATE =", value, "floatRate");
            return (Criteria) this;
        }

        public Criteria andBaseQuoteTypeEqualTo(String value) {
            addCriterion("BASE_QUOTE_TYPE =", value, "baseQuoteType");
            return (Criteria) this;
        }

        public Criteria andBaseRateTypeEqualTo(String value) {
            addCriterion("BASE_RATE_TYPE =", value, "baseRateType");
            return (Criteria) this;
        }

        public Criteria andBaseRateEqualTo(BigDecimal value) {
            addCriterion("BASE_RATE =", value, "baseRate");
            return (Criteria) this;
        }

        public Criteria andBaseEquivAmtEqualTo(BigDecimal value) {
            addCriterion("BASE_EQUIV_AMT =", value, "baseEquivAmt");
            return (Criteria) this;
        }

        public Criteria andCrossRateEqualTo(BigDecimal value) {
            addCriterion("CROSS_RATE =", value, "crossRate");
            return (Criteria) this;
        }

        public Criteria andCrossRateAttrEqualTo(String value) {
            addCriterion("CROSS_RATE_ATTR =", value, "crossRateAttr");
            return (Criteria) this;
        }

        public Criteria andUncCrossRateEqualTo(BigDecimal value) {
            addCriterion("UNC_CROSS_RATE =", value, "uncCrossRate");
            return (Criteria) this;
        }

        public Criteria andInnerRateEqualTo(BigDecimal value) {
            addCriterion("INNER_RATE =", value, "innerRate");
            return (Criteria) this;
        }

        public Criteria andChangeBaseEquivAmtEqualTo(BigDecimal value) {
            addCriterion("CHANGE_BASE_EQUIV_AMT =", value, "changeBaseEquivAmt");
            return (Criteria) this;
        }

        public Criteria andChangeCnyAmountEqualTo(BigDecimal value) {
            addCriterion("CHANGE_CNY_AMOUNT =", value, "changeCnyAmount");
            return (Criteria) this;
        }

        public Criteria andChangeRateEqualTo(BigDecimal value) {
            addCriterion("CHANGE_RATE =", value, "changeRate");
            return (Criteria) this;
        }

        public Criteria andChangeBaseQuoteTypeEqualTo(String value) {
            addCriterion("CHANGE_BASE_QUOTE_TYPE =", value, "changeBaseQuoteType");
            return (Criteria) this;
        }

        public Criteria andChangeQuoteTypeEqualTo(String value) {
            addCriterion("CHANGE_QUOTE_TYPE =", value, "changeQuoteType");
            return (Criteria) this;
        }

        public Criteria andChangeRateTypeEqualTo(String value) {
            addCriterion("CHANGE_RATE_TYPE =", value, "changeRateType");
            return (Criteria) this;
        }

        public Criteria andReferenceEqualTo(String value) {
            addCriterion("REFERENCE =", value, "reference");
            return (Criteria) this;
        }

        public Criteria andTraceRefNoEqualTo(String value) {
            addCriterion("TRACE_REF_NO =", value, "traceRefNo");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(String value) {
            addCriterion("SOURCE_TYPE =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andBankSeqNoEqualTo(String value) {
            addCriterion("BANK_SEQ_NO =", value, "bankSeqNo");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andSourceModuleEqualTo(String value) {
            addCriterion("SOURCE_MODULE =", value, "sourceModule");
            return (Criteria) this;
        }

        public Criteria andTerminalIdEqualTo(String value) {
            addCriterion("TERMINAL_ID =", value, "terminalId");
            return (Criteria) this;
        }

        public Criteria andTraceRefCodeEqualTo(String value) {
            addCriterion("TRACE_REF_CODE =", value, "traceRefCode");
            return (Criteria) this;
        }

        public Criteria andApprovalDateEqualTo(Date value) {
            addCriterion("APPROVAL_DATE =", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andValueDateEqualTo(Date value) {
            addCriterion("VALUE_DATE =", value, "valueDate");
            return (Criteria) this;
        }

        public Criteria andApprUserIdEqualTo(String value) {
            addCriterion("APPR_USER_ID =", value, "apprUserId");
            return (Criteria) this;
        }

        public Criteria andApprAuthUserIdEqualTo(String value) {
            addCriterion("APPR_AUTH_USER_ID =", value, "apprAuthUserId");
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

        public Criteria andReversalAuthUserIdEqualTo(String value) {
            addCriterion("REVERSAL_AUTH_USER_ID =", value, "reversalAuthUserId");
            return (Criteria) this;
        }

        public Criteria andReversalUserIdEqualTo(String value) {
            addCriterion("REVERSAL_USER_ID =", value, "reversalUserId");
            return (Criteria) this;
        }

        public Criteria andProfitCenterEqualTo(String value) {
            addCriterion("PROFIT_CENTER =", value, "profitCenter");
            return (Criteria) this;
        }

        public Criteria andFcyCtrlIbuncAmtEqualTo(BigDecimal value) {
            addCriterion("FCY_CTRL_IBUNC_AMT =", value, "fcyCtrlIbuncAmt");
            return (Criteria) this;
        }

        public Criteria andUncStatusEqualTo(String value) {
            addCriterion("UNC_STATUS =", value, "uncStatus");
            return (Criteria) this;
        }

        public Criteria andIbuncReferenceEqualTo(String value) {
            addCriterion("IBUNC_REFERENCE =", value, "ibuncReference");
            return (Criteria) this;
        }

        public Criteria andObuncReferenceEqualTo(String value) {
            addCriterion("OBUNC_REFERENCE =", value, "obuncReference");
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

        public Criteria andBuyUncRateEqualTo(BigDecimal value) {
            addCriterion("BUY_UNC_RATE =", value, "buyUncRate");
            return (Criteria) this;
        }

        public Criteria andCountryLocEqualTo(String value) {
            addCriterion("COUNTRY_LOC =", value, "countryLoc");
            return (Criteria) this;
        }

        public Criteria andCouponRateTypeEqualTo(String value) {
            addCriterion("COUPON_RATE_TYPE =", value, "couponRateType");
            return (Criteria) this;
        }

        public Criteria andEffectDateEqualTo(Date value) {
            addCriterion("EFFECT_DATE =", value, "effectDate");
            return (Criteria) this;
        }

        public Criteria andEffectTimeEqualTo(String value) {
            addCriterion("EFFECT_TIME =", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andFloatPointEqualTo(BigDecimal value) {
            addCriterion("FLOAT_POINT =", value, "floatPoint");
            return (Criteria) this;
        }

        public Criteria andMinAmtFlagEqualTo(String value) {
            addCriterion("MIN_AMT_FLAG =", value, "minAmtFlag");
            return (Criteria) this;
        }

        public Criteria andSellUncRateEqualTo(BigDecimal value) {
            addCriterion("SELL_UNC_RATE =", value, "sellUncRate");
            return (Criteria) this;
        }

        public Criteria andBranchEqualTo(String value) {
            addCriterion("BRANCH =", value, "branch");
            return (Criteria) this;
        }

        public Criteria andDocumentIdEqualTo(String value) {
            addCriterion("DOCUMENT_ID =", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeEqualTo(String value) {
            addCriterion("DOCUMENT_TYPE =", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("AREA_CODE =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andClientNameEqualTo(String value) {
            addCriterion("CLIENT_NAME =", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andIsIndividualEqualTo(String value) {
            addCriterion("IS_INDIVIDUAL =", value, "isIndividual");
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