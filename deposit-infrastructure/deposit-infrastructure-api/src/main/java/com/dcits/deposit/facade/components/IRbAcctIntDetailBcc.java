package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CycleFreq;
import com.dcits.deposit.enums.FloatType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IntApplType;
import com.dcits.deposit.enums.IntCalcBal;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasis;
import com.dcits.deposit.enums.TaxType;
import com.dcits.deposit.enums.YearBasis;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbAcctIntDetailEO;

/*实体表【利息明细表(RB_ACCT_INT_DETAIL)】数据服务接口*/
public interface IRbAcctIntDetailBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctIntDetailEO中的属性字段组合 **/
    long countByEo(RbAcctIntDetailEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctIntDetailEO中的属性字段组合 **/
    int removeByEo(RbAcctIntDetailEO eo);

    /** remove 根据主键: 账户内部键值、利息分类、客户号 **/
    int removeByPrimaryKey(Integer internalKey, String intClass, String clientNo);

    int create(RbAcctIntDetailEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbAcctIntDetailEO中不为空的属性写入数据库**/
    int createSelective(RbAcctIntDetailEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctIntDetailEO中的属性字段组合 **/
    List<RbAcctIntDetailEO> findByEo(RbAcctIntDetailEO eo);

    /** find 根据主键: 账户内部键值、利息分类、客户号 **/
    RbAcctIntDetailEO findByPrimaryKey(Integer internalKey, String intClass, String clientNo);

    /**  根据主键: 账户内部键值、利息分类、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbAcctIntDetailEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbAcctIntDetailEO eo);

    /** modify 根据主键: 账户内部键值、利息分类、客户号 **/
    int modifyByPrimaryKey(RbAcctIntDetailEO eo);
}