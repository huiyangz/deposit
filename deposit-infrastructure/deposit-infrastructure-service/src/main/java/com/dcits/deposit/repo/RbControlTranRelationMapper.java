package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbControlTranRelation;
import com.dcits.deposit.entity.RbControlTranRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbControlTranRelationMapper {
    long countByExample(RbControlTranRelationExample example);

    int deleteByExample(RbControlTranRelationExample example);

    int deleteByPrimaryKey(@Param("controlClass") String controlClass, @Param("tranType") String tranType, @Param("serviceNo") String serviceNo);

    int insert(RbControlTranRelation row);

    int insertSelective(RbControlTranRelation row);

    List<RbControlTranRelation> selectByExample(RbControlTranRelationExample example);

    RbControlTranRelation selectByPrimaryKey(@Param("controlClass") String controlClass, @Param("tranType") String tranType, @Param("serviceNo") String serviceNo);

    int updateByExampleSelective(@Param("row") RbControlTranRelation row, @Param("example") RbControlTranRelationExample example);

    int updateByExample(@Param("row") RbControlTranRelation row, @Param("example") RbControlTranRelationExample example);

    int updateByPrimaryKeySelective(RbControlTranRelation row);

    int updateByPrimaryKey(RbControlTranRelation row);
}