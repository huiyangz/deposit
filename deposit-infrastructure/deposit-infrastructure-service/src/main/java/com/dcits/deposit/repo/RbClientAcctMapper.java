package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbClientAcct;
import com.dcits.deposit.entity.RbClientAcctExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbClientAcctMapper {
    long countByExample(RbClientAcctExample example);

    int deleteByExample(RbClientAcctExample example);

    int deleteByPrimaryKey(@Param("baseAcctNo") String baseAcctNo, @Param("clientNo") String clientNo);

    int insert(RbClientAcct row);

    int insertSelective(RbClientAcct row);

    List<RbClientAcct> selectByExample(RbClientAcctExample example);

    RbClientAcct selectByPrimaryKey(@Param("baseAcctNo") String baseAcctNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbClientAcct row, @Param("example") RbClientAcctExample example);

    int updateByExample(@Param("row") RbClientAcct row, @Param("example") RbClientAcctExample example);

    int updateByPrimaryKeySelective(RbClientAcct row);

    int updateByPrimaryKey(RbClientAcct row);
}