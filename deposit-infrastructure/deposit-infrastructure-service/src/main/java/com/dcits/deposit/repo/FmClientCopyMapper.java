package com.dcits.deposit.repo;

import com.dcits.deposit.entity.FmClientCopy;
import com.dcits.deposit.entity.FmClientCopyExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmClientCopyMapper {
    long countByExample(FmClientCopyExample example);

    int deleteByExample(FmClientCopyExample example);

    int deleteByPrimaryKey(@Param("address") String address, @Param("taxResidentFlag") String taxResidentFlag, @Param("classLevel") String classLevel, @Param("state") String state, @Param("documentType") String documentType, @Param("lastUpdTimestamp") String lastUpdTimestamp, @Param("industry") String industry, @Param("prefFlag") String prefFlag, @Param("clientVerificationResult") String clientVerificationResult, @Param("countryLoc") String countryLoc, @Param("categoryType") String categoryType, @Param("repDocumentId") String repDocumentId, @Param("corporationFlag") String corporationFlag, @Param("postalCode") String postalCode, @Param("clientName") String clientName, @Param("industryLevel") String industryLevel, @Param("ghoCustomerClass") String ghoCustomerClass, @Param("education") String education, @Param("clientShort") String clientShort, @Param("city") String city, @Param("contactTel") String contactTel, @Param("businessScope") String businessScope, @Param("contactType") String contactType, @Param("legalRep") String legalRep, @Param("internalIndFlag") String internalIndFlag, @Param("issPlace") String issPlace, @Param("repExpiryDate") Date repExpiryDate, @Param("corpFlag") String corpFlag, @Param("occupationCode") String occupationCode, @Param("wrnFlag") String wrnFlag, @Param("createTimestamp") String createTimestamp, @Param("issDate") Date issDate, @Param("enClientName") String enClientName, @Param("sex") String sex, @Param("branchInnerFlag") String branchInnerFlag, @Param("mobilePhone") String mobilePhone, @Param("clientType") String clientType, @Param("maturityDate") Date maturityDate, @Param("birthDate") Date birthDate, @Param("taxFlag") String taxFlag, @Param("clientClass") String clientClass, @Param("documentId") String documentId, @Param("crRating") String crRating, @Param("clientStatus") String clientStatus, @Param("isIndividual") String isIndividual, @Param("inlandOffshore") String inlandOffshore, @Param("clientIndicator") String clientIndicator, @Param("nation") String nation, @Param("ctrlBranch") String ctrlBranch, @Param("spokenLanguage") String spokenLanguage, @Param("issCountry") String issCountry, @Param("repDocumentType") String repDocumentType, @Param("residentFlag") String residentFlag);

    int insert(FmClientCopy row);

    int insertSelective(FmClientCopy row);

    List<FmClientCopy> selectByExample(FmClientCopyExample example);

    FmClientCopy selectByPrimaryKey(@Param("address") String address, @Param("taxResidentFlag") String taxResidentFlag, @Param("classLevel") String classLevel, @Param("state") String state, @Param("documentType") String documentType, @Param("lastUpdTimestamp") String lastUpdTimestamp, @Param("industry") String industry, @Param("prefFlag") String prefFlag, @Param("clientVerificationResult") String clientVerificationResult, @Param("countryLoc") String countryLoc, @Param("categoryType") String categoryType, @Param("repDocumentId") String repDocumentId, @Param("corporationFlag") String corporationFlag, @Param("postalCode") String postalCode, @Param("clientName") String clientName, @Param("industryLevel") String industryLevel, @Param("ghoCustomerClass") String ghoCustomerClass, @Param("education") String education, @Param("clientShort") String clientShort, @Param("city") String city, @Param("contactTel") String contactTel, @Param("businessScope") String businessScope, @Param("contactType") String contactType, @Param("legalRep") String legalRep, @Param("internalIndFlag") String internalIndFlag, @Param("issPlace") String issPlace, @Param("repExpiryDate") Date repExpiryDate, @Param("corpFlag") String corpFlag, @Param("occupationCode") String occupationCode, @Param("wrnFlag") String wrnFlag, @Param("createTimestamp") String createTimestamp, @Param("issDate") Date issDate, @Param("enClientName") String enClientName, @Param("sex") String sex, @Param("branchInnerFlag") String branchInnerFlag, @Param("mobilePhone") String mobilePhone, @Param("clientType") String clientType, @Param("maturityDate") Date maturityDate, @Param("birthDate") Date birthDate, @Param("taxFlag") String taxFlag, @Param("clientClass") String clientClass, @Param("documentId") String documentId, @Param("crRating") String crRating, @Param("clientStatus") String clientStatus, @Param("isIndividual") String isIndividual, @Param("inlandOffshore") String inlandOffshore, @Param("clientIndicator") String clientIndicator, @Param("nation") String nation, @Param("ctrlBranch") String ctrlBranch, @Param("spokenLanguage") String spokenLanguage, @Param("issCountry") String issCountry, @Param("repDocumentType") String repDocumentType, @Param("residentFlag") String residentFlag);

    int updateByExampleSelective(@Param("row") FmClientCopy row, @Param("example") FmClientCopyExample example);

    int updateByExample(@Param("row") FmClientCopy row, @Param("example") FmClientCopyExample example);

    int updateByPrimaryKeySelective(FmClientCopy row);

    int updateByPrimaryKey(FmClientCopy row);
}