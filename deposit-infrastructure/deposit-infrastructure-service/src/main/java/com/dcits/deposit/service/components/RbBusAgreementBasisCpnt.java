package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AgreementClass;
import com.dcits.deposit.enums.AgreementSignEffectStatus;
import com.dcits.deposit.enums.GreementSignStatus;
import com.dcits.deposit.enums.RbBusAgreementType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusAgreement;
import com.dcits.deposit.entity.RbBusAgreementExample;
import com.dcits.deposit.facade.components.IRbBusAgreementBcc;
import com.dcits.deposit.facade.eo.RbBusAgreementEO;
import com.dcits.deposit.repo.RbBusAgreementMapper;
import com.dcits.deposit.service.utils.RbBusAgreementValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusAgreementBasisCpnt implements IRbBusAgreementBcc {
    @Autowired
    RbBusAgreementMapper rbBusAgreementMapper;

    @Override
    public long countByEo(RbBusAgreementEO eo) {
        RbBusAgreementExample example = RbBusAgreementValueUtil.eoToEntityExample(eo);
        return rbBusAgreementMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusAgreementEO eo) {
        RbBusAgreementExample example = RbBusAgreementValueUtil.eoToEntityExample(eo);
        return rbBusAgreementMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String agreementId) {
        return rbBusAgreementMapper.deleteByPrimaryKey(agreementId);
    }

    @Override
    public int create(RbBusAgreementEO eo) {
        RbBusAgreement row = RbBusAgreementValueUtil.eoToEntity(eo);
        return rbBusAgreementMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusAgreementEO eo) {
        RbBusAgreement row = RbBusAgreementValueUtil.eoToEntity(eo);
        return rbBusAgreementMapper.insertSelective(row);
    }

    @Override
    public List<RbBusAgreementEO> findByEo(RbBusAgreementEO eo) {
        RbBusAgreementExample example = RbBusAgreementValueUtil.eoToEntityExample(eo);
        List<RbBusAgreementEO> result = new ArrayList<>();
        List<RbBusAgreement> dbResult = rbBusAgreementMapper.selectByExample(example);
        for (RbBusAgreement item : dbResult) {
            result.add(RbBusAgreementValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusAgreementEO findByPrimaryKey(String agreementId) {
        return RbBusAgreementValueUtil.entityToEo(rbBusAgreementMapper.selectByPrimaryKey(agreementId));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusAgreementEO eo) {
        RbBusAgreement row = RbBusAgreementValueUtil.eoToEntity(eo);
        return rbBusAgreementMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusAgreementEO eo) {
        RbBusAgreement row = RbBusAgreementValueUtil.eoToEntity(eo);
        return rbBusAgreementMapper.updateByPrimaryKey(row);
    }
}