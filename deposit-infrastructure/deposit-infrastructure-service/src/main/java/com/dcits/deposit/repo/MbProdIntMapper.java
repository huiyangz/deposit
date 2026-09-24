package com.dcits.deposit.repo;

import com.dcits.deposit.entity.MbProdInt;
import com.dcits.deposit.entity.MbProdIntExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MbProdIntMapper {
    long countByExample(MbProdIntExample example);

    int deleteByExample(MbProdIntExample example);

    int deleteByPrimaryKey(@Param("prodNo") String prodNo, @Param("intType") String intType, @Param("eventType") String eventType, @Param("intClass") String intClass);

    int insert(MbProdInt row);

    int insertSelective(MbProdInt row);

    List<MbProdInt> selectByExample(MbProdIntExample example);

    MbProdInt selectByPrimaryKey(@Param("prodNo") String prodNo, @Param("intType") String intType, @Param("eventType") String eventType, @Param("intClass") String intClass);

    int updateByExampleSelective(@Param("row") MbProdInt row, @Param("example") MbProdIntExample example);

    int updateByExample(@Param("row") MbProdInt row, @Param("example") MbProdIntExample example);

    int updateByPrimaryKeySelective(MbProdInt row);

    int updateByPrimaryKey(MbProdInt row);
}