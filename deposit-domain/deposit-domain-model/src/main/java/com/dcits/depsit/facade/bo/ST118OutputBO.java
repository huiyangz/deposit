package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.Status;

/**
 * ST118 检查是否存在现金止收限制 输出 BO。
 *
 * <p>继承项目已有步骤结果基类 {@link StepResult}，业务字段与正式 Spec「### 输出」表一一对应，
 * 共 7 项（源需求标记均为「非必填」）：</p>
 * <ul>
 *   <li>{@code resSeqNo}、{@code restraintType}、{@code restraintsStatus}：命中时任一条命中记录的
 *       限制编号、账户限制类型、限制状态，未命中为空值。</li>
 *   <li>{@code status}、{@code drCrCtlFlag}、{@code cashFlag}：命中时任一条命中记录对应的
 *       A-生效 限制类型配置的状态、借贷方控制标志、现金标志，该条无 A-生效 配置时为空值。</li>
 *   <li>{@code cashStopCreditFlag}：检查结论的中文字面值「是」/「否」，由本步骤判定产出。</li>
 * </ul>
 *
 * <p>本步骤无业务失败场景（Spec REQ-006），成功时 {@code succeed=true} 且错误码、错误信息保持 null。</p>
 */
public class ST118OutputBO extends StepResult {

    /** 限制编号：命中记录的限制编号（来源【对公存款账户限制表 RB_BUS_RESTRAINTS】），未命中为空值。 */
    private String resSeqNo;

    /** 账户限制类型：命中记录的账户限制类型码值，未命中为空值。 */
    private RestraintType restraintType;

    /** 限制状态：命中记录的限制状态码值（步骤 1 筛选条件确定为 "A"），未命中为空值。 */
    private RestraintsStatus restraintsStatus;

    /** 状态：命中记录对应 A-生效 配置的状态码值（步骤 2 条件确定为 "A"），该条无 A-生效 配置时为空值。 */
    private Status status;

    /** 借方贷方控制标志：命中记录对应 A-生效 配置的借贷方控制标志码值（步骤 3 条件确定为 "C"），该条无 A-生效 配置时为空值。 */
    private DrCrCtlFlag drCrCtlFlag;

    /** 现金标志：命中记录对应 A-生效 配置的现金标志码值（步骤 3 条件确定为 "N"），该条无 A-生效 配置时为空值。 */
    private String cashFlag;

    /** 现金止收标志：中文字面值「是」（存在现金止收限制）/「否」（不存在现金止收限制）。 */
    private String cashStopCreditFlag;

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

    public String getCashStopCreditFlag() {
        return cashStopCreditFlag;
    }

    public void setCashStopCreditFlag(String cashStopCreditFlag) {
        this.cashStopCreditFlag = cashStopCreditFlag;
    }
}
