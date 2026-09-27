package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBusAcctIntDetail;
import com.dcits.deposit.entity.RbBusAcctIntDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusAcctIntDetailMapper {
    long countByExample(RbBusAcctIntDetailExample example);

    int deleteByExample(RbBusAcctIntDetailExample example);

    int deleteByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("intClass") String intClass);

    int insert(RbBusAcctIntDetail row);

    int insertSelective(RbBusAcctIntDetail row);

    List<RbBusAcctIntDetail> selectByExample(RbBusAcctIntDetailExample example);

    RbBusAcctIntDetail selectByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("intClass") String intClass);

    int updateByExampleSelective(@Param("row") RbBusAcctIntDetail row, @Param("example") RbBusAcctIntDetailExample example);

    int updateByExample(@Param("row") RbBusAcctIntDetail row, @Param("example") RbBusAcctIntDetailExample example);

    int updateByPrimaryKeySelective(RbBusAcctIntDetail row);

    int updateByPrimaryKey(RbBusAcctIntDetail row);
}