package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST018InputBO;
import com.dcits.deposit.facade.bo.ST018OutputBO;

/**
 * ST018 检查分行法人透支额度 步骤接口。
 */
public interface IST018 {
    /**
     * 检查分行法人透支额度。
     *
     * <p>本步骤只读查询，不涉及本地数据写入，无需调用方事务要求。</p>
     *
     * @param input 步骤输入
     * @return 步骤输出
     */
    ST018OutputBO execute(ST018InputBO input);
}
