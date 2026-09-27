package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.TranBranch;

/** ST023 检查机构币种交易权限 输入BO */
public class ST023InputBO {
	/** 交易机构号 */
	private TranBranch tranBranch;
	/** 交易币种 */
	private Ccy tranCcy;

	public TranBranch getTranBranch() {
		return tranBranch;
	}

	public void setTranBranch(TranBranch tranBranch) {
		this.tranBranch = tranBranch;
	}

	public Ccy getTranCcy() {
		return tranCcy;
	}

	public void setTranCcy(Ccy tranCcy) {
		this.tranCcy = tranCcy;
	}
}
