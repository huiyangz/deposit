package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbContactList;
import com.dcits.deposit.entity.RbContactListExample;
import com.dcits.deposit.facade.eo.RbContactListEO;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.LinkmanType;
import com.dcits.deposit.enums.ContactClass;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.ContactType;

public final class RbContactListValueUtil {
    private RbContactListValueUtil() {
    }

    public static RbContactListEO entityToEo(RbContactList entity) {
        if (entity == null) {
            return null;
        }
        RbContactListEO eo = new RbContactListEO();
        eo.setInternalKey(entity.getInternalKey());
        eo.setDocumentId(entity.getDocumentId());
        eo.setDocumentType(DocumentType.byValue(entity.getDocumentType()));
        eo.setLinkmanType(LinkmanType.byValue(entity.getLinkmanType()));
        eo.setLinkmanName(entity.getLinkmanName());
        eo.setPhoneNo1(entity.getPhoneNo1());
        eo.setPhoneNo2(entity.getPhoneNo2());
        eo.setContactStatus(entity.getContactStatus());
        eo.setContactClass(ContactClass.byValue(entity.getContactClass()));
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setLastChangeUserId(entity.getLastChangeUserId());
        eo.setClientNo(entity.getClientNo());
        eo.setLinkmanDesc(entity.getLinkmanDesc());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCheckCertificateFlag(IndividualFlag.byValue(entity.getCheckCertificateFlag()));
        eo.setCheckCertificateOrder(entity.getCheckCertificateOrder());
        eo.setContactType(ContactType.byValue(entity.getContactType()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbContactList eoToEntity(RbContactListEO eo) {
        if (eo == null) {
            return null;
        }
        RbContactList entity = new RbContactList();
        entity.setInternalKey(eo.getInternalKey());
        entity.setDocumentId(eo.getDocumentId());
        entity.setDocumentType(eo.getDocumentType() == null ? null : eo.getDocumentType().getValue());
        entity.setLinkmanType(eo.getLinkmanType() == null ? null : eo.getLinkmanType().getValue());
        entity.setLinkmanName(eo.getLinkmanName());
        entity.setPhoneNo1(eo.getPhoneNo1());
        entity.setPhoneNo2(eo.getPhoneNo2());
        entity.setContactStatus(eo.getContactStatus());
        entity.setContactClass(eo.getContactClass() == null ? null : eo.getContactClass().getValue());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setLastChangeUserId(eo.getLastChangeUserId());
        entity.setClientNo(eo.getClientNo());
        entity.setLinkmanDesc(eo.getLinkmanDesc());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCheckCertificateFlag(eo.getCheckCertificateFlag() == null ? null : eo.getCheckCertificateFlag().getValue());
        entity.setCheckCertificateOrder(eo.getCheckCertificateOrder());
        entity.setContactType(eo.getContactType() == null ? null : eo.getContactType().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbContactListExample eoToEntityExample(RbContactListEO eo) {
        if (eo == null) {
            return null;
        }
        RbContactListExample example = new RbContactListExample();
        RbContactListExample.Criteria criteria = example.createCriteria();
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getDocumentId() != null) criteria.andDocumentIdEqualTo(eo.getDocumentId());
        if (eo.getDocumentType() != null) criteria.andDocumentTypeEqualTo(eo.getDocumentType().getValue());
        if (eo.getLinkmanType() != null) criteria.andLinkmanTypeEqualTo(eo.getLinkmanType().getValue());
        if (eo.getLinkmanName() != null) criteria.andLinkmanNameEqualTo(eo.getLinkmanName());
        if (eo.getPhoneNo1() != null) criteria.andPhoneNo1EqualTo(eo.getPhoneNo1());
        if (eo.getPhoneNo2() != null) criteria.andPhoneNo2EqualTo(eo.getPhoneNo2());
        if (eo.getContactStatus() != null) criteria.andContactStatusEqualTo(eo.getContactStatus());
        if (eo.getContactClass() != null) criteria.andContactClassEqualTo(eo.getContactClass().getValue());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getLastChangeUserId() != null) criteria.andLastChangeUserIdEqualTo(eo.getLastChangeUserId());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getLinkmanDesc() != null) criteria.andLinkmanDescEqualTo(eo.getLinkmanDesc());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCheckCertificateFlag() != null) criteria.andCheckCertificateFlagEqualTo(eo.getCheckCertificateFlag().getValue());
        if (eo.getCheckCertificateOrder() != null) criteria.andCheckCertificateOrderEqualTo(eo.getCheckCertificateOrder());
        if (eo.getContactType() != null) criteria.andContactTypeEqualTo(eo.getContactType().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}