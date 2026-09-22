package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.FundAcctPurpose;
import com.dcits.deposit.enums.FundSource;
import com.dcits.deposit.enums.RegType;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBusFundDirectionDetailsEO;

/*实体表【对公存款资金来源去向登记表(RB_BUS_FUND_DIRECTION_DETAILS)】数据服务接口*/
public interface IRbBusFundDirectionDetailsBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusFundDirectionDetailsEO中的属性字段组合 **/
    long countByEo(RbBusFundDirectionDetailsEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusFundDirectionDetailsEO中的属性字段组合 **/
    int removeByEo(RbBusFundDirectionDetailsEO eo);

    /** remove 根据主键: 序号 **/
    int removeByPrimaryKey(String seqNo);

    int create(RbBusFundDirectionDetailsEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBusFundDirectionDetailsEO中不为空的属性写入数据库**/
    int createSelective(RbBusFundDirectionDetailsEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusFundDirectionDetailsEO中的属性字段组合 **/
    List<RbBusFundDirectionDetailsEO> findByEo(RbBusFundDirectionDetailsEO eo);

    /** find 根据主键: 序号 **/
    RbBusFundDirectionDetailsEO findByPrimaryKey(String seqNo);

    /**  根据主键: 序号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBusFundDirectionDetailsEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusFundDirectionDetailsEO eo);

    /** modify 根据主键: 序号 **/
    int modifyByPrimaryKey(RbBusFundDirectionDetailsEO eo);
}