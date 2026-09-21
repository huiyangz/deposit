package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.VoucherStatus;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.TbVoucherInfoEO;

/*实体表【尾箱凭证表(TB_VOUCHER_INFO)】数据服务接口*/
public interface ITbVoucherInfoBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.TbVoucherInfoEO中的属性字段组合 **/
    long countByEo(TbVoucherInfoEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.TbVoucherInfoEO中的属性字段组合 **/
    int removeByEo(TbVoucherInfoEO eo);

    /** remove 根据主键: 凭证主键 **/
    int removeByPrimaryKey(Integer voucherId);

    int create(TbVoucherInfoEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.TbVoucherInfoEO中不为空的属性写入数据库**/
    int createSelective(TbVoucherInfoEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.TbVoucherInfoEO中的属性字段组合 **/
    List<TbVoucherInfoEO> findByEo(TbVoucherInfoEO eo);

    /** find 根据主键: 凭证主键 **/
    TbVoucherInfoEO findByPrimaryKey(Integer voucherId);

    /**  根据主键: 凭证主键执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.TbVoucherInfoEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(TbVoucherInfoEO eo);

    /** modify 根据主键: 凭证主键 **/
    int modifyByPrimaryKey(TbVoucherInfoEO eo);
}