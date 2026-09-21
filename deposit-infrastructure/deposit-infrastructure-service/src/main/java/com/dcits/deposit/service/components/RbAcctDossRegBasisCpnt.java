package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DossOperateType;
import com.dcits.deposit.enums.DossStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.ToAcctType;
import com.dcits.deposit.enums.ToBankInd;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAcctDossReg;
import com.dcits.deposit.entity.RbAcctDossRegExample;
import com.dcits.deposit.facade.components.IRbAcctDossRegBcc;
import com.dcits.deposit.facade.eo.RbAcctDossRegEO;
import com.dcits.deposit.repo.RbAcctDossRegMapper;
import com.dcits.deposit.service.utils.RbAcctDossRegValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAcctDossRegBasisCpnt implements IRbAcctDossRegBcc {
    @Autowired
    RbAcctDossRegMapper rbAcctDossRegMapper;

    @Override
    public long countByEo(RbAcctDossRegEO eo) {
        RbAcctDossRegExample example = RbAcctDossRegValueUtil.eoToEntityExample(eo);
        return rbAcctDossRegMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAcctDossRegEO eo) {
        RbAcctDossRegExample example = RbAcctDossRegValueUtil.eoToEntityExample(eo);
        return rbAcctDossRegMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer internalKey, String clientNo) {
        return rbAcctDossRegMapper.deleteByPrimaryKey(internalKey, clientNo);
    }

    @Override
    public int create(RbAcctDossRegEO eo) {
        RbAcctDossReg row = RbAcctDossRegValueUtil.eoToEntity(eo);
        return rbAcctDossRegMapper.insert(row);
    }

    @Override
    public int createSelective(RbAcctDossRegEO eo) {
        RbAcctDossReg row = RbAcctDossRegValueUtil.eoToEntity(eo);
        return rbAcctDossRegMapper.insertSelective(row);
    }

    @Override
    public List<RbAcctDossRegEO> findByEo(RbAcctDossRegEO eo) {
        RbAcctDossRegExample example = RbAcctDossRegValueUtil.eoToEntityExample(eo);
        List<RbAcctDossRegEO> result = new ArrayList<>();
        List<RbAcctDossReg> dbResult = rbAcctDossRegMapper.selectByExample(example);
        for (RbAcctDossReg item : dbResult) {
            result.add(RbAcctDossRegValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAcctDossRegEO findByPrimaryKey(Integer internalKey, String clientNo) {
        return RbAcctDossRegValueUtil.entityToEo(rbAcctDossRegMapper.selectByPrimaryKey(internalKey, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAcctDossRegEO eo) {
        RbAcctDossReg row = RbAcctDossRegValueUtil.eoToEntity(eo);
        return rbAcctDossRegMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAcctDossRegEO eo) {
        RbAcctDossReg row = RbAcctDossRegValueUtil.eoToEntity(eo);
        return rbAcctDossRegMapper.updateByPrimaryKey(row);
    }
}