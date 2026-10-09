package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST123 检查账户是否存在不允许销户的限制 —— 步骤输出。
 *
 * <p>遍历 [账户限制信息] 后给出 [允许销户标志]：存在某条记录查得
 * {@code $销户标志$}＝「N-否」时为「不允许销户」，遍历结束且未发生中断时为「允许销户」，
 * 二者互斥。本步骤无业务失败场景，不产出错误码。</p>
 */
public class ST123OutputBO extends StepResult {

    /** 允许销户标志，取值：「允许销户」、「不允许销户」 */
    private String allowCloseAcctFlag;

    public String getAllowCloseAcctFlag() {
        return allowCloseAcctFlag;
    }

    public void setAllowCloseAcctFlag(String allowCloseAcctFlag) {
        this.allowCloseAcctFlag = allowCloseAcctFlag;
    }
}
