package com.dcits.deposit.repo;

import com.dcits.deposit.entity.FmBranchHoliday;
import com.dcits.deposit.entity.FmBranchHolidayExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmBranchHolidayMapper {
    long countByExample(FmBranchHolidayExample example);

    int deleteByExample(FmBranchHolidayExample example);

    int deleteByPrimaryKey(@Param("branch") String branch, @Param("holidayType") String holidayType, @Param("holidayDate") Date holidayDate);

    int insert(FmBranchHoliday row);

    int insertSelective(FmBranchHoliday row);

    List<FmBranchHoliday> selectByExample(FmBranchHolidayExample example);

    FmBranchHoliday selectByPrimaryKey(@Param("branch") String branch, @Param("holidayType") String holidayType, @Param("holidayDate") Date holidayDate);

    int updateByExampleSelective(@Param("row") FmBranchHoliday row, @Param("example") FmBranchHolidayExample example);

    int updateByExample(@Param("row") FmBranchHoliday row, @Param("example") FmBranchHolidayExample example);

    int updateByPrimaryKeySelective(FmBranchHoliday row);

    int updateByPrimaryKey(FmBranchHoliday row);
}