package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbCentReg;
import com.dcits.deposit.entity.RbCentRegExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbCentRegMapper {
    long countByExample(RbCentRegExample example);

    int deleteByExample(RbCentRegExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo);

    int insert(RbCentReg row);

    int insertSelective(RbCentReg row);

    List<RbCentReg> selectByExample(RbCentRegExample example);

    RbCentReg selectByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbCentReg row, @Param("example") RbCentRegExample example);

    int updateByExample(@Param("row") RbCentReg row, @Param("example") RbCentRegExample example);

    int updateByPrimaryKeySelective(RbCentReg row);

    int updateByPrimaryKey(RbCentReg row);
}