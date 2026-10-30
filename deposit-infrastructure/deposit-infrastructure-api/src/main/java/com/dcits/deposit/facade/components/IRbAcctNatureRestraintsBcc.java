package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.TermType;
import java.util.List;

import com.dcits.deposit.facade.eo.RbAcctNatureRestraintsEO;

/*实体表【账户属性与账户限制关联配置(RB_ACCT_NATURE_RESTRAINTS)】数据服务接口*/
public interface IRbAcctNatureRestraintsBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctNatureRestraintsEO中的属性字段组合 **/
    long countByEo(RbAcctNatureRestraintsEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctNatureRestraintsEO中的属性字段组合 **/
    int removeByEo(RbAcctNatureRestraintsEO eo);

    /** remove 根据主键: 账户限制类型、账户属性 **/
    int removeByPrimaryKey(String restraintType, String acctNatureNo);

    int create(RbAcctNatureRestraintsEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbAcctNatureRestraintsEO中不为空的属性写入数据库**/
    int createSelective(RbAcctNatureRestraintsEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctNatureRestraintsEO中的属性字段组合 **/
    List<RbAcctNatureRestraintsEO> findByEo(RbAcctNatureRestraintsEO eo);

    /** find 根据主键: 账户限制类型、账户属性 **/
    RbAcctNatureRestraintsEO findByPrimaryKey(String restraintType, String acctNatureNo);

    /**  根据主键: 账户限制类型、账户属性执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbAcctNatureRestraintsEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbAcctNatureRestraintsEO eo);

    /** modify 根据主键: 账户限制类型、账户属性 **/
    int modifyByPrimaryKey(RbAcctNatureRestraintsEO eo);
}