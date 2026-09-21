package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AgreeChangeType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CycleFreq;
import com.dcits.deposit.enums.FloatType;
import com.dcits.deposit.enums.FollowIntDayType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IntApplType;
import com.dcits.deposit.enums.IntCalcBal;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasis;
import com.dcits.deposit.enums.PenaltyOdiRateType;
import com.dcits.deposit.enums.RateEffectType;
import com.dcits.deposit.enums.TaxType;
import com.dcits.deposit.enums.YearBasis;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAcctIntDetailPre;
import com.dcits.deposit.entity.RbAcctIntDetailPreExample;
import com.dcits.deposit.facade.components.IRbAcctIntDetailPreBcc;
import com.dcits.deposit.facade.eo.RbAcctIntDetailPreEO;
import com.dcits.deposit.repo.RbAcctIntDetailPreMapper;
import com.dcits.deposit.service.utils.RbAcctIntDetailPreValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAcctIntDetailPreBasisCpnt implements IRbAcctIntDetailPreBcc {
    @Autowired
    RbAcctIntDetailPreMapper rbAcctIntDetailPreMapper;

    @Override
    public long countByEo(RbAcctIntDetailPreEO eo) {
        RbAcctIntDetailPreExample example = RbAcctIntDetailPreValueUtil.eoToEntityExample(eo);
        return rbAcctIntDetailPreMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAcctIntDetailPreEO eo) {
        RbAcctIntDetailPreExample example = RbAcctIntDetailPreValueUtil.eoToEntityExample(eo);
        return rbAcctIntDetailPreMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer internalKey, String intClass, BigDecimal agg, String clientNo, String tranTimestamp) {
        return rbAcctIntDetailPreMapper.deleteByPrimaryKey(internalKey, intClass, agg, clientNo, tranTimestamp);
    }

    @Override
    public int create(RbAcctIntDetailPreEO eo) {
        RbAcctIntDetailPre row = RbAcctIntDetailPreValueUtil.eoToEntity(eo);
        return rbAcctIntDetailPreMapper.insert(row);
    }

    @Override
    public int createSelective(RbAcctIntDetailPreEO eo) {
        RbAcctIntDetailPre row = RbAcctIntDetailPreValueUtil.eoToEntity(eo);
        return rbAcctIntDetailPreMapper.insertSelective(row);
    }

    @Override
    public List<RbAcctIntDetailPreEO> findByEo(RbAcctIntDetailPreEO eo) {
        RbAcctIntDetailPreExample example = RbAcctIntDetailPreValueUtil.eoToEntityExample(eo);
        List<RbAcctIntDetailPreEO> result = new ArrayList<>();
        List<RbAcctIntDetailPre> dbResult = rbAcctIntDetailPreMapper.selectByExample(example);
        for (RbAcctIntDetailPre item : dbResult) {
            result.add(RbAcctIntDetailPreValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAcctIntDetailPreEO findByPrimaryKey(Integer internalKey, String intClass, BigDecimal agg, String clientNo, String tranTimestamp) {
        return RbAcctIntDetailPreValueUtil.entityToEo(rbAcctIntDetailPreMapper.selectByPrimaryKey(internalKey, intClass, agg, clientNo, tranTimestamp));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAcctIntDetailPreEO eo) {
        RbAcctIntDetailPre row = RbAcctIntDetailPreValueUtil.eoToEntity(eo);
        return rbAcctIntDetailPreMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAcctIntDetailPreEO eo) {
        RbAcctIntDetailPre row = RbAcctIntDetailPreValueUtil.eoToEntity(eo);
        return rbAcctIntDetailPreMapper.updateByPrimaryKey(row);
    }
}