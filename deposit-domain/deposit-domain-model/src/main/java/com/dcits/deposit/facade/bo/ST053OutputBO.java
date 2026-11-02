package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.Status;

/**
 * ST053 检查质押类限制 步骤输出。
 *
 * <p>字段来自正式 Spec ST053「输出」表（REQ-004），继承 {@link StepResult} 承载步骤结果。
 * 输出表声明 restraintType 两次（分别来源 RB_BUS_RESTRAINTS 与 RB_RESTRAINT_TYPE），
 * 两同名字段的区分方式未在需求中定义（Spec 待确认事项 TBD-6），本步骤以单一 restraintType
 * 字段对外提供、取步骤 1 来源（RB_BUS_RESTRAINTS）值，见
 * {@link com.dcits.deposit.step.ST053Pbc#execute(ST053InputBO)}。</p>
 */
public class ST053OutputBO extends StepResult {

    /** 限制编号（来源 RB_BUS_RESTRAINTS） */
    private String resSeqNo;

    /** 账户限制类型（来源 RB_BUS_RESTRAINTS；与 RB_RESTRAINT_TYPE 来源同名字段的区分见 TBD-6） */
    private RestraintType restraintType;

    /** 限制状态（来源 RB_BUS_RESTRAINTS） */
    private RestraintsStatus restraintsStatus;

    /** 质押标志（来源 RB_RESTRAINT_TYPE，需求指定赋值并返回的业务结果） */
    private String pledgedFlag;

    /** 状态（来源 RB_RESTRAINT_TYPE） */
    private Status status;

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

    public String getPledgedFlag() {
        return pledgedFlag;
    }

    public void setPledgedFlag(String pledgedFlag) {
        this.pledgedFlag = pledgedFlag;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
