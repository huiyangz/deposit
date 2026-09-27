package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.TranBranch;

/** ST032 检查账户机构 输入BO */
public class ST032InputBO {
	/** 交易机构号 */
	private TranBranch tranBranch;
	/** 产品编号 */
	private String prodNo;
	/** 参数KEY值 */
	private String attrKey;
	/** 属性值 */
	private String attrValue;

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
