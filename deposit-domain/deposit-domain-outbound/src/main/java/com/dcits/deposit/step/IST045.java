package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST045InputBO;
import com.dcits.deposit.facade.bo.ST045OutputBO;

/** ST045 设置生效日期 步骤接口 */
public interface IST045 {

	/**
	 * 设置生效日期：赋值[系统日期]为{运行日期}；{生效日期}不等于空时赋值输出$生效日期$为{生效日期}，
	 * {生效日期}等于空时赋值输出$生效日期$为[系统日期]。
	 * 本步骤为纯日期赋值逻辑，不涉及本地数据库访问，无事务要求；无业务失败场景。
	 *
	 * @param input 输入BO
	 * @return 生效日期输出BO
	 */
	ST045OutputBO execute(ST045InputBO input);
}
