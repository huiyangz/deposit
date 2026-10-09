package com.dcits.depsit.repo;

import com.dcits.depsit.entity.MbIntMatrix;
import com.dcits.depsit.entity.MbIntMatrixExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MbIntMatrixMapper {
    long countByExample(MbIntMatrixExample example);

    int deleteByExample(MbIntMatrixExample example);

    int deleteByPrimaryKey(@Param("matrixNo") String matrixNo);

    int insert(MbIntMatrix row);

    int insertSelective(MbIntMatrix row);

    List<MbIntMatrix> selectByExample(MbIntMatrixExample example);

    MbIntMatrix selectByPrimaryKey(@Param("matrixNo") String matrixNo);

    int updateByExampleSelective(@Param("row") MbIntMatrix row, @Param("example") MbIntMatrixExample example);

    int updateByExample(@Param("row") MbIntMatrix row, @Param("example") MbIntMatrixExample example);

    int updateByPrimaryKeySelective(MbIntMatrix row);

    int updateByPrimaryKey(MbIntMatrix row);
}