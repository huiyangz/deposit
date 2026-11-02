package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.Status;

/**
 * ST049 检查转账止收限制 输出。
 *
 * <p>继承 {@link StepResult}，业务字段见正式 Spec ST049「输出」表。</p>
 */
public class ST049OutputBO extends StepResult {

    /** 限制编号（对公存款账户限制表 RB_BUS_RESTRAINTS） */
    private String resSeqNo;

    /** 账户限制类型（对公存款账户限制表 RB_BUS_RESTRAINTS） */
    private RestraintType restraintType;

    /** 限制状态（对公存款账户限制表 RB_BUS_RESTRAINTS） */
    private RestraintsStatus restraintsStatus;

    /** 借方贷方控制标志（存款限制类型表 RB_RESTRAINT_TYPE） */
    private DrCrCtlFlag drCrCtlFlag;

    /** 状态（存款限制类型表 RB_RESTRAINT_TYPE） */
    private Status status;

    /** 转账标志（存款限制类型表 RB_RESTRAINT_TYPE） */
    private String transferFlag;

    /** 止付标志（存款限制类型表 RB_RESTRAINT_TYPE） */
    private String stopFlag;

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

    public String getTransferFlag() {
        return transferFlag;
    }

    public void setTransferFlag(String transferFlag) {
        this.transferFlag = transferFlag;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }
}
