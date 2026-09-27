package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbCommissionRegister;
import com.dcits.deposit.entity.RbCommissionRegisterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbCommissionRegisterMapper {
    long countByExample(RbCommissionRegisterExample example);

    int deleteByExample(RbCommissionRegisterExample example);

    int deleteByPrimaryKey(@Param("channelSeqNo") String channelSeqNo, @Param("clientNo") String clientNo);

    int insert(RbCommissionRegister row);

    int insertSelective(RbCommissionRegister row);

    List<RbCommissionRegister> selectByExample(RbCommissionRegisterExample example);

    RbCommissionRegister selectByPrimaryKey(@Param("channelSeqNo") String channelSeqNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbCommissionRegister row, @Param("example") RbCommissionRegisterExample example);

    int updateByExample(@Param("row") RbCommissionRegister row, @Param("example") RbCommissionRegisterExample example);

    int updateByPrimaryKeySelective(RbCommissionRegister row);

    int updateByPrimaryKey(RbCommissionRegister row);
}