package com.dcits.deposit.repo;

import com.dcits.deposit.entity.FmStructureParam;
import com.dcits.deposit.entity.FmStructureParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmStructureParamMapper {
    long countByExample(FmStructureParamExample example);

    int deleteByExample(FmStructureParamExample example);

    int deleteByPrimaryKey(@Param("structureType") String structureType, @Param("paramType") String paramType, @Param("startPos") String startPos);

    int insert(FmStructureParam row);

    int insertSelective(FmStructureParam row);

    List<FmStructureParam> selectByExample(FmStructureParamExample example);

    FmStructureParam selectByPrimaryKey(@Param("structureType") String structureType, @Param("paramType") String paramType, @Param("startPos") String startPos);

    int updateByExampleSelective(@Param("row") FmStructureParam row, @Param("example") FmStructureParamExample example);

    int updateByExample(@Param("row") FmStructureParam row, @Param("example") FmStructureParamExample example);

    int updateByPrimaryKeySelective(FmStructureParam row);

    int updateByPrimaryKey(FmStructureParam row);
}