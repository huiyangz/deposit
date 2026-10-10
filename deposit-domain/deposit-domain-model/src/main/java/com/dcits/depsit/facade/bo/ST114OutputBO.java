package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;

/**
 * ST114 检查转账止收限制 输出 BO。
 *
 * <p>业务结论字段为 {@code stopCreditFlag}（取值「是」/「否」），其余 6 个字段为来源实体回显字段
 * （REQ-008、REQ-009）。{@code stopCreditFlag} 与【限制类型表】的「止付标志」{@code stopFlag}
 * 不是同一标志，本步骤从不读取止付标志。</p>
 */
public class ST114OutputBO extends StepResult {

    /** 限制编号（来源 RB_BUS_RESTRAINTS） */
    private String resSeqNo;

    /** 账户限制类型（来源 RB_BUS_RESTRAINTS） */
    private RestraintType restraintType;

    /** 限制状态（来源 RB_BUS_RESTRAINTS） */
    private RestraintsStatus restraintsStatus;

    /** 借方贷方控制标志（来源 RB_RESTRAINT_TYPE） */
    private DrCrCtlFlag drCrCtlFlag;

    /** 状态（来源 RB_RESTRAINT_TYPE） */
    private Status status;

    /** 转账标志（来源 RB_RESTRAINT_TYPE） */
    private String transferFlag;

    /** 转账止收标志：是-存在转账止收限制，否-不存在转账止收限制 */
    private String stopCreditFlag;

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

    public String getStopCreditFlag() {
        return stopCreditFlag;
    }

    public void setStopCreditFlag(String stopCreditFlag) {
        this.stopCreditFlag = stopCreditFlag;
    }
}
