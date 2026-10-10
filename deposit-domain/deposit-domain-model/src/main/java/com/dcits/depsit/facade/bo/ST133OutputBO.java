package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.DocumentType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ST133 登记账户限制登记簿 输出 BO。
 *
 * <p>字段照录正式 Spec「## 输出」表（REQ-003）：与「## 输入」表同名、同类型、同业务名称的 14 个字段，
 * 即返回本步骤已登记到登记簿【对公存款账户限制表（RB_BUS_RESTRAINTS）】的限制信息；登记成功时
 * 每个字段的取值等于本次登记的对应字段取值。</p>
 *
 * <p>「## 输出」表对 14 个字段均标「非必填」，该标记为字段在实体上的可空性声明（登记簿这 14 列在 DDL
 * 中均可为 {@code null}），不表示登记成功路径上可以留空。本 BO 不新增「## 输出」表以外的输出字段
 * （如登记结果、检查结论、限制状态）；步骤结果按 {@link StepResult} 既有契约以
 * {@code succeed} / {@code errorCode} / {@code errorMessage} 表达（REQ-005）。</p>
 */
public class ST133OutputBO extends StepResult {

    /** 限制编号：本次登记的限制编号（登记记录主键 RES_SEQ_NO） */
    private String resSeqNo;

    /** 限制金额：本次登记的限制金额 */
    private BigDecimal pledgedAmt;

    /** 开始日期：本次登记的开始日期 */
    private Date startDate;

    /** 结束日期：本次登记的结束日期 */
    private Date endDate;

    /** 执法人1证件类型：本次登记的取值（{@link DocumentType} 常量） */
    private DocumentType judiciaryDocumentType;

    /** 执法人证件类型2：本次登记的取值（{@link DocumentType} 常量） */
    private DocumentType judiciaryDocumentType2;

    /** 执法人2证件类型：本次登记的取值（{@link DocumentType} 常量） */
    private DocumentType judiciaryOthDocumentType;

    /** 执法人2证件类型2：本次登记的取值（{@link DocumentType} 常量） */
    private DocumentType judiciaryOthDocumentType2;

    /** 有权机关名称：本次登记的取值 */
    private String deductionJudiciaryName;

    /** 扣划法律文书号：本次登记的取值 */
    private String deductionLawNo;

    /** 执法人1证件号码：本次登记的取值（字符串原值） */
    private String judiciaryDocumentId;

    /** 执法人证件号码2：本次登记的取值（字符串原值） */
    private String judiciaryDocumentId2;

    /** 执法人2证件号码：本次登记的取值（字符串原值） */
    private String judiciaryOthDocumentId;

    /** 执法人2证件号码2：本次登记的取值（字符串原值） */
    private String judiciaryOthDocumentId2;

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
    }

    public BigDecimal getPledgedAmt() {
        return pledgedAmt;
    }

    public void setPledgedAmt(BigDecimal pledgedAmt) {
        this.pledgedAmt = pledgedAmt;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public DocumentType getJudiciaryDocumentType() {
        return judiciaryDocumentType;
    }

    public void setJudiciaryDocumentType(DocumentType judiciaryDocumentType) {
        this.judiciaryDocumentType = judiciaryDocumentType;
    }

    public DocumentType getJudiciaryDocumentType2() {
        return judiciaryDocumentType2;
    }

    public void setJudiciaryDocumentType2(DocumentType judiciaryDocumentType2) {
        this.judiciaryDocumentType2 = judiciaryDocumentType2;
    }

    public DocumentType getJudiciaryOthDocumentType() {
        return judiciaryOthDocumentType;
    }

    public void setJudiciaryOthDocumentType(DocumentType judiciaryOthDocumentType) {
        this.judiciaryOthDocumentType = judiciaryOthDocumentType;
    }

    public DocumentType getJudiciaryOthDocumentType2() {
        return judiciaryOthDocumentType2;
    }

    public void setJudiciaryOthDocumentType2(DocumentType judiciaryOthDocumentType2) {
        this.judiciaryOthDocumentType2 = judiciaryOthDocumentType2;
    }

    public String getDeductionJudiciaryName() {
        return deductionJudiciaryName;
    }

    public void setDeductionJudiciaryName(String deductionJudiciaryName) {
        this.deductionJudiciaryName = deductionJudiciaryName;
    }

    public String getDeductionLawNo() {
        return deductionLawNo;
    }

    public void setDeductionLawNo(String deductionLawNo) {
        this.deductionLawNo = deductionLawNo;
    }

    public String getJudiciaryDocumentId() {
        return judiciaryDocumentId;
    }

    public void setJudiciaryDocumentId(String judiciaryDocumentId) {
        this.judiciaryDocumentId = judiciaryDocumentId;
    }

    public String getJudiciaryDocumentId2() {
        return judiciaryDocumentId2;
    }

    public void setJudiciaryDocumentId2(String judiciaryDocumentId2) {
        this.judiciaryDocumentId2 = judiciaryDocumentId2;
    }

    public String getJudiciaryOthDocumentId() {
        return judiciaryOthDocumentId;
    }

    public void setJudiciaryOthDocumentId(String judiciaryOthDocumentId) {
        this.judiciaryOthDocumentId = judiciaryOthDocumentId;
    }

    public String getJudiciaryOthDocumentId2() {
        return judiciaryOthDocumentId2;
    }

    public void setJudiciaryOthDocumentId2(String judiciaryOthDocumentId2) {
        this.judiciaryOthDocumentId2 = judiciaryOthDocumentId2;
    }
}
