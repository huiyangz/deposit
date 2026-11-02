package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.Status;

/**
 * ST054 检查是否存在现金止收限制 步骤输出。
 *
 * <p>字段来自正式 Spec ST054「输出」表（REQ-004），继承 {@link StepResult} 承载步骤结果。
 * 输出表声明 restraintType 两次（分别来源 RB_BUS_RESTRAINTS 与 RB_RESTRAINT_TYPE），
 * 两同名字段的区分方式未在需求中定义（Spec 待确认事项 TBD-7），本步骤以单一 restraintType
 * 字段对外提供、取步骤 1 来源（RB_BUS_RESTRAINTS）值，见
 * {@link com.dcits.deposit.step.ST054Pbc#execute(ST054InputBO)}。</p>
 *
 * <p>需求步骤 3 返回的现金止收标志（"是"/"否"）未登记于「输出」表，承载输出字段去向待确认
 * （Spec 待确认事项 TBD-2），本输出不新增该字段，判定逻辑见实现中 FIXME。</p>
 */
public class ST054OutputBO extends StepResult {

    /** 限制编号（来源 RB_BUS_RESTRAINTS） */
    private String resSeqNo;

    /** 账户限制类型（来源 RB_BUS_RESTRAINTS；与 RB_RESTRAINT_TYPE 来源同名字段的区分见 TBD-7） */
    private RestraintType restraintType;

    /** 限制状态（来源 RB_BUS_RESTRAINTS） */
    private RestraintsStatus restraintsStatus;

    /** 状态（来源 RB_RESTRAINT_TYPE） */
    private Status status;

    /** 借方贷方控制标志（来源 RB_RESTRAINT_TYPE） */
    private DrCrCtlFlag drCrCtlFlag;

    /** 现金标志（来源 RB_RESTRAINT_TYPE，String 字段，工程无对应枚举） */
    private String cashFlag;

    /** 止付标志（来源 RB_RESTRAINT_TYPE） */
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public DrCrCtlFlag getDrCrCtlFlag() {
        return drCrCtlFlag;
    }

    public void setDrCrCtlFlag(DrCrCtlFlag drCrCtlFlag) {
        this.drCrCtlFlag = drCrCtlFlag;
    }

    public String getCashFlag() {
        return cashFlag;
    }

    public void setCashFlag(String cashFlag) {
        this.cashFlag = cashFlag;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }
}
