package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.ChannelClass;
import com.dcits.depsit.enums.SourceType;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.FmChannel;
import com.dcits.depsit.entity.FmChannelExample;
import com.dcits.depsit.facade.components.IFmChannelBcc;
import com.dcits.depsit.facade.eo.FmChannelEO;
import com.dcits.depsit.repo.FmChannelMapper;
import com.dcits.depsit.service.utils.FmChannelValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FmChannelBasisCpnt implements IFmChannelBcc {
    @Autowired
    FmChannelMapper fmChannelMapper;

    @Override
    public long countByEo(FmChannelEO eo) {
        FmChannelExample example = FmChannelValueUtil.eoToEntityExample(eo);
        return fmChannelMapper.countByExample(example);
    }

    @Override
    public int removeByEo(FmChannelEO eo) {
        FmChannelExample example = FmChannelValueUtil.eoToEntityExample(eo);
        return fmChannelMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String channel) {
        return fmChannelMapper.deleteByPrimaryKey(channel);
    }

    @Override
    public int create(FmChannelEO eo) {
        FmChannel row = FmChannelValueUtil.eoToEntity(eo);
        return fmChannelMapper.insert(row);
    }

    @Override
    public int createSelective(FmChannelEO eo) {
        FmChannel row = FmChannelValueUtil.eoToEntity(eo);
        return fmChannelMapper.insertSelective(row);
    }

    @Override
    public List<FmChannelEO> findByEo(FmChannelEO eo) {
        FmChannelExample example = FmChannelValueUtil.eoToEntityExample(eo);
        List<FmChannelEO> result = new ArrayList<>();
        List<FmChannel> dbResult = fmChannelMapper.selectByExample(example);
        for (FmChannel item : dbResult) {
            result.add(FmChannelValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public FmChannelEO findByPrimaryKey(String channel) {
        return FmChannelValueUtil.entityToEo(fmChannelMapper.selectByPrimaryKey(channel));
    }

    @Override
    public int modifyByPrimaryKeySelective(FmChannelEO eo) {
        FmChannel row = FmChannelValueUtil.eoToEntity(eo);
        return fmChannelMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(FmChannelEO eo) {
        FmChannel row = FmChannelValueUtil.eoToEntity(eo);
        return fmChannelMapper.updateByPrimaryKey(row);
    }

    FmChannelEO byChannel(SourceType channel) {
        FmChannelEO eo = new FmChannelEO();
        eo.setChannel(channel);
        return eo;
    }

    /**根据渠道查询表《渠道类型表(FM_CHANNEL)》**/
    public FmChannelEO findByChannel(SourceType channel) {
        List<FmChannelEO> eos = findByEo(byChannel(channel));
        return eos.isEmpty() ? null : eos.get(0);
    }
}