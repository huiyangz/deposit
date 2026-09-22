package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.ApprType;
import com.dcits.deposit.enums.CashItem;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranCategory;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbApprLetterTranHistEO;

/*实体表【核准件交易流水表(RB_APPR_LETTER_TRAN_HIST)】数据服务接口*/
public interface IRbApprLetterTranHistBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbApprLetterTranHistEO中的属性字段组合 **/
    long countByEo(RbApprLetterTranHistEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbApprLetterTranHistEO中的属性字段组合 **/
    int removeByEo(RbApprLetterTranHistEO eo);

    /** remove 根据主键: 序号、客户号 **/
    int removeByPrimaryKey(String seqNo, String clientNo);

    int create(RbApprLetterTranHistEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbApprLetterTranHistEO中不为空的属性写入数据库**/
    int createSelective(RbApprLetterTranHistEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbApprLetterTranHistEO中的属性字段组合 **/
    List<RbApprLetterTranHistEO> findByEo(RbApprLetterTranHistEO eo);

    /** find 根据主键: 序号、客户号 **/
    RbApprLetterTranHistEO findByPrimaryKey(String seqNo, String clientNo);

    /**  根据主键: 序号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbApprLetterTranHistEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbApprLetterTranHistEO eo);

    /** modify 根据主键: 序号、客户号 **/
    int modifyByPrimaryKey(RbApprLetterTranHistEO eo);
}