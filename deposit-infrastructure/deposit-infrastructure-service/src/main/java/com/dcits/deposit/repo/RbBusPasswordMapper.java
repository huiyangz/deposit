package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBusPassword;
import com.dcits.deposit.entity.RbBusPasswordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusPasswordMapper {
    long countByExample(RbBusPasswordExample example);

    int deleteByExample(RbBusPasswordExample example);

    int deleteByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("pwdType") String pwdType, @Param("pwdKey") String pwdKey);

    int insert(RbBusPassword row);

    int insertSelective(RbBusPassword row);

    List<RbBusPassword> selectByExample(RbBusPasswordExample example);

    RbBusPassword selectByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("pwdType") String pwdType, @Param("pwdKey") String pwdKey);

    int updateByExampleSelective(@Param("row") RbBusPassword row, @Param("example") RbBusPasswordExample example);

    int updateByExample(@Param("row") RbBusPassword row, @Param("example") RbBusPasswordExample example);

    int updateByPrimaryKeySelective(RbBusPassword row);

    int updateByPrimaryKey(RbBusPassword row);
}