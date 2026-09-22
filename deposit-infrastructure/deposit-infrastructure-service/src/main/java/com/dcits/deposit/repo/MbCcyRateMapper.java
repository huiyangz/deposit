package com.dcits.deposit.repo;

import com.dcits.deposit.entity.MbCcyRate;
import com.dcits.deposit.entity.MbCcyRateExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MbCcyRateMapper {
    long countByExample(MbCcyRateExample example);

    int deleteByExample(MbCcyRateExample example);

    int deleteByPrimaryKey(@Param("rateType") String rateType, @Param("ccy") String ccy, @Param("branch") String branch, @Param("effectDate") Date effectDate, @Param("effectTime") String effectTime);

    int insert(MbCcyRate row);

    int insertSelective(MbCcyRate row);

    List<MbCcyRate> selectByExample(MbCcyRateExample example);

    MbCcyRate selectByPrimaryKey(@Param("rateType") String rateType, @Param("ccy") String ccy, @Param("branch") String branch, @Param("effectDate") Date effectDate, @Param("effectTime") String effectTime);

    int updateByExampleSelective(@Param("row") MbCcyRate row, @Param("example") MbCcyRateExample example);

    int updateByExample(@Param("row") MbCcyRate row, @Param("example") MbCcyRateExample example);

    int updateByPrimaryKeySelective(MbCcyRate row);

    int updateByPrimaryKey(MbCcyRate row);
}