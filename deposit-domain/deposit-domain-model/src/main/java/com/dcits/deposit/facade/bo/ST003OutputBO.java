package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.RbAcctType;

/**
 * ST003 检查账户类型 输出BO
 *
 * 检查结果“通过”以 succeed=true 体现；账户类型为“T-定期账户”或“A-AIO账户”时
 * succeed=false，错误码为 ER0052。rbAcctType 为按{账号}查询【对公存款账户主表
 * （RB_BUS_ACCT）】得到的存款账户类型，非必填。
 */
public class ST003OutputBO extends StepResult {

	/** 存款账户类型 */
	private RbAcctType rbAcctType;

	public RbAcctType getRbAcctType() {
		return rbAcctType;
	}

	public void setRbAcctType(RbAcctType rbAcctType) {
		this.rbAcctType = rbAcctType;
	}
}
