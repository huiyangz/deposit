package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import java.util.List;

import com.dcits.deposit.facade.eo.FmBranchCcyEO;

/*实体表【机构币种表(FM_BRANCH_CCY)】数据服务接口*/
public interface IFmBranchCcyBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.FmBranchCcyEO中的属性字段组合 **/
    long countByEo(FmBranchCcyEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.FmBranchCcyEO中的属性字段组合 **/
    int removeByEo(FmBranchCcyEO eo);

    /** remove 根据主键: 归属机构号、币种 **/
    int removeByPrimaryKey(String branch, String ccy);

    int create(FmBranchCcyEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.FmBranchCcyEO中不为空的属性写入数据库**/
    int createSelective(FmBranchCcyEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.FmBranchCcyEO中的属性字段组合 **/
    List<FmBranchCcyEO> findByEo(FmBranchCcyEO eo);

    /** find 根据主键: 归属机构号、币种 **/
    FmBranchCcyEO findByPrimaryKey(String branch, String ccy);

    /**  根据主键: 归属机构号、币种执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.FmBranchCcyEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(FmBranchCcyEO eo);

    /** modify 根据主键: 归属机构号、币种 **/
    int modifyByPrimaryKey(FmBranchCcyEO eo);
}