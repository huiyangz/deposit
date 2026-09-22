package com.dcits.deposit.repo;

import com.dcits.deposit.entity.FmBranchCcy;
import com.dcits.deposit.entity.FmBranchCcyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmBranchCcyMapper {
    long countByExample(FmBranchCcyExample example);

    int deleteByExample(FmBranchCcyExample example);

    int deleteByPrimaryKey(@Param("branch") String branch, @Param("ccy") String ccy);

    int insert(FmBranchCcy row);

    int insertSelective(FmBranchCcy row);

    List<FmBranchCcy> selectByExample(FmBranchCcyExample example);

    FmBranchCcy selectByPrimaryKey(@Param("branch") String branch, @Param("ccy") String ccy);

    int updateByExampleSelective(@Param("row") FmBranchCcy row, @Param("example") FmBranchCcyExample example);

    int updateByExample(@Param("row") FmBranchCcy row, @Param("example") FmBranchCcyExample example);

    int updateByPrimaryKeySelective(FmBranchCcy row);

    int updateByPrimaryKey(FmBranchCcy row);
}