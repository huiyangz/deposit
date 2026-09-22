package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.WithdrawalType;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbClientAcctEO;

/*实体表【客户账户信息表(RB_CLIENT_ACCT)】数据服务接口*/
public interface IRbClientAcctBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbClientAcctEO中的属性字段组合 **/
    long countByEo(RbClientAcctEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbClientAcctEO中的属性字段组合 **/
    int removeByEo(RbClientAcctEO eo);

    /** remove 根据主键: 账号/卡号、客户号 **/
    int removeByPrimaryKey(String baseAcctNo, String clientNo);

    int create(RbClientAcctEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbClientAcctEO中不为空的属性写入数据库**/
    int createSelective(RbClientAcctEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbClientAcctEO中的属性字段组合 **/
    List<RbClientAcctEO> findByEo(RbClientAcctEO eo);

    /** find 根据主键: 账号/卡号、客户号 **/
    RbClientAcctEO findByPrimaryKey(String baseAcctNo, String clientNo);

    /**  根据主键: 账号/卡号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbClientAcctEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbClientAcctEO eo);

    /** modify 根据主键: 账号/卡号、客户号 **/
    int modifyByPrimaryKey(RbClientAcctEO eo);
}