package com.dcits.depsit.facade.components;

import com.dcits.depsit.enums.Ccy;
import com.dcits.depsit.enums.IntBasis;
import com.dcits.depsit.enums.IntType;
import com.dcits.depsit.enums.RollFreq;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.enums.YearBasisType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.depsit.facade.eo.MbIntMatrixEO;

/*实体表【利率税率阶梯表(MB_INT_MATRIX)】数据服务接口*/
public interface IMbIntMatrixBcc {
    /** count数据库表记录根据入参com.dcits.depsit.facade.eo.MbIntMatrixEO中的属性字段组合 **/
    long countByEo(MbIntMatrixEO eo);

    /** remove数据库表记录根据入参com.dcits.depsit.facade.eo.MbIntMatrixEO中的属性字段组合 **/
    int removeByEo(MbIntMatrixEO eo);

    /** remove 根据主键: 阶梯序号 **/
    int removeByPrimaryKey(String matrixNo);

    int create(MbIntMatrixEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.depsit.facade.eo.MbIntMatrixEO中不为空的属性写入数据库**/
    int createSelective(MbIntMatrixEO eo);

    /** find数据库表记录根据入参com.dcits.depsit.facade.eo.MbIntMatrixEO中的属性字段组合 **/
    List<MbIntMatrixEO> findByEo(MbIntMatrixEO eo);

    /** find 根据主键: 阶梯序号 **/
    MbIntMatrixEO findByPrimaryKey(String matrixNo);

    /**  根据主键: 阶梯序号执行更新记录操作，仅更新入参com.dcits.depsit.facade.eo.MbIntMatrixEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(MbIntMatrixEO eo);

    /** modify 根据主键: 阶梯序号 **/
    int modifyByPrimaryKey(MbIntMatrixEO eo);
}