package com.dcits.deposit.repo;

import com.dcits.deposit.entity.FmBranch;
import com.dcits.deposit.entity.FmBranchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmBranchMapper {
    long countByExample(FmBranchExample example);

    int deleteByExample(FmBranchExample example);

    int deleteByPrimaryKey(@Param("branch") String branch);

    int insert(FmBranch row);

    int insertSelective(FmBranch row);

    List<FmBranch> selectByExample(FmBranchExample example);

    FmBranch selectByPrimaryKey(@Param("branch") String branch);

    int updateByExampleSelective(@Param("row") FmBranch row, @Param("example") FmBranchExample example);

    int updateByExample(@Param("row") FmBranch row, @Param("example") FmBranchExample example);

    int updateByPrimaryKeySelective(FmBranch row);

    int updateByPrimaryKey(FmBranch row);
}