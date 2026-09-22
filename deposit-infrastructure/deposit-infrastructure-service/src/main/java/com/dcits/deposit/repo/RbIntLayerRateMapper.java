package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbIntLayerRate;
import com.dcits.deposit.entity.RbIntLayerRateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbIntLayerRateMapper {
    long countByExample(RbIntLayerRateExample example);

    int deleteByExample(RbIntLayerRateExample example);

    int deleteByPrimaryKey(@Param("irlSeqNo") String irlSeqNo, @Param("clientNo") String clientNo);

    int insert(RbIntLayerRate row);

    int insertSelective(RbIntLayerRate row);

    List<RbIntLayerRate> selectByExample(RbIntLayerRateExample example);

    RbIntLayerRate selectByPrimaryKey(@Param("irlSeqNo") String irlSeqNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbIntLayerRate row, @Param("example") RbIntLayerRateExample example);

    int updateByExample(@Param("row") RbIntLayerRate row, @Param("example") RbIntLayerRateExample example);

    int updateByPrimaryKeySelective(RbIntLayerRate row);

    int updateByPrimaryKey(RbIntLayerRate row);
}