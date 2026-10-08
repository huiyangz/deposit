package com.dcits.depsit.facade.components;

import com.dcits.depsit.enums.ChannelClass;
import com.dcits.depsit.enums.SourceType;
import java.util.List;

import com.dcits.depsit.facade.eo.RbChannelClassEO;

/*实体表【渠道类型(RB_CHANNEL_CLASS)】数据服务接口*/
public interface IRbChannelClassBcc {
    /** count数据库表记录根据入参com.dcits.depsit.facade.eo.RbChannelClassEO中的属性字段组合 **/
    long countByEo(RbChannelClassEO eo);

    /** remove数据库表记录根据入参com.dcits.depsit.facade.eo.RbChannelClassEO中的属性字段组合 **/
    int removeByEo(RbChannelClassEO eo);

    /** remove 根据主键: 渠道 **/
    int removeByPrimaryKey(String channel);

    int create(RbChannelClassEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.depsit.facade.eo.RbChannelClassEO中不为空的属性写入数据库**/
    int createSelective(RbChannelClassEO eo);

    /** find数据库表记录根据入参com.dcits.depsit.facade.eo.RbChannelClassEO中的属性字段组合 **/
    List<RbChannelClassEO> findByEo(RbChannelClassEO eo);

    /** find 根据主键: 渠道 **/
    RbChannelClassEO findByPrimaryKey(String channel);

    /**  根据主键: 渠道执行更新记录操作，仅更新入参com.dcits.depsit.facade.eo.RbChannelClassEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbChannelClassEO eo);

    /** modify 根据主键: 渠道 **/
    int modifyByPrimaryKey(RbChannelClassEO eo);

    /**根据渠道查询表《渠道类型(RB_CHANNEL_CLASS)》**/
    RbChannelClassEO findByChannel(SourceType channel);
}