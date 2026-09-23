package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.AcctRiskLevel;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctVerifyFlag;
import com.dcits.deposit.enums.AcctVerifyResult;
import com.dcits.deposit.enums.AllDepInd;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.AllDraRange;
import com.dcits.deposit.enums.AnnualStatus;
import com.dcits.deposit.enums.AutoRenewInd;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.CheckCertificateType;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.DepositNature;
import com.dcits.deposit.enums.FarmerFlag;
import com.dcits.deposit.enums.FixedCall;
import com.dcits.deposit.enums.IntIndFlag;
import com.dcits.deposit.enums.ManageType;
import com.dcits.deposit.enums.OsaFlag;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.enums.RbBusAcctPurpose;
import com.dcits.deposit.enums.RenewMethod;
import com.dcits.deposit.enums.SimpleAcct;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.SpecAcctFlag;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBusAcctEO;

/*实体表【对公存款账户主表(RB_BUS_ACCT)】数据服务接口*/
public interface IRbBusAcctBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAcctEO中的属性字段组合 **/
    long countByEo(RbBusAcctEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAcctEO中的属性字段组合 **/
    int removeByEo(RbBusAcctEO eo);

    /** remove 根据主键: 账户内部键值 **/
    int removeByPrimaryKey(Integer internalKey);

    int create(RbBusAcctEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBusAcctEO中不为空的属性写入数据库**/
    int createSelective(RbBusAcctEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAcctEO中的属性字段组合 **/
    List<RbBusAcctEO> findByEo(RbBusAcctEO eo);

    /** find 根据主键: 账户内部键值 **/
    RbBusAcctEO findByPrimaryKey(Integer internalKey);

    /**  根据主键: 账户内部键值执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBusAcctEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusAcctEO eo);

    /** modify 根据主键: 账户内部键值 **/
    int modifyByPrimaryKey(RbBusAcctEO eo);
}