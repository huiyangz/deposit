package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST044InputBO;
import com.dcits.deposit.facade.bo.ST044OutputBO;

/**
 * ST044 设置账户开户日期
 *
 * <p>获取系统日期（输入 runDate，来源系统日期表 FM_DATE），赋值并返回账户开户日期等于系统日期。
 * 本步骤不发生本地数据库读写，无事务要求；无业务失败场景，失败仅由技术异常传播表达。
 */
public interface IST044 {

    /**
     * 设置账户开户日期。
     *
     * @param input 输入BO，runDate 为必填的核心运行日期
     * @return 输出BO，succeed=true 且 acctOpenDate 等于输入 runDate
     */
    ST044OutputBO execute(ST044InputBO input);
}
