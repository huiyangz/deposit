package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbClientRestraints;
import com.dcits.deposit.entity.RbClientRestraintsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbClientRestraintsMapper {
    long countByExample(RbClientRestraintsExample example);

    int deleteByExample(RbClientRestraintsExample example);

    int deleteByPrimaryKey(@Param("resSeqNo") String resSeqNo, @Param("clientNo") String clientNo);

    int insert(RbClientRestraints row);

    int insertSelective(RbClientRestraints row);

    List<RbClientRestraints> selectByExample(RbClientRestraintsExample example);

    RbClientRestraints selectByPrimaryKey(@Param("resSeqNo") String resSeqNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbClientRestraints row, @Param("example") RbClientRestraintsExample example);

    int updateByExample(@Param("row") RbClientRestraints row, @Param("example") RbClientRestraintsExample example);

    int updateByPrimaryKeySelective(RbClientRestraints row);

    int updateByPrimaryKey(RbClientRestraints row);
}