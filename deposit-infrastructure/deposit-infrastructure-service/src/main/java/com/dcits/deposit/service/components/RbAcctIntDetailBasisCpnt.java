package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CycleFreq;
import com.dcits.deposit.enums.FloatType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IntApplType;
import com.dcits.deposit.enums.IntCalcBal;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasis;
import com.dcits.deposit.enums.TaxType;
import com.dcits.deposit.enums.YearBasis;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAcctIntDetail;
import com.dcits.deposit.entity.RbAcctIntDetailExample;
import com.dcits.deposit.facade.components.IRbAcctIntDetailBcc;
import com.dcits.deposit.facade.eo.RbAcctIntDetailEO;
import com.dcits.deposit.repo.RbAcctIntDetailMapper;
import com.dcits.deposit.service.utils.RbAcctIntDetailValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAcctIntDetailBasisCpnt implements IRbAcctIntDetailBcc {
    @Autowired
    RbAcctIntDetailMapper rbAcctIntDetailMapper;

    @Override
    public long countByEo(RbAcctIntDetailEO eo) {
        RbAcctIntDetailExample example = RbAcctIntDetailValueUtil.eoToEntityExample(eo);
        return rbAcctIntDetailMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAcctIntDetailEO eo) {
        RbAcctIntDetailExample example = RbAcctIntDetailValueUtil.eoToEntityExample(eo);
        return rbAcctIntDetailMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer internalKey, String intClass, String clientNo) {
        return rbAcctIntDetailMapper.deleteByPrimaryKey(internalKey, intClass, clientNo);
    }

    @Override
    public int create(RbAcctIntDetailEO eo) {
        RbAcctIntDetail row = RbAcctIntDetailValueUtil.eoToEntity(eo);
        return rbAcctIntDetailMapper.insert(row);
    }

    @Override
    public int createSelective(RbAcctIntDetailEO eo) {
        RbAcctIntDetail row = RbAcctIntDetailValueUtil.eoToEntity(eo);
        return rbAcctIntDetailMapper.insertSelective(row);
    }

    @Override
    public List<RbAcctIntDetailEO> findByEo(RbAcctIntDetailEO eo) {
        RbAcctIntDetailExample example = RbAcctIntDetailValueUtil.eoToEntityExample(eo);
        List<RbAcctIntDetailEO> result = new ArrayList<>();
        List<RbAcctIntDetail> dbResult = rbAcctIntDetailMapper.selectByExample(example);
        for (RbAcctIntDetail item : dbResult) {
            result.add(RbAcctIntDetailValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAcctIntDetailEO findByPrimaryKey(Integer internalKey, String intClass, String clientNo) {
        return RbAcctIntDetailValueUtil.entityToEo(rbAcctIntDetailMapper.selectByPrimaryKey(internalKey, intClass, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAcctIntDetailEO eo) {
        RbAcctIntDetail row = RbAcctIntDetailValueUtil.eoToEntity(eo);
        return rbAcctIntDetailMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAcctIntDetailEO eo) {
        RbAcctIntDetail row = RbAcctIntDetailValueUtil.eoToEntity(eo);
        return rbAcctIntDetailMapper.updateByPrimaryKey(row);
    }
}