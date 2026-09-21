package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.NatureClass;
import java.util.List;

import com.dcits.deposit.facade.eo.ClAcctNatureDefEO;

/*实体表【账户属性定义(CL_ACCT_NATURE_DEF)】数据服务接口*/
public interface IClAcctNatureDefBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.ClAcctNatureDefEO中的属性字段组合 **/
    long countByEo(ClAcctNatureDefEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.ClAcctNatureDefEO中的属性字段组合 **/
    int removeByEo(ClAcctNatureDefEO eo);

    /** remove 根据主键: 账户属性 **/
    int removeByPrimaryKey(String acctNature);

    int create(ClAcctNatureDefEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.ClAcctNatureDefEO中不为空的属性写入数据库**/
    int createSelective(ClAcctNatureDefEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.ClAcctNatureDefEO中的属性字段组合 **/
    List<ClAcctNatureDefEO> findByEo(ClAcctNatureDefEO eo);

    /** find 根据主键: 账户属性 **/
    ClAcctNatureDefEO findByPrimaryKey(String acctNature);

    /**  根据主键: 账户属性执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.ClAcctNatureDefEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(ClAcctNatureDefEO eo);

    /** modify 根据主键: 账户属性 **/
    int modifyByPrimaryKey(ClAcctNatureDefEO eo);

    /**根据账户属性查询表《账户属性定义(CL_ACCT_NATURE_DEF)》**/
    ClAcctNatureDefEO findByAcctNature(AcctNature acctNature);
}