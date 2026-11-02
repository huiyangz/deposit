package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.RestraintLevel;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;

/**
 * ST061 检查是否存在属性限制 输出。
 */
public class ST061OutputBO extends StepResult {

    /** 属性限制标志 */
    private String 属性限制标志;
    /** 限制编号，来源 对公存款账户限制表（RB_BUS_RESTRAINTS） */
    private String resSeqNo;
    /** 账户限制类型，来源 对公存款账户限制表（RB_BUS_RESTRAINTS） */
    private RestraintType restraintType;
    /** 限制状态，来源 对公存款账户限制表（RB_BUS_RESTRAINTS） */
    private RestraintsStatus restraintsStatus;
    /** 限制级别，来源 对公存款账户限制表（RB_BUS_RESTRAINTS） */
    private RestraintLevel restraintLevel;

    public String get属性限制标志() {
        return 属性限制标志;
    }

    public void set属性限制标志(String 属性限制标志) {
        this.属性限制标志 = 属性限制标志;
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

    public RestraintLevel getRestraintLevel() {
        return restraintLevel;
    }

    public void setRestraintLevel(RestraintLevel restraintLevel) {
        this.restraintLevel = restraintLevel;
    }
}
