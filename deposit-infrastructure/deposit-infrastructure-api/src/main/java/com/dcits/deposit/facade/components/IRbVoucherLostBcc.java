package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.LostType;
import com.dcits.deposit.enums.RelieveLossType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.VoucherLostStatus;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbVoucherLostEO;

/*实体表【凭证挂失登记簿(RB_VOUCHER_LOST)】数据服务接口*/
public interface IRbVoucherLostBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbVoucherLostEO中的属性字段组合 **/
    long countByEo(RbVoucherLostEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbVoucherLostEO中的属性字段组合 **/
    int removeByEo(RbVoucherLostEO eo);

    /** remove 根据主键: 挂失键编码、挂失编号 **/
    int removeByPrimaryKey(String lostKey, String lostNo);

    int create(RbVoucherLostEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbVoucherLostEO中不为空的属性写入数据库**/
    int createSelective(RbVoucherLostEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbVoucherLostEO中的属性字段组合 **/
    List<RbVoucherLostEO> findByEo(RbVoucherLostEO eo);

    /** find 根据主键: 挂失键编码、挂失编号 **/
    RbVoucherLostEO findByPrimaryKey(String lostKey, String lostNo);

    /**  根据主键: 挂失键编码、挂失编号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbVoucherLostEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbVoucherLostEO eo);

    /** modify 根据主键: 挂失键编码、挂失编号 **/
    int modifyByPrimaryKey(RbVoucherLostEO eo);
}