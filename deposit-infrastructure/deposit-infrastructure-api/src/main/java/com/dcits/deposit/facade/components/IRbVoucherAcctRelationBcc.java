package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.CanReasonCode;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.VoucherStatus;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbVoucherAcctRelationEO;

/*实体表【凭证账户关系表(RB_VOUCHER_ACCT_RELATION)】数据服务接口*/
public interface IRbVoucherAcctRelationBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbVoucherAcctRelationEO中的属性字段组合 **/
    long countByEo(RbVoucherAcctRelationEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbVoucherAcctRelationEO中的属性字段组合 **/
    int removeByEo(RbVoucherAcctRelationEO eo);

    /** remove 根据主键: 账号/卡号、凭证类型、凭证号、客户号 **/
    int removeByPrimaryKey(String baseAcctNo, String docType, String voucherNo, String clientNo);

    int create(RbVoucherAcctRelationEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbVoucherAcctRelationEO中不为空的属性写入数据库**/
    int createSelective(RbVoucherAcctRelationEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbVoucherAcctRelationEO中的属性字段组合 **/
    List<RbVoucherAcctRelationEO> findByEo(RbVoucherAcctRelationEO eo);

    /** find 根据主键: 账号/卡号、凭证类型、凭证号、客户号 **/
    RbVoucherAcctRelationEO findByPrimaryKey(String baseAcctNo, String docType, String voucherNo, String clientNo);

    /**  根据主键: 账号/卡号、凭证类型、凭证号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbVoucherAcctRelationEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbVoucherAcctRelationEO eo);

    /** modify 根据主键: 账号/卡号、凭证类型、凭证号、客户号 **/
    int modifyByPrimaryKey(RbVoucherAcctRelationEO eo);
}