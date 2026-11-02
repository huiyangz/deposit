package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.Status;

/**
 * ST052 检查是否存在转账止付限制 输出 BO。
 *
 * <p>业务输出：resSeqNo（限制编号）、restraintType（账户限制类型）、restraintsStatus（限制状态）
 * 来自对公存款账户限制表（RB_BUS_RESTRAINTS，REQ-001）；drCrCtlFlag（借方贷方控制标志）、
 * status（状态）、transferFlag（转账标志）来自存款限制类型表（RB_RESTRAINT_TYPE，REQ-002）；
 * stopFlag（止付标志）为 REQ-003 按借贷方控制标志与转账标志推导的结果（「是」/「否」，
 * 承载内容与物理值口径见 ST052Pbc 中 TBD-3 FIXME）。</p>
 *
 * <p>继承 {@link StepResult}，正常完成时 succeed=true、errorCode/errorMessage 为 null。</p>
 */
public class ST052OutputBO extends StepResult {

    /** 限制编号 */
    private String resSeqNo;
    /** 账户限制类型 */
    private RestraintType restraintType;
    /** 限制状态 */
    private RestraintsStatus restraintsStatus;
    /** 借方贷方控制标志 */
    private DrCrCtlFlag drCrCtlFlag;
    /** 状态 */
    private Status status;
    /** 转账标志 */
    private String transferFlag;
    /** 止付标志 */
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
