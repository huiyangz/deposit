package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.ClientType;

/**
 * ST008 检查客户类型 输出BO
 *
 * 检查结果“通过”以 succeed=true 体现；[客户类型]不为“公司”时 succeed=false，
 * 错误码为 ER0042。客户类型非必填，客户号无对应记录时为 null。
 */
public class ST008OutputBO extends StepResult {

	/** 客户类型 */
	private ClientType clientType;

	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}
}
