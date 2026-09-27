package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST014InputBO;
import com.dcits.deposit.facade.bo.ST014OutputBO;

/**
 * ST014 登记代办人信息 步骤接口
 *
 * 事务要求：代办人名称不为空时向本地库代办人登记表（RB_COMMISSION_REGISTER）新增记录，
 * 实现方法已标注 @Transactional，调用方按 Spring 事务语义使用。
 */
public interface IST014 {

    /**
     * 登记代办人信息。
     * 若代办人名称不为空（null 或空字符串视为空），按步骤描述 14 项记录清单登记代办人信息，
     * 并按输出表回显 16 个业务字段；条件不成立时跳过登记，正常返回成功。
     * 本步骤无业务失败场景，失败仅由技术异常传播表达。
     *
     * @param input 步骤输入
     * @return 步骤输出，登记信息回显
     */
    ST014OutputBO execute(ST014InputBO input);
}
