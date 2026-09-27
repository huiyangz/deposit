package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.TranType;

/**
 * ST006 检查存入交易类型 输入BO
 */
public class ST006InputBO {

	/** 交易类型 */
	private TranType tranType;

	public TranType getTranType() {
		return tranType;
	}

	public void setTranType(TranType tranType) {
		this.tranType = tranType;
	}
}
