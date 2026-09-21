package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RcListNotCheckRange;
import com.dcits.deposit.entity.RcListNotCheckRangeExample;
import com.dcits.deposit.facade.eo.RcListNotCheckRangeEO;
import com.dcits.deposit.enums.ListType;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.Company;

public final class RcListNotCheckRangeValueUtil {
    private RcListNotCheckRangeValueUtil() {
    }

    public static RcListNotCheckRangeEO entityToEo(RcListNotCheckRange entity) {
        if (entity == null) {
            return null;
        }
        RcListNotCheckRangeEO eo = new RcListNotCheckRangeEO();
        eo.setSeqNo(entity.getSeqNo());
        eo.setListType(ListType.byValue(entity.getListType()));
        eo.setRuleId(entity.getRuleId());
        eo.setTranType(TranType.byValue(entity.getTranType()));
        eo.setEventType(entity.getEventType());
        eo.setServiceCode(entity.getServiceCode());
        eo.setMessageType(entity.getMessageType());
        eo.setMessageCode(entity.getMessageCode());
        eo.setProgramId(entity.getProgramId());
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setRemark(entity.getRemark());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static RcListNotCheckRange eoToEntity(RcListNotCheckRangeEO eo) {
        if (eo == null) {
            return null;
        }
        RcListNotCheckRange entity = new RcListNotCheckRange();
        entity.setSeqNo(eo.getSeqNo());
        entity.setListType(eo.getListType() == null ? null : eo.getListType().getValue());
        entity.setRuleId(eo.getRuleId());
        entity.setTranType(eo.getTranType() == null ? null : eo.getTranType().getValue());
        entity.setEventType(eo.getEventType());
        entity.setServiceCode(eo.getServiceCode());
        entity.setMessageType(eo.getMessageType());
        entity.setMessageCode(eo.getMessageCode());
        entity.setProgramId(eo.getProgramId());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setRemark(eo.getRemark());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static RcListNotCheckRangeExample eoToEntityExample(RcListNotCheckRangeEO eo) {
        if (eo == null) {
            return null;
        }
        RcListNotCheckRangeExample example = new RcListNotCheckRangeExample();
        RcListNotCheckRangeExample.Criteria criteria = example.createCriteria();
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getListType() != null) criteria.andListTypeEqualTo(eo.getListType().getValue());
        if (eo.getRuleId() != null) criteria.andRuleIdEqualTo(eo.getRuleId());
        if (eo.getTranType() != null) criteria.andTranTypeEqualTo(eo.getTranType().getValue());
        if (eo.getEventType() != null) criteria.andEventTypeEqualTo(eo.getEventType());
        if (eo.getServiceCode() != null) criteria.andServiceCodeEqualTo(eo.getServiceCode());
        if (eo.getMessageType() != null) criteria.andMessageTypeEqualTo(eo.getMessageType());
        if (eo.getMessageCode() != null) criteria.andMessageCodeEqualTo(eo.getMessageCode());
        if (eo.getProgramId() != null) criteria.andProgramIdEqualTo(eo.getProgramId());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getRemark() != null) criteria.andRemarkEqualTo(eo.getRemark());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}