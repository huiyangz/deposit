package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST032InputBO;
import com.dcits.deposit.facade.bo.ST032OutputBO;

/** ST032 检查账户机构 步骤接口 */
public interface IST032 {

	/**
	 * 检查账户机构：根据{产品编号}、{参数KEY值}访问业务组件《产品管理》的业务功能《查询产品信息》获取[机构]列表，
	 * 检查产品配置的机构是否包含{交易机构}；包含时检查通过（succeed=true、错误字段为空），
	 * 否则返回错误码 ER0005（succeed=false）。
	 * 本步骤仅外部只读查询，不涉及本地数据库写入，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 检查结果输出BO
	 */
	ST032OutputBO execute(ST032InputBO input);
}
