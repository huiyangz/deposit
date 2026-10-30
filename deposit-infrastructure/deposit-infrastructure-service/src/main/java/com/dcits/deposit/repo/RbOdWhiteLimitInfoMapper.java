package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbOdWhiteLimitInfo;
import com.dcits.deposit.entity.RbOdWhiteLimitInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbOdWhiteLimitInfoMapper {
    long countByExample(RbOdWhiteLimitInfoExample example);

    int deleteByExample(RbOdWhiteLimitInfoExample example);

    int deleteByPrimaryKey(@Param("vbsflag") String vbsflag, @Param("isCrossFlag") String isCrossFlag);

    int insert(RbOdWhiteLimitInfo row);

    int insertSelective(RbOdWhiteLimitInfo row);

    List<RbOdWhiteLimitInfo> selectByExample(RbOdWhiteLimitInfoExample example);

    RbOdWhiteLimitInfo selectByPrimaryKey(@Param("vbsflag") String vbsflag, @Param("isCrossFlag") String isCrossFlag);

    int updateByExampleSelective(@Param("row") RbOdWhiteLimitInfo row, @Param("example") RbOdWhiteLimitInfoExample example);

    int updateByExample(@Param("row") RbOdWhiteLimitInfo row, @Param("example") RbOdWhiteLimitInfoExample example);

    int updateByPrimaryKeySelective(RbOdWhiteLimitInfo row);

    int updateByPrimaryKey(RbOdWhiteLimitInfo row);
}