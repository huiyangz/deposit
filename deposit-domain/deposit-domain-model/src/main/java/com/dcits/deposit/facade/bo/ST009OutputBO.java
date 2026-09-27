package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.RestraintsStatus;

/**
 * ST009 检查现金存入账户限制 输出BO
 *
 * 检查结果“通过”以 succeed=true 体现；现金不收不付限制、现金止收、限制未豁免分别以
 * 错误码 ER0043、ER0044、ER0045 体现。五个业务输出字段在实际获取到后写入，
 * 执行路径上未获取的输出保持 null。
 */
public class ST009OutputBO extends StepResult {

	/** 现金不收不付限制标志 */
	private String cashNonReceiptNonPaymentFlag;
	/** 现金止收标志 */
	private String cashStopReceiptFlag;
	/** 属性限制标志 */
	private String natureRestraintFlag;
	/** 账户限制类型 */
	private RestraintType restraintType;
	/** 限制状态，来源于[账户限制信息] */
	private RestraintsStatus restraintsStatus;

	public String getCashNonReceiptNonPaymentFlag() {
		return cashNonReceiptNonPaymentFlag;
	}

	public void setCashNonReceiptNonPaymentFlag(String cashNonReceiptNonPaymentFlag) {
		this.cashNonReceiptNonPaymentFlag = cashNonReceiptNonPaymentFlag;
	}

	public String getCashStopReceiptFlag() {
		return cashStopReceiptFlag;
	}

	public void setCashStopReceiptFlag(String cashStopReceiptFlag) {
		this.cashStopReceiptFlag = cashStopReceiptFlag;
	}

	public String getNatureRestraintFlag() {
		return natureRestraintFlag;
	}

	public void setNatureRestraintFlag(String natureRestraintFlag) {
		this.natureRestraintFlag = natureRestraintFlag;
	}

	public RestraintType getRestraintType() {
		return restraintType;
	}

	public void setRestraintType(RestraintType restraintType) {
		this.restraintType = restraintType;
	}

	public RestraintsStatus getRestraintsStatus() {
		return restraintsStatus;
	}

	public void setRestraintsStatus(RestraintsStatus restraintsStatus) {
		this.restraintsStatus = restraintsStatus;
	}
}
