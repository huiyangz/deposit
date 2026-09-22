package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAgreement;
import com.dcits.deposit.entity.RbAgreementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAgreementMapper {
    long countByExample(RbAgreementExample example);

    int deleteByExample(RbAgreementExample example);

    int deleteByPrimaryKey(@Param("agreementId") String agreementId, @Param("clientNo") String clientNo);

    int insert(RbAgreement row);

    int insertSelective(RbAgreement row);

    List<RbAgreement> selectByExample(RbAgreementExample example);

    RbAgreement selectByPrimaryKey(@Param("agreementId") String agreementId, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbAgreement row, @Param("example") RbAgreementExample example);

    int updateByExample(@Param("row") RbAgreement row, @Param("example") RbAgreementExample example);

    int updateByPrimaryKeySelective(RbAgreement row);

    int updateByPrimaryKey(RbAgreement row);
}