package com.dcits.depsit.facade.components;

import com.dcits.depsit.enums.AppointmentStatus;
import com.dcits.depsit.enums.CategoryType;
import com.dcits.depsit.enums.ClientType;
import com.dcits.depsit.enums.DocumentType;
import com.dcits.depsit.enums.IssCountry;
import com.dcits.depsit.enums.RbAcctType;
import com.dcits.depsit.enums.TranBranch;
import java.util.Date;
import java.util.List;

import com.dcits.depsit.facade.eo.RbBusAcctAppointmentEO;

/*实体表【对公客户账户预约表(RB_BUS_ACCT_APPOINTMENT)】数据服务接口*/
public interface IRbBusAcctAppointmentBcc {
    /** count数据库表记录根据入参com.dcits.depsit.facade.eo.RbBusAcctAppointmentEO中的属性字段组合 **/
    long countByEo(RbBusAcctAppointmentEO eo);

    /** remove数据库表记录根据入参com.dcits.depsit.facade.eo.RbBusAcctAppointmentEO中的属性字段组合 **/
    int removeByEo(RbBusAcctAppointmentEO eo);

    /** remove 根据主键: 预约编号 **/
    int removeByPrimaryKey(String orderNo);

    int create(RbBusAcctAppointmentEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.depsit.facade.eo.RbBusAcctAppointmentEO中不为空的属性写入数据库**/
    int createSelective(RbBusAcctAppointmentEO eo);

    /** find数据库表记录根据入参com.dcits.depsit.facade.eo.RbBusAcctAppointmentEO中的属性字段组合 **/
    List<RbBusAcctAppointmentEO> findByEo(RbBusAcctAppointmentEO eo);

    /** find 根据主键: 预约编号 **/
    RbBusAcctAppointmentEO findByPrimaryKey(String orderNo);

    /**  根据主键: 预约编号执行更新记录操作，仅更新入参com.dcits.depsit.facade.eo.RbBusAcctAppointmentEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusAcctAppointmentEO eo);

    /** modify 根据主键: 预约编号 **/
    int modifyByPrimaryKey(RbBusAcctAppointmentEO eo);
}