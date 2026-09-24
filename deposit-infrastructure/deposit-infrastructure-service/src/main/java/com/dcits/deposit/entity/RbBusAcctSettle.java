package com.dcits.deposit.entity;

public class RbBusAcctSettle {
    /** 收付款标志 */
    private String payRecInd;
    /** 结算账户行内外标识 */
    private String settleBankFlag;
    /** 交易参考号 */
    private String reference;
    /** 结算币种 */
    private String settleCcy;
    /** 银行内外标志 */
    private String bankInOut;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 金额类型 */
    private String amtType;
    /** 结算账户类型 */
    private String settleAcctClass;
    /** 结算方法 */
    private String settleMethod;
    /** 限制编号 */
    private String resSeqNo;
    /** 事件类型 */
    private String eventType;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 结算账号 */
    private String settleBaseAcctNo;
    /** 交易账号币种 */
    private String settleAcctCcy;
    /** 交易账户名称 */
    private String settleAcctName;
    /** 结算编号 */
    private String settleNo;
    /** 结算客户号 */
    private String settleClient;
    /** 交易账号序号 */
    private String settleAcctSeqNo;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;

    public String getPayRecInd() {
        return payRecInd;
    }

    public void setPayRecInd(String payRecInd) {
        this.payRecInd = payRecInd;
    }

    public String getSettleBankFlag() {
        return settleBankFlag;
    }

    public void setSettleBankFlag(String settleBankFlag) {
        this.settleBankFlag = settleBankFlag;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSettleCcy() {
        return settleCcy;
    }

    public void setSettleCcy(String settleCcy) {
        this.settleCcy = settleCcy;
    }

    public String getBankInOut() {
        return bankInOut;
    }

    public void setBankInOut(String bankInOut) {
        this.bankInOut = bankInOut;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getAmtType() {
        return amtType;
    }

    public void setAmtType(String amtType) {
        this.amtType = amtType;
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

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getSettleBaseAcctNo() {
        return settleBaseAcctNo;
    }

    public void setSettleBaseAcctNo(String settleBaseAcctNo) {
        this.settleBaseAcctNo = settleBaseAcctNo;
    }

    public String getSettleAcctCcy() {
        return settleAcctCcy;
    }

    public void setSettleAcctCcy(String settleAcctCcy) {
        this.settleAcctCcy = settleAcctCcy;
    }

    public String getSettleAcctName() {
        return settleAcctName;
    }

    public void setSettleAcctName(String settleAcctName) {
        this.settleAcctName = settleAcctName;
    }

    public String getSettleNo() {
        return settleNo;
    }

    public void setSettleNo(String settleNo) {
        this.settleNo = settleNo;
    }

    public String getSettleClient() {
        return settleClient;
    }

    public void setSettleClient(String settleClient) {
        this.settleClient = settleClient;
    }

    public String getSettleAcctSeqNo() {
        return settleAcctSeqNo;
    }

    public void setSettleAcctSeqNo(String settleAcctSeqNo) {
        this.settleAcctSeqNo = settleAcctSeqNo;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }
}