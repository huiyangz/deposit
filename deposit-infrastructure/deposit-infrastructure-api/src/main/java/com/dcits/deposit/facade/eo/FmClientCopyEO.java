package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.CategoryType;
import com.dcits.deposit.enums.City;
import com.dcits.deposit.enums.ClassLevel;
import com.dcits.deposit.enums.ClientClass;
import com.dcits.deposit.enums.ClientIndicator;
import com.dcits.deposit.enums.ClientStatus;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ContactType;
import com.dcits.deposit.enums.CrRating;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.Education;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.Industry;
import com.dcits.deposit.enums.IndustryLevel;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.Nation;
import com.dcits.deposit.enums.OccupationCode;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.Sex;
import com.dcits.deposit.enums.SpokenLanguage;
import com.dcits.deposit.enums.TaxFlag;
import com.dcits.deposit.enums.TaxResidentFlag;
import com.dcits.deposit.enums.VerificationResult;
import jakarta.validation.constraints.NotNull;

public class FmClientCopyEO {
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 客户名称 */
    private String clientName;
    /** 客户英文名称 */
    private String enClientName;
    /** 客户中文名称 */
    private String chClientName;
    /** 客户简称 */
    private String clientShort;
    /** 客户标识 */
    private ClientIndicator clientIndicator;
    /** 客户类型 */
    private ClientType clientType;
    /** 客户状态 */
    private ClientStatus clientStatus;
    /** 对私客户标志 */
    private IndividualFlag isIndividual;
    /** 地址 */
    private String address;
    /** 内部客户标志 */
    private IndividualFlag internalIndFlag;
    /** 职业编码 */
    private OccupationCode occupationCode;
    /** 核实结果 */
    private VerificationResult verificationResult;
    /** 居民标志 */
    private IndividualFlag residentFlag;
    /** 到期日期 */
    private java.util.Date maturityDate;
    /** 境内境外标志 */
    private IndividualFlag inlandOffshore;
    /** 证件号码 */
    private String documentId;
    /** 证件类型 */
    private DocumentType documentType;
    /** 发证国家 */
    private IssCountry issCountry;
    /** 客户证件签发地 */
    private String issPlace;
    /** 签发日期 */
    private java.util.Date issDate;
    /** 法定代表人身份证件号码 */
    private String repDocumentId;
    /** 法定代表人身份证件类型 */
    private DocumentType repDocumentType;
    /** 法定代表人名称 */
    private String legalRep;
    /** 法人代表证件到期日期 */
    private java.util.Date repExpiryDate;
    /** 客户细分类型 */
    private CategoryType categoryType;
    /** 性别 */
    private Sex sex;
    /** 省代码 */
    private OthBranchRegionalismCode state;
    /** 客户号归属机构号 */
    private AcctBranch ctrlBranch;
    /** 经营范围 */
    private String businessScope;
    /** 教育程度编号 */
    private Education education;
    /** 贷款核销标志 */
    private IndividualFlag wrnFlag;
    /** 小微企业标志 */
    private IndividualFlag corpFlag;
    /** 行业层级 */
    private IndustryLevel industryLevel;
    /** 机构内客户标志 */
    private IndividualFlag branchInnerFlag;
    /** 邮政编码 */
    private String postalCode;
    /** 收税标志 */
    private TaxFlag taxFlag;
    /** 城市 */
    private City city;
    /** 国籍 */
    private IssCountry countryLoc;
    /** 联系类型 */
    private ContactType contactType;
    /** 联系电话 */
    private String contactTel;
    /** 手机号码 */
    private String mobilePhone;
    /** 出生日期 */
    private java.util.Date birthDate;
    /** 信用等级 */
    private CrRating crRating;
    /** 集团客户分类 */
    private String ghoCustomerClass;
    /** 客户类别 */
    private ClientClass clientClass;
    /** 客户综合评级级别 */
    private ClassLevel classLevel;
    /** 首选标志 */
    private IndividualFlag prefFlag;
    /** 企业标志 */
    private IndividualFlag corporationFlag;
    /** 税收居民标识 */
    private TaxResidentFlag taxResidentFlag;
    /** 民族 */
    private Nation nation;
    /** 交流语言 */
    private SpokenLanguage spokenLanguage;
    /** 通用行业代码 */
    private Industry industry;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 同步时间戳 */
    private String syncTranTimestamp;
    /** 法人 */
    private Company company;

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getEnClientName() {
        return enClientName;
    }

    public void setEnClientName(String enClientName) {
        this.enClientName = enClientName;
    }

    public String getChClientName() {
        return chClientName;
    }

    public void setChClientName(String chClientName) {
        this.chClientName = chClientName;
    }

    public String getClientShort() {
        return clientShort;
    }

    public void setClientShort(String clientShort) {
        this.clientShort = clientShort;
    }

    public ClientIndicator getClientIndicator() {
        return clientIndicator;
    }

