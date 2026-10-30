package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbOdBranchInfoEO;

/*实体表【机构法人透支额度信息表(RB_OD_BRANCH_INFO)】数据服务接口*/
public interface IRbOdBranchInfoBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbOdBranchInfoEO中的属性字段组合 **/
    long countByEo(RbOdBranchInfoEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbOdBranchInfoEO中的属性字段组合 **/
    int removeByEo(RbOdBranchInfoEO eo);

    /** remove 根据主键: 归属机构号 **/
    int removeByPrimaryKey(String branch);

    int create(RbOdBranchInfoEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbOdBranchInfoEO中不为空的属性写入数据库**/
    int createSelective(RbOdBranchInfoEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbOdBranchInfoEO中的属性字段组合 **/
    List<RbOdBranchInfoEO> findByEo(RbOdBranchInfoEO eo);

    /** find 根据主键: 归属机构号 **/
    RbOdBranchInfoEO findByPrimaryKey(String branch);

    /**  根据主键: 归属机构号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbOdBranchInfoEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbOdBranchInfoEO eo);

    /** modify 根据主键: 归属机构号 **/
    int modifyByPrimaryKey(RbOdBranchInfoEO eo);

    /**根据归属机构号查询表《机构法人透支额度信息表(RB_OD_BRANCH_INFO)》**/
    RbOdBranchInfoEO findByBranch(TranBranch branch);
}