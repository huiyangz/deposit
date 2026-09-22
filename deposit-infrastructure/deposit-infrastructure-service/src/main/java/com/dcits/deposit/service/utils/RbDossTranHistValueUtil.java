package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbDossTranHist;
import com.dcits.deposit.entity.RbDossTranHistExample;
import com.dcits.deposit.facade.eo.RbDossTranHistEO;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.IntIndFlag;
import com.dcits.deposit.enums.Company;

public final class RbDossTranHistValueUtil {
    private RbDossTranHistValueUtil() {
    }

    public static RbDossTranHistEO entityToEo(RbDossTranHist entity) {
        if (entity == null) {
            return null;
        }
        RbDossTranHistEO eo = new RbDossTranHistEO();
        eo.setSeqNo(entity.getSeqNo());
        eo.setChannelSeqNo(entity.getChannelSeqNo());
        eo.setSubSeqNo(entity.getSubSeqNo());
        eo.setReference(entity.getReference());
        eo.setClientNo(entity.getClientNo());
        eo.setInternalKey(entity.getInternalKey());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setProdType(entity.getProdType());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setTranDate(entity.getTranDate());
        eo.setTranAmt(entity.getTranAmt());
        eo.setTranStatus(TranStatus.byValue(entity.getTranStatus()));
        eo.setIntIndFlag(IntIndFlag.byValue(entity.getIntIndFlag()));
        eo.setAccrDate(entity.getAccrDate());
        eo.setIntAccr(entity.getIntAccr());
        eo.setRemark(entity.getRemark());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static RbDossTranHist eoToEntity(RbDossTranHistEO eo) {
        if (eo == null) {
            return null;
        }
        RbDossTranHist entity = new RbDossTranHist();
        entity.setSeqNo(eo.getSeqNo());
        entity.setChannelSeqNo(eo.getChannelSeqNo());
        entity.setSubSeqNo(eo.getSubSeqNo());
        entity.setReference(eo.getReference());
        entity.setClientNo(eo.getClientNo());
        entity.setInternalKey(eo.getInternalKey());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setProdType(eo.getProdType());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setTranDate(eo.getTranDate());
        entity.setTranAmt(eo.getTranAmt());
        entity.setTranStatus(eo.getTranStatus() == null ? null : eo.getTranStatus().getValue());
        entity.setIntIndFlag(eo.getIntIndFlag() == null ? null : eo.getIntIndFlag().getValue());
        entity.setAccrDate(eo.getAccrDate());
        entity.setIntAccr(eo.getIntAccr());
        entity.setRemark(eo.getRemark());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static RbDossTranHistExample eoToEntityExample(RbDossTranHistEO eo) {
        if (eo == null) {
            return null;
        }
        RbDossTranHistExample example = new RbDossTranHistExample();
        RbDossTranHistExample.Criteria criteria = example.createCriteria();
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getChannelSeqNo() != null) criteria.andChannelSeqNoEqualTo(eo.getChannelSeqNo());
        if (eo.getSubSeqNo() != null) criteria.andSubSeqNoEqualTo(eo.getSubSeqNo());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getTranAmt() != null) criteria.andTranAmtEqualTo(eo.getTranAmt());
        if (eo.getTranStatus() != null) criteria.andTranStatusEqualTo(eo.getTranStatus().getValue());
        if (eo.getIntIndFlag() != null) criteria.andIntIndFlagEqualTo(eo.getIntIndFlag().getValue());
        if (eo.getAccrDate() != null) criteria.andAccrDateEqualTo(eo.getAccrDate());
        if (eo.getIntAccr() != null) criteria.andIntAccrEqualTo(eo.getIntAccr());
        if (eo.getRemark() != null) criteria.andRemarkEqualTo(eo.getRemark());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}