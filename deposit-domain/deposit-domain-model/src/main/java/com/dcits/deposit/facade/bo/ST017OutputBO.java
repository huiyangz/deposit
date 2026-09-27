package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.CrDrInd;

/**
 * ST017 设置贷记交易的借贷标志 输出BO
 *
 * 借贷标志固定赋值为“C-贷方”（CrDrInd.C）。本步骤无业务失败场景，
 * 失败仅由技术异常传播表达。
 */
public class ST017OutputBO extends StepResult {

	/** 借贷标志 */
	private CrDrInd crDrInd;

	public CrDrInd getCrDrInd() {
		return crDrInd;
	}

	public void setCrDrInd(CrDrInd crDrInd) {
		this.crDrInd = crDrInd;
	}
}
