package com.dcits.deposit.repo;

import com.dcits.deposit.entity.FmCcyHoliday;
import com.dcits.deposit.entity.FmCcyHolidayExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmCcyHolidayMapper {
    long countByExample(FmCcyHolidayExample example);

    int deleteByExample(FmCcyHolidayExample example);

    int deleteByPrimaryKey(@Param("ccy") String ccy, @Param("holidayDate") Date holidayDate);

    int insert(FmCcyHoliday row);

    int insertSelective(FmCcyHoliday row);

    List<FmCcyHoliday> selectByExample(FmCcyHolidayExample example);

    FmCcyHoliday selectByPrimaryKey(@Param("ccy") String ccy, @Param("holidayDate") Date holidayDate);

    int updateByExampleSelective(@Param("row") FmCcyHoliday row, @Param("example") FmCcyHolidayExample example);

    int updateByExample(@Param("row") FmCcyHoliday row, @Param("example") FmCcyHolidayExample example);

    int updateByPrimaryKeySelective(FmCcyHoliday row);

    int updateByPrimaryKey(FmCcyHoliday row);
}