package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbControlTypeDef;
import com.dcits.deposit.entity.RbControlTypeDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbControlTypeDefMapper {
    long countByExample(RbControlTypeDefExample example);

    int deleteByExample(RbControlTypeDefExample example);

    int deleteByPrimaryKey(@Param("controlType") String controlType, @Param("controlClass") String controlClass);

    int insert(RbControlTypeDef row);

    int insertSelective(RbControlTypeDef row);

    List<RbControlTypeDef> selectByExample(RbControlTypeDefExample example);

    RbControlTypeDef selectByPrimaryKey(@Param("controlType") String controlType, @Param("controlClass") String controlClass);

    int updateByExampleSelective(@Param("row") RbControlTypeDef row, @Param("example") RbControlTypeDefExample example);

    int updateByExample(@Param("row") RbControlTypeDef row, @Param("example") RbControlTypeDefExample example);

    int updateByPrimaryKeySelective(RbControlTypeDef row);

    int updateByPrimaryKey(RbControlTypeDef row);
}