    public void setClientIndicator(ClientIndicator clientIndicator) {
        this.clientIndicator = clientIndicator;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public ClientStatus getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(ClientStatus clientStatus) {
        this.clientStatus = clientStatus;
    }

    public IndividualFlag getIsIndividual() {
        return isIndividual;
    }

    public void setIsIndividual(IndividualFlag isIndividual) {
        this.isIndividual = isIndividual;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public IndividualFlag getInternalIndFlag() {
        return internalIndFlag;
    }

    public void setInternalIndFlag(IndividualFlag internalIndFlag) {
        this.internalIndFlag = internalIndFlag;
    }

    public OccupationCode getOccupationCode() {
        return occupationCode;
    }

    public void setOccupationCode(OccupationCode occupationCode) {
        this.occupationCode = occupationCode;
    }

    public VerificationResult getVerificationResult() {
        return verificationResult;
    }

    public void setVerificationResult(VerificationResult verificationResult) {
        this.verificationResult = verificationResult;
    }

    public IndividualFlag getResidentFlag() {
        return residentFlag;
    }

    public void setResidentFlag(IndividualFlag residentFlag) {
        this.residentFlag = residentFlag;
    }

    public java.util.Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.util.Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public IndividualFlag getInlandOffshore() {
        return inlandOffshore;
    }

    public void setInlandOffshore(IndividualFlag inlandOffshore) {
        this.inlandOffshore = inlandOffshore;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public IssCountry getIssCountry() {
        return issCountry;
    }

    public void setIssCountry(IssCountry issCountry) {
        this.issCountry = issCountry;
    }

    public String getIssPlace() {
        return issPlace;
    }

    public void setIssPlace(String issPlace) {
        this.issPlace = issPlace;
    }

    public java.util.Date getIssDate() {
        return issDate;
    }

    public void setIssDate(java.util.Date issDate) {
        this.issDate = issDate;
    }

    public String getRepDocumentId() {
        return repDocumentId;
    }

    public void setRepDocumentId(String repDocumentId) {
        this.repDocumentId = repDocumentId;
    }

    public DocumentType getRepDocumentType() {
        return repDocumentType;
    }

    public void setRepDocumentType(DocumentType repDocumentType) {
        this.repDocumentType = repDocumentType;
    }

    public String getLegalRep() {
        return legalRep;
    }

    public void setLegalRep(String legalRep) {
        this.legalRep = legalRep;
    }

    public java.util.Date getRepExpiryDate() {
        return repExpiryDate;
    }

    public void setRepExpiryDate(java.util.Date repExpiryDate) {
        this.repExpiryDate = repExpiryDate;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public OthBranchRegionalismCode getState() {
        return state;
    }

    public void setState(OthBranchRegionalismCode state) {
        this.state = state;
    }

    public AcctBranch getCtrlBranch() {
        return ctrlBranch;
    }

    public void setCtrlBranch(AcctBranch ctrlBranch) {
        this.ctrlBranch = ctrlBranch;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public IndividualFlag getWrnFlag() {
        return wrnFlag;
    }

    public void setWrnFlag(IndividualFlag wrnFlag) {
        this.wrnFlag = wrnFlag;
    }

    public IndividualFlag getCorpFlag() {
        return corpFlag;
    }

    public void setCorpFlag(IndividualFlag corpFlag) {
        this.corpFlag = corpFlag;
    }

    public IndustryLevel getIndustryLevel() {
        return industryLevel;
    }

    public void setIndustryLevel(IndustryLevel industryLevel) {
        this.industryLevel = industryLevel;
    }

    public IndividualFlag getBranchInnerFlag() {
        return branchInnerFlag;
    }

    public void setBranchInnerFlag(IndividualFlag branchInnerFlag) {
        this.branchInnerFlag = branchInnerFlag;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public TaxFlag getTaxFlag() {
        return taxFlag;
    }

    public void setTaxFlag(TaxFlag taxFlag) {
        this.taxFlag = taxFlag;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public IssCountry getCountryLoc() {
        return countryLoc;
    }

    public void setCountryLoc(IssCountry countryLoc) {
        this.countryLoc = countryLoc;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public java.util.Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(java.util.Date birthDate) {
        this.birthDate = birthDate;
    }

    public CrRating getCrRating() {
        return crRating;
    }

    public void setCrRating(CrRating crRating) {
        this.crRating = crRating;
    }

    public String getGhoCustomerClass() {
        return ghoCustomerClass;
    }

    public void setGhoCustomerClass(String ghoCustomerClass) {
        this.ghoCustomerClass = ghoCustomerClass;
    }

    public ClientClass getClientClass() {
        return clientClass;
    }

    public void setClientClass(ClientClass clientClass) {
        this.clientClass = clientClass;
    }

    public ClassLevel getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(ClassLevel classLevel) {
        this.classLevel = classLevel;
    }

    public IndividualFlag getPrefFlag() {
        return prefFlag;
    }

    public void setPrefFlag(IndividualFlag prefFlag) {
        this.prefFlag = prefFlag;
    }

    public IndividualFlag getCorporationFlag() {
        return corporationFlag;
    }

    public void setCorporationFlag(IndividualFlag corporationFlag) {
        this.corporationFlag = corporationFlag;
    }

    public TaxResidentFlag getTaxResidentFlag() {
        return taxResidentFlag;
    }

    public void setTaxResidentFlag(TaxResidentFlag taxResidentFlag) {
        this.taxResidentFlag = taxResidentFlag;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public SpokenLanguage getSpokenLanguage() {
        return spokenLanguage;
    }

    public void setSpokenLanguage(SpokenLanguage spokenLanguage) {
        this.spokenLanguage = spokenLanguage;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getLastChangeUserId() {
        return lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getSyncTranTimestamp() {
        return syncTranTimestamp;
    }

    public void setSyncTranTimestamp(String syncTranTimestamp) {
        this.syncTranTimestamp = syncTranTimestamp;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}