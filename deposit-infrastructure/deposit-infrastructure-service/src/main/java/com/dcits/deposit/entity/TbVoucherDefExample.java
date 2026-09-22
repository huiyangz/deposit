package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class TbVoucherDefExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public TbVoucherDefExample() {
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

        public Criteria andDocTypeEqualTo(String value) {
            addCriterion("DOC_TYPE =", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeDescEqualTo(String value) {
            addCriterion("DOC_TYPE_DESC =", value, "docTypeDesc");
            return (Criteria) this;
        }

        public Criteria andDocClassEqualTo(String value) {
            addCriterion("DOC_CLASS =", value, "docClass");
            return (Criteria) this;
        }

        public Criteria andVoucherBillIndEqualTo(String value) {
            addCriterion("VOUCHER_BILL_IND =", value, "voucherBillInd");
            return (Criteria) this;
        }

        public Criteria andVoucherLengthEqualTo(String value) {
            addCriterion("VOUCHER_LENGTH =", value, "voucherLength");
            return (Criteria) this;
        }

        public Criteria andPrefixReqEqualTo(String value) {
            addCriterion("PREFIX_REQ =", value, "prefixReq");
            return (Criteria) this;
        }

        public Criteria andIsCashChequeEqualTo(String value) {
            addCriterion("IS_CASH_CHEQUE =", value, "isCashCheque");
            return (Criteria) this;
        }

        public Criteria andChequeBookFlagEqualTo(String value) {
            addCriterion("CHEQUE_BOOK_FLAG =", value, "chequeBookFlag");
            return (Criteria) this;
        }

        public Criteria andHaveNumberEqualTo(String value) {
            addCriterion("HAVE_NUMBER =", value, "haveNumber");
            return (Criteria) this;
        }

        public Criteria andInControlEqualTo(String value) {
            addCriterion("IN_CONTROL =", value, "inControl");
            return (Criteria) this;
        }

        public Criteria andBranchRestraintFlagEqualTo(String value) {
            addCriterion("BRANCH_RESTRAINT_FLAG =", value, "branchRestraintFlag");
            return (Criteria) this;
        }

        public Criteria andAllowDistrFlagEqualTo(String value) {
            addCriterion("ALLOW_DISTR_FLAG =", value, "allowDistrFlag");
            return (Criteria) this;
        }

        public Criteria andSaleFlagEqualTo(String value) {
            addCriterion("SALE_FLAG =", value, "saleFlag");
            return (Criteria) this;
        }

        public Criteria andVouLostDaysEqualTo(Integer value) {
            addCriterion("VOU_LOST_DAYS =", value, "vouLostDays");
            return (Criteria) this;
        }

        public Criteria andVouLostReissueDaysEqualTo(Integer value) {
            addCriterion("VOU_LOST_REISSUE_DAYS =", value, "vouLostReissueDays");
            return (Criteria) this;
        }

        public Criteria andCommissionVouLostDaysEqualTo(Integer value) {
            addCriterion("COMMISSION_VOU_LOST_DAYS =", value, "commissionVouLostDays");
            return (Criteria) this;
        }

        public Criteria andExpireDateEqualTo(Date value) {
            addCriterion("EXPIRE_DATE =", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andEffectDateEqualTo(Date value) {
            addCriterion("EFFECT_DATE =", value, "effectDate");
            return (Criteria) this;
        }

        public Criteria andUseByOrderFlagEqualTo(String value) {
            addCriterion("USE_BY_ORDER_FLAG =", value, "useByOrderFlag");
            return (Criteria) this;
        }

        public Criteria andDepositTypeEqualTo(String value) {
            addCriterion("DEPOSIT_TYPE =", value, "depositType");
            return (Criteria) this;
        }

        public Criteria andOtherBankFlagEqualTo(String value) {
            addCriterion("OTHER_BANK_FLAG =", value, "otherBankFlag");
            return (Criteria) this;
        }

        public Criteria andProfitCenterEqualTo(String value) {
            addCriterion("PROFIT_CENTER =", value, "profitCenter");
            return (Criteria) this;
        }

        public Criteria andVoucherApproveStatusEqualTo(String value) {
            addCriterion("VOUCHER_APPROVE_STATUS =", value, "voucherApproveStatus");
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

        public Criteria andApprUserIdEqualTo(String value) {
            addCriterion("APPR_USER_ID =", value, "apprUserId");
            return (Criteria) this;
        }

        public Criteria andLastChangeUserIdEqualTo(String value) {
            addCriterion("LAST_CHANGE_USER_ID =", value, "lastChangeUserId");
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

        public Criteria andOpenAcctFlagEqualTo(String value) {
            addCriterion("OPEN_ACCT_FLAG =", value, "openAcctFlag");
            return (Criteria) this;
        }

        public Criteria andVouLostStopFlagEqualTo(String value) {
            addCriterion("VOU_LOST_STOP_FLAG =", value, "vouLostStopFlag");
            return (Criteria) this;
        }

        public Criteria andVouLostAllowChannelEqualTo(String value) {
            addCriterion("VOU_LOST_ALLOW_CHANNEL =", value, "vouLostAllowChannel");
            return (Criteria) this;
        }

        public Criteria andLostStopFlagEqualTo(String value) {
            addCriterion("LOST_STOP_FLAG =", value, "lostStopFlag");
            return (Criteria) this;
        }

        public Criteria andLostAllowChannelEqualTo(String value) {
            addCriterion("LOST_ALLOW_CHANNEL =", value, "lostAllowChannel");
            return (Criteria) this;
        }

        public Criteria andLostDaysEqualTo(Integer value) {
            addCriterion("LOST_DAYS =", value, "lostDays");
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