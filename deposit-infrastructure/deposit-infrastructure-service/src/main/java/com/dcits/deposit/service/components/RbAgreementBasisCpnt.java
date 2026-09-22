package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AgreementClass;
import com.dcits.deposit.enums.AgreementStatus;
import com.dcits.deposit.enums.AgreementType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAgreement;
import com.dcits.deposit.entity.RbAgreementExample;
import com.dcits.deposit.facade.components.IRbAgreementBcc;
import com.dcits.deposit.facade.eo.RbAgreementEO;
import com.dcits.deposit.repo.RbAgreementMapper;
import com.dcits.deposit.service.utils.RbAgreementValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAgreementBasisCpnt implements IRbAgreementBcc {
    @Autowired
    RbAgreementMapper rbAgreementMapper;

    @Override
    public long countByEo(RbAgreementEO eo) {
        RbAgreementExample example = RbAgreementValueUtil.eoToEntityExample(eo);
        return rbAgreementMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAgreementEO eo) {
        RbAgreementExample example = RbAgreementValueUtil.eoToEntityExample(eo);
        return rbAgreementMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String agreementId, String clientNo) {
        return rbAgreementMapper.deleteByPrimaryKey(agreementId, clientNo);
    }

    @Override
    public int create(RbAgreementEO eo) {
        RbAgreement row = RbAgreementValueUtil.eoToEntity(eo);
        return rbAgreementMapper.insert(row);
    }

    @Override
    public int createSelective(RbAgreementEO eo) {
        RbAgreement row = RbAgreementValueUtil.eoToEntity(eo);
        return rbAgreementMapper.insertSelective(row);
    }

    @Override
    public List<RbAgreementEO> findByEo(RbAgreementEO eo) {
        RbAgreementExample example = RbAgreementValueUtil.eoToEntityExample(eo);
        List<RbAgreementEO> result = new ArrayList<>();
        List<RbAgreement> dbResult = rbAgreementMapper.selectByExample(example);
        for (RbAgreement item : dbResult) {
            result.add(RbAgreementValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAgreementEO findByPrimaryKey(String agreementId, String clientNo) {
        return RbAgreementValueUtil.entityToEo(rbAgreementMapper.selectByPrimaryKey(agreementId, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAgreementEO eo) {
        RbAgreement row = RbAgreementValueUtil.eoToEntity(eo);
        return rbAgreementMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAgreementEO eo) {
        RbAgreement row = RbAgreementValueUtil.eoToEntity(eo);
        return rbAgreementMapper.updateByPrimaryKey(row);
    }
}