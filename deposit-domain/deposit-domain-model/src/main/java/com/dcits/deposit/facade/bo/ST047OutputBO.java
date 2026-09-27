package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.AllDepInd;

/** ST047 设置通存标志 输出BO */
public class ST047OutputBO extends StepResult {
	/** 通存标识 */
	private AllDepInd allDepInd;

	public AllDepInd getAllDepInd() {
		return allDepInd;
	}

	public void setAllDepInd(AllDepInd allDepInd) {
		this.allDepInd = allDepInd;
	}
}
