package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbOdBranchInfo;
import com.dcits.deposit.entity.RbOdBranchInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbOdBranchInfoMapper {
    long countByExample(RbOdBranchInfoExample example);

    int deleteByExample(RbOdBranchInfoExample example);

    int deleteByPrimaryKey(@Param("branch") String branch);

    int insert(RbOdBranchInfo row);

    int insertSelective(RbOdBranchInfo row);

    List<RbOdBranchInfo> selectByExample(RbOdBranchInfoExample example);

    RbOdBranchInfo selectByPrimaryKey(@Param("branch") String branch);

    int updateByExampleSelective(@Param("row") RbOdBranchInfo row, @Param("example") RbOdBranchInfoExample example);

    int updateByExample(@Param("row") RbOdBranchInfo row, @Param("example") RbOdBranchInfoExample example);

    int updateByPrimaryKeySelective(RbOdBranchInfo row);

    int updateByPrimaryKey(RbOdBranchInfo row);
}