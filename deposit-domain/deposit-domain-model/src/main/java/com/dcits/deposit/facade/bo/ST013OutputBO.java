package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.RestraintsStatus;

/** ST013 检查客户限制 输出BO */
public class ST013OutputBO extends StepResult {
	/** 限制状态 */
	private RestraintsStatus restraintsStatus;
	/** 限制编号 */
	private String resSeqNo;
	/** 账户限制类型 */
	private RestraintType restraintType;

	public RestraintsStatus getRestraintsStatus() {
		return restraintsStatus;
	}

	public void setRestraintsStatus(RestraintsStatus restraintsStatus) {
		this.restraintsStatus = restraintsStatus;
	}

	public String getResSeqNo() {
		return resSeqNo;
	}

	public void setResSeqNo(String resSeqNo) {
		this.resSeqNo = resSeqNo;
	}

	public RestraintType getRestraintType() {
		return restraintType;
	}

	public void setRestraintType(RestraintType restraintType) {
		this.restraintType = restraintType;
	}
}
