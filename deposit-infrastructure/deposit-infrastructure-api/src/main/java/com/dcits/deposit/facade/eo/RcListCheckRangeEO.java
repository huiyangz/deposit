package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ListType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranType;
import jakarta.validation.constraints.NotNull;

public class RcListCheckRangeEO {
    /** 序号 */
    @NotNull
    private String seqNo;
    /** 名单类型代码 */
    private ListType listType;
    /** 黑名单检查规则编号 */
    private String ruleId;
    /** 交易类型 */
    private TranType tranType;
    /** 事件类型 */
    private String eventType;
    /** 服务代码 */
    private String serviceCode;
    /** 接口服务类型 */
    private String messageType;
    /** 接口服务代码 */
    private String messageCode;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 交易代码 */
    private String programId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public ListType getListType() {
        return listType;
    }

    public void setListType(ListType listType) {
        this.listType = listType;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
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

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
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
}