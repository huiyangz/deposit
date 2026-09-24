package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AccountingStatus;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.AcctSetType;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctTranFlag;
import com.dcits.deposit.enums.AmtCalcType;
import com.dcits.deposit.enums.ApprIndicator;
import com.dcits.deposit.enums.AutoReversalFlag;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.CashItem;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.FromRateFlag;
import com.dcits.deposit.enums.IntCalcAmtType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.MediumFlag;
import com.dcits.deposit.enums.MediumType;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.RateType;
import com.dcits.deposit.enums.RcrRcdInd;
import com.dcits.deposit.enums.RemainTerm;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.State;
import com.dcits.deposit.enums.ToId;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranMethod;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.WithdrawalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusTranJnl;
import com.dcits.deposit.entity.RbBusTranJnlExample;
import com.dcits.deposit.facade.components.IRbBusTranJnlBcc;
import com.dcits.deposit.facade.eo.RbBusTranJnlEO;
import com.dcits.deposit.repo.RbBusTranJnlMapper;
import com.dcits.deposit.service.utils.RbBusTranJnlValueUtil;
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