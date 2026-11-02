package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST058InputBO;
import com.dcits.deposit.facade.bo.ST058OutputBO;

/**
 * ST058 检查是否存在不收不付限制 步骤接口。
 */
public interface IST058 {

    /**
     * 执行「检查是否存在不收不付限制」步骤。
     *
     * @param input 输入 BO
     * @return 输出 BO
     */
    ST058OutputBO execute(ST058InputBO input);
}
