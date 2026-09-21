package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasis;
import com.dcits.deposit.enums.MovtStatus;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.TaxType;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.YearBasis;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbAcctEventRegisterEO;

/*实体表【账户重要事件登记簿(RB_ACCT_EVENT_REGISTER)】数据服务接口*/
public interface IRbAcctEventRegisterBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctEventRegisterEO中的属性字段组合 **/
    long countByEo(RbAcctEventRegisterEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctEventRegisterEO中的属性字段组合 **/
    int removeByEo(RbAcctEventRegisterEO eo);

    /** remove 根据主键: 序号、交易日期、账户内部键值、客户号、利息分类 **/
    int removeByPrimaryKey(String seqNo, Date tranDate, Integer internalKey, String clientNo, String intClass);

    int create(RbAcctEventRegisterEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbAcctEventRegisterEO中不为空的属性写入数据库**/
    int createSelective(RbAcctEventRegisterEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctEventRegisterEO中的属性字段组合 **/
    List<RbAcctEventRegisterEO> findByEo(RbAcctEventRegisterEO eo);

    /** find 根据主键: 序号、交易日期、账户内部键值、客户号、利息分类 **/
    RbAcctEventRegisterEO findByPrimaryKey(String seqNo, Date tranDate, Integer internalKey, String clientNo, String intClass);

    /**  根据主键: 序号、交易日期、账户内部键值、客户号、利息分类执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbAcctEventRegisterEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbAcctEventRegisterEO eo);

    /** modify 根据主键: 序号、交易日期、账户内部键值、客户号、利息分类 **/
    int modifyByPrimaryKey(RbAcctEventRegisterEO eo);
}