package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.WithdrawalType;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAcctWithdrawType;
import com.dcits.deposit.entity.RbAcctWithdrawTypeExample;
import com.dcits.deposit.facade.components.IRbAcctWithdrawTypeBcc;
import com.dcits.deposit.facade.eo.RbAcctWithdrawTypeEO;
import com.dcits.deposit.repo.RbAcctWithdrawTypeMapper;
import com.dcits.deposit.service.utils.RbAcctWithdrawTypeValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAcctWithdrawTypeBasisCpnt implements IRbAcctWithdrawTypeBcc {
    @Autowired
    RbAcctWithdrawTypeMapper rbAcctWithdrawTypeMapper;

    @Override
    public long countByEo(RbAcctWithdrawTypeEO eo) {
        RbAcctWithdrawTypeExample example = RbAcctWithdrawTypeValueUtil.eoToEntityExample(eo);
        return rbAcctWithdrawTypeMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAcctWithdrawTypeEO eo) {
        RbAcctWithdrawTypeExample example = RbAcctWithdrawTypeValueUtil.eoToEntityExample(eo);
        return rbAcctWithdrawTypeMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String withdrawKey, String withdrawalType, String clientNo) {
        return rbAcctWithdrawTypeMapper.deleteByPrimaryKey(withdrawKey, withdrawalType, clientNo);
    }

    @Override
    public int create(RbAcctWithdrawTypeEO eo) {
        RbAcctWithdrawType row = RbAcctWithdrawTypeValueUtil.eoToEntity(eo);
        return rbAcctWithdrawTypeMapper.insert(row);
    }

    @Override
    public int createSelective(RbAcctWithdrawTypeEO eo) {
        RbAcctWithdrawType row = RbAcctWithdrawTypeValueUtil.eoToEntity(eo);
        return rbAcctWithdrawTypeMapper.insertSelective(row);
    }

    @Override
    public List<RbAcctWithdrawTypeEO> findByEo(RbAcctWithdrawTypeEO eo) {
        RbAcctWithdrawTypeExample example = RbAcctWithdrawTypeValueUtil.eoToEntityExample(eo);
        List<RbAcctWithdrawTypeEO> result = new ArrayList<>();
        List<RbAcctWithdrawType> dbResult = rbAcctWithdrawTypeMapper.selectByExample(example);
        for (RbAcctWithdrawType item : dbResult) {
            result.add(RbAcctWithdrawTypeValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAcctWithdrawTypeEO findByPrimaryKey(String withdrawKey, String withdrawalType, String clientNo) {
        return RbAcctWithdrawTypeValueUtil.entityToEo(rbAcctWithdrawTypeMapper.selectByPrimaryKey(withdrawKey, withdrawalType, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAcctWithdrawTypeEO eo) {
        RbAcctWithdrawType row = RbAcctWithdrawTypeValueUtil.eoToEntity(eo);
        return rbAcctWithdrawTypeMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAcctWithdrawTypeEO eo) {
        RbAcctWithdrawType row = RbAcctWithdrawTypeValueUtil.eoToEntity(eo);
        return rbAcctWithdrawTypeMapper.updateByPrimaryKey(row);
    }
}