package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbFundDirectionDetails;
import com.dcits.deposit.entity.RbFundDirectionDetailsExample;
import com.dcits.deposit.facade.eo.RbFundDirectionDetailsEO;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.RegType;
import com.dcits.deposit.enums.FundSource;
import com.dcits.deposit.enums.FundAcctPurpose;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.Company;

public final class RbFundDirectionDetailsValueUtil {
    private RbFundDirectionDetailsValueUtil() {
    }

    public static RbFundDirectionDetailsEO entityToEo(RbFundDirectionDetails entity) {
        if (entity == null) {
            return null;
        }
        RbFundDirectionDetailsEO eo = new RbFundDirectionDetailsEO();
        eo.setSeqNo(entity.getSeqNo());
        eo.setClientNo(entity.getClientNo());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setProdType(entity.getProdType());
        eo.setCcy(AcctCcy.byValue(entity.getCcy()));
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setAgentName(entity.getAgentName());
        eo.setRegType(RegType.byValue(entity.getRegType()));
        eo.setFundSource(FundSource.byValue(entity.getFundSource()));
        eo.setFundFromAcctNo(entity.getFundFromAcctNo());
        eo.setFundFromName(entity.getFundFromName());
        eo.setFundFromBankNo(entity.getFundFromBankNo());
        eo.setFundToAcctNo(entity.getFundToAcctNo());
        eo.setFundToName(entity.getFundToName());
        eo.setFundToBankNo(entity.getFundToBankNo());
        eo.setFundAcctPurpose(FundAcctPurpose.byValue(entity.getFundAcctPurpose()));
        eo.setBabInternalBaseAcctNo(entity.getBabInternalBaseAcctNo());
        eo.setDocumentType(DocumentType.byValue(entity.getDocumentType()));
        eo.setDocumentId(entity.getDocumentId());
        eo.setTranDate(entity.getTranDate());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static RbFundDirectionDetails eoToEntity(RbFundDirectionDetailsEO eo) {
        if (eo == null) {
            return null;
        }
        RbFundDirectionDetails entity = new RbFundDirectionDetails();
        entity.setSeqNo(eo.getSeqNo());
        entity.setClientNo(eo.getClientNo());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setProdType(eo.getProdType());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setAgentName(eo.getAgentName());
        entity.setRegType(eo.getRegType() == null ? null : eo.getRegType().getValue());
        entity.setFundSource(eo.getFundSource() == null ? null : eo.getFundSource().getValue());
        entity.setFundFromAcctNo(eo.getFundFromAcctNo());
        entity.setFundFromName(eo.getFundFromName());
        entity.setFundFromBankNo(eo.getFundFromBankNo());
        entity.setFundToAcctNo(eo.getFundToAcctNo());
        entity.setFundToName(eo.getFundToName());
        entity.setFundToBankNo(eo.getFundToBankNo());
        entity.setFundAcctPurpose(eo.getFundAcctPurpose() == null ? null : eo.getFundAcctPurpose().getValue());
        entity.setBabInternalBaseAcctNo(eo.getBabInternalBaseAcctNo());
        entity.setDocumentType(eo.getDocumentType() == null ? null : eo.getDocumentType().getValue());
        entity.setDocumentId(eo.getDocumentId());
        entity.setTranDate(eo.getTranDate());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static RbFundDirectionDetailsExample eoToEntityExample(RbFundDirectionDetailsEO eo) {
        if (eo == null) {
            return null;
        }
        RbFundDirectionDetailsExample example = new RbFundDirectionDetailsExample();
        RbFundDirectionDetailsExample.Criteria criteria = example.createCriteria();
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getAgentName() != null) criteria.andAgentNameEqualTo(eo.getAgentName());
        if (eo.getRegType() != null) criteria.andRegTypeEqualTo(eo.getRegType().getValue());
        if (eo.getFundSource() != null) criteria.andFundSourceEqualTo(eo.getFundSource().getValue());
        if (eo.getFundFromAcctNo() != null) criteria.andFundFromAcctNoEqualTo(eo.getFundFromAcctNo());
        if (eo.getFundFromName() != null) criteria.andFundFromNameEqualTo(eo.getFundFromName());
        if (eo.getFundFromBankNo() != null) criteria.andFundFromBankNoEqualTo(eo.getFundFromBankNo());
        if (eo.getFundToAcctNo() != null) criteria.andFundToAcctNoEqualTo(eo.getFundToAcctNo());
        if (eo.getFundToName() != null) criteria.andFundToNameEqualTo(eo.getFundToName());
        if (eo.getFundToBankNo() != null) criteria.andFundToBankNoEqualTo(eo.getFundToBankNo());
        if (eo.getFundAcctPurpose() != null) criteria.andFundAcctPurposeEqualTo(eo.getFundAcctPurpose().getValue());
        if (eo.getBabInternalBaseAcctNo() != null) criteria.andBabInternalBaseAcctNoEqualTo(eo.getBabInternalBaseAcctNo());
        if (eo.getDocumentType() != null) criteria.andDocumentTypeEqualTo(eo.getDocumentType().getValue());
        if (eo.getDocumentId() != null) criteria.andDocumentIdEqualTo(eo.getDocumentId());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}