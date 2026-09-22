package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAcct;
import com.dcits.deposit.entity.RbAcctExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAcctMapper {
    long countByExample(RbAcctExample example);

    int deleteByExample(RbAcctExample example);

    int deleteByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("clientNo") String clientNo);

    int insert(RbAcct row);

    int insertSelective(RbAcct row);

    List<RbAcct> selectByExample(RbAcctExample example);

    RbAcct selectByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbAcct row, @Param("example") RbAcctExample example);

    int updateByExample(@Param("row") RbAcct row, @Param("example") RbAcctExample example);

    int updateByPrimaryKeySelective(RbAcct row);

    int updateByPrimaryKey(RbAcct row);
}