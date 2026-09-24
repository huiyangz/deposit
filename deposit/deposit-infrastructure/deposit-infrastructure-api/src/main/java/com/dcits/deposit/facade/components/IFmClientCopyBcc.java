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

    /** remove 根据主键: 客户号 **/
    int removeByPrimaryKey(String clientNo);

    int create(FmClientCopyEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.FmClientCopyEO中不为空的属性写入数据库**/
    int createSelective(FmClientCopyEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.FmClientCopyEO中的属性字段组合 **/
    List<FmClientCopyEO> findByEo(FmClientCopyEO eo);

    /** find 根据主键: 客户号 **/
    FmClientCopyEO findByPrimaryKey(String clientNo);

    /**  根据主键: 客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.FmClientCopyEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(FmClientCopyEO eo);

    /** modify 根据主键: 客户号 **/
    int modifyByPrimaryKey(FmClientCopyEO eo);
}