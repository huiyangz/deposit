package com.dcits.depsit.facade.components;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.DocType;
import com.dcits.depsit.enums.LostType;
import com.dcits.depsit.enums.RelieveLossType;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.enums.VoucherLostStatus;
import java.util.Date;
import java.util.List;

import com.dcits.depsit.facade.eo.RbVoucherLostEO;

/*实体表【凭证挂失登记簿(RB_VOUCHER_LOST)】数据服务接口*/
public interface IRbVoucherLostBcc {
    /** count数据库表记录根据入参com.dcits.depsit.facade.eo.RbVoucherLostEO中的属性字段组合 **/
    long countByEo(RbVoucherLostEO eo);

    /** remove数据库表记录根据入参com.dcits.depsit.facade.eo.RbVoucherLostEO中的属性字段组合 **/
    int removeByEo(RbVoucherLostEO eo);

    /** remove 根据主键: 挂失键编码、挂失编号 **/
    int removeByPrimaryKey(String lostKey, String lostNo);

    int create(RbVoucherLostEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.depsit.facade.eo.RbVoucherLostEO中不为空的属性写入数据库**/
    int createSelective(RbVoucherLostEO eo);

    /** find数据库表记录根据入参com.dcits.depsit.facade.eo.RbVoucherLostEO中的属性字段组合 **/
    List<RbVoucherLostEO> findByEo(RbVoucherLostEO eo);

    /** find 根据主键: 挂失键编码、挂失编号 **/
    RbVoucherLostEO findByPrimaryKey(String lostKey, String lostNo);

    /**  根据主键: 挂失键编码、挂失编号执行更新记录操作，仅更新入参com.dcits.depsit.facade.eo.RbVoucherLostEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbVoucherLostEO eo);

    /** modify 根据主键: 挂失键编码、挂失编号 **/
    int modifyByPrimaryKey(RbVoucherLostEO eo);
}