package com.dcits.deposit.repo;

import com.dcits.deposit.entity.FmServiceDefine;
import com.dcits.deposit.entity.FmServiceDefineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmServiceDefineMapper {
    long countByExample(FmServiceDefineExample example);

    int deleteByExample(FmServiceDefineExample example);

    int deleteByPrimaryKey(@Param("serviceCode") String serviceCode, @Param("messageType") String messageType, @Param("messageCode") String messageCode);

    int insert(FmServiceDefine row);

    int insertSelective(FmServiceDefine row);

    List<FmServiceDefine> selectByExample(FmServiceDefineExample example);

    FmServiceDefine selectByPrimaryKey(@Param("serviceCode") String serviceCode, @Param("messageType") String messageType, @Param("messageCode") String messageCode);

    int updateByExampleSelective(@Param("row") FmServiceDefine row, @Param("example") FmServiceDefineExample example);

    int updateByExample(@Param("row") FmServiceDefine row, @Param("example") FmServiceDefineExample example);

    int updateByPrimaryKeySelective(FmServiceDefine row);

    int updateByPrimaryKey(FmServiceDefine row);
}