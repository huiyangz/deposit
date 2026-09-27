package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/** ST030 检查账号 输出BO */
public class ST030OutputBO extends StepResult {
	/** 检查结果，检查通过时为"通过" */
	private String checkResult;

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
}
