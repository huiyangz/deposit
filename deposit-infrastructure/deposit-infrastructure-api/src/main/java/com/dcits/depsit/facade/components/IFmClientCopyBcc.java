package com.dcits.depsit.facade.components;

import com.dcits.depsit.enums.CategoryType;
import com.dcits.depsit.enums.City;
import com.dcits.depsit.enums.ClassLevel;
import com.dcits.depsit.enums.ClientClass;
import com.dcits.depsit.enums.ClientIndicator;
import com.dcits.depsit.enums.ClientStatus;
import com.dcits.depsit.enums.ClientType;
import com.dcits.depsit.enums.ClientVerificationResult;
import com.dcits.depsit.enums.ContactType;
import com.dcits.depsit.enums.CountryLoc;
import com.dcits.depsit.enums.CrRating;
import com.dcits.depsit.enums.Education;
import com.dcits.depsit.enums.Industry;
import com.dcits.depsit.enums.IndustryLevel;
import com.dcits.depsit.enums.IssCountry;
import com.dcits.depsit.enums.Nation;
import com.dcits.depsit.enums.OccupationCode;
import com.dcits.depsit.enums.Sex;
import com.dcits.depsit.enums.SpokenLanguage;
import com.dcits.depsit.enums.State;
import com.dcits.depsit.enums.TaxFlag;
import com.dcits.depsit.enums.TaxResidentFlag;
import com.dcits.depsit.enums.ThawDocumentType2;
import com.dcits.depsit.enums.TranBranch;
import java.util.Date;
import java.util.List;

import com.dcits.depsit.facade.eo.FmClientCopyEO;

/*实体表【客户副本表(FM_CLIENT_COPY)】数据服务接口*/
public interface IFmClientCopyBcc {
    /** count数据库表记录根据入参com.dcits.depsit.facade.eo.FmClientCopyEO中的属性字段组合 **/
    long countByEo(FmClientCopyEO eo);

    /** remove数据库表记录根据入参com.dcits.depsit.facade.eo.FmClientCopyEO中的属性字段组合 **/
    int removeByEo(FmClientCopyEO eo);

    /** remove 根据主键: 客户号 **/
    int removeByPrimaryKey(String clientNo);

    int create(FmClientCopyEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.depsit.facade.eo.FmClientCopyEO中不为空的属性写入数据库**/
    int createSelective(FmClientCopyEO eo);

    /** find数据库表记录根据入参com.dcits.depsit.facade.eo.FmClientCopyEO中的属性字段组合 **/
    List<FmClientCopyEO> findByEo(FmClientCopyEO eo);

    /** find 根据主键: 客户号 **/
    FmClientCopyEO findByPrimaryKey(String clientNo);

    /**  根据主键: 客户号执行更新记录操作，仅更新入参com.dcits.depsit.facade.eo.FmClientCopyEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(FmClientCopyEO eo);

    /** modify 根据主键: 客户号 **/
    int modifyByPrimaryKey(FmClientCopyEO eo);
}