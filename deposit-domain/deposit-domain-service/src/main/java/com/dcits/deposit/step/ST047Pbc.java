package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.AllDepInd;
import com.dcits.deposit.facade.bo.ST047InputBO;
import com.dcits.deposit.facade.bo.ST047OutputBO;

/**
 * ST047 设置通存标志 步骤实现
 *
 * 步骤描述：
 * 1.获取产品的通存标识：根据{产品编号}、{参数KEY值}访问业务组件《产品管理》的业务功能《查询产品信息》，获取$通存标识$。
 * 2.设置通存标识：若{通存标识}为空，则赋值[通存标识]等于子步骤1获取的$通存标识$；否则赋值[通存标识]等于{通存标识}。
 */
@Service
public class ST047Pbc implements IST047 {

	private final ExternalTaskClient externalTaskClient;

	public ST047Pbc(ExternalTaskClient externalTaskClient) {
		this.externalTaskClient = externalTaskClient;
	}

	@Override
	public ST047OutputBO execute(ST047InputBO input) {
		ST047OutputBO output = new ST047OutputBO();

		// 子步骤1 获取产品的通存标识：根据{产品编号}、{参数KEY值}调用《产品管理》《查询产品信息》取得$通存标识$
		String remoteAllDepInd = externalTaskClient.queryProductInfo(input.getProdNo(), input.getAttrKey());

		// 子步骤2 设置通存标识：{通存标识}为空时赋值[通存标识]等于$通存标识$，否则沿用输入{通存标识}
		if (input.getAllDepInd() == null) {
			output.setAllDepInd(AllDepInd.byValue(remoteAllDepInd));
		} else {
			output.setAllDepInd(input.getAllDepInd());
		}

		output.setSucceed(true);
		return output;
	}
}
