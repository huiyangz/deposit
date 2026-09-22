package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.BankInOut;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.PayRecInd;
import com.dcits.deposit.enums.SettleAcctClass;
import com.dcits.deposit.enums.SettleBankFlag;
import com.dcits.deposit.enums.SettleMethod;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAcctSettle;
import com.dcits.deposit.entity.RbAcctSettleExample;
import com.dcits.deposit.facade.components.IRbAcctSettleBcc;
import com.dcits.deposit.facade.eo.RbAcctSettleEO;
import com.dcits.deposit.repo.RbAcctSettleMapper;
import com.dcits.deposit.service.utils.RbAcctSettleValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAcctSettleBasisCpnt implements IRbAcctSettleBcc {
    @Autowired
    RbAcctSettleMapper rbAcctSettleMapper;

    @Override
    public long countByEo(RbAcctSettleEO eo) {
        RbAcctSettleExample example = RbAcctSettleValueUtil.eoToEntityExample(eo);
        return rbAcctSettleMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAcctSettleEO eo) {
        RbAcctSettleExample example = RbAcctSettleValueUtil.eoToEntityExample(eo);
        return rbAcctSettleMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer internalKey, String settleNo, String clientNo) {
        return rbAcctSettleMapper.deleteByPrimaryKey(internalKey, settleNo, clientNo);
    }

    @Override
    public int create(RbAcctSettleEO eo) {
        RbAcctSettle row = RbAcctSettleValueUtil.eoToEntity(eo);
        return rbAcctSettleMapper.insert(row);
    }

    @Override
    public int createSelective(RbAcctSettleEO eo) {
        RbAcctSettle row = RbAcctSettleValueUtil.eoToEntity(eo);
        return rbAcctSettleMapper.insertSelective(row);
    }

    @Override
    public List<RbAcctSettleEO> findByEo(RbAcctSettleEO eo) {
        RbAcctSettleExample example = RbAcctSettleValueUtil.eoToEntityExample(eo);
        List<RbAcctSettleEO> result = new ArrayList<>();
        List<RbAcctSettle> dbResult = rbAcctSettleMapper.selectByExample(example);
        for (RbAcctSettle item : dbResult) {
            result.add(RbAcctSettleValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAcctSettleEO findByPrimaryKey(Integer internalKey, String settleNo, String clientNo) {
        return RbAcctSettleValueUtil.entityToEo(rbAcctSettleMapper.selectByPrimaryKey(internalKey, settleNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAcctSettleEO eo) {
        RbAcctSettle row = RbAcctSettleValueUtil.eoToEntity(eo);
        return rbAcctSettleMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAcctSettleEO eo) {
        RbAcctSettle row = RbAcctSettleValueUtil.eoToEntity(eo);
        return rbAcctSettleMapper.updateByPrimaryKey(row);
    }
}