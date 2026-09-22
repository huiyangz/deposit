package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.WithdrawalType;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbAcctWithdrawTypeEO;

/*实体表【账户支取方式(RB_ACCT_WITHDRAW_TYPE)】数据服务接口*/
public interface IRbAcctWithdrawTypeBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctWithdrawTypeEO中的属性字段组合 **/
    long countByEo(RbAcctWithdrawTypeEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctWithdrawTypeEO中的属性字段组合 **/
    int removeByEo(RbAcctWithdrawTypeEO eo);

    /** remove 根据主键: 支取方式内部键、支取方式、客户号 **/
    int removeByPrimaryKey(String withdrawKey, String withdrawalType, String clientNo);

    int create(RbAcctWithdrawTypeEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbAcctWithdrawTypeEO中不为空的属性写入数据库**/
    int createSelective(RbAcctWithdrawTypeEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctWithdrawTypeEO中的属性字段组合 **/
    List<RbAcctWithdrawTypeEO> findByEo(RbAcctWithdrawTypeEO eo);

    /** find 根据主键: 支取方式内部键、支取方式、客户号 **/
    RbAcctWithdrawTypeEO findByPrimaryKey(String withdrawKey, String withdrawalType, String clientNo);

    /**  根据主键: 支取方式内部键、支取方式、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbAcctWithdrawTypeEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbAcctWithdrawTypeEO eo);

    /** modify 根据主键: 支取方式内部键、支取方式、客户号 **/
    int modifyByPrimaryKey(RbAcctWithdrawTypeEO eo);
}