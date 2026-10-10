package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.TermType;
import java.util.Date;

/**
 * ST130 登记账户限制信息 输入 BO。
 *
 * <p>字段照录正式 Spec「### 输入」表的 8 个字段（字段名、类型、必填性、说明），
 * 即本步骤的全部输入，不额外要求调用方上送账号内部键值、限制编号、渠道流水号、法人等表外入参
 * （Spec REQ-001）。</p>
 *
 * <ul>
 *   <li>{@code baseAcctNo}（账号，{@code java.lang.String}，必填）——步骤描述中的 {账号}；</li>
 *   <li>{@code restraintType}（账户限制类型，{@link RestraintType}，必填）——步骤描述中的
 *       {限制类型}，取值域见 Spec REQ-003；</li>
 *   <li>{@code startDate}（开始日期，{@code java.util.Date}，必填）——步骤描述中的 {开始日期}；</li>
 *   <li>{@code endDate}（结束日期，{@code java.util.Date}，必填）——步骤描述中的 {结束日期}；</li>
 *   <li>{@code term}（存期期限，{@code java.lang.String}，必填）——步骤描述中的 {限制期限}，
 *       按原值登记，不作长度校验、补位、截断或与 {@code termType} 的联动换算（Spec REQ-004）；</li>
 *   <li>{@code termType}（周期类型，{@link TermType}，必填）——步骤描述中的 {限制期限类型}，
 *       取值域见 Spec REQ-004；</li>
 *   <li>{@code tranDate}（交易日期，{@code java.util.Date}，必填）——源需求未写明其用途与落库列，
 *       本步骤只按「## 输入」表接收，不据其产生写入或判断（Spec「验收范围与明确不覆盖的事项」第 4 项）；</li>
 *   <li>{@code runDate}（核心运行日期，{@code java.util.Date}，必填）——同上，源需求未写明其用途，
 *       本步骤只按表接收（Spec 第 4 项）。</li>
 * </ul>
 *
 * <p>8 个字段在「## 输入」表均标「必填」，但源需求未定义其为空时的行为，本 BO 不生成默认值、
 * 校验或兜底赋值（Spec「验收范围与明确不覆盖的事项」第 3 项）。</p>
 */
public class ST130InputBO {

    /** 账号：步骤描述中的 {账号}，登记记录的账号来源 */
    private String baseAcctNo;

    /** 账户限制类型：步骤描述中的 {限制类型}，取值取自 RestraintType 常量码值 */
    private RestraintType restraintType;

    /** 开始日期：步骤描述中的 {开始日期} */
    private Date startDate;

    /** 结束日期：步骤描述中的 {结束日期} */
    private Date endDate;

    /** 存期期限：步骤描述中的 {限制期限}，按原值登记 */
    private String term;

    /** 周期类型：步骤描述中的 {限制期限类型}，取值取自 TermType 常量码值 */
    private TermType termType;

    /** 交易日期：源需求未写明用途与落库列，本步骤只作输入接收 */
    private Date tranDate;

    /** 核心运行日期：源需求未写明用途与落库列，本步骤只作输入接收 */
    private Date runDate;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
        this.restraintType = restraintType;
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

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public TermType getTermType() {
        return termType;
    }

    public void setTermType(TermType termType) {
        this.termType = termType;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }
}
