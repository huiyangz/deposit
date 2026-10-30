package com.dcits.deposit.facade.components;

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
import java.util.List;

import com.dcits.deposit.facade.eo.FmClientCopyEO;

/*实体表【客户副本表(FM_CLIENT_COPY)】数据服务接口*/
public interface IFmClientCopyBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.FmClientCopyEO中的属性字段组合 **/
    long countByEo(FmClientCopyEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.FmClientCopyEO中的属性字段组合 **/
    int removeByEo(FmClientCopyEO eo);

    /** remove 根据主键: 地址、税收居民标识、客户综合评级级别、省代码、证件类型、最后修改时间戳、通用行业代码、首选标志、客户核实结果、国籍、客户细分类型、法定代表人身份证件号码、企业标志、邮政编码、客户名称、行业层级、集团客户分类、教育程度编号、客户简称、城市、联系电话、经营范围、联系类型、法定代表人名称、内部客户标志、客户证件签发地、法人代表证件到期日期、小微企业标志、职业编码、贷款核销标志、创建时间戳、签发日期、客户英文名称、性别、机构内客户标志、手机号码、客户类型、到期日期、出生日期、收税标志、客户类别、证件号码、信用等级、客户状态、对私客户标志、境内境外标志、客户标识、民族、客户号归属机构号、交流语言、发证国家、法定代表人身份证件类型、居民标志 **/
    int removeByPrimaryKey(String address, String taxResidentFlag, String classLevel, String state, String documentType, String lastUpdTimestamp, String industry, String prefFlag, String clientVerificationResult, String countryLoc, String categoryType, String repDocumentId, String corporationFlag, String postalCode, String clientName, String industryLevel, String ghoCustomerClass, String education, String clientShort, String city, String contactTel, String businessScope, String contactType, String legalRep, String internalIndFlag, String issPlace, Date repExpiryDate, String corpFlag, String occupationCode, String wrnFlag, String createTimestamp, Date issDate, String enClientName, String sex, String branchInnerFlag, String mobilePhone, String clientType, Date maturityDate, Date birthDate, String taxFlag, String clientClass, String documentId, String crRating, String clientStatus, String isIndividual, String inlandOffshore, String clientIndicator, String nation, String ctrlBranch, String spokenLanguage, String issCountry, String repDocumentType, String residentFlag);

    int create(FmClientCopyEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.FmClientCopyEO中不为空的属性写入数据库**/
    int createSelective(FmClientCopyEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.FmClientCopyEO中的属性字段组合 **/
    List<FmClientCopyEO> findByEo(FmClientCopyEO eo);

    /** find 根据主键: 地址、税收居民标识、客户综合评级级别、省代码、证件类型、最后修改时间戳、通用行业代码、首选标志、客户核实结果、国籍、客户细分类型、法定代表人身份证件号码、企业标志、邮政编码、客户名称、行业层级、集团客户分类、教育程度编号、客户简称、城市、联系电话、经营范围、联系类型、法定代表人名称、内部客户标志、客户证件签发地、法人代表证件到期日期、小微企业标志、职业编码、贷款核销标志、创建时间戳、签发日期、客户英文名称、性别、机构内客户标志、手机号码、客户类型、到期日期、出生日期、收税标志、客户类别、证件号码、信用等级、客户状态、对私客户标志、境内境外标志、客户标识、民族、客户号归属机构号、交流语言、发证国家、法定代表人身份证件类型、居民标志 **/
    FmClientCopyEO findByPrimaryKey(String address, String taxResidentFlag, String classLevel, String state, String documentType, String lastUpdTimestamp, String industry, String prefFlag, String clientVerificationResult, String countryLoc, String categoryType, String repDocumentId, String corporationFlag, String postalCode, String clientName, String industryLevel, String ghoCustomerClass, String education, String clientShort, String city, String contactTel, String businessScope, String contactType, String legalRep, String internalIndFlag, String issPlace, Date repExpiryDate, String corpFlag, String occupationCode, String wrnFlag, String createTimestamp, Date issDate, String enClientName, String sex, String branchInnerFlag, String mobilePhone, String clientType, Date maturityDate, Date birthDate, String taxFlag, String clientClass, String documentId, String crRating, String clientStatus, String isIndividual, String inlandOffshore, String clientIndicator, String nation, String ctrlBranch, String spokenLanguage, String issCountry, String repDocumentType, String residentFlag);

    /**  根据主键: 地址、税收居民标识、客户综合评级级别、省代码、证件类型、最后修改时间戳、通用行业代码、首选标志、客户核实结果、国籍、客户细分类型、法定代表人身份证件号码、企业标志、邮政编码、客户名称、行业层级、集团客户分类、教育程度编号、客户简称、城市、联系电话、经营范围、联系类型、法定代表人名称、内部客户标志、客户证件签发地、法人代表证件到期日期、小微企业标志、职业编码、贷款核销标志、创建时间戳、签发日期、客户英文名称、性别、机构内客户标志、手机号码、客户类型、到期日期、出生日期、收税标志、客户类别、证件号码、信用等级、客户状态、对私客户标志、境内境外标志、客户标识、民族、客户号归属机构号、交流语言、发证国家、法定代表人身份证件类型、居民标志执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.FmClientCopyEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(FmClientCopyEO eo);

    /** modify 根据主键: 地址、税收居民标识、客户综合评级级别、省代码、证件类型、最后修改时间戳、通用行业代码、首选标志、客户核实结果、国籍、客户细分类型、法定代表人身份证件号码、企业标志、邮政编码、客户名称、行业层级、集团客户分类、教育程度编号、客户简称、城市、联系电话、经营范围、联系类型、法定代表人名称、内部客户标志、客户证件签发地、法人代表证件到期日期、小微企业标志、职业编码、贷款核销标志、创建时间戳、签发日期、客户英文名称、性别、机构内客户标志、手机号码、客户类型、到期日期、出生日期、收税标志、客户类别、证件号码、信用等级、客户状态、对私客户标志、境内境外标志、客户标识、民族、客户号归属机构号、交流语言、发证国家、法定代表人身份证件类型、居民标志 **/
    int modifyByPrimaryKey(FmClientCopyEO eo);
}