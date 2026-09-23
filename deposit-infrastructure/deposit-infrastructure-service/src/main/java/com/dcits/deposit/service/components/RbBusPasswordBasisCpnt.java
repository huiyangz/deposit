package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.PasswordStatus;
import com.dcits.deposit.enums.PwdType;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusPassword;
import com.dcits.deposit.entity.RbBusPasswordExample;
import com.dcits.deposit.facade.components.IRbBusPasswordBcc;
import com.dcits.deposit.facade.eo.RbBusPasswordEO;
import com.dcits.deposit.repo.RbBusPasswordMapper;
import com.dcits.deposit.service.utils.RbBusPasswordValueUtil;
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