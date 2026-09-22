package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.Status;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbTranSceneMapping;
import com.dcits.deposit.entity.RbTranSceneMappingExample;
import com.dcits.deposit.facade.components.IRbTranSceneMappingBcc;
import com.dcits.deposit.facade.eo.RbTranSceneMappingEO;
import com.dcits.deposit.repo.RbTranSceneMappingMapper;
import com.dcits.deposit.service.utils.RbTranSceneMappingValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbTranSceneMappingBasisCpnt implements IRbTranSceneMappingBcc {
    @Autowired
    RbTranSceneMappingMapper rbTranSceneMappingMapper;

    @Override
    public long countByEo(RbTranSceneMappingEO eo) {
        RbTranSceneMappingExample example = RbTranSceneMappingValueUtil.eoToEntityExample(eo);
        return rbTranSceneMappingMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbTranSceneMappingEO eo) {
        RbTranSceneMappingExample example = RbTranSceneMappingValueUtil.eoToEntityExample(eo);
        return rbTranSceneMappingMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String tranScene) {
        return rbTranSceneMappingMapper.deleteByPrimaryKey(tranScene);
    }

    @Override
    public int create(RbTranSceneMappingEO eo) {
        RbTranSceneMapping row = RbTranSceneMappingValueUtil.eoToEntity(eo);
        return rbTranSceneMappingMapper.insert(row);
    }

    @Override
    public int createSelective(RbTranSceneMappingEO eo) {
        RbTranSceneMapping row = RbTranSceneMappingValueUtil.eoToEntity(eo);
        return rbTranSceneMappingMapper.insertSelective(row);
    }

    @Override
    public List<RbTranSceneMappingEO> findByEo(RbTranSceneMappingEO eo) {
        RbTranSceneMappingExample example = RbTranSceneMappingValueUtil.eoToEntityExample(eo);
        List<RbTranSceneMappingEO> result = new ArrayList<>();
        List<RbTranSceneMapping> dbResult = rbTranSceneMappingMapper.selectByExample(example);
        for (RbTranSceneMapping item : dbResult) {
            result.add(RbTranSceneMappingValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbTranSceneMappingEO findByPrimaryKey(String tranScene) {
        return RbTranSceneMappingValueUtil.entityToEo(rbTranSceneMappingMapper.selectByPrimaryKey(tranScene));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbTranSceneMappingEO eo) {
        RbTranSceneMapping row = RbTranSceneMappingValueUtil.eoToEntity(eo);
        return rbTranSceneMappingMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbTranSceneMappingEO eo) {
        RbTranSceneMapping row = RbTranSceneMappingValueUtil.eoToEntity(eo);
        return rbTranSceneMappingMapper.updateByPrimaryKey(row);
    }
}