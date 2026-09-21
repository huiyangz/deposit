package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CycleFreq;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IntCalcType;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.PayIntMode;
import com.dcits.deposit.enums.PrecontractStatus;
import com.dcits.deposit.enums.PrecontractType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.StageLimitClass;
import com.dcits.deposit.enums.StageProdClass;
import com.dcits.deposit.enums.WithdrawalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbDcPrecontract;
import com.dcits.deposit.entity.RbDcPrecontractExample;
import com.dcits.deposit.facade.components.IRbDcPrecontractBcc;
import com.dcits.deposit.facade.eo.RbDcPrecontractEO;
import com.dcits.deposit.repo.RbDcPrecontractMapper;
import com.dcits.deposit.service.utils.RbDcPrecontractValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbDcPrecontractBasisCpnt implements IRbDcPrecontractBcc {
    @Autowired
    RbDcPrecontractMapper rbDcPrecontractMapper;

    @Override
    public long countByEo(RbDcPrecontractEO eo) {
        RbDcPrecontractExample example = RbDcPrecontractValueUtil.eoToEntityExample(eo);
        return rbDcPrecontractMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbDcPrecontractEO eo) {
        RbDcPrecontractExample example = RbDcPrecontractValueUtil.eoToEntityExample(eo);
        return rbDcPrecontractMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String precontractNo, String clientNo) {
        return rbDcPrecontractMapper.deleteByPrimaryKey(precontractNo, clientNo);
    }

    @Override
    public int create(RbDcPrecontractEO eo) {
        RbDcPrecontract row = RbDcPrecontractValueUtil.eoToEntity(eo);
        return rbDcPrecontractMapper.insert(row);
    }

    @Override
    public int createSelective(RbDcPrecontractEO eo) {
        RbDcPrecontract row = RbDcPrecontractValueUtil.eoToEntity(eo);
        return rbDcPrecontractMapper.insertSelective(row);
    }

    @Override
    public List<RbDcPrecontractEO> findByEo(RbDcPrecontractEO eo) {
        RbDcPrecontractExample example = RbDcPrecontractValueUtil.eoToEntityExample(eo);
        List<RbDcPrecontractEO> result = new ArrayList<>();
        List<RbDcPrecontract> dbResult = rbDcPrecontractMapper.selectByExample(example);
        for (RbDcPrecontract item : dbResult) {
            result.add(RbDcPrecontractValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbDcPrecontractEO findByPrimaryKey(String precontractNo, String clientNo) {
        return RbDcPrecontractValueUtil.entityToEo(rbDcPrecontractMapper.selectByPrimaryKey(precontractNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbDcPrecontractEO eo) {
        RbDcPrecontract row = RbDcPrecontractValueUtil.eoToEntity(eo);
        return rbDcPrecontractMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbDcPrecontractEO eo) {
        RbDcPrecontract row = RbDcPrecontractValueUtil.eoToEntity(eo);
        return rbDcPrecontractMapper.updateByPrimaryKey(row);
    }
}