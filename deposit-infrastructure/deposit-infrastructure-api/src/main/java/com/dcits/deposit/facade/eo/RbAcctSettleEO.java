package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.BankInOut;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.PayRecInd;
import com.dcits.deposit.enums.SettleAcctClass;
import com.dcits.deposit.enums.SettleBankFlag;
import com.dcits.deposit.enums.SettleMethod;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbAcctSettleEO {
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 结算编号 */
    @NotNull
    private String settleNo;
    /** 限制编号 */
    private String resSeqNo;
    /** 事件类型 */
    private String eventType;
    /** 交易参考号 */
    private String reference;
    /** 结算账户类型 */
    private SettleAcctClass settleAcctClass;
    /** 结算方法 */
    private SettleMethod settleMethod;
    /** 收付款标志 */
    private PayRecInd payRecInd;
    /** 金额类型 */
    private AmtType amtType;
    /** 结算客户号 */
    private String settleClient;
    /** 银行内外标志 */
    private BankInOut bankInOut;
    /** 结算账户行内外标识 */
    private SettleBankFlag settleBankFlag;
    /** 清算行名称 */
    private String settleBankName;
    /** 结算账户内部键值 */
    private Integer settleAcctInternalKey;
    /** 结算账号 */
    private String settleBaseAcctNo;
    /** 结算账户产品类型 */
    private String settleProdType;
    /** 交易账号币种 */
    private AcctCcy settleAcctCcy;
    /** 交易账号序号 */
    private String settleAcctSeqNo;
    /** 交易账户名称 */
    private String settleAcctName;
    /** 结算账户电话号码 */
    private String settleMobilePhone;
    /** 清算机构号 */
    private AcctBranch settleBranch;
    /** 结算比重 */
    private BigDecimal settleWeight;
    /** 结算币种 */
    private AcctCcy settleCcy;
    /** 结算金额 */
    private BigDecimal settleAmt;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 交易柜员号 */
    private String userId;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** DAC值防篡改加密 */
    private String dacValue;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 开户银行金融机构编码 */
    private String bindAcctBranch;
    /** 创建日期 */
    private java.util.Date createDate;
    /** 创建时间戳 */
    private String createTimestamp;

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getSettleNo() {
        return settleNo;
    }

    public void setSettleNo(String settleNo) {
        this.settleNo = settleNo;
    }

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public SettleAcctClass getSettleAcctClass() {
        return settleAcctClass;
    }

    public void setSettleAcctClass(SettleAcctClass settleAcctClass) {
        this.settleAcctClass = settleAcctClass;
    }

    public SettleMethod getSettleMethod() {
        return settleMethod;
    }

    public void setSettleMethod(SettleMethod settleMethod) {
        this.settleMethod = settleMethod;
    }

    public PayRecInd getPayRecInd() {
        return payRecInd;
    }

    public void setPayRecInd(PayRecInd payRecInd) {
        this.payRecInd = payRecInd;
    }

    public AmtType getAmtType() {
        return amtType;
    }

    public void setAmtType(AmtType amtType) {
        this.amtType = amtType;
    }

    public String getSettleClient() {
        return settleClient;
    }

    public void setSettleClient(String settleClient) {
        this.settleClient = settleClient;
    }

    public BankInOut getBankInOut() {
        return bankInOut;
    }

    public void setBankInOut(BankInOut bankInOut) {
        this.bankInOut = bankInOut;
    }

    public SettleBankFlag getSettleBankFlag() {
        return settleBankFlag;
    }

    public void setSettleBankFlag(SettleBankFlag settleBankFlag) {
        this.settleBankFlag = settleBankFlag;
    }

    public String getSettleBankName() {
        return settleBankName;
    }

    public void setSettleBankName(String settleBankName) {
        this.settleBankName = settleBankName;
    }

    public Integer getSettleAcctInternalKey() {
        return settleAcctInternalKey;
    }

    public void setSettleAcctInternalKey(Integer settleAcctInternalKey) {
        this.settleAcctInternalKey = settleAcctInternalKey;
    }

    public String getSettleBaseAcctNo() {
        return settleBaseAcctNo;
    }

    public void setSettleBaseAcctNo(String settleBaseAcctNo) {
        this.settleBaseAcctNo = settleBaseAcctNo;
    }

    public String getSettleProdType() {
        return settleProdType;
    }

    public void setSettleProdType(String settleProdType) {
        this.settleProdType = settleProdType;
    }

    public AcctCcy getSettleAcctCcy() {
        return settleAcctCcy;
    }

    public void setSettleAcctCcy(AcctCcy settleAcctCcy) {
        this.settleAcctCcy = settleAcctCcy;
    }

    public String getSettleAcctSeqNo() {
        return settleAcctSeqNo;
    }

    public void setSettleAcctSeqNo(String settleAcctSeqNo) {
        this.settleAcctSeqNo = settleAcctSeqNo;
    }

    public String getSettleAcctName() {
        return settleAcctName;
    }

    public void setSettleAcctName(String settleAcctName) {
        this.settleAcctName = settleAcctName;
    }

    public String getSettleMobilePhone() {
        return settleMobilePhone;
    }

    public void setSettleMobilePhone(String settleMobilePhone) {
        this.settleMobilePhone = settleMobilePhone;
    }

    public AcctBranch getSettleBranch() {
        return settleBranch;
    }

    public void setSettleBranch(AcctBranch settleBranch) {
        this.settleBranch = settleBranch;
    }

    public BigDecimal getSettleWeight() {
        return settleWeight;
    }

    public void setSettleWeight(BigDecimal settleWeight) {
        this.settleWeight = settleWeight;
    }

    public AcctCcy getSettleCcy() {
        return settleCcy;
    }

    public void setSettleCcy(AcctCcy settleCcy) {
        this.settleCcy = settleCcy;
    }

    public BigDecimal getSettleAmt() {
        return settleAmt;
    }

    public void setSettleAmt(BigDecimal settleAmt) {
        this.settleAmt = settleAmt;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getLastChangeUserId() {
        return lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
    }

    public String getDacValue() {
        return dacValue;
    }

    public void setDacValue(String dacValue) {
        this.dacValue = dacValue;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getBindAcctBranch() {
        return bindAcctBranch;
    }

    public void setBindAcctBranch(String bindAcctBranch) {
        this.bindAcctBranch = bindAcctBranch;
    }

    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}