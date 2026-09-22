package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.ApplyInd;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.HolidayType;
import com.dcits.deposit.enums.WorkingHoliday;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.FmBranchHolidayEO;

/*实体表【机构假日表(FM_BRANCH_HOLIDAY)】数据服务接口*/
public interface IFmBranchHolidayBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.FmBranchHolidayEO中的属性字段组合 **/
    long countByEo(FmBranchHolidayEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.FmBranchHolidayEO中的属性字段组合 **/
    int removeByEo(FmBranchHolidayEO eo);

    /** remove 根据主键: 归属机构号、标准假日标志、节假日日期 **/
    int removeByPrimaryKey(String branch, String holidayType, Date holidayDate);

    int create(FmBranchHolidayEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.FmBranchHolidayEO中不为空的属性写入数据库**/
    int createSelective(FmBranchHolidayEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.FmBranchHolidayEO中的属性字段组合 **/
    List<FmBranchHolidayEO> findByEo(FmBranchHolidayEO eo);

    /** find 根据主键: 归属机构号、标准假日标志、节假日日期 **/
    FmBranchHolidayEO findByPrimaryKey(String branch, String holidayType, Date holidayDate);

    /**  根据主键: 归属机构号、标准假日标志、节假日日期执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.FmBranchHolidayEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(FmBranchHolidayEO eo);

    /** modify 根据主键: 归属机构号、标准假日标志、节假日日期 **/
    int modifyByPrimaryKey(FmBranchHolidayEO eo);
}