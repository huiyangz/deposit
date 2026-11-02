package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST015InputBO;
import com.dcits.deposit.facade.bo.ST015OutputBO;

/**
 * ST015 检查靠档标识 步骤接口。
 */
public interface IST015 {

    /**
     * 执行检查靠档标识步骤。
     *
     * @param input 步骤输入（baseAcctNo）
     * @return 步骤输出（isOverMonthSeasonOd 及按 GotoStepCondition 契约确定的跳转目标）
     */
    ST015OutputBO execute(ST015InputBO input);
}
