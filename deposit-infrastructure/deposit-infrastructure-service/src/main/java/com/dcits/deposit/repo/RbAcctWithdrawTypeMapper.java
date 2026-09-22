package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAcctWithdrawType;
import com.dcits.deposit.entity.RbAcctWithdrawTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAcctWithdrawTypeMapper {
    long countByExample(RbAcctWithdrawTypeExample example);

    int deleteByExample(RbAcctWithdrawTypeExample example);

    int deleteByPrimaryKey(@Param("withdrawKey") String withdrawKey, @Param("withdrawalType") String withdrawalType, @Param("clientNo") String clientNo);

    int insert(RbAcctWithdrawType row);

    int insertSelective(RbAcctWithdrawType row);

    List<RbAcctWithdrawType> selectByExample(RbAcctWithdrawTypeExample example);

    RbAcctWithdrawType selectByPrimaryKey(@Param("withdrawKey") String withdrawKey, @Param("withdrawalType") String withdrawalType, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbAcctWithdrawType row, @Param("example") RbAcctWithdrawTypeExample example);

    int updateByExample(@Param("row") RbAcctWithdrawType row, @Param("example") RbAcctWithdrawTypeExample example);

    int updateByPrimaryKeySelective(RbAcctWithdrawType row);

    int updateByPrimaryKey(RbAcctWithdrawType row);
}