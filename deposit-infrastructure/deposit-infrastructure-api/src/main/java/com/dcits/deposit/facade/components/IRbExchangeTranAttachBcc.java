package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.ExchangeAmountNature;
import com.dcits.deposit.enums.ExchangeAmountType;
import com.dcits.deposit.enums.ExchangeCancelReason;
import com.dcits.deposit.enums.ExchangeChangeReason;
import com.dcits.deposit.enums.ExchangeClass;
import com.dcits.deposit.enums.ExchangeReportType;
import com.dcits.deposit.enums.ExchangeSupplyReason;
import com.dcits.deposit.enums.ExchangeTranStatus;
import com.dcits.deposit.enums.ExchangeType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.SourceModule;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbExchangeTranAttachEO;

/*实体表【结售汇交易流水附属表(RB_EXCHANGE_TRAN_ATTACH)】数据服务接口*/
public interface IRbExchangeTranAttachBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbExchangeTranAttachEO中的属性字段组合 **/
    long countByEo(RbExchangeTranAttachEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbExchangeTranAttachEO中的属性字段组合 **/
    int removeByEo(RbExchangeTranAttachEO eo);

    /** remove 根据主键: 序号、客户号 **/
    int removeByPrimaryKey(String seqNo, String clientNo);

    int create(RbExchangeTranAttachEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbExchangeTranAttachEO中不为空的属性写入数据库**/
    int createSelective(RbExchangeTranAttachEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbExchangeTranAttachEO中的属性字段组合 **/
    List<RbExchangeTranAttachEO> findByEo(RbExchangeTranAttachEO eo);

    /** find 根据主键: 序号、客户号 **/
    RbExchangeTranAttachEO findByPrimaryKey(String seqNo, String clientNo);

    /**  根据主键: 序号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbExchangeTranAttachEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbExchangeTranAttachEO eo);

    /** modify 根据主键: 序号、客户号 **/
    int modifyByPrimaryKey(RbExchangeTranAttachEO eo);
}