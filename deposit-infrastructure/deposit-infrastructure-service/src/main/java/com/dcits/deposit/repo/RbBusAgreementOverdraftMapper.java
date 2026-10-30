package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBusAgreementOverdraft;
import com.dcits.deposit.entity.RbBusAgreementOverdraftExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusAgreementOverdraftMapper {
    long countByExample(RbBusAgreementOverdraftExample example);

    int deleteByExample(RbBusAgreementOverdraftExample example);

    int deleteByPrimaryKey(@Param("agreementId") String agreementId);

    int insert(RbBusAgreementOverdraft row);

    int insertSelective(RbBusAgreementOverdraft row);

    List<RbBusAgreementOverdraft> selectByExample(RbBusAgreementOverdraftExample example);

    RbBusAgreementOverdraft selectByPrimaryKey(@Param("agreementId") String agreementId);

    int updateByExampleSelective(@Param("row") RbBusAgreementOverdraft row, @Param("example") RbBusAgreementOverdraftExample example);

    int updateByExample(@Param("row") RbBusAgreementOverdraft row, @Param("example") RbBusAgreementOverdraftExample example);

    int updateByPrimaryKeySelective(RbBusAgreementOverdraft row);

    int updateByPrimaryKey(RbBusAgreementOverdraft row);
}