package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST051InputBO;
import com.dcits.deposit.facade.bo.ST051OutputBO;

/** ST051 增加账户限制 步骤接口 */
public interface IST051 {

	/**
	 * 增加账户限制：根据{客户号}查询【客户信息】取得[境内境外标识]、[客户细分类型]，
	 * 按列举的[客户细分类型]赋值[企业标志]，再按{账户属性}{账户用途}[境内境外标识][企业标志]
	 * 查询【企业账户属性控制配置信息】取得[限制类型][限制期限][限制期限类型]，
	 * 以{runDate}为[系统日期]执行规则《计算到期日期》取得[结束日期]，随后经《维护限制组件》
	 * 完成《检查限制类型》《检查是否跨法人》《检查增加限制起始日期》三项检查并《登记账户限制信息》，
	 * 检查不通过分别返回错误码 ER0039/ER0040/ER0041。
	 * 本步骤本地仅查询【客户信息】与【企业账户属性控制配置信息】，限制登记经《维护限制组件》完成，
	 * 本地无数据库写入，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 增加账户限制输出BO
	 */
	ST051OutputBO execute(ST051InputBO input);
}
