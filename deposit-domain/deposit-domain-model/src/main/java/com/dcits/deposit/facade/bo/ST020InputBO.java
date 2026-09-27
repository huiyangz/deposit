package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

/**
 * ST020 检查交易金额 输入BO
 */
public class ST020InputBO {

	/** 交易金额 */
	private BigDecimal tranAmt;

	public BigDecimal getTranAmt() {
		return tranAmt;
	}

	public void setTranAmt(BigDecimal tranAmt) {
		this.tranAmt = tranAmt;
	}
}
