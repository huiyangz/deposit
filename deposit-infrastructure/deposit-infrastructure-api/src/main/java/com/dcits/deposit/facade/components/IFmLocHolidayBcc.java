package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.ApplyInd;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.HolidayType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.WorkingHoliday;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.FmLocHolidayEO;

/*实体表【地区节假日(FM_LOC_HOLIDAY)】数据服务接口*/
public interface IFmLocHolidayBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.FmLocHolidayEO中的属性字段组合 **/
    long countByEo(FmLocHolidayEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.FmLocHolidayEO中的属性字段组合 **/
    int removeByEo(FmLocHolidayEO eo);

    /** remove 根据主键: 国家、省代码、节假日日期 **/
    int removeByPrimaryKey(String country, String state, Date holidayDate);

    int create(FmLocHolidayEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.FmLocHolidayEO中不为空的属性写入数据库**/
    int createSelective(FmLocHolidayEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.FmLocHolidayEO中的属性字段组合 **/
    List<FmLocHolidayEO> findByEo(FmLocHolidayEO eo);

    /** find 根据主键: 国家、省代码、节假日日期 **/
    FmLocHolidayEO findByPrimaryKey(String country, String state, Date holidayDate);

    /**  根据主键: 国家、省代码、节假日日期执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.FmLocHolidayEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(FmLocHolidayEO eo);

    /** modify 根据主键: 国家、省代码、节假日日期 **/
    int modifyByPrimaryKey(FmLocHolidayEO eo);
}