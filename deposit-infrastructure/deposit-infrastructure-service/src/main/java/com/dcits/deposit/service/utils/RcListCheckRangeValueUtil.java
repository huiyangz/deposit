package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RcListCheckRange;
import com.dcits.deposit.entity.RcListCheckRangeExample;
import com.dcits.deposit.facade.eo.RcListCheckRangeEO;
import com.dcits.deposit.enums.ListType;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.Company;

public final class RcListCheckRangeValueUtil {
    private RcListCheckRangeValueUtil() {
    }

    public static RcListCheckRangeEO entityToEo(RcListCheckRange entity) {
        if (entity == null) {
            return null;
        }
        RcListCheckRangeEO eo = new RcListCheckRangeEO();
        eo.setSeqNo(entity.getSeqNo());
        eo.setListType(ListType.byValue(entity.getListType()));
        eo.setRuleId(entity.getRuleId());
        eo.setTranType(TranType.byValue(entity.getTranType()));
        eo.setEventType(entity.getEventType());
        eo.setServiceCode(entity.getServiceCode());
        eo.setMessageType(entity.getMessageType());
        eo.setMessageCode(entity.getMessageCode());
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setProgramId(entity.getProgramId());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static RcListCheckRange eoToEntity(RcListCheckRangeEO eo) {
        if (eo == null) {
            return null;
        }
        RcListCheckRange entity = new RcListCheckRange();
        entity.setSeqNo(eo.getSeqNo());
        entity.setListType(eo.getListType() == null ? null : eo.getListType().getValue());
        entity.setRuleId(eo.getRuleId());
        entity.setTranType(eo.getTranType() == null ? null : eo.getTranType().getValue());
        entity.setEventType(eo.getEventType());
        entity.setServiceCode(eo.getServiceCode());
        entity.setMessageType(eo.getMessageType());
        entity.setMessageCode(eo.getMessageCode());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setProgramId(eo.getProgramId());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static RcListCheckRangeExample eoToEntityExample(RcListCheckRangeEO eo) {
        if (eo == null) {
            return null;
        }
        RcListCheckRangeExample example = new RcListCheckRangeExample();
        RcListCheckRangeExample.Criteria criteria = example.createCriteria();
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getListType() != null) criteria.andListTypeEqualTo(eo.getListType().getValue());
        if (eo.getRuleId() != null) criteria.andRuleIdEqualTo(eo.getRuleId());
        if (eo.getTranType() != null) criteria.andTranTypeEqualTo(eo.getTranType().getValue());
        if (eo.getEventType() != null) criteria.andEventTypeEqualTo(eo.getEventType());
        if (eo.getServiceCode() != null) criteria.andServiceCodeEqualTo(eo.getServiceCode());
        if (eo.getMessageType() != null) criteria.andMessageTypeEqualTo(eo.getMessageType());
        if (eo.getMessageCode() != null) criteria.andMessageCodeEqualTo(eo.getMessageCode());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getProgramId() != null) criteria.andProgramIdEqualTo(eo.getProgramId());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}