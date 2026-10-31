package com.dcits.deposit.rule;

import com.dcits.deposit.enums.AcctStatus;

/**
 * DT001 检查账户是否能够出账。
 *
 * <p>决策类规则。依据账户状态及两个转账控制标志（账户转账止付标志、账户转账不收不付标志）
 * 判定账户是否允许出账，返回出账标志「允许」或「不允许」。</p>
 *
 * <p>已确认判定依据（正式 Spec 规则描述条目 a、c~g）：</p>
 * <ul>
 *   <li>规则 a：账户状态为「新建」（{@code AcctStatus.N}）→「允许」；</li>
 *   <li>规则 c：「待激活」（{@code AcctStatus.H}）且止付「是」且不收不付「否」→「不允许」；</li>
 *   <li>规则 d：「活动」（{@code AcctStatus.A}）且止付「否」且不收不付「否」→「允许」；</li>
 *   <li>规则 e：「久悬」（{@code AcctStatus.S}）且不收不付「是」→「不允许」（不约束止付标志）；</li>
 *   <li>规则 f：「转营业外」（{@code AcctStatus.O}）且不收不付「是」→「不允许」（不约束止付标志）；</li>
 *   <li>规则 g：账户状态为「关闭」（{@code AcctStatus.C}）→「不允许」。</li>
 * </ul>
 *
 * <p>规则 b（「新建」且止付「是」且不收不付「否」→「不允许」）与规则 a 在「新建」状态下判定
 * 冲突，结果待业务确认，见 {@link #execute(AcctStatus, String, String)} 中 FIXME。</p>
 *
 * <p>账户转账止付标志、账户转账不收不付标志及出账标志的物理编码待确认，本实现按规则文本
 * 字面量「是」「否」「允许」「不允许」处理。</p>
 */
public class DT001 {

    /**
     * 检查账户是否能够出账。
     *
     * @param acctStatus        账户状态（必填）
     * @param 账户转账止付标志     账户转账止付标志（非必填）
     * @param 账户转账不收不付标志 账户转账不收不付标志（非必填）
     * @return 出账标志：「允许」或「不允许」；未覆盖输入返回 {@code null}，见 FIXME
     */
    public static String execute(AcctStatus acctStatus, String 账户转账止付标志, String 账户转账不收不付标志) {
        // 规则 a：账户状态为「新建」时返回「允许」
        // FIXME 业务项:DT001/检查账户是否能够出账 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:规则a（新建→允许）与规则b（新建且止付「是」且不收不付「否」→不允许）在「新建」状态下同时适用且结果相反，需求未声明规则优先级或例外关系（Spec 待确认事项 1） - 影响:组合 N+止付「是」+不收不付「否」当前按规则 a 返回「允许」，与规则 b 声明结果冲突 - 待确认:该组合应返回「允许」还是「不允许」，以及规则判定顺序/优先级
        if (acctStatus == AcctStatus.N) {
            return "允许";
        }
        // 规则 c：账户状态为「待激活」且止付「是」且不收不付「否」时返回「不允许」
        if (acctStatus == AcctStatus.H && "是".equals(账户转账止付标志) && "否".equals(账户转账不收不付标志)) {
            return "不允许";
        }
        // 规则 d：账户状态为「活动」且止付「否」且不收不付「否」时返回「允许」
        if (acctStatus == AcctStatus.A && "否".equals(账户转账止付标志) && "否".equals(账户转账不收不付标志)) {
            return "允许";
        }
        // 规则 e：账户状态为「久悬」且不收不付「是」时返回「不允许」（不约束止付标志）
        if (acctStatus == AcctStatus.S && "是".equals(账户转账不收不付标志)) {
            return "不允许";
        }
        // 规则 f：账户状态为「转营业外」且不收不付「是」时返回「不允许」（不约束止付标志）
        if (acctStatus == AcctStatus.O && "是".equals(账户转账不收不付标志)) {
            return "不允许";
        }
        // 规则 g：账户状态为「关闭」时返回「不允许」
        if (acctStatus == AcctStatus.C) {
            return "不允许";
        }
        // FIXME 业务项:DT001/检查账户是否能够出账 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:账户状态 D/I/P/R/U、已列举状态下未列举的标志组合及 acctStatus 为空时，需求未定义返回结果（Spec 待确认事项 2、5） - 影响:这些输入无已确认的出账标志结果，当前返回 null 表示未决 - 待确认:未覆盖输入应返回「允许」/「不允许」默认值还是报错
        return null;
    }
}
