package com.dcits.deposit.task.dto;

/**
 * T2S1 检查账户限制 输出 DTO。
 *
 * <p>需求「输出」表全部标记为非必填、类型为 {@code java.lang.String}（Spec REQ-005）。
 * 本 DTO 仅包含来源与字段名已确认且唯一对应的业务输出：五个判定结果标志分别对应
 * ST061/ST055/ST058/ST060/ST056 的判定结果，其余字段按来源实体分组取自 ST048、ST051、
 * ST053 的查询结果（REQ-005-S01）。输出表其余 19 个字段存在来源未定义（TBD-4）、
 * 语义未确认（TBD-6）或同名字段与枚举到字符串口径未定义（TBD-7），澄清前不纳入
 * 本 DTO，详见下方业务 FIXME。</p>
 */
public class T2S1OutputDTO {

    // FIXME 业务项:T2S1 检查账户限制 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:需求「输出」表将 resSeqNo、restraintType、restraintsStatus 三个字段来源登记为客户限制表（RB_CLIENT_RESTRAINTS），「执行步骤」表 15 个步骤均不查询该表（Spec TBD-4）。 - 影响:该三字段在接口内无取得步骤，输出 DTO 未包含对应字段，响应缺失该业务字段。 - 待确认:该三字段的取值来源（新增查询、其它步骤/组件提供或来源登记有误）。
    // FIXME 业务项:T2S1 检查账户限制 - 问题大类:业务 - 问题分类:枚举业务定义缺失 - 问题描述:需求「输出」表登记 resPriority 来源交易类型定义表（RB_TRAN_DEF）、说明「冻结级别」，ST057 按交易类型查询所得为「限制级别」且工程 RB_TRAN_DEF 无对应字段，「限制级别」「冻结级别」的物理编码与排序口径未定义（Spec TBD-6）。 - 影响:resPriority 的语义、取值与工程字段对应关系未确认，输出 DTO 未包含对应字段，响应缺失该业务字段。 - 待确认:resPriority 的语义、取值与工程字段对应关系。
    // FIXME 业务项:T2S1 检查账户限制 - 问题大类:业务 - 问题分类:类型定义矛盾 - 问题描述:需求「输出」表含重复字段名（两个 stopFlag、两个 counterFlag、两个 resPriority、两个 status、两个 resSeqNo、两个 restraintsStatus、三个 restraintType）且全部登记为 java.lang.String，对应步骤输出契约为枚举类型（RestraintType、RestraintsStatus、Status、DrCrCtlFlag、LimitBranchRange），restraintLevel 与 resBranchRange 亦为枚举类型输出；响应结构的字段命名、归属（同名字段如何区分）与枚举到字符串的输出口径均未定义（Spec TBD-7）。 - 影响:同名字段与枚举类型字段的接口输出 DTO 结构与映射无法确定，输出 DTO 未包含此类字段。 - 待确认:接口输出 DTO 结构与字段映射。

    /** 属性限制标志（ST061 判定结果，集合非空为「是」，空为「否」） */
    private String 属性限制标志;

    /** 止付标志（ST055 判定结果，借贷方控制标志 D-禁止借方为「是」，否则「否」） */
    private String stopFlag;

    /** 不收不付标志（ST058 判定结果，借贷方控制标志 A-禁止借贷方为「是」，否则「否」） */
    private String 不收不付标志;

    /** 现金不收不付限制标志（ST060 判定结果，借贷方控制标志 A 且现金标志 N 为「是」，否则「否」） */
    private String 现金不收不付限制标志;

    /** 转账不收不付标志（ST056 判定结果，借贷方控制标志 A 且转账标志 N 为「是」，否则「否」） */
    private String 转账不收不付标志;

    /** 账号（ST051 取得，来源对公存款账户主表 RB_BUS_ACCT） */
    private String baseAcctNo;

    /** 主账户标志（ST051 取得，来源对公存款账户主表 RB_BUS_ACCT） */
    private String leadAcctFlag;

    /** 产品编号（ST048 取得，来源存款限制检查控制详情 RB_RESTRAINT_CONTROL_DETAILS） */
    private String prodNo;

    /** 交易类型关联（ST048 取得，来源存款限制检查控制详情 RB_RESTRAINT_CONTROL_DETAILS） */
    private String tranTypeLink;

    /** 渠道模式（ST048 取得，来源存款限制检查控制详情 RB_RESTRAINT_CONTROL_DETAILS） */
    private String channelMuster;

    /** 摘要码（ST048 取得，来源存款限制检查控制详情 RB_RESTRAINT_CONTROL_DETAILS） */
    private String narrativeCode;

    /** 质押标志（ST053 取得，来源存款限制类型表 RB_RESTRAINT_TYPE） */
    private String pledgedFlag;

    public String get属性限制标志() {
        return 属性限制标志;
    }

    public void set属性限制标志(String 属性限制标志) {
        this.属性限制标志 = 属性限制标志;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }

    public String get不收不付标志() {
        return 不收不付标志;
    }

    public void set不收不付标志(String 不收不付标志) {
        this.不收不付标志 = 不收不付标志;
    }

    public String get现金不收不付限制标志() {
        return 现金不收不付限制标志;
    }

    public void set现金不收不付限制标志(String 现金不收不付限制标志) {
        this.现金不收不付限制标志 = 现金不收不付限制标志;
    }

    public String get转账不收不付标志() {
        return 转账不收不付标志;
    }

    public void set转账不收不付标志(String 转账不收不付标志) {
        this.转账不收不付标志 = 转账不收不付标志;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getLeadAcctFlag() {
        return leadAcctFlag;
    }

    public void setLeadAcctFlag(String leadAcctFlag) {
        this.leadAcctFlag = leadAcctFlag;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getTranTypeLink() {
        return tranTypeLink;
    }

    public void setTranTypeLink(String tranTypeLink) {
        this.tranTypeLink = tranTypeLink;
    }

    public String getChannelMuster() {
        return channelMuster;
    }

    public void setChannelMuster(String channelMuster) {
        this.channelMuster = channelMuster;
    }

    public String getNarrativeCode() {
        return narrativeCode;
    }

    public void setNarrativeCode(String narrativeCode) {
        this.narrativeCode = narrativeCode;
    }

    public String getPledgedFlag() {
        return pledgedFlag;
    }

    public void setPledgedFlag(String pledgedFlag) {
        this.pledgedFlag = pledgedFlag;
    }
}
