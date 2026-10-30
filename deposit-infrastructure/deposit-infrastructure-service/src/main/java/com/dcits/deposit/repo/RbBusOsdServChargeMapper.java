package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBusOsdServCharge;
import com.dcits.deposit.entity.RbBusOsdServChargeExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusOsdServChargeMapper {
    long countByExample(RbBusOsdServChargeExample example);

    int deleteByExample(RbBusOsdServChargeExample example);

    int deleteByPrimaryKey(@Param("osdSeqNo") String osdSeqNo, @Param("tranDate") Date tranDate);

    int insert(RbBusOsdServCharge row);

    int insertSelective(RbBusOsdServCharge row);

    List<RbBusOsdServCharge> selectByExample(RbBusOsdServChargeExample example);

    RbBusOsdServCharge selectByPrimaryKey(@Param("osdSeqNo") String osdSeqNo, @Param("tranDate") Date tranDate);

    int updateByExampleSelective(@Param("row") RbBusOsdServCharge row, @Param("example") RbBusOsdServChargeExample example);

    int updateByExample(@Param("row") RbBusOsdServCharge row, @Param("example") RbBusOsdServChargeExample example);

    int updateByPrimaryKeySelective(RbBusOsdServCharge row);

    int updateByPrimaryKey(RbBusOsdServCharge row);
}