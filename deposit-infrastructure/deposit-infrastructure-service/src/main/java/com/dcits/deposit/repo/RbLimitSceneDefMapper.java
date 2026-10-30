package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbLimitSceneDef;
import com.dcits.deposit.entity.RbLimitSceneDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbLimitSceneDefMapper {
    long countByExample(RbLimitSceneDefExample example);

    int deleteByExample(RbLimitSceneDefExample example);

    int deleteByPrimaryKey(@Param("limitCcy") String limitCcy, @Param("checkObjType") String checkObjType, @Param("lastUpdTimestamp") String lastUpdTimestamp, @Param("limitSceneDesc") String limitSceneDesc, @Param("createTimestamp") String createTimestamp, @Param("validFlag") String validFlag, @Param("limitConvert") String limitConvert, @Param("limitMainType") String limitMainType);

    int insert(RbLimitSceneDef row);

    int insertSelective(RbLimitSceneDef row);

    List<RbLimitSceneDef> selectByExample(RbLimitSceneDefExample example);

    RbLimitSceneDef selectByPrimaryKey(@Param("limitCcy") String limitCcy, @Param("checkObjType") String checkObjType, @Param("lastUpdTimestamp") String lastUpdTimestamp, @Param("limitSceneDesc") String limitSceneDesc, @Param("createTimestamp") String createTimestamp, @Param("validFlag") String validFlag, @Param("limitConvert") String limitConvert, @Param("limitMainType") String limitMainType);

    int updateByExampleSelective(@Param("row") RbLimitSceneDef row, @Param("example") RbLimitSceneDefExample example);

    int updateByExample(@Param("row") RbLimitSceneDef row, @Param("example") RbLimitSceneDefExample example);

    int updateByPrimaryKeySelective(RbLimitSceneDef row);

    int updateByPrimaryKey(RbLimitSceneDef row);
}