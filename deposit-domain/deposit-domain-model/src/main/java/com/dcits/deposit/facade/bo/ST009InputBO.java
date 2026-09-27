package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.TranType;

/**
 * ST009 检查现金存入账户限制 输入BO
 */
public class ST009InputBO {

	/** 账号 */
	private String baseAcctNo;
	/** 交易类型 */
	private TranType tranType;
	/** 交易渠道编号 */
	private String channelNo;
	/** 产品编号 */
	private String prodNo;
	/** 摘要码 */
	private String narrativeCode;

	public String getBaseAcctNo() {
		return baseAcctNo;
	}

	public void setBaseAcctNo(String baseAcctNo) {
		this.baseAcctNo = baseAcctNo;
	}

	public TranType getTranType() {
		return tranType;
	}

	public void setTranType(TranType tranType) {
		this.tranType = tranType;
	}

	public String getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}

	public String getProdNo() {
		return prodNo;
	}

	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}

	public String getNarrativeCode() {
		return narrativeCode;
	}

	public void setNarrativeCode(String narrativeCode) {
		this.narrativeCode = narrativeCode;
	}
}
