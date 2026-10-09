package com.dcits.depsit.facade.components;

import com.dcits.depsit.enums.ChannelClass;
import com.dcits.depsit.enums.SourceType;
import java.util.List;

import com.dcits.depsit.facade.eo.FmChannelEO;

/*实体表【渠道类型表(FM_CHANNEL)】数据服务接口*/
public interface IFmChannelBcc {
    /** count数据库表记录根据入参com.dcits.depsit.facade.eo.FmChannelEO中的属性字段组合 **/
    long countByEo(FmChannelEO eo);

    /** remove数据库表记录根据入参com.dcits.depsit.facade.eo.FmChannelEO中的属性字段组合 **/
    int removeByEo(FmChannelEO eo);

    /** remove 根据主键: 渠道 **/
    int removeByPrimaryKey(String channel);

    int create(FmChannelEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.depsit.facade.eo.FmChannelEO中不为空的属性写入数据库**/
    int createSelective(FmChannelEO eo);

    /** find数据库表记录根据入参com.dcits.depsit.facade.eo.FmChannelEO中的属性字段组合 **/
    List<FmChannelEO> findByEo(FmChannelEO eo);

    /** find 根据主键: 渠道 **/
    FmChannelEO findByPrimaryKey(String channel);

    /**  根据主键: 渠道执行更新记录操作，仅更新入参com.dcits.depsit.facade.eo.FmChannelEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(FmChannelEO eo);

    /** modify 根据主键: 渠道 **/
    int modifyByPrimaryKey(FmChannelEO eo);

    /**根据渠道查询表《渠道类型表(FM_CHANNEL)》**/
    FmChannelEO findByChannel(SourceType channel);
}