package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.Status;
import java.util.List;

import com.dcits.deposit.facade.eo.RbTranSceneMappingEO;

/*实体表【存款场景映射表(RB_TRAN_SCENE_MAPPING)】数据服务接口*/
public interface IRbTranSceneMappingBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbTranSceneMappingEO中的属性字段组合 **/
    long countByEo(RbTranSceneMappingEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbTranSceneMappingEO中的属性字段组合 **/
    int removeByEo(RbTranSceneMappingEO eo);

    /** remove 根据主键: 交易场景编码 **/
    int removeByPrimaryKey(String tranScene);

    int create(RbTranSceneMappingEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbTranSceneMappingEO中不为空的属性写入数据库**/
    int createSelective(RbTranSceneMappingEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbTranSceneMappingEO中的属性字段组合 **/
    List<RbTranSceneMappingEO> findByEo(RbTranSceneMappingEO eo);

    /** find 根据主键: 交易场景编码 **/
    RbTranSceneMappingEO findByPrimaryKey(String tranScene);

    /**  根据主键: 交易场景编码执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbTranSceneMappingEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbTranSceneMappingEO eo);

    /** modify 根据主键: 交易场景编码 **/
    int modifyByPrimaryKey(RbTranSceneMappingEO eo);
}