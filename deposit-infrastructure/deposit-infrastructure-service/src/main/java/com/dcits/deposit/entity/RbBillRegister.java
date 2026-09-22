package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbBillRegister {
    /** 票据业务编号 */
    private String billSerialNo;
    /** 客户号 */
    private String clientNo;
    /** 票据号码 */
    private String billNo;
    /** 票据业务类型 */
    private String billBusiType;
    /** 票据类型 */
    private String billType;
    /** 票据状态 */
    private String billStatus;
    /** 票据前缀编码 */
    private String billPrefix;
    /** 票据凭证号 */
    private String billVoucherNo;
    /** 凭证类型 */
    private String docType;
    /** 凭证种类 */
    private String docClass;
    /** 提示日期 */
    private Date promptDate;
    /** 结算日期 */
    private Date settleDate;
    /** 票据密钥 */
    private String encryptKey;
    /** 票据申请书类型 */
    private String billApplyType;
    /** 本票申请书号码 */
    private String billApplyNo;
    /** 本票申请书前缀编码 */
    private String billApplyPrefix;
    /** 票据申请书日期 */
    private Date billApplyDate;
    /** 票据签发金额 */
    private BigDecimal billIssueAmt;
    /** 票据签发币种 */
    private String billIssueCcy;
    /** 票据签发方式 */
    private String billIssueType;
    /** 票据签发行行号 */
    private String billIssueBankNo;
    /** 票据签发行行名 */
    private String billIssueBankName;
    /** 票据签发时间 */
    private Date billIssueDate;
    /** 票据签发现金项目代码 */
    private String billIssueCashItem;
    /** 票据签发机构 */
    private String billIssueBranch;
    /** 票据签发柜员 */
    private String billIssueUserId;
    /** 现金凭证预约复核柜员号 */
    private String apprUserId;
    /** 授权柜员号 */
    private String authUserId;
    /** 打印次数 */
    private Integer printCnt;
    /** 代理付款行行号 */
    private String agentPayerBankNo;
    /** 代理付款行行名 */
    private String agentPayerBankName;
    /** 票据兑付状态 */
    private String billPaymentStatus;
    /** 票据兑付金额 */
    private BigDecimal billPaymentAmt;
    /** 本汇票多余资金未兑付金额 */
    private BigDecimal excessAmt;
    /** 银承兑付类型 */
    private String paymentType;
    /** 兑付日期 */
    private Date paymentDate;
    /** 兑付现金项目代码 */
    private String paymentCashItem;
    /** 兑付行行号 */
    private String paymentBankNo;
    /** 兑付行名称 */
    private String paymentBankName;
    /** 付款人账号 */
    private String payerBaseAcctNo;
    /** 付款行名称 */
    private String payerBankName;
    /** 付款人账户名称 */
    private String payerAcctName;
    /** 付款账户币种 */
    private String payerAcctCcy;
    /** 付款账户产品编号 */
    private String payerAcctProdType;
    /** 付款人账户序号 */
    private String payerAcctSeqNo;
    /** 付款人证件号码 */
    private String payerDocumentId;
    /** 付款人证件类型 */
    private String payerDocumentType;
    /** 付款人地址 */
    private String payerAddr;
    /** 付款人机构号 */
    private String payerBankCode;
    /** 收款人账号 */
    private String payeeBaseAcctNo;
    /** 收款人账户序号 */
    private String payeeAcctSeqNo;
    /** 收款人产品编号 */
    private String payeeProdType;
    /** 收款人账户币种 */
    private String payeeAcctCcy;
    /** 收款人账户名称 */
    private String payeeAcctName;
    /** 收款人地址 */
    private String payeeAddr;
    /** 收款人证件类型 */
    private String payeeDocumentType;
    /** 收款人证件号码 */
    private String payeeDocumentId;
    /** 收款行行号 */
    private String payeeBankCode;
    /** 收款行名称 */
    private String payeeBankName;
    /** 本汇票退回账号 */
    private String returnBaseAcctNo;
    /** 本汇票退回账户名称 */
    private String returnAcctName;
    /** 退回证件号码 */
    private String returnDocumentId;
    /** 退回证件类型 */
    private String returnDocumentType;
    /** 退票行行号 */
    private String refundBankNo;
    /** 退回现金项目代码 */
    private String returnCashItem;
    /** 本汇票退回方式 */
    private String returnType;
    /** 本汇票退回柜员号 */
    private String returnUser;
    /** 本汇票退回日期 */
    private Date returnDate;
    /** 最后持票人名称 */
    private String lastHolderName;
    /** 最后持票人账号 */
    private String lastHolderBaseAcctNo;
    /** 最后持票人开户行行号 */
    private String lastHolderBankCode;
    /** 最后持票人开户行名称 */
    private String lastHolderBankName;
    /** 备注 */
    private String remark;
    /** 法人 */
    private String company;
    /** 上一交易日期 */
    private Date lastTranDate;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;

    public String getBillSerialNo() {
        return billSerialNo;
    }

    public void setBillSerialNo(String billSerialNo) {
        this.billSerialNo = billSerialNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getBillBusiType() {
        return billBusiType;
    }

    public void setBillBusiType(String billBusiType) {
        this.billBusiType = billBusiType;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getBillPrefix() {
        return billPrefix;
    }

    public void setBillPrefix(String billPrefix) {
        this.billPrefix = billPrefix;
    }

    public String getBillVoucherNo() {
        return billVoucherNo;
    }

    public void setBillVoucherNo(String billVoucherNo) {
        this.billVoucherNo = billVoucherNo;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocClass() {
        return docClass;
    }

    public void setDocClass(String docClass) {
        this.docClass = docClass;
    }

    public Date getPromptDate() {
        return promptDate;
    }

    public void setPromptDate(Date promptDate) {
        this.promptDate = promptDate;
    }

    public Date getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public String getBillApplyType() {
        return billApplyType;
    }

    public void setBillApplyType(String billApplyType) {
        this.billApplyType = billApplyType;
    }

    public String getBillApplyNo() {
        return billApplyNo;
    }

    public void setBillApplyNo(String billApplyNo) {
        this.billApplyNo = billApplyNo;
    }

    public String getBillApplyPrefix() {
        return billApplyPrefix;
    }

    public void setBillApplyPrefix(String billApplyPrefix) {
        this.billApplyPrefix = billApplyPrefix;
    }

    public Date getBillApplyDate() {
        return billApplyDate;
    }

    public void setBillApplyDate(Date billApplyDate) {
        this.billApplyDate = billApplyDate;
    }

    public BigDecimal getBillIssueAmt() {
        return billIssueAmt;
    }

    public void setBillIssueAmt(BigDecimal billIssueAmt) {
        this.billIssueAmt = billIssueAmt;
    }

    public String getBillIssueCcy() {
        return billIssueCcy;
    }

    public void setBillIssueCcy(String billIssueCcy) {
        this.billIssueCcy = billIssueCcy;
    }

    public String getBillIssueType() {
        return billIssueType;
    }

    public void setBillIssueType(String billIssueType) {
        this.billIssueType = billIssueType;
    }

    public String getBillIssueBankNo() {
        return billIssueBankNo;
    }

    public void setBillIssueBankNo(String billIssueBankNo) {
        this.billIssueBankNo = billIssueBankNo;
    }

    public String getBillIssueBankName() {
        return billIssueBankName;
    }

    public void setBillIssueBankName(String billIssueBankName) {
        this.billIssueBankName = billIssueBankName;
    }

    public Date getBillIssueDate() {
        return billIssueDate;
    }

    public void setBillIssueDate(Date billIssueDate) {
        this.billIssueDate = billIssueDate;
    }

    public String getBillIssueCashItem() {
        return billIssueCashItem;
    }

    public void setBillIssueCashItem(String billIssueCashItem) {
        this.billIssueCashItem = billIssueCashItem;
    }

    public String getBillIssueBranch() {
        return billIssueBranch;
    }

    public void setBillIssueBranch(String billIssueBranch) {
        this.billIssueBranch = billIssueBranch;
    }

    public String getBillIssueUserId() {
        return billIssueUserId;
    }

    public void setBillIssueUserId(String billIssueUserId) {
        this.billIssueUserId = billIssueUserId;
    }

    public String getApprUserId() {
        return apprUserId;
    }

    public void setApprUserId(String apprUserId) {
        this.apprUserId = apprUserId;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    public Integer getPrintCnt() {
        return printCnt;
    }

    public void setPrintCnt(Integer printCnt) {
        this.printCnt = printCnt;
    }

    public String getAgentPayerBankNo() {
        return agentPayerBankNo;
    }

    public void setAgentPayerBankNo(String agentPayerBankNo) {
        this.agentPayerBankNo = agentPayerBankNo;
    }

    public String getAgentPayerBankName() {
        return agentPayerBankName;
    }

    public void setAgentPayerBankName(String agentPayerBankName) {
        this.agentPayerBankName = agentPayerBankName;
    }

    public String getBillPaymentStatus() {
        return billPaymentStatus;
    }

    public void setBillPaymentStatus(String billPaymentStatus) {
        this.billPaymentStatus = billPaymentStatus;
    }

    public BigDecimal getBillPaymentAmt() {
        return billPaymentAmt;
    }

    public void setBillPaymentAmt(BigDecimal billPaymentAmt) {
        this.billPaymentAmt = billPaymentAmt;
    }

    public BigDecimal getExcessAmt() {
        return excessAmt;
    }

    public void setExcessAmt(BigDecimal excessAmt) {
        this.excessAmt = excessAmt;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentCashItem() {
        return paymentCashItem;
    }

    public void setPaymentCashItem(String paymentCashItem) {
        this.paymentCashItem = paymentCashItem;
    }

    public String getPaymentBankNo() {
        return paymentBankNo;
    }

    public void setPaymentBankNo(String paymentBankNo) {
        this.paymentBankNo = paymentBankNo;
    }

    public String getPaymentBankName() {
        return paymentBankName;
    }

    public void setPaymentBankName(String paymentBankName) {
        this.paymentBankName = paymentBankName;
    }

    public String getPayerBaseAcctNo() {
        return payerBaseAcctNo;
    }

    public void setPayerBaseAcctNo(String payerBaseAcctNo) {
        this.payerBaseAcctNo = payerBaseAcctNo;
    }

    public String getPayerBankName() {
        return payerBankName;
    }

    public void setPayerBankName(String payerBankName) {
        this.payerBankName = payerBankName;
    }

    public String getPayerAcctName() {
        return payerAcctName;
    }

    public void setPayerAcctName(String payerAcctName) {
        this.payerAcctName = payerAcctName;
    }

    public String getPayerAcctCcy() {
        return payerAcctCcy;
    }

    public void setPayerAcctCcy(String payerAcctCcy) {
        this.payerAcctCcy = payerAcctCcy;
    }

    public String getPayerAcctProdType() {
        return payerAcctProdType;
    }

    public void setPayerAcctProdType(String payerAcctProdType) {
        this.payerAcctProdType = payerAcctProdType;
    }

    public String getPayerAcctSeqNo() {
        return payerAcctSeqNo;
    }

    public void setPayerAcctSeqNo(String payerAcctSeqNo) {
        this.payerAcctSeqNo = payerAcctSeqNo;
    }

    public String getPayerDocumentId() {
        return payerDocumentId;
    }

    public void setPayerDocumentId(String payerDocumentId) {
        this.payerDocumentId = payerDocumentId;
    }

    public String getPayerDocumentType() {
        return payerDocumentType;
    }

    public void setPayerDocumentType(String payerDocumentType) {
        this.payerDocumentType = payerDocumentType;
    }

    public String getPayerAddr() {
        return payerAddr;
    }

    public void setPayerAddr(String payerAddr) {
        this.payerAddr = payerAddr;
    }

    public String getPayerBankCode() {
        return payerBankCode;
    }

    public void setPayerBankCode(String payerBankCode) {
        this.payerBankCode = payerBankCode;
    }

    public String getPayeeBaseAcctNo() {
        return payeeBaseAcctNo;
    }

    public void setPayeeBaseAcctNo(String payeeBaseAcctNo) {
        this.payeeBaseAcctNo = payeeBaseAcctNo;
    }

    public String getPayeeAcctSeqNo() {
        return payeeAcctSeqNo;
    }

    public void setPayeeAcctSeqNo(String payeeAcctSeqNo) {
        this.payeeAcctSeqNo = payeeAcctSeqNo;
    }

    public String getPayeeProdType() {
        return payeeProdType;
    }

    public void setPayeeProdType(String payeeProdType) {
        this.payeeProdType = payeeProdType;
    }

    public String getPayeeAcctCcy() {
        return payeeAcctCcy;
    }

    public void setPayeeAcctCcy(String payeeAcctCcy) {
        this.payeeAcctCcy = payeeAcctCcy;
    }

    public String getPayeeAcctName() {
        return payeeAcctName;
    }

    public void setPayeeAcctName(String payeeAcctName) {
        this.payeeAcctName = payeeAcctName;
    }

    public String getPayeeAddr() {
        return payeeAddr;
    }

    public void setPayeeAddr(String payeeAddr) {
        this.payeeAddr = payeeAddr;
    }

    public String getPayeeDocumentType() {
        return payeeDocumentType;
    }

    public void setPayeeDocumentType(String payeeDocumentType) {
        this.payeeDocumentType = payeeDocumentType;
    }

    public String getPayeeDocumentId() {
        return payeeDocumentId;
    }

    public void setPayeeDocumentId(String payeeDocumentId) {
        this.payeeDocumentId = payeeDocumentId;
    }

    public String getPayeeBankCode() {
        return payeeBankCode;
    }

    public void setPayeeBankCode(String payeeBankCode) {
        this.payeeBankCode = payeeBankCode;
    }

    public String getPayeeBankName() {
        return payeeBankName;
    }

    public void setPayeeBankName(String payeeBankName) {
        this.payeeBankName = payeeBankName;
    }

    public String getReturnBaseAcctNo() {
        return returnBaseAcctNo;
    }

    public void setReturnBaseAcctNo(String returnBaseAcctNo) {
        this.returnBaseAcctNo = returnBaseAcctNo;
    }

    public String getReturnAcctName() {
        return returnAcctName;
    }

    public void setReturnAcctName(String returnAcctName) {
        this.returnAcctName = returnAcctName;
    }

    public String getReturnDocumentId() {
        return returnDocumentId;
    }

    public void setReturnDocumentId(String returnDocumentId) {
        this.returnDocumentId = returnDocumentId;
    }

    public String getReturnDocumentType() {
        return returnDocumentType;
    }

    public void setReturnDocumentType(String returnDocumentType) {
        this.returnDocumentType = returnDocumentType;
    }

    public String getRefundBankNo() {
        return refundBankNo;
    }

    public void setRefundBankNo(String refundBankNo) {
        this.refundBankNo = refundBankNo;
    }

    public String getReturnCashItem() {
        return returnCashItem;
    }

    public void setReturnCashItem(String returnCashItem) {
        this.returnCashItem = returnCashItem;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnUser() {
        return returnUser;
    }

    public void setReturnUser(String returnUser) {
        this.returnUser = returnUser;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getLastHolderName() {
        return lastHolderName;
    }

    public void setLastHolderName(String lastHolderName) {
        this.lastHolderName = lastHolderName;
    }

    public String getLastHolderBaseAcctNo() {
        return lastHolderBaseAcctNo;
    }

    public void setLastHolderBaseAcctNo(String lastHolderBaseAcctNo) {
        this.lastHolderBaseAcctNo = lastHolderBaseAcctNo;
    }

    public String getLastHolderBankCode() {
        return lastHolderBankCode;
    }

    public void setLastHolderBankCode(String lastHolderBankCode) {
        this.lastHolderBankCode = lastHolderBankCode;
    }

    public String getLastHolderBankName() {
        return lastHolderBankName;
    }

    public void setLastHolderBankName(String lastHolderBankName) {
        this.lastHolderBankName = lastHolderBankName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getLastTranDate() {
        return lastTranDate;
    }

    public void setLastTranDate(Date lastTranDate) {
        this.lastTranDate = lastTranDate;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}