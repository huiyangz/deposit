package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.LimitBranchRange;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbRestraintControlDetails;
import com.dcits.depsit.entity.RbRestraintControlDetailsExample;
import com.dcits.depsit.facade.components.IRbRestraintControlDetailsBcc;
import com.dcits.depsit.facade.eo.RbRestraintControlDetailsEO;
import com.dcits.depsit.repo.RbRestraintControlDetailsMapper;
import com.dcits.depsit.service.utils.RbRestraintControlDetailsValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbRestraintControlDetailsBasisCpnt implements IRbRestraintControlDetailsBcc {
    @Autowired
    RbRestraintControlDetailsMapper rbRestraintControlDetailsMapper;

    @Override
    public long countByEo(RbRestraintControlDetailsEO eo) {
        RbRestraintControlDetailsExample example = RbRestraintControlDetailsValueUtil.eoToEntityExample(eo);
        return rbRestraintControlDetailsMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbRestraintControlDetailsEO eo) {
        RbRestraintControlDetailsExample example = RbRestraintControlDetailsValueUtil.eoToEntityExample(eo);
        return rbRestraintControlDetailsMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String prodNo, String expression, String tranTypeLink, String restraintType, String batchFlag, String counterFlag) {
        return rbRestraintControlDetailsMapper.deleteByPrimaryKey(prodNo, expression, tranTypeLink, restraintType, batchFlag, counterFlag);
    }

    @Override
    public int create(RbRestraintControlDetailsEO eo) {
        RbRestraintControlDetails row = RbRestraintControlDetailsValueUtil.eoToEntity(eo);
        return rbRestraintControlDetailsMapper.insert(row);
    }

    @Override
    public int createSelective(RbRestraintControlDetailsEO eo) {
        RbRestraintControlDetails row = RbRestraintControlDetailsValueUtil.eoToEntity(eo);
        return rbRestraintControlDetailsMapper.insertSelective(row);
    }

    @Override
    public List<RbRestraintControlDetailsEO> findByEo(RbRestraintControlDetailsEO eo) {
        RbRestraintControlDetailsExample example = RbRestraintControlDetailsValueUtil.eoToEntityExample(eo);
        List<RbRestraintControlDetailsEO> result = new ArrayList<>();
        List<RbRestraintControlDetails> dbResult = rbRestraintControlDetailsMapper.selectByExample(example);
        for (RbRestraintControlDetails item : dbResult) {
            result.add(RbRestraintControlDetailsValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbRestraintControlDetailsEO findByPrimaryKey(String prodNo, String expression, String tranTypeLink, String restraintType, String batchFlag, String counterFlag) {
        return RbRestraintControlDetailsValueUtil.entityToEo(rbRestraintControlDetailsMapper.selectByPrimaryKey(prodNo, expression, tranTypeLink, restraintType, batchFlag, counterFlag));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbRestraintControlDetailsEO eo) {
        RbRestraintControlDetails row = RbRestraintControlDetailsValueUtil.eoToEntity(eo);
        return rbRestraintControlDetailsMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbRestraintControlDetailsEO eo) {
        RbRestraintControlDetails row = RbRestraintControlDetailsValueUtil.eoToEntity(eo);
        return rbRestraintControlDetailsMapper.updateByPrimaryKey(row);
    }
}