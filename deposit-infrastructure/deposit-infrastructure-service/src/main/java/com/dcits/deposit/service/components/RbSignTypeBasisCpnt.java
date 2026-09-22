package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SignType;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbSignType;
import com.dcits.deposit.entity.RbSignTypeExample;
import com.dcits.deposit.facade.components.IRbSignTypeBcc;
import com.dcits.deposit.facade.eo.RbSignTypeEO;
import com.dcits.deposit.repo.RbSignTypeMapper;
import com.dcits.deposit.service.utils.RbSignTypeValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbSignTypeBasisCpnt implements IRbSignTypeBcc {
    @Autowired
    RbSignTypeMapper rbSignTypeMapper;

    @Override
    public long countByEo(RbSignTypeEO eo) {
        RbSignTypeExample example = RbSignTypeValueUtil.eoToEntityExample(eo);
        return rbSignTypeMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbSignTypeEO eo) {
        RbSignTypeExample example = RbSignTypeValueUtil.eoToEntityExample(eo);
        return rbSignTypeMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String signType) {
        return rbSignTypeMapper.deleteByPrimaryKey(signType);
    }

    @Override
    public int create(RbSignTypeEO eo) {
        RbSignType row = RbSignTypeValueUtil.eoToEntity(eo);
        return rbSignTypeMapper.insert(row);
    }

    @Override
    public int createSelective(RbSignTypeEO eo) {
        RbSignType row = RbSignTypeValueUtil.eoToEntity(eo);
        return rbSignTypeMapper.insertSelective(row);
    }

    @Override
    public List<RbSignTypeEO> findByEo(RbSignTypeEO eo) {
        RbSignTypeExample example = RbSignTypeValueUtil.eoToEntityExample(eo);
        List<RbSignTypeEO> result = new ArrayList<>();
        List<RbSignType> dbResult = rbSignTypeMapper.selectByExample(example);
        for (RbSignType item : dbResult) {
            result.add(RbSignTypeValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbSignTypeEO findByPrimaryKey(String signType) {
        return RbSignTypeValueUtil.entityToEo(rbSignTypeMapper.selectByPrimaryKey(signType));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbSignTypeEO eo) {
        RbSignType row = RbSignTypeValueUtil.eoToEntity(eo);
        return rbSignTypeMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbSignTypeEO eo) {
        RbSignType row = RbSignTypeValueUtil.eoToEntity(eo);
        return rbSignTypeMapper.updateByPrimaryKey(row);
    }

    RbSignTypeEO bySignType(SignType signType) {
        RbSignTypeEO eo = new RbSignTypeEO();
        eo.setSignType(signType);
        return eo;
    }

    /**根据签约类型查询表《协议类型参数表(RB_SIGN_TYPE)》**/
    public RbSignTypeEO findBySignType(SignType signType) {
        List<RbSignTypeEO> eos = findByEo(bySignType(signType));
        return eos.isEmpty() ? null : eos.get(0);
    }
}