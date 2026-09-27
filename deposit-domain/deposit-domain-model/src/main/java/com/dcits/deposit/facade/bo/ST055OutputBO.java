package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/** ST055 设置账号 输出BO */
public class ST055OutputBO extends StepResult {
	/** 账号 */
	private String baseAcctNo;

	public String getBaseAcctNo() {
		return baseAcctNo;
	}

	public void setBaseAcctNo(String baseAcctNo) {
		this.baseAcctNo = baseAcctNo;
	}
}
