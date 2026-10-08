package com.dcits.depsit.repo;

import com.dcits.depsit.entity.RbChannelClass;
import com.dcits.depsit.entity.RbChannelClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbChannelClassMapper {
    long countByExample(RbChannelClassExample example);

    int deleteByExample(RbChannelClassExample example);

    int deleteByPrimaryKey(@Param("channel") String channel);

    int insert(RbChannelClass row);

    int insertSelective(RbChannelClass row);

    List<RbChannelClass> selectByExample(RbChannelClassExample example);

    RbChannelClass selectByPrimaryKey(@Param("channel") String channel);

    int updateByExampleSelective(@Param("row") RbChannelClass row, @Param("example") RbChannelClassExample example);

    int updateByExample(@Param("row") RbChannelClass row, @Param("example") RbChannelClassExample example);

    int updateByPrimaryKeySelective(RbChannelClass row);

    int updateByPrimaryKey(RbChannelClass row);
}