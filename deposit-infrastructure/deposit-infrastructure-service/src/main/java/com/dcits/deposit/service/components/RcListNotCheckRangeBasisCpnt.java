package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ListType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranType;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RcListNotCheckRange;
import com.dcits.deposit.entity.RcListNotCheckRangeExample;
import com.dcits.deposit.facade.components.IRcListNotCheckRangeBcc;
import com.dcits.deposit.facade.eo.RcListNotCheckRangeEO;
import com.dcits.deposit.repo.RcListNotCheckRangeMapper;
import com.dcits.deposit.service.utils.RcListNotCheckRangeValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RcListNotCheckRangeBasisCpnt implements IRcListNotCheckRangeBcc {
    @Autowired
    RcListNotCheckRangeMapper rcListNotCheckRangeMapper;

    @Override
    public long countByEo(RcListNotCheckRangeEO eo) {
        RcListNotCheckRangeExample example = RcListNotCheckRangeValueUtil.eoToEntityExample(eo);
        return rcListNotCheckRangeMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RcListNotCheckRangeEO eo) {
        RcListNotCheckRangeExample example = RcListNotCheckRangeValueUtil.eoToEntityExample(eo);
        return rcListNotCheckRangeMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo) {
        return rcListNotCheckRangeMapper.deleteByPrimaryKey(seqNo);
    }

    @Override
    public int create(RcListNotCheckRangeEO eo) {
        RcListNotCheckRange row = RcListNotCheckRangeValueUtil.eoToEntity(eo);
        return rcListNotCheckRangeMapper.insert(row);
    }

    @Override
    public int createSelective(RcListNotCheckRangeEO eo) {
        RcListNotCheckRange row = RcListNotCheckRangeValueUtil.eoToEntity(eo);
        return rcListNotCheckRangeMapper.insertSelective(row);
    }

    @Override
    public List<RcListNotCheckRangeEO> findByEo(RcListNotCheckRangeEO eo) {
        RcListNotCheckRangeExample example = RcListNotCheckRangeValueUtil.eoToEntityExample(eo);
        List<RcListNotCheckRangeEO> result = new ArrayList<>();
        List<RcListNotCheckRange> dbResult = rcListNotCheckRangeMapper.selectByExample(example);
        for (RcListNotCheckRange item : dbResult) {
            result.add(RcListNotCheckRangeValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RcListNotCheckRangeEO findByPrimaryKey(String seqNo) {
        return RcListNotCheckRangeValueUtil.entityToEo(rcListNotCheckRangeMapper.selectByPrimaryKey(seqNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RcListNotCheckRangeEO eo) {
        RcListNotCheckRange row = RcListNotCheckRangeValueUtil.eoToEntity(eo);
        return rcListNotCheckRangeMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RcListNotCheckRangeEO eo) {
        RcListNotCheckRange row = RcListNotCheckRangeValueUtil.eoToEntity(eo);
        return rcListNotCheckRangeMapper.updateByPrimaryKey(row);
    }
}