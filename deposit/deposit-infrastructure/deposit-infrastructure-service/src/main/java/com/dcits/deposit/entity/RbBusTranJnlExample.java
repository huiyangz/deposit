package com.dcits.deposit.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class RbBusTranJnlExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RbBusTranJnlExample() {
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

        public Criteria andCommissionClientTelEqualTo(String value) {
            addCriterion("COMMISSION_CLIENT_TEL =", value, "commissionClientTel");
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

        public Criteria andSourceTypeEqualTo(String value) {
            addCriterion("SOURCE_TYPE =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andFhSeqNoEqualTo(String value) {
            addCriterion("FH_SEQ_NO =", value, "fhSeqNo");
            return (Criteria) this;
        }

        public Criteria andOrigSystemEqualTo(String value) {
            addCriterion("ORIG_SYSTEM =", value, "origSystem");
            return (Criteria) this;
        }

        public Criteria andOthDocumentIdEqualTo(String value) {
            addCriterion("OTH_DOCUMENT_ID =", value, "othDocumentId");
            return (Criteria) this;
        }

        public Criteria andPreviousBalAmtEqualTo(BigDecimal value) {
            addCriterion("PREVIOUS_BAL_AMT =", value, "previousBalAmt");
            return (Criteria) this;
        }

        public Criteria andTranCountryEqualTo(String value) {
            addCriterion("TRAN_COUNTRY =", value, "tranCountry");
            return (Criteria) this;
        }

        public Criteria andLastUpdTimestampEqualTo(String value) {
            addCriterion("LAST_UPD_TIMESTAMP =", value, "lastUpdTimestamp");
            return (Criteria) this;
        }

        public Criteria andTranNoteEqualTo(String value) {
            addCriterion("TRAN_NOTE =", value, "tranNote");
            return (Criteria) this;
        }

        public Criteria andContraAcctCcyEqualTo(String value) {
            addCriterion("CONTRA_ACCT_CCY =", value, "contraAcctCcy");
            return (Criteria) this;
        }

        public Criteria andLimitRefListEqualTo(String value) {
            addCriterion("LIMIT_REF_LIST =", value, "limitRefList");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdEqualTo(String value) {
            addCriterion("AUTH_USER_ID =", value, "authUserId");
            return (Criteria) this;
        }

        public Criteria andReversalFlagEqualTo(String value) {
            addCriterion("REVERSAL_FLAG =", value, "reversalFlag");
            return (Criteria) this;
        }

        public Criteria andCashFromCodeEqualTo(String value) {
            addCriterion("CASH_FROM_CODE =", value, "cashFromCode");
            return (Criteria) this;
        }

        public Criteria andOthReferenceEqualTo(String value) {
            addCriterion("OTH_REFERENCE =", value, "othReference");
            return (Criteria) this;
        }

        public Criteria andOthRealBranchRegionCodeEqualTo(String value) {
            addCriterion("OTH_REAL_BRANCH_REGION_CODE =", value, "othRealBranchRegionCode");
            return (Criteria) this;
        }

        public Criteria andTranTypeEqualTo(String value) {
            addCriterion("TRAN_TYPE =", value, "tranType");
            return (Criteria) this;
        }

        public Criteria andOthRealTranNameEqualTo(String value) {
            addCriterion("OTH_REAL_TRAN_NAME =", value, "othRealTranName");
            return (Criteria) this;
        }

        public Criteria andVoucherNoEqualTo(String value) {
            addCriterion("VOUCHER_NO =", value, "voucherNo");
            return (Criteria) this;
        }

        public Criteria andReaccountCdEqualTo(String value) {
            addCriterion("REACCOUNT_CD =", value, "reaccountCd");
            return (Criteria) this;
        }

        public Criteria andPrimaryTranSeqNoEqualTo(String value) {
            addCriterion("PRIMARY_TRAN_SEQ_NO =", value, "primaryTranSeqNo");
            return (Criteria) this;
        }

        public Criteria andBaseCcyAmountOneEqualTo(BigDecimal value) {
            addCriterion("BASE_CCY_AMOUNT_ONE =", value, "baseCcyAmountOne");
            return (Criteria) this;
        }

        public Criteria andMediumFlagEqualTo(String value) {
            addCriterion("MEDIUM_FLAG =", value, "mediumFlag");
            return (Criteria) this;
        }

        public Criteria andOvToAmountEqualTo(BigDecimal value) {
            addCriterion("OV_TO_AMOUNT =", value, "ovToAmount");
            return (Criteria) this;
        }

        public Criteria andFromRateFlagEqualTo(String value) {
            addCriterion("FROM_RATE_FLAG =", value, "fromRateFlag");
            return (Criteria) this;
        }

        public Criteria andAcctCcyEqualTo(String value) {
            addCriterion("ACCT_CCY =", value, "acctCcy");
            return (Criteria) this;
        }

        public Criteria andToRateFlagEqualTo(String value) {
            addCriterion("TO_RATE_FLAG =", value, "toRateFlag");
            return (Criteria) this;
        }

        public Criteria andNarrativeEqualTo(String value) {
            addCriterion("NARRATIVE =", value, "narrative");
            return (Criteria) this;
        }

        public Criteria andOthRealBaseAcctNoEqualTo(String value) {
            addCriterion("OTH_REAL_BASE_ACCT_NO =", value, "othRealBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andOthAcctDescEqualTo(String value) {
            addCriterion("OTH_ACCT_DESC =", value, "othAcctDesc");
            return (Criteria) this;
        }

        public Criteria andCommissionClientNameEqualTo(String value) {
            addCriterion("COMMISSION_CLIENT_NAME =", value, "commissionClientName");
            return (Criteria) this;
        }

        public Criteria andPrintIndicatorEqualTo(String value) {
            addCriterion("PRINT_INDICATOR =", value, "printIndicator");
            return (Criteria) this;
        }

        public Criteria andIsFinSubAcctEqualTo(String value) {
            addCriterion("IS_FIN_SUB_ACCT =", value, "isFinSubAcct");
            return (Criteria) this;
        }

        public Criteria andActualBalEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_BAL =", value, "actualBal");
            return (Criteria) this;
        }

        public Criteria andCrossRateEqualTo(BigDecimal value) {
            addCriterion("CROSS_RATE =", value, "crossRate");
            return (Criteria) this;
        }

        public Criteria andEventTypeEqualTo(String value) {
            addCriterion("EVENT_TYPE =", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andContraEquivAmtEqualTo(BigDecimal value) {
            addCriterion("CONTRA_EQUIV_AMT =", value, "contraEquivAmt");
            return (Criteria) this;
        }

        public Criteria andRateTypeEqualTo(String value) {
            addCriterion("RATE_TYPE =", value, "rateType");
            return (Criteria) this;
        }

        public Criteria andEffectDateEqualTo(Date value) {
            addCriterion("EFFECT_DATE =", value, "effectDate");
            return (Criteria) this;
        }

        public Criteria andAcctSetTypeEqualTo(String value) {
            addCriterion("ACCT_SET_TYPE =", value, "acctSetType");
            return (Criteria) this;
        }

        public Criteria andChannelSeqNoEqualTo(String value) {
            addCriterion("CHANNEL_SEQ_NO =", value, "channelSeqNo");
            return (Criteria) this;
        }

        public Criteria andApprUserIdEqualTo(String value) {
            addCriterion("APPR_USER_ID =", value, "apprUserId");
            return (Criteria) this;
        }

        public Criteria andTackOverCcyRateTwoEqualTo(BigDecimal value) {
            addCriterion("TACK_OVER_CCY_RATE_TWO =", value, "tackOverCcyRateTwo");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("CHANNEL =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andOthDocumentTypeEqualTo(String value) {
            addCriterion("OTH_DOCUMENT_TYPE =", value, "othDocumentType");
            return (Criteria) this;
        }

        public Criteria andOthRealDocumentTypeEqualTo(String value) {
            addCriterion("OTH_REAL_DOCUMENT_TYPE =", value, "othRealDocumentType");
            return (Criteria) this;
        }

        public Criteria andLoanProdNoEqualTo(String value) {
            addCriterion("LOAN_PROD_NO =", value, "loanProdNo");
            return (Criteria) this;
        }

        public Criteria andToIdEqualTo(String value) {
            addCriterion("TO_ID =", value, "toId");
            return (Criteria) this;
        }

        public Criteria andCustRateEqualTo(BigDecimal value) {
            addCriterion("CUST_RATE =", value, "custRate");
            return (Criteria) this;
        }

        public Criteria andBalTypeEqualTo(String value) {
            addCriterion("BAL_TYPE =", value, "balType");
            return (Criteria) this;
        }

        public Criteria andSubAcctNoEqualTo(String value) {
            addCriterion("SUB_ACCT_NO =", value, "subAcctNo");
            return (Criteria) this;
        }

        public Criteria andBusSeqNoEqualTo(String value) {
            addCriterion("BUS_SEQ_NO =", value, "busSeqNo");
            return (Criteria) this;
        }

        public Criteria andAcctStatusEqualTo(String value) {
            addCriterion("ACCT_STATUS =", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andRcrRcdIndEqualTo(String value) {
            addCriterion("RCR_RCD_IND =", value, "rcrRcdInd");
            return (Criteria) this;
        }

        public Criteria andExchangeTranCodeEqualTo(String value) {
            addCriterion("EXCHANGE_TRAN_CODE =", value, "exchangeTranCode");
            return (Criteria) this;
        }

        public Criteria andClientNameEqualTo(String value) {
            addCriterion("CLIENT_NAME =", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andServChargeEqualTo(String value) {
            addCriterion("SERV_CHARGE =", value, "servCharge");
            return (Criteria) this;
        }

        public Criteria andAcctSeqNoEqualTo(String value) {
            addCriterion("ACCT_SEQ_NO =", value, "acctSeqNo");
            return (Criteria) this;
        }

        public Criteria andApprIndicatorEqualTo(String value) {
            addCriterion("APPR_INDICATOR =", value, "apprIndicator");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeEqualTo(String value) {
            addCriterion("DOCUMENT_TYPE =", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andAcctBranchEqualTo(String value) {
            addCriterion("ACCT_BRANCH =", value, "acctBranch");
            return (Criteria) this;
        }

        public Criteria andOthTranNameEqualTo(String value) {
            addCriterion("OTH_TRAN_NAME =", value, "othTranName");
            return (Criteria) this;
        }

        public Criteria andIsCommTranEqualTo(String value) {
            addCriterion("IS_COMM_TRAN =", value, "isCommTran");
            return (Criteria) this;
        }

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andBaseCcyAmountTwoEqualTo(BigDecimal value) {
            addCriterion("BASE_CCY_AMOUNT_TWO =", value, "baseCcyAmountTwo");
            return (Criteria) this;
        }

        public Criteria andAcctRealFlagEqualTo(String value) {
            addCriterion("ACCT_REAL_FLAG =", value, "acctRealFlag");
            return (Criteria) this;
        }

        public Criteria andOthBranchRegionalismCodeEqualTo(String value) {
            addCriterion("OTH_BRANCH_REGIONALISM_CODE =", value, "othBranchRegionalismCode");
            return (Criteria) this;
        }

        public Criteria andFromAmountEqualTo(BigDecimal value) {
            addCriterion("FROM_AMOUNT =", value, "fromAmount");
            return (Criteria) this;
        }

        public Criteria andSourceModuleEqualTo(String value) {
            addCriterion("SOURCE_MODULE =", value, "sourceModule");
            return (Criteria) this;
        }

        public Criteria andToXrateEqualTo(BigDecimal value) {
            addCriterion("TO_XRATE =", value, "toXrate");
            return (Criteria) this;
        }

        public Criteria andProfitCenterEqualTo(String value) {
            addCriterion("PROFIT_CENTER =", value, "profitCenter");
            return (Criteria) this;
        }

        public Criteria andCashToCountryEqualTo(String value) {
            addCriterion("CASH_TO_COUNTRY =", value, "cashToCountry");
            return (Criteria) this;
        }

        public Criteria andBankSeqNoEqualTo(String value) {
            addCriterion("BANK_SEQ_NO =", value, "bankSeqNo");
            return (Criteria) this;
        }

        public Criteria andCashToCodeEqualTo(String value) {
            addCriterion("CASH_TO_CODE =", value, "cashToCode");
            return (Criteria) this;
        }

        public Criteria andPrimaryEventTypeEqualTo(String value) {
            addCriterion("PRIMARY_EVENT_TYPE =", value, "primaryEventType");
            return (Criteria) this;
        }

        public Criteria andTranMethodEqualTo(String value) {
            addCriterion("TRAN_METHOD =", value, "tranMethod");
            return (Criteria) this;
        }

        public Criteria andLenderEqualTo(String value) {
            addCriterion("LENDER =", value, "lender");
            return (Criteria) this;
        }

        public Criteria andProgramIdEqualTo(String value) {
            addCriterion("PROGRAM_ID =", value, "programId");
            return (Criteria) this;
        }

        public Criteria andCashFromCountryEqualTo(String value) {
            addCriterion("CASH_FROM_COUNTRY =", value, "cashFromCountry");
            return (Criteria) this;
        }

        public Criteria andOthRealProdNoEqualTo(String value) {
            addCriterion("OTH_REAL_PROD_NO =", value, "othRealProdNo");
            return (Criteria) this;
        }

        public Criteria andPrintCntEqualTo(Integer value) {
            addCriterion("PRINT_CNT =", value, "printCnt");
            return (Criteria) this;
        }

        public Criteria andDealCodeEqualTo(String value) {
            addCriterion("DEAL_CODE =", value, "dealCode");
            return (Criteria) this;
        }

        public Criteria andProdNoEqualTo(String value) {
            addCriterion("PROD_NO =", value, "prodNo");
            return (Criteria) this;
        }

        public Criteria andOthBankCodeEqualTo(String value) {
            addCriterion("OTH_BANK_CODE =", value, "othBankCode");
            return (Criteria) this;
        }

        public Criteria andOthBaseAcctNoEqualTo(String value) {
            addCriterion("OTH_BASE_ACCT_NO =", value, "othBaseAcctNo");
            return (Criteria) this;
        }

        public Criteria andCashItemEqualTo(String value) {
            addCriterion("CASH_ITEM =", value, "cashItem");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("BATCH_NO =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andChannelDateEqualTo(Date value) {
            addCriterion("CHANNEL_DATE =", value, "channelDate");
            return (Criteria) this;
        }

        public Criteria andBillNoEqualTo(String value) {
            addCriterion("BILL_NO =", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoEqualTo(String value) {
            addCriterion("SEQ_NO =", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andReceiptNoEqualTo(String value) {
            addCriterion("RECEIPT_NO =", value, "receiptNo");
            return (Criteria) this;
        }

        public Criteria andOvCrossRateEqualTo(BigDecimal value) {
            addCriterion("OV_CROSS_RATE =", value, "ovCrossRate");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(String value) {
            addCriterion("CREATE_TIMESTAMP =", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andOthBranchEqualTo(String value) {
            addCriterion("OTH_BRANCH =", value, "othBranch");
            return (Criteria) this;
        }

        public Criteria andReferenceEqualTo(String value) {
            addCriterion("REFERENCE =", value, "reference");
            return (Criteria) this;
        }

        public Criteria andQuoteTypeEqualTo(String value) {
            addCriterion("QUOTE_TYPE =", value, "quoteType");
            return (Criteria) this;
        }

        public Criteria andCashSourceCountryEqualTo(String value) {
            addCriterion("CASH_SOURCE_COUNTRY =", value, "cashSourceCountry");
            return (Criteria) this;
        }

        public Criteria andAutoReversalFlagEqualTo(String value) {
            addCriterion("AUTO_REVERSAL_FLAG =", value, "autoReversalFlag");
            return (Criteria) this;
        }

        public Criteria andTranAmtEqualTo(BigDecimal value) {
            addCriterion("TRAN_AMT =", value, "tranAmt");
            return (Criteria) this;
        }

        public Criteria andGlPostedFlagEqualTo(String value) {
            addCriterion("GL_POSTED_FLAG =", value, "glPostedFlag");
            return (Criteria) this;
        }

        public Criteria andAcctClassEqualTo(String value) {
            addCriterion("ACCT_CLASS =", value, "acctClass");
            return (Criteria) this;
        }

        public Criteria andPbkUpdFlagEqualTo(String value) {
            addCriterion("PBK_UPD_FLAG =", value, "pbkUpdFlag");
            return (Criteria) this;
        }

        public Criteria andGlNoEqualTo(String value) {
            addCriterion("GL_NO =", value, "glNo");
            return (Criteria) this;
        }

        public Criteria andActualBalAmtFinEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_BAL_AMT_FIN =", value, "actualBalAmtFin");
            return (Criteria) this;
        }

        public Criteria andTranBranchEqualTo(String value) {
            addCriterion("TRAN_BRANCH =", value, "tranBranch");
            return (Criteria) this;
        }

        public Criteria andPrefixEqualTo(String value) {
            addCriterion("PREFIX =", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andCashUsePlaceCodeEqualTo(String value) {
            addCriterion("CASH_USE_PLACE_CODE =", value, "cashUsePlaceCode");
            return (Criteria) this;
        }

        public Criteria andSettlementDateEqualTo(Date value) {
            addCriterion("SETTLEMENT_DATE =", value, "settlementDate");
            return (Criteria) this;
        }

        public Criteria andFromXrateEqualTo(BigDecimal value) {
            addCriterion("FROM_XRATE =", value, "fromXrate");
            return (Criteria) this;
        }

        public Criteria andExchangeTranCodetEqualTo(String value) {
            addCriterion("EXCHANGE_TRAN_CODET =", value, "exchangeTranCodet");
            return (Criteria) this;
        }

        public Criteria andToCcyEqualTo(String value) {
            addCriterion("TO_CCY =", value, "toCcy");
            return (Criteria) this;
        }

        public Criteria andOthBankNameEqualTo(String value) {
            addCriterion("OTH_BANK_NAME =", value, "othBankName");
            return (Criteria) this;
        }

        public Criteria andInternalKeyEqualTo(Integer value) {
            addCriterion("INTERNAL_KEY =", value, "internalKey");
            return (Criteria) this;
        }

        public Criteria andOthSeqNoEqualTo(String value) {
            addCriterion("OTH_SEQ_NO =", value, "othSeqNo");
            return (Criteria) this;
        }

        public Criteria andOthRealTranAddrEqualTo(String value) {
            addCriterion("OTH_REAL_TRAN_ADDR =", value, "othRealTranAddr");
            return (Criteria) this;
        }

        public Criteria andAmtTypeEqualTo(String value) {
            addCriterion("AMT_TYPE =", value, "amtType");
            return (Criteria) this;
        }

        public Criteria andClientTypeEqualTo(String value) {
            addCriterion("CLIENT_TYPE =", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andAutoTradeFlagEqualTo(String value) {
            addCriterion("AUTO_TRADE_FLAG =", value, "autoTradeFlag");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andAcctDescEqualTo(String value) {
            addCriterion("ACCT_DESC =", value, "acctDesc");
            return (Criteria) this;
        }

        public Criteria andOthRealDocumentIdEqualTo(String value) {
            addCriterion("OTH_REAL_DOCUMENT_ID =", value, "othRealDocumentId");
            return (Criteria) this;
        }

        public Criteria andAcctTranFlagEqualTo(String value) {
            addCriterion("ACCT_TRAN_FLAG =", value, "acctTranFlag");
            return (Criteria) this;
        }

        public Criteria andAmtCalcTypeEqualTo(String value) {
            addCriterion("AMT_CALC_TYPE =", value, "amtCalcType");
            return (Criteria) this;
        }

        public Criteria andOthRealBankCodeEqualTo(String value) {
            addCriterion("OTH_REAL_BANK_CODE =", value, "othRealBankCode");
            return (Criteria) this;
        }

        public Criteria andLcyTranAmtEqualTo(BigDecimal value) {
            addCriterion("LCY_TRAN_AMT =", value, "lcyTranAmt");
            return (Criteria) this;
        }

        public Criteria andOthAcctCcyEqualTo(String value) {
            addCriterion("OTH_ACCT_CCY =", value, "othAcctCcy");
            return (Criteria) this;
        }

        public Criteria andSendSystemEqualTo(String value) {
            addCriterion("SEND_SYSTEM =", value, "sendSystem");
            return (Criteria) this;
        }

        public Criteria andOthProdNoEqualTo(String value) {
            addCriterion("OTH_PROD_NO =", value, "othProdNo");
            return (Criteria) this;
        }

        public Criteria andTackOverCcyRateOneEqualTo(BigDecimal value) {
            addCriterion("TACK_OVER_CCY_RATE_ONE =", value, "tackOverCcyRateOne");
            return (Criteria) this;
        }

        public Criteria andOthAcctSeqNoEqualTo(String value) {
            addCriterion("OTH_ACCT_SEQ_NO =", value, "othAcctSeqNo");
            return (Criteria) this;
        }

        public Criteria andAccountingStatusEqualTo(String value) {
            addCriterion("ACCOUNTING_STATUS =", value, "accountingStatus");
            return (Criteria) this;
        }

        public Criteria andSubSeqNoEqualTo(String value) {
            addCriterion("SUB_SEQ_NO =", value, "subSeqNo");
            return (Criteria) this;
        }

        public Criteria andOthTranAddrEqualTo(String value) {
            addCriterion("OTH_TRAN_ADDR =", value, "othTranAddr");
            return (Criteria) this;
        }

        public Criteria andNarrativeCodeEqualTo(String value) {
            addCriterion("NARRATIVE_CODE =", value, "narrativeCode");
            return (Criteria) this;
        }

        public Criteria andTranDateEqualTo(Date value) {
            addCriterion("TRAN_DATE =", value, "tranDate");
            return (Criteria) this;
        }

        public Criteria andBaseEquivAmtEqualTo(BigDecimal value) {
            addCriterion("BASE_EQUIV_AMT =", value, "baseEquivAmt");
            return (Criteria) this;
        }

        public Criteria andCcyEqualTo(String value) {
            addCriterion("CCY =", value, "ccy");
            return (Criteria) this;
        }

        public Criteria andBaseAcctNoEqualTo(String value) {
            addCriterion("BASE_ACCT_NO =", value, "baseAcctNo");
            return (Criteria) this;
        }

        public Criteria andPayUnitEqualTo(String value) {
            addCriterion("PAY_UNIT =", value, "payUnit");
            return (Criteria) this;
        }

        public Criteria andOthRealBankNameEqualTo(String value) {
            addCriterion("OTH_REAL_BANK_NAME =", value, "othRealBankName");
            return (Criteria) this;
        }

        public Criteria andRemainTermEqualTo(String value) {
            addCriterion("REMAIN_TERM =", value, "remainTerm");
            return (Criteria) this;
        }

        public Criteria andFromCcyEqualTo(String value) {
            addCriterion("FROM_CCY =", value, "fromCcy");
            return (Criteria) this;
        }

        public Criteria andReversalSeqNoEqualTo(String value) {
            addCriterion("REVERSAL_SEQ_NO =", value, "reversalSeqNo");
            return (Criteria) this;
        }

        public Criteria andTranDescEqualTo(String value) {
            addCriterion("TRAN_DESC =", value, "tranDesc");
            return (Criteria) this;
        }

        public Criteria andMediumTypeEqualTo(String value) {
            addCriterion("MEDIUM_TYPE =", value, "mediumType");
            return (Criteria) this;
        }

        public Criteria andCrDrIndEqualTo(String value) {
            addCriterion("CR_DR_IND =", value, "crDrInd");
            return (Criteria) this;
        }

        public Criteria andToAmountEqualTo(BigDecimal value) {
            addCriterion("TO_AMOUNT =", value, "toAmount");
            return (Criteria) this;
        }

        public Criteria andDocumentIdEqualTo(String value) {
            addCriterion("DOCUMENT_ID =", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andTranStatusEqualTo(String value) {
            addCriterion("TRAN_STATUS =", value, "tranStatus");
            return (Criteria) this;
        }

        public Criteria andDocTypeEqualTo(String value) {
            addCriterion("DOC_TYPE =", value, "docType");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTypeEqualTo(String value) {
            addCriterion("WITHDRAWAL_TYPE =", value, "withdrawalType");
            return (Criteria) this;
        }

        public Criteria andOthInternalKeyEqualTo(Integer value) {
            addCriterion("OTH_INTERNAL_KEY =", value, "othInternalKey");
            return (Criteria) this;
        }

        public Criteria andContraTranDateEqualTo(Date value) {
            addCriterion("CONTRA_TRAN_DATE =", value, "contraTranDate");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(String value) {
            addCriterion("PRIORITY =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andFlatRateEqualTo(BigDecimal value) {
            addCriterion("FLAT_RATE =", value, "flatRate");
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