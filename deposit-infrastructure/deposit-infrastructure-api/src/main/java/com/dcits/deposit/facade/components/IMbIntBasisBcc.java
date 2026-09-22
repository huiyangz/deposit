package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IntBasis;
import java.util.List;

import com.dcits.deposit.facade.eo.MbIntBasisEO;

/*实体表【基准利率类型表(MB_INT_BASIS)】数据服务接口*/
public interface IMbIntBasisBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.MbIntBasisEO中的属性字段组合 **/
    long countByEo(MbIntBasisEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.MbIntBasisEO中的属性字段组合 **/
    int removeByEo(MbIntBasisEO eo);

    /** remove 根据主键: 基准利率类型 **/
    int removeByPrimaryKey(String intBasis);

    int create(MbIntBasisEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.MbIntBasisEO中不为空的属性写入数据库**/
    int createSelective(MbIntBasisEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.MbIntBasisEO中的属性字段组合 **/
    List<MbIntBasisEO> findByEo(MbIntBasisEO eo);

    /** find 根据主键: 基准利率类型 **/
    MbIntBasisEO findByPrimaryKey(String intBasis);

    /**  根据主键: 基准利率类型执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.MbIntBasisEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(MbIntBasisEO eo);

    /** modify 根据主键: 基准利率类型 **/
    int modifyByPrimaryKey(MbIntBasisEO eo);

    /**根据基准利率类型查询表《基准利率类型表(MB_INT_BASIS)》**/
    MbIntBasisEO findByIntBasis(IntBasis intBasis);
}