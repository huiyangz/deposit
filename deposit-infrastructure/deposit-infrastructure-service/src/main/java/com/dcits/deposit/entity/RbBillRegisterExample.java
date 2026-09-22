package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbBillRegisterExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbBillRegisterExample() {
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

        public Criteria andBillSerialNoEqualTo(String value) {
            addCriterion("BILL_SERIAL_NO =", value, "billSerialNo");
            return (Criteria) this;
        }

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andBillNoEqualTo(String value) {
            addCriterion("BILL_NO =", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillBusiTypeEqualTo(String value) {
            addCriterion("BILL_BUSI_TYPE =", value, "billBusiType");
            return (Criteria) this;
        }

        public Criteria andBillTypeEqualTo(String value) {
            addCriterion("BILL_TYPE =", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillStatusEqualTo(String value) {
            addCriterion("BILL_STATUS =", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillPrefixEqualTo(String value) {
            addCriterion("BILL_PREFIX =", value, "billPrefix");
            return (Criteria) this;
        }

        public Criteria andBillVoucherNoEqualTo(String value) {
            addCriterion("BILL_VOUCHER_NO =", value, "billVoucherNo");
            return (Criteria) this;
        }

        public Criteria andDocTypeEqualTo(String value) {
            addCriterion("DOC_TYPE =", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocClassEqualTo(String value) {
            addCriterion("DOC_CLASS =", value, "docClass");
            return (Criteria) this;
        }

        public Criteria andPromptDateEqualTo(Date value) {
            addCriterion("PROMPT_DATE =", value, "promptDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateEqualTo(Date value) {
            addCriterion("SETTLE_DATE =", value, "settleDate");
            return (Criteria) this;
        }

        public Criteria andEncryptKeyEqualTo(String value) {
            addCriterion("ENCRYPT_KEY =", value, "encryptKey");
            return (Criteria) this;
        }

        public Criteria andBillApplyTypeEqualTo(String value) {
            addCriterion("BILL_APPLY_TYPE =", value, "billApplyType");
            return (Criteria) this;
        }

        public Criteria andBillApplyNoEqualTo(String value) {
            addCriterion("BILL_APPLY_NO =", value, "billApplyNo");
            return (Criteria) this;
        }

        public Criteria andBillApplyPrefixEqualTo(String value) {
            addCriterion("BILL_APPLY_PREFIX =", value, "billApplyPrefix");
            return (Criteria) this;
        }

        public Criteria andBillApplyDateEqualTo(Date value) {
            addCriterion("BILL_APPLY_DATE =", value, "billApplyDate");
            return (Criteria) this;
        }

        public Criteria andBillIssueAmtEqualTo(BigDecimal value) {
            addCriterion("BILL_ISSUE_AMT =", value, "billIssueAmt");
            return (Criteria) this;
        }

        public Criteria andBillIssueCcyEqualTo(String value) {
            addCriterion("BILL_ISSUE_CCY =", value, "billIssueCcy");
            return (Criteria) this;
        }

        public Criteria andBillIssueTypeEqualTo(String value) {
            addCriterion("BILL_ISSUE_TYPE =", value, "billIssueType");
            return (Criteria) this;
        }

        public Criteria andBillIssueBankNoEqualTo(String value) {
            addCriterion("BILL_ISSUE_BANK_NO =", value, "billIssueBankNo");
            return (Criteria) this;
        }

        public Criteria andBillIssueBankNameEqualTo(String value) {
            addCriterion("BILL_ISSUE_BANK_NAME =", value, "billIssueBankName");
            return (Criteria) this;
        }

        public Criteria andBillIssueDateEqualTo(Date value) {
            addCriterion("BILL_ISSUE_DATE =", value, "billIssueDate");
            return (Criteria) this;
        }

        public Criteria andBillIssueCashItemEqualTo(String value) {
            addCriterion("BILL_ISSUE_CASH_ITEM =", value, "billIssueCashItem");
            return (Criteria) this;
        }

        public Criteria andBillIssueBranchEqualTo(String value) {
            addCriterion("BILL_ISSUE_BRANCH =", value, "billIssueBranch");
            return (Criteria) this;
        }

        public Criteria andBillIssueUserIdEqualTo(String value) {
            addCriterion("BILL_ISSUE_USER_ID =", value, "billIssueUserId");
            return (Criteria) this;
        }

        public Criteria andApprUserIdEqualTo(String value) {
            addCriterion("APPR_USER_ID =", value, "apprUserId");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdEqualTo(String value) {
            addCriterion("AUTH_USER_ID =", value, "authUserId");
            return (Criteria) this;
        }

        public Criteria andPrintCntEqualTo(Integer value) {
            addCriterion("PRINT_CNT =", value, "printCnt");
            return (Criteria) this;
        }

        public Criteria andAgentPayerBankNoEqualTo(String value) {
            addCriterion("AGENT_PAYER_BANK_NO =", value, "agentPayerBankNo");
            return (Criteria) this;
        }

        public Criteria andAgentPayerBankNameEqualTo(String value) {
            addCriterion("AGENT_PAYER_BANK_NAME =", value, "agentPayerBankName");
            return (Criteria) this;
        }

        public Criteria andBillPaymentStatusEqualTo(String value) {
            addCriterion("BILL_PAYMENT_STATUS =", value, "billPaymentStatus");
            return (Criteria) this;
        }

        public Criteria andBillPaymentAmtEqualTo(BigDecimal value) {
            addCriterion("BILL_PAYMENT_AMT =", value, "billPaymentAmt");
            return (Criteria) this;
        }

        public Criteria andExcessAmtEqualTo(BigDecimal value) {
            addCriterion("EXCESS_AMT =", value, "excessAmt");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeEqualTo(String value) {
            addCriterion("PAYMENT_TYPE =", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentDateEqualTo(Date value) {
            addCriterion("PAYMENT_DATE =", value, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentCashItemEqualTo(String value) {
            addCriterion("PAYMENT_CASH_ITEM =", value, "paymentCashItem");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNoEqualTo(String value) {
            addCriterion("PAYMENT_BANK_NO =", value, "paymentBankNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNameEqualTo(String value) {
            addCriterion("PAYMENT_BANK_NAME =", value, "paymentBankName");
            return (Criteria) this;
        }

        public Criteria andPayerBaseAcctNoEqualTo(String value) {
            addCriterion("PAYER_BASE_ACCT_NO =", value, "payerBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andPayerBankNameEqualTo(String value) {
            addCriterion("PAYER_BANK_NAME =", value, "payerBankName");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNameEqualTo(String value) {
            addCriterion("PAYER_ACCT_NAME =", value, "payerAcctName");
            return (Criteria) this;
        }

        public Criteria andPayerAcctCcyEqualTo(String value) {
            addCriterion("PAYER_ACCT_CCY =", value, "payerAcctCcy");
            return (Criteria) this;
        }

        public Criteria andPayerAcctProdTypeEqualTo(String value) {
            addCriterion("PAYER_ACCT_PROD_TYPE =", value, "payerAcctProdType");
            return (Criteria) this;
        }

        public Criteria andPayerAcctSeqNoEqualTo(String value) {
            addCriterion("PAYER_ACCT_SEQ_NO =", value, "payerAcctSeqNo");
            return (Criteria) this;
        }

        public Criteria andPayerDocumentIdEqualTo(String value) {
            addCriterion("PAYER_DOCUMENT_ID =", value, "payerDocumentId");
            return (Criteria) this;
        }

        public Criteria andPayerDocumentTypeEqualTo(String value) {
            addCriterion("PAYER_DOCUMENT_TYPE =", value, "payerDocumentType");
            return (Criteria) this;
        }

        public Criteria andPayerAddrEqualTo(String value) {
            addCriterion("PAYER_ADDR =", value, "payerAddr");
            return (Criteria) this;
        }

        public Criteria andPayerBankCodeEqualTo(String value) {
            addCriterion("PAYER_BANK_CODE =", value, "payerBankCode");
            return (Criteria) this;
        }

        public Criteria andPayeeBaseAcctNoEqualTo(String value) {
            addCriterion("PAYEE_BASE_ACCT_NO =", value, "payeeBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAcctSeqNoEqualTo(String value) {
            addCriterion("PAYEE_ACCT_SEQ_NO =", value, "payeeAcctSeqNo");
            return (Criteria) this;
        }

        public Criteria andPayeeProdTypeEqualTo(String value) {
            addCriterion("PAYEE_PROD_TYPE =", value, "payeeProdType");
            return (Criteria) this;
        }

        public Criteria andPayeeAcctCcyEqualTo(String value) {
            addCriterion("PAYEE_ACCT_CCY =", value, "payeeAcctCcy");
            return (Criteria) this;
        }

        public Criteria andPayeeAcctNameEqualTo(String value) {
            addCriterion("PAYEE_ACCT_NAME =", value, "payeeAcctName");
            return (Criteria) this;
        }

        public Criteria andPayeeAddrEqualTo(String value) {
            addCriterion("PAYEE_ADDR =", value, "payeeAddr");
            return (Criteria) this;
        }

        public Criteria andPayeeDocumentTypeEqualTo(String value) {
            addCriterion("PAYEE_DOCUMENT_TYPE =", value, "payeeDocumentType");
            return (Criteria) this;
        }

        public Criteria andPayeeDocumentIdEqualTo(String value) {
            addCriterion("PAYEE_DOCUMENT_ID =", value, "payeeDocumentId");
            return (Criteria) this;
        }

        public Criteria andPayeeBankCodeEqualTo(String value) {
            addCriterion("PAYEE_BANK_CODE =", value, "payeeBankCode");
            return (Criteria) this;
        }

        public Criteria andPayeeBankNameEqualTo(String value) {
            addCriterion("PAYEE_BANK_NAME =", value, "payeeBankName");
            return (Criteria) this;
        }

        public Criteria andReturnBaseAcctNoEqualTo(String value) {
            addCriterion("RETURN_BASE_ACCT_NO =", value, "returnBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andReturnAcctNameEqualTo(String value) {
            addCriterion("RETURN_ACCT_NAME =", value, "returnAcctName");
            return (Criteria) this;
        }

        public Criteria andReturnDocumentIdEqualTo(String value) {
            addCriterion("RETURN_DOCUMENT_ID =", value, "returnDocumentId");
            return (Criteria) this;
        }

        public Criteria andReturnDocumentTypeEqualTo(String value) {
            addCriterion("RETURN_DOCUMENT_TYPE =", value, "returnDocumentType");
            return (Criteria) this;
        }

        public Criteria andRefundBankNoEqualTo(String value) {
            addCriterion("REFUND_BANK_NO =", value, "refundBankNo");
            return (Criteria) this;
        }

        public Criteria andReturnCashItemEqualTo(String value) {
            addCriterion("RETURN_CASH_ITEM =", value, "returnCashItem");
            return (Criteria) this;
        }

        public Criteria andReturnTypeEqualTo(String value) {
            addCriterion("RETURN_TYPE =", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnUserEqualTo(String value) {
            addCriterion("RETURN_USER =", value, "returnUser");
            return (Criteria) this;
        }

        public Criteria andReturnDateEqualTo(Date value) {
            addCriterion("RETURN_DATE =", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andLastHolderNameEqualTo(String value) {
            addCriterion("LAST_HOLDER_NAME =", value, "lastHolderName");
            return (Criteria) this;
        }

        public Criteria andLastHolderBaseAcctNoEqualTo(String value) {
            addCriterion("LAST_HOLDER_BASE_ACCT_NO =", value, "lastHolderBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andLastHolderBankCodeEqualTo(String value) {
            addCriterion("LAST_HOLDER_BANK_CODE =", value, "lastHolderBankCode");
            return (Criteria) this;
        }

        public Criteria andLastHolderBankNameEqualTo(String value) {
            addCriterion("LAST_HOLDER_BANK_NAME =", value, "lastHolderBankName");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("COMPANY =", value, "company");
            return (Criteria) this;
        }

        public Criteria andLastTranDateEqualTo(Date value) {
            addCriterion("LAST_TRAN_DATE =", value, "lastTranDate");
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