package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.Status;

/**
 * ST116 检查是否存在转账止付限制 输出BO。
 *
 * <p>业务字段按 Spec「### 输出」表行序；全部 7 项出参在源需求「## 输出」表中标记为「非必填」。
 * 回显字段（{@code resSeqNo}、{@code restraintType}、{@code restraintsStatus}）取自命中的限制信息；
 * 配置字段（{@code drCrCtlFlag}、{@code status}、{@code transferFlag}）取自该账户限制类型对应的
 * A-生效 配置；{@code transferStopPayFlag} 为中文字面值「是」/「否」的检查结论。</p>
 */
public class ST116OutputBO extends StepResult {

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

    /** 转账止付标志（「是」或「否」） */
    private String transferStopPayFlag;

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

    public String getTransferStopPayFlag() {
        return transferStopPayFlag;
    }

    public void setTransferStopPayFlag(String transferStopPayFlag) {
        this.transferStopPayFlag = transferStopPayFlag;
    }
}
