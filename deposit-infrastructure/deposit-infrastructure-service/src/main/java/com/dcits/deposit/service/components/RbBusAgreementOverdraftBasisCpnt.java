package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AgreementSignEffectStatus;
import com.dcits.deposit.enums.AmortizeTimeType;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.FeeTakenMode;
import com.dcits.deposit.enums.FeeType;
import com.dcits.deposit.enums.GreementSignStatus;
import com.dcits.deposit.enums.IsOverMonthSeasonOd;
import com.dcits.deposit.enums.OdMaturityRule;
import com.dcits.deposit.enums.OdMethod;
import com.dcits.deposit.enums.OdMode;
import com.dcits.deposit.enums.OdPayMethod;
import com.dcits.deposit.enums.RbBusAgreementType;
import com.dcits.deposit.enums.RollFreq;
import com.dcits.deposit.enums.TermType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusAgreementOverdraft;
import com.dcits.deposit.entity.RbBusAgreementOverdraftExample;
import com.dcits.deposit.facade.components.IRbBusAgreementOverdraftBcc;
import com.dcits.deposit.facade.eo.RbBusAgreementOverdraftEO;
import com.dcits.deposit.repo.RbBusAgreementOverdraftMapper;
import com.dcits.deposit.service.utils.RbBusAgreementOverdraftValueUtil;
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