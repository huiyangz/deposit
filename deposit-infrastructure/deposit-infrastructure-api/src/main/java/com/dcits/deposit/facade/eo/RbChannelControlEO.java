package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.ControlStatus;
import com.dcits.deposit.enums.ControlType;
import jakarta.validation.constraints.NotNull;

public class RbChannelControlEO {
    /** 控制编号 */
    @NotNull
    private String controlSeqNo;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 渠道控制类型 */
    private ControlType controlType;
    /** 渠道控制状态 */
    private ControlStatus controlStatus;

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

    public ControlType getControlType() {
        return controlType;
    }

    public void setControlType(ControlType controlType) {
        this.controlType = controlType;
    }

    public ControlStatus getControlStatus() {
        return controlStatus;
    }

    public void setControlStatus(ControlStatus controlStatus) {
        this.controlStatus = controlStatus;
    }
}