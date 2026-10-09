package com.dcits.depsit.facade.components;

import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.enums.AcctOperateType;
import com.dcits.depsit.enums.AcctStatus;
import com.dcits.depsit.enums.NatureProperty;
import com.dcits.depsit.enums.RbBusAcctPurpose;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.TermType;
import java.util.List;

import com.dcits.depsit.facade.eo.RbCorpNatureDefEO;

/*实体表【企业账户属性控制配置表(RB_CORP_NATURE_DEF)】数据服务接口*/
public interface IRbCorpNatureDefBcc {
    /** count数据库表记录根据入参com.dcits.depsit.facade.eo.RbCorpNatureDefEO中的属性字段组合 **/
    long countByEo(RbCorpNatureDefEO eo);

    /** remove数据库表记录根据入参com.dcits.depsit.facade.eo.RbCorpNatureDefEO中的属性字段组合 **/
    int removeByEo(RbCorpNatureDefEO eo);

    /** remove 根据主键: 序号 **/
    int removeByPrimaryKey(String seqNo);

    int create(RbCorpNatureDefEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.depsit.facade.eo.RbCorpNatureDefEO中不为空的属性写入数据库**/
    int createSelective(RbCorpNatureDefEO eo);

    /** find数据库表记录根据入参com.dcits.depsit.facade.eo.RbCorpNatureDefEO中的属性字段组合 **/
    List<RbCorpNatureDefEO> findByEo(RbCorpNatureDefEO eo);

    /** find 根据主键: 序号 **/
    RbCorpNatureDefEO findByPrimaryKey(String seqNo);

    /**  根据主键: 序号执行更新记录操作，仅更新入参com.dcits.depsit.facade.eo.RbCorpNatureDefEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbCorpNatureDefEO eo);

    /** modify 根据主键: 序号 **/
    int modifyByPrimaryKey(RbCorpNatureDefEO eo);
}