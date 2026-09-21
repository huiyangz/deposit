package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbTaeAccountCheckSumEO;

/*实体表【日间对账汇总表(RB_TAE_ACCOUNT_CHECK_SUM)】数据服务接口*/
public interface IRbTaeAccountCheckSumBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbTaeAccountCheckSumEO中的属性字段组合 **/
    long countByEo(RbTaeAccountCheckSumEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbTaeAccountCheckSumEO中的属性字段组合 **/
    int removeByEo(RbTaeAccountCheckSumEO eo);

    /** remove 根据主键: 场次 **/
    int removeByPrimaryKey(String sessionId);

    int create(RbTaeAccountCheckSumEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbTaeAccountCheckSumEO中不为空的属性写入数据库**/
    int createSelective(RbTaeAccountCheckSumEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbTaeAccountCheckSumEO中的属性字段组合 **/
    List<RbTaeAccountCheckSumEO> findByEo(RbTaeAccountCheckSumEO eo);

    /** find 根据主键: 场次 **/
    RbTaeAccountCheckSumEO findByPrimaryKey(String sessionId);

    /**  根据主键: 场次执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbTaeAccountCheckSumEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbTaeAccountCheckSumEO eo);

    /** modify 根据主键: 场次 **/
    int modifyByPrimaryKey(RbTaeAccountCheckSumEO eo);
}