package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ControlClass;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.TranType;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbControlTranRelation;
import com.dcits.deposit.entity.RbControlTranRelationExample;
import com.dcits.deposit.facade.components.IRbControlTranRelationBcc;
import com.dcits.deposit.facade.eo.RbControlTranRelationEO;
import com.dcits.deposit.repo.RbControlTranRelationMapper;
import com.dcits.deposit.service.utils.RbControlTranRelationValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbControlTranRelationBasisCpnt implements IRbControlTranRelationBcc {
    @Autowired
    RbControlTranRelationMapper rbControlTranRelationMapper;

    @Override
    public long countByEo(RbControlTranRelationEO eo) {
        RbControlTranRelationExample example = RbControlTranRelationValueUtil.eoToEntityExample(eo);
        return rbControlTranRelationMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbControlTranRelationEO eo) {
        RbControlTranRelationExample example = RbControlTranRelationValueUtil.eoToEntityExample(eo);
        return rbControlTranRelationMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String controlClass, String tranType, String serviceNo) {
        return rbControlTranRelationMapper.deleteByPrimaryKey(controlClass, tranType, serviceNo);
    }

    @Override
    public int create(RbControlTranRelationEO eo) {
        RbControlTranRelation row = RbControlTranRelationValueUtil.eoToEntity(eo);
        return rbControlTranRelationMapper.insert(row);
    }

    @Override
    public int createSelective(RbControlTranRelationEO eo) {
        RbControlTranRelation row = RbControlTranRelationValueUtil.eoToEntity(eo);
        return rbControlTranRelationMapper.insertSelective(row);
    }

    @Override
    public List<RbControlTranRelationEO> findByEo(RbControlTranRelationEO eo) {
        RbControlTranRelationExample example = RbControlTranRelationValueUtil.eoToEntityExample(eo);
        List<RbControlTranRelationEO> result = new ArrayList<>();
        List<RbControlTranRelation> dbResult = rbControlTranRelationMapper.selectByExample(example);
        for (RbControlTranRelation item : dbResult) {
            result.add(RbControlTranRelationValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbControlTranRelationEO findByPrimaryKey(String controlClass, String tranType, String serviceNo) {
        return RbControlTranRelationValueUtil.entityToEo(rbControlTranRelationMapper.selectByPrimaryKey(controlClass, tranType, serviceNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbControlTranRelationEO eo) {
        RbControlTranRelation row = RbControlTranRelationValueUtil.eoToEntity(eo);
        return rbControlTranRelationMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbControlTranRelationEO eo) {
        RbControlTranRelation row = RbControlTranRelationValueUtil.eoToEntity(eo);
        return rbControlTranRelationMapper.updateByPrimaryKey(row);
    }
}