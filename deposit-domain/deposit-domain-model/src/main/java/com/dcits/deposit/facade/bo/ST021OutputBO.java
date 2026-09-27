package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.AcctStatus;

/**
 * ST021 检查存入账户账户状态 输出BO
 */
public class ST021OutputBO extends StepResult {

	/** 账户状态 */
	private AcctStatus acctStatus;

	public AcctStatus getAcctStatus() {
		return acctStatus;
	}

	public void setAcctStatus(AcctStatus acctStatus) {
		this.acctStatus = acctStatus;
	}
}
