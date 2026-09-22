package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.Status;
import jakarta.validation.constraints.NotNull;

public class RbTranSceneMappingEO {
    /** 属性值 */
    private String attrValue;
    /** 参数键值对 */
    private String keyValue;
    /** 场景分类 */
    private String sceneClass;
    /** 参数数据类型 */
    private String attrType;
    /** 状态 */
    private Status status;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 交易场景编码 */
    @NotNull
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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