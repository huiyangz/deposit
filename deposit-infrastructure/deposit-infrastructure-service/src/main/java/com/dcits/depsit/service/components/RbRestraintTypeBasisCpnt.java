package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.AllowRepeatFlag;
import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.LimitBranchRange;
import com.dcits.depsit.enums.RestraintAmtFlag;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.enums.UnMaintBranchRange;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbRestraintType;
import com.dcits.depsit.entity.RbRestraintTypeExample;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import com.dcits.depsit.repo.RbRestraintTypeMapper;
import com.dcits.depsit.service.utils.RbRestraintTypeValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbRestraintTypeBasisCpnt implements IRbRestraintTypeBcc {
    @Autowired
    RbRestraintTypeMapper rbRestraintTypeMapper;

    @Override
    public long countByEo(RbRestraintTypeEO eo) {
        RbRestraintTypeExample example = RbRestraintTypeValueUtil.eoToEntityExample(eo);
        return rbRestraintTypeMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbRestraintTypeEO eo) {
        RbRestraintTypeExample example = RbRestraintTypeValueUtil.eoToEntityExample(eo);
        return rbRestraintTypeMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String restraintType) {
        return rbRestraintTypeMapper.deleteByPrimaryKey(restraintType);
    }

    @Override
    public int create(RbRestraintTypeEO eo) {
        RbRestraintType row = RbRestraintTypeValueUtil.eoToEntity(eo);
        return rbRestraintTypeMapper.insert(row);
    }

    @Override
    public int createSelective(RbRestraintTypeEO eo) {
        RbRestraintType row = RbRestraintTypeValueUtil.eoToEntity(eo);
        return rbRestraintTypeMapper.insertSelective(row);
    }

    @Override
    public List<RbRestraintTypeEO> findByEo(RbRestraintTypeEO eo) {
        RbRestraintTypeExample example = RbRestraintTypeValueUtil.eoToEntityExample(eo);
        List<RbRestraintTypeEO> result = new ArrayList<>();
        List<RbRestraintType> dbResult = rbRestraintTypeMapper.selectByExample(example);
        for (RbRestraintType item : dbResult) {
            result.add(RbRestraintTypeValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbRestraintTypeEO findByPrimaryKey(String restraintType) {
        return RbRestraintTypeValueUtil.entityToEo(rbRestraintTypeMapper.selectByPrimaryKey(restraintType));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbRestraintTypeEO eo) {
        RbRestraintType row = RbRestraintTypeValueUtil.eoToEntity(eo);
        return rbRestraintTypeMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbRestraintTypeEO eo) {
        RbRestraintType row = RbRestraintTypeValueUtil.eoToEntity(eo);
        return rbRestraintTypeMapper.updateByPrimaryKey(row);
    }

    RbRestraintTypeEO byRestraintType(RestraintType restraintType) {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(restraintType);
        return eo;
    }

    /**根据账户限制类型查询表《存款限制类型表(RB_RESTRAINT_TYPE)》**/
    public RbRestraintTypeEO findByRestraintType(RestraintType restraintType) {
        List<RbRestraintTypeEO> eos = findByEo(byRestraintType(restraintType));
        return eos.isEmpty() ? null : eos.get(0);
    }
}