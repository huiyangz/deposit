package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.CategoryType;
import com.dcits.deposit.facade.bo.ST026InputBO;
import com.dcits.deposit.facade.bo.ST026OutputBO;
import com.dcits.deposit.facade.components.IFmClientCopyBcc;
import com.dcits.deposit.facade.eo.FmClientCopyEO;
import com.dcits.deposit.rule.DT001;

/**
 * ST026 设置账户状态
 */
@Service
public class ST026Pbc implements IST026 {

	/** 企业标志：是 */
	private static final String CORPORATION_FLAG_YES = "是";
	/** 企业标志：否 */
	private static final String CORPORATION_FLAG_NO = "否";

	private final IFmClientCopyBcc fmClientCopyBcc;

	public ST026Pbc(IFmClientCopyBcc fmClientCopyBcc) {
		this.fmClientCopyBcc = fmClientCopyBcc;
	}

	@Override
	public ST026OutputBO execute(ST026InputBO input) {
		ST026OutputBO output = new ST026OutputBO();

		// 子步骤1 获取客户信息：根据{客户号}查询【客户信息】获取[境内境外标识]、[客户细分类型]
		FmClientCopyEO clientCopy = fmClientCopyBcc.findByPrimaryKey(input.getClientNo());
		String inlandOffshore = clientCopy.getInlandOffshore();
		CategoryType categoryType = clientCopy.getCategoryType();

		// 子步骤2 获取企业标志：客户细分类型为一人公司、非法人企业、有字号的个体工商户、无字号的个体工商户则企业标志为"是"，否则为"否"
		String corporationFlag = resolveCorporationFlag(categoryType);

		// 子步骤3 获取账户状态：根据{账户用途}、{账户属性}、[企业标志]、[境内境外标识]执行规则《根据核准类型设置账户状态》
		AcctStatus acctStatus = DT001.execute(input.getRbBusAcctPurpose(), input.getAcctNatureNo(),
				corporationFlag, inlandOffshore);

		// 子步骤4 赋值账户状态：[账户状态]为空值（null）则返回错误码 ER0063，否则赋值账户状态
		if (acctStatus == null) {
			output.setErrorCode("ER0063");
			output.setErrorMessage("ER0063::根据核准类型设置账户状态获取的账户状态为空值");
			return output;
		}
		output.setAcctStatus(acctStatus);
		output.setSucceed(true);
		return output;
	}

	/**
	 * 子步骤2 判定企业标志：客户细分类型命中一人公司、非法人企业、有字号的个体工商户、无字号的个体工商户为"是"，否则为"否"
	 */
	private String resolveCorporationFlag(CategoryType categoryType) {
		if (CategoryType.VALUE_204 == categoryType || CategoryType.VALUE_205 == categoryType
				|| CategoryType.VALUE_207 == categoryType || CategoryType.VALUE_208 == categoryType) {
			return CORPORATION_FLAG_YES;
		}
		return CORPORATION_FLAG_NO;
	}
}
