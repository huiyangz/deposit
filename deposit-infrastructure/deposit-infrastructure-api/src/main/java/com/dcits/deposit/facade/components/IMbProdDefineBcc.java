package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.BranchType;
import com.dcits.deposit.enums.City;
import com.dcits.deposit.enums.EventDefault;
import com.dcits.deposit.enums.HierarchyCode;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.State;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.enums.TranBranch;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.MbProdDefineEO;

/*实体表【产品定义表(MB_PROD_DEFINE)】数据服务接口*/
public interface IMbProdDefineBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.MbProdDefineEO中的属性字段组合 **/
    long countByEo(MbProdDefineEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.MbProdDefineEO中的属性字段组合 **/
    int removeByEo(MbProdDefineEO eo);

    /** remove 根据主键: 序号、产品编号 **/
    int removeByPrimaryKey(String seqNo, String prodNo);

    int create(MbProdDefineEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.MbProdDefineEO中不为空的属性写入数据库**/
    int createSelective(MbProdDefineEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.MbProdDefineEO中的属性字段组合 **/
    List<MbProdDefineEO> findByEo(MbProdDefineEO eo);

    /** find 根据主键: 序号、产品编号 **/
    MbProdDefineEO findByPrimaryKey(String seqNo, String prodNo);

    /**  根据主键: 序号、产品编号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.MbProdDefineEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(MbProdDefineEO eo);

    /** modify 根据主键: 序号、产品编号 **/
    int modifyByPrimaryKey(MbProdDefineEO eo);
}