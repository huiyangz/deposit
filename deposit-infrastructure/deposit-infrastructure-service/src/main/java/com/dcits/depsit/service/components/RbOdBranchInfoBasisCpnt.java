package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbOdBranchInfo;
import com.dcits.depsit.entity.RbOdBranchInfoExample;
import com.dcits.depsit.facade.components.IRbOdBranchInfoBcc;
import com.dcits.depsit.facade.eo.RbOdBranchInfoEO;
import com.dcits.depsit.repo.RbOdBranchInfoMapper;
import com.dcits.depsit.service.utils.RbOdBranchInfoValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbOdBranchInfoBasisCpnt implements IRbOdBranchInfoBcc {
    @Autowired
    RbOdBranchInfoMapper rbOdBranchInfoMapper;

    @Override
    public long countByEo(RbOdBranchInfoEO eo) {
        RbOdBranchInfoExample example = RbOdBranchInfoValueUtil.eoToEntityExample(eo);
        return rbOdBranchInfoMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbOdBranchInfoEO eo) {
        RbOdBranchInfoExample example = RbOdBranchInfoValueUtil.eoToEntityExample(eo);
        return rbOdBranchInfoMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Date lastChangeDate, BigDecimal usedAmt, String createTimestamp, String branch, String tranTimestamp, String company, BigDecimal totalLimit) {
        return rbOdBranchInfoMapper.deleteByPrimaryKey(lastChangeDate, usedAmt, createTimestamp, branch, tranTimestamp, company, totalLimit);
    }

    @Override
    public int create(RbOdBranchInfoEO eo) {
        RbOdBranchInfo row = RbOdBranchInfoValueUtil.eoToEntity(eo);
        return rbOdBranchInfoMapper.insert(row);
    }

    @Override
    public int createSelective(RbOdBranchInfoEO eo) {
        RbOdBranchInfo row = RbOdBranchInfoValueUtil.eoToEntity(eo);
        return rbOdBranchInfoMapper.insertSelective(row);
    }

    @Override
    public List<RbOdBranchInfoEO> findByEo(RbOdBranchInfoEO eo) {
        RbOdBranchInfoExample example = RbOdBranchInfoValueUtil.eoToEntityExample(eo);
        List<RbOdBranchInfoEO> result = new ArrayList<>();
        List<RbOdBranchInfo> dbResult = rbOdBranchInfoMapper.selectByExample(example);
        for (RbOdBranchInfo item : dbResult) {
            result.add(RbOdBranchInfoValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbOdBranchInfoEO findByPrimaryKey(Date lastChangeDate, BigDecimal usedAmt, String createTimestamp, String branch, String tranTimestamp, String company, BigDecimal totalLimit) {
        return RbOdBranchInfoValueUtil.entityToEo(rbOdBranchInfoMapper.selectByPrimaryKey(lastChangeDate, usedAmt, createTimestamp, branch, tranTimestamp, company, totalLimit));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbOdBranchInfoEO eo) {
        RbOdBranchInfo row = RbOdBranchInfoValueUtil.eoToEntity(eo);
        return rbOdBranchInfoMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbOdBranchInfoEO eo) {
        RbOdBranchInfo row = RbOdBranchInfoValueUtil.eoToEntity(eo);
        return rbOdBranchInfoMapper.updateByPrimaryKey(row);
    }
}