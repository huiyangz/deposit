package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.WithdrawalType;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBusClientAcctEO;

/*实体表【对公客户账户表(RB_BUS_CLIENT_ACCT)】数据服务接口*/
public interface IRbBusClientAcctBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusClientAcctEO中的属性字段组合 **/
    long countByEo(RbBusClientAcctEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusClientAcctEO中的属性字段组合 **/
    int removeByEo(RbBusClientAcctEO eo);

    /** remove 根据主键: 账号、客户号 **/
    int removeByPrimaryKey(String baseAcctNo, String clientNo);

    int create(RbBusClientAcctEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBusClientAcctEO中不为空的属性写入数据库**/
    int createSelective(RbBusClientAcctEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusClientAcctEO中的属性字段组合 **/
    List<RbBusClientAcctEO> findByEo(RbBusClientAcctEO eo);

    /** find 根据主键: 账号、客户号 **/
    RbBusClientAcctEO findByPrimaryKey(String baseAcctNo, String clientNo);

    /**  根据主键: 账号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBusClientAcctEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusClientAcctEO eo);

    /** modify 根据主键: 账号、客户号 **/
    int modifyByPrimaryKey(RbBusClientAcctEO eo);
}