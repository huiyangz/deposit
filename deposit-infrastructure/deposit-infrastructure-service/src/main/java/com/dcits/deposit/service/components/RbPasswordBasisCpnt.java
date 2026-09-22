package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.PasswordStatus;
import com.dcits.deposit.enums.PwdType;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbPassword;
import com.dcits.deposit.entity.RbPasswordExample;
import com.dcits.deposit.facade.components.IRbPasswordBcc;
import com.dcits.deposit.facade.eo.RbPasswordEO;
import com.dcits.deposit.repo.RbPasswordMapper;
import com.dcits.deposit.service.utils.RbPasswordValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbPasswordBasisCpnt implements IRbPasswordBcc {
    @Autowired
    RbPasswordMapper rbPasswordMapper;

    @Override
    public long countByEo(RbPasswordEO eo) {
        RbPasswordExample example = RbPasswordValueUtil.eoToEntityExample(eo);
        return rbPasswordMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbPasswordEO eo) {
        RbPasswordExample example = RbPasswordValueUtil.eoToEntityExample(eo);
        return rbPasswordMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String pwdKey, String pwdType, String clientNo) {
        return rbPasswordMapper.deleteByPrimaryKey(pwdKey, pwdType, clientNo);
    }

    @Override
    public int create(RbPasswordEO eo) {
        RbPassword row = RbPasswordValueUtil.eoToEntity(eo);
        return rbPasswordMapper.insert(row);
    }

    @Override
    public int createSelective(RbPasswordEO eo) {
        RbPassword row = RbPasswordValueUtil.eoToEntity(eo);
        return rbPasswordMapper.insertSelective(row);
    }

    @Override
    public List<RbPasswordEO> findByEo(RbPasswordEO eo) {
        RbPasswordExample example = RbPasswordValueUtil.eoToEntityExample(eo);
        List<RbPasswordEO> result = new ArrayList<>();
        List<RbPassword> dbResult = rbPasswordMapper.selectByExample(example);
        for (RbPassword item : dbResult) {
            result.add(RbPasswordValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbPasswordEO findByPrimaryKey(String pwdKey, String pwdType, String clientNo) {
        return RbPasswordValueUtil.entityToEo(rbPasswordMapper.selectByPrimaryKey(pwdKey, pwdType, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbPasswordEO eo) {
        RbPassword row = RbPasswordValueUtil.eoToEntity(eo);
        return rbPasswordMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbPasswordEO eo) {
        RbPassword row = RbPasswordValueUtil.eoToEntity(eo);
        return rbPasswordMapper.updateByPrimaryKey(row);
    }
}