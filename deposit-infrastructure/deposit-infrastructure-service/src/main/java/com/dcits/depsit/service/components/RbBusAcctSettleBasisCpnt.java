package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.BankInOut;
import com.dcits.depsit.enums.Ccy;
import com.dcits.depsit.enums.IntCalcAmtType;
import com.dcits.depsit.enums.PayRecInd;
import com.dcits.depsit.enums.SettleAcctClass;
import com.dcits.depsit.enums.SettleBankFlag;
import com.dcits.depsit.enums.SettleMethod;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbBusAcctSettle;
import com.dcits.depsit.entity.RbBusAcctSettleExample;
import com.dcits.depsit.facade.components.IRbBusAcctSettleBcc;
import com.dcits.depsit.facade.eo.RbBusAcctSettleEO;
import com.dcits.depsit.repo.RbBusAcctSettleMapper;
import com.dcits.depsit.service.utils.RbBusAcctSettleValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusAcctSettleBasisCpnt implements IRbBusAcctSettleBcc {
    @Autowired
    RbBusAcctSettleMapper rbBusAcctSettleMapper;

    @Override
    public long countByEo(RbBusAcctSettleEO eo) {
        RbBusAcctSettleExample example = RbBusAcctSettleValueUtil.eoToEntityExample(eo);
        return rbBusAcctSettleMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusAcctSettleEO eo) {
        RbBusAcctSettleExample example = RbBusAcctSettleValueUtil.eoToEntityExample(eo);
        return rbBusAcctSettleMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer internalKey, String settleNo) {
        return rbBusAcctSettleMapper.deleteByPrimaryKey(internalKey, settleNo);
    }

    @Override
    public int create(RbBusAcctSettleEO eo) {
        RbBusAcctSettle row = RbBusAcctSettleValueUtil.eoToEntity(eo);
        return rbBusAcctSettleMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusAcctSettleEO eo) {
        RbBusAcctSettle row = RbBusAcctSettleValueUtil.eoToEntity(eo);
        return rbBusAcctSettleMapper.insertSelective(row);
    }

    @Override
    public List<RbBusAcctSettleEO> findByEo(RbBusAcctSettleEO eo) {
        RbBusAcctSettleExample example = RbBusAcctSettleValueUtil.eoToEntityExample(eo);
        List<RbBusAcctSettleEO> result = new ArrayList<>();
        List<RbBusAcctSettle> dbResult = rbBusAcctSettleMapper.selectByExample(example);
        for (RbBusAcctSettle item : dbResult) {
            result.add(RbBusAcctSettleValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusAcctSettleEO findByPrimaryKey(Integer internalKey, String settleNo) {
        return RbBusAcctSettleValueUtil.entityToEo(rbBusAcctSettleMapper.selectByPrimaryKey(internalKey, settleNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusAcctSettleEO eo) {
        RbBusAcctSettle row = RbBusAcctSettleValueUtil.eoToEntity(eo);
        return rbBusAcctSettleMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusAcctSettleEO eo) {
        RbBusAcctSettle row = RbBusAcctSettleValueUtil.eoToEntity(eo);
        return rbBusAcctSettleMapper.updateByPrimaryKey(row);
    }
}