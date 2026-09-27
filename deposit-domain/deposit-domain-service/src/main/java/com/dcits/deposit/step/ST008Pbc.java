package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.facade.bo.ST008InputBO;
import com.dcits.deposit.facade.bo.ST008OutputBO;
import com.dcits.deposit.facade.components.IFmClientCopyBcc;
import com.dcits.deposit.facade.eo.FmClientCopyEO;

/**
 * ST008 检查客户类型 步骤实现
 *
 * 步骤描述：
 * 1.获取客户类型：根据{客户号}查询【客户信息】获取$客户类型$。
 * 2.检查客户类型：若[客户类型]不为“公司”，则返回[错误码]“ER0042”，
 * 否则返回检查结果为“通过”。
 */
@Service
public class ST008Pbc implements IST008 {

	private final IFmClientCopyBcc fmClientCopyBcc;

	public ST008Pbc(IFmClientCopyBcc fmClientCopyBcc) {
		this.fmClientCopyBcc = fmClientCopyBcc;
	}

	@Override
	public ST008OutputBO execute(ST008InputBO input) {
		ST008OutputBO output = new ST008OutputBO();
		// 子步骤1 获取客户类型：根据{客户号}查询【客户信息】（客户副本表 FM_CLIENT_COPY）获取$客户类型$
		FmClientCopyEO clientCopy = fmClientCopyBcc.findByPrimaryKey(input.getClientNo());
		output.setClientType(clientCopy == null ? null : clientCopy.getClientType());

		// 子步骤2 检查客户类型：[客户类型]不为“公司”（ClientType.VALUE_200）则返回错误码 ER0042
		if (output.getClientType() != ClientType.VALUE_200) {
			output.setSucceed(false);
			output.setErrorCode("ER0042");
			output.setErrorMessage("ER0042::客户类型不为公司");
			return output;
		}
		// 客户类型为“公司”，检查结果为“通过”
		output.setSucceed(true);
		return output;
	}
}
