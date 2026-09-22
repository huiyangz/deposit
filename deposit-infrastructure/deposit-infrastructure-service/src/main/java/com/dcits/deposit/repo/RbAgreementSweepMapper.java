package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAgreementSweep;
import com.dcits.deposit.entity.RbAgreementSweepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAgreementSweepMapper {
    long countByExample(RbAgreementSweepExample example);

    int deleteByExample(RbAgreementSweepExample example);

    int deleteByPrimaryKey(@Param("agreementId") String agreementId, @Param("clientNo") String clientNo);

    int insert(RbAgreementSweep row);

    int insertSelective(RbAgreementSweep row);

    List<RbAgreementSweep> selectByExample(RbAgreementSweepExample example);

    RbAgreementSweep selectByPrimaryKey(@Param("agreementId") String agreementId, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbAgreementSweep row, @Param("example") RbAgreementSweepExample example);

    int updateByExample(@Param("row") RbAgreementSweep row, @Param("example") RbAgreementSweepExample example);

    int updateByPrimaryKeySelective(RbAgreementSweep row);

    int updateByPrimaryKey(RbAgreementSweep row);
}