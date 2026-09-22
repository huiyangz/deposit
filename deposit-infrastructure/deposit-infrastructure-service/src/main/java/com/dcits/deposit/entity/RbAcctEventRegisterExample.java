package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbAcctEventRegisterExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbAcctEventRegisterExample() {
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

        public Criteria andAcctBranchEqualTo(String value) {
            addCriterion("ACCT_BRANCH =", value, "acctBranch");
            return (Criteria) this;
        }

        public Criteria andAcctOpenDateEqualTo(Date value) {
            addCriterion("ACCT_OPEN_DATE =", value, "acctOpenDate");
            return (Criteria) this;
        }

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andClientTypeEqualTo(String value) {
            addCriterion("CLIENT_TYPE =", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andMovtStatusEqualTo(String value) {
            addCriterion("MOVT_STATUS =", value, "movtStatus");
            return (Criteria) this;
        }

        public Criteria andIntClassEqualTo(String value) {
            addCriterion("INT_CLASS =", value, "intClass");
            return (Criteria) this;
        }

        public Criteria andIntTypeEqualTo(String value) {
            addCriterion("INT_TYPE =", value, "intType");
            return (Criteria) this;
        }

        public Criteria andActualRateEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_RATE =", value, "actualRate");
            return (Criteria) this;
        }

        public Criteria andFloatRateEqualTo(BigDecimal value) {
            addCriterion("FLOAT_RATE =", value, "floatRate");
            return (Criteria) this;
        }

        public Criteria andSpreadRateEqualTo(BigDecimal value) {
            addCriterion("SPREAD_RATE =", value, "spreadRate");
            return (Criteria) this;
        }

        public Criteria andRealRateEqualTo(BigDecimal value) {
            addCriterion("REAL_RATE =", value, "realRate");
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

        public Criteria andAcctLevelIntRateEqualTo(BigDecimal value) {
            addCriterion("ACCT_LEVEL_INT_RATE =", value, "acctLevelIntRate");
            return (Criteria) this;
        }

        public Criteria andGrossInterestAmtEqualTo(BigDecimal value) {
            addCriterion("GROSS_INTEREST_AMT =", value, "grossInterestAmt");
            return (Criteria) this;
        }

        public Criteria andCalcIntAmtEqualTo(BigDecimal value) {
            addCriterion("CALC_INT_AMT =", value, "calcIntAmt");
            return (Criteria) this;
        }

        public Criteria andLastCycleDateEqualTo(Date value) {
            addCriterion("LAST_CYCLE_DATE =", value, "lastCycleDate");
            return (Criteria) this;
        }

        public Criteria andIntCapFlagEqualTo(String value) {
            addCriterion("INT_CAP_FLAG =", value, "intCapFlag");
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

        public Criteria andMaturityDateEqualTo(Date value) {
            addCriterion("MATURITY_DATE =", value, "maturityDate");
            return (Criteria) this;
        }

        public Criteria andAmtTypeEqualTo(String value) {
            addCriterion("AMT_TYPE =", value, "amtType");
            return (Criteria) this;
        }

        public Criteria andPrincipalAmtEqualTo(BigDecimal value) {
            addCriterion("PRINCIPAL_AMT =", value, "principalAmt");
            return (Criteria) this;
        }

        public Criteria andTranAmtEqualTo(BigDecimal value) {
            addCriterion("TRAN_AMT =", value, "tranAmt");
            return (Criteria) this;
        }

        public Criteria andDebtIntRateEqualTo(BigDecimal value) {
            addCriterion("DEBT_INT_RATE =", value, "debtIntRate");
            return (Criteria) this;
        }

        public Criteria andNetInterestAmtEqualTo(BigDecimal value) {
            addCriterion("NET_INTEREST_AMT =", value, "netInterestAmt");
            return (Criteria) this;
        }

        public Criteria andCalcDaysEqualTo(Integer value) {
            addCriterion("CALC_DAYS =", value, "calcDays");
            return (Criteria) this;
        }

        public Criteria andTaxRateEqualTo(BigDecimal value) {
            addCriterion("TAX_RATE =", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxTypeEqualTo(String value) {
            addCriterion("TAX_TYPE =", value, "taxType");
            return (Criteria) this;
        }

        public Criteria andTaxAmtEqualTo(BigDecimal value) {
            addCriterion("TAX_AMT =", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andReferenceEqualTo(String value) {
            addCriterion("REFERENCE =", value, "reference");
            return (Criteria) this;
        }

        public Criteria andGlPostedFlagEqualTo(String value) {
            addCriterion("GL_POSTED_FLAG =", value, "glPostedFlag");
            return (Criteria) this;
        }

        public Criteria andReversalDateEqualTo(Date value) {
            addCriterion("REVERSAL_DATE =", value, "reversalDate");
            return (Criteria) this;
        }

        public Criteria andNarrativeEqualTo(String value) {
            addCriterion("NARRATIVE =", value, "narrative");
            return (Criteria) this;
        }

        public Criteria andSourceModuleEqualTo(String value) {
            addCriterion("SOURCE_MODULE =", value, "sourceModule");
            return (Criteria) this;
        }

        public Criteria andTranStatusEqualTo(String value) {
            addCriterion("TRAN_STATUS =", value, "tranStatus");
            return (Criteria) this;
        }

        public Criteria andPrintCntEqualTo(Integer value) {
            addCriterion("PRINT_CNT =", value, "printCnt");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
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

        public Criteria andBusSeqNoEqualTo(String value) {
            addCriterion("BUS_SEQ_NO =", value, "busSeqNo");
            return (Criteria) this;
        }

        public Criteria andCalcBeginDateEqualTo(Date value) {
            addCriterion("CALC_BEGIN_DATE =", value, "calcBeginDate");
            return (Criteria) this;
        }

        public Criteria andMonthBasisEqualTo(String value) {
            addCriterion("MONTH_BASIS =", value, "monthBasis");
            return (Criteria) this;
        }

        public Criteria andYearBasisEqualTo(String value) {
            addCriterion("YEAR_BASIS =", value, "yearBasis");
            return (Criteria) this;
        }

        public Criteria andReaccountCdEqualTo(String value) {
            addCriterion("REACCOUNT_CD =", value, "reaccountCd");
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