package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbTranControlHist;
import com.dcits.deposit.entity.RbTranControlHistExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbTranControlHistMapper {
    long countByExample(RbTranControlHistExample example);

    int deleteByExample(RbTranControlHistExample example);

    int deleteByPrimaryKey(@Param("channelSeqNo") String channelSeqNo, @Param("channelDate") Date channelDate, @Param("sourceType") String sourceType, @Param("subSeqNo") String subSeqNo, @Param("tranDate") Date tranDate);

    int insert(RbTranControlHist row);

    int insertSelective(RbTranControlHist row);

    List<RbTranControlHist> selectByExample(RbTranControlHistExample example);

    RbTranControlHist selectByPrimaryKey(@Param("channelSeqNo") String channelSeqNo, @Param("channelDate") Date channelDate, @Param("sourceType") String sourceType, @Param("subSeqNo") String subSeqNo, @Param("tranDate") Date tranDate);

    int updateByExampleSelective(@Param("row") RbTranControlHist row, @Param("example") RbTranControlHistExample example);

    int updateByExample(@Param("row") RbTranControlHist row, @Param("example") RbTranControlHistExample example);

    int updateByPrimaryKeySelective(RbTranControlHist row);

    int updateByPrimaryKey(RbTranControlHist row);
}