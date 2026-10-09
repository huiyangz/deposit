package com.dcits.depsit.repo;

import com.dcits.depsit.entity.RbBusinessParameter;
import com.dcits.depsit.entity.RbBusinessParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusinessParameterMapper {
    long countByExample(RbBusinessParameterExample example);

    int deleteByExample(RbBusinessParameterExample example);

    int deleteByPrimaryKey(@Param("paraKey") String paraKey);

    int insert(RbBusinessParameter row);

    int insertSelective(RbBusinessParameter row);

    List<RbBusinessParameter> selectByExample(RbBusinessParameterExample example);

    RbBusinessParameter selectByPrimaryKey(@Param("paraKey") String paraKey);

    int updateByExampleSelective(@Param("row") RbBusinessParameter row, @Param("example") RbBusinessParameterExample example);

    int updateByExample(@Param("row") RbBusinessParameter row, @Param("example") RbBusinessParameterExample example);

    int updateByPrimaryKeySelective(RbBusinessParameter row);

    int updateByPrimaryKey(RbBusinessParameter row);
}