package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.Status;

/**
 * ST055 检查是否存在止付限制 输出。
 */
public class ST055OutputBO extends StepResult {

    /** 止付标志（「是」/「否」） */
    private String stopFlag;

    /** 限制编号（对公存款账户限制表） */
    private String resSeqNo;

    /** 账户限制类型（对公存款账户限制表） */
    private RestraintType restraintType;

    /** 限制状态（对公存款账户限制表） */
    private RestraintsStatus restraintsStatus;

    /** 借方贷方控制标志（存款限制类型表） */
    private DrCrCtlFlag drCrCtlFlag;

    /** 状态（存款限制类型表） */
    private Status status;

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
    }

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
        this.restraintType = restraintType;
    }

    public RestraintsStatus getRestraintsStatus() {
        return restraintsStatus;
    }

    public void setRestraintsStatus(RestraintsStatus restraintsStatus) {
        this.restraintsStatus = restraintsStatus;
    }

    public DrCrCtlFlag getDrCrCtlFlag() {
        return drCrCtlFlag;
    }

    public void setDrCrCtlFlag(DrCrCtlFlag drCrCtlFlag) {
        this.drCrCtlFlag = drCrCtlFlag;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
