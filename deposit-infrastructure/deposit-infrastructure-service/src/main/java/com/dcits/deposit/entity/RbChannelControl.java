package com.dcits.deposit.entity;

public class RbChannelControl {
    /** 控制编号 */
    private String controlSeqNo;
    /** 客户号 */
    private String clientNo;
    /** 渠道控制类型 */
    private String controlType;
    /** 渠道控制状态 */
    private String controlStatus;

    public String getControlSeqNo() {
        return controlSeqNo;
    }

    public void setControlSeqNo(String controlSeqNo) {
        this.controlSeqNo = controlSeqNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getControlType() {
        return controlType;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    public String getControlStatus() {
        return controlStatus;
    }

    public void setControlStatus(String controlStatus) {
        this.controlStatus = controlStatus;
    }
}