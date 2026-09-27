package com.dcits.deposit.step;

import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.CategoryType;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.facade.bo.ST051InputBO;
import com.dcits.deposit.facade.bo.ST051OutputBO;
import com.dcits.deposit.facade.components.IFmClientCopyBcc;
import com.dcits.deposit.facade.components.IRbCorpNatureDefBcc;
import com.dcits.deposit.facade.eo.FmClientCopyEO;
import com.dcits.deposit.facade.eo.RbCorpNatureDefEO;
import com.dcits.deposit.rule.BR005;

/**
 * ST051 增加账户限制 步骤实现
 *
 * 步骤描述：
 * 1.获取境内境外标识：根据{客户号}查询【客户信息】获取[境内境外标识]、[客户细分类型]
 * 2.赋值企业标志：[客户细分类型]等于"一人公司""非法人企业""有字号的个体工商户""无字号的个体工商户"
 *   时赋值[企业标志]等于"是"，否则等于"否"
 * 3.获取限制信息：根据{账户属性}{账户用途}[境内境外标识][企业标志]查询【企业账户属性控制配置信息】
 *   获取[限制类型][限制期限][限制期限类型]
 * 4.获取系统日期：赋值[系统日期]为{runDate}
 * 5.计算结束日期：执行规则《计算到期日期》获取[结束日期]
 * 6-7.经《维护限制组件》《检查限制类型》获取[检查结果]，非"通过"返回错误码 ER0039
 * 8-9.经《维护限制组件》《检查是否跨法人》获取[检查结果]，非"通过"返回错误码 ER0040
 * 10-11.经《维护限制组件》《检查增加限制起始日期》获取[检查结果]，非"通过"返回错误码 ER0041
 * 12.经《维护限制组件》《登记账户限制信息》完成登记
 */
@Service
public class ST051Pbc implements IST051 {

	/** 跨组件调用Map中检查结果的键名（对方接口字段契约未提供，属ST051已接受的需求处理结论，传参与读取在本实现内保持一致） */
	private static final String KEY_CHECK_RESULT = "checkResult";
	/** 跨组件调用Map参数键：账号 */
	private static final String KEY_BASE_ACCT_NO = "baseAcctNo";
	/** 跨组件调用Map参数键：交易机构 */
	private static final String KEY_TRAN_BRANCH = "tranBranch";
	/** 跨组件调用Map参数键：限制类型 */
	private static final String KEY_RESTRAINT_TYPE = "restraintType";
	/** 跨组件调用Map参数键：限制期限 */
	private static final String KEY_TERM = "term";
	/** 跨组件调用Map参数键：限制期限类型 */
	private static final String KEY_TERM_TYPE = "termType";
	/** 跨组件调用Map参数键：结束日期 */
	private static final String KEY_END_DATE = "endDate";
	/** 跨组件调用Map参数键：系统日期 */
	private static final String KEY_SYSTEM_DATE = "systemDate";
	/** 检查通过结果 */
	private static final String CHECK_RESULT_PASS = "通过";
	/** 企业标志"是" */
	private static final String CORPORATION_YES = "是";
	/** 企业标志"否" */
	private static final String CORPORATION_NO = "否";

	/** 子步骤2列举的企业类客户细分类型：一人公司、非法人企业、有字号的个体工商户、无字号的个体工商户 */
	private static final Set<CategoryType> CORPORATION_CATEGORY_TYPES = EnumSet.of(
			CategoryType.VALUE_204, CategoryType.VALUE_205, CategoryType.VALUE_207, CategoryType.VALUE_208);

	private final IFmClientCopyBcc fmClientCopyBcc;
	private final IRbCorpNatureDefBcc rbCorpNatureDefBcc;
	private final ExternalTaskClient externalTaskClient;

	public ST051Pbc(IFmClientCopyBcc fmClientCopyBcc, IRbCorpNatureDefBcc rbCorpNatureDefBcc,
			ExternalTaskClient externalTaskClient) {
		this.fmClientCopyBcc = fmClientCopyBcc;
		this.rbCorpNatureDefBcc = rbCorpNatureDefBcc;
		this.externalTaskClient = externalTaskClient;
	}

