package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctSettleMethod;
import com.dcits.deposit.enums.AgreementStatus;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SettleInd;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.YhtAcctFlag;
import com.dcits.deposit.enums.YhtAcctOrgSchema;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAgreementYht;
import com.dcits.deposit.entity.RbAgreementYhtExample;
import com.dcits.deposit.facade.components.IRbAgreementYhtBcc;
import com.dcits.deposit.facade.eo.RbAgreementYhtEO;
import com.dcits.deposit.repo.RbAgreementYhtMapper;
import com.dcits.deposit.service.utils.RbAgreementYhtValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAgreementYhtBasisCpnt implements IRbAgreementYhtBcc {
    @Autowired
    RbAgreementYhtMapper rbAgreementYhtMapper;

    @Override
    public long countByEo(RbAgreementYhtEO eo) {
        RbAgreementYhtExample example = RbAgreementYhtValueUtil.eoToEntityExample(eo);
        return rbAgreementYhtMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAgreementYhtEO eo) {
        RbAgreementYhtExample example = RbAgreementYhtValueUtil.eoToEntityExample(eo);
        return rbAgreementYhtMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String agreementId, String clientNo) {
        return rbAgreementYhtMapper.deleteByPrimaryKey(agreementId, clientNo);
    }

    @Override
    public int create(RbAgreementYhtEO eo) {
        RbAgreementYht row = RbAgreementYhtValueUtil.eoToEntity(eo);
        return rbAgreementYhtMapper.insert(row);
    }

    @Override
    public int createSelective(RbAgreementYhtEO eo) {
        RbAgreementYht row = RbAgreementYhtValueUtil.eoToEntity(eo);
        return rbAgreementYhtMapper.insertSelective(row);
    }

    @Override
    public List<RbAgreementYhtEO> findByEo(RbAgreementYhtEO eo) {
        RbAgreementYhtExample example = RbAgreementYhtValueUtil.eoToEntityExample(eo);
        List<RbAgreementYhtEO> result = new ArrayList<>();
        List<RbAgreementYht> dbResult = rbAgreementYhtMapper.selectByExample(example);
        for (RbAgreementYht item : dbResult) {
            result.add(RbAgreementYhtValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAgreementYhtEO findByPrimaryKey(String agreementId, String clientNo) {
        return RbAgreementYhtValueUtil.entityToEo(rbAgreementYhtMapper.selectByPrimaryKey(agreementId, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAgreementYhtEO eo) {
        RbAgreementYht row = RbAgreementYhtValueUtil.eoToEntity(eo);
        return rbAgreementYhtMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAgreementYhtEO eo) {
        RbAgreementYht row = RbAgreementYhtValueUtil.eoToEntity(eo);
        return rbAgreementYhtMapper.updateByPrimaryKey(row);
    }
}