package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAcctSettle;
import com.dcits.deposit.entity.RbAcctSettleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAcctSettleMapper {
    long countByExample(RbAcctSettleExample example);

    int deleteByExample(RbAcctSettleExample example);

    int deleteByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("settleNo") String settleNo, @Param("clientNo") String clientNo);

    int insert(RbAcctSettle row);

    int insertSelective(RbAcctSettle row);

    List<RbAcctSettle> selectByExample(RbAcctSettleExample example);

    RbAcctSettle selectByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("settleNo") String settleNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbAcctSettle row, @Param("example") RbAcctSettleExample example);

    int updateByExample(@Param("row") RbAcctSettle row, @Param("example") RbAcctSettleExample example);

    int updateByPrimaryKeySelective(RbAcctSettle row);

    int updateByPrimaryKey(RbAcctSettle row);
}