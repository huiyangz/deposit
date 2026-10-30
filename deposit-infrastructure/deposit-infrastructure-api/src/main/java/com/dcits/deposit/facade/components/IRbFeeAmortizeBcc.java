package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AmortizeStatus;
import com.dcits.deposit.enums.AmortizeTimeType;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.FeeTakenMode;
import com.dcits.deposit.enums.FeeType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbFeeAmortizeEO;

/*实体表【费用摊销合约表(RB_FEE_AMORTIZE)】数据服务接口*/
public interface IRbFeeAmortizeBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbFeeAmortizeEO中的属性字段组合 **/
    long countByEo(RbFeeAmortizeEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbFeeAmortizeEO中的属性字段组合 **/
    int removeByEo(RbFeeAmortizeEO eo);

    /** remove 根据主键: 摊销编号 **/
    int removeByPrimaryKey(String amortizeId);

    int create(RbFeeAmortizeEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbFeeAmortizeEO中不为空的属性写入数据库**/
    int createSelective(RbFeeAmortizeEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbFeeAmortizeEO中的属性字段组合 **/
    List<RbFeeAmortizeEO> findByEo(RbFeeAmortizeEO eo);

    /** find 根据主键: 摊销编号 **/
    RbFeeAmortizeEO findByPrimaryKey(String amortizeId);

    /**  根据主键: 摊销编号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbFeeAmortizeEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbFeeAmortizeEO eo);

    /** modify 根据主键: 摊销编号 **/
    int modifyByPrimaryKey(RbFeeAmortizeEO eo);
}