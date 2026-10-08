package com.dcits.depsit.facade.components;

import com.dcits.depsit.enums.CtrlItemType;
import com.dcits.depsit.enums.DealFlow;
import com.dcits.depsit.enums.ResBranchRange;
import com.dcits.depsit.enums.SumType;
import com.dcits.depsit.enums.TermType;
import com.dcits.depsit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.depsit.facade.eo.RbLimitCtrlConfEO;

/*实体表【限额控制配置(RB_LIMIT_CTRL_CONF)】数据服务接口*/
public interface IRbLimitCtrlConfBcc {
    /** count数据库表记录根据入参com.dcits.depsit.facade.eo.RbLimitCtrlConfEO中的属性字段组合 **/
    long countByEo(RbLimitCtrlConfEO eo);

    /** remove数据库表记录根据入参com.dcits.depsit.facade.eo.RbLimitCtrlConfEO中的属性字段组合 **/
    int removeByEo(RbLimitCtrlConfEO eo);

    /** remove 根据主键: 限额机构编码、限额场景编码 **/
    int removeByPrimaryKey(String limitBranchId, String limitSceneNo);

    int create(RbLimitCtrlConfEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.depsit.facade.eo.RbLimitCtrlConfEO中不为空的属性写入数据库**/
    int createSelective(RbLimitCtrlConfEO eo);

    /** find数据库表记录根据入参com.dcits.depsit.facade.eo.RbLimitCtrlConfEO中的属性字段组合 **/
    List<RbLimitCtrlConfEO> findByEo(RbLimitCtrlConfEO eo);

    /** find 根据主键: 限额机构编码、限额场景编码 **/
    RbLimitCtrlConfEO findByPrimaryKey(String limitBranchId, String limitSceneNo);

    /**  根据主键: 限额机构编码、限额场景编码执行更新记录操作，仅更新入参com.dcits.depsit.facade.eo.RbLimitCtrlConfEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbLimitCtrlConfEO eo);

    /** modify 根据主键: 限额机构编码、限额场景编码 **/
    int modifyByPrimaryKey(RbLimitCtrlConfEO eo);
}