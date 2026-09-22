package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbSignType;
import com.dcits.deposit.entity.RbSignTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbSignTypeMapper {
    long countByExample(RbSignTypeExample example);

    int deleteByExample(RbSignTypeExample example);

    int deleteByPrimaryKey(@Param("signType") String signType);

    int insert(RbSignType row);

    int insertSelective(RbSignType row);

    List<RbSignType> selectByExample(RbSignTypeExample example);

    RbSignType selectByPrimaryKey(@Param("signType") String signType);

    int updateByExampleSelective(@Param("row") RbSignType row, @Param("example") RbSignTypeExample example);

    int updateByExample(@Param("row") RbSignType row, @Param("example") RbSignTypeExample example);

    int updateByPrimaryKeySelective(RbSignType row);

    int updateByPrimaryKey(RbSignType row);
}