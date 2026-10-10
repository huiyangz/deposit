package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.DocumentType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ST133 登记账户限制登记簿 输入 BO。
 *
 * <p>字段照录正式 Spec「## 输入」表（REQ-001）：14 个字段全部必填，来源实体均为
 * 对公存款账户限制表（RB_BUS_RESTRAINTS），即它们是本步骤登记到该登记簿的登记内容，
 * 取值由调用方在本次执行中提供；该「来源实体」列不是查询条件声明，本步骤不因该列对
 * 该表发起查询（REQ-001-S02）。</p>
 *
 * <p>字段按「### 登记内容与步骤描述六类信息的对应」分为六类：{限制编号} {@code resSeqNo}（1）、
 * {限制金额} {@code pledgedAmt}（1）、{开始日期} {@code startDate}（1）、{结束日期} {@code endDate}（1）、
 * {执法人信息} 8 个证件类型／证件号码字段、{法律文书} {@code deductionJudiciaryName} 与
 * {@code deductionLawNo}（2），合计 1＋1＋1＋1＋8＋2＝14。</p>
 *
 * <p>4 个证件类型字段以枚举 {@link DocumentType} 承载（REQ-004）；源需求未定义这 14 个字段为空
 * （{@code null} 或空字符串）时的行为，本 BO 不生成默认值、校验或兜底
 * （Spec「验收范围与明确不覆盖的事项」第 4 项）。</p>
 */
public class ST133InputBO {

    /** 限制编号：{限制编号}，登记记录的主键（RES_SEQ_NO） */
    private String resSeqNo;

    /** 限制金额：{限制金额}，写入 PLEDGED_AMT，不换算、不舍入 */
    private BigDecimal pledgedAmt;

    /** 开始日期：{开始日期}，写入 START_DATE，不截断、不归一化 */
    private Date startDate;

    /** 结束日期：{结束日期}，写入 END_DATE，不截断、不归一化 */
    private Date endDate;

    /** 执法人1证件类型：{执法人信息}，取值域 {@link DocumentType} */
    private DocumentType judiciaryDocumentType;

    /** 执法人证件类型2：{执法人信息}，取值域 {@link DocumentType} */
    private DocumentType judiciaryDocumentType2;

    /** 执法人2证件类型：{执法人信息}，取值域 {@link DocumentType} */
    private DocumentType judiciaryOthDocumentType;

    /** 执法人2证件类型2：{执法人信息}，取值域 {@link DocumentType} */
    private DocumentType judiciaryOthDocumentType2;

    /** 有权机关名称：{法律文书} */
    private String deductionJudiciaryName;

    /** 扣划法律文书号：{法律文书} */
    private String deductionLawNo;

    /** 执法人1证件号码：{执法人信息}，源需求未指定取值枚举 */
    private String judiciaryDocumentId;

    /** 执法人证件号码2：{执法人信息}，源需求未指定取值枚举 */
    private String judiciaryDocumentId2;

    /** 执法人2证件号码：{执法人信息}，源需求未指定取值枚举 */
    private String judiciaryOthDocumentId;

    /** 执法人2证件号码2：{执法人信息}，源需求未指定取值枚举 */
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
