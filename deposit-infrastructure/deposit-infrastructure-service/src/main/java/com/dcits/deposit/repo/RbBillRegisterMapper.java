package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBillRegister;
import com.dcits.deposit.entity.RbBillRegisterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBillRegisterMapper {
    long countByExample(RbBillRegisterExample example);

    int deleteByExample(RbBillRegisterExample example);

    int deleteByPrimaryKey(@Param("billSerialNo") String billSerialNo, @Param("clientNo") String clientNo);

    int insert(RbBillRegister row);

    int insertSelective(RbBillRegister row);

    List<RbBillRegister> selectByExample(RbBillRegisterExample example);

    RbBillRegister selectByPrimaryKey(@Param("billSerialNo") String billSerialNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbBillRegister row, @Param("example") RbBillRegisterExample example);

    int updateByExample(@Param("row") RbBillRegister row, @Param("example") RbBillRegisterExample example);

    int updateByPrimaryKeySelective(RbBillRegister row);

    int updateByPrimaryKey(RbBillRegister row);
}