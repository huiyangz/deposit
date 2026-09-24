package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbBusFundDirectionDetails;
import com.dcits.deposit.entity.RbBusFundDirectionDetailsExample;
import com.dcits.deposit.facade.eo.RbBusFundDirectionDetailsEO;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.FundSource;
import com.dcits.deposit.enums.RegType;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.FundAcctPurpose;

public final class RbBusFundDirectionDetailsValueUtil {
    private RbBusFundDirectionDetailsValueUtil() {
    }

    public static RbBusFundDirectionDetailsEO entityToEo(RbBusFundDirectionDetails entity) {
        if (entity == null) {
            return null;
        }
        RbBusFundDirectionDetailsEO eo = new RbBusFundDirectionDetailsEO();
        eo.setDocumentType(DocumentType.byValue(entity.getDocumentType()));
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setFundToBankNo(entity.getFundToBankNo());
        eo.setTranDate(entity.getTranDate());
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setFundSource(FundSource.byValue(entity.getFundSource()));
        eo.setRegType(RegType.byValue(entity.getRegType()));
        eo.setBabInternalBaseAcctNo(entity.getBabInternalBaseAcctNo());
        eo.setCcy(Ccy.byValue(entity.getCcy()));
        eo.setDocumentId(entity.getDocumentId());
        eo.setFundFromName(entity.getFundFromName());
        eo.setProdNo(entity.getProdNo());
        eo.setFundFromAcctNo(entity.getFundFromAcctNo());
        eo.setFundAcctPurpose(FundAcctPurpose.byValue(entity.getFundAcctPurpose()));
        eo.setAgentName(entity.getAgentName());
        eo.setSeqNo(entity.getSeqNo());
        eo.setFundToName(entity.getFundToName());
        eo.setFundFromBankNo(entity.getFundFromBankNo());
        eo.setFundToAcctNo(entity.getFundToAcctNo());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbBusFundDirectionDetails eoToEntity(RbBusFundDirectionDetailsEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusFundDirectionDetails entity = new RbBusFundDirectionDetails();
        entity.setDocumentType(eo.getDocumentType() == null ? null : eo.getDocumentType().getValue());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setFundToBankNo(eo.getFundToBankNo());
        entity.setTranDate(eo.getTranDate());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setFundSource(eo.getFundSource() == null ? null : eo.getFundSource().getValue());
        entity.setRegType(eo.getRegType() == null ? null : eo.getRegType().getValue());
        entity.setBabInternalBaseAcctNo(eo.getBabInternalBaseAcctNo());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setDocumentId(eo.getDocumentId());
        entity.setFundFromName(eo.getFundFromName());
        entity.setProdNo(eo.getProdNo());
        entity.setFundFromAcctNo(eo.getFundFromAcctNo());
        entity.setFundAcctPurpose(eo.getFundAcctPurpose() == null ? null : eo.getFundAcctPurpose().getValue());
        entity.setAgentName(eo.getAgentName());
        entity.setSeqNo(eo.getSeqNo());
        entity.setFundToName(eo.getFundToName());
        entity.setFundFromBankNo(eo.getFundFromBankNo());
        entity.setFundToAcctNo(eo.getFundToAcctNo());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbBusFundDirectionDetailsExample eoToEntityExample(RbBusFundDirectionDetailsEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusFundDirectionDetailsExample example = new RbBusFundDirectionDetailsExample();
        RbBusFundDirectionDetailsExample.Criteria criteria = example.createCriteria();
        if (eo.getDocumentType() != null) criteria.andDocumentTypeEqualTo(eo.getDocumentType().getValue());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getFundToBankNo() != null) criteria.andFundToBankNoEqualTo(eo.getFundToBankNo());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getFundSource() != null) criteria.andFundSourceEqualTo(eo.getFundSource().getValue());
        if (eo.getRegType() != null) criteria.andRegTypeEqualTo(eo.getRegType().getValue());
        if (eo.getBabInternalBaseAcctNo() != null) criteria.andBabInternalBaseAcctNoEqualTo(eo.getBabInternalBaseAcctNo());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getDocumentId() != null) criteria.andDocumentIdEqualTo(eo.getDocumentId());
        if (eo.getFundFromName() != null) criteria.andFundFromNameEqualTo(eo.getFundFromName());
        if (eo.getProdNo() != null) criteria.andProdNoEqualTo(eo.getProdNo());
        if (eo.getFundFromAcctNo() != null) criteria.andFundFromAcctNoEqualTo(eo.getFundFromAcctNo());
        if (eo.getFundAcctPurpose() != null) criteria.andFundAcctPurposeEqualTo(eo.getFundAcctPurpose().getValue());
        if (eo.getAgentName() != null) criteria.andAgentNameEqualTo(eo.getAgentName());
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getFundToName() != null) criteria.andFundToNameEqualTo(eo.getFundToName());
        if (eo.getFundFromBankNo() != null) criteria.andFundFromBankNoEqualTo(eo.getFundFromBankNo());
        if (eo.getFundToAcctNo() != null) criteria.andFundToAcctNoEqualTo(eo.getFundToAcctNo());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}