package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

/**
 * ST024 检查法人透支金额 输入。
 */
public class ST024InputBO {

	/** 账号（必填，由调用方提供） */
	private String baseAcctNo;

	/** 交易金额（必填，由调用方提供） */
	private BigDecimal tranAmt;

	public String getBaseAcctNo() {
		return baseAcctNo;
	}

	public void setBaseAcctNo(String baseAcctNo) {
		this.baseAcctNo = baseAcctNo;
	}

	public BigDecimal getTranAmt() {
		return tranAmt;
	}

	public void setTranAmt(BigDecimal tranAmt) {
		this.tranAmt = tranAmt;
	}
}
