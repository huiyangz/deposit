package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.Status;

/**
 * ST058 检查是否存在不收不付限制 输出 BO。
 *
 * <p>继承 {@link StepResult}。业务输出含不收不付标志及限制相关字段；
 * 不收不付标志物理编码待确认（见实现 FIXME）。</p>
 */
public class ST058OutputBO extends StepResult {

    /** 不收不付标志（业务取值「是」/「否」，物理编码待确认） */
    private String noCreditNoDebitFlag;

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

    public String getNoCreditNoDebitFlag() {
        return noCreditNoDebitFlag;
    }

    public void setNoCreditNoDebitFlag(String noCreditNoDebitFlag) {
        this.noCreditNoDebitFlag = noCreditNoDebitFlag;
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
