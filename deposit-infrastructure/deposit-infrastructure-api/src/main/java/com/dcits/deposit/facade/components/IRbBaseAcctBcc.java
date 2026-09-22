package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctType;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBaseAcctEO;

/*实体表【主账户基本信息表(RB_BASE_ACCT)】数据服务接口*/
public interface IRbBaseAcctBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBaseAcctEO中的属性字段组合 **/
    long countByEo(RbBaseAcctEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBaseAcctEO中的属性字段组合 **/
    int removeByEo(RbBaseAcctEO eo);

    /** remove 根据主键: 账号/卡号、客户号 **/
    int removeByPrimaryKey(String baseAcctNo, String clientNo);

    int create(RbBaseAcctEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBaseAcctEO中不为空的属性写入数据库**/
    int createSelective(RbBaseAcctEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBaseAcctEO中的属性字段组合 **/
    List<RbBaseAcctEO> findByEo(RbBaseAcctEO eo);

    /** find 根据主键: 账号/卡号、客户号 **/
    RbBaseAcctEO findByPrimaryKey(String baseAcctNo, String clientNo);

    /**  根据主键: 账号/卡号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBaseAcctEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBaseAcctEO eo);

    /** modify 根据主键: 账号/卡号、客户号 **/
    int modifyByPrimaryKey(RbBaseAcctEO eo);
}