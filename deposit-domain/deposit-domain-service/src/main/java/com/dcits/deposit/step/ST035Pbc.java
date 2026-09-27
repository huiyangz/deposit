package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST035InputBO;
import com.dcits.deposit.facade.bo.ST035OutputBO;

/**
 * ST035 检查利率浮动类型
 */
@Service
public class ST035Pbc implements IST035 {

	/** 检查通过结果 */
	private static final String CHECK_RESULT_PASS = "通过";

	@Override
	public ST035OutputBO execute(ST035InputBO input) {
		ST035OutputBO output = new ST035OutputBO();

		// 子步骤1 检查利率浮动信息必输性：{账户利率浮动百分点}、{账户利率浮动百分比}、{账户固定利率}三者只有一个不为空则返回检查结果"通过"，否则返回错误码 ER0032
		int notNullCount = 0;
		if (input.getAcctSpreadRate() != null) {
			notNullCount++;
		}
		if (input.getAcctPercentRate() != null) {
			notNullCount++;
		}
		if (input.getAcctFixedRate() != null) {
			notNullCount++;
		}
		if (notNullCount != 1) {
			output.setErrorCode("ER0032");
			output.setErrorMessage("ER0032::利率浮动信息必输性检查不通过");
			return output;
		}
		output.setCheckResult(CHECK_RESULT_PASS);
		output.setSucceed(true);
		return output;
	}
}
