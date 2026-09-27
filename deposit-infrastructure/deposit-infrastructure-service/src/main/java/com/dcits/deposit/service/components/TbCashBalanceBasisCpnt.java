package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.TranBranch;
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
    public int removeByPrimaryKey(String tranTimestamp, Date updateDate, String branch, BigDecimal eopdAmount, String tailboxId, BigDecimal availableAmt, BigDecimal sopdAmount, BigDecimal lockAmount, String company, BigDecimal amount, String ccy, BigDecimal lockSpallAmt, Integer cashId, Date lastChangeDate, String createTimestamp) {
        return tbCashBalanceMapper.deleteByPrimaryKey(tranTimestamp, updateDate, branch, eopdAmount, tailboxId, availableAmt, sopdAmount, lockAmount, company, amount, ccy, lockSpallAmt, cashId, lastChangeDate, createTimestamp);
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
    public TbCashBalanceEO findByPrimaryKey(String tranTimestamp, Date updateDate, String branch, BigDecimal eopdAmount, String tailboxId, BigDecimal availableAmt, BigDecimal sopdAmount, BigDecimal lockAmount, String company, BigDecimal amount, String ccy, BigDecimal lockSpallAmt, Integer cashId, Date lastChangeDate, String createTimestamp) {
        return TbCashBalanceValueUtil.entityToEo(tbCashBalanceMapper.selectByPrimaryKey(tranTimestamp, updateDate, branch, eopdAmount, tailboxId, availableAmt, sopdAmount, lockAmount, company, amount, ccy, lockSpallAmt, cashId, lastChangeDate, createTimestamp));
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