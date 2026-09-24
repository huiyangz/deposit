package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBusAcctSettle;
import com.dcits.deposit.entity.RbBusAcctSettleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusAcctSettleMapper {
    long countByExample(RbBusAcctSettleExample example);

    int deleteByExample(RbBusAcctSettleExample example);

    int deleteByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("settleNo") String settleNo);

    int insert(RbBusAcctSettle row);

    int insertSelective(RbBusAcctSettle row);

    List<RbBusAcctSettle> selectByExample(RbBusAcctSettleExample example);

    RbBusAcctSettle selectByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("settleNo") String settleNo);

    int updateByExampleSelective(@Param("row") RbBusAcctSettle row, @Param("example") RbBusAcctSettleExample example);

    int updateByExample(@Param("row") RbBusAcctSettle row, @Param("example") RbBusAcctSettleExample example);

    int updateByPrimaryKeySelective(RbBusAcctSettle row);

    int updateByPrimaryKey(RbBusAcctSettle row);
}