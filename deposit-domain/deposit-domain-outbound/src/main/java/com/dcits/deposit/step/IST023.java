package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST023InputBO;
import com.dcits.deposit.facade.bo.ST023OutputBO;

/**
 * ST023 登记代办人信息 步骤接口。
 *
 * <p>若代办人信息数组不为空，将代办人信息登记到代办人登记表（RB_COMMISSION_REGISTER），
 * 返回登记结果；代办人信息数组为空时不登记、不新增记录，步骤正常成功结束。</p>
 *
 * <p>事务要求：本步骤执行代办人登记表本地新增写入，实现使用 Spring {@code @Transactional}，
 * 调用方须在事务边界内调用。</p>
 */
public interface IST023 {

    /**
     * 执行登记代办人信息步骤。
     *
     * @param input 步骤输入（代办人信息 16 个字段）
     * @return 步骤输出：成功时 {@code succeed=true}、错误字段为 null，业务字段为登记后记录中的对应值
     */
    ST023OutputBO execute(ST023InputBO input);
}
