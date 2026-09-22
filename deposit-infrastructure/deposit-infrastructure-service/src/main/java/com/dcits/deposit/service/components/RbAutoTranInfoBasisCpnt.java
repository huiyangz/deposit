package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAutoTranInfo;
import com.dcits.deposit.entity.RbAutoTranInfoExample;
import com.dcits.deposit.facade.components.IRbAutoTranInfoBcc;
import com.dcits.deposit.facade.eo.RbAutoTranInfoEO;
import com.dcits.deposit.repo.RbAutoTranInfoMapper;
import com.dcits.deposit.service.utils.RbAutoTranInfoValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAutoTranInfoBasisCpnt implements IRbAutoTranInfoBcc {
    @Autowired
    RbAutoTranInfoMapper rbAutoTranInfoMapper;

    @Override
    public long countByEo(RbAutoTranInfoEO eo) {
        RbAutoTranInfoExample example = RbAutoTranInfoValueUtil.eoToEntityExample(eo);
        return rbAutoTranInfoMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAutoTranInfoEO eo) {
        RbAutoTranInfoExample example = RbAutoTranInfoValueUtil.eoToEntityExample(eo);
        return rbAutoTranInfoMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo, String clientNo) {
        return rbAutoTranInfoMapper.deleteByPrimaryKey(seqNo, clientNo);
    }

    @Override
    public int create(RbAutoTranInfoEO eo) {
        RbAutoTranInfo row = RbAutoTranInfoValueUtil.eoToEntity(eo);
        return rbAutoTranInfoMapper.insert(row);
    }

    @Override
    public int createSelective(RbAutoTranInfoEO eo) {
        RbAutoTranInfo row = RbAutoTranInfoValueUtil.eoToEntity(eo);
        return rbAutoTranInfoMapper.insertSelective(row);
    }

    @Override
    public List<RbAutoTranInfoEO> findByEo(RbAutoTranInfoEO eo) {
        RbAutoTranInfoExample example = RbAutoTranInfoValueUtil.eoToEntityExample(eo);
        List<RbAutoTranInfoEO> result = new ArrayList<>();
        List<RbAutoTranInfo> dbResult = rbAutoTranInfoMapper.selectByExample(example);
        for (RbAutoTranInfo item : dbResult) {
            result.add(RbAutoTranInfoValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAutoTranInfoEO findByPrimaryKey(String seqNo, String clientNo) {
        return RbAutoTranInfoValueUtil.entityToEo(rbAutoTranInfoMapper.selectByPrimaryKey(seqNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAutoTranInfoEO eo) {
        RbAutoTranInfo row = RbAutoTranInfoValueUtil.eoToEntity(eo);
        return rbAutoTranInfoMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAutoTranInfoEO eo) {
        RbAutoTranInfo row = RbAutoTranInfoValueUtil.eoToEntity(eo);
        return rbAutoTranInfoMapper.updateByPrimaryKey(row);
    }
}