package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.OnlineTranStatus;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import jakarta.validation.constraints.NotNull;

public class RbTranControlHistEO {
    /** 渠道流水号 */
    @NotNull
    private String channelSeqNo;
    /** 渠道日期 */
    @NotNull
    private java.util.Date channelDate;
    /** 渠道类型 */
    @NotNull
    private SourceType sourceType;
    /** 子流水号 */
    @NotNull
    private String subSeqNo;
    /** 业务细类 */
    private String busiSubClass;
    /** 客户号 */
    private String clientNo;
    /** 交易日期 */
    @NotNull
    private java.util.Date tranDate;
    /** 交易机构号 */
    private AcctBranch tranBranch;
    /** 事件类型 */
    private String tranEventType;
    /** 交易描述 */
    private String tranDesc;
    /** 交易参考号 */
    private String reference;
    /** 联机交易状态 */
    private OnlineTranStatus onlineTranStatus;
    /** 接口服务类型 */
    private String messageType;
    /** 接口服务代码 */
    private String messageCode;
    /** 服务代码 */
    private String serviceCode;
    /** 源模块 */
    private SourceModule sourceModule;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 消费系统流水号 */
    private String customerSeqNo;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 传输代码 */
    private String tranCode;
    /** TAE交易模式 */
    private String taeTradeMode;
    /** 借贷标志 */
    private CrDrInd drCrFlag;
    /** tae记账标志 */
    private IndividualFlag taeFlag;

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public java.util.Date getChannelDate() {
        return channelDate;
    }

    public void setChannelDate(java.util.Date channelDate) {
        this.channelDate = channelDate;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public String getSubSeqNo() {
        return subSeqNo;
    }

    public void setSubSeqNo(String subSeqNo) {
        this.subSeqNo = subSeqNo;
    }

    public String getBusiSubClass() {
        return busiSubClass;
    }

    public void setBusiSubClass(String busiSubClass) {
        this.busiSubClass = busiSubClass;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public AcctBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(AcctBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getTranEventType() {
        return tranEventType;
    }

    public void setTranEventType(String tranEventType) {
        this.tranEventType = tranEventType;
    }

    public String getTranDesc() {
        return tranDesc;
    }

    public void setTranDesc(String tranDesc) {
        this.tranDesc = tranDesc;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public OnlineTranStatus getOnlineTranStatus() {
        return onlineTranStatus;
    }

    public void setOnlineTranStatus(OnlineTranStatus onlineTranStatus) {
        this.onlineTranStatus = onlineTranStatus;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public SourceModule getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(SourceModule sourceModule) {
        this.sourceModule = sourceModule;
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

    public String getCustomerSeqNo() {
        return customerSeqNo;
    }

    public void setCustomerSeqNo(String customerSeqNo) {
        this.customerSeqNo = customerSeqNo;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getTaeTradeMode() {
        return taeTradeMode;
    }

    public void setTaeTradeMode(String taeTradeMode) {
        this.taeTradeMode = taeTradeMode;
    }

    public CrDrInd getDrCrFlag() {
        return drCrFlag;
    }

    public void setDrCrFlag(CrDrInd drCrFlag) {
        this.drCrFlag = drCrFlag;
    }

    public IndividualFlag getTaeFlag() {
        return taeFlag;
    }

    public void setTaeFlag(IndividualFlag taeFlag) {
        this.taeFlag = taeFlag;
    }
}