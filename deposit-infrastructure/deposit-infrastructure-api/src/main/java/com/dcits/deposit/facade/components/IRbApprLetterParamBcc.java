package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import java.util.List;

import com.dcits.deposit.facade.eo.RbApprLetterParamEO;

/*实体表【核准件限额参数表(RB_APPR_LETTER_PARAM)】数据服务接口*/
public interface IRbApprLetterParamBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbApprLetterParamEO中的属性字段组合 **/
    long countByEo(RbApprLetterParamEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbApprLetterParamEO中的属性字段组合 **/
    int removeByEo(RbApprLetterParamEO eo);

    /** remove 根据主键: 参数名称 **/
    int removeByPrimaryKey(String paraKey);

    int create(RbApprLetterParamEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbApprLetterParamEO中不为空的属性写入数据库**/
    int createSelective(RbApprLetterParamEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbApprLetterParamEO中的属性字段组合 **/
    List<RbApprLetterParamEO> findByEo(RbApprLetterParamEO eo);

    /** find 根据主键: 参数名称 **/
    RbApprLetterParamEO findByPrimaryKey(String paraKey);

    /**  根据主键: 参数名称执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbApprLetterParamEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbApprLetterParamEO eo);

    /** modify 根据主键: 参数名称 **/
    int modifyByPrimaryKey(RbApprLetterParamEO eo);
}