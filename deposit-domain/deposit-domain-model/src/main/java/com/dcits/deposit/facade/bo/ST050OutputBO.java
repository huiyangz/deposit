package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/** ST050 设置账户年检标志 输出BO */
public class ST050OutputBO extends StepResult {
	/** 年检标志 */
	private String annualFlag;

	public String getAnnualFlag() {
		return annualFlag;
	}

	public void setAnnualFlag(String annualFlag) {
		this.annualFlag = annualFlag;
	}
}
