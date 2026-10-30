package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.CheckObjType;
import com.dcits.deposit.enums.LimitConvert;
import com.dcits.deposit.enums.LimitMainType;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbLimitSceneDef;
import com.dcits.deposit.entity.RbLimitSceneDefExample;
import com.dcits.deposit.facade.components.IRbLimitSceneDefBcc;
import com.dcits.deposit.facade.eo.RbLimitSceneDefEO;
import com.dcits.deposit.repo.RbLimitSceneDefMapper;
import com.dcits.deposit.service.utils.RbLimitSceneDefValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbLimitSceneDefBasisCpnt implements IRbLimitSceneDefBcc {
    @Autowired
    RbLimitSceneDefMapper rbLimitSceneDefMapper;

    @Override
    public long countByEo(RbLimitSceneDefEO eo) {
        RbLimitSceneDefExample example = RbLimitSceneDefValueUtil.eoToEntityExample(eo);
        return rbLimitSceneDefMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbLimitSceneDefEO eo) {
        RbLimitSceneDefExample example = RbLimitSceneDefValueUtil.eoToEntityExample(eo);
        return rbLimitSceneDefMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String limitCcy, String checkObjType, String lastUpdTimestamp, String limitSceneDesc, String createTimestamp, String validFlag, String limitConvert, String limitMainType) {
        return rbLimitSceneDefMapper.deleteByPrimaryKey(limitCcy, checkObjType, lastUpdTimestamp, limitSceneDesc, createTimestamp, validFlag, limitConvert, limitMainType);
    }

    @Override
    public int create(RbLimitSceneDefEO eo) {
        RbLimitSceneDef row = RbLimitSceneDefValueUtil.eoToEntity(eo);
        return rbLimitSceneDefMapper.insert(row);
    }

    @Override
    public int createSelective(RbLimitSceneDefEO eo) {
        RbLimitSceneDef row = RbLimitSceneDefValueUtil.eoToEntity(eo);
        return rbLimitSceneDefMapper.insertSelective(row);
    }

    @Override
    public List<RbLimitSceneDefEO> findByEo(RbLimitSceneDefEO eo) {
        RbLimitSceneDefExample example = RbLimitSceneDefValueUtil.eoToEntityExample(eo);
        List<RbLimitSceneDefEO> result = new ArrayList<>();
        List<RbLimitSceneDef> dbResult = rbLimitSceneDefMapper.selectByExample(example);
        for (RbLimitSceneDef item : dbResult) {
            result.add(RbLimitSceneDefValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbLimitSceneDefEO findByPrimaryKey(String limitCcy, String checkObjType, String lastUpdTimestamp, String limitSceneDesc, String createTimestamp, String validFlag, String limitConvert, String limitMainType) {
        return RbLimitSceneDefValueUtil.entityToEo(rbLimitSceneDefMapper.selectByPrimaryKey(limitCcy, checkObjType, lastUpdTimestamp, limitSceneDesc, createTimestamp, validFlag, limitConvert, limitMainType));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbLimitSceneDefEO eo) {
        RbLimitSceneDef row = RbLimitSceneDefValueUtil.eoToEntity(eo);
        return rbLimitSceneDefMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbLimitSceneDefEO eo) {
        RbLimitSceneDef row = RbLimitSceneDefValueUtil.eoToEntity(eo);
        return rbLimitSceneDefMapper.updateByPrimaryKey(row);
    }
}