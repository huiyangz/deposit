package com.dcits.deposit.facade.bo;

import java.util.Date;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.RbBusAcctPurpose;
import com.dcits.deposit.enums.TranBranch;

/** ST051 增加账户限制 输入BO */
public class ST051InputBO {
	/** 核心运行日期 */
	private Date runDate;
	/** 账号 */
	private String baseAcctNo;
	/** 交易机构号 */
	private TranBranch tranBranch;
	/** 对公存款账户用途 */
	private RbBusAcctPurpose rbBusAcctPurpose;
	/** 客户号 */
	private String clientNo;
	/** 账户属性 */
	private AcctNatureNo acctNatureNo;

	public Date getRunDate() {
		return runDate;
	}

	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}

	public String getBaseAcctNo() {
		return baseAcctNo;
	}

	public void setBaseAcctNo(String baseAcctNo) {
		this.baseAcctNo = baseAcctNo;
	}

	public TranBranch getTranBranch() {
		return tranBranch;
	}

	public void setTranBranch(TranBranch tranBranch) {
		this.tranBranch = tranBranch;
	}

	public RbBusAcctPurpose getRbBusAcctPurpose() {
		return rbBusAcctPurpose;
	}

	public void setRbBusAcctPurpose(RbBusAcctPurpose rbBusAcctPurpose) {
		this.rbBusAcctPurpose = rbBusAcctPurpose;
	}

	public String getClientNo() {
		return clientNo;
	}

	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}

	public AcctNatureNo getAcctNatureNo() {
		return acctNatureNo;
	}

	public void setAcctNatureNo(AcctNatureNo acctNatureNo) {
		this.acctNatureNo = acctNatureNo;
	}
}
