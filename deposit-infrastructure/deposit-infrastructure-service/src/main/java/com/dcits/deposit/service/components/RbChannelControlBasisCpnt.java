package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.ControlStatus;
import com.dcits.deposit.enums.ControlType;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbChannelControl;
import com.dcits.deposit.entity.RbChannelControlExample;
import com.dcits.deposit.facade.components.IRbChannelControlBcc;
import com.dcits.deposit.facade.eo.RbChannelControlEO;
import com.dcits.deposit.repo.RbChannelControlMapper;
import com.dcits.deposit.service.utils.RbChannelControlValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbChannelControlBasisCpnt implements IRbChannelControlBcc {
    @Autowired
    RbChannelControlMapper rbChannelControlMapper;

    @Override
    public long countByEo(RbChannelControlEO eo) {
        RbChannelControlExample example = RbChannelControlValueUtil.eoToEntityExample(eo);
        return rbChannelControlMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbChannelControlEO eo) {
        RbChannelControlExample example = RbChannelControlValueUtil.eoToEntityExample(eo);
        return rbChannelControlMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String controlSeqNo, String clientNo) {
        return rbChannelControlMapper.deleteByPrimaryKey(controlSeqNo, clientNo);
    }

    @Override
    public int create(RbChannelControlEO eo) {
        RbChannelControl row = RbChannelControlValueUtil.eoToEntity(eo);
        return rbChannelControlMapper.insert(row);
    }

    @Override
    public int createSelective(RbChannelControlEO eo) {
        RbChannelControl row = RbChannelControlValueUtil.eoToEntity(eo);
        return rbChannelControlMapper.insertSelective(row);
    }

    @Override
    public List<RbChannelControlEO> findByEo(RbChannelControlEO eo) {
        RbChannelControlExample example = RbChannelControlValueUtil.eoToEntityExample(eo);
        List<RbChannelControlEO> result = new ArrayList<>();
        List<RbChannelControl> dbResult = rbChannelControlMapper.selectByExample(example);
        for (RbChannelControl item : dbResult) {
            result.add(RbChannelControlValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbChannelControlEO findByPrimaryKey(String controlSeqNo, String clientNo) {
        return RbChannelControlValueUtil.entityToEo(rbChannelControlMapper.selectByPrimaryKey(controlSeqNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbChannelControlEO eo) {
        RbChannelControl row = RbChannelControlValueUtil.eoToEntity(eo);
        return rbChannelControlMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbChannelControlEO eo) {
        RbChannelControl row = RbChannelControlValueUtil.eoToEntity(eo);
        return rbChannelControlMapper.updateByPrimaryKey(row);
    }
}