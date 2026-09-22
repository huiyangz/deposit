package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.BranchType;
import com.dcits.deposit.enums.City;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.HierarchyCode;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.ProfitCenter;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.FmBranchEO;

/*实体表【机构信息表(FM_BRANCH)】数据服务接口*/
public interface IFmBranchBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.FmBranchEO中的属性字段组合 **/
    long countByEo(FmBranchEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.FmBranchEO中的属性字段组合 **/
    int removeByEo(FmBranchEO eo);

    /** remove 根据主键: 归属机构号 **/
    int removeByPrimaryKey(String branch);

    int create(FmBranchEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.FmBranchEO中不为空的属性写入数据库**/
    int createSelective(FmBranchEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.FmBranchEO中的属性字段组合 **/
    List<FmBranchEO> findByEo(FmBranchEO eo);

    /** find 根据主键: 归属机构号 **/
    FmBranchEO findByPrimaryKey(String branch);

    /**  根据主键: 归属机构号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.FmBranchEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(FmBranchEO eo);

    /** modify 根据主键: 归属机构号 **/
    int modifyByPrimaryKey(FmBranchEO eo);

    /**根据归属机构号查询表《机构信息表(FM_BRANCH)》**/
    FmBranchEO findByBranch(AcctBranch branch);
}