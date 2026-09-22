package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AgreementStatus;
import com.dcits.deposit.enums.AgreementType;
import com.dcits.deposit.enums.AutoRenewRollover;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.OpenNumType;
import com.dcits.deposit.enums.OthAcctSort;
import com.dcits.deposit.enums.ReasonCode;
import com.dcits.deposit.enums.RenewAcctType;
import com.dcits.deposit.enums.RenewType;
import com.dcits.deposit.enums.TermType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAgreementSweep;
import com.dcits.deposit.entity.RbAgreementSweepExample;
import com.dcits.deposit.facade.components.IRbAgreementSweepBcc;
import com.dcits.deposit.facade.eo.RbAgreementSweepEO;
import com.dcits.deposit.repo.RbAgreementSweepMapper;
import com.dcits.deposit.service.utils.RbAgreementSweepValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAgreementSweepBasisCpnt implements IRbAgreementSweepBcc {
    @Autowired
    RbAgreementSweepMapper rbAgreementSweepMapper;

    @Override
    public long countByEo(RbAgreementSweepEO eo) {
        RbAgreementSweepExample example = RbAgreementSweepValueUtil.eoToEntityExample(eo);
        return rbAgreementSweepMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAgreementSweepEO eo) {
        RbAgreementSweepExample example = RbAgreementSweepValueUtil.eoToEntityExample(eo);
        return rbAgreementSweepMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String agreementId, String clientNo) {
        return rbAgreementSweepMapper.deleteByPrimaryKey(agreementId, clientNo);
    }

    @Override
    public int create(RbAgreementSweepEO eo) {
        RbAgreementSweep row = RbAgreementSweepValueUtil.eoToEntity(eo);
        return rbAgreementSweepMapper.insert(row);
    }

    @Override
    public int createSelective(RbAgreementSweepEO eo) {
        RbAgreementSweep row = RbAgreementSweepValueUtil.eoToEntity(eo);
        return rbAgreementSweepMapper.insertSelective(row);
    }

    @Override
    public List<RbAgreementSweepEO> findByEo(RbAgreementSweepEO eo) {
        RbAgreementSweepExample example = RbAgreementSweepValueUtil.eoToEntityExample(eo);
        List<RbAgreementSweepEO> result = new ArrayList<>();
        List<RbAgreementSweep> dbResult = rbAgreementSweepMapper.selectByExample(example);
        for (RbAgreementSweep item : dbResult) {
            result.add(RbAgreementSweepValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAgreementSweepEO findByPrimaryKey(String agreementId, String clientNo) {
        return RbAgreementSweepValueUtil.entityToEo(rbAgreementSweepMapper.selectByPrimaryKey(agreementId, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAgreementSweepEO eo) {
        RbAgreementSweep row = RbAgreementSweepValueUtil.eoToEntity(eo);
        return rbAgreementSweepMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAgreementSweepEO eo) {
        RbAgreementSweep row = RbAgreementSweepValueUtil.eoToEntity(eo);
        return rbAgreementSweepMapper.updateByPrimaryKey(row);
    }
}