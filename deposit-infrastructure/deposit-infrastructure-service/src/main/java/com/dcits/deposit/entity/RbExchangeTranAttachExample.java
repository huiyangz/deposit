package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbExchangeTranAttachExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbExchangeTranAttachExample() {
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

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andForeAcctEqualTo(String value) {
            addCriterion("FORE_ACCT =", value, "foreAcct");
            return (Criteria) this;
        }

        public Criteria andChannelSeqNoEqualTo(String value) {
            addCriterion("CHANNEL_SEQ_NO =", value, "channelSeqNo");
            return (Criteria) this;
        }

        public Criteria andDocumentIdEqualTo(String value) {
            addCriterion("DOCUMENT_ID =", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andExchangeSupplyReasonEqualTo(String value) {
            addCriterion("EXCHANGE_SUPPLY_REASON =", value, "exchangeSupplyReason");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountNatureEqualTo(String value) {
            addCriterion("EXCHANGE_AMOUNT_NATURE =", value, "exchangeAmountNature");
            return (Criteria) this;
        }

        public Criteria andAgencyCorpNameEqualTo(String value) {
            addCriterion("AGENCY_CORP_NAME =", value, "agencyCorpName");
            return (Criteria) this;
        }

        public Criteria andCnyAcctNoEqualTo(String value) {
            addCriterion("CNY_ACCT_NO =", value, "cnyAcctNo");
            return (Criteria) this;
        }

        public Criteria andExchangeChangeReasonEqualTo(String value) {
            addCriterion("EXCHANGE_CHANGE_REASON =", value, "exchangeChangeReason");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeEqualTo(String value) {
            addCriterion("DOCUMENT_TYPE =", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andIssCountryEqualTo(String value) {
            addCriterion("ISS_COUNTRY =", value, "issCountry");
            return (Criteria) this;
        }

        public Criteria andExchangeCancelReasonEqualTo(String value) {
            addCriterion("EXCHANGE_CANCEL_REASON =", value, "exchangeCancelReason");
            return (Criteria) this;
        }

        public Criteria andSupplyRemarkEqualTo(String value) {
            addCriterion("SUPPLY_REMARK =", value, "supplyRemark");
            return (Criteria) this;
        }

        public Criteria andApprLetterNoEqualTo(String value) {
            addCriterion("APPR_LETTER_NO =", value, "apprLetterNo");
            return (Criteria) this;
        }

        public Criteria andIndividualBusiOrgCodeEqualTo(String value) {
            addCriterion("INDIVIDUAL_BUSI_ORG_CODE =", value, "individualBusiOrgCode");
            return (Criteria) this;
        }

        public Criteria andIndividualBusiNameEqualTo(String value) {
            addCriterion("INDIVIDUAL_BUSI_NAME =", value, "individualBusiName");
            return (Criteria) this;
        }

        public Criteria andClientNameEqualTo(String value) {
            addCriterion("CLIENT_NAME =", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andSupplyDocumentIdEqualTo(String value) {
            addCriterion("SUPPLY_DOCUMENT_ID =", value, "supplyDocumentId");
            return (Criteria) this;
        }

        public Criteria andAgencyCorpOrgCodeEqualTo(String value) {
            addCriterion("AGENCY_CORP_ORG_CODE =", value, "agencyCorpOrgCode");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountTypeEqualTo(String value) {
            addCriterion("EXCHANGE_AMOUNT_TYPE =", value, "exchangeAmountType");
            return (Criteria) this;
        }

        public Criteria andExchangeClassEqualTo(String value) {
            addCriterion("EXCHANGE_CLASS =", value, "exchangeClass");
            return (Criteria) this;
        }

        public Criteria andExchangeReportTypeEqualTo(String value) {
            addCriterion("EXCHANGE_REPORT_TYPE =", value, "exchangeReportType");
            return (Criteria) this;
        }

        public Criteria andExchangeReportNoEqualTo(String value) {
            addCriterion("EXCHANGE_REPORT_NO =", value, "exchangeReportNo");
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

        public Criteria andExchangeTypeEqualTo(String value) {
            addCriterion("EXCHANGE_TYPE =", value, "exchangeType");
            return (Criteria) this;
        }

        public Criteria andExchangeTranStatusEqualTo(String value) {
            addCriterion("EXCHANGE_TRAN_STATUS =", value, "exchangeTranStatus");
            return (Criteria) this;
        }

        public Criteria andExchangePurposeEqualTo(String value) {
            addCriterion("EXCHANGE_PURPOSE =", value, "exchangePurpose");
            return (Criteria) this;
        }

        public Criteria andExchangePurposeDetailsEqualTo(String value) {
            addCriterion("EXCHANGE_PURPOSE_DETAILS =", value, "exchangePurposeDetails");
            return (Criteria) this;
        }

        public Criteria andSourceModuleEqualTo(String value) {
            addCriterion("SOURCE_MODULE =", value, "sourceModule");
            return (Criteria) this;
        }

        public Criteria andApprUserIdEqualTo(String value) {
            addCriterion("APPR_USER_ID =", value, "apprUserId");
            return (Criteria) this;
        }

        public Criteria andApprovalDateEqualTo(Date value) {
            addCriterion("APPROVAL_DATE =", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andTranDateEqualTo(Date value) {
            addCriterion("TRAN_DATE =", value, "tranDate");
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

        public Criteria andDiscountValueEqualTo(BigDecimal value) {
            addCriterion("DISCOUNT_VALUE =", value, "discountValue");
            return (Criteria) this;
        }

        public Criteria andLastChangeUserIdEqualTo(String value) {
            addCriterion("LAST_CHANGE_USER_ID =", value, "lastChangeUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("COMPANY =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCashFromCodeEqualTo(String value) {
            addCriterion("CASH_FROM_CODE =", value, "cashFromCode");
            return (Criteria) this;
        }

        public Criteria andCashFromCountryEqualTo(String value) {
            addCriterion("CASH_FROM_COUNTRY =", value, "cashFromCountry");
            return (Criteria) this;
        }

        public Criteria andCashToCodeEqualTo(String value) {
            addCriterion("CASH_TO_CODE =", value, "cashToCode");
            return (Criteria) this;
        }

        public Criteria andCashToCountryEqualTo(String value) {
            addCriterion("CASH_TO_COUNTRY =", value, "cashToCountry");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
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