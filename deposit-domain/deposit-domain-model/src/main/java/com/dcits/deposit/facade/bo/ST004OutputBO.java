package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.TranType;

/**
 * ST004 登记交易流水 输出BO
 *
 * 登记成功以 succeed=true 体现，错误字段为 null；crDrInd、ccy、tranType、tranAmt
 * 为已登记进对公存款账户金融交易流水表（RB_BUS_TRAN_JNL）的业务字段回显。
 * 本步骤无业务失败场景，失败仅由技术异常传播表达。
 */
public class ST004OutputBO extends StepResult {

	/** 借贷标志 */
	private CrDrInd crDrInd;
	/** 币种 */
	private Ccy ccy;
	/** 交易类型 */
	private TranType tranType;
	/** 交易金额 */
	private BigDecimal tranAmt;

	public CrDrInd getCrDrInd() {
		return crDrInd;
	}

	public void setCrDrInd(CrDrInd crDrInd) {
		this.crDrInd = crDrInd;
	}

	public Ccy getCcy() {
		return ccy;
	}

	public void setCcy(Ccy ccy) {
		this.ccy = ccy;
	}

	public TranType getTranType() {
		return tranType;
	}

	public void setTranType(TranType tranType) {
		this.tranType = tranType;
	}

	public BigDecimal getTranAmt() {
		return tranAmt;
	}

	public void setTranAmt(BigDecimal tranAmt) {
		this.tranAmt = tranAmt;
	}
}
