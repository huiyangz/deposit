package com.dcits.deposit.entity;

public class RcRuleType {
    /** 黑名单检查规则编号 */
    private String ruleId;
    /** 账户限制类型 */
    private String restraintType;
    /** 规则描述 */
    private String ruleDesc;
    /** 处理方式 */
    private String dealFlow;
    /** 周期类型 */
    private String termType;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 存期期限 */
    private String term;
    /** 客户所有账户增加限制标志 */
    private String resAllFlag;
    /** 其他账户限制期限 */
    private String othTerm;
    /** 其他账户限制期限类型 */
    private String othTermType;
    /** 卡介质 */
    private String cardMedium;
    /** 黑名单限制操作标识 */
    private String resOperateFlag;
    /** 限额编码 */
    private String limitRef;
    /** 其他账户限制类型 */
    private String othRestraintType;
    /** 限制机构范围 */
    private String resBranchRange;
    /** 渠道控制类型 */
    private String controlType;
    /** 其他账户顺延期限 */
    private String othDelayTerm;
    /** 其他账户顺延期限类型 */
    private String othDelayTermType;
    /** 其他账户控制类型 */
    private String othControlType;
    /** 关联账户核实标志 */
    private String relVerifyFlag;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(String restraintType) {
        this.restraintType = restraintType;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public String getDealFlow() {
        return dealFlow;
    }

    public void setDealFlow(String dealFlow) {
        this.dealFlow = dealFlow;
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getResAllFlag() {
        return resAllFlag;
    }

    public void setResAllFlag(String resAllFlag) {
        this.resAllFlag = resAllFlag;
    }

    public String getOthTerm() {
        return othTerm;
    }

    public void setOthTerm(String othTerm) {
        this.othTerm = othTerm;
    }

    public String getOthTermType() {
        return othTermType;
    }

    public void setOthTermType(String othTermType) {
        this.othTermType = othTermType;
    }

    public String getCardMedium() {
        return cardMedium;
    }

    public void setCardMedium(String cardMedium) {
        this.cardMedium = cardMedium;
    }

    public String getResOperateFlag() {
        return resOperateFlag;
    }

    public void setResOperateFlag(String resOperateFlag) {
        this.resOperateFlag = resOperateFlag;
    }

    public String getLimitRef() {
        return limitRef;
    }

    public void setLimitRef(String limitRef) {
        this.limitRef = limitRef;
    }

    public String getOthRestraintType() {
        return othRestraintType;
    }

    public void setOthRestraintType(String othRestraintType) {
        this.othRestraintType = othRestraintType;
    }

    public String getResBranchRange() {
        return resBranchRange;
    }

    public void setResBranchRange(String resBranchRange) {
        this.resBranchRange = resBranchRange;
    }

    public String getControlType() {
        return controlType;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    public String getOthDelayTerm() {
        return othDelayTerm;
    }

    public void setOthDelayTerm(String othDelayTerm) {
        this.othDelayTerm = othDelayTerm;
    }

    public String getOthDelayTermType() {
        return othDelayTermType;
    }

    public void setOthDelayTermType(String othDelayTermType) {
        this.othDelayTermType = othDelayTermType;
    }

    public String getOthControlType() {
        return othControlType;
    }

    public void setOthControlType(String othControlType) {
        this.othControlType = othControlType;
    }

    public String getRelVerifyFlag() {
        return relVerifyFlag;
    }

    public void setRelVerifyFlag(String relVerifyFlag) {
        this.relVerifyFlag = relVerifyFlag;
    }
}