package com.dcits.deposit.step;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST010InputBO;
import com.dcits.deposit.facade.bo.ST010OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST010 检查账户存在性 步骤实现
 *
 * 步骤描述：
 * 1.获取账户信息：根据{账号}查询【账户信息】获取[账户信息]。
 * 2.检查账户存在性：若[账户信息]不存在，则返回[错误码]“ER0048”，
 * 否则返回检查结果为“通过”。
 */
@Service
public class ST010Pbc implements IST010 {

	private final IRbBusAcctBcc rbBusAcctBcc;

	public ST010Pbc(IRbBusAcctBcc rbBusAcctBcc) {
		this.rbBusAcctBcc = rbBusAcctBcc;
	}

	@Override
	public ST010OutputBO execute(ST010InputBO input) {
		ST010OutputBO output = new ST010OutputBO();

		// 子步骤1 获取账户信息：根据{账号}查询【账户信息】（RB_BUS_ACCT）获取[账户信息]
		RbBusAcctEO queryEo = new RbBusAcctEO();
		queryEo.setBaseAcctNo(input.getBaseAcctNo());
		List<RbBusAcctEO> acctList = rbBusAcctBcc.findByEo(queryEo);

		// 子步骤2 检查账户存在性：[账户信息]不存在则返回错误码 ER0048
		if (acctList.isEmpty()) {
			output.setSucceed(false);
			output.setErrorCode("ER0048");
			output.setErrorMessage("ER0048::账户不存在");
			return output;
		}

		// [账户信息]存在，检查结果为“通过”，账号取自查询记录
		output.setBaseAcctNo(acctList.get(0).getBaseAcctNo());
		output.setSucceed(true);
		return output;
	}
}
