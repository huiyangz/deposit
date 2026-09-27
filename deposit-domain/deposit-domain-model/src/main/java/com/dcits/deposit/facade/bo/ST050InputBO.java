package com.dcits.deposit.facade.bo;

import java.util.Date;

import com.dcits.deposit.enums.AcctNatureNo;

/** ST050 设置账户年检标志 输入BO */
public class ST050InputBO {
	/** 账户属性 */
	private AcctNatureNo acctNatureNo;
	/** 账户开户日期 */
	private Date acctOpenDate;
	/** 客户号 */
	private String clientNo;
	/** 产品编号 */
	private String prodNo;
	/** 参数KEY值 */
	private String attrKey;
	/** 核心运行日期 */
	private Date runDate;

	public AcctNatureNo getAcctNatureNo() {
		return acctNatureNo;
	}

	public void setAcctNatureNo(AcctNatureNo acctNatureNo) {
		this.acctNatureNo = acctNatureNo;
	}

	public Date getAcctOpenDate() {
		return acctOpenDate;
	}

	public void setAcctOpenDate(Date acctOpenDate) {
		this.acctOpenDate = acctOpenDate;
	}

	public String getClientNo() {
		return clientNo;
	}

	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}

	public String getProdNo() {
		return prodNo;
	}

	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}

	public String getAttrKey() {
		return attrKey;
	}

	public void setAttrKey(String attrKey) {
		this.attrKey = attrKey;
	}

	public Date getRunDate() {
		return runDate;
	}

	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}
}
