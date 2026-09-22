package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbLimitElementDef;
import com.dcits.deposit.entity.RbLimitElementDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbLimitElementDefMapper {
    long countByExample(RbLimitElementDefExample example);

    int deleteByExample(RbLimitElementDefExample example);

    int deleteByPrimaryKey(@Param("elementId") String elementId);

    int insert(RbLimitElementDef row);

    int insertSelective(RbLimitElementDef row);

    List<RbLimitElementDef> selectByExample(RbLimitElementDefExample example);

    RbLimitElementDef selectByPrimaryKey(@Param("elementId") String elementId);

    int updateByExampleSelective(@Param("row") RbLimitElementDef row, @Param("example") RbLimitElementDefExample example);

    int updateByExample(@Param("row") RbLimitElementDef row, @Param("example") RbLimitElementDefExample example);

    int updateByPrimaryKeySelective(RbLimitElementDef row);

    int updateByPrimaryKey(RbLimitElementDef row);
}