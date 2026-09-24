package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.NatureClass;
import java.util.List;

import com.dcits.deposit.facade.eo.RbAcctNatureDefEO;

/*实体表【账户属性定义(RB_ACCT_NATURE_DEF)】数据服务接口*/
public interface IRbAcctNatureDefBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctNatureDefEO中的属性字段组合 **/
    long countByEo(RbAcctNatureDefEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctNatureDefEO中的属性字段组合 **/
    int removeByEo(RbAcctNatureDefEO eo);

    /** remove 根据主键: 账户属性 **/
    int removeByPrimaryKey(String acctNatureNo);

    int create(RbAcctNatureDefEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbAcctNatureDefEO中不为空的属性写入数据库**/
    int createSelective(RbAcctNatureDefEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctNatureDefEO中的属性字段组合 **/
    List<RbAcctNatureDefEO> findByEo(RbAcctNatureDefEO eo);

    /** find 根据主键: 账户属性 **/
    RbAcctNatureDefEO findByPrimaryKey(String acctNatureNo);

    /**  根据主键: 账户属性执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbAcctNatureDefEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbAcctNatureDefEO eo);

    /** modify 根据主键: 账户属性 **/
    int modifyByPrimaryKey(RbAcctNatureDefEO eo);

    /**根据账户属性查询表《账户属性定义(RB_ACCT_NATURE_DEF)》**/
    RbAcctNatureDefEO findByAcctNatureNo(AcctNatureNo acctNatureNo);
}