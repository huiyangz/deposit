package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBusAgreementYht;
import com.dcits.deposit.entity.RbBusAgreementYhtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusAgreementYhtMapper {
    long countByExample(RbBusAgreementYhtExample example);

    int deleteByExample(RbBusAgreementYhtExample example);

    int deleteByPrimaryKey(@Param("agreementId") String agreementId);

    int insert(RbBusAgreementYht row);

    int insertSelective(RbBusAgreementYht row);

    List<RbBusAgreementYht> selectByExample(RbBusAgreementYhtExample example);

    RbBusAgreementYht selectByPrimaryKey(@Param("agreementId") String agreementId);

    int updateByExampleSelective(@Param("row") RbBusAgreementYht row, @Param("example") RbBusAgreementYhtExample example);

    int updateByExample(@Param("row") RbBusAgreementYht row, @Param("example") RbBusAgreementYhtExample example);

    int updateByPrimaryKeySelective(RbBusAgreementYht row);

    int updateByPrimaryKey(RbBusAgreementYht row);
}