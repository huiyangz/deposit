package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.TranBranch;

/** ST037 检查通兑标志 输入BO */
public class ST037InputBO {
	/** 币种 */
	private Ccy ccy;
	/** 通兑标识 */
	private AllDraInd allDraInd;
	/** 通兑机构编号 */
	private TranBranch allDraIntBranch;
	/** 产品编号 */
	private String prodNo;
	/** 参数KEY值 */
	private String attrKey;
	/** 属性值 */
	private String attrValue;

	public Ccy getCcy() {
		return ccy;
	}

	public void setCcy(Ccy ccy) {
		this.ccy = ccy;
	}

	public AllDraInd getAllDraInd() {
		return allDraInd;
	}

	public void setAllDraInd(AllDraInd allDraInd) {
		this.allDraInd = allDraInd;
	}

	public TranBranch getAllDraIntBranch() {
		return allDraIntBranch;
	}

	public void setAllDraIntBranch(TranBranch allDraIntBranch) {
		this.allDraIntBranch = allDraIntBranch;
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
