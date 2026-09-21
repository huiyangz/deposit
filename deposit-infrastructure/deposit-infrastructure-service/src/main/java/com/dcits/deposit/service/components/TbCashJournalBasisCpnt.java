package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.MoveType;
import com.dcits.deposit.enums.PayRecInd;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.TbCashJournal;
import com.dcits.deposit.entity.TbCashJournalExample;
import com.dcits.deposit.facade.components.ITbCashJournalBcc;
import com.dcits.deposit.facade.eo.TbCashJournalEO;
import com.dcits.deposit.repo.TbCashJournalMapper;
import com.dcits.deposit.service.utils.TbCashJournalValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TbCashJournalBasisCpnt implements ITbCashJournalBcc {
    @Autowired
    TbCashJournalMapper tbCashJournalMapper;

    @Override
    public long countByEo(TbCashJournalEO eo) {
        TbCashJournalExample example = TbCashJournalValueUtil.eoToEntityExample(eo);
        return tbCashJournalMapper.countByExample(example);
    }

    @Override
    public int removeByEo(TbCashJournalEO eo) {
        TbCashJournalExample example = TbCashJournalValueUtil.eoToEntityExample(eo);
        return tbCashJournalMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String journalId, Date tranDate) {
        return tbCashJournalMapper.deleteByPrimaryKey(journalId, tranDate);
    }

    @Override
    public int create(TbCashJournalEO eo) {
        TbCashJournal row = TbCashJournalValueUtil.eoToEntity(eo);
        return tbCashJournalMapper.insert(row);
    }

    @Override
    public int createSelective(TbCashJournalEO eo) {
        TbCashJournal row = TbCashJournalValueUtil.eoToEntity(eo);
        return tbCashJournalMapper.insertSelective(row);
    }

    @Override
    public List<TbCashJournalEO> findByEo(TbCashJournalEO eo) {
        TbCashJournalExample example = TbCashJournalValueUtil.eoToEntityExample(eo);
        List<TbCashJournalEO> result = new ArrayList<>();
        List<TbCashJournal> dbResult = tbCashJournalMapper.selectByExample(example);
        for (TbCashJournal item : dbResult) {
            result.add(TbCashJournalValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public TbCashJournalEO findByPrimaryKey(String journalId, Date tranDate) {
        return TbCashJournalValueUtil.entityToEo(tbCashJournalMapper.selectByPrimaryKey(journalId, tranDate));
    }

    @Override
    public int modifyByPrimaryKeySelective(TbCashJournalEO eo) {
        TbCashJournal row = TbCashJournalValueUtil.eoToEntity(eo);
        return tbCashJournalMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(TbCashJournalEO eo) {
        TbCashJournal row = TbCashJournalValueUtil.eoToEntity(eo);
        return tbCashJournalMapper.updateByPrimaryKey(row);
    }
}