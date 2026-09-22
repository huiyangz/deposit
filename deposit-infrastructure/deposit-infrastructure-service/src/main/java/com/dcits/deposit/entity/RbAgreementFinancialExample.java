package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbAgreementFinancialExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbAgreementFinancialExample() {
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

        public Criteria andAgreementTypeEqualTo(String value) {
            addCriterion("AGREEMENT_TYPE =", value, "agreementType");
            return (Criteria) this;
        }

        public Criteria andFinProdTypeEqualTo(String value) {
            addCriterion("FIN_PROD_TYPE =", value, "finProdType");
            return (Criteria) this;
        }

        public Criteria andFinProdDescEqualTo(String value) {
            addCriterion("FIN_PROD_DESC =", value, "finProdDesc");
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

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
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

        public Criteria andFinFixedAmtEqualTo(BigDecimal value) {
            addCriterion("FIN_FIXED_AMT =", value, "finFixedAmt");
            return (Criteria) this;
        }

        public Criteria andRemainAmtEqualTo(BigDecimal value) {
            addCriterion("REMAIN_AMT =", value, "remainAmt");
            return (Criteria) this;
        }

        public Criteria andIntMinAmtEqualTo(BigDecimal value) {
            addCriterion("INT_MIN_AMT =", value, "intMinAmt");
            return (Criteria) this;
        }

        public Criteria andTransferFreqEqualTo(String value) {
            addCriterion("TRANSFER_FREQ =", value, "transferFreq");
            return (Criteria) this;
        }

        public Criteria andTransferStartDateEqualTo(Date value) {
            addCriterion("TRANSFER_START_DATE =", value, "transferStartDate");
            return (Criteria) this;
        }

        public Criteria andTransferFreqTypeEqualTo(String value) {
            addCriterion("TRANSFER_FREQ_TYPE =", value, "transferFreqType");
            return (Criteria) this;
        }

        public Criteria andTransferEndDateEqualTo(Date value) {
            addCriterion("TRANSFER_END_DATE =", value, "transferEndDate");
            return (Criteria) this;
        }

        public Criteria andTransferDayEqualTo(String value) {
            addCriterion("TRANSFER_DAY =", value, "transferDay");
            return (Criteria) this;
        }

        public Criteria andAgreementStatusEqualTo(String value) {
            addCriterion("AGREEMENT_STATUS =", value, "agreementStatus");
            return (Criteria) this;
        }

        public Criteria andNextTransferDateEqualTo(Date value) {
            addCriterion("NEXT_TRANSFER_DATE =", value, "nextTransferDate");
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

        public Criteria andTdaAcctSeqNoEqualTo(String value) {
            addCriterion("TDA_ACCT_SEQ_NO =", value, "tdaAcctSeqNo");
            return (Criteria) this;
        }

        public Criteria andTdaBaseAcctNoEqualTo(String value) {
            addCriterion("TDA_BASE_ACCT_NO =", value, "tdaBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andTdaAcctProdTypeEqualTo(String value) {
            addCriterion("TDA_ACCT_PROD_TYPE =", value, "tdaAcctProdType");
            return (Criteria) this;
        }

        public Criteria andTdaAcctCcyEqualTo(String value) {
            addCriterion("TDA_ACCT_CCY =", value, "tdaAcctCcy");
            return (Criteria) this;
        }

        public Criteria andFinancialAmountEqualTo(BigDecimal value) {
            addCriterion("FINANCIAL_AMOUNT =", value, "financialAmount");
            return (Criteria) this;
        }

        public Criteria andLastChangeDateEqualTo(Date value) {
            addCriterion("LAST_CHANGE_DATE =", value, "lastChangeDate");
            return (Criteria) this;
        }

        public Criteria andFailureTotalTimesEqualTo(Integer value) {
            addCriterion("FAILURE_TOTAL_TIMES =", value, "failureTotalTimes");
            return (Criteria) this;
        }

        public Criteria andFailureTimesEqualTo(Integer value) {
            addCriterion("FAILURE_TIMES =", value, "failureTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessTimesEqualTo(Integer value) {
            addCriterion("SUCCESS_TIMES =", value, "successTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessTotalTimesEqualTo(Integer value) {
            addCriterion("SUCCESS_TOTAL_TIMES =", value, "successTotalTimes");
            return (Criteria) this;
        }

        public Criteria andAutoExtendEqualTo(String value) {
            addCriterion("AUTO_EXTEND =", value, "autoExtend");
            return (Criteria) this;
        }

        public Criteria andLastTransferDateEqualTo(Date value) {
            addCriterion("LAST_TRANSFER_DATE =", value, "lastTransferDate");
            return (Criteria) this;
        }

        public Criteria andSignBranchEqualTo(String value) {
            addCriterion("SIGN_BRANCH =", value, "signBranch");
            return (Criteria) this;
        }

        public Criteria andSignUserIdEqualTo(String value) {
            addCriterion("SIGN_USER_ID =", value, "signUserId");
            return (Criteria) this;
        }

        public Criteria andOutSignUserIdEqualTo(String value) {
            addCriterion("OUT_SIGN_USER_ID =", value, "outSignUserId");
            return (Criteria) this;
        }

        public Criteria andOutSignBranchEqualTo(String value) {
            addCriterion("OUT_SIGN_BRANCH =", value, "outSignBranch");
            return (Criteria) this;
        }

        public Criteria andAcctExecEqualTo(String value) {
            addCriterion("ACCT_EXEC =", value, "acctExec");
            return (Criteria) this;
        }

        public Criteria andAcctExecNameEqualTo(String value) {
            addCriterion("ACCT_EXEC_NAME =", value, "acctExecName");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("COMPANY =", value, "company");
            return (Criteria) this;
        }

        public Criteria andTranTimestampEqualTo(String value) {
            addCriterion("TRAN_TIMESTAMP =", value, "tranTimestamp");
            return (Criteria) this;
        }

        public Criteria andAutoSettleFlagEqualTo(String value) {
            addCriterion("AUTO_SETTLE_FLAG =", value, "autoSettleFlag");
            return (Criteria) this;
        }

        public Criteria andDepositNatureEqualTo(String value) {
            addCriterion("DEPOSIT_NATURE =", value, "depositNature");
            return (Criteria) this;
        }

        public Criteria andFailureReasonEqualTo(String value) {
            addCriterion("FAILURE_REASON =", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andUnsignOperateDateEqualTo(Date value) {
            addCriterion("UNSIGN_OPERATE_DATE =", value, "unsignOperateDate");
            return (Criteria) this;
        }

        public Criteria andAmortizeTimeTypeEqualTo(String value) {
            addCriterion("AMORTIZE_TIME_TYPE =", value, "amortizeTimeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeEqualTo(String value) {
            addCriterion("FEE_TYPE =", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andIntBasisRateEqualTo(BigDecimal value) {
            addCriterion("INT_BASIS_RATE =", value, "intBasisRate");
            return (Criteria) this;
        }

        public Criteria andPastDueRateEqualTo(BigDecimal value) {
            addCriterion("PAST_DUE_RATE =", value, "pastDueRate");
            return (Criteria) this;
        }

        public Criteria andRealRateEqualTo(BigDecimal value) {
            addCriterion("REAL_RATE =", value, "realRate");
            return (Criteria) this;
        }

        public Criteria andLastTransferReferenceEqualTo(String value) {
            addCriterion("LAST_TRANSFER_REFERENCE =", value, "lastTransferReference");
            return (Criteria) this;
        }

        public Criteria andSignReferenceEqualTo(String value) {
            addCriterion("SIGN_REFERENCE =", value, "signReference");
            return (Criteria) this;
        }

        public Criteria andUnsignReferenceEqualTo(String value) {
            addCriterion("UNSIGN_REFERENCE =", value, "unsignReference");
            return (Criteria) this;
        }

        public Criteria andOdModeEqualTo(String value) {
            addCriterion("OD_MODE =", value, "odMode");
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