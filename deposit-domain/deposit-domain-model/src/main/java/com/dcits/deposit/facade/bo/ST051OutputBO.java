package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;

/**
 * ST051 检查账户是否存在限制 - 步骤输出。
 */
public class ST051OutputBO extends StepResult {
    /** 账号（来源：对公存款账户主表 RB_BUS_ACCT） */
    private String baseAcctNo;
    /** 主账户标志（来源：对公存款账户主表 RB_BUS_ACCT） */
    private String leadAcctFlag;
    /** 限制编号（来源：对公存款账户限制表 RB_BUS_RESTRAINTS） */
    private String resSeqNo;
    /** 限制状态（来源：对公存款账户限制表 RB_BUS_RESTRAINTS） */
    private RestraintsStatus restraintsStatus;
    /** 账户限制类型（来源：对公存款账户限制表 RB_BUS_RESTRAINTS） */
    private RestraintType restraintType;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getLeadAcctFlag() {
        return leadAcctFlag;
    }

    public void setLeadAcctFlag(String leadAcctFlag) {
        this.leadAcctFlag = leadAcctFlag;
    }

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
    }

    public RestraintsStatus getRestraintsStatus() {
        return restraintsStatus;
    }

    public void setRestraintsStatus(RestraintsStatus restraintsStatus) {
        this.restraintsStatus = restraintsStatus;
    }

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
        this.restraintType = restraintType;
    }
}
