package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAcctDossReg;
import com.dcits.deposit.entity.RbAcctDossRegExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAcctDossRegMapper {
    long countByExample(RbAcctDossRegExample example);

    int deleteByExample(RbAcctDossRegExample example);

    int deleteByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("clientNo") String clientNo);

    int insert(RbAcctDossReg row);

    int insertSelective(RbAcctDossReg row);

    List<RbAcctDossReg> selectByExample(RbAcctDossRegExample example);

    RbAcctDossReg selectByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbAcctDossReg row, @Param("example") RbAcctDossRegExample example);

    int updateByExample(@Param("row") RbAcctDossReg row, @Param("example") RbAcctDossRegExample example);

    int updateByPrimaryKeySelective(RbAcctDossReg row);

    int updateByPrimaryKey(RbAcctDossReg row);
}