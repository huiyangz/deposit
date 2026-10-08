package com.dcits.depsit.repo;

import com.dcits.depsit.entity.RbOdBranchInfo;
import com.dcits.depsit.entity.RbOdBranchInfoExample;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbOdBranchInfoMapper {
    long countByExample(RbOdBranchInfoExample example);

    int deleteByExample(RbOdBranchInfoExample example);

    int deleteByPrimaryKey(@Param("lastChangeDate") Date lastChangeDate, @Param("usedAmt") BigDecimal usedAmt, @Param("createTimestamp") String createTimestamp, @Param("branch") String branch, @Param("tranTimestamp") String tranTimestamp, @Param("company") String company, @Param("totalLimit") BigDecimal totalLimit);

    int insert(RbOdBranchInfo row);

    int insertSelective(RbOdBranchInfo row);

    List<RbOdBranchInfo> selectByExample(RbOdBranchInfoExample example);

    RbOdBranchInfo selectByPrimaryKey(@Param("lastChangeDate") Date lastChangeDate, @Param("usedAmt") BigDecimal usedAmt, @Param("createTimestamp") String createTimestamp, @Param("branch") String branch, @Param("tranTimestamp") String tranTimestamp, @Param("company") String company, @Param("totalLimit") BigDecimal totalLimit);

    int updateByExampleSelective(@Param("row") RbOdBranchInfo row, @Param("example") RbOdBranchInfoExample example);

    int updateByExample(@Param("row") RbOdBranchInfo row, @Param("example") RbOdBranchInfoExample example);

    int updateByPrimaryKeySelective(RbOdBranchInfo row);

    int updateByPrimaryKey(RbOdBranchInfo row);
}