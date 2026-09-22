package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SignType;
import java.util.List;

import com.dcits.deposit.facade.eo.RbSignTypeEO;

/*实体表【协议类型参数表(RB_SIGN_TYPE)】数据服务接口*/
public interface IRbSignTypeBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbSignTypeEO中的属性字段组合 **/
    long countByEo(RbSignTypeEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbSignTypeEO中的属性字段组合 **/
    int removeByEo(RbSignTypeEO eo);

    /** remove 根据主键: 签约类型 **/
    int removeByPrimaryKey(String signType);

    int create(RbSignTypeEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbSignTypeEO中不为空的属性写入数据库**/
    int createSelective(RbSignTypeEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbSignTypeEO中的属性字段组合 **/
    List<RbSignTypeEO> findByEo(RbSignTypeEO eo);

    /** find 根据主键: 签约类型 **/
    RbSignTypeEO findByPrimaryKey(String signType);

    /**  根据主键: 签约类型执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbSignTypeEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbSignTypeEO eo);

    /** modify 根据主键: 签约类型 **/
    int modifyByPrimaryKey(RbSignTypeEO eo);

    /**根据签约类型查询表《协议类型参数表(RB_SIGN_TYPE)》**/
    RbSignTypeEO findBySignType(SignType signType);
}