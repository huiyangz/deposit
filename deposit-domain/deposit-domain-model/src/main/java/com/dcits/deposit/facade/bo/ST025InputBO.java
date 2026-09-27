package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.Ccy;

/**
 * ST025 检查币种 输入BO
 *
 * 字段来源：docs/specs/ST025.md 输入表，均必填。
 */
public class ST025InputBO {

	/** 币种 */
	private Ccy ccy;
	/** 产品编号 */
	private String prodNo;
	/** 参数KEY值 */
	private String attrKey;

	public Ccy getCcy() {
		return ccy;
	}

	public void setCcy(Ccy ccy) {
		this.ccy = ccy;
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
