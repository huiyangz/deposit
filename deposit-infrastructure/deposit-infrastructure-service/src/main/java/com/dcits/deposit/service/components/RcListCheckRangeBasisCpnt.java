package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ListType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranType;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RcListCheckRange;
import com.dcits.deposit.entity.RcListCheckRangeExample;
import com.dcits.deposit.facade.components.IRcListCheckRangeBcc;
import com.dcits.deposit.facade.eo.RcListCheckRangeEO;
import com.dcits.deposit.repo.RcListCheckRangeMapper;
import com.dcits.deposit.service.utils.RcListCheckRangeValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RcListCheckRangeBasisCpnt implements IRcListCheckRangeBcc {
    @Autowired
    RcListCheckRangeMapper rcListCheckRangeMapper;

    @Override
    public long countByEo(RcListCheckRangeEO eo) {
        RcListCheckRangeExample example = RcListCheckRangeValueUtil.eoToEntityExample(eo);
        return rcListCheckRangeMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RcListCheckRangeEO eo) {
        RcListCheckRangeExample example = RcListCheckRangeValueUtil.eoToEntityExample(eo);
        return rcListCheckRangeMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo) {
        return rcListCheckRangeMapper.deleteByPrimaryKey(seqNo);
    }

    @Override
    public int create(RcListCheckRangeEO eo) {
        RcListCheckRange row = RcListCheckRangeValueUtil.eoToEntity(eo);
        return rcListCheckRangeMapper.insert(row);
    }

    @Override
    public int createSelective(RcListCheckRangeEO eo) {
        RcListCheckRange row = RcListCheckRangeValueUtil.eoToEntity(eo);
        return rcListCheckRangeMapper.insertSelective(row);
    }

    @Override
    public List<RcListCheckRangeEO> findByEo(RcListCheckRangeEO eo) {
        RcListCheckRangeExample example = RcListCheckRangeValueUtil.eoToEntityExample(eo);
        List<RcListCheckRangeEO> result = new ArrayList<>();
        List<RcListCheckRange> dbResult = rcListCheckRangeMapper.selectByExample(example);
        for (RcListCheckRange item : dbResult) {
            result.add(RcListCheckRangeValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RcListCheckRangeEO findByPrimaryKey(String seqNo) {
        return RcListCheckRangeValueUtil.entityToEo(rcListCheckRangeMapper.selectByPrimaryKey(seqNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RcListCheckRangeEO eo) {
        RcListCheckRange row = RcListCheckRangeValueUtil.eoToEntity(eo);
        return rcListCheckRangeMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RcListCheckRangeEO eo) {
        RcListCheckRange row = RcListCheckRangeValueUtil.eoToEntity(eo);
        return rcListCheckRangeMapper.updateByPrimaryKey(row);
    }
}