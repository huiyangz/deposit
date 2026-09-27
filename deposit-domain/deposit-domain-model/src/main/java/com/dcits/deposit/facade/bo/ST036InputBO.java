package com.dcits.deposit.facade.bo;

/**
 * ST036 设置允许转久悬标志 输入BO
 */
public class ST036InputBO {

	/** 允许账户转久悬标志 */
	private String allowSuspendFlag;
	/** 产品编号 */
	private String prodNo;
	/** 参数KEY值 */
	private String attrKey;

	public String getAllowSuspendFlag() {
		return allowSuspendFlag;
	}

	public void setAllowSuspendFlag(String allowSuspendFlag) {
		this.allowSuspendFlag = allowSuspendFlag;
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
}
