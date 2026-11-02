package com.dcits.deposit.facade.bo;

/** ST047 检查客户是否存在限制 输入 BO */
public class ST047InputBO {

	/** 客户号（必填，由调用方上送，作为查询客户限制表的依据） */
	private String clientNo;

	public String getClientNo() {
		return clientNo;
	}

	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}
}
