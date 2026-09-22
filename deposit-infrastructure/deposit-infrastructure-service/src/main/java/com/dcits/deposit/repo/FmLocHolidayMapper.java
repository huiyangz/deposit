package com.dcits.deposit.repo;

import com.dcits.deposit.entity.FmLocHoliday;
import com.dcits.deposit.entity.FmLocHolidayExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmLocHolidayMapper {
    long countByExample(FmLocHolidayExample example);

    int deleteByExample(FmLocHolidayExample example);

    int deleteByPrimaryKey(@Param("country") String country, @Param("state") String state, @Param("holidayDate") Date holidayDate);

    int insert(FmLocHoliday row);

    int insertSelective(FmLocHoliday row);

    List<FmLocHoliday> selectByExample(FmLocHolidayExample example);

    FmLocHoliday selectByPrimaryKey(@Param("country") String country, @Param("state") String state, @Param("holidayDate") Date holidayDate);

    int updateByExampleSelective(@Param("row") FmLocHoliday row, @Param("example") FmLocHolidayExample example);

    int updateByExample(@Param("row") FmLocHoliday row, @Param("example") FmLocHolidayExample example);

    int updateByPrimaryKeySelective(FmLocHoliday row);

    int updateByPrimaryKey(FmLocHoliday row);
}