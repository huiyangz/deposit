package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import java.util.List;

import com.dcits.deposit.facade.eo.FmStructureParamEO;

/*实体表【结构参数定义表(FM_STRUCTURE_PARAM)】数据服务接口*/
public interface IFmStructureParamBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.FmStructureParamEO中的属性字段组合 **/
    long countByEo(FmStructureParamEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.FmStructureParamEO中的属性字段组合 **/
    int removeByEo(FmStructureParamEO eo);

    /** remove 根据主键: 结构类型、参数类型、起始位置 **/
    int removeByPrimaryKey(String structureType, String paramType, String startPos);

    int create(FmStructureParamEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.FmStructureParamEO中不为空的属性写入数据库**/
    int createSelective(FmStructureParamEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.FmStructureParamEO中的属性字段组合 **/
    List<FmStructureParamEO> findByEo(FmStructureParamEO eo);

    /** find 根据主键: 结构类型、参数类型、起始位置 **/
    FmStructureParamEO findByPrimaryKey(String structureType, String paramType, String startPos);

    /**  根据主键: 结构类型、参数类型、起始位置执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.FmStructureParamEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(FmStructureParamEO eo);

    /** modify 根据主键: 结构类型、参数类型、起始位置 **/
    int modifyByPrimaryKey(FmStructureParamEO eo);
}