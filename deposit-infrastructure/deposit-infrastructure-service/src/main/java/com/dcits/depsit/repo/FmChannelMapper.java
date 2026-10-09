package com.dcits.depsit.repo;

import com.dcits.depsit.entity.FmChannel;
import com.dcits.depsit.entity.FmChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmChannelMapper {
    long countByExample(FmChannelExample example);

    int deleteByExample(FmChannelExample example);

    int deleteByPrimaryKey(@Param("channel") String channel);

    int insert(FmChannel row);

    int insertSelective(FmChannel row);

    List<FmChannel> selectByExample(FmChannelExample example);

    FmChannel selectByPrimaryKey(@Param("channel") String channel);

    int updateByExampleSelective(@Param("row") FmChannel row, @Param("example") FmChannelExample example);

    int updateByExample(@Param("row") FmChannel row, @Param("example") FmChannelExample example);

    int updateByPrimaryKeySelective(FmChannel row);

    int updateByPrimaryKey(FmChannel row);
}