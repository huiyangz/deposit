package com.dcits.deposit.repo;

import com.dcits.deposit.entity.IaBatchOpenDetail;
import com.dcits.deposit.entity.IaBatchOpenDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IaBatchOpenDetailMapper {
    long countByExample(IaBatchOpenDetailExample example);

    int deleteByExample(IaBatchOpenDetailExample example);

    int deleteByPrimaryKey(@Param("batchNo") String batchNo, @Param("batchSeqNo") String batchSeqNo);

    int insert(IaBatchOpenDetail row);

    int insertSelective(IaBatchOpenDetail row);

    List<IaBatchOpenDetail> selectByExample(IaBatchOpenDetailExample example);

    IaBatchOpenDetail selectByPrimaryKey(@Param("batchNo") String batchNo, @Param("batchSeqNo") String batchSeqNo);

    int updateByExampleSelective(@Param("row") IaBatchOpenDetail row, @Param("example") IaBatchOpenDetailExample example);

    int updateByExample(@Param("row") IaBatchOpenDetail row, @Param("example") IaBatchOpenDetailExample example);

    int updateByPrimaryKeySelective(IaBatchOpenDetail row);

    int updateByPrimaryKey(IaBatchOpenDetail row);
}