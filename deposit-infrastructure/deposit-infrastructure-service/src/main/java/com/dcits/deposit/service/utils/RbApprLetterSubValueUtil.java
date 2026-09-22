package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbApprLetterSub;
import com.dcits.deposit.entity.RbApprLetterSubExample;
import com.dcits.deposit.facade.eo.RbApprLetterSubEO;
import com.dcits.deposit.enums.MainSubInd;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;

public final class RbApprLetterSubValueUtil {
    private RbApprLetterSubValueUtil() {
    }

    public static RbApprLetterSubEO entityToEo(RbApprLetterSub entity) {
        if (entity == null) {
            return null;
        }
        RbApprLetterSubEO eo = new RbApprLetterSubEO();
        eo.setApprLetterNo(entity.getApprLetterNo());
        eo.setMainSubInd(MainSubInd.byValue(entity.getMainSubInd()));
        eo.setCcy(AcctCcy.byValue(entity.getCcy()));
        eo.setApprLimitAmt(entity.getApprLimitAmt());
        eo.setCrTotalAmt(entity.getCrTotalAmt());
        eo.setDrTotalAmt(entity.getDrTotalAmt());
        eo.setGraceAmt(entity.getGraceAmt());
        eo.setGraceProportion(entity.getGraceProportion());
        eo.setClientNo(entity.getClientNo());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setRemark(entity.getRemark());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static RbApprLetterSub eoToEntity(RbApprLetterSubEO eo) {
        if (eo == null) {
            return null;
        }
        RbApprLetterSub entity = new RbApprLetterSub();
        entity.setApprLetterNo(eo.getApprLetterNo());
        entity.setMainSubInd(eo.getMainSubInd() == null ? null : eo.getMainSubInd().getValue());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setApprLimitAmt(eo.getApprLimitAmt());
        entity.setCrTotalAmt(eo.getCrTotalAmt());
        entity.setDrTotalAmt(eo.getDrTotalAmt());
        entity.setGraceAmt(eo.getGraceAmt());
        entity.setGraceProportion(eo.getGraceProportion());
        entity.setClientNo(eo.getClientNo());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setRemark(eo.getRemark());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static RbApprLetterSubExample eoToEntityExample(RbApprLetterSubEO eo) {
        if (eo == null) {
            return null;
        }
        RbApprLetterSubExample example = new RbApprLetterSubExample();
        RbApprLetterSubExample.Criteria criteria = example.createCriteria();
        if (eo.getApprLetterNo() != null) criteria.andApprLetterNoEqualTo(eo.getApprLetterNo());
        if (eo.getMainSubInd() != null) criteria.andMainSubIndEqualTo(eo.getMainSubInd().getValue());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getApprLimitAmt() != null) criteria.andApprLimitAmtEqualTo(eo.getApprLimitAmt());
        if (eo.getCrTotalAmt() != null) criteria.andCrTotalAmtEqualTo(eo.getCrTotalAmt());
        if (eo.getDrTotalAmt() != null) criteria.andDrTotalAmtEqualTo(eo.getDrTotalAmt());
        if (eo.getGraceAmt() != null) criteria.andGraceAmtEqualTo(eo.getGraceAmt());
        if (eo.getGraceProportion() != null) criteria.andGraceProportionEqualTo(eo.getGraceProportion());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getRemark() != null) criteria.andRemarkEqualTo(eo.getRemark());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}