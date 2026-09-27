package com.dcits.deposit.facade.bo;

import java.util.Date;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.TermType;

/** ST051 增加账户限制 输出BO */
public class ST051OutputBO extends StepResult {
	/** 结束日期 */
	private Date endDate;
	/** 账号 */
	private String baseAcctNo;
	/** 账户限制类型 */
	private RestraintType restraintType;
	/** 存期期限 */
	private String term;
	/** 周期类型 */
	private TermType termType;

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getBaseAcctNo() {
		return baseAcctNo;
	}

	public void setBaseAcctNo(String baseAcctNo) {
		this.baseAcctNo = baseAcctNo;
	}

	public RestraintType getRestraintType() {
		return restraintType;
	}

	public void setRestraintType(RestraintType restraintType) {
		this.restraintType = restraintType;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public TermType getTermType() {
		return termType;
	}

	public void setTermType(TermType termType) {
		this.termType = termType;
	}
}
