package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.SpecAcctFlag;

/** ST030 检查账号 输入BO */
public class ST030InputBO {
	/** 账号 */
	private String baseAcctNo;
	/** 卡号 */
	private String cardNo;
	/** 定制账户标志 */
	private SpecAcctFlag specAcctFlag;

	public String getBaseAcctNo() {
		return baseAcctNo;
	}

	public void setBaseAcctNo(String baseAcctNo) {
		this.baseAcctNo = baseAcctNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public SpecAcctFlag getSpecAcctFlag() {
		return specAcctFlag;
	}

	public void setSpecAcctFlag(SpecAcctFlag specAcctFlag) {
		this.specAcctFlag = specAcctFlag;
	}
}
