package com.dcits.deposit.entity;

import java.util.Date;

public class RbLimitSceneDef {
    /** 限额场景编码 */
    private String limitSceneNo;
    /** 限额场景描述 */
    private String limitSceneDesc;
    /** 限额大类 */
    private String limitMainType;
    /** 检查对象类型 */
    private String checkObjType;
    /** 限额折算方式 */
    private String limitConvert;
    /** 限制币种 */
    private String limitCcy;
    /** 启用标志 */
    private String validFlag;
    /** 法人 */
    private String company;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 交易时间戳 */
    private String tranTimestamp;

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public String getLimitSceneDesc() {
        return limitSceneDesc;
    }

    public void setLimitSceneDesc(String limitSceneDesc) {
        this.limitSceneDesc = limitSceneDesc;
    }

    public String getLimitMainType() {
        return limitMainType;
    }

    public void setLimitMainType(String limitMainType) {
        this.limitMainType = limitMainType;
    }

    public String getCheckObjType() {
        return checkObjType;
    }

    public void setCheckObjType(String checkObjType) {
        this.checkObjType = checkObjType;
    }

    public String getLimitConvert() {
        return limitConvert;
    }

    public void setLimitConvert(String limitConvert) {
        this.limitConvert = limitConvert;
    }

    public String getLimitCcy() {
        return limitCcy;
    }

    public void setLimitCcy(String limitCcy) {
        this.limitCcy = limitCcy;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}