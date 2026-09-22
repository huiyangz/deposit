package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.QuoteType;
import com.dcits.deposit.enums.RateType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.MbCcyRate;
import com.dcits.deposit.entity.MbCcyRateExample;
import com.dcits.deposit.facade.components.IMbCcyRateBcc;
import com.dcits.deposit.facade.eo.MbCcyRateEO;
import com.dcits.deposit.repo.MbCcyRateMapper;
import com.dcits.deposit.service.utils.MbCcyRateValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MbCcyRateBasisCpnt implements IMbCcyRateBcc {
    @Autowired
    MbCcyRateMapper mbCcyRateMapper;

    @Override
    public long countByEo(MbCcyRateEO eo) {
        MbCcyRateExample example = MbCcyRateValueUtil.eoToEntityExample(eo);
        return mbCcyRateMapper.countByExample(example);
    }

    @Override
    public int removeByEo(MbCcyRateEO eo) {
        MbCcyRateExample example = MbCcyRateValueUtil.eoToEntityExample(eo);
        return mbCcyRateMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String rateType, String ccy, String branch, Date effectDate, String effectTime) {
        return mbCcyRateMapper.deleteByPrimaryKey(rateType, ccy, branch, effectDate, effectTime);
    }

    @Override
    public int create(MbCcyRateEO eo) {
        MbCcyRate row = MbCcyRateValueUtil.eoToEntity(eo);
        return mbCcyRateMapper.insert(row);
    }

    @Override
    public int createSelective(MbCcyRateEO eo) {
        MbCcyRate row = MbCcyRateValueUtil.eoToEntity(eo);
        return mbCcyRateMapper.insertSelective(row);
    }

    @Override
    public List<MbCcyRateEO> findByEo(MbCcyRateEO eo) {
        MbCcyRateExample example = MbCcyRateValueUtil.eoToEntityExample(eo);
        List<MbCcyRateEO> result = new ArrayList<>();
        List<MbCcyRate> dbResult = mbCcyRateMapper.selectByExample(example);
        for (MbCcyRate item : dbResult) {
            result.add(MbCcyRateValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public MbCcyRateEO findByPrimaryKey(String rateType, String ccy, String branch, Date effectDate, String effectTime) {
        return MbCcyRateValueUtil.entityToEo(mbCcyRateMapper.selectByPrimaryKey(rateType, ccy, branch, effectDate, effectTime));
    }

    @Override
    public int modifyByPrimaryKeySelective(MbCcyRateEO eo) {
        MbCcyRate row = MbCcyRateValueUtil.eoToEntity(eo);
        return mbCcyRateMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(MbCcyRateEO eo) {
        MbCcyRate row = MbCcyRateValueUtil.eoToEntity(eo);
        return mbCcyRateMapper.updateByPrimaryKey(row);
    }
}