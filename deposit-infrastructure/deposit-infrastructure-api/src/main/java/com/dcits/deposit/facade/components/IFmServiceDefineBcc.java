package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcrossBranCheckFlag;
import com.dcits.deposit.enums.AllowReverseFlag;
import com.dcits.deposit.enums.BlacklistCheckFlag;
import com.dcits.deposit.enums.BusiCategory;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.MultiCorpCheckFlag;
import java.util.List;

import com.dcits.deposit.facade.eo.FmServiceDefineEO;

/*实体表【核心服务定义表(FM_SERVICE_DEFINE)】数据服务接口*/
public interface IFmServiceDefineBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.FmServiceDefineEO中的属性字段组合 **/
    long countByEo(FmServiceDefineEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.FmServiceDefineEO中的属性字段组合 **/
    int removeByEo(FmServiceDefineEO eo);

    /** remove 根据主键: 服务代码、接口服务类型、接口服务代码 **/
    int removeByPrimaryKey(String serviceCode, String messageType, String messageCode);

    int create(FmServiceDefineEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.FmServiceDefineEO中不为空的属性写入数据库**/
    int createSelective(FmServiceDefineEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.FmServiceDefineEO中的属性字段组合 **/
    List<FmServiceDefineEO> findByEo(FmServiceDefineEO eo);

    /** find 根据主键: 服务代码、接口服务类型、接口服务代码 **/
    FmServiceDefineEO findByPrimaryKey(String serviceCode, String messageType, String messageCode);

    /**  根据主键: 服务代码、接口服务类型、接口服务代码执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.FmServiceDefineEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(FmServiceDefineEO eo);

    /** modify 根据主键: 服务代码、接口服务类型、接口服务代码 **/
    int modifyByPrimaryKey(FmServiceDefineEO eo);
}