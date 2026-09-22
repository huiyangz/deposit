package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ControlClass;
import com.dcits.deposit.enums.ControlType;
import com.dcits.deposit.enums.IndividualFlag;
import jakarta.validation.constraints.NotNull;

public class RbControlTypeDefEO {
    /** 渠道控制类型 */
    @NotNull
    private ControlType controlType;
    /** 渠道控制类型描述 */
    private String controlTypeDesc;
    /** 控制方式 */
    private String ctlType;
    /** 渠道集合 */
    private String channelMuster;
    /** 渠道控制分类 */
    @NotNull
    private ControlClass controlClass;
    /** 允许手工控制标志 */
    private IndividualFlag manualCtrlFlag;
    /** 允许手工解控标志 */
    private IndividualFlag manualUnCtrlFlag;
    /** 法人 */
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public ControlType getControlType() {
        return controlType;
    }

    public void setControlType(ControlType controlType) {
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

    public ControlClass getControlClass() {
        return controlClass;
    }

    public void setControlClass(ControlClass controlClass) {
        this.controlClass = controlClass;
    }

    public IndividualFlag getManualCtrlFlag() {
        return manualCtrlFlag;
    }

    public void setManualCtrlFlag(IndividualFlag manualCtrlFlag) {
        this.manualCtrlFlag = manualCtrlFlag;
    }

    public IndividualFlag getManualUnCtrlFlag() {
        return manualUnCtrlFlag;
    }

    public void setManualUnCtrlFlag(IndividualFlag manualUnCtrlFlag) {
        this.manualUnCtrlFlag = manualUnCtrlFlag;
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