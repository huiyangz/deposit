package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbAgreement;
import com.dcits.deposit.entity.RbAgreementExample;
import com.dcits.deposit.facade.eo.RbAgreementEO;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AgreementType;
import com.dcits.deposit.enums.AgreementClass;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AgreementStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.Company;

public final class RbAgreementValueUtil {
    private RbAgreementValueUtil() {
    }

    public static RbAgreementEO entityToEo(RbAgreement entity) {
        if (entity == null) {
            return null;
        }
        RbAgreementEO eo = new RbAgreementEO();
        eo.setAgreementId(entity.getAgreementId());
        eo.setSignBranch(AcctBranch.byValue(entity.getSignBranch()));
        eo.setAgreementType(AgreementType.byValue(entity.getAgreementType()));
        eo.setAgreementClass(AgreementClass.byValue(entity.getAgreementClass()));
        eo.setAgreementKeyType(entity.getAgreementKeyType());
        eo.setAgreementKey(entity.getAgreementKey());
        eo.setAgreementAmt(entity.getAgreementAmt());
        eo.setAgreProdType(entity.getAgreProdType());
        eo.setSignChannel(SourceType.byValue(entity.getSignChannel()));
        eo.setTranBranch(AcctBranch.byValue(entity.getTranBranch()));
        eo.setSignDate(entity.getSignDate());
        eo.setSignUserId(entity.getSignUserId());
        eo.setStartDate(entity.getStartDate());
        eo.setEndDate(entity.getEndDate());
        eo.setAgreementStatus(AgreementStatus.byValue(entity.getAgreementStatus()));
        eo.setAgreementCloseAcctFlag(IndividualFlag.byValue(entity.getAgreementCloseAcctFlag()));
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setProdType(entity.getProdType());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setAcctName(entity.getAcctName());
        eo.setClientNo(entity.getClientNo());
        eo.setClientShort(entity.getClientShort());
        eo.setOppositeInternalKey(entity.getOppositeInternalKey());
        eo.setAgreementOpenDate(entity.getAgreementOpenDate());
        eo.setOutSignBranch(AcctBranch.byValue(entity.getOutSignBranch()));
        eo.setOutSignChannel(SourceType.byValue(entity.getOutSignChannel()));
        eo.setOutSignDate(entity.getOutSignDate());
        eo.setOutSignUserId(entity.getOutSignUserId());
        eo.setUserId(entity.getUserId());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setLastChangeUserId(entity.getLastChangeUserId());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbAgreement eoToEntity(RbAgreementEO eo) {
        if (eo == null) {
            return null;
        }
        RbAgreement entity = new RbAgreement();
        entity.setAgreementId(eo.getAgreementId());
        entity.setSignBranch(eo.getSignBranch() == null ? null : eo.getSignBranch().getValue());
        entity.setAgreementType(eo.getAgreementType() == null ? null : eo.getAgreementType().getValue());
        entity.setAgreementClass(eo.getAgreementClass() == null ? null : eo.getAgreementClass().getValue());
        entity.setAgreementKeyType(eo.getAgreementKeyType());
        entity.setAgreementKey(eo.getAgreementKey());
        entity.setAgreementAmt(eo.getAgreementAmt());
        entity.setAgreProdType(eo.getAgreProdType());
        entity.setSignChannel(eo.getSignChannel() == null ? null : eo.getSignChannel().getValue());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setSignDate(eo.getSignDate());
        entity.setSignUserId(eo.getSignUserId());
        entity.setStartDate(eo.getStartDate());
        entity.setEndDate(eo.getEndDate());
        entity.setAgreementStatus(eo.getAgreementStatus() == null ? null : eo.getAgreementStatus().getValue());
        entity.setAgreementCloseAcctFlag(eo.getAgreementCloseAcctFlag() == null ? null : eo.getAgreementCloseAcctFlag().getValue());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setProdType(eo.getProdType());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setAcctName(eo.getAcctName());
        entity.setClientNo(eo.getClientNo());
        entity.setClientShort(eo.getClientShort());
        entity.setOppositeInternalKey(eo.getOppositeInternalKey());
        entity.setAgreementOpenDate(eo.getAgreementOpenDate());
        entity.setOutSignBranch(eo.getOutSignBranch() == null ? null : eo.getOutSignBranch().getValue());
        entity.setOutSignChannel(eo.getOutSignChannel() == null ? null : eo.getOutSignChannel().getValue());
        entity.setOutSignDate(eo.getOutSignDate());
        entity.setOutSignUserId(eo.getOutSignUserId());
        entity.setUserId(eo.getUserId());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setLastChangeUserId(eo.getLastChangeUserId());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbAgreementExample eoToEntityExample(RbAgreementEO eo) {
        if (eo == null) {
            return null;
        }
        RbAgreementExample example = new RbAgreementExample();
        RbAgreementExample.Criteria criteria = example.createCriteria();
        if (eo.getAgreementId() != null) criteria.andAgreementIdEqualTo(eo.getAgreementId());
        if (eo.getSignBranch() != null) criteria.andSignBranchEqualTo(eo.getSignBranch().getValue());
        if (eo.getAgreementType() != null) criteria.andAgreementTypeEqualTo(eo.getAgreementType().getValue());
        if (eo.getAgreementClass() != null) criteria.andAgreementClassEqualTo(eo.getAgreementClass().getValue());
        if (eo.getAgreementKeyType() != null) criteria.andAgreementKeyTypeEqualTo(eo.getAgreementKeyType());
        if (eo.getAgreementKey() != null) criteria.andAgreementKeyEqualTo(eo.getAgreementKey());
        if (eo.getAgreementAmt() != null) criteria.andAgreementAmtEqualTo(eo.getAgreementAmt());
        if (eo.getAgreProdType() != null) criteria.andAgreProdTypeEqualTo(eo.getAgreProdType());
        if (eo.getSignChannel() != null) criteria.andSignChannelEqualTo(eo.getSignChannel().getValue());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getSignDate() != null) criteria.andSignDateEqualTo(eo.getSignDate());
        if (eo.getSignUserId() != null) criteria.andSignUserIdEqualTo(eo.getSignUserId());
        if (eo.getStartDate() != null) criteria.andStartDateEqualTo(eo.getStartDate());
        if (eo.getEndDate() != null) criteria.andEndDateEqualTo(eo.getEndDate());
        if (eo.getAgreementStatus() != null) criteria.andAgreementStatusEqualTo(eo.getAgreementStatus().getValue());
        if (eo.getAgreementCloseAcctFlag() != null) criteria.andAgreementCloseAcctFlagEqualTo(eo.getAgreementCloseAcctFlag().getValue());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getAcctName() != null) criteria.andAcctNameEqualTo(eo.getAcctName());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getClientShort() != null) criteria.andClientShortEqualTo(eo.getClientShort());
        if (eo.getOppositeInternalKey() != null) criteria.andOppositeInternalKeyEqualTo(eo.getOppositeInternalKey());
        if (eo.getAgreementOpenDate() != null) criteria.andAgreementOpenDateEqualTo(eo.getAgreementOpenDate());
        if (eo.getOutSignBranch() != null) criteria.andOutSignBranchEqualTo(eo.getOutSignBranch().getValue());
        if (eo.getOutSignChannel() != null) criteria.andOutSignChannelEqualTo(eo.getOutSignChannel().getValue());
        if (eo.getOutSignDate() != null) criteria.andOutSignDateEqualTo(eo.getOutSignDate());
        if (eo.getOutSignUserId() != null) criteria.andOutSignUserIdEqualTo(eo.getOutSignUserId());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getLastChangeUserId() != null) criteria.andLastChangeUserIdEqualTo(eo.getLastChangeUserId());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}