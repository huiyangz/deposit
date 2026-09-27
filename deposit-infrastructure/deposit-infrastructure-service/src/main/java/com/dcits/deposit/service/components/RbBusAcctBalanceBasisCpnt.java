package com.dcits.deposit.service.components;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusAcctBalance;
import com.dcits.deposit.entity.RbBusAcctBalanceExample;
import com.dcits.deposit.facade.components.IRbBusAcctBalanceBcc;
import com.dcits.deposit.facade.eo.RbBusAcctBalanceEO;
import com.dcits.deposit.repo.RbBusAcctBalanceMapper;
import com.dcits.deposit.service.utils.RbBusAcctBalanceValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusAcctBalanceBasisCpnt implements IRbBusAcctBalanceBcc {
    @Autowired
    RbBusAcctBalanceMapper rbBusAcctBalanceMapper;

    @Override
    public long countByEo(RbBusAcctBalanceEO eo) {
        RbBusAcctBalanceExample example = RbBusAcctBalanceValueUtil.eoToEntityExample(eo);
        return rbBusAcctBalanceMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusAcctBalanceEO eo) {
        RbBusAcctBalanceExample example = RbBusAcctBalanceValueUtil.eoToEntityExample(eo);
        return rbBusAcctBalanceMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer internalKey) {
        return rbBusAcctBalanceMapper.deleteByPrimaryKey(internalKey);
    }

    @Override
    public int create(RbBusAcctBalanceEO eo) {
        RbBusAcctBalance row = RbBusAcctBalanceValueUtil.eoToEntity(eo);
        return rbBusAcctBalanceMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusAcctBalanceEO eo) {
        RbBusAcctBalance row = RbBusAcctBalanceValueUtil.eoToEntity(eo);
        return rbBusAcctBalanceMapper.insertSelective(row);
    }

    @Override
    public List<RbBusAcctBalanceEO> findByEo(RbBusAcctBalanceEO eo) {
        RbBusAcctBalanceExample example = RbBusAcctBalanceValueUtil.eoToEntityExample(eo);
        List<RbBusAcctBalanceEO> result = new ArrayList<>();
        List<RbBusAcctBalance> dbResult = rbBusAcctBalanceMapper.selectByExample(example);
        for (RbBusAcctBalance item : dbResult) {
            result.add(RbBusAcctBalanceValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusAcctBalanceEO findByPrimaryKey(Integer internalKey) {
        return RbBusAcctBalanceValueUtil.entityToEo(rbBusAcctBalanceMapper.selectByPrimaryKey(internalKey));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusAcctBalanceEO eo) {
        RbBusAcctBalance row = RbBusAcctBalanceValueUtil.eoToEntity(eo);
        return rbBusAcctBalanceMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusAcctBalanceEO eo) {
        RbBusAcctBalance row = RbBusAcctBalanceValueUtil.eoToEntity(eo);
        return rbBusAcctBalanceMapper.updateByPrimaryKey(row);
    }
}