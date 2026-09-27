package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.FloatType;
import com.dcits.deposit.enums.IntCalcBal;
import com.dcits.deposit.enums.IntChangeType;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasisType;
import com.dcits.deposit.enums.RollFreq;
import com.dcits.deposit.enums.YearBasisType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBusAcctIntDetailEO;

/*实体表【对公存款利息明细表(RB_BUS_ACCT_INT_DETAIL)】数据服务接口*/
public interface IRbBusAcctIntDetailBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAcctIntDetailEO中的属性字段组合 **/
    long countByEo(RbBusAcctIntDetailEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAcctIntDetailEO中的属性字段组合 **/
    int removeByEo(RbBusAcctIntDetailEO eo);

    /** remove 根据主键: 账户内部键值、利息分类 **/
    int removeByPrimaryKey(Integer internalKey, String intClass);

    int create(RbBusAcctIntDetailEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBusAcctIntDetailEO中不为空的属性写入数据库**/
    int createSelective(RbBusAcctIntDetailEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAcctIntDetailEO中的属性字段组合 **/
    List<RbBusAcctIntDetailEO> findByEo(RbBusAcctIntDetailEO eo);

    /** find 根据主键: 账户内部键值、利息分类 **/
    RbBusAcctIntDetailEO findByPrimaryKey(Integer internalKey, String intClass);

    /**  根据主键: 账户内部键值、利息分类执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBusAcctIntDetailEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusAcctIntDetailEO eo);

    /** modify 根据主键: 账户内部键值、利息分类 **/
    int modifyByPrimaryKey(RbBusAcctIntDetailEO eo);
}