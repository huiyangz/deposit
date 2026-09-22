package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.ApplyInd;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.HolidayType;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.FmCcyHolidayEO;

/*实体表【币种节假日定义表(FM_CCY_HOLIDAY)】数据服务接口*/
public interface IFmCcyHolidayBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.FmCcyHolidayEO中的属性字段组合 **/
    long countByEo(FmCcyHolidayEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.FmCcyHolidayEO中的属性字段组合 **/
    int removeByEo(FmCcyHolidayEO eo);

    /** remove 根据主键: 币种、节假日日期 **/
    int removeByPrimaryKey(String ccy, Date holidayDate);

    int create(FmCcyHolidayEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.FmCcyHolidayEO中不为空的属性写入数据库**/
    int createSelective(FmCcyHolidayEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.FmCcyHolidayEO中的属性字段组合 **/
    List<FmCcyHolidayEO> findByEo(FmCcyHolidayEO eo);

    /** find 根据主键: 币种、节假日日期 **/
    FmCcyHolidayEO findByPrimaryKey(String ccy, Date holidayDate);

    /**  根据主键: 币种、节假日日期执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.FmCcyHolidayEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(FmCcyHolidayEO eo);

    /** modify 根据主键: 币种、节假日日期 **/
    int modifyByPrimaryKey(FmCcyHolidayEO eo);
}