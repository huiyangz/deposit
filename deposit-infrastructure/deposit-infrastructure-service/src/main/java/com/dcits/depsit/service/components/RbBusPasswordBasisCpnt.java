package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.PasswordStatus;
import com.dcits.depsit.enums.PwdType;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbBusPassword;
import com.dcits.depsit.entity.RbBusPasswordExample;
import com.dcits.depsit.facade.components.IRbBusPasswordBcc;
import com.dcits.depsit.facade.eo.RbBusPasswordEO;
import com.dcits.depsit.repo.RbBusPasswordMapper;
import com.dcits.depsit.service.utils.RbBusPasswordValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusPasswordBasisCpnt implements IRbBusPasswordBcc {
    @Autowired
    RbBusPasswordMapper rbBusPasswordMapper;

    @Override
    public long countByEo(RbBusPasswordEO eo) {
        RbBusPasswordExample example = RbBusPasswordValueUtil.eoToEntityExample(eo);
        return rbBusPasswordMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusPasswordEO eo) {
        RbBusPasswordExample example = RbBusPasswordValueUtil.eoToEntityExample(eo);
        return rbBusPasswordMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer internalKey, String pwdType, String pwdKey) {
        return rbBusPasswordMapper.deleteByPrimaryKey(internalKey, pwdType, pwdKey);
    }

    @Override
    public int create(RbBusPasswordEO eo) {
        RbBusPassword row = RbBusPasswordValueUtil.eoToEntity(eo);
        return rbBusPasswordMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusPasswordEO eo) {
        RbBusPassword row = RbBusPasswordValueUtil.eoToEntity(eo);
        return rbBusPasswordMapper.insertSelective(row);
    }

    @Override
    public List<RbBusPasswordEO> findByEo(RbBusPasswordEO eo) {
        RbBusPasswordExample example = RbBusPasswordValueUtil.eoToEntityExample(eo);
        List<RbBusPasswordEO> result = new ArrayList<>();
        List<RbBusPassword> dbResult = rbBusPasswordMapper.selectByExample(example);
        for (RbBusPassword item : dbResult) {
            result.add(RbBusPasswordValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusPasswordEO findByPrimaryKey(Integer internalKey, String pwdType, String pwdKey) {
        return RbBusPasswordValueUtil.entityToEo(rbBusPasswordMapper.selectByPrimaryKey(internalKey, pwdType, pwdKey));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusPasswordEO eo) {
        RbBusPassword row = RbBusPasswordValueUtil.eoToEntity(eo);
        return rbBusPasswordMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusPasswordEO eo) {
        RbBusPassword row = RbBusPasswordValueUtil.eoToEntity(eo);
        return rbBusPasswordMapper.updateByPrimaryKey(row);
    }
}