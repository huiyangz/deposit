package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbLimitElementDef;
import com.dcits.deposit.entity.RbLimitElementDefExample;
import com.dcits.deposit.facade.components.IRbLimitElementDefBcc;
import com.dcits.deposit.facade.eo.RbLimitElementDefEO;
import com.dcits.deposit.repo.RbLimitElementDefMapper;
import com.dcits.deposit.service.utils.RbLimitElementDefValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbLimitElementDefBasisCpnt implements IRbLimitElementDefBcc {
    @Autowired
    RbLimitElementDefMapper rbLimitElementDefMapper;

    @Override
    public long countByEo(RbLimitElementDefEO eo) {
        RbLimitElementDefExample example = RbLimitElementDefValueUtil.eoToEntityExample(eo);
        return rbLimitElementDefMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbLimitElementDefEO eo) {
        RbLimitElementDefExample example = RbLimitElementDefValueUtil.eoToEntityExample(eo);
        return rbLimitElementDefMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String elementId) {
        return rbLimitElementDefMapper.deleteByPrimaryKey(elementId);
    }

    @Override
    public int create(RbLimitElementDefEO eo) {
        RbLimitElementDef row = RbLimitElementDefValueUtil.eoToEntity(eo);
        return rbLimitElementDefMapper.insert(row);
    }

    @Override
    public int createSelective(RbLimitElementDefEO eo) {
        RbLimitElementDef row = RbLimitElementDefValueUtil.eoToEntity(eo);
        return rbLimitElementDefMapper.insertSelective(row);
    }

    @Override
    public List<RbLimitElementDefEO> findByEo(RbLimitElementDefEO eo) {
        RbLimitElementDefExample example = RbLimitElementDefValueUtil.eoToEntityExample(eo);
        List<RbLimitElementDefEO> result = new ArrayList<>();
        List<RbLimitElementDef> dbResult = rbLimitElementDefMapper.selectByExample(example);
        for (RbLimitElementDef item : dbResult) {
            result.add(RbLimitElementDefValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbLimitElementDefEO findByPrimaryKey(String elementId) {
        return RbLimitElementDefValueUtil.entityToEo(rbLimitElementDefMapper.selectByPrimaryKey(elementId));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbLimitElementDefEO eo) {
        RbLimitElementDef row = RbLimitElementDefValueUtil.eoToEntity(eo);
        return rbLimitElementDefMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbLimitElementDefEO eo) {
        RbLimitElementDef row = RbLimitElementDefValueUtil.eoToEntity(eo);
        return rbLimitElementDefMapper.updateByPrimaryKey(row);
    }
}