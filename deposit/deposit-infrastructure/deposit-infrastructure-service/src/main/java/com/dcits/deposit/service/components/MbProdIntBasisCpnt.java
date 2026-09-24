package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.DaysGearType;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.EffectDateCalcMethod;
import com.dcits.deposit.enums.GearAmtMethod;
import com.dcits.deposit.enums.GearDaysInd;
import com.dcits.deposit.enums.GroupRuleType;
import com.dcits.deposit.enums.IntCalcAmtType;
import com.dcits.deposit.enums.IntCalcMethod;
import com.dcits.deposit.enums.IntChangeType;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntMatchRule;
import com.dcits.deposit.enums.IntRecalcMethod;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasisType;
import com.dcits.deposit.enums.RateLayerRule;
import com.dcits.deposit.enums.RollFreq;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.VoucherStatus;
import com.dcits.deposit.enums.YearBasisType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.MbProdInt;
import com.dcits.deposit.entity.MbProdIntExample;
import com.dcits.deposit.facade.components.IMbProdIntBcc;
import com.dcits.deposit.facade.eo.MbProdIntEO;
import com.dcits.deposit.repo.MbProdIntMapper;
import com.dcits.deposit.service.utils.MbProdIntValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MbProdIntBasisCpnt implements IMbProdIntBcc {
    @Autowired
    MbProdIntMapper mbProdIntMapper;

    @Override
    public long countByEo(MbProdIntEO eo) {
        MbProdIntExample example = MbProdIntValueUtil.eoToEntityExample(eo);
        return mbProdIntMapper.countByExample(example);
    }

    @Override
    public int removeByEo(MbProdIntEO eo) {
        MbProdIntExample example = MbProdIntValueUtil.eoToEntityExample(eo);
        return mbProdIntMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String prodNo, String intType, String eventType, String intClass) {
        return mbProdIntMapper.deleteByPrimaryKey(prodNo, intType, eventType, intClass);
    }

    @Override
    public int create(MbProdIntEO eo) {
        MbProdInt row = MbProdIntValueUtil.eoToEntity(eo);
        return mbProdIntMapper.insert(row);
    }

    @Override
    public int createSelective(MbProdIntEO eo) {
        MbProdInt row = MbProdIntValueUtil.eoToEntity(eo);
        return mbProdIntMapper.insertSelective(row);
    }

    @Override
    public List<MbProdIntEO> findByEo(MbProdIntEO eo) {
        MbProdIntExample example = MbProdIntValueUtil.eoToEntityExample(eo);
        List<MbProdIntEO> result = new ArrayList<>();
        List<MbProdInt> dbResult = mbProdIntMapper.selectByExample(example);
        for (MbProdInt item : dbResult) {
            result.add(MbProdIntValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public MbProdIntEO findByPrimaryKey(String prodNo, String intType, String eventType, String intClass) {
        return MbProdIntValueUtil.entityToEo(mbProdIntMapper.selectByPrimaryKey(prodNo, intType, eventType, intClass));
    }

    @Override
    public int modifyByPrimaryKeySelective(MbProdIntEO eo) {
        MbProdInt row = MbProdIntValueUtil.eoToEntity(eo);
        return mbProdIntMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(MbProdIntEO eo) {
        MbProdInt row = MbProdIntValueUtil.eoToEntity(eo);
        return mbProdIntMapper.updateByPrimaryKey(row);
    }
}