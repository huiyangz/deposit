package com.dcits.deposit.step;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.SettleAcctClass;
import com.dcits.deposit.facade.bo.ST057InputBO;
import com.dcits.deposit.facade.bo.ST057OutputBO;

/**
 * ST057 检查利息资本化标志 步骤实现
 *
 * 步骤描述：
 * 1.检查利息资本化标志：若{利息资本化标志}等于"N"，则继续执行，否则返回检查结果为“通过”。
 * 2.检查利息入账结算账户存在性：若上送的结算账户数组中不存在{结算账户类型}为"INT"
 * （利息入账账户）的账户，则返回[错误码]“ER0034”，否则返回检查结果为“通过”。
 */
@Service
public class ST057Pbc implements IST057 {

	/** 利息资本化标志：不资本化 */
	private static final String INT_CAP_FLAG_NO = "N";
	/** 检查通过结果 */
	private static final String CHECK_RESULT_PASS = "通过";

	@Override
	public ST057OutputBO execute(ST057InputBO input) {
		ST057OutputBO output = new ST057OutputBO();

		// 子步骤1 检查利息资本化标志：{利息资本化标志}等于"N"则继续执行子步骤2，否则返回检查结果"通过"（正常提前结束）
		if (!INT_CAP_FLAG_NO.equals(input.getIntCapFlag())) {
			output.setCheckResult(CHECK_RESULT_PASS);
			output.setSucceed(true);
			return output;
		}

		// 子步骤2 检查利息入账结算账户存在性：结算账户数组中不存在{结算账户类型}为"INT"（利息入账账户）的账户，返回错误码 ER0034
		if (!containsSettleAcctClass(input.getSettleAccts(), SettleAcctClass.INT)) {
			output.setSucceed(false);
			output.setErrorCode("ER0034");
			output.setErrorMessage("ER0034::上送的结算账户数组中不存在利息入账账户");
			return output;
		}

		// 存在{结算账户类型}为"INT"（利息入账账户）的账户，返回检查结果"通过"
		output.setCheckResult(CHECK_RESULT_PASS);
		output.setSucceed(true);
		return output;
	}

	/**
	 * 子步骤2 判定上送的结算账户数组中是否存在指定{结算账户类型}的账户
	 */
	private boolean containsSettleAcctClass(List<ST057InputBO.SettleAcctDTO> settleAccts, SettleAcctClass settleAcctClass) {
		for (ST057InputBO.SettleAcctDTO settleAcct : settleAccts) {
			if (settleAcct.getSettleAcctClass() == settleAcctClass) {
				return true;
			}
		}
		return false;
	}
}
