package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST010 检查账户存在性 输出BO
 *
 * 检查结果“通过”以 succeed=true 体现；[账户信息]不存在时 succeed=false，
 * 错误码为 ER0048。baseAcctNo 取自查询到的[账户信息]记录（RB_BUS_ACCT）。
 */
public class ST010OutputBO extends StepResult {

	/** 账号（来源实体：对公存款账户主表 RB_BUS_ACCT） */
	private String baseAcctNo;

	public String getBaseAcctNo() {
		return baseAcctNo;
	}

	public void setBaseAcctNo(String baseAcctNo) {
		this.baseAcctNo = baseAcctNo;
	}
}
