package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbAcctSettle {
    /** 账户内部键值 */
    private Integer internalKey;
    /** 结算编号 */
    private String settleNo;
    /** 限制编号 */
    private String resSeqNo;
    /** 事件类型 */
    private String eventType;
    /** 交易参考号 */
    private String reference;
    /** 结算账户类型 */
    private String settleAcctClass;
    /** 结算方法 */
    private String settleMethod;
    /** 收付款标志 */
    private String payRecInd;
    /** 金额类型 */
    private String amtType;
    /** 结算客户号 */
    private String settleClient;
    /** 银行内外标志 */
    private String bankInOut;
    /** 结算账户行内外标识 */
    private String settleBankFlag;
    /** 清算行名称 */
    private String settleBankName;
    /** 结算账户内部键值 */
    private Integer settleAcctInternalKey;
    /** 结算账号 */
    private String settleBaseAcctNo;
    /** 结算账户产品类型 */
    private String settleProdType;
    /** 交易账号币种 */
    private String settleAcctCcy;
    /** 交易账号序号 */
    private String settleAcctSeqNo;
    /** 交易账户名称 */
    private String settleAcctName;
    /** 结算账户电话号码 */
    private String settleMobilePhone;
    /** 清算机构号 */
    private String settleBranch;
    /** 结算比重 */
    private BigDecimal settleWeight;
    /** 结算币种 */
    private String settleCcy;
    /** 结算金额 */
    private BigDecimal settleAmt;
    /** 客户号 */
    private String clientNo;
    /** 交易柜员号 */
    private String userId;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** DAC值防篡改加密 */
    private String dacValue;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 开户银行金融机构编码 */
    private String bindAcctBranch;
    /** 创建日期 */
    private Date createDate;
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

    public String getSettleAcctClass() {
        return settleAcctClass;
    }

    public void setSettleAcctClass(String settleAcctClass) {
        this.settleAcctClass = settleAcctClass;
    }

    public String getSettleMethod() {
        return settleMethod;
    }

    public void setSettleMethod(String settleMethod) {
        this.settleMethod = settleMethod;
    }

    public String getPayRecInd() {
        return payRecInd;
    }

    public void setPayRecInd(String payRecInd) {
        this.payRecInd = payRecInd;
    }

    public String getAmtType() {
        return amtType;
    }

    public void setAmtType(String amtType) {
        this.amtType = amtType;
    }

    public String getSettleClient() {
        return settleClient;
    }

    public void setSettleClient(String settleClient) {
        this.settleClient = settleClient;
    }

    public String getBankInOut() {
        return bankInOut;
    }

    public void setBankInOut(String bankInOut) {
        this.bankInOut = bankInOut;
    }

    public String getSettleBankFlag() {
        return settleBankFlag;
    }

    public void setSettleBankFlag(String settleBankFlag) {
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

    public String getSettleAcctCcy() {
        return settleAcctCcy;
    }

    public void setSettleAcctCcy(String settleAcctCcy) {
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

    public String getSettleBranch() {
        return settleBranch;
    }

    public void setSettleBranch(String settleBranch) {
        this.settleBranch = settleBranch;
    }

    public BigDecimal getSettleWeight() {
        return settleWeight;
    }

    public void setSettleWeight(BigDecimal settleWeight) {
        this.settleWeight = settleWeight;
    }

    public String getSettleCcy() {
        return settleCcy;
    }

    public void setSettleCcy(String settleCcy) {
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

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBindAcctBranch() {
        return bindAcctBranch;
    }

    public void setBindAcctBranch(String bindAcctBranch) {
        this.bindAcctBranch = bindAcctBranch;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}