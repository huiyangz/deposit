package com.dcits.deposit.step;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.facade.bo.ST009InputBO;
import com.dcits.deposit.facade.bo.ST009OutputBO;

/**
 * ST009 检查现金存入账户限制 步骤实现
 *
 * 步骤描述：
 * 1.获取账户限制信息：根据{账号}访问《检查账户是否存在限制》，获取[账户限制信息]。
 * 2.检查账户限制信息：若[账户限制信息]等于空，则返回检查结果为“通过”，否则继续执行。
 * 3.获取现金不收不付限制标志：根据{账号}访问《检查是否存在现金不收不付限制》。
 * 4.检查现金不收不付限制标志：若等于“是”，则返回错误码 ER0043，否则继续执行。
 * 5.获取现金止收标志：根据{账号}访问《检查是否存在现金止收限制》。
 * 6.检查现金止收标志：若等于“是”，则返回错误码 ER0044，否则继续执行。
 * 7.获取账户属性限制标志：根据[账户限制信息]访问《检查是否存在属性限制》。
 * 8.检查属性限制标志：若等于“是”，则跳转至子步骤《获取限制豁免信息》，否则继续执行。
 * 9.执行限制优先级检查：根据{交易类型}和[账户限制信息]的限制类型访问《检查限制优先级》。
 * 10.根据检查结果判断限制检查分支：若为“不检查限制”，则返回检查结果为“通过”，否则继续执行。
 * 11.获取限制豁免信息：根据限制类型、{交易类型}、{交易渠道编号}、{产品编号}、{摘要码}访问《检查限制豁免》。
 * 12.检查账户限制豁免：若[执行结果]为“豁免”，则返回检查结果为“通过”，否则返回错误码 ER0045。
 *
 * [账户限制信息]按响应中的 restraintType、restraintsStatus 字段绑定，两者均未返回视为空。
 */
@Service
public class ST009Pbc implements IST009 {

	/** 标志取值：是 */
	private static final String FLAG_YES = "是";
	/** 检查结果：不检查限制 */
	private static final String CHECK_RESULT_NO_CHECK = "不检查限制";
	/** 执行结果：豁免 */
	private static final String EXECUTE_RESULT_EXEMPT = "豁免";

	private final ExternalTaskClient externalTaskClient;

	public ST009Pbc(ExternalTaskClient externalTaskClient) {
		this.externalTaskClient = externalTaskClient;
	}

