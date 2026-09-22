package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAcctDoss;
import com.dcits.deposit.entity.RbAcctDossExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAcctDossMapper {
    long countByExample(RbAcctDossExample example);

    int deleteByExample(RbAcctDossExample example);

    int deleteByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("clientNo") String clientNo);

    int insert(RbAcctDoss row);

    int insertSelective(RbAcctDoss row);

    List<RbAcctDoss> selectByExample(RbAcctDossExample example);

    RbAcctDoss selectByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbAcctDoss row, @Param("example") RbAcctDossExample example);

    int updateByExample(@Param("row") RbAcctDoss row, @Param("example") RbAcctDossExample example);

    int updateByPrimaryKeySelective(RbAcctDoss row);

    int updateByPrimaryKey(RbAcctDoss row);
}