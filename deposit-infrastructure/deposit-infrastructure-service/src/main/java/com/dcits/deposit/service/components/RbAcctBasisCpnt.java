package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AccountingStatus;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctType;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.AutoRenewRollover;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.BusinessUnit;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.FixedCall;
import com.dcits.deposit.enums.GlType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IntIndFlag;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.OsaFlag;
import com.dcits.deposit.enums.OwnershipType;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.ReasonCode;
import com.dcits.deposit.enums.RegionFlag;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TermType;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAcct;
import com.dcits.deposit.entity.RbAcctExample;
import com.dcits.deposit.facade.components.IRbAcctBcc;
import com.dcits.deposit.facade.eo.RbAcctEO;
import com.dcits.deposit.repo.RbAcctMapper;
import com.dcits.deposit.service.utils.RbAcctValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAcctBasisCpnt implements IRbAcctBcc {
    @Autowired
    RbAcctMapper rbAcctMapper;

    @Override
    public long countByEo(RbAcctEO eo) {
        RbAcctExample example = RbAcctValueUtil.eoToEntityExample(eo);
        return rbAcctMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAcctEO eo) {
        RbAcctExample example = RbAcctValueUtil.eoToEntityExample(eo);
        return rbAcctMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer internalKey, String clientNo) {
        return rbAcctMapper.deleteByPrimaryKey(internalKey, clientNo);
    }

    @Override
    public int create(RbAcctEO eo) {
        RbAcct row = RbAcctValueUtil.eoToEntity(eo);
        return rbAcctMapper.insert(row);
    }

    @Override
    public int createSelective(RbAcctEO eo) {
        RbAcct row = RbAcctValueUtil.eoToEntity(eo);
        return rbAcctMapper.insertSelective(row);
    }

    @Override
    public List<RbAcctEO> findByEo(RbAcctEO eo) {
        RbAcctExample example = RbAcctValueUtil.eoToEntityExample(eo);
        List<RbAcctEO> result = new ArrayList<>();
        List<RbAcct> dbResult = rbAcctMapper.selectByExample(example);
        for (RbAcct item : dbResult) {
            result.add(RbAcctValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAcctEO findByPrimaryKey(Integer internalKey, String clientNo) {
        return RbAcctValueUtil.entityToEo(rbAcctMapper.selectByPrimaryKey(internalKey, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAcctEO eo) {
        RbAcct row = RbAcctValueUtil.eoToEntity(eo);
        return rbAcctMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAcctEO eo) {
        RbAcct row = RbAcctValueUtil.eoToEntity(eo);
        return rbAcctMapper.updateByPrimaryKey(row);
    }
}