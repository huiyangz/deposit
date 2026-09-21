package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.AcctOpenMode;
import com.dcits.deposit.enums.AcctOpenType;
import com.dcits.deposit.enums.AcctProperty2;
import com.dcits.deposit.enums.AcctRiskLevel;
import com.dcits.deposit.enums.AcctTellerSignFlag;
import com.dcits.deposit.enums.AcctVerifyResult;
import com.dcits.deposit.enums.AgreementDepositType;
import com.dcits.deposit.enums.AmountNature;
import com.dcits.deposit.enums.AnnualStatus;
import com.dcits.deposit.enums.BalanceWay;
import com.dcits.deposit.enums.BalUpdType;
import com.dcits.deposit.enums.BlacklistStatus;
import com.dcits.deposit.enums.CaseInvolvedFlag;
import com.dcits.deposit.enums.CheckCertificateType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DepositNature;
import com.dcits.deposit.enums.FarmerFlag;
import com.dcits.deposit.enums.HangWriteOffFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.LoanFundFlag;
import com.dcits.deposit.enums.ManageType;
import com.dcits.deposit.enums.MsgStatus;
import com.dcits.deposit.enums.ProdClass;
import com.dcits.deposit.enums.SimpleAcct;
import com.dcits.deposit.enums.SpecialProdClass;
import com.dcits.deposit.enums.StageLimitClass;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.Treatment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAcctAttach;
import com.dcits.deposit.entity.RbAcctAttachExample;
import com.dcits.deposit.facade.components.IRbAcctAttachBcc;
import com.dcits.deposit.facade.eo.RbAcctAttachEO;
import com.dcits.deposit.repo.RbAcctAttachMapper;
import com.dcits.deposit.service.utils.RbAcctAttachValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAcctAttachBasisCpnt implements IRbAcctAttachBcc {
    @Autowired
    RbAcctAttachMapper rbAcctAttachMapper;

    @Override
    public long countByEo(RbAcctAttachEO eo) {
        RbAcctAttachExample example = RbAcctAttachValueUtil.eoToEntityExample(eo);
        return rbAcctAttachMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAcctAttachEO eo) {
        RbAcctAttachExample example = RbAcctAttachValueUtil.eoToEntityExample(eo);
        return rbAcctAttachMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer internalKey, String clientNo) {
        return rbAcctAttachMapper.deleteByPrimaryKey(internalKey, clientNo);
    }

    @Override
    public int create(RbAcctAttachEO eo) {
        RbAcctAttach row = RbAcctAttachValueUtil.eoToEntity(eo);
        return rbAcctAttachMapper.insert(row);
    }

    @Override
    public int createSelective(RbAcctAttachEO eo) {
        RbAcctAttach row = RbAcctAttachValueUtil.eoToEntity(eo);
        return rbAcctAttachMapper.insertSelective(row);
    }

    @Override
    public List<RbAcctAttachEO> findByEo(RbAcctAttachEO eo) {
        RbAcctAttachExample example = RbAcctAttachValueUtil.eoToEntityExample(eo);
        List<RbAcctAttachEO> result = new ArrayList<>();
        List<RbAcctAttach> dbResult = rbAcctAttachMapper.selectByExample(example);
        for (RbAcctAttach item : dbResult) {
            result.add(RbAcctAttachValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAcctAttachEO findByPrimaryKey(Integer internalKey, String clientNo) {
        return RbAcctAttachValueUtil.entityToEo(rbAcctAttachMapper.selectByPrimaryKey(internalKey, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAcctAttachEO eo) {
        RbAcctAttach row = RbAcctAttachValueUtil.eoToEntity(eo);
        return rbAcctAttachMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAcctAttachEO eo) {
        RbAcctAttach row = RbAcctAttachValueUtil.eoToEntity(eo);
        return rbAcctAttachMapper.updateByPrimaryKey(row);
    }
}