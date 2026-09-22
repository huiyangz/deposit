package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ControlClass;
import com.dcits.deposit.enums.ControlType;
import com.dcits.deposit.enums.IndividualFlag;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbControlTypeDef;
import com.dcits.deposit.entity.RbControlTypeDefExample;
import com.dcits.deposit.facade.components.IRbControlTypeDefBcc;
import com.dcits.deposit.facade.eo.RbControlTypeDefEO;
import com.dcits.deposit.repo.RbControlTypeDefMapper;
import com.dcits.deposit.service.utils.RbControlTypeDefValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbControlTypeDefBasisCpnt implements IRbControlTypeDefBcc {
    @Autowired
    RbControlTypeDefMapper rbControlTypeDefMapper;

    @Override
    public long countByEo(RbControlTypeDefEO eo) {
        RbControlTypeDefExample example = RbControlTypeDefValueUtil.eoToEntityExample(eo);
        return rbControlTypeDefMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbControlTypeDefEO eo) {
        RbControlTypeDefExample example = RbControlTypeDefValueUtil.eoToEntityExample(eo);
        return rbControlTypeDefMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String controlType, String controlClass) {
        return rbControlTypeDefMapper.deleteByPrimaryKey(controlType, controlClass);
    }

    @Override
    public int create(RbControlTypeDefEO eo) {
        RbControlTypeDef row = RbControlTypeDefValueUtil.eoToEntity(eo);
        return rbControlTypeDefMapper.insert(row);
    }

    @Override
    public int createSelective(RbControlTypeDefEO eo) {
        RbControlTypeDef row = RbControlTypeDefValueUtil.eoToEntity(eo);
        return rbControlTypeDefMapper.insertSelective(row);
    }

    @Override
    public List<RbControlTypeDefEO> findByEo(RbControlTypeDefEO eo) {
        RbControlTypeDefExample example = RbControlTypeDefValueUtil.eoToEntityExample(eo);
        List<RbControlTypeDefEO> result = new ArrayList<>();
        List<RbControlTypeDef> dbResult = rbControlTypeDefMapper.selectByExample(example);
        for (RbControlTypeDef item : dbResult) {
            result.add(RbControlTypeDefValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbControlTypeDefEO findByPrimaryKey(String controlType, String controlClass) {
        return RbControlTypeDefValueUtil.entityToEo(rbControlTypeDefMapper.selectByPrimaryKey(controlType, controlClass));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbControlTypeDefEO eo) {
        RbControlTypeDef row = RbControlTypeDefValueUtil.eoToEntity(eo);
        return rbControlTypeDefMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbControlTypeDefEO eo) {
        RbControlTypeDef row = RbControlTypeDefValueUtil.eoToEntity(eo);
        return rbControlTypeDefMapper.updateByPrimaryKey(row);
    }
}