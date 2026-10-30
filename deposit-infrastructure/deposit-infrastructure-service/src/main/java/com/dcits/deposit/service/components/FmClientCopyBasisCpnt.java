package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.CategoryType;
import com.dcits.deposit.enums.City;
import com.dcits.deposit.enums.ClassLevel;
import com.dcits.deposit.enums.ClientClass;
import com.dcits.deposit.enums.ClientIndicator;
import com.dcits.deposit.enums.ClientStatus;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.ClientVerificationResult;
import com.dcits.deposit.enums.ContactType;
import com.dcits.deposit.enums.CountryLoc;
import com.dcits.deposit.enums.CrRating;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.Education;
import com.dcits.deposit.enums.Industry;
import com.dcits.deposit.enums.IndustryLevel;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.Nation;
import com.dcits.deposit.enums.OccupationCode;
import com.dcits.deposit.enums.Sex;
import com.dcits.deposit.enums.SpokenLanguage;
import com.dcits.deposit.enums.State;
import com.dcits.deposit.enums.TaxFlag;
import com.dcits.deposit.enums.TaxResidentFlag;
import com.dcits.deposit.enums.TranBranch;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.FmClientCopy;
import com.dcits.deposit.entity.FmClientCopyExample;
import com.dcits.deposit.facade.components.IFmClientCopyBcc;
import com.dcits.deposit.facade.eo.FmClientCopyEO;
import com.dcits.deposit.repo.FmClientCopyMapper;
import com.dcits.deposit.service.utils.FmClientCopyValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FmClientCopyBasisCpnt implements IFmClientCopyBcc {
    @Autowired
    FmClientCopyMapper fmClientCopyMapper;

    @Override
    public long countByEo(FmClientCopyEO eo) {
        FmClientCopyExample example = FmClientCopyValueUtil.eoToEntityExample(eo);
        return fmClientCopyMapper.countByExample(example);
    }

    @Override
    public int removeByEo(FmClientCopyEO eo) {
        FmClientCopyExample example = FmClientCopyValueUtil.eoToEntityExample(eo);
        return fmClientCopyMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String address, String taxResidentFlag, String classLevel, String state, String documentType, String lastUpdTimestamp, String industry, String prefFlag, String clientVerificationResult, String countryLoc, String categoryType, String repDocumentId, String corporationFlag, String postalCode, String clientName, String industryLevel, String ghoCustomerClass, String education, String clientShort, String city, String contactTel, String businessScope, String contactType, String legalRep, String internalIndFlag, String issPlace, Date repExpiryDate, String corpFlag, String occupationCode, String wrnFlag, String createTimestamp, Date issDate, String enClientName, String sex, String branchInnerFlag, String mobilePhone, String clientType, Date maturityDate, Date birthDate, String taxFlag, String clientClass, String documentId, String crRating, String clientStatus, String isIndividual, String inlandOffshore, String clientIndicator, String nation, String ctrlBranch, String spokenLanguage, String issCountry, String repDocumentType, String residentFlag) {
        return fmClientCopyMapper.deleteByPrimaryKey(address, taxResidentFlag, classLevel, state, documentType, lastUpdTimestamp, industry, prefFlag, clientVerificationResult, countryLoc, categoryType, repDocumentId, corporationFlag, postalCode, clientName, industryLevel, ghoCustomerClass, education, clientShort, city, contactTel, businessScope, contactType, legalRep, internalIndFlag, issPlace, repExpiryDate, corpFlag, occupationCode, wrnFlag, createTimestamp, issDate, enClientName, sex, branchInnerFlag, mobilePhone, clientType, maturityDate, birthDate, taxFlag, clientClass, documentId, crRating, clientStatus, isIndividual, inlandOffshore, clientIndicator, nation, ctrlBranch, spokenLanguage, issCountry, repDocumentType, residentFlag);
    }

    @Override
    public int create(FmClientCopyEO eo) {
        FmClientCopy row = FmClientCopyValueUtil.eoToEntity(eo);
        return fmClientCopyMapper.insert(row);
    }

    @Override
    public int createSelective(FmClientCopyEO eo) {
        FmClientCopy row = FmClientCopyValueUtil.eoToEntity(eo);
        return fmClientCopyMapper.insertSelective(row);
    }

    @Override
    public List<FmClientCopyEO> findByEo(FmClientCopyEO eo) {
        FmClientCopyExample example = FmClientCopyValueUtil.eoToEntityExample(eo);
        List<FmClientCopyEO> result = new ArrayList<>();
        List<FmClientCopy> dbResult = fmClientCopyMapper.selectByExample(example);
        for (FmClientCopy item : dbResult) {
            result.add(FmClientCopyValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public FmClientCopyEO findByPrimaryKey(String address, String taxResidentFlag, String classLevel, String state, String documentType, String lastUpdTimestamp, String industry, String prefFlag, String clientVerificationResult, String countryLoc, String categoryType, String repDocumentId, String corporationFlag, String postalCode, String clientName, String industryLevel, String ghoCustomerClass, String education, String clientShort, String city, String contactTel, String businessScope, String contactType, String legalRep, String internalIndFlag, String issPlace, Date repExpiryDate, String corpFlag, String occupationCode, String wrnFlag, String createTimestamp, Date issDate, String enClientName, String sex, String branchInnerFlag, String mobilePhone, String clientType, Date maturityDate, Date birthDate, String taxFlag, String clientClass, String documentId, String crRating, String clientStatus, String isIndividual, String inlandOffshore, String clientIndicator, String nation, String ctrlBranch, String spokenLanguage, String issCountry, String repDocumentType, String residentFlag) {
        return FmClientCopyValueUtil.entityToEo(fmClientCopyMapper.selectByPrimaryKey(address, taxResidentFlag, classLevel, state, documentType, lastUpdTimestamp, industry, prefFlag, clientVerificationResult, countryLoc, categoryType, repDocumentId, corporationFlag, postalCode, clientName, industryLevel, ghoCustomerClass, education, clientShort, city, contactTel, businessScope, contactType, legalRep, internalIndFlag, issPlace, repExpiryDate, corpFlag, occupationCode, wrnFlag, createTimestamp, issDate, enClientName, sex, branchInnerFlag, mobilePhone, clientType, maturityDate, birthDate, taxFlag, clientClass, documentId, crRating, clientStatus, isIndividual, inlandOffshore, clientIndicator, nation, ctrlBranch, spokenLanguage, issCountry, repDocumentType, residentFlag));
    }

    @Override
    public int modifyByPrimaryKeySelective(FmClientCopyEO eo) {
        FmClientCopy row = FmClientCopyValueUtil.eoToEntity(eo);
        return fmClientCopyMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(FmClientCopyEO eo) {
        FmClientCopy row = FmClientCopyValueUtil.eoToEntity(eo);
        return fmClientCopyMapper.updateByPrimaryKey(row);
    }
}