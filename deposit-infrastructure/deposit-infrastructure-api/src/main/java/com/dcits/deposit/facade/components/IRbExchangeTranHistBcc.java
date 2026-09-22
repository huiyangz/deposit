package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.BaseQuoteType;
import com.dcits.deposit.enums.BaseRateType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CouponRateType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.ExchangeTranStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.QuoteType;
import com.dcits.deposit.enums.RateType;
import com.dcits.deposit.enums.SellBuyInd;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.UncStatus;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbExchangeTranHistEO;

/*实体表【结售汇交易流水表(RB_EXCHANGE_TRAN_HIST)】数据服务接口*/
public interface IRbExchangeTranHistBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbExchangeTranHistEO中的属性字段组合 **/
    long countByEo(RbExchangeTranHistEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbExchangeTranHistEO中的属性字段组合 **/
    int removeByEo(RbExchangeTranHistEO eo);

    /** remove 根据主键: 序号、客户号、交易日期 **/
    int removeByPrimaryKey(String seqNo, String clientNo, Date tranDate);

    int create(RbExchangeTranHistEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbExchangeTranHistEO中不为空的属性写入数据库**/
    int createSelective(RbExchangeTranHistEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbExchangeTranHistEO中的属性字段组合 **/
    List<RbExchangeTranHistEO> findByEo(RbExchangeTranHistEO eo);

    /** find 根据主键: 序号、客户号、交易日期 **/
    RbExchangeTranHistEO findByPrimaryKey(String seqNo, String clientNo, Date tranDate);

    /**  根据主键: 序号、客户号、交易日期执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbExchangeTranHistEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbExchangeTranHistEO eo);

    /** modify 根据主键: 序号、客户号、交易日期 **/
    int modifyByPrimaryKey(RbExchangeTranHistEO eo);
}