package com.dcits.depsit.facade.components;

import com.dcits.depsit.enums.IssCountry;
import com.dcits.depsit.enums.ListCategory;
import com.dcits.depsit.enums.ListOrg;
import com.dcits.depsit.enums.RcBlackStatus;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.ThawDocumentType2;
import com.dcits.depsit.enums.TranBranch;
import java.util.Date;
import java.util.List;

import com.dcits.depsit.facade.eo.RcAllListEO;

/*实体表【名单信息表(RC_ALL_LIST)】数据服务接口*/
public interface IRcAllListBcc {
    /** count数据库表记录根据入参com.dcits.depsit.facade.eo.RcAllListEO中的属性字段组合 **/
    long countByEo(RcAllListEO eo);

    /** remove数据库表记录根据入参com.dcits.depsit.facade.eo.RcAllListEO中的属性字段组合 **/
    int removeByEo(RcAllListEO eo);

    /** remove 根据主键: 黑名单序号 **/
    int removeByPrimaryKey(String rcSeqNo);

    int create(RcAllListEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.depsit.facade.eo.RcAllListEO中不为空的属性写入数据库**/
    int createSelective(RcAllListEO eo);

    /** find数据库表记录根据入参com.dcits.depsit.facade.eo.RcAllListEO中的属性字段组合 **/
    List<RcAllListEO> findByEo(RcAllListEO eo);

    /** find 根据主键: 黑名单序号 **/
    RcAllListEO findByPrimaryKey(String rcSeqNo);

    /**  根据主键: 黑名单序号执行更新记录操作，仅更新入参com.dcits.depsit.facade.eo.RcAllListEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RcAllListEO eo);

    /** modify 根据主键: 黑名单序号 **/
    int modifyByPrimaryKey(RcAllListEO eo);
}