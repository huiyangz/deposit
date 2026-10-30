package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.WithdrawalType;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusClientAcct;
import com.dcits.deposit.entity.RbBusClientAcctExample;
import com.dcits.deposit.facade.components.IRbBusClientAcctBcc;
import com.dcits.deposit.facade.eo.RbBusClientAcctEO;
import com.dcits.deposit.repo.RbBusClientAcctMapper;
import com.dcits.deposit.service.utils.RbBusClientAcctValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusClientAcctBasisCpnt implements IRbBusClientAcctBcc {
    @Autowired
    RbBusClientAcctMapper rbBusClientAcctMapper;

    @Override
    public long countByEo(RbBusClientAcctEO eo) {
        RbBusClientAcctExample example = RbBusClientAcctValueUtil.eoToEntityExample(eo);
        return rbBusClientAcctMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusClientAcctEO eo) {
        RbBusClientAcctExample example = RbBusClientAcctValueUtil.eoToEntityExample(eo);
        return rbBusClientAcctMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String baseAcctNo, String clientNo) {
        return rbBusClientAcctMapper.deleteByPrimaryKey(baseAcctNo, clientNo);
    }

    @Override
    public int create(RbBusClientAcctEO eo) {
        RbBusClientAcct row = RbBusClientAcctValueUtil.eoToEntity(eo);
        return rbBusClientAcctMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusClientAcctEO eo) {
        RbBusClientAcct row = RbBusClientAcctValueUtil.eoToEntity(eo);
        return rbBusClientAcctMapper.insertSelective(row);
    }

    @Override
    public List<RbBusClientAcctEO> findByEo(RbBusClientAcctEO eo) {
        RbBusClientAcctExample example = RbBusClientAcctValueUtil.eoToEntityExample(eo);
        List<RbBusClientAcctEO> result = new ArrayList<>();
        List<RbBusClientAcct> dbResult = rbBusClientAcctMapper.selectByExample(example);
        for (RbBusClientAcct item : dbResult) {
            result.add(RbBusClientAcctValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusClientAcctEO findByPrimaryKey(String baseAcctNo, String clientNo) {
        return RbBusClientAcctValueUtil.entityToEo(rbBusClientAcctMapper.selectByPrimaryKey(baseAcctNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusClientAcctEO eo) {
        RbBusClientAcct row = RbBusClientAcctValueUtil.eoToEntity(eo);
        return rbBusClientAcctMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusClientAcctEO eo) {
        RbBusClientAcct row = RbBusClientAcctValueUtil.eoToEntity(eo);
        return rbBusClientAcctMapper.updateByPrimaryKey(row);
    }
}