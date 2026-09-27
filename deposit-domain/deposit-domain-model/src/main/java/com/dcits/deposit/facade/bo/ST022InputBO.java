package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.CashItem;
import com.dcits.deposit.enums.TranType;

/**
 * ST022 检查现金项目编号 输入BO
 */
public class ST022InputBO {

	/** 交易类型 */
	private TranType tranType;

	/** 现金项目编号 */
	private CashItem cashItem;

	public TranType getTranType() {
		return tranType;
	}

	public void setTranType(TranType tranType) {
		this.tranType = tranType;
	}

	public CashItem getCashItem() {
		return cashItem;
	}

	public void setCashItem(CashItem cashItem) {
		this.cashItem = cashItem;
	}
}
