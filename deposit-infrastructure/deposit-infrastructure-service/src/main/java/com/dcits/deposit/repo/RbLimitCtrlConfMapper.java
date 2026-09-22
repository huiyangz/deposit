package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbLimitCtrlConf;
import com.dcits.deposit.entity.RbLimitCtrlConfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbLimitCtrlConfMapper {
    long countByExample(RbLimitCtrlConfExample example);

    int deleteByExample(RbLimitCtrlConfExample example);

    int deleteByPrimaryKey(@Param("limitSceneNo") String limitSceneNo, @Param("limitBranchId") String limitBranchId);

    int insert(RbLimitCtrlConf row);

    int insertSelective(RbLimitCtrlConf row);

    List<RbLimitCtrlConf> selectByExample(RbLimitCtrlConfExample example);

    RbLimitCtrlConf selectByPrimaryKey(@Param("limitSceneNo") String limitSceneNo, @Param("limitBranchId") String limitBranchId);

    int updateByExampleSelective(@Param("row") RbLimitCtrlConf row, @Param("example") RbLimitCtrlConfExample example);

    int updateByExample(@Param("row") RbLimitCtrlConf row, @Param("example") RbLimitCtrlConfExample example);

    int updateByPrimaryKeySelective(RbLimitCtrlConf row);

    int updateByPrimaryKey(RbLimitCtrlConf row);
}