package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST037InputBO;
import com.dcits.deposit.facade.bo.ST037OutputBO;

/**
 * ST037 获取限额场景编码 步骤接口。
 *
 * <p>交易执行步骤，仅按输入 limitSceneNo、tranDate 等查询限额控制配置与
 * 限额控制客户自定义配置，无本地数据写入，不要求调用方事务。</p>
 */
public interface IST037 {

    /**
     * 执行获取限额场景编码。
     *
     * @param input 输入 BO（baseAcctNo、clientNo、limitSceneNo、tranDate）
     * @return 输出 BO（限额控制配置 / 限额控制客户自定义配置来源字段及回显字段）
     */
    ST037OutputBO execute(ST037InputBO input);
}
