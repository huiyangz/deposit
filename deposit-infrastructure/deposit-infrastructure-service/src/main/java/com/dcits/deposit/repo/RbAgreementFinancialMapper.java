package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAgreementFinancial;
import com.dcits.deposit.entity.RbAgreementFinancialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAgreementFinancialMapper {
    long countByExample(RbAgreementFinancialExample example);

    int deleteByExample(RbAgreementFinancialExample example);

    int deleteByPrimaryKey(@Param("agreementId") String agreementId, @Param("clientNo") String clientNo);

    int insert(RbAgreementFinancial row);

    int insertSelective(RbAgreementFinancial row);

    List<RbAgreementFinancial> selectByExample(RbAgreementFinancialExample example);

    RbAgreementFinancial selectByPrimaryKey(@Param("agreementId") String agreementId, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbAgreementFinancial row, @Param("example") RbAgreementFinancialExample example);

    int updateByExample(@Param("row") RbAgreementFinancial row, @Param("example") RbAgreementFinancialExample example);

    int updateByPrimaryKeySelective(RbAgreementFinancial row);

    int updateByPrimaryKey(RbAgreementFinancial row);
}