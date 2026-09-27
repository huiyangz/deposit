package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.AcctRiskLevel;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctVerifyFlag;
import com.dcits.deposit.enums.AcctVerifyResult;
import com.dcits.deposit.enums.AllDepInd;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.AllDraRange;
import com.dcits.deposit.enums.AnnualStatus;
import com.dcits.deposit.enums.AutoRenewInd;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.CheckCertificateType;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.DepositNature;
import com.dcits.deposit.enums.FarmerFlag;
import com.dcits.deposit.enums.FixedCall;
import com.dcits.deposit.enums.IntIndFlag;
import com.dcits.deposit.enums.ManageType;
import com.dcits.deposit.enums.OsaFlag;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.enums.RbBusAcctPurpose;
import com.dcits.deposit.enums.RenewMethod;
import com.dcits.deposit.enums.SimpleAcct;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.SpecAcctFlag;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusAcct;
import com.dcits.deposit.entity.RbBusAcctExample;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;
import com.dcits.deposit.repo.RbBusAcctMapper;
import com.dcits.deposit.service.utils.RbBusAcctValueUtil;
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