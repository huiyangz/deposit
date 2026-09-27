package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.RbBusAcctPurpose;

/** ST026 设置账户状态 输入BO */
public class ST026InputBO {
	/** 账户属性 */
	private AcctNatureNo acctNatureNo;
	/** 对公存款账户用途 */
	private RbBusAcctPurpose rbBusAcctPurpose;
	/** 客户号 */
	private String clientNo;
	/** 产品编号 */
	private String prodNo;
	/** 参数KEY值 */
	private String attrKey;
	/** 属性值 */
	private String attrValue;

	public AcctNatureNo getAcctNatureNo() {
		return acctNatureNo;
	}

	public void setAcctNatureNo(AcctNatureNo acctNatureNo) {
		this.acctNatureNo = acctNatureNo;
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

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}
}
