package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbLimitSumInfo;
import com.dcits.deposit.entity.RbLimitSumInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbLimitSumInfoMapper {
    long countByExample(RbLimitSumInfoExample example);

    int deleteByExample(RbLimitSumInfoExample example);

    int deleteByPrimaryKey(@Param("clientNo") String clientNo, @Param("limitSceneNo") String limitSceneNo, @Param("checkObjVal") String checkObjVal);

    int insert(RbLimitSumInfo row);

    int insertSelective(RbLimitSumInfo row);

    List<RbLimitSumInfo> selectByExample(RbLimitSumInfoExample example);

    RbLimitSumInfo selectByPrimaryKey(@Param("clientNo") String clientNo, @Param("limitSceneNo") String limitSceneNo, @Param("checkObjVal") String checkObjVal);

    int updateByExampleSelective(@Param("row") RbLimitSumInfo row, @Param("example") RbLimitSumInfoExample example);

    int updateByExample(@Param("row") RbLimitSumInfo row, @Param("example") RbLimitSumInfoExample example);

    int updateByPrimaryKeySelective(RbLimitSumInfo row);

    int updateByPrimaryKey(RbLimitSumInfo row);
}