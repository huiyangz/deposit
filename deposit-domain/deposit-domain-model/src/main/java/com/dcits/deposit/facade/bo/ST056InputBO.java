package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.RbBusAcctPurpose;

/**
 * ST056 检查账户用途 输入BO
 *
 * 字段来源：docs/specs/ST056.md 输入表，字段来源实体为对公存款账户主表（RB_BUS_ACCT），
 * 由上游装配进本 BO，本步骤不访问数据库。
 */
public class ST056InputBO {

	/** 对公存款账户用途（非必填） */
	private RbBusAcctPurpose rbBusAcctPurpose;
	/** 账户币种（必填） */
	private AcctCcy acctCcy;
	/** 核准件编号（非必填） */
	private String apprLetterNo;
	/** 账户属性（非必填） */
	private AcctNatureNo acctNatureNo;

	public RbBusAcctPurpose getRbBusAcctPurpose() {
		return rbBusAcctPurpose;
	}

	public void setRbBusAcctPurpose(RbBusAcctPurpose rbBusAcctPurpose) {
		this.rbBusAcctPurpose = rbBusAcctPurpose;
	}

	public AcctCcy getAcctCcy() {
		return acctCcy;
	}

	public void setAcctCcy(AcctCcy acctCcy) {
		this.acctCcy = acctCcy;
	}

	public String getApprLetterNo() {
		return apprLetterNo;
	}

	public void setApprLetterNo(String apprLetterNo) {
		this.apprLetterNo = apprLetterNo;
	}

	public AcctNatureNo getAcctNatureNo() {
		return acctNatureNo;
	}

	public void setAcctNatureNo(AcctNatureNo acctNatureNo) {
		this.acctNatureNo = acctNatureNo;
	}
}
