package com.dcits.depsit.repo;

import com.dcits.depsit.entity.RbBusAcctIntDetail;
import com.dcits.depsit.entity.RbBusAcctIntDetailExample;
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