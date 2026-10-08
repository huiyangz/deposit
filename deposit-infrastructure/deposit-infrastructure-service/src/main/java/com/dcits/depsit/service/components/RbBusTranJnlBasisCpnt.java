package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.AccountingStatus;
import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.AcctClass;
import com.dcits.depsit.enums.AcctSetType;
import com.dcits.depsit.enums.AcctStatus;
import com.dcits.depsit.enums.AcctTranFlag;
import com.dcits.depsit.enums.AmtCalcType;
import com.dcits.depsit.enums.ApprIndicator;
import com.dcits.depsit.enums.AutoReversalFlag;
import com.dcits.depsit.enums.BalType;
import com.dcits.depsit.enums.CashItem;
import com.dcits.depsit.enums.Ccy;
import com.dcits.depsit.enums.ClientType;
import com.dcits.depsit.enums.CrDrInd;
import com.dcits.depsit.enums.DocType;
import com.dcits.depsit.enums.FromRateFlag;
import com.dcits.depsit.enums.IntCalcAmtType;
import com.dcits.depsit.enums.IssCountry;
import com.dcits.depsit.enums.MediumFlag;
import com.dcits.depsit.enums.MediumType;
import com.dcits.depsit.enums.OthTranType;
import com.dcits.depsit.enums.ProfitCenter;
import com.dcits.depsit.enums.RateType;
import com.dcits.depsit.enums.RcrRcdInd;
import com.dcits.depsit.enums.RemainTerm;
import com.dcits.depsit.enums.SourceModule;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.State;
import com.dcits.depsit.enums.ThawDocumentType2;
import com.dcits.depsit.enums.ToId;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.enums.TranMethod;
import com.dcits.depsit.enums.TranStatus;
import com.dcits.depsit.enums.WithdrawalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbBusTranJnl;
import com.dcits.depsit.entity.RbBusTranJnlExample;
import com.dcits.depsit.facade.components.IRbBusTranJnlBcc;
import com.dcits.depsit.facade.eo.RbBusTranJnlEO;
import com.dcits.depsit.repo.RbBusTranJnlMapper;
import com.dcits.depsit.service.utils.RbBusTranJnlValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusTranJnlBasisCpnt implements IRbBusTranJnlBcc {
    @Autowired
    RbBusTranJnlMapper rbBusTranJnlMapper;

    @Override
    public long countByEo(RbBusTranJnlEO eo) {
        RbBusTranJnlExample example = RbBusTranJnlValueUtil.eoToEntityExample(eo);
        return rbBusTranJnlMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusTranJnlEO eo) {
        RbBusTranJnlExample example = RbBusTranJnlValueUtil.eoToEntityExample(eo);
        return rbBusTranJnlMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo, Date tranDate) {
        return rbBusTranJnlMapper.deleteByPrimaryKey(seqNo, tranDate);
    }

    @Override
    public int create(RbBusTranJnlEO eo) {
        RbBusTranJnl row = RbBusTranJnlValueUtil.eoToEntity(eo);
        return rbBusTranJnlMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusTranJnlEO eo) {
        RbBusTranJnl row = RbBusTranJnlValueUtil.eoToEntity(eo);
        return rbBusTranJnlMapper.insertSelective(row);
    }

    @Override
    public List<RbBusTranJnlEO> findByEo(RbBusTranJnlEO eo) {
        RbBusTranJnlExample example = RbBusTranJnlValueUtil.eoToEntityExample(eo);
        List<RbBusTranJnlEO> result = new ArrayList<>();
        List<RbBusTranJnl> dbResult = rbBusTranJnlMapper.selectByExample(example);
        for (RbBusTranJnl item : dbResult) {
            result.add(RbBusTranJnlValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusTranJnlEO findByPrimaryKey(String seqNo, Date tranDate) {
        return RbBusTranJnlValueUtil.entityToEo(rbBusTranJnlMapper.selectByPrimaryKey(seqNo, tranDate));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusTranJnlEO eo) {
        RbBusTranJnl row = RbBusTranJnlValueUtil.eoToEntity(eo);
        return rbBusTranJnlMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusTranJnlEO eo) {
        RbBusTranJnl row = RbBusTranJnlValueUtil.eoToEntity(eo);
        return rbBusTranJnlMapper.updateByPrimaryKey(row);
    }
}