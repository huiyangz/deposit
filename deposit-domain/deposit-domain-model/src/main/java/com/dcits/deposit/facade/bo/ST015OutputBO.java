package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.IsOverMonthSeasonOd;

/**
 * ST015 检查靠档标识 步骤输出。
 *
 * <p>业务输出 isOverMonthSeasonOd 为靠档跨月季标识（来源对公透支签约表
 * RB_BUS_AGREEMENT_OVERDRAFT）；gotoStepName 为步骤流转机制字段，运行时按
 * {@code GotoStepCondition} 契约依据其值确定是否跳转及跳转目标，不属于 Spec 业务输出。</p>
 */
public class ST015OutputBO extends StepResult {

    /** 靠档跨月季标识 */
    private IsOverMonthSeasonOd isOverMonthSeasonOd;

    /** 跳转目标步骤名称，按 {@code GotoStepCondition} 契约运行时依据该值确定跳转目标 */
    private String gotoStepName;

    public IsOverMonthSeasonOd getIsOverMonthSeasonOd() {
        return isOverMonthSeasonOd;
    }

    public void setIsOverMonthSeasonOd(IsOverMonthSeasonOd isOverMonthSeasonOd) {
        this.isOverMonthSeasonOd = isOverMonthSeasonOd;
    }

    public String getGotoStepName() {
        return gotoStepName;
    }

    public void setGotoStepName(String gotoStepName) {
        this.gotoStepName = gotoStepName;
    }
}
