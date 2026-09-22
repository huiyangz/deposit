package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbLoanFundInfo;
import com.dcits.deposit.entity.RbLoanFundInfoExample;
import com.dcits.deposit.facade.components.IRbLoanFundInfoBcc;
import com.dcits.deposit.facade.eo.RbLoanFundInfoEO;
import com.dcits.deposit.repo.RbLoanFundInfoMapper;
import com.dcits.deposit.service.utils.RbLoanFundInfoValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbLoanFundInfoBasisCpnt implements IRbLoanFundInfoBcc {
    @Autowired
    RbLoanFundInfoMapper rbLoanFundInfoMapper;

    @Override
    public long countByEo(RbLoanFundInfoEO eo) {
        RbLoanFundInfoExample example = RbLoanFundInfoValueUtil.eoToEntityExample(eo);
        return rbLoanFundInfoMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbLoanFundInfoEO eo) {
        RbLoanFundInfoExample example = RbLoanFundInfoValueUtil.eoToEntityExample(eo);
        return rbLoanFundInfoMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer internalKey, String clientNo) {
        return rbLoanFundInfoMapper.deleteByPrimaryKey(internalKey, clientNo);
    }

    @Override
    public int create(RbLoanFundInfoEO eo) {
        RbLoanFundInfo row = RbLoanFundInfoValueUtil.eoToEntity(eo);
        return rbLoanFundInfoMapper.insert(row);
    }

    @Override
    public int createSelective(RbLoanFundInfoEO eo) {
        RbLoanFundInfo row = RbLoanFundInfoValueUtil.eoToEntity(eo);
        return rbLoanFundInfoMapper.insertSelective(row);
    }

    @Override
    public List<RbLoanFundInfoEO> findByEo(RbLoanFundInfoEO eo) {
        RbLoanFundInfoExample example = RbLoanFundInfoValueUtil.eoToEntityExample(eo);
        List<RbLoanFundInfoEO> result = new ArrayList<>();
        List<RbLoanFundInfo> dbResult = rbLoanFundInfoMapper.selectByExample(example);
        for (RbLoanFundInfo item : dbResult) {
            result.add(RbLoanFundInfoValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbLoanFundInfoEO findByPrimaryKey(Integer internalKey, String clientNo) {
        return RbLoanFundInfoValueUtil.entityToEo(rbLoanFundInfoMapper.selectByPrimaryKey(internalKey, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbLoanFundInfoEO eo) {
        RbLoanFundInfo row = RbLoanFundInfoValueUtil.eoToEntity(eo);
        return rbLoanFundInfoMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbLoanFundInfoEO eo) {
        RbLoanFundInfo row = RbLoanFundInfoValueUtil.eoToEntity(eo);
        return rbLoanFundInfoMapper.updateByPrimaryKey(row);
    }
}