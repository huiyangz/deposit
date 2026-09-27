package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.CommissionFlag;
import com.dcits.deposit.enums.CommissionRelation;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbCommissionRegister;
import com.dcits.deposit.entity.RbCommissionRegisterExample;
import com.dcits.deposit.facade.components.IRbCommissionRegisterBcc;
import com.dcits.deposit.facade.eo.RbCommissionRegisterEO;
import com.dcits.deposit.repo.RbCommissionRegisterMapper;
import com.dcits.deposit.service.utils.RbCommissionRegisterValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbCommissionRegisterBasisCpnt implements IRbCommissionRegisterBcc {
    @Autowired
    RbCommissionRegisterMapper rbCommissionRegisterMapper;

    @Override
    public long countByEo(RbCommissionRegisterEO eo) {
        RbCommissionRegisterExample example = RbCommissionRegisterValueUtil.eoToEntityExample(eo);
        return rbCommissionRegisterMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbCommissionRegisterEO eo) {
        RbCommissionRegisterExample example = RbCommissionRegisterValueUtil.eoToEntityExample(eo);
        return rbCommissionRegisterMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String channelSeqNo, String clientNo) {
        return rbCommissionRegisterMapper.deleteByPrimaryKey(channelSeqNo, clientNo);
    }

    @Override
    public int create(RbCommissionRegisterEO eo) {
        RbCommissionRegister row = RbCommissionRegisterValueUtil.eoToEntity(eo);
        return rbCommissionRegisterMapper.insert(row);
    }

    @Override
    public int createSelective(RbCommissionRegisterEO eo) {
        RbCommissionRegister row = RbCommissionRegisterValueUtil.eoToEntity(eo);
        return rbCommissionRegisterMapper.insertSelective(row);
    }

    @Override
    public List<RbCommissionRegisterEO> findByEo(RbCommissionRegisterEO eo) {
        RbCommissionRegisterExample example = RbCommissionRegisterValueUtil.eoToEntityExample(eo);
        List<RbCommissionRegisterEO> result = new ArrayList<>();
        List<RbCommissionRegister> dbResult = rbCommissionRegisterMapper.selectByExample(example);
        for (RbCommissionRegister item : dbResult) {
            result.add(RbCommissionRegisterValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbCommissionRegisterEO findByPrimaryKey(String channelSeqNo, String clientNo) {
        return RbCommissionRegisterValueUtil.entityToEo(rbCommissionRegisterMapper.selectByPrimaryKey(channelSeqNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbCommissionRegisterEO eo) {
        RbCommissionRegister row = RbCommissionRegisterValueUtil.eoToEntity(eo);
        return rbCommissionRegisterMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbCommissionRegisterEO eo) {
        RbCommissionRegister row = RbCommissionRegisterValueUtil.eoToEntity(eo);
        return rbCommissionRegisterMapper.updateByPrimaryKey(row);
    }
}