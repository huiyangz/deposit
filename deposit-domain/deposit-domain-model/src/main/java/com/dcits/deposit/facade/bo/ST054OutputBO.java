package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

import com.dcits.common.step.StepResult;

/** ST054 设置账户执行利率 输出BO */
public class ST054OutputBO extends StepResult {
	/** 执行利率 */
	private BigDecimal realRate;

	public BigDecimal getRealRate() {
		return realRate;
	}

	public void setRealRate(BigDecimal realRate) {
		this.realRate = realRate;
	}
}
