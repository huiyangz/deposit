package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbLimitSceneDef;
import com.dcits.deposit.entity.RbLimitSceneDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbLimitSceneDefMapper {
    long countByExample(RbLimitSceneDefExample example);

    int deleteByExample(RbLimitSceneDefExample example);

    int deleteByPrimaryKey(@Param("limitSceneNo") String limitSceneNo);

    int insert(RbLimitSceneDef row);

    int insertSelective(RbLimitSceneDef row);

    List<RbLimitSceneDef> selectByExample(RbLimitSceneDefExample example);

    RbLimitSceneDef selectByPrimaryKey(@Param("limitSceneNo") String limitSceneNo);

    int updateByExampleSelective(@Param("row") RbLimitSceneDef row, @Param("example") RbLimitSceneDefExample example);

    int updateByExample(@Param("row") RbLimitSceneDef row, @Param("example") RbLimitSceneDefExample example);

    int updateByPrimaryKeySelective(RbLimitSceneDef row);

    int updateByPrimaryKey(RbLimitSceneDef row);
}