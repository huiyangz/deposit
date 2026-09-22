package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DossOperateType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAcctDoss;
import com.dcits.deposit.entity.RbAcctDossExample;
import com.dcits.deposit.facade.components.IRbAcctDossBcc;
import com.dcits.deposit.facade.eo.RbAcctDossEO;
import com.dcits.deposit.repo.RbAcctDossMapper;
import com.dcits.deposit.service.utils.RbAcctDossValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAcctDossBasisCpnt implements IRbAcctDossBcc {
    @Autowired
    RbAcctDossMapper rbAcctDossMapper;

    @Override
    public long countByEo(RbAcctDossEO eo) {
        RbAcctDossExample example = RbAcctDossValueUtil.eoToEntityExample(eo);
        return rbAcctDossMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAcctDossEO eo) {
        RbAcctDossExample example = RbAcctDossValueUtil.eoToEntityExample(eo);
        return rbAcctDossMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer internalKey, String clientNo) {
        return rbAcctDossMapper.deleteByPrimaryKey(internalKey, clientNo);
    }

    @Override
    public int create(RbAcctDossEO eo) {
        RbAcctDoss row = RbAcctDossValueUtil.eoToEntity(eo);
        return rbAcctDossMapper.insert(row);
    }

    @Override
    public int createSelective(RbAcctDossEO eo) {
        RbAcctDoss row = RbAcctDossValueUtil.eoToEntity(eo);
        return rbAcctDossMapper.insertSelective(row);
    }

    @Override
    public List<RbAcctDossEO> findByEo(RbAcctDossEO eo) {
        RbAcctDossExample example = RbAcctDossValueUtil.eoToEntityExample(eo);
        List<RbAcctDossEO> result = new ArrayList<>();
        List<RbAcctDoss> dbResult = rbAcctDossMapper.selectByExample(example);
        for (RbAcctDoss item : dbResult) {
            result.add(RbAcctDossValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAcctDossEO findByPrimaryKey(Integer internalKey, String clientNo) {
        return RbAcctDossValueUtil.entityToEo(rbAcctDossMapper.selectByPrimaryKey(internalKey, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAcctDossEO eo) {
        RbAcctDoss row = RbAcctDossValueUtil.eoToEntity(eo);
        return rbAcctDossMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAcctDossEO eo) {
        RbAcctDoss row = RbAcctDossValueUtil.eoToEntity(eo);
        return rbAcctDossMapper.updateByPrimaryKey(row);
    }
}