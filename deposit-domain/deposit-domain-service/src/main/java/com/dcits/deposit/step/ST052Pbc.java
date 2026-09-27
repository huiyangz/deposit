package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.WithdrawalType;
import com.dcits.deposit.facade.bo.ST052InputBO;
import com.dcits.deposit.facade.bo.ST052OutputBO;

/**
 * ST052 检查支取方式
 *
 * 步骤描述：
 * 1.获取产品的支取方式：根据{产品编号}、{参数KEY值}访问业务组件《产品管理》的业务功能《查询产品信息》，获取产品的支取方式集合；
 * 2.检查支取方式是否在产品配置范围内：若产品的支取方式集合包含输入参数{支取方式}，则继续执行，否则返回错误码“ER0021”；
 * 3.检查非代办支取密码：若{支取方式}等于“凭密码”或“凭印鉴和密码”且{代办人名称}为空且{密码}等于空，则返回错误码“ER0022”，否则返回检查结果为“通过”。
 */
@Service
public class ST052Pbc implements IST052 {

	/** 错误码：支取方式不在产品配置范围内 */
	private static final String ER0021 = "ER0021";
	/** 错误码：非代办支取密码为空 */
	private static final String ER0022 = "ER0022";

	/** 检查通过时检查结果的取值 */
	private static final String CHECK_RESULT_PASSED = "通过";

	private final ExternalTaskClient externalTaskClient;

	public ST052Pbc(ExternalTaskClient externalTaskClient) {
		this.externalTaskClient = externalTaskClient;
	}

	@Override
	public ST052OutputBO execute(ST052InputBO input) {
		ST052OutputBO output = new ST052OutputBO();

		// 子步骤1 获取产品的支取方式：按产品编号和参数KEY值查询产品管理，返回值为产品支取方式集合的原值
		String withdrawalTypes = externalTaskClient.queryProductInfo(input.getProdNo(), input.getAttrKey());

		// 子步骤2 检查支取方式是否在产品配置范围内：支取方式代码为单字符，集合原值包含该代码即视为在配置范围内
		if (!withdrawalTypes.contains(input.getWithdrawalType().getValue())) {
			output.setSucceed(false);
			output.setErrorCode(ER0021);
			output.setErrorMessage(ER0021 + "::支取方式不在产品配置范围内");
			return output;
		}

		// 子步骤3 检查非代办支取密码：“凭密码”（P）或“凭印鉴和密码”（B）支取、代办人名称为空且密码为空时，返回ER0022
		boolean passwordType = input.getWithdrawalType() == WithdrawalType.P
				|| input.getWithdrawalType() == WithdrawalType.B;
		if (passwordType && isEmpty(input.getCommissionClientName()) && isEmpty(input.getPassword())) {
			output.setSucceed(false);
			output.setErrorCode(ER0022);
			output.setErrorMessage(ER0022 + "::非代办支取密码为空");
			return output;
		}

		// 检查通过
		output.setCheckResult(CHECK_RESULT_PASSED);
		output.setSucceed(true);
		return output;
	}

	/**
	 * 判断字符串为空（null 或空字符串）。
	 */
	private boolean isEmpty(String value) {
		return value == null || value.isEmpty();
	}
}
