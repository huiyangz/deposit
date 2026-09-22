package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBusinessParameterEO;

/*实体表【存款参数表(RB_BUSINESS_PARAMETER)】数据服务接口*/
public interface IRbBusinessParameterBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusinessParameterEO中的属性字段组合 **/
    long countByEo(RbBusinessParameterEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusinessParameterEO中的属性字段组合 **/
    int removeByEo(RbBusinessParameterEO eo);

    /** remove 根据主键: 参数名称 **/
    int removeByPrimaryKey(String paraKey);

    int create(RbBusinessParameterEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBusinessParameterEO中不为空的属性写入数据库**/
    int createSelective(RbBusinessParameterEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusinessParameterEO中的属性字段组合 **/
    List<RbBusinessParameterEO> findByEo(RbBusinessParameterEO eo);

    /** find 根据主键: 参数名称 **/
    RbBusinessParameterEO findByPrimaryKey(String paraKey);

    /**  根据主键: 参数名称执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBusinessParameterEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusinessParameterEO eo);

    /** modify 根据主键: 参数名称 **/
    int modifyByPrimaryKey(RbBusinessParameterEO eo);
}