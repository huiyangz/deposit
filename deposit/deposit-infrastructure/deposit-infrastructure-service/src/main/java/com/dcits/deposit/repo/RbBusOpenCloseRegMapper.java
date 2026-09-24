package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBusOpenCloseReg;
import com.dcits.deposit.entity.RbBusOpenCloseRegExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusOpenCloseRegMapper {
    long countByExample(RbBusOpenCloseRegExample example);

    int deleteByExample(RbBusOpenCloseRegExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo);

    int insert(RbBusOpenCloseReg row);

    int insertSelective(RbBusOpenCloseReg row);

    List<RbBusOpenCloseReg> selectByExample(RbBusOpenCloseRegExample example);

    RbBusOpenCloseReg selectByPrimaryKey(@Param("seqNo") String seqNo);

    int updateByExampleSelective(@Param("row") RbBusOpenCloseReg row, @Param("example") RbBusOpenCloseRegExample example);

    int updateByExample(@Param("row") RbBusOpenCloseReg row, @Param("example") RbBusOpenCloseRegExample example);

    int updateByPrimaryKeySelective(RbBusOpenCloseReg row);

    int updateByPrimaryKey(RbBusOpenCloseReg row);
}