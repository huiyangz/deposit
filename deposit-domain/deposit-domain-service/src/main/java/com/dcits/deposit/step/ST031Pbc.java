package com.dcits.deposit.step;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.facade.bo.ST031InputBO;
import com.dcits.deposit.facade.bo.ST031OutputBO;
import com.dcits.deposit.rule.BR002;

/**
 * ST031 计算账户执行利率
 */
@Service
public class ST031Pbc implements IST031 {

	/** 产品管理《查询产品利率信息》返回的产品利率字段名 */
	private static final String PROD_INT_RATE_KEY = "prodIntRate";

	private final ExternalTaskClient externalTaskClient;

	public ST031Pbc(ExternalTaskClient externalTaskClient) {
		this.externalTaskClient = externalTaskClient;
	}

	@Override
	public ST031OutputBO execute(ST031InputBO input) {
		ST031OutputBO output = new ST031OutputBO();

		// 子步骤1 获取产品的产品利率：根据{产品编号}访问业务组件《产品管理》的《查询产品利率信息》，取返回字段 prodIntRate
		Map<String, Object> prodIntRateInfo = externalTaskClient.queryProductInterestRate(input.getProdNo());
		BigDecimal productRate = (BigDecimal) prodIntRateInfo.get(PROD_INT_RATE_KEY);

		// 子步骤2 计算账户执行利率：按{账户利率浮动百分点}、{账户利率浮动百分比}、{账户固定利率}、[产品利率]执行规则《计算账户利率》获取[执行利率]
		BigDecimal realRate = BR002.execute(input.getAcctSpreadRate(), input.getAcctPercentRate(),
				input.getAcctFixedRate(), productRate);

		output.setRealRate(realRate);
		output.setSucceed(true);
		return output;
	}
}
