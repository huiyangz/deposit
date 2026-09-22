package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import java.math.BigDecimal;
import java.util.List;

import com.dcits.deposit.facade.eo.MbProdGroupEO;

/*实体表【产品组定义表(MB_PROD_GROUP)】数据服务接口*/
public interface IMbProdGroupBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.MbProdGroupEO中的属性字段组合 **/
    long countByEo(MbProdGroupEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.MbProdGroupEO中的属性字段组合 **/
    int removeByEo(MbProdGroupEO eo);

    /** remove 根据主键: 产品类型、产品子类型、法人 **/
    int removeByPrimaryKey(String prodType, String prodSubType, String company);

    int create(MbProdGroupEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.MbProdGroupEO中不为空的属性写入数据库**/
    int createSelective(MbProdGroupEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.MbProdGroupEO中的属性字段组合 **/
    List<MbProdGroupEO> findByEo(MbProdGroupEO eo);

    /** find 根据主键: 产品类型、产品子类型、法人 **/
    MbProdGroupEO findByPrimaryKey(String prodType, String prodSubType, String company);

    /**  根据主键: 产品类型、产品子类型、法人执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.MbProdGroupEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(MbProdGroupEO eo);

    /** modify 根据主键: 产品类型、产品子类型、法人 **/
    int modifyByPrimaryKey(MbProdGroupEO eo);
}