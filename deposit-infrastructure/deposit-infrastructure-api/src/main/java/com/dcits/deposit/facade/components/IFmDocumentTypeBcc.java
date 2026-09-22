package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AppInd;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IndividualFlag;
import java.util.List;

import com.dcits.deposit.facade.eo.FmDocumentTypeEO;

/*实体表【证件类型表(FM_DOCUMENT_TYPE)】数据服务接口*/
public interface IFmDocumentTypeBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.FmDocumentTypeEO中的属性字段组合 **/
    long countByEo(FmDocumentTypeEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.FmDocumentTypeEO中的属性字段组合 **/
    int removeByEo(FmDocumentTypeEO eo);

    /** remove 根据主键: 证件类型 **/
    int removeByPrimaryKey(String documentType);

    int create(FmDocumentTypeEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.FmDocumentTypeEO中不为空的属性写入数据库**/
    int createSelective(FmDocumentTypeEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.FmDocumentTypeEO中的属性字段组合 **/
    List<FmDocumentTypeEO> findByEo(FmDocumentTypeEO eo);

    /** find 根据主键: 证件类型 **/
    FmDocumentTypeEO findByPrimaryKey(String documentType);

    /**  根据主键: 证件类型执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.FmDocumentTypeEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(FmDocumentTypeEO eo);

    /** modify 根据主键: 证件类型 **/
    int modifyByPrimaryKey(FmDocumentTypeEO eo);

    /**根据证件类型查询表《证件类型表(FM_DOCUMENT_TYPE)》**/
    FmDocumentTypeEO findByDocumentType(DocumentType documentType);
}