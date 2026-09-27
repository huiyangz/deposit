package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.TranType;

/**
 * ST005 登记现金交易明细 输出BO
 *
 * 登记成功以 succeed=true 体现，四个业务字段回显登记值。
 * SPEC 声明本步骤无业务失败场景，失败仅由技术异常传播表达。
 */
public class ST005OutputBO extends StepResult {

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
