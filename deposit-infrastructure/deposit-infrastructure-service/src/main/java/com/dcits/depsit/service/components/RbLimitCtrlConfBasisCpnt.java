package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.CtrlItemType;
import com.dcits.depsit.enums.DealFlow;
import com.dcits.depsit.enums.ResBranchRange;
import com.dcits.depsit.enums.SumType;
import com.dcits.depsit.enums.TermType;
import com.dcits.depsit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbLimitCtrlConf;
import com.dcits.depsit.entity.RbLimitCtrlConfExample;
import com.dcits.depsit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.depsit.facade.eo.RbLimitCtrlConfEO;
import com.dcits.depsit.repo.RbLimitCtrlConfMapper;
import com.dcits.depsit.service.utils.RbLimitCtrlConfValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbLimitCtrlConfBasisCpnt implements IRbLimitCtrlConfBcc {
    @Autowired
    RbLimitCtrlConfMapper rbLimitCtrlConfMapper;

    @Override
    public long countByEo(RbLimitCtrlConfEO eo) {
        RbLimitCtrlConfExample example = RbLimitCtrlConfValueUtil.eoToEntityExample(eo);
        return rbLimitCtrlConfMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbLimitCtrlConfEO eo) {
        RbLimitCtrlConfExample example = RbLimitCtrlConfValueUtil.eoToEntityExample(eo);
        return rbLimitCtrlConfMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String limitBranchId, String limitSceneNo) {
        return rbLimitCtrlConfMapper.deleteByPrimaryKey(limitBranchId, limitSceneNo);
    }

    @Override
    public int create(RbLimitCtrlConfEO eo) {
        RbLimitCtrlConf row = RbLimitCtrlConfValueUtil.eoToEntity(eo);
        return rbLimitCtrlConfMapper.insert(row);
    }

    @Override
    public int createSelective(RbLimitCtrlConfEO eo) {
        RbLimitCtrlConf row = RbLimitCtrlConfValueUtil.eoToEntity(eo);
        return rbLimitCtrlConfMapper.insertSelective(row);
    }

    @Override
    public List<RbLimitCtrlConfEO> findByEo(RbLimitCtrlConfEO eo) {
        RbLimitCtrlConfExample example = RbLimitCtrlConfValueUtil.eoToEntityExample(eo);
        List<RbLimitCtrlConfEO> result = new ArrayList<>();
        List<RbLimitCtrlConf> dbResult = rbLimitCtrlConfMapper.selectByExample(example);
        for (RbLimitCtrlConf item : dbResult) {
            result.add(RbLimitCtrlConfValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbLimitCtrlConfEO findByPrimaryKey(String limitBranchId, String limitSceneNo) {
        return RbLimitCtrlConfValueUtil.entityToEo(rbLimitCtrlConfMapper.selectByPrimaryKey(limitBranchId, limitSceneNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbLimitCtrlConfEO eo) {
        RbLimitCtrlConf row = RbLimitCtrlConfValueUtil.eoToEntity(eo);
        return rbLimitCtrlConfMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbLimitCtrlConfEO eo) {
        RbLimitCtrlConf row = RbLimitCtrlConfValueUtil.eoToEntity(eo);
        return rbLimitCtrlConfMapper.updateByPrimaryKey(row);
    }
}