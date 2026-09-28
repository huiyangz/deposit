package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.RbBusAcctPurpose;
import com.dcits.deposit.facade.bo.ST056InputBO;
import com.dcits.deposit.facade.bo.ST056OutputBO;

/**
 * ST056 检查账户用途
 *
 * 步骤描述：
 * 1.检查资本项下人民币账户的核准件编号：{币种}为"人民币元"且{账户用途}为"资本项下"时，
 * 若{核准件编号}为空，则返回错误码 ER0012，否则继续执行；
 * 2.检查资本项下人民币账户的账户属性：同一前提条件下，若{账户属性}为空，则返回错误码 ER0013，否则继续执行；
 * 3.检查账户属性：按{账户属性}跳转——"基本存款账户"/"一般存款账户"跳转子步骤4，"验资户"跳转子步骤5，
 * "专用存款账户"跳转子步骤6；
 * 4.检查基本户和验资户的账户用途：用途不为空且不为"无特殊用途"返回 ER0014，否则检查通过；
 * 5.检查临时户的账户用途：用途不等于"注册验资"/"增资验资"/"无特殊用途"任一值返回 ER0015，否则检查通过；
 * 6.检查专用户的账户用途：用途不等于"预算单位专用"/"非预算单位专用"任一值返回 ER0016，否则检查通过。
 *
 * 输入字段来源实体 RB_BUS_ACCT 由上游装配进 InputBO，本步骤无 BCC、规则及跨组件调用，不访问数据库。
 */
@Service
public class ST056Pbc implements IST056 {

	@Override
	public ST056OutputBO execute(ST056InputBO input) {
		ST056OutputBO output = new ST056OutputBO();
		// 前提条件：{币种}为"人民币元"且{账户用途}为"资本项下"（子步骤1/2 共用）
		boolean capitalRmbAccount = input.getAcctCcy() == AcctCcy.CNY
				&& input.getRbBusAcctPurpose() == RbBusAcctPurpose.VALUE_501;
		String errorCode = null;

		// 子步骤1：检查资本项下人民币账户的核准件编号——核准件编号为空（null 或空串）返回 ER0012，否则继续执行
		if (capitalRmbAccount && isBlank(input.getApprLetterNo())) {
			errorCode = "ER0012";
		}

		// 子步骤2：检查资本项下人民币账户的账户属性——账户属性为空返回 ER0013，否则继续执行
		if (errorCode == null && capitalRmbAccount && input.getAcctNatureNo() == null) {
			errorCode = "ER0013";
		}

		// 子步骤3：检查账户属性——根据账户属性跳转至对应用途检查子步骤
		if (errorCode == null) {
			AcctNatureNo acctNatureNo = input.getAcctNatureNo();
			if (acctNatureNo == AcctNatureNo.VALUE_11001 || acctNatureNo == AcctNatureNo.VALUE_11002) {
				// 子步骤3a："基本存款账户"或"一般存款账户" → 跳转子步骤4
				errorCode = checkBasicAndGeneralPurpose(input.getRbBusAcctPurpose());
			} else if (acctNatureNo == AcctNatureNo.VALUE_17) {
				// 子步骤3b："验资户" → 跳转子步骤5
				errorCode = checkTemporaryPurpose(input.getRbBusAcctPurpose());
			} else if (acctNatureNo == AcctNatureNo.VALUE_11004) {
				// 子步骤3c："专用存款账户" → 跳转子步骤6
				errorCode = checkSpecialPurpose(input.getRbBusAcctPurpose());
			} else {
				// 账户属性不属于 SPEC 定义的任一跳转分支（含未触发子步骤2校验时的 null），
				// SPEC 未定义该情况的检查结果，不发明默认通过或默认错误码，本步骤不产生检查通过结论
				return output;
			}
		}

		if (errorCode == null) {
			// 检查结果为"通过"：以步骤成功（succeed=true）表达，无业务输出字段
			output.setSucceed(true);
		} else {
			// 业务失败：统一设置失败状态、错误码与错误信息（业务说明取自 SPEC 子步骤描述原文）后终止
			output.setSucceed(false);
			output.setErrorCode(errorCode);
			output.setErrorMessage(errorCode + "::" + errorMessageOf(errorCode));
		}
		return output;
	}

	/**
	 * 子步骤4：检查基本户和验资户的账户用途。
	 * 到达本子步骤时{账户属性}已为"基本存款账户"或"一般存款账户"，
	 * 若{账户用途}不为空且不为"无特殊用途"返回 ER0014，否则检查通过。
	 *
	 * @param purpose 对公存款账户用途
	 * @return 失败错误码，检查通过返回 null
	 */
	private String checkBasicAndGeneralPurpose(RbBusAcctPurpose purpose) {
		if (purpose != null && purpose != RbBusAcctPurpose.VALUE_0) {
			return "ER0014";
		}
		return null;
	}

	/**
	 * 子步骤5：检查临时户的账户用途。
	 * 到达本子步骤时{账户属性}已为"验资户"，
	 * 若{账户用途}不等于"注册验资"/"增资验资"/"无特殊用途"任一值返回 ER0015
	 *（SPEC 未如子步骤4设"不为空"豁免，用途为空按字面判定为不等于任一允许值），否则检查通过。
	 *
	 * @param purpose 对公存款账户用途
	 * @return 失败错误码，检查通过返回 null
	 */
	private String checkTemporaryPurpose(RbBusAcctPurpose purpose) {
		if (purpose != RbBusAcctPurpose.VALUE_1 && purpose != RbBusAcctPurpose.VALUE_2
				&& purpose != RbBusAcctPurpose.VALUE_0) {
			return "ER0015";
		}
		return null;
	}

	/**
	 * 子步骤6：检查专用户的账户用途。
	 * 到达本子步骤时{账户属性}已为"专用存款账户"，
	 * 若{账户用途}不等于"预算单位专用"/"非预算单位专用"任一值返回 ER0016，否则检查通过。
	 *
	 * @param purpose 对公存款账户用途
	 * @return 失败错误码，检查通过返回 null
	 */
	private String checkSpecialPurpose(RbBusAcctPurpose purpose) {
		if (purpose != RbBusAcctPurpose.VALUE_4 && purpose != RbBusAcctPurpose.VALUE_3) {
			return "ER0016";
		}
		return null;
	}

	/**
	 * 判断字符串字段是否为空（null 或空串）。
	 *
	 * @param value 字符串取值
	 * @return true 表示为空
	 */
	private boolean isBlank(String value) {
		return value == null || value.isEmpty();
	}

	/**
	 * 错误码对应的业务说明（内容为 SPEC 子步骤描述的失败条件原文）。
	 *
	 * @param errorCode 已确认的错误码
	 * @return 业务说明
	 */
	private String errorMessageOf(String errorCode) {
		switch (errorCode) {
			case "ER0012":
				return "资本项下人民币账户的核准件编号为空";
			case "ER0013":
				return "资本项下人民币账户的账户属性为空";
			case "ER0014":
				return "基本存款账户或一般存款账户的账户用途不为空且不为无特殊用途";
			case "ER0015":
				return "验资户的账户用途不等于注册验资或增资验资或无特殊用途";
			case "ER0016":
				return "专用存款账户的账户用途不等于预算单位专用或非预算单位专用";
			default:
				return "";
		}
	}
}
