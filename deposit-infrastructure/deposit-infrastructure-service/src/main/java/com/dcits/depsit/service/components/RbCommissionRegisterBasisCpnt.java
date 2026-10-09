package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.CommissionFlag;
import com.dcits.depsit.enums.CommissionRelation;
import com.dcits.depsit.enums.DocType;
import com.dcits.depsit.enums.DocumentType;
import com.dcits.depsit.enums.IssCountry;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbCommissionRegister;
import com.dcits.depsit.entity.RbCommissionRegisterExample;
import com.dcits.depsit.facade.components.IRbCommissionRegisterBcc;
import com.dcits.depsit.facade.eo.RbCommissionRegisterEO;
import com.dcits.depsit.repo.RbCommissionRegisterMapper;
import com.dcits.depsit.service.utils.RbCommissionRegisterValueUtil;
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