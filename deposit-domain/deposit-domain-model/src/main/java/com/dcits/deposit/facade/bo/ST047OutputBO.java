package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;

/** ST047 检查客户是否存在限制 输出 BO，继承步骤结果 */
public class ST047OutputBO extends StepResult {

	/** 限制编号（客户限制表 RB_CLIENT_RESTRAINTS） */
	private String resSeqNo;

	/** 账户限制类型（客户限制表 RB_CLIENT_RESTRAINTS） */
	private RestraintType restraintType;

	/** 限制状态（客户限制表 RB_CLIENT_RESTRAINTS） */
	private RestraintsStatus restraintsStatus;

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

	public RestraintsStatus getRestraintsStatus() {
		return restraintsStatus;
	}

	public void setRestraintsStatus(RestraintsStatus restraintsStatus) {
		this.restraintsStatus = restraintsStatus;
	}
}
