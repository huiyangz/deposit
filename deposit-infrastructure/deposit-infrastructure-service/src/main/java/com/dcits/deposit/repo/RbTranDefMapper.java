package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbTranDef;
import com.dcits.deposit.entity.RbTranDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbTranDefMapper {
    long countByExample(RbTranDefExample example);

    int deleteByExample(RbTranDefExample example);

    int deleteByPrimaryKey(@Param("tranType") String tranType);

    int insert(RbTranDef row);

    int insertSelective(RbTranDef row);

    List<RbTranDef> selectByExample(RbTranDefExample example);

    RbTranDef selectByPrimaryKey(@Param("tranType") String tranType);

    int updateByExampleSelective(@Param("row") RbTranDef row, @Param("example") RbTranDefExample example);

    int updateByExample(@Param("row") RbTranDef row, @Param("example") RbTranDefExample example);

    int updateByPrimaryKeySelective(RbTranDef row);

    int updateByPrimaryKey(RbTranDef row);
}