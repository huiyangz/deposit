package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.AllDraInd;

/**
 * ST029 设置通兑标志 输出BO
 */
public class ST029OutputBO extends StepResult {

	/** 通兑标识（非必填，数据来源：对公存款账户主表 RB_BUS_ACCT） */
	private AllDraInd allDraInd;

	public AllDraInd getAllDraInd() {
		return allDraInd;
	}

	public void setAllDraInd(AllDraInd allDraInd) {
		this.allDraInd = allDraInd;
	}
}
