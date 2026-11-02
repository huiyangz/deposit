package com.dcits.deposit.task.dto;

/** T5S1 检查客户限制 交易接口输出 DTO */
public class T5S1OutputDTO {

	/** 限制编号（客户限制表 RB_CLIENT_RESTRAINTS，非必填） */
	private String resSeqNo;

	/** 账户限制类型（客户限制表 RB_CLIENT_RESTRAINTS，非必填，按标准代码值 String 表达） */
	private String restraintType;

	/** 限制状态（客户限制表 RB_CLIENT_RESTRAINTS，非必填，按标准代码值 String 表达） */
	private String restraintsStatus;

	public String getResSeqNo() {
		return resSeqNo;
	}

	public void setResSeqNo(String resSeqNo) {
		this.resSeqNo = resSeqNo;
	}

	public String getRestraintType() {
		return restraintType;
	}

	public void setRestraintType(String restraintType) {
		this.restraintType = restraintType;
	}

	public String getRestraintsStatus() {
		return restraintsStatus;
	}

	public void setRestraintsStatus(String restraintsStatus) {
		this.restraintsStatus = restraintsStatus;
	}
}
