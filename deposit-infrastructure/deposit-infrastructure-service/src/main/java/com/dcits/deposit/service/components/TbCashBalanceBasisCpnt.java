package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.TbCashBalance;
import com.dcits.deposit.entity.TbCashBalanceExample;
import com.dcits.deposit.facade.components.ITbCashBalanceBcc;
import com.dcits.deposit.facade.eo.TbCashBalanceEO;
import com.dcits.deposit.repo.TbCashBalanceMapper;
import com.dcits.deposit.service.utils.TbCashBalanceValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TbCashBalanceBasisCpnt implements ITbCashBalanceBcc {
    @Autowired
    TbCashBalanceMapper tbCashBalanceMapper;

    @Override
    public long countByEo(TbCashBalanceEO eo) {
        TbCashBalanceExample example = TbCashBalanceValueUtil.eoToEntityExample(eo);
        return tbCashBalanceMapper.countByExample(example);
    }

    @Override
    public int removeByEo(TbCashBalanceEO eo) {
        TbCashBalanceExample example = TbCashBalanceValueUtil.eoToEntityExample(eo);
        return tbCashBalanceMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer cashId) {
        return tbCashBalanceMapper.deleteByPrimaryKey(cashId);
    }

    @Override
    public int create(TbCashBalanceEO eo) {
        TbCashBalance row = TbCashBalanceValueUtil.eoToEntity(eo);
        return tbCashBalanceMapper.insert(row);
    }

    @Override
    public int createSelective(TbCashBalanceEO eo) {
        TbCashBalance row = TbCashBalanceValueUtil.eoToEntity(eo);
        return tbCashBalanceMapper.insertSelective(row);
    }

    @Override
    public List<TbCashBalanceEO> findByEo(TbCashBalanceEO eo) {
        TbCashBalanceExample example = TbCashBalanceValueUtil.eoToEntityExample(eo);
        List<TbCashBalanceEO> result = new ArrayList<>();
        List<TbCashBalance> dbResult = tbCashBalanceMapper.selectByExample(example);
        for (TbCashBalance item : dbResult) {
            result.add(TbCashBalanceValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public TbCashBalanceEO findByPrimaryKey(Integer cashId) {
        return TbCashBalanceValueUtil.entityToEo(tbCashBalanceMapper.selectByPrimaryKey(cashId));
    }

    @Override
    public int modifyByPrimaryKeySelective(TbCashBalanceEO eo) {
        TbCashBalance row = TbCashBalanceValueUtil.eoToEntity(eo);
        return tbCashBalanceMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(TbCashBalanceEO eo) {
        TbCashBalance row = TbCashBalanceValueUtil.eoToEntity(eo);
        return tbCashBalanceMapper.updateByPrimaryKey(row);
    }
}