package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAcctNatureRestraints;
import com.dcits.deposit.entity.RbAcctNatureRestraintsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAcctNatureRestraintsMapper {
    long countByExample(RbAcctNatureRestraintsExample example);

    int deleteByExample(RbAcctNatureRestraintsExample example);

    int deleteByPrimaryKey(@Param("restraintType") String restraintType, @Param("acctNatureNo") String acctNatureNo);

    int insert(RbAcctNatureRestraints row);

    int insertSelective(RbAcctNatureRestraints row);

    List<RbAcctNatureRestraints> selectByExample(RbAcctNatureRestraintsExample example);

    RbAcctNatureRestraints selectByPrimaryKey(@Param("restraintType") String restraintType, @Param("acctNatureNo") String acctNatureNo);

    int updateByExampleSelective(@Param("row") RbAcctNatureRestraints row, @Param("example") RbAcctNatureRestraintsExample example);

    int updateByExample(@Param("row") RbAcctNatureRestraints row, @Param("example") RbAcctNatureRestraintsExample example);

    int updateByPrimaryKeySelective(RbAcctNatureRestraints row);

    int updateByPrimaryKey(RbAcctNatureRestraints row);
}