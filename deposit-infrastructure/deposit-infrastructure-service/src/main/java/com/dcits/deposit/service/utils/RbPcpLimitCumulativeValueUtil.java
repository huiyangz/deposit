package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbPcpLimitCumulative;
import com.dcits.deposit.entity.RbPcpLimitCumulativeExample;
import com.dcits.deposit.facade.eo.RbPcpLimitCumulativeEO;
import com.dcits.deposit.enums.LimitType;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.Company;

public final class RbPcpLimitCumulativeValueUtil {
    private RbPcpLimitCumulativeValueUtil() {
    }

    public static RbPcpLimitCumulativeEO entityToEo(RbPcpLimitCumulative entity) {
        if (entity == null) {
            return null;
        }
        RbPcpLimitCumulativeEO eo = new RbPcpLimitCumulativeEO();
        eo.setInternalKey(entity.getInternalKey());
        eo.setLimitType(LimitType.byValue(entity.getLimitType()));
        eo.setAgreementId(entity.getAgreementId());
        eo.setClientNo(entity.getClientNo());
        eo.setLimitNum(entity.getLimitNum());
        eo.setLimitAmt(entity.getLimitAmt());
        eo.setCrDrInd(CrDrInd.byValue(entity.getCrDrInd()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbPcpLimitCumulative eoToEntity(RbPcpLimitCumulativeEO eo) {
        if (eo == null) {
            return null;
        }
        RbPcpLimitCumulative entity = new RbPcpLimitCumulative();
        entity.setInternalKey(eo.getInternalKey());
        entity.setLimitType(eo.getLimitType() == null ? null : eo.getLimitType().getValue());
        entity.setAgreementId(eo.getAgreementId());
        entity.setClientNo(eo.getClientNo());
        entity.setLimitNum(eo.getLimitNum());
        entity.setLimitAmt(eo.getLimitAmt());
        entity.setCrDrInd(eo.getCrDrInd() == null ? null : eo.getCrDrInd().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbPcpLimitCumulativeExample eoToEntityExample(RbPcpLimitCumulativeEO eo) {
        if (eo == null) {
            return null;
        }
        RbPcpLimitCumulativeExample example = new RbPcpLimitCumulativeExample();
        RbPcpLimitCumulativeExample.Criteria criteria = example.createCriteria();
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getLimitType() != null) criteria.andLimitTypeEqualTo(eo.getLimitType().getValue());
        if (eo.getAgreementId() != null) criteria.andAgreementIdEqualTo(eo.getAgreementId());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getLimitNum() != null) criteria.andLimitNumEqualTo(eo.getLimitNum());
        if (eo.getLimitAmt() != null) criteria.andLimitAmtEqualTo(eo.getLimitAmt());
        if (eo.getCrDrInd() != null) criteria.andCrDrIndEqualTo(eo.getCrDrInd().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}