package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAcctBalance;
import com.dcits.deposit.entity.RbAcctBalanceExample;
import com.dcits.deposit.facade.components.IRbAcctBalanceBcc;
import com.dcits.deposit.facade.eo.RbAcctBalanceEO;
import com.dcits.deposit.repo.RbAcctBalanceMapper;
import com.dcits.deposit.service.utils.RbAcctBalanceValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAcctBalanceBasisCpnt implements IRbAcctBalanceBcc {
    @Autowired
    RbAcctBalanceMapper rbAcctBalanceMapper;

    @Override
    public long countByEo(RbAcctBalanceEO eo) {
        RbAcctBalanceExample example = RbAcctBalanceValueUtil.eoToEntityExample(eo);
        return rbAcctBalanceMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAcctBalanceEO eo) {
        RbAcctBalanceExample example = RbAcctBalanceValueUtil.eoToEntityExample(eo);
        return rbAcctBalanceMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer internalKey, String clientNo) {
        return rbAcctBalanceMapper.deleteByPrimaryKey(internalKey, clientNo);
    }

    @Override
    public int create(RbAcctBalanceEO eo) {
        RbAcctBalance row = RbAcctBalanceValueUtil.eoToEntity(eo);
        return rbAcctBalanceMapper.insert(row);
    }

    @Override
    public int createSelective(RbAcctBalanceEO eo) {
        RbAcctBalance row = RbAcctBalanceValueUtil.eoToEntity(eo);
        return rbAcctBalanceMapper.insertSelective(row);
    }

    @Override
    public List<RbAcctBalanceEO> findByEo(RbAcctBalanceEO eo) {
        RbAcctBalanceExample example = RbAcctBalanceValueUtil.eoToEntityExample(eo);
        List<RbAcctBalanceEO> result = new ArrayList<>();
        List<RbAcctBalance> dbResult = rbAcctBalanceMapper.selectByExample(example);
        for (RbAcctBalance item : dbResult) {
            result.add(RbAcctBalanceValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAcctBalanceEO findByPrimaryKey(Integer internalKey, String clientNo) {
        return RbAcctBalanceValueUtil.entityToEo(rbAcctBalanceMapper.selectByPrimaryKey(internalKey, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAcctBalanceEO eo) {
        RbAcctBalance row = RbAcctBalanceValueUtil.eoToEntity(eo);
        return rbAcctBalanceMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAcctBalanceEO eo) {
        RbAcctBalance row = RbAcctBalanceValueUtil.eoToEntity(eo);
        return rbAcctBalanceMapper.updateByPrimaryKey(row);
    }
}