package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.Ccy;

/** ST023 检查机构币种交易权限 输出BO */
public class ST023OutputBO extends StepResult {
	/** 币种（来源实体：机构币种表 FM_BRANCH_CCY） */
	private Ccy ccy;

	public Ccy getCcy() {
		return ccy;
	}

	public void setCcy(Ccy ccy) {
		this.ccy = ccy;
	}
}
