package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAcctAttach;
import com.dcits.deposit.entity.RbAcctAttachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAcctAttachMapper {
    long countByExample(RbAcctAttachExample example);

    int deleteByExample(RbAcctAttachExample example);

    int deleteByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("clientNo") String clientNo);

    int insert(RbAcctAttach row);

    int insertSelective(RbAcctAttach row);

    List<RbAcctAttach> selectByExample(RbAcctAttachExample example);

    RbAcctAttach selectByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbAcctAttach row, @Param("example") RbAcctAttachExample example);

    int updateByExample(@Param("row") RbAcctAttach row, @Param("example") RbAcctAttachExample example);

    int updateByPrimaryKeySelective(RbAcctAttach row);

    int updateByPrimaryKey(RbAcctAttach row);
}