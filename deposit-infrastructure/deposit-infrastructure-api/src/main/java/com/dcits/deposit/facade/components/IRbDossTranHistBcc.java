package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IntIndFlag;
import com.dcits.deposit.enums.TranStatus;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbDossTranHistEO;

/*实体表【久悬户交易流水表(RB_DOSS_TRAN_HIST)】数据服务接口*/
public interface IRbDossTranHistBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbDossTranHistEO中的属性字段组合 **/
    long countByEo(RbDossTranHistEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbDossTranHistEO中的属性字段组合 **/
    int removeByEo(RbDossTranHistEO eo);

    /** remove 根据主键: 序号、客户号、账户内部键值 **/
    int removeByPrimaryKey(String seqNo, String clientNo, Integer internalKey);

    int create(RbDossTranHistEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbDossTranHistEO中不为空的属性写入数据库**/
    int createSelective(RbDossTranHistEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbDossTranHistEO中的属性字段组合 **/
    List<RbDossTranHistEO> findByEo(RbDossTranHistEO eo);

    /** find 根据主键: 序号、客户号、账户内部键值 **/
    RbDossTranHistEO findByPrimaryKey(String seqNo, String clientNo, Integer internalKey);

    /**  根据主键: 序号、客户号、账户内部键值执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbDossTranHistEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbDossTranHistEO eo);

    /** modify 根据主键: 序号、客户号、账户内部键值 **/
    int modifyByPrimaryKey(RbDossTranHistEO eo);
}