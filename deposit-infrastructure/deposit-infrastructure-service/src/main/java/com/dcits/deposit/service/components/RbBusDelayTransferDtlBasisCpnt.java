package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.ArrivalStatus;
import com.dcits.deposit.enums.BankInOut;
import com.dcits.deposit.enums.CashItem;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranMethod;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusDelayTransferDtl;
import com.dcits.deposit.entity.RbBusDelayTransferDtlExample;
import com.dcits.deposit.facade.components.IRbBusDelayTransferDtlBcc;
import com.dcits.deposit.facade.eo.RbBusDelayTransferDtlEO;
import com.dcits.deposit.repo.RbBusDelayTransferDtlMapper;
import com.dcits.deposit.service.utils.RbBusDelayTransferDtlValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusDelayTransferDtlBasisCpnt implements IRbBusDelayTransferDtlBcc {
    @Autowired
    RbBusDelayTransferDtlMapper rbBusDelayTransferDtlMapper;

    @Override
    public long countByEo(RbBusDelayTransferDtlEO eo) {
        RbBusDelayTransferDtlExample example = RbBusDelayTransferDtlValueUtil.eoToEntityExample(eo);
        return rbBusDelayTransferDtlMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusDelayTransferDtlEO eo) {
        RbBusDelayTransferDtlExample example = RbBusDelayTransferDtlValueUtil.eoToEntityExample(eo);
        return rbBusDelayTransferDtlMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo, Date tranDate) {
        return rbBusDelayTransferDtlMapper.deleteByPrimaryKey(seqNo, tranDate);
    }

    @Override
    public int create(RbBusDelayTransferDtlEO eo) {
        RbBusDelayTransferDtl row = RbBusDelayTransferDtlValueUtil.eoToEntity(eo);
        return rbBusDelayTransferDtlMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusDelayTransferDtlEO eo) {
        RbBusDelayTransferDtl row = RbBusDelayTransferDtlValueUtil.eoToEntity(eo);
        return rbBusDelayTransferDtlMapper.insertSelective(row);
    }

    @Override
    public List<RbBusDelayTransferDtlEO> findByEo(RbBusDelayTransferDtlEO eo) {
        RbBusDelayTransferDtlExample example = RbBusDelayTransferDtlValueUtil.eoToEntityExample(eo);
        List<RbBusDelayTransferDtlEO> result = new ArrayList<>();
        List<RbBusDelayTransferDtl> dbResult = rbBusDelayTransferDtlMapper.selectByExample(example);
        for (RbBusDelayTransferDtl item : dbResult) {
            result.add(RbBusDelayTransferDtlValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusDelayTransferDtlEO findByPrimaryKey(String seqNo, Date tranDate) {
        return RbBusDelayTransferDtlValueUtil.entityToEo(rbBusDelayTransferDtlMapper.selectByPrimaryKey(seqNo, tranDate));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusDelayTransferDtlEO eo) {
        RbBusDelayTransferDtl row = RbBusDelayTransferDtlValueUtil.eoToEntity(eo);
        return rbBusDelayTransferDtlMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusDelayTransferDtlEO eo) {
        RbBusDelayTransferDtl row = RbBusDelayTransferDtlValueUtil.eoToEntity(eo);
        return rbBusDelayTransferDtlMapper.updateByPrimaryKey(row);
    }
}