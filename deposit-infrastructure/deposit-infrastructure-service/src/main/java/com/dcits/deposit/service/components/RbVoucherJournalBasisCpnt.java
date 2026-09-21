package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.CanReasonCode;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.VoucherStatus;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbVoucherJournal;
import com.dcits.deposit.entity.RbVoucherJournalExample;
import com.dcits.deposit.facade.components.IRbVoucherJournalBcc;
import com.dcits.deposit.facade.eo.RbVoucherJournalEO;
import com.dcits.deposit.repo.RbVoucherJournalMapper;
import com.dcits.deposit.service.utils.RbVoucherJournalValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbVoucherJournalBasisCpnt implements IRbVoucherJournalBcc {
    @Autowired
    RbVoucherJournalMapper rbVoucherJournalMapper;

    @Override
    public long countByEo(RbVoucherJournalEO eo) {
        RbVoucherJournalExample example = RbVoucherJournalValueUtil.eoToEntityExample(eo);
        return rbVoucherJournalMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbVoucherJournalEO eo) {
        RbVoucherJournalExample example = RbVoucherJournalValueUtil.eoToEntityExample(eo);
        return rbVoucherJournalMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String voucherJournalId, String clientNo, Date tranDate) {
        return rbVoucherJournalMapper.deleteByPrimaryKey(voucherJournalId, clientNo, tranDate);
    }

    @Override
    public int create(RbVoucherJournalEO eo) {
        RbVoucherJournal row = RbVoucherJournalValueUtil.eoToEntity(eo);
        return rbVoucherJournalMapper.insert(row);
    }

    @Override
    public int createSelective(RbVoucherJournalEO eo) {
        RbVoucherJournal row = RbVoucherJournalValueUtil.eoToEntity(eo);
        return rbVoucherJournalMapper.insertSelective(row);
    }

    @Override
    public List<RbVoucherJournalEO> findByEo(RbVoucherJournalEO eo) {
        RbVoucherJournalExample example = RbVoucherJournalValueUtil.eoToEntityExample(eo);
        List<RbVoucherJournalEO> result = new ArrayList<>();
        List<RbVoucherJournal> dbResult = rbVoucherJournalMapper.selectByExample(example);
        for (RbVoucherJournal item : dbResult) {
            result.add(RbVoucherJournalValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbVoucherJournalEO findByPrimaryKey(String voucherJournalId, String clientNo, Date tranDate) {
        return RbVoucherJournalValueUtil.entityToEo(rbVoucherJournalMapper.selectByPrimaryKey(voucherJournalId, clientNo, tranDate));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbVoucherJournalEO eo) {
        RbVoucherJournal row = RbVoucherJournalValueUtil.eoToEntity(eo);
        return rbVoucherJournalMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbVoucherJournalEO eo) {
        RbVoucherJournal row = RbVoucherJournalValueUtil.eoToEntity(eo);
        return rbVoucherJournalMapper.updateByPrimaryKey(row);
    }
}