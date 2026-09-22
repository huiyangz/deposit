package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasis;
import com.dcits.deposit.enums.MovtStatus;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.TaxType;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.YearBasis;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAcctEventRegister;
import com.dcits.deposit.entity.RbAcctEventRegisterExample;
import com.dcits.deposit.facade.components.IRbAcctEventRegisterBcc;
import com.dcits.deposit.facade.eo.RbAcctEventRegisterEO;
import com.dcits.deposit.repo.RbAcctEventRegisterMapper;
import com.dcits.deposit.service.utils.RbAcctEventRegisterValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAcctEventRegisterBasisCpnt implements IRbAcctEventRegisterBcc {
    @Autowired
    RbAcctEventRegisterMapper rbAcctEventRegisterMapper;

    @Override
    public long countByEo(RbAcctEventRegisterEO eo) {
        RbAcctEventRegisterExample example = RbAcctEventRegisterValueUtil.eoToEntityExample(eo);
        return rbAcctEventRegisterMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAcctEventRegisterEO eo) {
        RbAcctEventRegisterExample example = RbAcctEventRegisterValueUtil.eoToEntityExample(eo);
        return rbAcctEventRegisterMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo, Date tranDate, Integer internalKey, String clientNo, String intClass) {
        return rbAcctEventRegisterMapper.deleteByPrimaryKey(seqNo, tranDate, internalKey, clientNo, intClass);
    }

    @Override
    public int create(RbAcctEventRegisterEO eo) {
        RbAcctEventRegister row = RbAcctEventRegisterValueUtil.eoToEntity(eo);
        return rbAcctEventRegisterMapper.insert(row);
    }

    @Override
    public int createSelective(RbAcctEventRegisterEO eo) {
        RbAcctEventRegister row = RbAcctEventRegisterValueUtil.eoToEntity(eo);
        return rbAcctEventRegisterMapper.insertSelective(row);
    }

    @Override
    public List<RbAcctEventRegisterEO> findByEo(RbAcctEventRegisterEO eo) {
        RbAcctEventRegisterExample example = RbAcctEventRegisterValueUtil.eoToEntityExample(eo);
        List<RbAcctEventRegisterEO> result = new ArrayList<>();
        List<RbAcctEventRegister> dbResult = rbAcctEventRegisterMapper.selectByExample(example);
        for (RbAcctEventRegister item : dbResult) {
            result.add(RbAcctEventRegisterValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAcctEventRegisterEO findByPrimaryKey(String seqNo, Date tranDate, Integer internalKey, String clientNo, String intClass) {
        return RbAcctEventRegisterValueUtil.entityToEo(rbAcctEventRegisterMapper.selectByPrimaryKey(seqNo, tranDate, internalKey, clientNo, intClass));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAcctEventRegisterEO eo) {
        RbAcctEventRegister row = RbAcctEventRegisterValueUtil.eoToEntity(eo);
        return rbAcctEventRegisterMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAcctEventRegisterEO eo) {
        RbAcctEventRegister row = RbAcctEventRegisterValueUtil.eoToEntity(eo);
        return rbAcctEventRegisterMapper.updateByPrimaryKey(row);
    }
}