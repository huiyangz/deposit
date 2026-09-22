package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AgreeChangeType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CycleFreq;
import com.dcits.deposit.enums.FloatType;
import com.dcits.deposit.enums.FollowIntDayType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IntApplType;
import com.dcits.deposit.enums.IntCalcBal;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasis;
import com.dcits.deposit.enums.PenaltyOdiRateType;
import com.dcits.deposit.enums.RateEffectType;
import com.dcits.deposit.enums.TaxType;
import com.dcits.deposit.enums.YearBasis;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbAcctIntDetailPreEO;

/*实体表【预计提利息明细表(RB_ACCT_INT_DETAIL_PRE)】数据服务接口*/
public interface IRbAcctIntDetailPreBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctIntDetailPreEO中的属性字段组合 **/
    long countByEo(RbAcctIntDetailPreEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctIntDetailPreEO中的属性字段组合 **/
    int removeByEo(RbAcctIntDetailPreEO eo);

    /** remove 根据主键: 账户内部键值、利息分类、积数、客户号、交易时间戳 **/
    int removeByPrimaryKey(Integer internalKey, String intClass, BigDecimal agg, String clientNo, String tranTimestamp);

    int create(RbAcctIntDetailPreEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbAcctIntDetailPreEO中不为空的属性写入数据库**/
    int createSelective(RbAcctIntDetailPreEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctIntDetailPreEO中的属性字段组合 **/
    List<RbAcctIntDetailPreEO> findByEo(RbAcctIntDetailPreEO eo);

    /** find 根据主键: 账户内部键值、利息分类、积数、客户号、交易时间戳 **/
    RbAcctIntDetailPreEO findByPrimaryKey(Integer internalKey, String intClass, BigDecimal agg, String clientNo, String tranTimestamp);

    /**  根据主键: 账户内部键值、利息分类、积数、客户号、交易时间戳执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbAcctIntDetailPreEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbAcctIntDetailPreEO eo);

    /** modify 根据主键: 账户内部键值、利息分类、积数、客户号、交易时间戳 **/
    int modifyByPrimaryKey(RbAcctIntDetailPreEO eo);
}