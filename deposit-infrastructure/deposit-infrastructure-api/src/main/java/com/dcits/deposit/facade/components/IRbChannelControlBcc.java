package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.ControlStatus;
import com.dcits.deposit.enums.ControlType;
import java.util.List;

import com.dcits.deposit.facade.eo.RbChannelControlEO;

/*实体表【渠道控制表(RB_CHANNEL_CONTROL)】数据服务接口*/
public interface IRbChannelControlBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbChannelControlEO中的属性字段组合 **/
    long countByEo(RbChannelControlEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbChannelControlEO中的属性字段组合 **/
    int removeByEo(RbChannelControlEO eo);

    /** remove 根据主键: 控制编号、客户号 **/
    int removeByPrimaryKey(String controlSeqNo, String clientNo);

    int create(RbChannelControlEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbChannelControlEO中不为空的属性写入数据库**/
    int createSelective(RbChannelControlEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbChannelControlEO中的属性字段组合 **/
    List<RbChannelControlEO> findByEo(RbChannelControlEO eo);

    /** find 根据主键: 控制编号、客户号 **/
    RbChannelControlEO findByPrimaryKey(String controlSeqNo, String clientNo);

    /**  根据主键: 控制编号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbChannelControlEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbChannelControlEO eo);

    /** modify 根据主键: 控制编号、客户号 **/
    int modifyByPrimaryKey(RbChannelControlEO eo);
}