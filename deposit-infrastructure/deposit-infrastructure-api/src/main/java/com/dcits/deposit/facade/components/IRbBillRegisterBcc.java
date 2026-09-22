package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.BillBusiType;
import com.dcits.deposit.enums.BillIssueType;
import com.dcits.deposit.enums.BillPaymentStatus;
import com.dcits.deposit.enums.BillStatus;
import com.dcits.deposit.enums.BillType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.ReturnType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBillRegisterEO;

/*实体表【票据签发登记簿(RB_BILL_REGISTER)】数据服务接口*/
public interface IRbBillRegisterBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBillRegisterEO中的属性字段组合 **/
    long countByEo(RbBillRegisterEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBillRegisterEO中的属性字段组合 **/
    int removeByEo(RbBillRegisterEO eo);

    /** remove 根据主键: 票据业务编号、客户号 **/
    int removeByPrimaryKey(String billSerialNo, String clientNo);

    int create(RbBillRegisterEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBillRegisterEO中不为空的属性写入数据库**/
    int createSelective(RbBillRegisterEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBillRegisterEO中的属性字段组合 **/
    List<RbBillRegisterEO> findByEo(RbBillRegisterEO eo);

    /** find 根据主键: 票据业务编号、客户号 **/
    RbBillRegisterEO findByPrimaryKey(String billSerialNo, String clientNo);

    /**  根据主键: 票据业务编号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBillRegisterEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBillRegisterEO eo);

    /** modify 根据主键: 票据业务编号、客户号 **/
    int modifyByPrimaryKey(RbBillRegisterEO eo);
}