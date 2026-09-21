package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.QuoteType;
import com.dcits.deposit.enums.RateType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.MbCcyRateEO;

/*实体表【汇率牌价表(MB_CCY_RATE)】数据服务接口*/
public interface IMbCcyRateBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.MbCcyRateEO中的属性字段组合 **/
    long countByEo(MbCcyRateEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.MbCcyRateEO中的属性字段组合 **/
    int removeByEo(MbCcyRateEO eo);

    /** remove 根据主键: 汇率类型、币种、归属机构号、生效日期、生效时间 **/
    int removeByPrimaryKey(String rateType, String ccy, String branch, Date effectDate, String effectTime);

    int create(MbCcyRateEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.MbCcyRateEO中不为空的属性写入数据库**/
    int createSelective(MbCcyRateEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.MbCcyRateEO中的属性字段组合 **/
    List<MbCcyRateEO> findByEo(MbCcyRateEO eo);

    /** find 根据主键: 汇率类型、币种、归属机构号、生效日期、生效时间 **/
    MbCcyRateEO findByPrimaryKey(String rateType, String ccy, String branch, Date effectDate, String effectTime);

    /**  根据主键: 汇率类型、币种、归属机构号、生效日期、生效时间执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.MbCcyRateEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(MbCcyRateEO eo);

    /** modify 根据主键: 汇率类型、币种、归属机构号、生效日期、生效时间 **/
    int modifyByPrimaryKey(MbCcyRateEO eo);
}