	@Override
	public ST009OutputBO execute(ST009InputBO input) {
		ST009OutputBO output = new ST009OutputBO();

		// 子步骤1 获取账户限制信息：根据{账号}访问《检查账户是否存在限制》（ST005）
		Map<String, Object> acctRestraintResp = externalTaskClient.executeValidationST005(
				singleEntryMap("baseAcctNo", input.getBaseAcctNo()));
		String restraintTypeValue = extractString(acctRestraintResp, "restraintType");
		String restraintsStatusValue = extractString(acctRestraintResp, "restraintsStatus");

		// 子步骤2 检查账户限制信息：[账户限制信息]等于空则返回检查结果“通过”
		if (restraintTypeValue == null && restraintsStatusValue == null) {
			output.setSucceed(true);
			return output;
		}
		output.setRestraintType(RestraintType.byValue(restraintTypeValue));
		output.setRestraintsStatus(RestraintsStatus.byValue(restraintsStatusValue));

		// 子步骤3 获取现金不收不付限制标志：根据{账号}访问《检查是否存在现金不收不付限制》（ST014）
		Map<String, Object> nonReceiptNonPaymentResp = externalTaskClient.executeValidationST014(
				singleEntryMap("baseAcctNo", input.getBaseAcctNo()));
		String cashNonReceiptNonPaymentFlag = extractString(nonReceiptNonPaymentResp,
				"cashNonReceiptNonPaymentFlag");
		output.setCashNonReceiptNonPaymentFlag(cashNonReceiptNonPaymentFlag);

		// 子步骤4 检查现金不收不付限制标志：等于“是”返回错误码 ER0043，否则继续执行
		if (FLAG_YES.equals(cashNonReceiptNonPaymentFlag)) {
			output.setErrorCode("ER0043");
			output.setErrorMessage("ER0043::存在现金不收不付限制");
			return output;
		}

		// 子步骤5 获取现金止收标志：根据{账号}访问《检查是否存在现金止收限制》（ST008）
		Map<String, Object> stopReceiptResp = externalTaskClient.executeValidationST008(
				singleEntryMap("baseAcctNo", input.getBaseAcctNo()));
		String cashStopReceiptFlag = extractString(stopReceiptResp, "cashStopReceiptFlag");
		output.setCashStopReceiptFlag(cashStopReceiptFlag);

		// 子步骤6 检查现金止收标志：等于“是”返回错误码 ER0044，否则继续执行
		if (FLAG_YES.equals(cashStopReceiptFlag)) {
			output.setErrorCode("ER0044");
			output.setErrorMessage("ER0044::存在现金止收限制");
			return output;
		}

		// 子步骤7 获取账户属性限制标志：根据[账户限制信息]访问《检查是否存在属性限制》（ST015）
		Map<String, Object> natureRequest = new HashMap<>();
		natureRequest.put("restraintType", restraintTypeValue);
		natureRequest.put("restraintsStatus", restraintsStatusValue);
		Map<String, Object> natureResp = externalTaskClient.executeValidationST015(natureRequest);
		String natureRestraintFlag = extractString(natureResp, "natureRestraintFlag");
		output.setNatureRestraintFlag(natureRestraintFlag);

		// 子步骤8 检查属性限制标志：等于“是”跳转至子步骤《获取限制豁免信息》(11)，否则继续执行子步骤9、10
		if (!FLAG_YES.equals(natureRestraintFlag)) {
			// 子步骤9 执行限制优先级检查：根据{交易类型}和[账户限制信息]的限制类型访问《检查限制优先级》（ST011）
			Map<String, Object> priorityRequest = new HashMap<>();
			priorityRequest.put("tranType", input.getTranType().getValue());
			priorityRequest.put("restraintType", restraintTypeValue);
			Map<String, Object> priorityResp = externalTaskClient.executeValidationST011(priorityRequest);
			String checkResult = extractString(priorityResp, "checkResult");

			// 子步骤10 根据检查结果判断限制检查分支：为“不检查限制”则返回检查结果“通过”，否则继续执行
			if (CHECK_RESULT_NO_CHECK.equals(checkResult)) {
				output.setSucceed(true);
				return output;
			}
		}

		// 子步骤11 获取限制豁免信息：根据[账户限制信息]的限制类型、{交易类型}、{交易渠道编号}、{产品编号}、{摘要码}
		// 访问《检查限制豁免》（ST002）
		Map<String, Object> exemptionRequest = new HashMap<>();
		exemptionRequest.put("restraintType", restraintTypeValue);
		exemptionRequest.put("tranType", input.getTranType().getValue());
		exemptionRequest.put("channelNo", input.getChannelNo());
		exemptionRequest.put("prodNo", input.getProdNo());
		exemptionRequest.put("narrativeCode", input.getNarrativeCode());
		Map<String, Object> exemptionResp = externalTaskClient.executeValidationST002(exemptionRequest);
		String executeResult = extractString(exemptionResp, "executeResult");

		// 子步骤12 检查账户限制豁免：[执行结果]为“豁免”返回检查结果“通过”，否则返回错误码 ER0045
		if (EXECUTE_RESULT_EXEMPT.equals(executeResult)) {
			output.setSucceed(true);
			return output;
		}
		output.setErrorCode("ER0045");
		output.setErrorMessage("ER0045::账户限制未豁免");
		return output;
	}

	/**
	 * 构建单键请求Map（按{账号}等单参数外部调用）
	 */
	private Map<String, Object> singleEntryMap(String key, Object value) {
		Map<String, Object> map = new HashMap<>();
		map.put(key, value);
		return map;
	}

	/**
	 * 从外部响应Map中读取字符串字段，响应或字段缺失时返回 null
	 */
	private String extractString(Map<String, Object> response, String key) {
		if (response == null) {
			return null;
		}
		Object value = response.get(key);
		return value == null ? null : String.valueOf(value);
	}
}
