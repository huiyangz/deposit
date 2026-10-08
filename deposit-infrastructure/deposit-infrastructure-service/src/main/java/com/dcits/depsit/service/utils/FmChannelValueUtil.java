package com.dcits.depsit.service.utils;

import com.dcits.depsit.entity.FmChannel;
import com.dcits.depsit.entity.FmChannelExample;
import com.dcits.depsit.facade.eo.FmChannelEO;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.ChannelClass;

public final class FmChannelValueUtil {
    private FmChannelValueUtil() {
    }

    public static FmChannelEO entityToEo(FmChannel entity) {
        if (entity == null) {
            return null;
        }
        FmChannelEO eo = new FmChannelEO();
        eo.setCounterFlag(entity.getCounterFlag());
        eo.setChannelType(SourceType.byValue(entity.getChannelType()));
        eo.setChannelShort(entity.getChannelShort());
        eo.setChannel(SourceType.byValue(entity.getChannel()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(entity.getCompany());
        eo.setChannelClass(ChannelClass.byValue(entity.getChannelClass()));
        eo.setChannelDesc(entity.getChannelDesc());
        return eo;
    }

    public static FmChannel eoToEntity(FmChannelEO eo) {
        if (eo == null) {
            return null;
        }
        FmChannel entity = new FmChannel();
        entity.setCounterFlag(eo.getCounterFlag());
        entity.setChannelType(eo.getChannelType() == null ? null : eo.getChannelType().getValue());
        entity.setChannelShort(eo.getChannelShort());
        entity.setChannel(eo.getChannel() == null ? null : eo.getChannel().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany());
        entity.setChannelClass(eo.getChannelClass() == null ? null : eo.getChannelClass().getValue());
        entity.setChannelDesc(eo.getChannelDesc());
        return entity;
    }

    public static FmChannelExample eoToEntityExample(FmChannelEO eo) {
        if (eo == null) {
            return null;
        }
        FmChannelExample example = new FmChannelExample();
        FmChannelExample.Criteria criteria = example.createCriteria();
        if (eo.getCounterFlag() != null) criteria.andCounterFlagEqualTo(eo.getCounterFlag());
        if (eo.getChannelType() != null) criteria.andChannelTypeEqualTo(eo.getChannelType().getValue());
        if (eo.getChannelShort() != null) criteria.andChannelShortEqualTo(eo.getChannelShort());
        if (eo.getChannel() != null) criteria.andChannelEqualTo(eo.getChannel().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany());
        if (eo.getChannelClass() != null) criteria.andChannelClassEqualTo(eo.getChannelClass().getValue());
        if (eo.getChannelDesc() != null) criteria.andChannelDescEqualTo(eo.getChannelDesc());
        return example;
    }
}