package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.facade.bo.ST030InputBO;
import com.dcits.deposit.facade.bo.ST030OutputBO;
import com.dcits.deposit.facade.bo.ST052InputBO;
import com.dcits.deposit.facade.bo.ST052OutputBO;
import com.dcits.deposit.facade.bo.ST056InputBO;
import com.dcits.deposit.facade.bo.ST056OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;
import com.dcits.deposit.rule.DT002;

/**
 * ST030 检查对手账户是否能够入账 步骤实现。
 *
 * <p>按正式 Spec ST030「步骤描述」第 1–5 项编排执行：</p>
 * <ol>
 *   <li>依据对手账号查询【账户信息】（对公存款账户主表 RB_BUS_ACCT）取得账户状态；</li>
 *   <li>以对手账号为调用账号调用组件内步骤 ST052，取得转账止付标志；</li>
 *   <li>以对手账号为调用账号调用组件内步骤 ST056，取得转账不收不付标志；</li>
 *   <li>以账户状态、转账止付标志、转账不收不付标志执行规则《检查账户是否能够入账》（DT002），取得入账标志；</li>
 *   <li>入账标志为"允许"时返回检查结果"通过"（正常完成，成功状态、错误字段为空），
 *       否则返回错误码"ER0077"（转入账户不允许入账，交易失败）按业务失败结束。</li>
 * </ol>
 *
 * <p>按对手账号定位账户记录的查询方式（TBD-4）、必填输入缺失行为（TBD-5）、查询无记录行为
 * （TBD-6）、组件内步骤失败传播（TBD-3）、规则未确认组合与"否则"分支边界（TBD-2）、"通过"
 * 载体与失败时输出口径（TBD-7）、输出物理编码（TBD-8）等未确认事项见各子步骤 FIXME，
 * 不作为已确认业务行为，待确认后按确认结果实现。</p>
 */
@Service
public class ST030Pbc implements IST030 {

    /** 入账标志-允许。Spec REQ-005 条件原文字面量，实际存储/比较值待确认，见 TBD-8 */
    private static final String FLAG_ALLOW = "允许";

    /** 错误码-ER0077：转入账户不允许入账，交易失败（errorcodes.properties 第 77 行，需求步骤 5 声明） */
    private static final String ERROR_CODE_ER0077 = "ER0077";

    /** 错误信息-ER0077 业务说明，按「错误码::业务说明」格式（step-error-contract） */
    private static final String ERROR_MESSAGE_ER0077 = "ER0077::转入账户不允许入账，交易失败";

    /** 对公存款账户主表（RB_BUS_ACCT）数据服务 */
    @Autowired
    private IRbBusAcctBcc rbBusAcctBcc;

    /** 组件内步骤 ST052 检查是否存在转账止付限制 */
    @Autowired
    private IST052 st052;

    /** 组件内步骤 ST056 检查是否存在转账不收不付限制 */
    @Autowired
    private IST056 st056;

