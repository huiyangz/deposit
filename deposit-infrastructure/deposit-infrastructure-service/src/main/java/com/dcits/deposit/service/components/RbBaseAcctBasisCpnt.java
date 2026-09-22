package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctType;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBaseAcct;
import com.dcits.deposit.entity.RbBaseAcctExample;
import com.dcits.deposit.facade.components.IRbBaseAcctBcc;
import com.dcits.deposit.facade.eo.RbBaseAcctEO;
import com.dcits.deposit.repo.RbBaseAcctMapper;
import com.dcits.deposit.service.utils.RbBaseAcctValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBaseAcctBasisCpnt implements IRbBaseAcctBcc {
    @Autowired
    RbBaseAcctMapper rbBaseAcctMapper;

    @Override
    public long countByEo(RbBaseAcctEO eo) {
        RbBaseAcctExample example = RbBaseAcctValueUtil.eoToEntityExample(eo);
        return rbBaseAcctMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBaseAcctEO eo) {
        RbBaseAcctExample example = RbBaseAcctValueUtil.eoToEntityExample(eo);
        return rbBaseAcctMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String baseAcctNo, String clientNo) {
        return rbBaseAcctMapper.deleteByPrimaryKey(baseAcctNo, clientNo);
    }

    @Override
    public int create(RbBaseAcctEO eo) {
        RbBaseAcct row = RbBaseAcctValueUtil.eoToEntity(eo);
        return rbBaseAcctMapper.insert(row);
    }

    @Override
    public int createSelective(RbBaseAcctEO eo) {
        RbBaseAcct row = RbBaseAcctValueUtil.eoToEntity(eo);
        return rbBaseAcctMapper.insertSelective(row);
    }

    @Override
    public List<RbBaseAcctEO> findByEo(RbBaseAcctEO eo) {
        RbBaseAcctExample example = RbBaseAcctValueUtil.eoToEntityExample(eo);
        List<RbBaseAcctEO> result = new ArrayList<>();
        List<RbBaseAcct> dbResult = rbBaseAcctMapper.selectByExample(example);
        for (RbBaseAcct item : dbResult) {
            result.add(RbBaseAcctValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBaseAcctEO findByPrimaryKey(String baseAcctNo, String clientNo) {
        return RbBaseAcctValueUtil.entityToEo(rbBaseAcctMapper.selectByPrimaryKey(baseAcctNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBaseAcctEO eo) {
        RbBaseAcct row = RbBaseAcctValueUtil.eoToEntity(eo);
        return rbBaseAcctMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBaseAcctEO eo) {
        RbBaseAcct row = RbBaseAcctValueUtil.eoToEntity(eo);
        return rbBaseAcctMapper.updateByPrimaryKey(row);
    }
}