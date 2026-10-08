package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.DaysGearType;
import com.dcits.depsit.enums.DocType;
import com.dcits.depsit.enums.EffectDateCalcMethod;
import com.dcits.depsit.enums.GearAmtMethod;
import com.dcits.depsit.enums.GearDaysInd;
import com.dcits.depsit.enums.GroupRuleType;
import com.dcits.depsit.enums.IntCalcAmtType;
import com.dcits.depsit.enums.IntCalcMethod;
import com.dcits.depsit.enums.IntChangeType;
import com.dcits.depsit.enums.IntClass;
import com.dcits.depsit.enums.IntMatchRule;
import com.dcits.depsit.enums.IntRecalcMethod;
import com.dcits.depsit.enums.IntType;
import com.dcits.depsit.enums.MonthBasisType;
import com.dcits.depsit.enums.RateLayerRule;
import com.dcits.depsit.enums.RollFreq;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.enums.VoucherStatus;
import com.dcits.depsit.enums.YearBasisType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.MbProdInt;
import com.dcits.depsit.entity.MbProdIntExample;
import com.dcits.depsit.facade.components.IMbProdIntBcc;
import com.dcits.depsit.facade.eo.MbProdIntEO;
import com.dcits.depsit.repo.MbProdIntMapper;
import com.dcits.depsit.service.utils.MbProdIntValueUtil;
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