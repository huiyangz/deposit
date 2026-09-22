package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbDcPrecontract;
import com.dcits.deposit.entity.RbDcPrecontractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbDcPrecontractMapper {
    long countByExample(RbDcPrecontractExample example);

    int deleteByExample(RbDcPrecontractExample example);

    int deleteByPrimaryKey(@Param("precontractNo") String precontractNo, @Param("clientNo") String clientNo);

    int insert(RbDcPrecontract row);

    int insertSelective(RbDcPrecontract row);

    List<RbDcPrecontract> selectByExample(RbDcPrecontractExample example);

    RbDcPrecontract selectByPrimaryKey(@Param("precontractNo") String precontractNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbDcPrecontract row, @Param("example") RbDcPrecontractExample example);

    int updateByExample(@Param("row") RbDcPrecontract row, @Param("example") RbDcPrecontractExample example);

    int updateByPrimaryKeySelective(RbDcPrecontract row);

    int updateByPrimaryKey(RbDcPrecontract row);
}