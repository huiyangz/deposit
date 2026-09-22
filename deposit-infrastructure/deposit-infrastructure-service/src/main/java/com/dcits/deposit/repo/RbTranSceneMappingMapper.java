package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbTranSceneMapping;
import com.dcits.deposit.entity.RbTranSceneMappingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbTranSceneMappingMapper {
    long countByExample(RbTranSceneMappingExample example);

    int deleteByExample(RbTranSceneMappingExample example);

    int deleteByPrimaryKey(@Param("tranScene") String tranScene);

    int insert(RbTranSceneMapping row);

    int insertSelective(RbTranSceneMapping row);

    List<RbTranSceneMapping> selectByExample(RbTranSceneMappingExample example);

    RbTranSceneMapping selectByPrimaryKey(@Param("tranScene") String tranScene);

    int updateByExampleSelective(@Param("row") RbTranSceneMapping row, @Param("example") RbTranSceneMappingExample example);

    int updateByExample(@Param("row") RbTranSceneMapping row, @Param("example") RbTranSceneMappingExample example);

    int updateByPrimaryKeySelective(RbTranSceneMapping row);

    int updateByPrimaryKey(RbTranSceneMapping row);
}