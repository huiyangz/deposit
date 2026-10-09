package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.AgreementSignEffectStatus;
import com.dcits.depsit.enums.AmortizeTimeType;
import com.dcits.depsit.enums.Ccy;
import com.dcits.depsit.enums.FeeTakenMode;
import com.dcits.depsit.enums.FeeType;
import com.dcits.depsit.enums.GreementSignStatus;
import com.dcits.depsit.enums.IsOverMonthSeasonOd;
import com.dcits.depsit.enums.OdMaturityRule;
import com.dcits.depsit.enums.OdMethod;
import com.dcits.depsit.enums.OdMode;
import com.dcits.depsit.enums.OdPayMethod;
import com.dcits.depsit.enums.RbBusAgreementType;
import com.dcits.depsit.enums.RollFreq;
import com.dcits.depsit.enums.TermType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbBusAgreementOverdraft;
import com.dcits.depsit.entity.RbBusAgreementOverdraftExample;
import com.dcits.depsit.facade.components.IRbBusAgreementOverdraftBcc;
import com.dcits.depsit.facade.eo.RbBusAgreementOverdraftEO;
import com.dcits.depsit.repo.RbBusAgreementOverdraftMapper;
import com.dcits.depsit.service.utils.RbBusAgreementOverdraftValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusAgreementOverdraftBasisCpnt implements IRbBusAgreementOverdraftBcc {
    @Autowired
    RbBusAgreementOverdraftMapper rbBusAgreementOverdraftMapper;

    @Override
    public long countByEo(RbBusAgreementOverdraftEO eo) {
        RbBusAgreementOverdraftExample example = RbBusAgreementOverdraftValueUtil.eoToEntityExample(eo);
        return rbBusAgreementOverdraftMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusAgreementOverdraftEO eo) {
        RbBusAgreementOverdraftExample example = RbBusAgreementOverdraftValueUtil.eoToEntityExample(eo);
        return rbBusAgreementOverdraftMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String agreementId) {
        return rbBusAgreementOverdraftMapper.deleteByPrimaryKey(agreementId);
    }

    @Override
    public int create(RbBusAgreementOverdraftEO eo) {
        RbBusAgreementOverdraft row = RbBusAgreementOverdraftValueUtil.eoToEntity(eo);
        return rbBusAgreementOverdraftMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusAgreementOverdraftEO eo) {
        RbBusAgreementOverdraft row = RbBusAgreementOverdraftValueUtil.eoToEntity(eo);
        return rbBusAgreementOverdraftMapper.insertSelective(row);
    }

    @Override
    public List<RbBusAgreementOverdraftEO> findByEo(RbBusAgreementOverdraftEO eo) {
        RbBusAgreementOverdraftExample example = RbBusAgreementOverdraftValueUtil.eoToEntityExample(eo);
        List<RbBusAgreementOverdraftEO> result = new ArrayList<>();
        List<RbBusAgreementOverdraft> dbResult = rbBusAgreementOverdraftMapper.selectByExample(example);
        for (RbBusAgreementOverdraft item : dbResult) {
            result.add(RbBusAgreementOverdraftValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusAgreementOverdraftEO findByPrimaryKey(String agreementId) {
        return RbBusAgreementOverdraftValueUtil.entityToEo(rbBusAgreementOverdraftMapper.selectByPrimaryKey(agreementId));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusAgreementOverdraftEO eo) {
        RbBusAgreementOverdraft row = RbBusAgreementOverdraftValueUtil.eoToEntity(eo);
        return rbBusAgreementOverdraftMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusAgreementOverdraftEO eo) {
        RbBusAgreementOverdraft row = RbBusAgreementOverdraftValueUtil.eoToEntity(eo);
        return rbBusAgreementOverdraftMapper.updateByPrimaryKey(row);
    }
}