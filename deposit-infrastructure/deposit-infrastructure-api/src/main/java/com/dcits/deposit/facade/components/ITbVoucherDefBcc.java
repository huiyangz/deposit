package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DepositType;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.SaleFlag;
import com.dcits.deposit.enums.VoucherApproveStatus;
import com.dcits.deposit.enums.VoucherBillInd;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.TbVoucherDefEO;

/*实体表【凭证类型定义表(TB_VOUCHER_DEF)】数据服务接口*/
public interface ITbVoucherDefBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.TbVoucherDefEO中的属性字段组合 **/
    long countByEo(TbVoucherDefEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.TbVoucherDefEO中的属性字段组合 **/
    int removeByEo(TbVoucherDefEO eo);

    /** remove 根据主键: 凭证类型 **/
    int removeByPrimaryKey(String docType);

    int create(TbVoucherDefEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.TbVoucherDefEO中不为空的属性写入数据库**/
    int createSelective(TbVoucherDefEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.TbVoucherDefEO中的属性字段组合 **/
    List<TbVoucherDefEO> findByEo(TbVoucherDefEO eo);

    /** find 根据主键: 凭证类型 **/
    TbVoucherDefEO findByPrimaryKey(String docType);

    /**  根据主键: 凭证类型执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.TbVoucherDefEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(TbVoucherDefEO eo);

    /** modify 根据主键: 凭证类型 **/
    int modifyByPrimaryKey(TbVoucherDefEO eo);

    /**根据凭证类型查询表《凭证类型定义表(TB_VOUCHER_DEF)》**/
    TbVoucherDefEO findByDocType(DocType docType);
}