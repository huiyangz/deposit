package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBusClientAcct;
import com.dcits.deposit.entity.RbBusClientAcctExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusClientAcctMapper {
    long countByExample(RbBusClientAcctExample example);

    int deleteByExample(RbBusClientAcctExample example);

    int deleteByPrimaryKey(@Param("baseAcctNo") String baseAcctNo, @Param("clientNo") String clientNo);

    int insert(RbBusClientAcct row);

    int insertSelective(RbBusClientAcct row);

    List<RbBusClientAcct> selectByExample(RbBusClientAcctExample example);

    RbBusClientAcct selectByPrimaryKey(@Param("baseAcctNo") String baseAcctNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbBusClientAcct row, @Param("example") RbBusClientAcctExample example);

    int updateByExample(@Param("row") RbBusClientAcct row, @Param("example") RbBusClientAcctExample example);

    int updateByPrimaryKeySelective(RbBusClientAcct row);

    int updateByPrimaryKey(RbBusClientAcct row);
}