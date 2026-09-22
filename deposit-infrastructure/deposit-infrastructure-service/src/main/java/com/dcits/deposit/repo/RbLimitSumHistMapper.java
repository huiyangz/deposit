package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbLimitSumHist;
import com.dcits.deposit.entity.RbLimitSumHistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbLimitSumHistMapper {
    long countByExample(RbLimitSumHistExample example);

    int deleteByExample(RbLimitSumHistExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo);

    int insert(RbLimitSumHist row);

    int insertSelective(RbLimitSumHist row);

    List<RbLimitSumHist> selectByExample(RbLimitSumHistExample example);

    RbLimitSumHist selectByPrimaryKey(@Param("seqNo") String seqNo);

    int updateByExampleSelective(@Param("row") RbLimitSumHist row, @Param("example") RbLimitSumHistExample example);

    int updateByExample(@Param("row") RbLimitSumHist row, @Param("example") RbLimitSumHistExample example);

    int updateByPrimaryKeySelective(RbLimitSumHist row);

    int updateByPrimaryKey(RbLimitSumHist row);
}