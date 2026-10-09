package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.ChannelClass;
import com.dcits.depsit.enums.SourceType;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbChannelClass;
import com.dcits.depsit.entity.RbChannelClassExample;
import com.dcits.depsit.facade.components.IRbChannelClassBcc;
import com.dcits.depsit.facade.eo.RbChannelClassEO;
import com.dcits.depsit.repo.RbChannelClassMapper;
import com.dcits.depsit.service.utils.RbChannelClassValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbChannelClassBasisCpnt implements IRbChannelClassBcc {
    @Autowired
    RbChannelClassMapper rbChannelClassMapper;

    @Override
    public long countByEo(RbChannelClassEO eo) {
        RbChannelClassExample example = RbChannelClassValueUtil.eoToEntityExample(eo);
        return rbChannelClassMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbChannelClassEO eo) {
        RbChannelClassExample example = RbChannelClassValueUtil.eoToEntityExample(eo);
        return rbChannelClassMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String channel) {
        return rbChannelClassMapper.deleteByPrimaryKey(channel);
    }

    @Override
    public int create(RbChannelClassEO eo) {
        RbChannelClass row = RbChannelClassValueUtil.eoToEntity(eo);
        return rbChannelClassMapper.insert(row);
    }

    @Override
    public int createSelective(RbChannelClassEO eo) {
        RbChannelClass row = RbChannelClassValueUtil.eoToEntity(eo);
        return rbChannelClassMapper.insertSelective(row);
    }

    @Override
    public List<RbChannelClassEO> findByEo(RbChannelClassEO eo) {
        RbChannelClassExample example = RbChannelClassValueUtil.eoToEntityExample(eo);
        List<RbChannelClassEO> result = new ArrayList<>();
        List<RbChannelClass> dbResult = rbChannelClassMapper.selectByExample(example);
        for (RbChannelClass item : dbResult) {
            result.add(RbChannelClassValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbChannelClassEO findByPrimaryKey(String channel) {
        return RbChannelClassValueUtil.entityToEo(rbChannelClassMapper.selectByPrimaryKey(channel));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbChannelClassEO eo) {
        RbChannelClass row = RbChannelClassValueUtil.eoToEntity(eo);
        return rbChannelClassMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbChannelClassEO eo) {
        RbChannelClass row = RbChannelClassValueUtil.eoToEntity(eo);
        return rbChannelClassMapper.updateByPrimaryKey(row);
    }

    RbChannelClassEO byChannel(SourceType channel) {
        RbChannelClassEO eo = new RbChannelClassEO();
        eo.setChannel(channel);
        return eo;
    }

    /**根据渠道查询表《渠道类型(RB_CHANNEL_CLASS)》**/
    public RbChannelClassEO findByChannel(SourceType channel) {
        List<RbChannelClassEO> eos = findByEo(byChannel(channel));
        return eos.isEmpty() ? null : eos.get(0);
    }
}