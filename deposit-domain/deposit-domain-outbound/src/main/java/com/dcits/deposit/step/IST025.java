package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST025InputBO;
import com.dcits.deposit.facade.bo.ST025OutputBO;

/**
 * ST025 检查币种 步骤接口
 *
 * 仅跨组件查询与结果检查，不涉及本地数据库读写，无本地事务要求。
 */
public interface IST025 {

	/**
	 * 检查账户币种是否在产品配置范围内。
	 *
	 * 集合包含输入币种时 succeed=true；不包含时 succeed=false，errorCode=ER0023。
	 *
	 * @param input 输入BO（ccy 币种、prodNo 产品编号、attrKey 参数KEY值，均必填）
	 * @return 步骤输出BO（成功标志与错误码/错误信息）
	 */
	ST025OutputBO execute(ST025InputBO input);
}
