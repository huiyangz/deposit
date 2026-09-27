package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.Ccy;

/**
 * ST002 检查交易币种 输入BO
 */
public class ST002InputBO {

	/** 账号 */
	private String baseAcctNo;
	/** 交易币种 */
	private Ccy tranCcy;

	public String getBaseAcctNo() {
		return baseAcctNo;
	}

	public void setBaseAcctNo(String baseAcctNo) {
		this.baseAcctNo = baseAcctNo;
	}

	public Ccy getTranCcy() {
		return tranCcy;
	}

	public void setTranCcy(Ccy tranCcy) {
		this.tranCcy = tranCcy;
	}
}
