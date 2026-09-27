package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.facade.bo.ST029InputBO;
import com.dcits.deposit.facade.bo.ST029OutputBO;

/**
 * ST029 设置通兑标志
 *
 * 1.获取产品的通兑标志：根据产品编号、参数KEY值访问业务组件《产品管理》的
 * 业务功能《查询产品信息》，获取产品的通兑标志。
 * 2.设置通兑标志：若输入的通兑标志为空，则赋值通兑标志等于产品的通兑标志。
 *
 * 本步骤无业务失败场景，失败仅由技术异常传播表达。
 */
@Service
public class ST029Pbc implements IST029 {

	private final ExternalTaskClient externalTaskClient;

	public ST029Pbc(ExternalTaskClient externalTaskClient) {
		this.externalTaskClient = externalTaskClient;
	}

	@Override
	public ST029OutputBO execute(ST029InputBO input) {
		ST029OutputBO output = new ST029OutputBO();
		// 子步骤1 获取产品的通兑标志：根据产品编号、参数KEY值调用产品管理《查询产品信息》
		String productAllDraIndValue = externalTaskClient.queryProductInfo(input.getProdNo(), input.getAttrKey());
		// 子步骤2 设置通兑标志：输入通兑标志为空时赋产品的通兑标志，非空时保留输入值
		if (input.getAllDraInd() == null) {
			output.setAllDraInd(AllDraInd.byValue(productAllDraIndValue));
		} else {
			output.setAllDraInd(input.getAllDraInd());
		}
		// 正常完成，无业务失败场景
		output.setSucceed(true);
		return output;
	}
}
