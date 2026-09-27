package com.dcits.deposit.facade.components;

import java.math.BigDecimal;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBusAcctBalanceEO;

/*实体表【对公存款账户余额表(RB_BUS_ACCT_BALANCE)】数据服务接口*/
public interface IRbBusAcctBalanceBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAcctBalanceEO中的属性字段组合 **/
    long countByEo(RbBusAcctBalanceEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAcctBalanceEO中的属性字段组合 **/
    int removeByEo(RbBusAcctBalanceEO eo);

    /** remove 根据主键: 账户内部键值 **/
    int removeByPrimaryKey(Integer internalKey);

    int create(RbBusAcctBalanceEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBusAcctBalanceEO中不为空的属性写入数据库**/
    int createSelective(RbBusAcctBalanceEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAcctBalanceEO中的属性字段组合 **/
    List<RbBusAcctBalanceEO> findByEo(RbBusAcctBalanceEO eo);

    /** find 根据主键: 账户内部键值 **/
    RbBusAcctBalanceEO findByPrimaryKey(Integer internalKey);

    /**  根据主键: 账户内部键值执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBusAcctBalanceEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusAcctBalanceEO eo);

    /** modify 根据主键: 账户内部键值 **/
    int modifyByPrimaryKey(RbBusAcctBalanceEO eo);
}