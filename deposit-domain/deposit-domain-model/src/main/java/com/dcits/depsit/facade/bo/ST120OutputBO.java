package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;

/**
 * ST120 检查是否存在转账不收不付限制 - 输出。
 *
 * <p>业务结论由 {@code acctTranNoRecvNoPayFlag}（转账不收不付标志）承载，
 * 取中文字面值：「是」表示存在转账不收不付限制，「否」表示不存在。</p>
 *
 * <p>命中（结论为「是」）时回显命中那条【账户限制信息】记录的限制编号、账户限制类型、
 * 限制状态，以及该记录对应【限制类型表】生效配置的借贷方控制标志、状态、转账标志。
 * 结论为「否」时各回显字段的取值源需求未规定（Spec「验收范围与明确不覆盖的事项」第 3 项），
 * 本 BO 不对其作规定。</p>
 */
public class ST120OutputBO extends StepResult {
    /** 转账不收不付标志（"是"-存在转账不收不付限制、"否"-不存在转账不收不付限制） */
    private String acctTranNoRecvNoPayFlag;
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
    /**
     * 止付标志。
     *
     * <p>源需求「## 已接受的需求处理结论」已放行本字段：子步骤 1 至子步骤 3 均未获取或返回该字段，
     * 其取值来源与返回条件在正式需求中无法确定，Spec「验收范围与明确不覆盖的事项」第 1 项据此
     * 不为该字段规定取值来源、取值或返回条件。本步骤不对其赋值。</p>
     */
    private String stopFlag;

    public String getAcctTranNoRecvNoPayFlag() {
        return acctTranNoRecvNoPayFlag;
    }

    public void setAcctTranNoRecvNoPayFlag(String acctTranNoRecvNoPayFlag) {
        this.acctTranNoRecvNoPayFlag = acctTranNoRecvNoPayFlag;
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
