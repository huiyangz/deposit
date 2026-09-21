package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbClientAcctRelation;
import com.dcits.deposit.entity.RbClientAcctRelationExample;
import com.dcits.deposit.facade.eo.RbClientAcctRelationEO;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.RelStatus;
import com.dcits.deposit.enums.Company;

public final class RbClientAcctRelationValueUtil {
    private RbClientAcctRelationValueUtil() {
    }

    public static RbClientAcctRelationEO entityToEo(RbClientAcctRelation entity) {
        if (entity == null) {
            return null;
        }
        RbClientAcctRelationEO eo = new RbClientAcctRelationEO();
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setClientNo(entity.getClientNo());
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setAcctInternalKey(entity.getAcctInternalKey());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setProdType(entity.getProdType());
        eo.setDefaultAcctFlag(entity.getDefaultAcctFlag());
        eo.setRelStatus(RelStatus.byValue(entity.getRelStatus()));
        eo.setClientAcctType(entity.getClientAcctType());
        eo.setCreateDate(entity.getCreateDate());
        eo.setUpdateDate(entity.getUpdateDate());
        eo.setCreateUserId(entity.getCreateUserId());
        eo.setUpdateUserId(entity.getUpdateUserId());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static RbClientAcctRelation eoToEntity(RbClientAcctRelationEO eo) {
        if (eo == null) {
            return null;
        }
        RbClientAcctRelation entity = new RbClientAcctRelation();
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setClientNo(eo.getClientNo());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setAcctInternalKey(eo.getAcctInternalKey());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setProdType(eo.getProdType());
        entity.setDefaultAcctFlag(eo.getDefaultAcctFlag());
        entity.setRelStatus(eo.getRelStatus() == null ? null : eo.getRelStatus().getValue());
        entity.setClientAcctType(eo.getClientAcctType());
        entity.setCreateDate(eo.getCreateDate());
        entity.setUpdateDate(eo.getUpdateDate());
        entity.setCreateUserId(eo.getCreateUserId());
        entity.setUpdateUserId(eo.getUpdateUserId());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static RbClientAcctRelationExample eoToEntityExample(RbClientAcctRelationEO eo) {
        if (eo == null) {
            return null;
        }
        RbClientAcctRelationExample example = new RbClientAcctRelationExample();
        RbClientAcctRelationExample.Criteria criteria = example.createCriteria();
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getAcctInternalKey() != null) criteria.andAcctInternalKeyEqualTo(eo.getAcctInternalKey());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getDefaultAcctFlag() != null) criteria.andDefaultAcctFlagEqualTo(eo.getDefaultAcctFlag());
        if (eo.getRelStatus() != null) criteria.andRelStatusEqualTo(eo.getRelStatus().getValue());
        if (eo.getClientAcctType() != null) criteria.andClientAcctTypeEqualTo(eo.getClientAcctType());
        if (eo.getCreateDate() != null) criteria.andCreateDateEqualTo(eo.getCreateDate());
        if (eo.getUpdateDate() != null) criteria.andUpdateDateEqualTo(eo.getUpdateDate());
        if (eo.getCreateUserId() != null) criteria.andCreateUserIdEqualTo(eo.getCreateUserId());
        if (eo.getUpdateUserId() != null) criteria.andUpdateUserIdEqualTo(eo.getUpdateUserId());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}