package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.RestraintsStatus;

/**
 * ST135 更新账户手工解限限制状态 输出 BO。
 *
 * <p>字段照录正式 Spec「## 输出」表：{@code restraintsStatus}（限制状态，
 * {@code com.dcits.depsit.enums.RestraintsStatus}，非必填，来源实体 对公存款账户限制表 RB_BUS_RESTRAINTS），
 * 取值为本步骤写入【账户限制信息】的限制状态取值（"E-失效"，{@link RestraintsStatus#E}，码值 "E"，Spec REQ-003）。</p>
 */
public class ST135OutputBO extends StepResult {

    /** 限制状态：本次更新写入的取值（RestraintsStatus.E，"E-失效"） */
    private RestraintsStatus restraintsStatus;

    public RestraintsStatus getRestraintsStatus() {
        return restraintsStatus;
    }

    public void setRestraintsStatus(RestraintsStatus restraintsStatus) {
        this.restraintsStatus = restraintsStatus;
    }
}