	@Override
	public ST051OutputBO execute(ST051InputBO input) {
		ST051OutputBO output = new ST051OutputBO();

		// 子步骤1 获取境内境外标识：根据{客户号}查询【客户信息】获取[境内境外标识]、[客户细分类型]
		FmClientCopyEO clientCopy = fmClientCopyBcc.findByPrimaryKey(input.getClientNo());
		String inlandOffshore = clientCopy.getInlandOffshore();

		// 子步骤2 赋值企业标志：[客户细分类型]等于列举四类时[企业标志]="是"，否则"否"
		String corporation = CORPORATION_CATEGORY_TYPES.contains(clientCopy.getCategoryType())
				? CORPORATION_YES : CORPORATION_NO;

		// 子步骤3 获取限制信息：按{账户属性}{账户用途}[境内境外标识][企业标志]查询【企业账户属性控制配置信息】
		// 获取[限制类型][限制期限][限制期限类型]
		RbCorpNatureDefEO queryEo = new RbCorpNatureDefEO();
		queryEo.setAcctNatureNo(input.getAcctNatureNo());
		queryEo.setRbBusAcctPurpose(input.getRbBusAcctPurpose());
		queryEo.setInlandOffshore(inlandOffshore);
		queryEo.setCorporation(corporation);
		RbCorpNatureDefEO natureDef = rbCorpNatureDefBcc.findByEo(queryEo).get(0);
		RestraintType restraintType = natureDef.getRestraintType();
		String term = natureDef.getTerm();
		TermType termType = natureDef.getTermType();

		// 子步骤4 获取系统日期：赋值[系统日期]为{runDate}
		Date systemDate = input.getRunDate();

		// 子步骤5 计算结束日期：根据[系统日期]、[限制期限]、[限制期限类型]执行规则《计算到期日期》获取[结束日期]
		Date endDate = BR005.execute(systemDate, term, termType);

		// 子步骤6 检查限制类型：根据{账号}、[限制类型]、[限制期限]、[限制期限类型]、[结束日期]、[系统日期]
		// 访问《维护限制组件》《检查限制类型》获取[检查结果]
		Map<String, Object> checkTypeResult = externalTaskClient.executeRestrictionST001(
				buildRestraintParamMap(input, restraintType, term, termType, endDate, systemDate));
		// 子步骤7 检查检查结果：[检查结果]为"通过"继续执行，否则返回错误码 ER0039
		if (!CHECK_RESULT_PASS.equals(checkTypeResult.get(KEY_CHECK_RESULT))) {
			output.setErrorCode("ER0039");
			output.setErrorMessage("ER0039::检查限制类型不通过");
			return output;
		}

		// 子步骤8 检查是否跨法人：根据{账号}、{交易机构}访问《维护限制组件》《检查是否跨法人》获取[检查结果]
		Map<String, Object> crossLegalResult = externalTaskClient.executeRestrictionST002(
				buildCrossLegalParamMap(input));
		// 子步骤9 检查检查结果：[检查结果]为"通过"继续执行，否则返回错误码 ER0040
		if (!CHECK_RESULT_PASS.equals(crossLegalResult.get(KEY_CHECK_RESULT))) {
			output.setErrorCode("ER0040");
			output.setErrorMessage("ER0040::检查是否跨法人不通过");
			return output;
		}

		// 子步骤10 检查增加限制起始日期：根据{账号}、[限制类型]、[限制期限]、[限制期限类型]、[结束日期]、[系统日期]
		// 访问《维护限制组件》《检查增加限制起始日期》获取[检查结果]
		Map<String, Object> startDateResult = externalTaskClient.executeRestrictionST003(
				buildRestraintParamMap(input, restraintType, term, termType, endDate, systemDate));
		// 子步骤11 检查检查结果：[检查结果]为"通过"继续执行，否则返回错误码 ER0041
		if (!CHECK_RESULT_PASS.equals(startDateResult.get(KEY_CHECK_RESULT))) {
			output.setErrorCode("ER0041");
			output.setErrorMessage("ER0041::检查增加限制起始日期不通过");
			return output;
		}

		// 子步骤12 登记账户限制信息：根据{账号}、[限制类型]、[限制期限]、[限制期限类型]、[结束日期]、[系统日期]
		// 访问《维护限制组件》《登记账户限制信息》
		externalTaskClient.executeRestrictionST004(
				buildRestraintParamMap(input, restraintType, term, termType, endDate, systemDate));

		output.setEndDate(endDate);
		output.setBaseAcctNo(input.getBaseAcctNo());
		output.setRestraintType(restraintType);
		output.setTerm(term);
		output.setTermType(termType);
		output.setSucceed(true);
		return output;
	}

	/**
	 * 构造子步骤6/10/12 跨组件调用参数：{账号}、[限制类型]、[限制期限]、[限制期限类型]、[结束日期]、[系统日期]
	 */
	private Map<String, Object> buildRestraintParamMap(ST051InputBO input, RestraintType restraintType,
			String term, TermType termType, Date endDate, Date systemDate) {
		Map<String, Object> bo = new HashMap<>();
		bo.put(KEY_BASE_ACCT_NO, input.getBaseAcctNo());
		bo.put(KEY_RESTRAINT_TYPE, restraintType);
		bo.put(KEY_TERM, term);
		bo.put(KEY_TERM_TYPE, termType);
		bo.put(KEY_END_DATE, endDate);
		bo.put(KEY_SYSTEM_DATE, systemDate);
		return bo;
	}

	/**
	 * 构造子步骤8 跨组件调用参数：{账号}、{交易机构}
	 */
	private Map<String, Object> buildCrossLegalParamMap(ST051InputBO input) {
		Map<String, Object> bo = new HashMap<>();
		bo.put(KEY_BASE_ACCT_NO, input.getBaseAcctNo());
		bo.put(KEY_TRAN_BRANCH, input.getTranBranch());
		return bo;
	}
}
