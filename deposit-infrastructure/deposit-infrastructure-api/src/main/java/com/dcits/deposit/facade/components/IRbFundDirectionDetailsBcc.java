package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.FundAcctPurpose;
import com.dcits.deposit.enums.FundSource;
import com.dcits.deposit.enums.RegType;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbFundDirectionDetailsEO;

/*实体表【资金来源去向登记表(RB_FUND_DIRECTION_DETAILS)】数据服务接口*/
public interface IRbFundDirectionDetailsBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbFundDirectionDetailsEO中的属性字段组合 **/
    long countByEo(RbFundDirectionDetailsEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbFundDirectionDetailsEO中的属性字段组合 **/
    int removeByEo(RbFundDirectionDetailsEO eo);

    /** remove 根据主键: 序号、客户号 **/
    int removeByPrimaryKey(String seqNo, String clientNo);

    int create(RbFundDirectionDetailsEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbFundDirectionDetailsEO中不为空的属性写入数据库**/
    int createSelective(RbFundDirectionDetailsEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbFundDirectionDetailsEO中的属性字段组合 **/
    List<RbFundDirectionDetailsEO> findByEo(RbFundDirectionDetailsEO eo);

    /** find 根据主键: 序号、客户号 **/
    RbFundDirectionDetailsEO findByPrimaryKey(String seqNo, String clientNo);

    /**  根据主键: 序号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbFundDirectionDetailsEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbFundDirectionDetailsEO eo);

    /** modify 根据主键: 序号、客户号 **/
    int modifyByPrimaryKey(RbFundDirectionDetailsEO eo);
}