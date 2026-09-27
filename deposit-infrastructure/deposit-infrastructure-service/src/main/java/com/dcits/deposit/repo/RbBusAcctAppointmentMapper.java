package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBusAcctAppointment;
import com.dcits.deposit.entity.RbBusAcctAppointmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusAcctAppointmentMapper {
    long countByExample(RbBusAcctAppointmentExample example);

    int deleteByExample(RbBusAcctAppointmentExample example);

    int deleteByPrimaryKey(@Param("orderNo") String orderNo);

    int insert(RbBusAcctAppointment row);

    int insertSelective(RbBusAcctAppointment row);

    List<RbBusAcctAppointment> selectByExample(RbBusAcctAppointmentExample example);

    RbBusAcctAppointment selectByPrimaryKey(@Param("orderNo") String orderNo);

    int updateByExampleSelective(@Param("row") RbBusAcctAppointment row, @Param("example") RbBusAcctAppointmentExample example);

    int updateByExample(@Param("row") RbBusAcctAppointment row, @Param("example") RbBusAcctAppointmentExample example);

    int updateByPrimaryKeySelective(RbBusAcctAppointment row);

    int updateByPrimaryKey(RbBusAcctAppointment row);
}