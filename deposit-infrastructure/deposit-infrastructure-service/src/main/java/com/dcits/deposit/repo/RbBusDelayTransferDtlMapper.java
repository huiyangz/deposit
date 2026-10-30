package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBusDelayTransferDtl;
import com.dcits.deposit.entity.RbBusDelayTransferDtlExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusDelayTransferDtlMapper {
    long countByExample(RbBusDelayTransferDtlExample example);

    int deleteByExample(RbBusDelayTransferDtlExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo, @Param("tranDate") Date tranDate);

    int insert(RbBusDelayTransferDtl row);

    int insertSelective(RbBusDelayTransferDtl row);

    List<RbBusDelayTransferDtl> selectByExample(RbBusDelayTransferDtlExample example);

    RbBusDelayTransferDtl selectByPrimaryKey(@Param("seqNo") String seqNo, @Param("tranDate") Date tranDate);

    int updateByExampleSelective(@Param("row") RbBusDelayTransferDtl row, @Param("example") RbBusDelayTransferDtlExample example);

    int updateByExample(@Param("row") RbBusDelayTransferDtl row, @Param("example") RbBusDelayTransferDtlExample example);

    int updateByPrimaryKeySelective(RbBusDelayTransferDtl row);

    int updateByPrimaryKey(RbBusDelayTransferDtl row);
}