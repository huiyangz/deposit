package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.ExchangeAmountNature;
import com.dcits.deposit.enums.ExchangeAmountType;
import com.dcits.deposit.enums.ExchangeCancelReason;
import com.dcits.deposit.enums.ExchangeChangeReason;
import com.dcits.deposit.enums.ExchangeClass;
import com.dcits.deposit.enums.ExchangeReportType;
import com.dcits.deposit.enums.ExchangeSupplyReason;
import com.dcits.deposit.enums.ExchangeTranStatus;
import com.dcits.deposit.enums.ExchangeType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.SourceModule;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbExchangeTranAttach;
import com.dcits.deposit.entity.RbExchangeTranAttachExample;
import com.dcits.deposit.facade.components.IRbExchangeTranAttachBcc;
import com.dcits.deposit.facade.eo.RbExchangeTranAttachEO;
import com.dcits.deposit.repo.RbExchangeTranAttachMapper;
import com.dcits.deposit.service.utils.RbExchangeTranAttachValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbExchangeTranAttachBasisCpnt implements IRbExchangeTranAttachBcc {
    @Autowired
    RbExchangeTranAttachMapper rbExchangeTranAttachMapper;

    @Override
    public long countByEo(RbExchangeTranAttachEO eo) {
        RbExchangeTranAttachExample example = RbExchangeTranAttachValueUtil.eoToEntityExample(eo);
        return rbExchangeTranAttachMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbExchangeTranAttachEO eo) {
        RbExchangeTranAttachExample example = RbExchangeTranAttachValueUtil.eoToEntityExample(eo);
        return rbExchangeTranAttachMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo, String clientNo) {
        return rbExchangeTranAttachMapper.deleteByPrimaryKey(seqNo, clientNo);
    }

    @Override
    public int create(RbExchangeTranAttachEO eo) {
        RbExchangeTranAttach row = RbExchangeTranAttachValueUtil.eoToEntity(eo);
        return rbExchangeTranAttachMapper.insert(row);
    }

    @Override
    public int createSelective(RbExchangeTranAttachEO eo) {
        RbExchangeTranAttach row = RbExchangeTranAttachValueUtil.eoToEntity(eo);
        return rbExchangeTranAttachMapper.insertSelective(row);
    }

    @Override
    public List<RbExchangeTranAttachEO> findByEo(RbExchangeTranAttachEO eo) {
        RbExchangeTranAttachExample example = RbExchangeTranAttachValueUtil.eoToEntityExample(eo);
        List<RbExchangeTranAttachEO> result = new ArrayList<>();
        List<RbExchangeTranAttach> dbResult = rbExchangeTranAttachMapper.selectByExample(example);
        for (RbExchangeTranAttach item : dbResult) {
            result.add(RbExchangeTranAttachValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbExchangeTranAttachEO findByPrimaryKey(String seqNo, String clientNo) {
        return RbExchangeTranAttachValueUtil.entityToEo(rbExchangeTranAttachMapper.selectByPrimaryKey(seqNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbExchangeTranAttachEO eo) {
        RbExchangeTranAttach row = RbExchangeTranAttachValueUtil.eoToEntity(eo);
        return rbExchangeTranAttachMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbExchangeTranAttachEO eo) {
        RbExchangeTranAttach row = RbExchangeTranAttachValueUtil.eoToEntity(eo);
        return rbExchangeTranAttachMapper.updateByPrimaryKey(row);
    }
}