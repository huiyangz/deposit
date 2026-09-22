package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbPcpLimitCumulative;
import com.dcits.deposit.entity.RbPcpLimitCumulativeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbPcpLimitCumulativeMapper {
    long countByExample(RbPcpLimitCumulativeExample example);

    int deleteByExample(RbPcpLimitCumulativeExample example);

    int deleteByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("limitType") String limitType, @Param("agreementId") String agreementId, @Param("clientNo") String clientNo);

    int insert(RbPcpLimitCumulative row);

    int insertSelective(RbPcpLimitCumulative row);

    List<RbPcpLimitCumulative> selectByExample(RbPcpLimitCumulativeExample example);

    RbPcpLimitCumulative selectByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("limitType") String limitType, @Param("agreementId") String agreementId, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbPcpLimitCumulative row, @Param("example") RbPcpLimitCumulativeExample example);

    int updateByExample(@Param("row") RbPcpLimitCumulative row, @Param("example") RbPcpLimitCumulativeExample example);

    int updateByPrimaryKeySelective(RbPcpLimitCumulative row);

    int updateByPrimaryKey(RbPcpLimitCumulative row);
}