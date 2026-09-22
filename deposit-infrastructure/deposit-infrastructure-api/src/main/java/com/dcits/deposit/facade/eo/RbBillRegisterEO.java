package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.BillBusiType;
import com.dcits.deposit.enums.BillIssueType;
import com.dcits.deposit.enums.BillPaymentStatus;
import com.dcits.deposit.enums.BillStatus;
import com.dcits.deposit.enums.BillType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.ReturnType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbBillRegisterEO {
    /** 票据业务编号 */
    @NotNull
    private String billSerialNo;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 票据号码 */
    private String billNo;
    /** 票据业务类型 */
    private BillBusiType billBusiType;
    /** 票据类型 */
    private BillType billType;
    /** 票据状态 */
    private BillStatus billStatus;
    /** 票据前缀编码 */
    private String billPrefix;
    /** 票据凭证号 */
    private String billVoucherNo;
    /** 凭证类型 */
    private DocType docType;
    /** 凭证种类 */
    private DocClass docClass;
    /** 提示日期 */
    private java.util.Date promptDate;
    /** 结算日期 */
    private java.util.Date settleDate;
    /** 票据密钥 */
    private String encryptKey;
    /** 票据申请书类型 */
    private String billApplyType;
    /** 本票申请书号码 */
    private String billApplyNo;
    /** 本票申请书前缀编码 */
    private String billApplyPrefix;
    /** 票据申请书日期 */
    private java.util.Date billApplyDate;
    /** 票据签发金额 */
    private BigDecimal billIssueAmt;
    /** 票据签发币种 */
    private AcctCcy billIssueCcy;
    /** 票据签发方式 */
    private BillIssueType billIssueType;
    /** 票据签发行行号 */
    private String billIssueBankNo;
    /** 票据签发行行名 */
    private String billIssueBankName;
    /** 票据签发时间 */
    private java.util.Date billIssueDate;
    /** 票据签发现金项目代码 */
    private String billIssueCashItem;
    /** 票据签发机构 */
    private AcctBranch billIssueBranch;
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
    private BillPaymentStatus billPaymentStatus;
    /** 票据兑付金额 */
    private BigDecimal billPaymentAmt;
    /** 本汇票多余资金未兑付金额 */
    private BigDecimal excessAmt;
    /** 银承兑付类型 */
    private BillIssueType paymentType;
    /** 兑付日期 */
    private java.util.Date paymentDate;
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
    private AcctCcy payerAcctCcy;
    /** 付款账户产品编号 */
    private String payerAcctProdType;
    /** 付款人账户序号 */
    private String payerAcctSeqNo;
    /** 付款人证件号码 */
    private String payerDocumentId;
    /** 付款人证件类型 */
    private DocumentType payerDocumentType;
    /** 付款人地址 */
    private String payerAddr;
    /** 付款人机构号 */
    private AcctBranch payerBankCode;
    /** 收款人账号 */
    private String payeeBaseAcctNo;
    /** 收款人账户序号 */
    private String payeeAcctSeqNo;
    /** 收款人产品编号 */
    private String payeeProdType;
    /** 收款人账户币种 */
    private AcctCcy payeeAcctCcy;
    /** 收款人账户名称 */
    private String payeeAcctName;
    /** 收款人地址 */
    private String payeeAddr;
    /** 收款人证件类型 */
    private DocumentType payeeDocumentType;
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
    private DocumentType returnDocumentType;
    /** 退票行行号 */
    private String refundBankNo;
    /** 退回现金项目代码 */
    private String returnCashItem;
    /** 本汇票退回方式 */
    private ReturnType returnType;
    /** 本汇票退回柜员号 */
    private String returnUser;
    /** 本汇票退回日期 */
    private java.util.Date returnDate;
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
    private Company company;
    /** 上一交易日期 */
    private java.util.Date lastTranDate;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;

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

    public BillBusiType getBillBusiType() {
        return billBusiType;
    }

    public void setBillBusiType(BillBusiType billBusiType) {
        this.billBusiType = billBusiType;
    }

    public BillType getBillType() {
        return billType;
    }

    public void setBillType(BillType billType) {
        this.billType = billType;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
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

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public DocClass getDocClass() {
        return docClass;
    }

    public void setDocClass(DocClass docClass) {
        this.docClass = docClass;
    }

    public java.util.Date getPromptDate() {
        return promptDate;
    }

    public void setPromptDate(java.util.Date promptDate) {
        this.promptDate = promptDate;
    }

    public java.util.Date getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(java.util.Date settleDate) {
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

    public java.util.Date getBillApplyDate() {
        return billApplyDate;
    }

    public void setBillApplyDate(java.util.Date billApplyDate) {
        this.billApplyDate = billApplyDate;
    }

    public BigDecimal getBillIssueAmt() {
        return billIssueAmt;
    }

    public void setBillIssueAmt(BigDecimal billIssueAmt) {
        this.billIssueAmt = billIssueAmt;
    }

    public AcctCcy getBillIssueCcy() {
        return billIssueCcy;
    }

    public void setBillIssueCcy(AcctCcy billIssueCcy) {
        this.billIssueCcy = billIssueCcy;
    }

    public BillIssueType getBillIssueType() {
        return billIssueType;
    }

    public void setBillIssueType(BillIssueType billIssueType) {
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

    public java.util.Date getBillIssueDate() {
        return billIssueDate;
    }

    public void setBillIssueDate(java.util.Date billIssueDate) {
        this.billIssueDate = billIssueDate;
    }

    public String getBillIssueCashItem() {
        return billIssueCashItem;
    }

    public void setBillIssueCashItem(String billIssueCashItem) {
        this.billIssueCashItem = billIssueCashItem;
    }

    public AcctBranch getBillIssueBranch() {
        return billIssueBranch;
    }

    public void setBillIssueBranch(AcctBranch billIssueBranch) {
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

    public BillPaymentStatus getBillPaymentStatus() {
        return billPaymentStatus;
    }

    public void setBillPaymentStatus(BillPaymentStatus billPaymentStatus) {
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

    public BillIssueType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(BillIssueType paymentType) {
        this.paymentType = paymentType;
    }

    public java.util.Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(java.util.Date paymentDate) {
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

    public AcctCcy getPayerAcctCcy() {
        return payerAcctCcy;
    }

    public void setPayerAcctCcy(AcctCcy payerAcctCcy) {
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

    public DocumentType getPayerDocumentType() {
        return payerDocumentType;
    }

    public void setPayerDocumentType(DocumentType payerDocumentType) {
        this.payerDocumentType = payerDocumentType;
    }

    public String getPayerAddr() {
        return payerAddr;
    }

    public void setPayerAddr(String payerAddr) {
        this.payerAddr = payerAddr;
    }

    public AcctBranch getPayerBankCode() {
        return payerBankCode;
    }

    public void setPayerBankCode(AcctBranch payerBankCode) {
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

    public AcctCcy getPayeeAcctCcy() {
        return payeeAcctCcy;
    }

    public void setPayeeAcctCcy(AcctCcy payeeAcctCcy) {
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

    public DocumentType getPayeeDocumentType() {
        return payeeDocumentType;
    }

    public void setPayeeDocumentType(DocumentType payeeDocumentType) {
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

    public DocumentType getReturnDocumentType() {
        return returnDocumentType;
    }

    public void setReturnDocumentType(DocumentType returnDocumentType) {
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

    public ReturnType getReturnType() {
        return returnType;
    }

    public void setReturnType(ReturnType returnType) {
        this.returnType = returnType;
    }

    public String getReturnUser() {
        return returnUser;
    }

    public void setReturnUser(String returnUser) {
        this.returnUser = returnUser;
    }

    public java.util.Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(java.util.Date returnDate) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public java.util.Date getLastTranDate() {
        return lastTranDate;
    }

    public void setLastTranDate(java.util.Date lastTranDate) {
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

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}