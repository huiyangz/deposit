package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbLimitCtrlCustomInfo;
import com.dcits.deposit.entity.RbLimitCtrlCustomInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbLimitCtrlCustomInfoMapper {
    long countByExample(RbLimitCtrlCustomInfoExample example);

    int deleteByExample(RbLimitCtrlCustomInfoExample example);

    int deleteByPrimaryKey(@Param("clientNo") String clientNo, @Param("limitSceneNo") String limitSceneNo, @Param("checkObjVal") String checkObjVal);

    int insert(RbLimitCtrlCustomInfo row);

    int insertSelective(RbLimitCtrlCustomInfo row);

    List<RbLimitCtrlCustomInfo> selectByExample(RbLimitCtrlCustomInfoExample example);

    RbLimitCtrlCustomInfo selectByPrimaryKey(@Param("clientNo") String clientNo, @Param("limitSceneNo") String limitSceneNo, @Param("checkObjVal") String checkObjVal);

    int updateByExampleSelective(@Param("row") RbLimitCtrlCustomInfo row, @Param("example") RbLimitCtrlCustomInfoExample example);

    int updateByExample(@Param("row") RbLimitCtrlCustomInfo row, @Param("example") RbLimitCtrlCustomInfoExample example);

    int updateByPrimaryKeySelective(RbLimitCtrlCustomInfo row);

    int updateByPrimaryKey(RbLimitCtrlCustomInfo row);
}