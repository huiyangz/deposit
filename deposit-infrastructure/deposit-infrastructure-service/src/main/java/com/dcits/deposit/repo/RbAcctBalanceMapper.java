package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAcctBalance;
import com.dcits.deposit.entity.RbAcctBalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAcctBalanceMapper {
    long countByExample(RbAcctBalanceExample example);

    int deleteByExample(RbAcctBalanceExample example);

    int deleteByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("clientNo") String clientNo);

    int insert(RbAcctBalance row);

    int insertSelective(RbAcctBalance row);

    List<RbAcctBalance> selectByExample(RbAcctBalanceExample example);

    RbAcctBalance selectByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbAcctBalance row, @Param("example") RbAcctBalanceExample example);

    int updateByExample(@Param("row") RbAcctBalance row, @Param("example") RbAcctBalanceExample example);

    int updateByPrimaryKeySelective(RbAcctBalance row);

    int updateByPrimaryKey(RbAcctBalance row);
}