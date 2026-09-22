package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.WithdrawalType;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbClientAcct;
import com.dcits.deposit.entity.RbClientAcctExample;
import com.dcits.deposit.facade.components.IRbClientAcctBcc;
import com.dcits.deposit.facade.eo.RbClientAcctEO;
import com.dcits.deposit.repo.RbClientAcctMapper;
import com.dcits.deposit.service.utils.RbClientAcctValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbClientAcctBasisCpnt implements IRbClientAcctBcc {
    @Autowired
    RbClientAcctMapper rbClientAcctMapper;

    @Override
    public long countByEo(RbClientAcctEO eo) {
        RbClientAcctExample example = RbClientAcctValueUtil.eoToEntityExample(eo);
        return rbClientAcctMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbClientAcctEO eo) {
        RbClientAcctExample example = RbClientAcctValueUtil.eoToEntityExample(eo);
        return rbClientAcctMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String baseAcctNo, String clientNo) {
        return rbClientAcctMapper.deleteByPrimaryKey(baseAcctNo, clientNo);
    }

    @Override
    public int create(RbClientAcctEO eo) {
        RbClientAcct row = RbClientAcctValueUtil.eoToEntity(eo);
        return rbClientAcctMapper.insert(row);
    }

    @Override
    public int createSelective(RbClientAcctEO eo) {
        RbClientAcct row = RbClientAcctValueUtil.eoToEntity(eo);
        return rbClientAcctMapper.insertSelective(row);
    }

    @Override
    public List<RbClientAcctEO> findByEo(RbClientAcctEO eo) {
        RbClientAcctExample example = RbClientAcctValueUtil.eoToEntityExample(eo);
        List<RbClientAcctEO> result = new ArrayList<>();
        List<RbClientAcct> dbResult = rbClientAcctMapper.selectByExample(example);
        for (RbClientAcct item : dbResult) {
            result.add(RbClientAcctValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbClientAcctEO findByPrimaryKey(String baseAcctNo, String clientNo) {
        return RbClientAcctValueUtil.entityToEo(rbClientAcctMapper.selectByPrimaryKey(baseAcctNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbClientAcctEO eo) {
        RbClientAcct row = RbClientAcctValueUtil.eoToEntity(eo);
        return rbClientAcctMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbClientAcctEO eo) {
        RbClientAcct row = RbClientAcctValueUtil.eoToEntity(eo);
        return rbClientAcctMapper.updateByPrimaryKey(row);
    }
}