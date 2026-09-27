package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST012InputBO;
import com.dcits.deposit.facade.bo.ST012OutputBO;

/**
 * ST012 更新存入后账户余额 步骤接口
 *
 * 事务要求：本步骤更新本地账户余额表（RB_BUS_ACCT_BALANCE），实现使用 Spring 声明式事务；
 * 调用方如需与其他本地写入保持原子性，应在外层统一开启事务，本步骤不承诺跨组件原子事务。
 */
public interface IST012 {

    /**
     * 根据账号查询对公存款账户主表获取账户内部键值，再查询账户余额表获取原汇总金额，
     * 将汇总金额更新为原汇总金额+交易金额。
     *
     * @param input 账号、交易金额
     * @return 更新后的汇总金额与账户可用余额；本步骤无业务失败场景，失败仅由技术异常传播表达
     */
    ST012OutputBO execute(ST012InputBO input);
}
