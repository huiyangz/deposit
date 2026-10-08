package com.dcits.depsit.service.utils;

import com.dcits.depsit.entity.RcListNotCheckRange;
import com.dcits.depsit.entity.RcListNotCheckRangeExample;
import com.dcits.depsit.facade.eo.RcListNotCheckRangeEO;
import com.dcits.depsit.enums.OthTranType;
import com.dcits.depsit.enums.SourceType;

public final class RcListNotCheckRangeValueUtil {
    private RcListNotCheckRangeValueUtil() {
    }

    public static RcListNotCheckRangeEO entityToEo(RcListNotCheckRange entity) {
        if (entity == null) {
            return null;
        }
        RcListNotCheckRangeEO eo = new RcListNotCheckRangeEO();
        eo.setListType(entity.getListType());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setProgramId(entity.getProgramId());
        eo.setTranType(OthTranType.byValue(entity.getTranType()));
        eo.setRuleId(entity.getRuleId());
        eo.setSeqNo(entity.getSeqNo());
        eo.setMessageCode(entity.getMessageCode());
        eo.setServiceCode(entity.getServiceCode());
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setMessageType(entity.getMessageType());
        eo.setEventType(entity.getEventType());
        return eo;
    }

    public static RcListNotCheckRange eoToEntity(RcListNotCheckRangeEO eo) {
        if (eo == null) {
            return null;
        }
        RcListNotCheckRange entity = new RcListNotCheckRange();
        entity.setListType(eo.getListType());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setProgramId(eo.getProgramId());
        entity.setTranType(eo.getTranType() == null ? null : eo.getTranType().getValue());
        entity.setRuleId(eo.getRuleId());
        entity.setSeqNo(eo.getSeqNo());
        entity.setMessageCode(eo.getMessageCode());
        entity.setServiceCode(eo.getServiceCode());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setMessageType(eo.getMessageType());
        entity.setEventType(eo.getEventType());
        return entity;
    }

    public static RcListNotCheckRangeExample eoToEntityExample(RcListNotCheckRangeEO eo) {
        if (eo == null) {
            return null;
        }
        RcListNotCheckRangeExample example = new RcListNotCheckRangeExample();
        RcListNotCheckRangeExample.Criteria criteria = example.createCriteria();
        if (eo.getListType() != null) criteria.andListTypeEqualTo(eo.getListType());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getProgramId() != null) criteria.andProgramIdEqualTo(eo.getProgramId());
        if (eo.getTranType() != null) criteria.andTranTypeEqualTo(eo.getTranType().getValue());
        if (eo.getRuleId() != null) criteria.andRuleIdEqualTo(eo.getRuleId());
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getMessageCode() != null) criteria.andMessageCodeEqualTo(eo.getMessageCode());
        if (eo.getServiceCode() != null) criteria.andServiceCodeEqualTo(eo.getServiceCode());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getMessageType() != null) criteria.andMessageTypeEqualTo(eo.getMessageType());
        if (eo.getEventType() != null) criteria.andEventTypeEqualTo(eo.getEventType());
        return example;
    }
}