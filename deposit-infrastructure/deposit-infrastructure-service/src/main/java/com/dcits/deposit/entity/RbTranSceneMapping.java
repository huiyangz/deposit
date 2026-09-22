package com.dcits.deposit.entity;

public class RbTranSceneMapping {
    /** 属性值 */
    private String attrValue;
    /** 参数键值对 */
    private String keyValue;
    /** 场景分类 */
    private String sceneClass;
    /** 参数数据类型 */
    private String attrType;
    /** 状态 */
    private String status;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 交易场景编码 */
    private String tranScene;
    /** 交易场景描述 */
    private String tranSceneDesc;

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getSceneClass() {
        return sceneClass;
    }

    public void setSceneClass(String sceneClass) {
        this.sceneClass = sceneClass;
    }

    public String getAttrType() {
        return attrType;
    }

    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getTranScene() {
        return tranScene;
    }

    public void setTranScene(String tranScene) {
        this.tranScene = tranScene;
    }

    public String getTranSceneDesc() {
        return tranSceneDesc;
    }

    public void setTranSceneDesc(String tranSceneDesc) {
        this.tranSceneDesc = tranSceneDesc;
    }
}