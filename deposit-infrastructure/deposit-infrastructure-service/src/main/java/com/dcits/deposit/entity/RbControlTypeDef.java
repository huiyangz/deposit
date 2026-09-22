package com.dcits.deposit.entity;

public class RbControlTypeDef {
    /** 渠道控制类型 */
    private String controlType;
    /** 渠道控制类型描述 */
    private String controlTypeDesc;
    /** 控制方式 */
    private String ctlType;
    /** 渠道集合 */
    private String channelMuster;
    /** 渠道控制分类 */
    private String controlClass;
    /** 允许手工控制标志 */
    private String manualCtrlFlag;
    /** 允许手工解控标志 */
    private String manualUnCtrlFlag;
    /** 法人 */
    private String company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public String getControlType() {
        return controlType;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    public String getControlTypeDesc() {
        return controlTypeDesc;
    }

    public void setControlTypeDesc(String controlTypeDesc) {
        this.controlTypeDesc = controlTypeDesc;
    }

    public String getCtlType() {
        return ctlType;
    }

    public void setCtlType(String ctlType) {
        this.ctlType = ctlType;
    }

    public String getChannelMuster() {
        return channelMuster;
    }

    public void setChannelMuster(String channelMuster) {
        this.channelMuster = channelMuster;
    }

    public String getControlClass() {
        return controlClass;
    }

    public void setControlClass(String controlClass) {
        this.controlClass = controlClass;
    }

    public String getManualCtrlFlag() {
        return manualCtrlFlag;
    }

    public void setManualCtrlFlag(String manualCtrlFlag) {
        this.manualCtrlFlag = manualCtrlFlag;
    }

    public String getManualUnCtrlFlag() {
        return manualUnCtrlFlag;
    }

    public void setManualUnCtrlFlag(String manualUnCtrlFlag) {
        this.manualUnCtrlFlag = manualUnCtrlFlag;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}