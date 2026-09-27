package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.WithdrawalType;

/**
 * ST052 检查支取方式 输入BO
 */
public class ST052InputBO {

	/** 支取方式 */
	private WithdrawalType withdrawalType;
	/** 密码 */
	private String password;
	/** 代办人名称 */
	private String commissionClientName;
	/** 产品编号 */
	private String prodNo;
	/** 参数KEY值 */
	private String attrKey;
	/** 属性值 */
	private String attrValue;

	public WithdrawalType getWithdrawalType() {
		return withdrawalType;
	}

	public void setWithdrawalType(WithdrawalType withdrawalType) {
		this.withdrawalType = withdrawalType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCommissionClientName() {
		return commissionClientName;
	}

	public void setCommissionClientName(String commissionClientName) {
		this.commissionClientName = commissionClientName;
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
