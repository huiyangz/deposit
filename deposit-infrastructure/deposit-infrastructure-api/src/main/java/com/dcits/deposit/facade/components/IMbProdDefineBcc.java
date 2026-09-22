package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.EventDefault;
import com.dcits.deposit.enums.Status;
import java.util.List;

import com.dcits.deposit.facade.eo.MbProdDefineEO;

/*实体表【产品定义表(MB_PROD_DEFINE)】数据服务接口*/
public interface IMbProdDefineBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.MbProdDefineEO中的属性字段组合 **/
    long countByEo(MbProdDefineEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.MbProdDefineEO中的属性字段组合 **/
    int removeByEo(MbProdDefineEO eo);

    /** remove 根据主键: 产品类型、序号、法人 **/
    int removeByPrimaryKey(String prodType, String seqNo, String company);

    int create(MbProdDefineEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.MbProdDefineEO中不为空的属性写入数据库**/
    int createSelective(MbProdDefineEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.MbProdDefineEO中的属性字段组合 **/
    List<MbProdDefineEO> findByEo(MbProdDefineEO eo);

    /** find 根据主键: 产品类型、序号、法人 **/
    MbProdDefineEO findByPrimaryKey(String prodType, String seqNo, String company);

    /**  根据主键: 产品类型、序号、法人执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.MbProdDefineEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(MbProdDefineEO eo);

    /** modify 根据主键: 产品类型、序号、法人 **/
    int modifyByPrimaryKey(MbProdDefineEO eo);
}