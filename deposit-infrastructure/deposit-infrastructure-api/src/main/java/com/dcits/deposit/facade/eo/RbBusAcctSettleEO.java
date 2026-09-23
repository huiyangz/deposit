package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.BankInOut;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.IntCalcAmtType;
import com.dcits.deposit.enums.PayRecInd;
import com.dcits.deposit.enums.SettleAcctClass;
import com.dcits.deposit.enums.SettleBankFlag;
import com.dcits.deposit.enums.SettleMethod;
import jakarta.validation.constraints.NotNull;

public class RbBusAcctSettleEO {
    /** 收付款标志 */
    private PayRecInd payRecInd;
    /** 结算账户行内外标识 */
    private SettleBankFlag settleBankFlag;
    /** 交易参考号 */
    private String reference;
    /** 结算币种 */
    private Ccy settleCcy;
    /** 银行内外标志 */
    private BankInOut bankInOut;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 金额类型 */
    private IntCalcAmtType amtType;
    /** 结算账户类型 */
    private SettleAcctClass settleAcctClass;
    /** 结算方法 */
    private SettleMethod settleMethod;
    /** 限制编号 */
    private String resSeqNo;
    /** 事件类型 */
    private String eventType;
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 结算账号 */
    private String settleBaseAcctNo;
    /** 交易账号币种 */
    private AcctCcy settleAcctCcy;
    /** 交易账户名称 */
    private String settleAcctName;
    /** 结算编号 */
    @NotNull
    private String settleNo;
    /** 结算客户号 */
    private String settleClient;
    /** 交易账号序号 */
    private String settleAcctSeqNo;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;

    public PayRecInd getPayRecInd() {
        return payRecInd;
    }

    public void setPayRecInd(PayRecInd payRecInd) {
        this.payRecInd = payRecInd;
    }

    public SettleBankFlag getSettleBankFlag() {
        return settleBankFlag;
    }

    public void setSettleBankFlag(SettleBankFlag settleBankFlag) {
        this.settleBankFlag = settleBankFlag;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Ccy getSettleCcy() {
        return settleCcy;
    }

    public void setSettleCcy(Ccy settleCcy) {
        this.settleCcy = settleCcy;
    }

    public BankInOut getBankInOut() {
        return bankInOut;
    }

    public void setBankInOut(BankInOut bankInOut) {
        this.bankInOut = bankInOut;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public IntCalcAmtType getAmtType() {
        return amtType;
    }

    public void setAmtType(IntCalcAmtType amtType) {
        this.amtType = amtType;
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

    public AcctCcy getSettleAcctCcy() {
        return settleAcctCcy;
    }

    public void setSettleAcctCcy(AcctCcy settleAcctCcy) {
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