    @Override
    public ST030OutputBO execute(ST030InputBO input) {
        ST030OutputBO output = new ST030OutputBO();

        // 必填输入缺失行为（Spec TBD-5）：othBaseAcctNo 标记必填，空/缺失时步骤行为未定义
        // FIXME 业务项:ST030/检查对手账户是否能够入账 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:必填输入 othBaseAcctNo 缺失/为空时的步骤行为未定义（是否业务失败、失败码、是否仍执行账户查询与组件内步骤调用；Spec TBD-5） - 影响:缺失必填输入时当前按正常路径继续执行，null 会传入账户查询条件与 ST052/ST056 输入 baseAcctNo，实际行为待确认 - 待确认:必填输入缺失时的处理行为；othBaseAcctNo→baseAcctNo 参数映射残留确认（REQ-002/REQ-003 已按调用账号口径执行）

        // 输出物理编码（Spec TBD-8）：输出字段物理名与取值编码未确认
        // FIXME 业务项:ST030/检查对手账户是否能够入账 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:输出四个业务字段的物理字段名与取值编码未定义（入账标志/转账止付标志/转账不收不付标志为字面中文串"允许"/"不允许"、"是"/"否"，acctStatus 为枚举；Spec TBD-8） - 影响:当前 OutputBO 以 entryFlag/transferStopFlag/transferNoCreditNoDebitFlag/acctStatus 命名并按字面中文取值返回，实际编码待确认 - 待确认:输出物理字段名与存储/传输编码

        // 子步骤 1（REQ-001）：依据对手账号查询【账户信息】（对公存款账户主表 RB_BUS_ACCT）取得账户状态
        // FIXME 业务项:ST030/检查对手账户是否能够入账 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:按对手账号定位账户记录的查询方式未定义，RbBusAcctEO 未暴露账号（baseAcctNo）字段，findByEo 按 EO 非空字段组合查询无法直接按对手账号过滤（Spec TBD-4） - 影响:当前以空查询条件 EO 调用 findByEo 并按单条结果查询统一约定取结果集第一条，能否正确定位对手账户取决于后续确认 - 待确认:按对手账号定位 RB_BUS_ACCT 记录并取得 acctStatus 的查询方式/关联字段
        RbBusAcctEO queryEo = new RbBusAcctEO();
        List<RbBusAcctEO> acctList = rbBusAcctBcc.findByEo(queryEo);
        if (acctList.isEmpty()) {
            // 查询无记录：对手账号无对应账户记录时的步骤行为未定义（Spec TBD-6）
            // FIXME 业务项:ST030/检查对手账户是否能够入账 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:按对手账号查询【账户信息】无记录时的步骤行为未定义（是否返回业务失败及错误码；ER0081"对手账户不存在"存在但需求未声明使用，Spec TBD-6） - 影响:该路径当前按查询为空返回成功且业务输出为 null，是否报错或如何返回待确认 - 待确认:对手账号无对应账户记录时是否业务失败及错误码
            output.setSucceed(true);
            return output;
        }
        // 面向单条结果的查询，多条统一取结果集第一条
        AcctStatus acctStatus = acctList.get(0).getAcctStatus();
        output.setAcctStatus(acctStatus);

        // 子步骤 2（REQ-002）：以对手账号为调用账号调用组件内步骤 ST052 取得转账止付标志
        ST052InputBO stopInput = new ST052InputBO();
        stopInput.setBaseAcctNo(input.getOthBaseAcctNo());
        ST052OutputBO stopResult = st052.execute(stopInput);
        if (!stopResult.isSucceed()) {
            // 组件内步骤返回业务失败时的传播口径未定义（Spec TBD-3），当前按原样传播其错误字段
            // FIXME 业务项:ST030/检查对手账户是否能够入账 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:组件内步骤 ST052/ST056 返回业务失败时本步骤的传播口径未定义，是否原样传播其错误字段或转换为本步骤错误码未确认（Spec TBD-3） - 影响:该路径当前按原样传播目标步骤错误字段并返回失败，实际口径待确认 - 待确认:组件内步骤业务失败时本步骤的传播与转换口径
            output.setErrorCode(stopResult.getErrorCode());
            output.setErrorMessage(stopResult.getErrorMessage());
            return output;
        }
        String transferStopFlag = stopResult.getStopFlag();
        output.setTransferStopFlag(transferStopFlag);

        // 子步骤 3（REQ-003）：以对手账号为调用账号调用组件内步骤 ST056 取得转账不收不付标志
        ST056InputBO noCreditInput = new ST056InputBO();
        noCreditInput.setBaseAcctNo(input.getOthBaseAcctNo());
        ST056OutputBO noCreditResult = st056.execute(noCreditInput);
        if (!noCreditResult.isSucceed()) {
            // 组件内步骤返回业务失败：同 ST052 分支，按 TBD-3 当前口径原样传播其错误字段（见子步骤 2 分支 FIXME）
            output.setErrorCode(noCreditResult.getErrorCode());
            output.setErrorMessage(noCreditResult.getErrorMessage());
            return output;
        }
        String transferNoCreditNoDebitFlag = noCreditResult.getTransferNoCreditNoDebitFlag();
        output.setTransferNoCreditNoDebitFlag(transferNoCreditNoDebitFlag);

        // 子步骤 4（REQ-004）：以账户状态、转账止付标志、转账不收不付标志执行规则《检查账户是否能够入账》（DT002）
        String entryFlag = DT002.execute(acctStatus, transferStopFlag, transferNoCreditNoDebitFlag);
        output.setEntryFlag(entryFlag);

        // 子步骤 5（REQ-005）：入账标志为"允许"时返回检查结果"通过"（正常完成），否则返回错误码 ER0077
        // FIXME 业务项:ST030/检查对手账户是否能够入账 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:"检查结果为'通过'"未登记于需求输出表，其业务结论承载方式（是否另有业务字段）未确认；入账标志非"允许"返回 ER0077 时输出表四个业务字段是否仍返回及取值未确认（Spec TBD-7） - 影响:当前"通过"按步骤正常完成承载（succeed=true、错误字段 null），失败时仍保留已计算字段，实际口径待确认 - 待确认:"通过"的业务结论载体及失败时输出表字段口径
        if (FLAG_ALLOW.equals(entryFlag)) {
            output.setSucceed(true);
            return output;
        }
        // 入账标志非"允许"：业务失败，返回错误码 ER0077
        // FIXME 业务项:ST030/检查对手账户是否能够入账 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:[入账标志]判定结果继承 DT002 未确认部分（未列状态与标志组合、标志空值等，DT002 TBD-1/TBD-2/TBD-6）；入账标志取值域外（如空值）落入"否则"分支时是否返回 ER0077、与"不允许"是否区分未确认（Spec TBD-2） - 影响:当前按"非'允许'即 ER0077"实现，未确认组合与取值域外值的步骤结果未确定 - 待确认:未确认组合的入账标志结果及"否则"分支对取值域外值的处理
        output.setSucceed(false);
        output.setErrorCode(ERROR_CODE_ER0077);
        output.setErrorMessage(ERROR_MESSAGE_ER0077);
        return output;
    }
}
