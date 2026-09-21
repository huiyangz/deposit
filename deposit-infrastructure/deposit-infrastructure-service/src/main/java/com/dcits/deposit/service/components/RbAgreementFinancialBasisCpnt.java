package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AgreementStatus;
import com.dcits.deposit.enums.AgreementType;
import com.dcits.deposit.enums.AmortizeTimeType;
import com.dcits.deposit.enums.AutoRenewRollover;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DepositNature;
import com.dcits.deposit.enums.FeeType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.OdMode;
import com.dcits.deposit.enums.TermType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAgreementFinancial;
import com.dcits.deposit.entity.RbAgreementFinancialExample;
import com.dcits.deposit.facade.components.IRbAgreementFinancialBcc;
import com.dcits.deposit.facade.eo.RbAgreementFinancialEO;
import com.dcits.deposit.repo.RbAgreementFinancialMapper;
import com.dcits.deposit.service.utils.RbAgreementFinancialValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAgreementFinancialBasisCpnt implements IRbAgreementFinancialBcc {
    @Autowired
    RbAgreementFinancialMapper rbAgreementFinancialMapper;

    @Override
    public long countByEo(RbAgreementFinancialEO eo) {
        RbAgreementFinancialExample example = RbAgreementFinancialValueUtil.eoToEntityExample(eo);
        return rbAgreementFinancialMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAgreementFinancialEO eo) {
        RbAgreementFinancialExample example = RbAgreementFinancialValueUtil.eoToEntityExample(eo);
        return rbAgreementFinancialMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String agreementId, String clientNo) {
        return rbAgreementFinancialMapper.deleteByPrimaryKey(agreementId, clientNo);
    }

    @Override
    public int create(RbAgreementFinancialEO eo) {
        RbAgreementFinancial row = RbAgreementFinancialValueUtil.eoToEntity(eo);
        return rbAgreementFinancialMapper.insert(row);
    }

    @Override
    public int createSelective(RbAgreementFinancialEO eo) {
        RbAgreementFinancial row = RbAgreementFinancialValueUtil.eoToEntity(eo);
        return rbAgreementFinancialMapper.insertSelective(row);
    }

    @Override
    public List<RbAgreementFinancialEO> findByEo(RbAgreementFinancialEO eo) {
        RbAgreementFinancialExample example = RbAgreementFinancialValueUtil.eoToEntityExample(eo);
        List<RbAgreementFinancialEO> result = new ArrayList<>();
        List<RbAgreementFinancial> dbResult = rbAgreementFinancialMapper.selectByExample(example);
        for (RbAgreementFinancial item : dbResult) {
            result.add(RbAgreementFinancialValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAgreementFinancialEO findByPrimaryKey(String agreementId, String clientNo) {
        return RbAgreementFinancialValueUtil.entityToEo(rbAgreementFinancialMapper.selectByPrimaryKey(agreementId, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAgreementFinancialEO eo) {
        RbAgreementFinancial row = RbAgreementFinancialValueUtil.eoToEntity(eo);
        return rbAgreementFinancialMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAgreementFinancialEO eo) {
        RbAgreementFinancial row = RbAgreementFinancialValueUtil.eoToEntity(eo);
        return rbAgreementFinancialMapper.updateByPrimaryKey(row);
    }
}