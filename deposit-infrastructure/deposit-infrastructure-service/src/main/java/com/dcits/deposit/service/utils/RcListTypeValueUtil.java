package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RcListType;
import com.dcits.deposit.entity.RcListTypeExample;
import com.dcits.deposit.facade.eo.RcListTypeEO;
import com.dcits.deposit.enums.ListType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ListCategory;

public final class RcListTypeValueUtil {
    private RcListTypeValueUtil() {
    }

    public static RcListTypeEO entityToEo(RcListType entity) {
        if (entity == null) {
            return null;
        }
        RcListTypeEO eo = new RcListTypeEO();
        eo.setListType(ListType.byValue(entity.getListType()));
        eo.setListTypeDesc(entity.getListTypeDesc());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setListCategory(ListCategory.byValue(entity.getListCategory()));
        eo.setRuleId(entity.getRuleId());
        return eo;
    }

    public static RcListType eoToEntity(RcListTypeEO eo) {
        if (eo == null) {
            return null;
        }
        RcListType entity = new RcListType();
        entity.setListType(eo.getListType() == null ? null : eo.getListType().getValue());
        entity.setListTypeDesc(eo.getListTypeDesc());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setListCategory(eo.getListCategory() == null ? null : eo.getListCategory().getValue());
        entity.setRuleId(eo.getRuleId());
        return entity;
    }

    public static RcListTypeExample eoToEntityExample(RcListTypeEO eo) {
        if (eo == null) {
            return null;
        }
        RcListTypeExample example = new RcListTypeExample();
        RcListTypeExample.Criteria criteria = example.createCriteria();
        if (eo.getListType() != null) criteria.andListTypeEqualTo(eo.getListType().getValue());
        if (eo.getListTypeDesc() != null) criteria.andListTypeDescEqualTo(eo.getListTypeDesc());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getListCategory() != null) criteria.andListCategoryEqualTo(eo.getListCategory().getValue());
        if (eo.getRuleId() != null) criteria.andRuleIdEqualTo(eo.getRuleId());
        return example;
    }
}