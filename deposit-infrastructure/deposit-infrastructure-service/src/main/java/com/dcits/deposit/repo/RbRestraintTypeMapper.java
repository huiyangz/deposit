package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbRestraintType;
import com.dcits.deposit.entity.RbRestraintTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbRestraintTypeMapper {
    long countByExample(RbRestraintTypeExample example);

    int deleteByExample(RbRestraintTypeExample example);

    int deleteByPrimaryKey(@Param("restraintType") String restraintType);

    int insert(RbRestraintType row);

    int insertSelective(RbRestraintType row);

    List<RbRestraintType> selectByExample(RbRestraintTypeExample example);

    RbRestraintType selectByPrimaryKey(@Param("restraintType") String restraintType);

    int updateByExampleSelective(@Param("row") RbRestraintType row, @Param("example") RbRestraintTypeExample example);

    int updateByExample(@Param("row") RbRestraintType row, @Param("example") RbRestraintTypeExample example);

    int updateByPrimaryKeySelective(RbRestraintType row);

    int updateByPrimaryKey(RbRestraintType row);
}