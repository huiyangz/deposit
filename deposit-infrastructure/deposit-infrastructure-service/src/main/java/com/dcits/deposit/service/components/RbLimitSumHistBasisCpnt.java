package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.SourceType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbLimitSumHist;
import com.dcits.deposit.entity.RbLimitSumHistExample;
import com.dcits.deposit.facade.components.IRbLimitSumHistBcc;
import com.dcits.deposit.facade.eo.RbLimitSumHistEO;
import com.dcits.deposit.repo.RbLimitSumHistMapper;
import com.dcits.deposit.service.utils.RbLimitSumHistValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbLimitSumHistBasisCpnt implements IRbLimitSumHistBcc {
    @Autowired
    RbLimitSumHistMapper rbLimitSumHistMapper;

    @Override
    public long countByEo(RbLimitSumHistEO eo) {
        RbLimitSumHistExample example = RbLimitSumHistValueUtil.eoToEntityExample(eo);
        return rbLimitSumHistMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbLimitSumHistEO eo) {
        RbLimitSumHistExample example = RbLimitSumHistValueUtil.eoToEntityExample(eo);
        return rbLimitSumHistMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo) {
        return rbLimitSumHistMapper.deleteByPrimaryKey(seqNo);
    }

    @Override
    public int create(RbLimitSumHistEO eo) {
        RbLimitSumHist row = RbLimitSumHistValueUtil.eoToEntity(eo);
        return rbLimitSumHistMapper.insert(row);
    }

    @Override
    public int createSelective(RbLimitSumHistEO eo) {
        RbLimitSumHist row = RbLimitSumHistValueUtil.eoToEntity(eo);
        return rbLimitSumHistMapper.insertSelective(row);
    }

    @Override
    public List<RbLimitSumHistEO> findByEo(RbLimitSumHistEO eo) {
        RbLimitSumHistExample example = RbLimitSumHistValueUtil.eoToEntityExample(eo);
        List<RbLimitSumHistEO> result = new ArrayList<>();
        List<RbLimitSumHist> dbResult = rbLimitSumHistMapper.selectByExample(example);
        for (RbLimitSumHist item : dbResult) {
            result.add(RbLimitSumHistValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbLimitSumHistEO findByPrimaryKey(String seqNo) {
        return RbLimitSumHistValueUtil.entityToEo(rbLimitSumHistMapper.selectByPrimaryKey(seqNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbLimitSumHistEO eo) {
        RbLimitSumHist row = RbLimitSumHistValueUtil.eoToEntity(eo);
        return rbLimitSumHistMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbLimitSumHistEO eo) {
        RbLimitSumHist row = RbLimitSumHistValueUtil.eoToEntity(eo);
        return rbLimitSumHistMapper.updateByPrimaryKey(row);
    }
}