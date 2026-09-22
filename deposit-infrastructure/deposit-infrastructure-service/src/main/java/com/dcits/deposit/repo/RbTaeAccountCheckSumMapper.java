package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbTaeAccountCheckSum;
import com.dcits.deposit.entity.RbTaeAccountCheckSumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbTaeAccountCheckSumMapper {
    long countByExample(RbTaeAccountCheckSumExample example);

    int deleteByExample(RbTaeAccountCheckSumExample example);

    int deleteByPrimaryKey(@Param("sessionId") String sessionId);

    int insert(RbTaeAccountCheckSum row);

    int insertSelective(RbTaeAccountCheckSum row);

    List<RbTaeAccountCheckSum> selectByExample(RbTaeAccountCheckSumExample example);

    RbTaeAccountCheckSum selectByPrimaryKey(@Param("sessionId") String sessionId);

    int updateByExampleSelective(@Param("row") RbTaeAccountCheckSum row, @Param("example") RbTaeAccountCheckSumExample example);

    int updateByExample(@Param("row") RbTaeAccountCheckSum row, @Param("example") RbTaeAccountCheckSumExample example);

    int updateByPrimaryKeySelective(RbTaeAccountCheckSum row);

    int updateByPrimaryKey(RbTaeAccountCheckSum row);
}