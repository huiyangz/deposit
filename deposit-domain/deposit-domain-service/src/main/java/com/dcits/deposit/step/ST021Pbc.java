package com.dcits.deposit.step;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.facade.bo.ST021InputBO;
import com.dcits.deposit.facade.bo.ST021OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST021 检查存入账户账户状态
 *
 * 子步骤1 获取账户状态：根据{账号}查询【账户信息】获取$账户状态$；
 * 若未查到账户记录，检查不通过，返回失败（错误码待业务补充确认）。
 * 子步骤2 检查账户状态：若[账户状态]为“C-关闭”或“S-久悬”或“O-转营业外”，
 * 则返回[错误码]“ER0046”，否则返回检查结果为“通过”。
 */
@Service
public class ST021Pbc implements IST021 {

	/** 账户状态为“C-关闭”或“S-久悬”或“O-转营业外”时的错误码 */
	private static final String ERROR_CODE_ER0046 = "ER0046";

	/** 错误码 ER0046 对应的业务说明（错误码::业务信息） */
	private static final String ERROR_MESSAGE_ER0046 = ERROR_CODE_ER0046
			+ "::账户状态为“C-关闭”或“S-久悬”或“O-转营业外”无法交易";

	private final IRbBusAcctBcc rbBusAcctBcc;

	public ST021Pbc(IRbBusAcctBcc rbBusAcctBcc) {
		this.rbBusAcctBcc = rbBusAcctBcc;
	}

	@Override
	public ST021OutputBO execute(ST021InputBO input) {
		ST021OutputBO output = new ST021OutputBO();

		// 子步骤1 获取账户状态：根据{账号}查询【账户信息】获取$账户状态$
		RbBusAcctEO acctInfo = findAcctInfo(input.getBaseAcctNo());

		// 子步骤1：若未查到账户记录，检查不通过，返回失败（错误码待业务补充确认）
		if (acctInfo == null) {
			output.setSucceed(false);
			output.setErrorMessage("未查到账户记录，检查不通过");
			return output;
		}

		AcctStatus acctStatus = acctInfo.getAcctStatus();

		// 子步骤2 检查账户状态：若[账户状态]为“C-关闭”或“S-久悬”或“O-转营业外”，则返回[错误码]“ER0046”
		if (acctStatus == AcctStatus.C || acctStatus == AcctStatus.S || acctStatus == AcctStatus.O) {
			output.setSucceed(false);
			output.setErrorCode(ERROR_CODE_ER0046);
			output.setErrorMessage(ERROR_MESSAGE_ER0046);
			return output;
		}

		// 子步骤2 否则分支：检查结果为“通过”，回写[账户状态]
		output.setAcctStatus(acctStatus);
		output.setSucceed(true);
		return output;
	}

	/**
	 * 子步骤1 获取账户状态：根据{账号}查询【账户信息】。
	 *
	 * @param baseAcctNo 账号
	 * @return 命中的账户记录；未查到账户记录时返回 null
	 */
	private RbBusAcctEO findAcctInfo(String baseAcctNo) {
		RbBusAcctEO condition = new RbBusAcctEO();
		condition.setBaseAcctNo(baseAcctNo);
		List<RbBusAcctEO> acctList = rbBusAcctBcc.findByEo(condition);
		if (acctList == null || acctList.isEmpty()) {
			return null;
		}
		return acctList.get(0);
	}
}
