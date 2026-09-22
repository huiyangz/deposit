package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.Weekend1;
import java.util.List;

import com.dcits.deposit.facade.eo.FmStateEO;

/*实体表【省、州信息表(FM_STATE)】数据服务接口*/
public interface IFmStateBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.FmStateEO中的属性字段组合 **/
    long countByEo(FmStateEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.FmStateEO中的属性字段组合 **/
    int removeByEo(FmStateEO eo);

    /** remove 根据主键: 国家、省代码 **/
    int removeByPrimaryKey(String country, String state);

    int create(FmStateEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.FmStateEO中不为空的属性写入数据库**/
    int createSelective(FmStateEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.FmStateEO中的属性字段组合 **/
    List<FmStateEO> findByEo(FmStateEO eo);

    /** find 根据主键: 国家、省代码 **/
    FmStateEO findByPrimaryKey(String country, String state);

    /**  根据主键: 国家、省代码执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.FmStateEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(FmStateEO eo);

    /** modify 根据主键: 国家、省代码 **/
    int modifyByPrimaryKey(FmStateEO eo);
}