package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.TranType;

/**
 * ST005 登记现金交易明细 输入BO
 */
public class ST005InputBO {

	/** 交易类型 */
	private TranType tranType;

	/** 币种 */
	private Ccy ccy;

	/** 借贷标志 */
	private CrDrInd crDrInd;

	/** 交易金额 */
	private BigDecimal tranAmt;

	public TranType getTranType() {
		return tranType;
	}

	public void setTranType(TranType tranType) {
		this.tranType = tranType;
	}

	public Ccy getCcy() {
		return ccy;
	}

	public void setCcy(Ccy ccy) {
		this.ccy = ccy;
	}

	public CrDrInd getCrDrInd() {
		return crDrInd;
	}

	public void setCrDrInd(CrDrInd crDrInd) {
		this.crDrInd = crDrInd;
	}

	public BigDecimal getTranAmt() {
		return tranAmt;
	}

	public void setTranAmt(BigDecimal tranAmt) {
		this.tranAmt = tranAmt;
	}
}
