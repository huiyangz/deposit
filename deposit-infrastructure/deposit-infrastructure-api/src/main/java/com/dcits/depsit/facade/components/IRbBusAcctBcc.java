package com.dcits.depsit.facade.components;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.enums.AcctRiskLevel;
import com.dcits.depsit.enums.AcctStatus;
import com.dcits.depsit.enums.AcctVerifyFlag;
import com.dcits.depsit.enums.AcctVerifyResult;
import com.dcits.depsit.enums.AllDepInd;
import com.dcits.depsit.enums.AllDraInd;
import com.dcits.depsit.enums.AllDraRange;
import com.dcits.depsit.enums.AnnualStatus;
import com.dcits.depsit.enums.AutoRenewInd;
import com.dcits.depsit.enums.BalType;
import com.dcits.depsit.enums.CheckCertificateType;
import com.dcits.depsit.enums.ClientType;
import com.dcits.depsit.enums.DepositNature;
import com.dcits.depsit.enums.FarmerFlag;
import com.dcits.depsit.enums.FixedCall;
import com.dcits.depsit.enums.IntIndFlag;
import com.dcits.depsit.enums.ManageType;
import com.dcits.depsit.enums.OsaFlag;
import com.dcits.depsit.enums.RbAcctType;
import com.dcits.depsit.enums.RbBusAcctPurpose;
import com.dcits.depsit.enums.RenewMethod;
import com.dcits.depsit.enums.SimpleAcct;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.SpecAcctFlag;
import com.dcits.depsit.enums.TermType;
import com.dcits.depsit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.depsit.facade.eo.RbBusAcctEO;

/*实体表【对公存款账户主表(RB_BUS_ACCT)】数据服务接口*/
public interface IRbBusAcctBcc {
    /** count数据库表记录根据入参com.dcits.depsit.facade.eo.RbBusAcctEO中的属性字段组合 **/
    long countByEo(RbBusAcctEO eo);

    /** remove数据库表记录根据入参com.dcits.depsit.facade.eo.RbBusAcctEO中的属性字段组合 **/
    int removeByEo(RbBusAcctEO eo);

    /** remove 根据主键: 账户内部键值 **/
    int removeByPrimaryKey(Integer internalKey);

    int create(RbBusAcctEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.depsit.facade.eo.RbBusAcctEO中不为空的属性写入数据库**/
    int createSelective(RbBusAcctEO eo);

    /** find数据库表记录根据入参com.dcits.depsit.facade.eo.RbBusAcctEO中的属性字段组合 **/
    List<RbBusAcctEO> findByEo(RbBusAcctEO eo);

    /** find 根据主键: 账户内部键值 **/
    RbBusAcctEO findByPrimaryKey(Integer internalKey);

    /**  根据主键: 账户内部键值执行更新记录操作，仅更新入参com.dcits.depsit.facade.eo.RbBusAcctEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusAcctEO eo);

    /** modify 根据主键: 账户内部键值 **/
    int modifyByPrimaryKey(RbBusAcctEO eo);
}