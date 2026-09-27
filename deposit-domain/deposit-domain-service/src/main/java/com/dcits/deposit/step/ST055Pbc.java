package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.SpecAcctFlag;
import com.dcits.deposit.facade.bo.ST055InputBO;
import com.dcits.deposit.facade.bo.ST055OutputBO;
import com.dcits.deposit.facade.components.IFmBranchBcc;
import com.dcits.deposit.facade.components.IFmClientCopyBcc;
import com.dcits.deposit.facade.eo.FmBranchEO;
import com.dcits.deposit.facade.eo.FmClientCopyEO;
import com.dcits.deposit.rule.BR006;

/**
 * ST055 设置账号 步骤实现
 */
@Service
public class ST055Pbc implements IST055 {

	/** 子步骤3 账号生成规则类型：AC */
	private static final String ACCT_GEN_RULE_TYPE = "AC";
	/** 子步骤5.1a {非居民账户标志}比较字面：Y-是（按 SPEC 整串字面比较；输入字段绑定 residentFlag，见已接受的需求处理结论） */
	private static final String NON_RESIDENT_FLAG_YES = "Y-是";
	/** 子步骤5.1a {境内境外标志}比较字面：N-境外（按 SPEC 整串字面比较） */
	private static final String OFFSHORE = "N-境外";
	/** 子步骤5.1a 非居民账户账号前缀 */
	private static final String NRA_PREFIX = "NRA";
	/** 子步骤7/10 自贸区机构标志比较基准：SPEC 字面 Y-是 的编码部分 "Y"；FM_BRANCH.FTA_FLAG 为 VARCHAR(1)
	 * （deposit-infrastructure-service/src/main/resources/ddl/FM_BRANCH.sql），仅能存储编码，
	 * 同"A-全账户定制"按编码 SpecAcctFlag.A 比较的既有惯例 */
	private static final String FTA_FLAG_YES = "Y";
	/** 子步骤10a 前缀：FTI-区内个人自由贸易账户 */
	private static final String PREFIX_FTI = "FTI";
	/** 子步骤10b 前缀：FTF-区内境外个人自由贸易账户 */
	private static final String PREFIX_FTF = "FTF";
	/** 子步骤10c 前缀：FTE-区内机构自由贸易账户 */
	private static final String PREFIX_FTE = "FTE";
	/** 子步骤10d 前缀：FTN-境外机构自由贸易账户 */
	private static final String PREFIX_FTN = "FTN";
	/** 子步骤10e 前缀：FTU-同业机构自由贸易账户 */
	private static final String PREFIX_FTU = "FTU";

	private final ExternalTaskClient externalTaskClient;
	private final IFmBranchBcc fmBranchBcc;
	private final IFmClientCopyBcc fmClientCopyBcc;

	public ST055Pbc(ExternalTaskClient externalTaskClient, IFmBranchBcc fmBranchBcc,
			IFmClientCopyBcc fmClientCopyBcc) {
		this.externalTaskClient = externalTaskClient;
		this.fmBranchBcc = fmBranchBcc;
		this.fmClientCopyBcc = fmClientCopyBcc;
	}

	@Override
	public ST055OutputBO execute(ST055InputBO input) {
		ST055OutputBO output = new ST055OutputBO();

		// [账号] 中间数据
		String acctNo;

		// 子步骤1 检查定制账户标志：等于"A-全账户定制"跳转《赋值定制账号》，否则跳转《设置账号生成规则类型》
		if (input.getSpecAcctFlag() == SpecAcctFlag.A) {
			// 子步骤2 赋值定制账号：赋值[账号]为{账号}
			acctNo = input.getBaseAcctNo();
		} else {
			// 子步骤3 设置账号生成规则类型：赋值[账号生成规则类型]等于"AC"
			// 子步骤4 生成账号：按[账号生成规则类型]、{交易机构}、{产品编号}调用基础公共《生成账号》，赋值[账号]为$账号$
			acctNo = externalTaskClient.genAcctNo(ACCT_GEN_RULE_TYPE, input.getTranBranch().getValue(),
					input.getProdNo());
		}

		// 子步骤5.1 设置账号前缀：
		// a.若{非居民账户标志}等于"Y-是"且{境内境外标志}等于"N-境外"，则赋值[账号]为"NRA"+[账号]
		if (NON_RESIDENT_FLAG_YES.equals(input.getResidentFlag())
				&& OFFSHORE.equals(input.getInlandOffshore())) {
			acctNo = NRA_PREFIX + acctNo;
		}
		// b.若{非居民账户标志}等于"N-否"，则赋值[账号]为[账号]（保持原值，无前缀）

		// 子步骤6 获取自贸区机构标志：根据{开户机构}查询【机构信息】获取$自贸区机构标志$
		FmBranchEO fmBranchEO = fmBranchBcc.findByBranch(input.getAcctBranch());

		// 子步骤7 设置非自贸区机构账户的账号：[自贸区机构标志]非"Y-是"则返回输出参数[账号]
		if (!FTA_FLAG_YES.equals(fmBranchEO.getFtaFlag())) {
			output.setBaseAcctNo(acctNo);
			output.setSucceed(true);
			return output;
		}

		// 子步骤8 获取客户信息：根据{客户号}查询【客户信息】获取$境内境外标志$$税收居民标志$$客户类型$$对私客户标志$
		FmClientCopyEO clientEO = fmClientCopyBcc.findByPrimaryKey(input.getClientNo());

		// 子步骤9 获取自贸区种类：按客户信息四要素执行规则《设置自贸区种类》获取[自贸区种类]
		AcctNatureNo ftaType = BR006.execute(clientEO.getIsIndividual(), clientEO.getTaxResidentFlag(),
				clientEO.getClientType(), clientEO.getInlandOffshore());

		// 子步骤10 设置自贸区机构账户的账号：按[自贸区种类]拼接前缀后返回输出参数[账号]
		acctNo = resolveFtaPrefix(ftaType) + acctNo;

		output.setBaseAcctNo(acctNo);
		output.setSucceed(true);
		return output;
	}

	/**
	 * 子步骤10 按[自贸区种类]返回拼接前缀；无对应种类（含规则未命中返回 null）时返回空串，不加前缀
	 */
	private String resolveFtaPrefix(AcctNatureNo ftaType) {
		// a.FTI-区内个人自由贸易账户
		if (AcctNatureNo.VALUE_3605 == ftaType) {
			return PREFIX_FTI;
		}
		// b.FTF-区内境外个人自由贸易账户
		if (AcctNatureNo.VALUE_3606 == ftaType) {
			return PREFIX_FTF;
		}
		// c.FTE-区内机构自由贸易账户
		if (AcctNatureNo.VALUE_3603 == ftaType) {
			return PREFIX_FTE;
		}
		// d.FTN-境外机构自由贸易账户
		if (AcctNatureNo.VALUE_3604 == ftaType) {
			return PREFIX_FTN;
		}
		// e.FTU-同业机构自由贸易账户
		if (AcctNatureNo.VALUE_3607 == ftaType) {
			return PREFIX_FTU;
		}
		return "";
	}
}
