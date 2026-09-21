package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbLimitElementDefEO;

/*实体表【限额因子定义(RB_LIMIT_ELEMENT_DEF)】数据服务接口*/
public interface IRbLimitElementDefBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbLimitElementDefEO中的属性字段组合 **/
    long countByEo(RbLimitElementDefEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbLimitElementDefEO中的属性字段组合 **/
    int removeByEo(RbLimitElementDefEO eo);

    /** remove 根据主键: 因子名称 **/
    int removeByPrimaryKey(String elementId);

    int create(RbLimitElementDefEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbLimitElementDefEO中不为空的属性写入数据库**/
    int createSelective(RbLimitElementDefEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbLimitElementDefEO中的属性字段组合 **/
    List<RbLimitElementDefEO> findByEo(RbLimitElementDefEO eo);

    /** find 根据主键: 因子名称 **/
    RbLimitElementDefEO findByPrimaryKey(String elementId);

    /**  根据主键: 因子名称执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbLimitElementDefEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbLimitElementDefEO eo);

    /** modify 根据主键: 因子名称 **/
    int modifyByPrimaryKey(RbLimitElementDefEO eo);
}