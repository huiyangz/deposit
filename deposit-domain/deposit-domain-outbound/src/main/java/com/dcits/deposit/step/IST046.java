package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST046InputBO;
import com.dcits.deposit.facade.bo.ST046OutputBO;

/**
 * ST046 登记账户信息 步骤接口
 *
 * 事务要求：本步骤新增本地对公存款账户主表（RB_BUS_ACCT）记录，实现使用 Spring 声明式事务；
 * 调用方如需与其他本地写入保持原子性，应在外层统一开启事务，本步骤不承诺跨组件原子事务。
 */
public interface IST046 {

    /**
     * 登记账户辅助信息与账户基本信息：辅助信息中的监管账户类型、监管原因仅在监管账户标志为"是"时登记，
     * 查证金额仅在查证类型为"对资金类业务查证"时登记，查证类型按已接受的需求处理结论无条件登记；
     * 账户内部键值由系统根据账号生成，创建时间戳与最后修改时间戳为当前系统时间，
     * 两个子步骤登记的字段共同构成一条 RB_BUS_ACCT 记录后写入。
     *
     * @param input 账户辅助信息与账户基本信息
     * @return 已登记的对公存款账户主表信息；本步骤无业务失败场景，失败仅由技术异常传播表达
     */
    ST046OutputBO execute(ST046InputBO input);
}
