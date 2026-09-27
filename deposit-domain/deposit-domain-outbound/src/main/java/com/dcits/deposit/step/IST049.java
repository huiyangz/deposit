package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST049InputBO;
import com.dcits.deposit.facade.bo.ST049OutputBO;

/** ST049 检查账户执行利率 步骤接口 */
public interface IST049 {

	/**
	 * 检查账户执行利率：根据{产品编号}访问业务组件《产品管理》的业务功能《查询产品利率信息》，
	 * 获取$产品利率$、$最大执行利率$、$最小执行利率$；若[最大执行利率]或[最小执行利率]为空
	 * （未查询到产品利率信息），或者[执行利率]大于[最大执行利率]，或者小于[最小执行利率]，
	 * 返回错误码 ER0033，否则检查通过并原样输出{执行利率}。
	 * 产品利率信息表（MB_PROD_INT）经《产品管理》外部访问，本步骤本地无数据库读写，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 检查账户执行利率输出BO
	 */
	ST049OutputBO execute(ST049InputBO input);
}
