package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbLoanFundInfoEO;

/*实体表【贷款资金信息表(RB_LOAN_FUND_INFO)】数据服务接口*/
public interface IRbLoanFundInfoBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbLoanFundInfoEO中的属性字段组合 **/
    long countByEo(RbLoanFundInfoEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbLoanFundInfoEO中的属性字段组合 **/
    int removeByEo(RbLoanFundInfoEO eo);

    /** remove 根据主键: 账户内部键值、客户号 **/
    int removeByPrimaryKey(Integer internalKey, String clientNo);

    int create(RbLoanFundInfoEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbLoanFundInfoEO中不为空的属性写入数据库**/
    int createSelective(RbLoanFundInfoEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbLoanFundInfoEO中的属性字段组合 **/
    List<RbLoanFundInfoEO> findByEo(RbLoanFundInfoEO eo);

    /** find 根据主键: 账户内部键值、客户号 **/
    RbLoanFundInfoEO findByPrimaryKey(Integer internalKey, String clientNo);

    /**  根据主键: 账户内部键值、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbLoanFundInfoEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbLoanFundInfoEO eo);

    /** modify 根据主键: 账户内部键值、客户号 **/
    int modifyByPrimaryKey(RbLoanFundInfoEO eo);
}