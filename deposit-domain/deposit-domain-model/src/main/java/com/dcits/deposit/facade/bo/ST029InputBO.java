package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.AllDraInd;

/**
 * ST029 设置通兑标志 输入BO
 */
public class ST029InputBO {

	/** 通兑标识（非必填，为空时取产品的通兑标志） */
	private AllDraInd allDraInd;

	/** 产品编号（必填，来源：产品定义表 MB_PROD_DEFINE） */
	private String prodNo;

	/** 参数KEY值（必填，来源：产品定义表 MB_PROD_DEFINE） */
	private String attrKey;

	/** 属性值（必填，来源：产品定义表 MB_PROD_DEFINE） */
	private String attrValue;

	public AllDraInd getAllDraInd() {
		return allDraInd;
	}

	public void setAllDraInd(AllDraInd allDraInd) {
		this.allDraInd = allDraInd;
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
