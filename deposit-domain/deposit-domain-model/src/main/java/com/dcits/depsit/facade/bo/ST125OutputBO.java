package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.RestraintLevel;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.RestraintsStatus;

/**
 * ST125 检查是否存在属性限制 输出 BO。
 *
 * <p>{@code natureRestraintFlag} 取值恰为「是」或「否」；四个回显字段在命中记录时为选中记录的值，
 * 未查到记录时为空值。</p>
 */
public class ST125OutputBO extends StepResult {

    /** 属性限制标志：取值恰为「是」或「否」 */
    private String natureRestraintFlag;

    /** 限制编号：命中记录时回显选中记录的限制编号，未查到记录时为空值 */
    private String resSeqNo;

    /** 账户限制类型：命中记录时回显选中记录的账户限制类型，未查到记录时为空值 */
    private RestraintType restraintType;

    /** 限制状态：命中记录时回显选中记录的限制状态（按筛选条件即码值 A），未查到记录时为空值 */
    private RestraintsStatus restraintsStatus;

    /** 限制级别：命中记录时回显选中记录的限制级别（按筛选条件即码值 NATURE），未查到记录时为空值 */
    private RestraintLevel restraintLevel;

    public String getNatureRestraintFlag() {
        return natureRestraintFlag;
    }

    public void setNatureRestraintFlag(String natureRestraintFlag) {
        this.natureRestraintFlag = natureRestraintFlag;
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
