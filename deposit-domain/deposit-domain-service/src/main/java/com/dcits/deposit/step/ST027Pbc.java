package com.dcits.deposit.step;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST027InputBO;
import com.dcits.deposit.facade.bo.ST027OutputBO;
import com.dcits.deposit.facade.bo.ST052InputBO;
import com.dcits.deposit.facade.bo.ST052OutputBO;
import com.dcits.deposit.facade.bo.ST056InputBO;
import com.dcits.deposit.facade.bo.ST056OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;
import com.dcits.deposit.rule.DT001;

/**
 * ST027 检查账户是否能够出账 步骤实现。
 *
 * <p>流程（正式 Spec REQ-001~REQ-005）：REQ-001 依据输入账号 baseAcctNo 查询【对公存款账户主表】
 * （RB_BUS_ACCT）取得账户状态（acctStatus）；REQ-002 调用组件内步骤 ST052 取得转账止付标志；
 * REQ-003 调用组件内步骤 ST056 取得转账不收不付标志；REQ-004 以账户状态、转账止付标志、
 * 转账不收不付标志执行决策规则 DT001 取得出账标志；REQ-005 出账标志为「允许」时返回检查结果
 * 「通过」、步骤成功结束（succeed=true、错误字段为 null），否则步骤失败、返回错误码
 * ER0076（errorMessage 为 {@code ER0076::转出账户不允许出账，交易失败}）。</p>
 *
 * <p>按账号查询账户记录工程口径（TBD-2）、查询无记录行为（TBD-5）、baseAcctNo 必填缺失行为
 * （TBD-6）、两个标志物理编码（TBD-4）、出账标志物理取值（TBD-3）见 {@code execute} 中 FIXME，
 * 待业务确认后落实。</p>
 */
@Service
public class ST027Pbc implements IST027 {

    private final IRbBusAcctBcc rbBusAcctBcc;

    private final IST052 ist052;

    private final IST056 ist056;

    public ST027Pbc(IRbBusAcctBcc rbBusAcctBcc, IST052 ist052, IST056 ist056) {
        this.rbBusAcctBcc = rbBusAcctBcc;
        this.ist052 = ist052;
        this.ist056 = ist056;
    }

    @Override
    public ST027OutputBO execute(ST027InputBO input) {
        ST027OutputBO output = new ST027OutputBO();

        // 子步骤 REQ-001 获取账户状态：依据输入账号 baseAcctNo 查询对公存款账户主表
        // （RB_BUS_ACCT，业务称谓「账户信息」），取得账户状态（acctStatus）。
        // FIXME 业务项:ST027/检查账户是否能够出账 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:按账号（baseAcctNo）定位账户记录并取得 acctStatus 的工程口径未确认，当前 RbBusAcctEO 未暴露 baseAcctNo 字段（主键为客户号、账户内部键值）（Spec 待确认事项 TBD-2） - 影响:当前仅以空 EO 组合查询并取结果集第一条记录，查询条件无法表达账号，acctStatus 来源记录未确认 - 待确认:按账号定位账户记录并取得账户状态的实现口径（字段、关联表或索引表）
        // FIXME 业务项:ST027/检查账户是否能够出账 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:baseAcctNo 标记必填，需求未定义其为空/未提供时的步骤行为（是否返回错误）（Spec 待确认事项 TBD-6） - 影响:必填缺失时当前实现无已确认的返回结果，继续以空值执行后续查询与调用 - 待确认:baseAcctNo 缺失/空值时的步骤行为
        RbBusAcctEO acctQuery = new RbBusAcctEO();
        List<RbBusAcctEO> acctList = rbBusAcctBcc.findByEo(acctQuery);

        // FIXME 业务项:ST027/检查账户是否能够出账 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:按账号查询对公存款账户主表无记录、无法取得账户状态时，需求未定义步骤行为（报错或跳过后续检查）（Spec 待确认事项 TBD-5） - 影响:无记录路径当前无已确认的返回结果 - 待确认:查询无记录时步骤是报错还是跳过后续检查（及对应返回）
        if (acctList == null || acctList.isEmpty()) {
            // TBD-5 未确认：按单条结果查询约定（无记录返回空、查询为空不等于业务失败），
            // 暂按正常提前结束返回（不设置业务字段），不作为业务失败；该路径结果待业务确认后实现。
            output.setSucceed(true);
            output.setErrorCode(null);
            output.setErrorMessage(null);
            return output;
        }

        RbBusAcctEO acctRecord = acctList.get(0);
        output.setAcctStatus(acctRecord.getAcctStatus());

        // 子步骤 REQ-002 获取账户转账止付标志：调用组件内步骤 ST052「检查是否存在转账止付限制」，
        // 取得该步骤返回的转账止付标志（stopFlag）。
        // FIXME 业务项:ST027/检查账户是否能够出账 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:转账止付标志、转账不收不付标志业务取值为「是」/「否」，物理取值（字面量中文串或映射编码如 Y/N）分别沿 ST052、ST056 Spec 待确认（Spec 待确认事项 TBD-4） - 影响:当前按字面量「是」/「否」透传并作为 DT001 规则输入，若物理编码确认后需复核取值与断言 - 待确认:两个标志的物理取值常量
        ST052InputBO st052Input = new ST052InputBO();
        st052Input.setBaseAcctNo(input.getBaseAcctNo());
        ST052OutputBO st052Output = ist052.execute(st052Input);
        output.setTransferStopFlag(st052Output.getStopFlag());

        // 子步骤 REQ-003 获取账户转账不收不付标志：调用组件内步骤 ST056「检查是否存在转账不收不付限制」，
        // 取得该步骤返回的转账不收不付标志。
        ST056InputBO st056Input = new ST056InputBO();
        st056Input.setBaseAcctNo(input.getBaseAcctNo());
        ST056OutputBO st056Output = ist056.execute(st056Input);
        output.setTransferNoCreditNoDebitFlag(st056Output.getTransferNoCreditNoDebitFlag());

        // 子步骤 REQ-004 执行检查账户是否能够出账规则：以 REQ-001~REQ-003 取得的账户状态、
        // 转账止付标志、转账不收不付标志为输入，执行决策规则 DT001，取得出账标志（debitFlag）。
        String debitFlag = DT001.execute(output.getAcctStatus(),
                output.getTransferStopFlag(), output.getTransferNoCreditNoDebitFlag());
        output.setDebitFlag(debitFlag);

        // 子步骤 REQ-005 检查出账标志：出账标志为「允许」时返回检查结果「通过」（步骤成功结束）；
        // 否则返回错误码 ER0076（转出账户不允许出账，交易失败），步骤失败。
        // FIXME 业务项:ST027/检查账户是否能够出账 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:出账标志业务取值为「允许」/「不允许」，物理取值（字面量中文串或映射编码）未确认，REQ-005「为'允许'」的判断口径随之待确认（Spec 待确认事项 TBD-3） - 影响:当前按字面量「允许」判断并沿 DT001 现行实现取值，若物理编码确认后需复核判断口径与断言 - 待确认:出账标志物理取值及「允许」判断口径
        if ("允许".equals(debitFlag)) {
            // 检查结果「通过」：按 Spec 已接受结论 TBD-7，以步骤成功结束承载（succeed=true、错误字段为 null）
            output.setSucceed(true);
            output.setErrorCode(null);
            output.setErrorMessage(null);
        } else {
            output.setSucceed(false);
            output.setErrorCode("ER0076");
            output.setErrorMessage("ER0076::转出账户不允许出账，交易失败");
        }
        return output;
    }
}
