package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.Company;
import java.util.List;

import com.dcits.deposit.facade.eo.MbBranchProdEO;

/*实体表【机构产品关联表(MB_BRANCH_PROD)】数据服务接口*/
public interface IMbBranchProdBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.MbBranchProdEO中的属性字段组合 **/
    long countByEo(MbBranchProdEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.MbBranchProdEO中的属性字段组合 **/
    int removeByEo(MbBranchProdEO eo);

    /** remove 根据主键: 归属机构号、产品类型、法人 **/
    int removeByPrimaryKey(String branch, String prodType, String company);

    int create(MbBranchProdEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.MbBranchProdEO中不为空的属性写入数据库**/
    int createSelective(MbBranchProdEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.MbBranchProdEO中的属性字段组合 **/
    List<MbBranchProdEO> findByEo(MbBranchProdEO eo);

    /** find 根据主键: 归属机构号、产品类型、法人 **/
    MbBranchProdEO findByPrimaryKey(String branch, String prodType, String company);

    /**  根据主键: 归属机构号、产品类型、法人执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.MbBranchProdEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(MbBranchProdEO eo);

    /** modify 根据主键: 归属机构号、产品类型、法人 **/
    int modifyByPrimaryKey(MbBranchProdEO eo);
}