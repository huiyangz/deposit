package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST052 检查支取方式 输出BO
 */
public class ST052OutputBO extends StepResult {

	/** 检查结果，检查通过时取值“通过” */
	private String checkResult;

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
}
