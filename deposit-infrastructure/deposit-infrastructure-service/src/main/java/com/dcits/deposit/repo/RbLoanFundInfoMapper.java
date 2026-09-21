package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbLoanFundInfo;
import com.dcits.deposit.entity.RbLoanFundInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbLoanFundInfoMapper {
    long countByExample(RbLoanFundInfoExample example);

    int deleteByExample(RbLoanFundInfoExample example);

    int deleteByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("clientNo") String clientNo);

    int insert(RbLoanFundInfo row);

    int insertSelective(RbLoanFundInfo row);

    List<RbLoanFundInfo> selectByExample(RbLoanFundInfoExample example);

    RbLoanFundInfo selectByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbLoanFundInfo row, @Param("example") RbLoanFundInfoExample example);

    int updateByExample(@Param("row") RbLoanFundInfo row, @Param("example") RbLoanFundInfoExample example);

    int updateByPrimaryKeySelective(RbLoanFundInfo row);

    int updateByPrimaryKey(RbLoanFundInfo row);
}