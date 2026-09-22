package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CycleFreq;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasis;
import com.dcits.deposit.enums.NearPeriodType;
import com.dcits.deposit.enums.YearBasis;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbIntLayerRate;
import com.dcits.deposit.entity.RbIntLayerRateExample;
import com.dcits.deposit.facade.components.IRbIntLayerRateBcc;
import com.dcits.deposit.facade.eo.RbIntLayerRateEO;
import com.dcits.deposit.repo.RbIntLayerRateMapper;
import com.dcits.deposit.service.utils.RbIntLayerRateValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbIntLayerRateBasisCpnt implements IRbIntLayerRateBcc {
    @Autowired
    RbIntLayerRateMapper rbIntLayerRateMapper;

    @Override
    public long countByEo(RbIntLayerRateEO eo) {
        RbIntLayerRateExample example = RbIntLayerRateValueUtil.eoToEntityExample(eo);
        return rbIntLayerRateMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbIntLayerRateEO eo) {
        RbIntLayerRateExample example = RbIntLayerRateValueUtil.eoToEntityExample(eo);
        return rbIntLayerRateMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String irlSeqNo, String clientNo) {
        return rbIntLayerRateMapper.deleteByPrimaryKey(irlSeqNo, clientNo);
    }

    @Override
    public int create(RbIntLayerRateEO eo) {
        RbIntLayerRate row = RbIntLayerRateValueUtil.eoToEntity(eo);
        return rbIntLayerRateMapper.insert(row);
    }

    @Override
    public int createSelective(RbIntLayerRateEO eo) {
        RbIntLayerRate row = RbIntLayerRateValueUtil.eoToEntity(eo);
        return rbIntLayerRateMapper.insertSelective(row);
    }

    @Override
    public List<RbIntLayerRateEO> findByEo(RbIntLayerRateEO eo) {
        RbIntLayerRateExample example = RbIntLayerRateValueUtil.eoToEntityExample(eo);
        List<RbIntLayerRateEO> result = new ArrayList<>();
        List<RbIntLayerRate> dbResult = rbIntLayerRateMapper.selectByExample(example);
        for (RbIntLayerRate item : dbResult) {
            result.add(RbIntLayerRateValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbIntLayerRateEO findByPrimaryKey(String irlSeqNo, String clientNo) {
        return RbIntLayerRateValueUtil.entityToEo(rbIntLayerRateMapper.selectByPrimaryKey(irlSeqNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbIntLayerRateEO eo) {
        RbIntLayerRate row = RbIntLayerRateValueUtil.eoToEntity(eo);
        return rbIntLayerRateMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbIntLayerRateEO eo) {
        RbIntLayerRate row = RbIntLayerRateValueUtil.eoToEntity(eo);
        return rbIntLayerRateMapper.updateByPrimaryKey(row);
    }
}