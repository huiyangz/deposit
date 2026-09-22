package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbRestraints;
import com.dcits.deposit.entity.RbRestraintsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbRestraintsMapper {
    long countByExample(RbRestraintsExample example);

    int deleteByExample(RbRestraintsExample example);

    int deleteByPrimaryKey(@Param("resSeqNo") String resSeqNo, @Param("clientNo") String clientNo);

    int insert(RbRestraints row);

    int insertSelective(RbRestraints row);

    List<RbRestraints> selectByExample(RbRestraintsExample example);

    RbRestraints selectByPrimaryKey(@Param("resSeqNo") String resSeqNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbRestraints row, @Param("example") RbRestraintsExample example);

    int updateByExample(@Param("row") RbRestraints row, @Param("example") RbRestraintsExample example);

    int updateByPrimaryKeySelective(RbRestraints row);

    int updateByPrimaryKey(RbRestraints row);
}