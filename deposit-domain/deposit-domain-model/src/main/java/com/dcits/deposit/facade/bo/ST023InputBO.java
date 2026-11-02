package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.CommissionRelation;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IssCountry;
import java.util.Date;

/**
 * ST023 登记代办人信息 步骤输入。
 *
 * <p>字段与正式 Spec「输入」表一致；「必填 / 非必填」按输入表标注记录。
 * 代办人信息数组本身未在输入表声明，其来源与结构见 Spec 待确认事项 1、2。</p>
 */
public class ST023InputBO {

    /** 交易参考号（必填） */
    private String reference;

    /** 代办人名称（必填） */
    private String commissionClientName;

    /** 代办人客户号（非必填） */
    private String commissionClientNo;

    /** 代办人证件号码（必填） */
    private String commissionDocumentId;

    /** 代办人证件类型（必填） */
    private DocumentType commissionDocumentType;

    /** 国家（必填） */
    private IssCountry country;

    /** 代办人证件开始日期（必填） */
    private Date commissionStartDate;

    /** 代办人证件到期日期（必填） */
    private Date commissionExpireDate;

    /** 代办人电话（必填） */
    private String commissionClientTel;

    /** 代办原因（非必填） */
    private String commissionReason;

    /** 代办人关系类型（非必填） */
    private CommissionRelation commissionRelation;

    /** 代办核实员工号1（非必填） */
    private String commissionConfirmUserIdKey1;

    /** 代办核实员工号2（非必填） */
    private String commissionConfirmUserIdKey2;

    /** 核实电话号码（非必填） */
    private String commissionConfirmTel;

    /** 代办核实时间（非必填） */
    private String commissionConfirmTime;

    /** 代办人核实结果（非必填） */
    private String commissionConfirmResult;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCommissionClientName() {
        return commissionClientName;
    }

    public void setCommissionClientName(String commissionClientName) {
        this.commissionClientName = commissionClientName;
    }

    public String getCommissionClientNo() {
        return commissionClientNo;
    }

    public void setCommissionClientNo(String commissionClientNo) {
        this.commissionClientNo = commissionClientNo;
    }

    public String getCommissionDocumentId() {
        return commissionDocumentId;
    }

    public void setCommissionDocumentId(String commissionDocumentId) {
        this.commissionDocumentId = commissionDocumentId;
    }

    public DocumentType getCommissionDocumentType() {
        return commissionDocumentType;
    }

    public void setCommissionDocumentType(DocumentType commissionDocumentType) {
        this.commissionDocumentType = commissionDocumentType;
    }

    public IssCountry getCountry() {
        return country;
    }

    public void setCountry(IssCountry country) {
        this.country = country;
    }

    public Date getCommissionStartDate() {
        return commissionStartDate;
    }

    public void setCommissionStartDate(Date commissionStartDate) {
        this.commissionStartDate = commissionStartDate;
    }

    public Date getCommissionExpireDate() {
        return commissionExpireDate;
    }

    public void setCommissionExpireDate(Date commissionExpireDate) {
        this.commissionExpireDate = commissionExpireDate;
    }

    public String getCommissionClientTel() {
        return commissionClientTel;
    }

    public void setCommissionClientTel(String commissionClientTel) {
        this.commissionClientTel = commissionClientTel;
    }

    public String getCommissionReason() {
        return commissionReason;
    }

    public void setCommissionReason(String commissionReason) {
        this.commissionReason = commissionReason;
    }

    public CommissionRelation getCommissionRelation() {
        return commissionRelation;
    }

    public void setCommissionRelation(CommissionRelation commissionRelation) {
        this.commissionRelation = commissionRelation;
    }

    public String getCommissionConfirmUserIdKey1() {
        return commissionConfirmUserIdKey1;
    }

    public void setCommissionConfirmUserIdKey1(String commissionConfirmUserIdKey1) {
        this.commissionConfirmUserIdKey1 = commissionConfirmUserIdKey1;
    }

    public String getCommissionConfirmUserIdKey2() {
        return commissionConfirmUserIdKey2;
    }

    public void setCommissionConfirmUserIdKey2(String commissionConfirmUserIdKey2) {
        this.commissionConfirmUserIdKey2 = commissionConfirmUserIdKey2;
    }

    public String getCommissionConfirmTel() {
        return commissionConfirmTel;
    }

    public void setCommissionConfirmTel(String commissionConfirmTel) {
        this.commissionConfirmTel = commissionConfirmTel;
    }

    public String getCommissionConfirmTime() {
        return commissionConfirmTime;
    }

    public void setCommissionConfirmTime(String commissionConfirmTime) {
        this.commissionConfirmTime = commissionConfirmTime;
    }

    public String getCommissionConfirmResult() {
        return commissionConfirmResult;
    }

    public void setCommissionConfirmResult(String commissionConfirmResult) {
        this.commissionConfirmResult = commissionConfirmResult;
    }
}
