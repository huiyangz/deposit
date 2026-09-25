package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST054InputBO;
import com.dcits.deposit.facade.bo.ST054OutputBO;

/**
 * ST054 设置账户执行利率 步骤接口。
 *
 * <p>赋值账户$执行利率$为[执行利率]。本步骤仅做参数赋值，
 * 不涉及本地数据库读写，无事务要求。</p>
 */
public interface IST054 {

    /**
     * 设置账户执行利率。
     *
     * @param input 输入BO（realRate 必填）
     * @return 输出BO，成功时 succeed=true、realRate 为执行利率
     */
    ST054OutputBO execute(ST054InputBO input);
}
