package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CtrlItemType;
import com.dcits.deposit.enums.IndividualFlag;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbLimitCtrlCustomInfoEO;

/*实体表【限额控制客户自定义配置(RB_LIMIT_CTRL_CUSTOM_INFO)】数据服务接口*/
public interface IRbLimitCtrlCustomInfoBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbLimitCtrlCustomInfoEO中的属性字段组合 **/
    long countByEo(RbLimitCtrlCustomInfoEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbLimitCtrlCustomInfoEO中的属性字段组合 **/
    int removeByEo(RbLimitCtrlCustomInfoEO eo);

    /** remove 根据主键: 客户号、限额场景编码、限额检查对象值 **/
    int removeByPrimaryKey(String clientNo, String limitSceneNo, String checkObjVal);

    int create(RbLimitCtrlCustomInfoEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbLimitCtrlCustomInfoEO中不为空的属性写入数据库**/
    int createSelective(RbLimitCtrlCustomInfoEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbLimitCtrlCustomInfoEO中的属性字段组合 **/
    List<RbLimitCtrlCustomInfoEO> findByEo(RbLimitCtrlCustomInfoEO eo);

    /** find 根据主键: 客户号、限额场景编码、限额检查对象值 **/
    RbLimitCtrlCustomInfoEO findByPrimaryKey(String clientNo, String limitSceneNo, String checkObjVal);

    /**  根据主键: 客户号、限额场景编码、限额检查对象值执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbLimitCtrlCustomInfoEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbLimitCtrlCustomInfoEO eo);

    /** modify 根据主键: 客户号、限额场景编码、限额检查对象值 **/
    int modifyByPrimaryKey(RbLimitCtrlCustomInfoEO eo);
}