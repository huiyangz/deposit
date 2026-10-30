package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBusAcctBalance;
import com.dcits.deposit.entity.RbBusAcctBalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusAcctBalanceMapper {
    long countByExample(RbBusAcctBalanceExample example);

    int deleteByExample(RbBusAcctBalanceExample example);

    int deleteByPrimaryKey(@Param("internalKey") Integer internalKey);

    int insert(RbBusAcctBalance row);

    int insertSelective(RbBusAcctBalance row);

    List<RbBusAcctBalance> selectByExample(RbBusAcctBalanceExample example);

    RbBusAcctBalance selectByPrimaryKey(@Param("internalKey") Integer internalKey);

    int updateByExampleSelective(@Param("row") RbBusAcctBalance row, @Param("example") RbBusAcctBalanceExample example);

    int updateByExample(@Param("row") RbBusAcctBalance row, @Param("example") RbBusAcctBalanceExample example);

    int updateByPrimaryKeySelective(RbBusAcctBalance row);

    int updateByPrimaryKey(RbBusAcctBalance row);
}