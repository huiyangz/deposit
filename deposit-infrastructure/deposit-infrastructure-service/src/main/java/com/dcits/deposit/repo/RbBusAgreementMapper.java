package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBusAgreement;
import com.dcits.deposit.entity.RbBusAgreementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusAgreementMapper {
    long countByExample(RbBusAgreementExample example);

    int deleteByExample(RbBusAgreementExample example);

    int deleteByPrimaryKey(@Param("agreementId") String agreementId);

    int insert(RbBusAgreement row);

    int insertSelective(RbBusAgreement row);

    List<RbBusAgreement> selectByExample(RbBusAgreementExample example);

    RbBusAgreement selectByPrimaryKey(@Param("agreementId") String agreementId);

    int updateByExampleSelective(@Param("row") RbBusAgreement row, @Param("example") RbBusAgreementExample example);

    int updateByExample(@Param("row") RbBusAgreement row, @Param("example") RbBusAgreementExample example);

    int updateByPrimaryKeySelective(RbBusAgreement row);

    int updateByPrimaryKey(RbBusAgreement row);
}