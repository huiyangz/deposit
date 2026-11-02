package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST059 检查账户是否存在不允许销户的限制 输出 BO。
 *
 * <p>输出[允许销户标志]，业务取值「允许销户」/「不允许销户」，由步骤描述及 Spec
 * REQ-003、REQ-004 确认。需求输出表说明为「待定：允许销户标志」，物理编码（字面中文串或
 * 映射编码）与输出载体未确认（Spec TBD-2）；本步骤按已确认业务取值以字面中文串输出。</p>
 */
public class ST059OutputBO extends StepResult {

    /** [允许销户标志] */
    private String allowCloseFlag;

    public String getAllowCloseFlag() {
        return allowCloseFlag;
    }

    public void setAllowCloseFlag(String allowCloseFlag) {
        this.allowCloseFlag = allowCloseFlag;
    }
}
