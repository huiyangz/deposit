package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAcctNatureDef;
import com.dcits.deposit.entity.RbAcctNatureDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAcctNatureDefMapper {
    long countByExample(RbAcctNatureDefExample example);

    int deleteByExample(RbAcctNatureDefExample example);

    int deleteByPrimaryKey(@Param("acctNatureNo") String acctNatureNo);

    int insert(RbAcctNatureDef row);

    int insertSelective(RbAcctNatureDef row);

    List<RbAcctNatureDef> selectByExample(RbAcctNatureDefExample example);

    RbAcctNatureDef selectByPrimaryKey(@Param("acctNatureNo") String acctNatureNo);

    int updateByExampleSelective(@Param("row") RbAcctNatureDef row, @Param("example") RbAcctNatureDefExample example);

    int updateByExample(@Param("row") RbAcctNatureDef row, @Param("example") RbAcctNatureDefExample example);

    int updateByPrimaryKeySelective(RbAcctNatureDef row);

    int updateByPrimaryKey(RbAcctNatureDef row);
}