package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AccountingStatus;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctTranFlag;
import com.dcits.deposit.enums.AmtCalcType;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.ApprIndicator;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.BusinessUnit;
import com.dcits.deposit.enums.CashItem;
import com.dcits.deposit.enums.CashSourceRemark;
import com.dcits.deposit.enums.CashUseRemark;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.FinType;
import com.dcits.deposit.enums.FromRateFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.MediumType;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.QuoteType;
import com.dcits.deposit.enums.RateType;
import com.dcits.deposit.enums.RemainTerm;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TellerTerminalType;
import com.dcits.deposit.enums.TranCategory;
import com.dcits.deposit.enums.TranMethod;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.WithdrawalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbTranHist;
import com.dcits.deposit.entity.RbTranHistExample;
import com.dcits.deposit.facade.components.IRbTranHistBcc;
import com.dcits.deposit.facade.eo.RbTranHistEO;
import com.dcits.deposit.repo.RbTranHistMapper;
import com.dcits.deposit.service.utils.RbTranHistValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbTranHistBasisCpnt implements IRbTranHistBcc {
    @Autowired
    RbTranHistMapper rbTranHistMapper;

    @Override
    public long countByEo(RbTranHistEO eo) {
        RbTranHistExample example = RbTranHistValueUtil.eoToEntityExample(eo);
        return rbTranHistMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbTranHistEO eo) {
        RbTranHistExample example = RbTranHistValueUtil.eoToEntityExample(eo);
        return rbTranHistMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo, String clientNo, Date tranDate) {
        return rbTranHistMapper.deleteByPrimaryKey(seqNo, clientNo, tranDate);
    }

    @Override
    public int create(RbTranHistEO eo) {
        RbTranHist row = RbTranHistValueUtil.eoToEntity(eo);
        return rbTranHistMapper.insert(row);
    }

    @Override
    public int createSelective(RbTranHistEO eo) {
        RbTranHist row = RbTranHistValueUtil.eoToEntity(eo);
        return rbTranHistMapper.insertSelective(row);
    }

    @Override
    public List<RbTranHistEO> findByEo(RbTranHistEO eo) {
        RbTranHistExample example = RbTranHistValueUtil.eoToEntityExample(eo);
        List<RbTranHistEO> result = new ArrayList<>();
        List<RbTranHist> dbResult = rbTranHistMapper.selectByExample(example);
        for (RbTranHist item : dbResult) {
            result.add(RbTranHistValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbTranHistEO findByPrimaryKey(String seqNo, String clientNo, Date tranDate) {
        return RbTranHistValueUtil.entityToEo(rbTranHistMapper.selectByPrimaryKey(seqNo, clientNo, tranDate));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbTranHistEO eo) {
        RbTranHist row = RbTranHistValueUtil.eoToEntity(eo);
        return rbTranHistMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbTranHistEO eo) {
        RbTranHist row = RbTranHistValueUtil.eoToEntity(eo);
        return rbTranHistMapper.updateByPrimaryKey(row);
    }
}