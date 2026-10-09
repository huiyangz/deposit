package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.enums.AcctRiskLevel;
import com.dcits.depsit.enums.AcctStatus;
import com.dcits.depsit.enums.AcctVerifyFlag;
import com.dcits.depsit.enums.AcctVerifyResult;
import com.dcits.depsit.enums.AllDepInd;
import com.dcits.depsit.enums.AllDraInd;
import com.dcits.depsit.enums.AllDraRange;
import com.dcits.depsit.enums.AnnualStatus;
import com.dcits.depsit.enums.AutoRenewInd;
import com.dcits.depsit.enums.BalType;
import com.dcits.depsit.enums.CheckCertificateType;
import com.dcits.depsit.enums.ClientType;
import com.dcits.depsit.enums.DepositNature;
import com.dcits.depsit.enums.FarmerFlag;
import com.dcits.depsit.enums.FixedCall;
import com.dcits.depsit.enums.IntIndFlag;
import com.dcits.depsit.enums.ManageType;
import com.dcits.depsit.enums.OsaFlag;
import com.dcits.depsit.enums.RbAcctType;
import com.dcits.depsit.enums.RbBusAcctPurpose;
import com.dcits.depsit.enums.RenewMethod;
import com.dcits.depsit.enums.SimpleAcct;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.SpecAcctFlag;
import com.dcits.depsit.enums.TermType;
import com.dcits.depsit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbBusAcct;
import com.dcits.depsit.entity.RbBusAcctExample;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.eo.RbBusAcctEO;
import com.dcits.depsit.repo.RbBusAcctMapper;
import com.dcits.depsit.service.utils.RbBusAcctValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusAcctBasisCpnt implements IRbBusAcctBcc {
    @Autowired
    RbBusAcctMapper rbBusAcctMapper;

    @Override
    public long countByEo(RbBusAcctEO eo) {
        RbBusAcctExample example = RbBusAcctValueUtil.eoToEntityExample(eo);
        return rbBusAcctMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusAcctEO eo) {
        RbBusAcctExample example = RbBusAcctValueUtil.eoToEntityExample(eo);
        return rbBusAcctMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer internalKey) {
        return rbBusAcctMapper.deleteByPrimaryKey(internalKey);
    }

    @Override
    public int create(RbBusAcctEO eo) {
        RbBusAcct row = RbBusAcctValueUtil.eoToEntity(eo);
        return rbBusAcctMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusAcctEO eo) {
        RbBusAcct row = RbBusAcctValueUtil.eoToEntity(eo);
        return rbBusAcctMapper.insertSelective(row);
    }

    @Override
    public List<RbBusAcctEO> findByEo(RbBusAcctEO eo) {
        RbBusAcctExample example = RbBusAcctValueUtil.eoToEntityExample(eo);
        List<RbBusAcctEO> result = new ArrayList<>();
        List<RbBusAcct> dbResult = rbBusAcctMapper.selectByExample(example);
        for (RbBusAcct item : dbResult) {
            result.add(RbBusAcctValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusAcctEO findByPrimaryKey(Integer internalKey) {
        return RbBusAcctValueUtil.entityToEo(rbBusAcctMapper.selectByPrimaryKey(internalKey));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusAcctEO eo) {
        RbBusAcct row = RbBusAcctValueUtil.eoToEntity(eo);
        return rbBusAcctMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusAcctEO eo) {
        RbBusAcct row = RbBusAcctValueUtil.eoToEntity(eo);
        return rbBusAcctMapper.updateByPrimaryKey(row);
    }
}