package com.dcits.deposit.facade.bo;

import java.util.Date;

import com.dcits.common.step.StepResult;

/** ST045 设置生效日期 输出BO */
public class ST045OutputBO extends StepResult {
	/** 生效日期 */
	private Date effectDate;

	public Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}
}
