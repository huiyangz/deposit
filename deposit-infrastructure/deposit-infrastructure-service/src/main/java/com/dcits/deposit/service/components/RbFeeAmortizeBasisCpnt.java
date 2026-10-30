package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AmortizeStatus;
import com.dcits.deposit.enums.AmortizeTimeType;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.FeeTakenMode;
import com.dcits.deposit.enums.FeeType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbFeeAmortize;
import com.dcits.deposit.entity.RbFeeAmortizeExample;
import com.dcits.deposit.facade.components.IRbFeeAmortizeBcc;
import com.dcits.deposit.facade.eo.RbFeeAmortizeEO;
import com.dcits.deposit.repo.RbFeeAmortizeMapper;
import com.dcits.deposit.service.utils.RbFeeAmortizeValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbFeeAmortizeBasisCpnt implements IRbFeeAmortizeBcc {
    @Autowired
    RbFeeAmortizeMapper rbFeeAmortizeMapper;

    @Override
    public long countByEo(RbFeeAmortizeEO eo) {
        RbFeeAmortizeExample example = RbFeeAmortizeValueUtil.eoToEntityExample(eo);
        return rbFeeAmortizeMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbFeeAmortizeEO eo) {
        RbFeeAmortizeExample example = RbFeeAmortizeValueUtil.eoToEntityExample(eo);
        return rbFeeAmortizeMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String amortizeId) {
        return rbFeeAmortizeMapper.deleteByPrimaryKey(amortizeId);
    }

    @Override
    public int create(RbFeeAmortizeEO eo) {
        RbFeeAmortize row = RbFeeAmortizeValueUtil.eoToEntity(eo);
        return rbFeeAmortizeMapper.insert(row);
    }

    @Override
    public int createSelective(RbFeeAmortizeEO eo) {
        RbFeeAmortize row = RbFeeAmortizeValueUtil.eoToEntity(eo);
        return rbFeeAmortizeMapper.insertSelective(row);
    }

    @Override
    public List<RbFeeAmortizeEO> findByEo(RbFeeAmortizeEO eo) {
        RbFeeAmortizeExample example = RbFeeAmortizeValueUtil.eoToEntityExample(eo);
        List<RbFeeAmortizeEO> result = new ArrayList<>();
        List<RbFeeAmortize> dbResult = rbFeeAmortizeMapper.selectByExample(example);
        for (RbFeeAmortize item : dbResult) {
            result.add(RbFeeAmortizeValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbFeeAmortizeEO findByPrimaryKey(String amortizeId) {
        return RbFeeAmortizeValueUtil.entityToEo(rbFeeAmortizeMapper.selectByPrimaryKey(amortizeId));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbFeeAmortizeEO eo) {
        RbFeeAmortize row = RbFeeAmortizeValueUtil.eoToEntity(eo);
        return rbFeeAmortizeMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbFeeAmortizeEO eo) {
        RbFeeAmortize row = RbFeeAmortizeValueUtil.eoToEntity(eo);
        return rbFeeAmortizeMapper.updateByPrimaryKey(row);
    }
}