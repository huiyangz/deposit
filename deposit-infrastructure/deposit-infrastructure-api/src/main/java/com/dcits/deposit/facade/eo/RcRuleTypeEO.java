package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ControlType;
import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.LimitBranchRange;
import com.dcits.deposit.enums.LimitRef;
import com.dcits.deposit.enums.ResOperateFlag;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.TermType;
import jakarta.validation.constraints.NotNull;

public class RcRuleTypeEO {
    /** 黑名单检查规则编号 */
    @NotNull
    private String ruleId;
    /** 账户限制类型 */
    private RestraintType restraintType;
    /** 规则描述 */
    private String ruleDesc;
    /** 处理方式 */
    private DealFlow dealFlow;
    /** 周期类型 */
    private TermType termType;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 存期期限 */
    private String term;
    /** 客户所有账户增加限制标志 */
    private IndividualFlag resAllFlag;
    /** 其他账户限制期限 */
    private String othTerm;
    /** 其他账户限制期限类型 */
    private TermType othTermType;
    /** 卡介质 */
    private String cardMedium;
    /** 黑名单限制操作标识 */
    private ResOperateFlag resOperateFlag;
    /** 限额编码 */
    private LimitRef limitRef;
    /** 其他账户限制类型 */
    private RestraintType othRestraintType;
    /** 限制机构范围 */
    private LimitBranchRange resBranchRange;
    /** 渠道控制类型 */
    private ControlType controlType;
    /** 其他账户顺延期限 */
    private String othDelayTerm;
    /** 其他账户顺延期限类型 */
    private TermType othDelayTermType;
    /** 其他账户控制类型 */
    private ControlType othControlType;
    /** 关联账户核实标志 */
    private IndividualFlag relVerifyFlag;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
        this.restraintType = restraintType;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public DealFlow getDealFlow() {
        return dealFlow;
    }

    public void setDealFlow(DealFlow dealFlow) {
        this.dealFlow = dealFlow;
    }

    public TermType getTermType() {
        return termType;
    }

    public void setTermType(TermType termType) {
        this.termType = termType;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public IndividualFlag getResAllFlag() {
        return resAllFlag;
    }

    public void setResAllFlag(IndividualFlag resAllFlag) {
        this.resAllFlag = resAllFlag;
    }

    public String getOthTerm() {
        return othTerm;
    }

    public void setOthTerm(String othTerm) {
        this.othTerm = othTerm;
    }

    public TermType getOthTermType() {
        return othTermType;
    }

    public void setOthTermType(TermType othTermType) {
        this.othTermType = othTermType;
    }

    public String getCardMedium() {
        return cardMedium;
    }

    public void setCardMedium(String cardMedium) {
        this.cardMedium = cardMedium;
    }

    public ResOperateFlag getResOperateFlag() {
        return resOperateFlag;
    }

    public void setResOperateFlag(ResOperateFlag resOperateFlag) {
        this.resOperateFlag = resOperateFlag;
    }

    public LimitRef getLimitRef() {
        return limitRef;
    }

    public void setLimitRef(LimitRef limitRef) {
        this.limitRef = limitRef;
    }

    public RestraintType getOthRestraintType() {
        return othRestraintType;
    }

    public void setOthRestraintType(RestraintType othRestraintType) {
        this.othRestraintType = othRestraintType;
    }

    public LimitBranchRange getResBranchRange() {
        return resBranchRange;
    }

    public void setResBranchRange(LimitBranchRange resBranchRange) {
        this.resBranchRange = resBranchRange;
    }

    public ControlType getControlType() {
        return controlType;
    }

    public void setControlType(ControlType controlType) {
        this.controlType = controlType;
    }

    public String getOthDelayTerm() {
        return othDelayTerm;
    }

    public void setOthDelayTerm(String othDelayTerm) {
        this.othDelayTerm = othDelayTerm;
    }

    public TermType getOthDelayTermType() {
        return othDelayTermType;
    }

    public void setOthDelayTermType(TermType othDelayTermType) {
        this.othDelayTermType = othDelayTermType;
    }

    public ControlType getOthControlType() {
        return othControlType;
    }

    public void setOthControlType(ControlType othControlType) {
        this.othControlType = othControlType;
    }

    public IndividualFlag getRelVerifyFlag() {
        return relVerifyFlag;
    }

    public void setRelVerifyFlag(IndividualFlag relVerifyFlag) {
        this.relVerifyFlag = relVerifyFlag;
    }
}