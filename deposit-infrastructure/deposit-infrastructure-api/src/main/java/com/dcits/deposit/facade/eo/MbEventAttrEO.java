package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import jakarta.validation.constraints.NotNull;

public class MbEventAttrEO {
    /** 事件类型 */
    @NotNull
    private String eventType;
    /** 序号 */
    @NotNull
    private String seqNo;
    /** 组件ID */
    private String assembleId;
    /** 组件类型 */
    private String assembleType;
    /** 指标运行规则 */
    private String assembleRule;
    /** 属性值 */
    private String attrValue;
    /** 法人 */
    @NotNull
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getAssembleId() {
        return assembleId;
    }

    public void setAssembleId(String assembleId) {
        this.assembleId = assembleId;
    }

    public String getAssembleType() {
        return assembleType;
    }

    public void setAssembleType(String assembleType) {
        this.assembleType = assembleType;
    }

    public String getAssembleRule() {
        return assembleRule;
    }

    public void setAssembleRule(String assembleRule) {
        this.assembleRule = assembleRule;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}