package com.dcits.depsit.repo;

import com.dcits.depsit.entity.RbOdWhiteLimitInfo;
import com.dcits.depsit.entity.RbOdWhiteLimitInfoExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbOdWhiteLimitInfoMapper {
    long countByExample(RbOdWhiteLimitInfoExample example);

    int deleteByExample(RbOdWhiteLimitInfoExample example);

    int deleteByPrimaryKey(@Param("odPtAmt") BigDecimal odPtAmt, @Param("tranTimestamp") String tranTimestamp, @Param("company") String company, @Param("sameObjectPdOdCumulative") BigDecimal sameObjectPdOdCumulative, @Param("vbsflag") String vbsflag, @Param("isCrossFlag") String isCrossFlag);

    int insert(RbOdWhiteLimitInfo row);

    int insertSelective(RbOdWhiteLimitInfo row);

    List<RbOdWhiteLimitInfo> selectByExample(RbOdWhiteLimitInfoExample example);

    RbOdWhiteLimitInfo selectByPrimaryKey(@Param("odPtAmt") BigDecimal odPtAmt, @Param("tranTimestamp") String tranTimestamp, @Param("company") String company, @Param("sameObjectPdOdCumulative") BigDecimal sameObjectPdOdCumulative, @Param("vbsflag") String vbsflag, @Param("isCrossFlag") String isCrossFlag);

    int updateByExampleSelective(@Param("row") RbOdWhiteLimitInfo row, @Param("example") RbOdWhiteLimitInfoExample example);

    int updateByExample(@Param("row") RbOdWhiteLimitInfo row, @Param("example") RbOdWhiteLimitInfoExample example);

    int updateByPrimaryKeySelective(RbOdWhiteLimitInfo row);

    int updateByPrimaryKey(RbOdWhiteLimitInfo row);
}