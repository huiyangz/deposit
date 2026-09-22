package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbOpenCloseReg;
import com.dcits.deposit.entity.RbOpenCloseRegExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbOpenCloseRegMapper {
    long countByExample(RbOpenCloseRegExample example);

    int deleteByExample(RbOpenCloseRegExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo);

    int insert(RbOpenCloseReg row);

    int insertSelective(RbOpenCloseReg row);

    List<RbOpenCloseReg> selectByExample(RbOpenCloseRegExample example);

    RbOpenCloseReg selectByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbOpenCloseReg row, @Param("example") RbOpenCloseRegExample example);

    int updateByExample(@Param("row") RbOpenCloseReg row, @Param("example") RbOpenCloseRegExample example);

    int updateByPrimaryKeySelective(RbOpenCloseReg row);

    int updateByPrimaryKey(RbOpenCloseReg row);
}