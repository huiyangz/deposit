package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.Status;

/**
 * ST060 检查是否存在现金不收不付限制 步骤输出。
 *
 * <p>继承 {@link StepResult}：步骤正常完成时 succeed=true、errorCode/errorMessage 为 null。</p>
 */
public class ST060OutputBO extends StepResult {

    // FIXME 业务项:ST060/检查是否存在现金不收不付限制 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:现金不收不付限制标志的物理字段名与物理取值编码（字面量「是」/「否」或映射为其它编码）未确认（Spec 待确认事项 TBD-5） - 影响:当前字段暂命名 cashNoReceiveNoPayFlag、按业务取值「是」/「否」输出，物理字段名与编码确认后可能需要调整 - 待确认:现金不收不付限制标志的实际物理字段名及物理编码
    /** 现金不收不付限制标志（业务取值「是」/「否」，非必填） */
    private String cashNoReceiveNoPayFlag;

    /** 限制编号（对公存款账户限制表 RB_BUS_RESTRAINTS，非必填） */
    private String resSeqNo;

    /** 账户限制类型（对公存款账户限制表 RB_BUS_RESTRAINTS，非必填） */
    private RestraintType restraintType;

    /** 限制状态（对公存款账户限制表 RB_BUS_RESTRAINTS，查询条件限定「A-生效」，非必填） */
    private RestraintsStatus restraintsStatus;

    /** 借方贷方控制标志（存款限制类型表 RB_RESTRAINT_TYPE，非必填） */
    private DrCrCtlFlag drCrCtlFlag;

    /** 状态（存款限制类型表 RB_RESTRAINT_TYPE，查询条件限定「A-生效」，非必填） */
    private Status status;

    /** 现金标志（存款限制类型表 RB_RESTRAINT_TYPE，非必填） */
    private String cashFlag;

    public String getCashNoReceiveNoPayFlag() {
        return cashNoReceiveNoPayFlag;
    }

    public void setCashNoReceiveNoPayFlag(String cashNoReceiveNoPayFlag) {
        this.cashNoReceiveNoPayFlag = cashNoReceiveNoPayFlag;
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

    public String getCashFlag() {
        return cashFlag;
    }

    public void setCashFlag(String cashFlag) {
        this.cashFlag = cashFlag;
    }
}
