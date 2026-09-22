package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBatchTranDetails;
import com.dcits.deposit.entity.RbBatchTranDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBatchTranDetailsMapper {
    long countByExample(RbBatchTranDetailsExample example);

    int deleteByExample(RbBatchTranDetailsExample example);

    int deleteByPrimaryKey(@Param("batchSeqNo") String batchSeqNo, @Param("batchNo") String batchNo);

    int insert(RbBatchTranDetails row);

    int insertSelective(RbBatchTranDetails row);

    List<RbBatchTranDetails> selectByExample(RbBatchTranDetailsExample example);

    RbBatchTranDetails selectByPrimaryKey(@Param("batchSeqNo") String batchSeqNo, @Param("batchNo") String batchNo);

    int updateByExampleSelective(@Param("row") RbBatchTranDetails row, @Param("example") RbBatchTranDetailsExample example);

    int updateByExample(@Param("row") RbBatchTranDetails row, @Param("example") RbBatchTranDetailsExample example);

    int updateByPrimaryKeySelective(RbBatchTranDetails row);

    int updateByPrimaryKey(RbBatchTranDetails row);
}