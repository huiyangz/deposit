package com.dcits.deposit.step;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.facade.bo.ST003InputBO;
import com.dcits.deposit.facade.bo.ST003OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST003 检查账户类型 步骤实现
 *
 * 步骤描述：
 * 1.获取账户类型：根据{账号}查询【对公存款账户主表（RB_BUS_ACCT）】获取$账户类型$
 * 2.检查账户类型：若[账户类型]不等于“T-定期账户”或“A-AIO账户”，则返回检查结果为“通过”，
 * 否则返回[错误码]“ER0052”
 */
@Service
public class ST003Pbc implements IST003 {

	private final IRbBusAcctBcc rbBusAcctBcc;

	public ST003Pbc(IRbBusAcctBcc rbBusAcctBcc) {
		this.rbBusAcctBcc = rbBusAcctBcc;
	}

	@Override
	public ST003OutputBO execute(ST003InputBO input) {
		ST003OutputBO output = new ST003OutputBO();

		// 子步骤1 获取账户类型：按{账号}查询【对公存款账户主表（RB_BUS_ACCT）】获取$账户类型$
		RbBusAcctEO queryEo = new RbBusAcctEO();
		queryEo.setBaseAcctNo(input.getBaseAcctNo());
		List<RbBusAcctEO> rbBusAcctList = rbBusAcctBcc.findByEo(queryEo);
		RbAcctType rbAcctType = null;
		if (rbBusAcctList != null && !rbBusAcctList.isEmpty()) {
			rbAcctType = rbBusAcctList.get(0).getRbAcctType();
		}
		output.setRbAcctType(rbAcctType);

		// 子步骤2 检查账户类型：[账户类型]等于“T-定期账户”或“A-AIO账户”时返回错误码 ER0052
		if (RbAcctType.T == rbAcctType || RbAcctType.A == rbAcctType) {
			output.setSucceed(false);
			output.setErrorCode("ER0052");
			output.setErrorMessage("ER0052::账户类型为T-定期账户或A-AIO账户");
			return output;
		}

		// [账户类型]不等于“T-定期账户”或“A-AIO账户”，检查结果为“通过”
		output.setSucceed(true);
		return output;
	}
}
