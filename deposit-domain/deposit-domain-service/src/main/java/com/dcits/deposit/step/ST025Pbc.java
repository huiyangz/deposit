package com.dcits.deposit.step;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.facade.bo.ST025InputBO;
import com.dcits.deposit.facade.bo.ST025OutputBO;

/**
 * ST025 检查币种
 *
 * 步骤描述：
 * 1.获取产品的币种：根据产品编号、参数KEY值访问业务组件《产品管理》的业务功能《查询产品信息》，获取产品币种集合；
 * 2.检查账户币种是否在产品配置范围内：若产品币种集合包含输入币种，则本步骤成功返回（succeed=true），
 * 否则本步骤失败返回（succeed=false）并返回错误码 ER0023。
 *
 * 集合表示约定：queryProductInfo 返回逗号分隔的币种代码串（如 "CNY,USD,EUR"），
 * 「包含」按元素精确匹配判定（非子串包含）；依赖查不到记录时按契约返回空串，即空集合。
 */
@Service
public class ST025Pbc implements IST025 {

	private final ExternalTaskClient externalTaskClient;

	public ST025Pbc(ExternalTaskClient externalTaskClient) {
		this.externalTaskClient = externalTaskClient;
	}

	@Override
	public ST025OutputBO execute(ST025InputBO input) {
		ST025OutputBO output = new ST025OutputBO();
		// 子步骤1：获取产品的币种——按产品编号+参数KEY值调用《产品管理·查询产品信息》，取得产品币种集合串
		String ccyCollection = externalTaskClient.queryProductInfo(input.getProdNo(), input.getAttrKey());
		// 子步骤2：检查账户币种是否在产品配置范围内——集合元素精确匹配输入币种
		if (containsCcy(ccyCollection, input.getCcy().getValue())) {
			// 包含分支：本步骤成功返回
			output.setSucceed(true);
		} else {
			// 否则分支：本步骤失败返回，错误码 ER0023（账户币种不在产品配置范围内）
			output.setSucceed(false);
			output.setErrorCode("ER0023");
			output.setErrorMessage("ER0023::账户币种不在产品配置范围内");
		}
		return output;
	}

	/**
	 * 判断逗号分隔的币种集合串是否包含指定币种（元素精确匹配，非子串包含）。
	 *
	 * @param ccyCollection 产品币种集合串（逗号分隔），空串或 null 视为空集合
	 * @param ccyValue 输入币种编码
	 * @return 是否包含
	 */
	private boolean containsCcy(String ccyCollection, String ccyValue) {
		if (ccyCollection == null || ccyCollection.isEmpty()) {
			return false;
		}
		return Arrays.stream(ccyCollection.split(","))
				.map(String::trim)
				.anyMatch(ccyValue::equals);
	}
}
