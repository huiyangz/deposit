package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbPassword;
import com.dcits.deposit.entity.RbPasswordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbPasswordMapper {
    long countByExample(RbPasswordExample example);

    int deleteByExample(RbPasswordExample example);

    int deleteByPrimaryKey(@Param("pwdKey") String pwdKey, @Param("pwdType") String pwdType, @Param("clientNo") String clientNo);

    int insert(RbPassword row);

    int insertSelective(RbPassword row);

    List<RbPassword> selectByExample(RbPasswordExample example);

    RbPassword selectByPrimaryKey(@Param("pwdKey") String pwdKey, @Param("pwdType") String pwdType, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbPassword row, @Param("example") RbPasswordExample example);

    int updateByExample(@Param("row") RbPassword row, @Param("example") RbPasswordExample example);

    int updateByPrimaryKeySelective(RbPassword row);

    int updateByPrimaryKey(RbPassword row);
}