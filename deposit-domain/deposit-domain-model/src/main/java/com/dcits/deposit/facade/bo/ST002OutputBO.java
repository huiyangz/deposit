package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.AcctCcy;

/**
 * ST002 检查交易币种 输出BO
 *
 * 检查结果“通过”以 succeed=true 体现；账户币种不等于交易币种时 succeed=false，
 * 错误码为 ER0051。业务输出仅为账户币种，来源于对公存款账户主表（RB_BUS_ACCT）。
 */
public class ST002OutputBO extends StepResult {

	/** 账户币种 */
	private AcctCcy acctCcy;

	public AcctCcy getAcctCcy() {
		return acctCcy;
	}

	public void setAcctCcy(AcctCcy acctCcy) {
		this.acctCcy = acctCcy;
	}
}
