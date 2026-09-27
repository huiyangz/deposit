package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST036 设置允许转久悬标志 输出BO
 *
 * 本步骤无业务失败场景，失败仅由技术异常传播表达，succeed=true 时错误字段为 null。
 */
public class ST036OutputBO extends StepResult {

	/** 允许账户转久悬标志 */
	private String allowSuspendFlag;

	public String getAllowSuspendFlag() {
		return allowSuspendFlag;
	}

	public void setAllowSuspendFlag(String allowSuspendFlag) {
		this.allowSuspendFlag = allowSuspendFlag;
	}
}
