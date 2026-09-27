package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.SpecAcctFlag;
import com.dcits.deposit.enums.TranBranch;

/** ST055 设置账号 输入BO */
public class ST055InputBO {
	/** 交易机构号 */
	private TranBranch tranBranch;
	/** 产品编号 */
	private String prodNo;
	/** 居民标志 */
	private String residentFlag;
	/** 境内境外标志 */
	private String inlandOffshore;
	/** 账户开立行行号 */
	private TranBranch acctBranch;
	/** 定制账户标志 */
	private SpecAcctFlag specAcctFlag;
	/** 账号 */
	private String baseAcctNo;
	/** 客户号 */
	private String clientNo;

	public TranBranch getTranBranch() {
		return tranBranch;
	}

	public void setTranBranch(TranBranch tranBranch) {
		this.tranBranch = tranBranch;
	}

	public String getProdNo() {
		return prodNo;
	}

	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}

	public String getResidentFlag() {
		return residentFlag;
	}

	public void setResidentFlag(String residentFlag) {
		this.residentFlag = residentFlag;
	}

	public String getInlandOffshore() {
		return inlandOffshore;
	}

	public void setInlandOffshore(String inlandOffshore) {
		this.inlandOffshore = inlandOffshore;
	}

	public TranBranch getAcctBranch() {
		return acctBranch;
	}

	public void setAcctBranch(TranBranch acctBranch) {
		this.acctBranch = acctBranch;
	}

	public SpecAcctFlag getSpecAcctFlag() {
		return specAcctFlag;
	}

	public void setSpecAcctFlag(SpecAcctFlag specAcctFlag) {
		this.specAcctFlag = specAcctFlag;
	}

	public String getBaseAcctNo() {
		return baseAcctNo;
	}

	public void setBaseAcctNo(String baseAcctNo) {
		this.baseAcctNo = baseAcctNo;
	}

	public String getClientNo() {
		return clientNo;
	}

	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}
}
