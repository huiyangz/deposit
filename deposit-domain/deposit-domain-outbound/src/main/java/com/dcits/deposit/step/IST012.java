package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST012InputBO;
import com.dcits.deposit.facade.bo.ST012OutputBO;

/**
 * ST012 检查账户余额 步骤接口。
 */
public interface IST012 {

    /**
     * 执行检查账户余额步骤。
     *
     * @param input 步骤输入
     * @return 步骤输出
     */
    ST012OutputBO execute(ST012InputBO input);
}
