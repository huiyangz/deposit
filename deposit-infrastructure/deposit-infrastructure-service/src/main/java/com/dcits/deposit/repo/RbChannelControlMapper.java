package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbChannelControl;
import com.dcits.deposit.entity.RbChannelControlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbChannelControlMapper {
    long countByExample(RbChannelControlExample example);

    int deleteByExample(RbChannelControlExample example);

    int deleteByPrimaryKey(@Param("controlSeqNo") String controlSeqNo, @Param("clientNo") String clientNo);

    int insert(RbChannelControl row);

    int insertSelective(RbChannelControl row);

    List<RbChannelControl> selectByExample(RbChannelControlExample example);

    RbChannelControl selectByPrimaryKey(@Param("controlSeqNo") String controlSeqNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbChannelControl row, @Param("example") RbChannelControlExample example);

    int updateByExample(@Param("row") RbChannelControl row, @Param("example") RbChannelControlExample example);

    int updateByPrimaryKeySelective(RbChannelControl row);

    int updateByPrimaryKey(RbChannelControl row);
}