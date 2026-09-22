package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.FtaNature;
import com.dcits.deposit.enums.FtaType;
import com.dcits.deposit.enums.RateType;
import java.util.List;

import com.dcits.deposit.facade.eo.FmFtaBranchEO;

/*实体表【自贸区结构表(FM_FTA_BRANCH)】数据服务接口*/
public interface IFmFtaBranchBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.FmFtaBranchEO中的属性字段组合 **/
    long countByEo(FmFtaBranchEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.FmFtaBranchEO中的属性字段组合 **/
    int removeByEo(FmFtaBranchEO eo);

    /** remove 根据主键: 自贸区代码 **/
    int removeByPrimaryKey(String ftaCode);

    int create(FmFtaBranchEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.FmFtaBranchEO中不为空的属性写入数据库**/
    int createSelective(FmFtaBranchEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.FmFtaBranchEO中的属性字段组合 **/
    List<FmFtaBranchEO> findByEo(FmFtaBranchEO eo);

    /** find 根据主键: 自贸区代码 **/
    FmFtaBranchEO findByPrimaryKey(String ftaCode);

    /**  根据主键: 自贸区代码执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.FmFtaBranchEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(FmFtaBranchEO eo);

    /** modify 根据主键: 自贸区代码 **/
    int modifyByPrimaryKey(FmFtaBranchEO eo);
}