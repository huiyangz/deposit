package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.AllDepInd;

/** ST047 设置通存标志 输入BO */
public class ST047InputBO {
	/** 通存标识 */
	private AllDepInd allDepInd;
	/** 产品编号 */
	private String prodNo;
	/** 参数KEY值 */
	private String attrKey;

	public AllDepInd getAllDepInd() {
		return allDepInd;
	}

	public void setAllDepInd(AllDepInd allDepInd) {
		this.allDepInd = allDepInd;
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
