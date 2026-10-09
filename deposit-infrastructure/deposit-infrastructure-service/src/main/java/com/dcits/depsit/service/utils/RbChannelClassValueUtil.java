package com.dcits.depsit.service.utils;

import com.dcits.depsit.entity.RbChannelClass;
import com.dcits.depsit.entity.RbChannelClassExample;
import com.dcits.depsit.facade.eo.RbChannelClassEO;
import com.dcits.depsit.enums.ChannelClass;
import com.dcits.depsit.enums.SourceType;

public final class RbChannelClassValueUtil {
    private RbChannelClassValueUtil() {
    }

    public static RbChannelClassEO entityToEo(RbChannelClass entity) {
        if (entity == null) {
            return null;
        }
        RbChannelClassEO eo = new RbChannelClassEO();
        eo.setChannelClass(ChannelClass.byValue(entity.getChannelClass()));
        eo.setChannelDesc(entity.getChannelDesc());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setChannel(SourceType.byValue(entity.getChannel()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbChannelClass eoToEntity(RbChannelClassEO eo) {
        if (eo == null) {
            return null;
        }
        RbChannelClass entity = new RbChannelClass();
        entity.setChannelClass(eo.getChannelClass() == null ? null : eo.getChannelClass().getValue());
        entity.setChannelDesc(eo.getChannelDesc());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setChannel(eo.getChannel() == null ? null : eo.getChannel().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbChannelClassExample eoToEntityExample(RbChannelClassEO eo) {
        if (eo == null) {
            return null;
        }
        RbChannelClassExample example = new RbChannelClassExample();
        RbChannelClassExample.Criteria criteria = example.createCriteria();
        if (eo.getChannelClass() != null) criteria.andChannelClassEqualTo(eo.getChannelClass().getValue());
        if (eo.getChannelDesc() != null) criteria.andChannelDescEqualTo(eo.getChannelDesc());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getChannel() != null) criteria.andChannelEqualTo(eo.getChannel().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}