package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAgreementYht;
import com.dcits.deposit.entity.RbAgreementYhtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAgreementYhtMapper {
    long countByExample(RbAgreementYhtExample example);

    int deleteByExample(RbAgreementYhtExample example);

    int deleteByPrimaryKey(@Param("agreementId") String agreementId, @Param("clientNo") String clientNo);

    int insert(RbAgreementYht row);

    int insertSelective(RbAgreementYht row);

    List<RbAgreementYht> selectByExample(RbAgreementYhtExample example);

    RbAgreementYht selectByPrimaryKey(@Param("agreementId") String agreementId, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbAgreementYht row, @Param("example") RbAgreementYhtExample example);

    int updateByExample(@Param("row") RbAgreementYht row, @Param("example") RbAgreementYhtExample example);

    int updateByPrimaryKeySelective(RbAgreementYht row);

    int updateByPrimaryKey(RbAgreementYht row);
}