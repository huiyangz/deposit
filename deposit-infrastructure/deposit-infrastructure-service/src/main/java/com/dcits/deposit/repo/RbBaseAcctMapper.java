package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBaseAcct;
import com.dcits.deposit.entity.RbBaseAcctExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBaseAcctMapper {
    long countByExample(RbBaseAcctExample example);

    int deleteByExample(RbBaseAcctExample example);

    int deleteByPrimaryKey(@Param("baseAcctNo") String baseAcctNo, @Param("clientNo") String clientNo);

    int insert(RbBaseAcct row);

    int insertSelective(RbBaseAcct row);

    List<RbBaseAcct> selectByExample(RbBaseAcctExample example);

    RbBaseAcct selectByPrimaryKey(@Param("baseAcctNo") String baseAcctNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbBaseAcct row, @Param("example") RbBaseAcctExample example);

    int updateByExample(@Param("row") RbBaseAcct row, @Param("example") RbBaseAcctExample example);

    int updateByPrimaryKeySelective(RbBaseAcct row);

    int updateByPrimaryKey(RbBaseAcct row);
}