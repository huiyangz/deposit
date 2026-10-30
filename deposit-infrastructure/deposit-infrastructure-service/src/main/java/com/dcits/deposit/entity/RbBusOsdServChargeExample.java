package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbBusOsdServChargeExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbBusOsdServChargeExample() {
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

        public Criteria andProfitAllotFlagEqualTo(String value) {
            addCriterion("PROFIT_ALLOT_FLAG =", value, "profitAllotFlag");
            return (Criteria) this;
        }

        public Criteria andTranBranchPercentEqualTo(BigDecimal value) {
            addCriterion("TRAN_BRANCH_PERCENT =", value, "tranBranchPercent");
            return (Criteria) this;
        }

        public Criteria andChargeToInternalKeyEqualTo(Integer value) {
            addCriterion("CHARGE_TO_INTERNAL_KEY =", value, "chargeToInternalKey");
            return (Criteria) this;
        }

        public Criteria andTranBranchEqualTo(String value) {
            addCriterion("TRAN_BRANCH =", value, "tranBranch");
            return (Criteria) this;
        }

        public Criteria andBaseAcctNoEqualTo(String value) {
            addCriterion("BASE_ACCT_NO =", value, "baseAcctNo");
            return (Criteria) this;
        }

        public Criteria andReversalDateEqualTo(Date value) {
            addCriterion("REVERSAL_DATE =", value, "reversalDate");
            return (Criteria) this;
        }

        public Criteria andDiscFeeAmtEqualTo(BigDecimal value) {
            addCriterion("DISC_FEE_AMT =", value, "discFeeAmt");
            return (Criteria) this;
        }

        public Criteria andAgreementIdEqualTo(String value) {
            addCriterion("AGREEMENT_ID =", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andVoucherNumEqualTo(Integer value) {
            addCriterion("VOUCHER_NUM =", value, "voucherNum");
            return (Criteria) this;
        }

        public Criteria andDelayFlagEqualTo(String value) {
            addCriterion("DELAY_FLAG =", value, "delayFlag");
            return (Criteria) this;
        }

        public Criteria andChargeToCcyEqualTo(String value) {
            addCriterion("CHARGE_TO_CCY =", value, "chargeToCcy");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(BigDecimal value) {
            addCriterion("UNIT_PRICE =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andDiscRateEqualTo(BigDecimal value) {
            addCriterion("DISC_RATE =", value, "discRate");
            return (Criteria) this;
        }

        public Criteria andReversalAuthUserIdEqualTo(String value) {
            addCriterion("REVERSAL_AUTH_USER_ID =", value, "reversalAuthUserId");
            return (Criteria) this;
        }

        public Criteria andDocTypeEqualTo(String value) {
            addCriterion("DOC_TYPE =", value, "docType");
            return (Criteria) this;
        }

        public Criteria andTaxRateEqualTo(BigDecimal value) {
            addCriterion("TAX_RATE =", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andReversalFlagEqualTo(String value) {
            addCriterion("REVERSAL_FLAG =", value, "reversalFlag");
            return (Criteria) this;
        }

        public Criteria andEffectDateEqualTo(Date value) {
            addCriterion("EFFECT_DATE =", value, "effectDate");
            return (Criteria) this;
        }

        public Criteria andOrigFeeAmtEqualTo(BigDecimal value) {
            addCriterion("ORIG_FEE_AMT =", value, "origFeeAmt");
            return (Criteria) this;
        }

        public Criteria andLastChargeDateEqualTo(Date value) {
            addCriterion("LAST_CHARGE_DATE =", value, "lastChargeDate");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(String value) {
            addCriterion("CREATE_TIMESTAMP =", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andReversalBranchEqualTo(String value) {
            addCriterion("REVERSAL_BRANCH =", value, "reversalBranch");
            return (Criteria) this;
        }

        public Criteria andFeeCcyEqualTo(String value) {
            addCriterion("FEE_CCY =", value, "feeCcy");
            return (Criteria) this;
        }

        public Criteria andVoucherEndNoEqualTo(String value) {
            addCriterion("VOUCHER_END_NO =", value, "voucherEndNo");
            return (Criteria) this;
        }

        public Criteria andTranFeeAmtEqualTo(BigDecimal value) {
            addCriterion("TRAN_FEE_AMT =", value, "tranFeeAmt");
            return (Criteria) this;
        }

        public Criteria andChargePeriodFreqEqualTo(String value) {
            addCriterion("CHARGE_PERIOD_FREQ =", value, "chargePeriodFreq");
            return (Criteria) this;
        }

        public Criteria andInternalKeyEqualTo(Integer value) {
            addCriterion("INTERNAL_KEY =", value, "internalKey");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andRbBusAgreementTypeEqualTo(String value) {
            addCriterion("RB_BUS_AGREEMENT_TYPE =", value, "rbBusAgreementType");
            return (Criteria) this;
        }

        public Criteria andTranProfitAmtEqualTo(BigDecimal value) {
            addCriterion("TRAN_PROFIT_AMT =", value, "tranProfitAmt");
            return (Criteria) this;
        }

        public Criteria andChargeToAcctSeqNoEqualTo(String value) {
            addCriterion("CHARGE_TO_ACCT_SEQ_NO =", value, "chargeToAcctSeqNo");
            return (Criteria) this;
        }

        public Criteria andChargeToBaseAcctNoEqualTo(String value) {
            addCriterion("CHARGE_TO_BASE_ACCT_NO =", value, "chargeToBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andPrimaryTranSeqNoEqualTo(String value) {
            addCriterion("PRIMARY_TRAN_SEQ_NO =", value, "primaryTranSeqNo");
            return (Criteria) this;
        }

        public Criteria andAcctNameEqualTo(String value) {
            addCriterion("ACCT_NAME =", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andManualDiscFeeEqualTo(BigDecimal value) {
            addCriterion("MANUAL_DISC_FEE =", value, "manualDiscFee");
            return (Criteria) this;
        }

        public Criteria andOthBusinessNoEqualTo(String value) {
            addCriterion("OTH_BUSINESS_NO =", value, "othBusinessNo");
            return (Criteria) this;
        }

        public Criteria andFeeAmtEqualTo(BigDecimal value) {
            addCriterion("FEE_AMT =", value, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andOthNameEqualTo(String value) {
            addCriterion("OTH_NAME =", value, "othName");
            return (Criteria) this;
        }

        public Criteria andOpenBranchPercentEqualTo(BigDecimal value) {
            addCriterion("OPEN_BRANCH_PERCENT =", value, "openBranchPercent");
            return (Criteria) this;
        }

        public Criteria andTaxAmtEqualTo(BigDecimal value) {
            addCriterion("TAX_AMT =", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andChargeDayEqualTo(String value) {
            addCriterion("CHARGE_DAY =", value, "chargeDay");
            return (Criteria) this;
        }

        public Criteria andRecAmtEqualTo(BigDecimal value) {
            addCriterion("REC_AMT =", value, "recAmt");
            return (Criteria) this;
        }

        public Criteria andAcctBranchEqualTo(String value) {
            addCriterion("ACCT_BRANCH =", value, "acctBranch");
            return (Criteria) this;
        }

        public Criteria andOsdStatusEqualTo(String value) {
            addCriterion("OSD_STATUS =", value, "osdStatus");
            return (Criteria) this;
        }

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andOsdSeqNoEqualTo(String value) {
            addCriterion("OSD_SEQ_NO =", value, "osdSeqNo");
            return (Criteria) this;
        }

        public Criteria andTaxTypeNoEqualTo(String value) {
            addCriterion("TAX_TYPE_NO =", value, "taxTypeNo");
            return (Criteria) this;
        }

        public Criteria andNextChargeDateEqualTo(Date value) {
            addCriterion("NEXT_CHARGE_DATE =", value, "nextChargeDate");
            return (Criteria) this;
        }

        public Criteria andOpenProfitAmtEqualTo(BigDecimal value) {
            addCriterion("OPEN_PROFIT_AMT =", value, "openProfitAmt");
            return (Criteria) this;
        }

        public Criteria andVoucherStartNoEqualTo(String value) {
            addCriterion("VOUCHER_START_NO =", value, "voucherStartNo");
            return (Criteria) this;
        }

        public Criteria andDiscTypeEqualTo(String value) {
            addCriterion("DISC_TYPE =", value, "discType");
            return (Criteria) this;
        }

        public Criteria andPrefixEqualTo(String value) {
            addCriterion("PREFIX =", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andBatchFeeMergeFlagEqualTo(String value) {
            addCriterion("BATCH_FEE_MERGE_FLAG =", value, "batchFeeMergeFlag");
            return (Criteria) this;
        }

        public Criteria andReversalUserIdEqualTo(String value) {
            addCriterion("REVERSAL_USER_ID =", value, "reversalUserId");
            return (Criteria) this;
        }

        public Criteria andTranDateEqualTo(Date value) {
            addCriterion("TRAN_DATE =", value, "tranDate");
            return (Criteria) this;
        }

        public Criteria andFeeTypeEqualTo(String value) {
            addCriterion("FEE_TYPE =", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andBoIndEqualTo(String value) {
            addCriterion("BO_IND =", value, "boInd");
            return (Criteria) this;
        }

        public Criteria andChargeWayEqualTo(String value) {
            addCriterion("CHARGE_WAY =", value, "chargeWay");
            return (Criteria) this;
        }

        public Criteria andClientTypeEqualTo(String value) {
            addCriterion("CLIENT_TYPE =", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimestampEqualTo(String value) {
            addCriterion("LAST_UPD_TIMESTAMP =", value, "lastUpdTimestamp");
            return (Criteria) this;
        }

        public Criteria andReferenceEqualTo(String value) {
            addCriterion("REFERENCE =", value, "reference");
            return (Criteria) this;
        }

        public Criteria andChargeToProdNoEqualTo(String value) {
            addCriterion("CHARGE_TO_PROD_NO =", value, "chargeToProdNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoEqualTo(String value) {
            addCriterion("SEQ_NO =", value, "seqNo");
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