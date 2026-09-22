package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AccountingStatus;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctType;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.AutoRenewRollover;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.BusinessUnit;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.FixedCall;
import com.dcits.deposit.enums.GlType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IntIndFlag;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.OsaFlag;
import com.dcits.deposit.enums.OwnershipType;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.ReasonCode;
import com.dcits.deposit.enums.RegionFlag;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TermType;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbAcctEO;

/*实体表【账户基本信息表(RB_ACCT)】数据服务接口*/
public interface IRbAcctBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctEO中的属性字段组合 **/
    long countByEo(RbAcctEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctEO中的属性字段组合 **/
    int removeByEo(RbAcctEO eo);

    /** remove 根据主键: 账户内部键值、客户号 **/
    int removeByPrimaryKey(Integer internalKey, String clientNo);

    int create(RbAcctEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbAcctEO中不为空的属性写入数据库**/
    int createSelective(RbAcctEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctEO中的属性字段组合 **/
    List<RbAcctEO> findByEo(RbAcctEO eo);

    /** find 根据主键: 账户内部键值、客户号 **/
    RbAcctEO findByPrimaryKey(Integer internalKey, String clientNo);

    /**  根据主键: 账户内部键值、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbAcctEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbAcctEO eo);

    /** modify 根据主键: 账户内部键值、客户号 **/
    int modifyByPrimaryKey(RbAcctEO eo);
}