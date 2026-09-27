package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.facade.bo.ST040InputBO;
import com.dcits.deposit.facade.bo.ST040OutputBO;
import com.dcits.deposit.rule.BR003;

/**
 * ST040 检查允许转久悬标志
 */
@Service
public class ST040Pbc implements IST040 {

	/** 检查通过结果 */
	private static final String CHECK_RESULT_PASS = "通过";

	private final ExternalTaskClient externalTaskClient;

	public ST040Pbc(ExternalTaskClient externalTaskClient) {
		this.externalTaskClient = externalTaskClient;
	}

	@Override
	public ST040OutputBO execute(ST040InputBO input) {
		ST040OutputBO output = new ST040OutputBO();

		// 子步骤1 获取产品的是否允许转久悬标志：根据{产品编号}、{参数KEY值}访问业务组件《产品管理》的《查询产品信息》，获取$是否允许转久悬$
		String allowDormantFlag = externalTaskClient.queryProductInfo(input.getProdNo(), input.getAttrKey());

		// 子步骤2 检查允许转久悬标志：根据{允许账户转久悬标志}和产品的[是否允许转久悬]标志执行规则《检查允许转久悬标志》，获取[执行结果]
		boolean executeResult = BR003.execute(input.getAllowSuspendFlag(), allowDormantFlag);

		// 子步骤3 检查执行结果：[执行结果]为是则返回检查结果"通过"，否则返回错误码 ER0030
		if (!executeResult) {
			output.setErrorCode("ER0030");
			output.setErrorMessage("ER0030::检查允许转久悬标志未通过");
			return output;
		}
		output.setCheckResult(CHECK_RESULT_PASS);
		output.setSucceed(true);
		return output;
	}
}
