package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctSettleMethod;
import com.dcits.deposit.enums.AgreementSignEffectStatus;
import com.dcits.deposit.enums.GreementSignStatus;
import com.dcits.deposit.enums.SettleInd;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.YhtAcctFlag;
import com.dcits.deposit.enums.YhtAcctOrgSchema;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusAgreementYht;
import com.dcits.deposit.entity.RbBusAgreementYhtExample;
import com.dcits.deposit.facade.components.IRbBusAgreementYhtBcc;
import com.dcits.deposit.facade.eo.RbBusAgreementYhtEO;
import com.dcits.deposit.repo.RbBusAgreementYhtMapper;
import com.dcits.deposit.service.utils.RbBusAgreementYhtValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusAgreementYhtBasisCpnt implements IRbBusAgreementYhtBcc {
    @Autowired
    RbBusAgreementYhtMapper rbBusAgreementYhtMapper;

    @Override
    public long countByEo(RbBusAgreementYhtEO eo) {
        RbBusAgreementYhtExample example = RbBusAgreementYhtValueUtil.eoToEntityExample(eo);
        return rbBusAgreementYhtMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusAgreementYhtEO eo) {
        RbBusAgreementYhtExample example = RbBusAgreementYhtValueUtil.eoToEntityExample(eo);
        return rbBusAgreementYhtMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String agreementId) {
        return rbBusAgreementYhtMapper.deleteByPrimaryKey(agreementId);
    }

    @Override
    public int create(RbBusAgreementYhtEO eo) {
        RbBusAgreementYht row = RbBusAgreementYhtValueUtil.eoToEntity(eo);
        return rbBusAgreementYhtMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusAgreementYhtEO eo) {
        RbBusAgreementYht row = RbBusAgreementYhtValueUtil.eoToEntity(eo);
        return rbBusAgreementYhtMapper.insertSelective(row);
    }

    @Override
    public List<RbBusAgreementYhtEO> findByEo(RbBusAgreementYhtEO eo) {
        RbBusAgreementYhtExample example = RbBusAgreementYhtValueUtil.eoToEntityExample(eo);
        List<RbBusAgreementYhtEO> result = new ArrayList<>();
        List<RbBusAgreementYht> dbResult = rbBusAgreementYhtMapper.selectByExample(example);
        for (RbBusAgreementYht item : dbResult) {
            result.add(RbBusAgreementYhtValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusAgreementYhtEO findByPrimaryKey(String agreementId) {
        return RbBusAgreementYhtValueUtil.entityToEo(rbBusAgreementYhtMapper.selectByPrimaryKey(agreementId));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusAgreementYhtEO eo) {
        RbBusAgreementYht row = RbBusAgreementYhtValueUtil.eoToEntity(eo);
        return rbBusAgreementYhtMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusAgreementYhtEO eo) {
        RbBusAgreementYht row = RbBusAgreementYhtValueUtil.eoToEntity(eo);
        return rbBusAgreementYhtMapper.updateByPrimaryKey(row);
    }
}