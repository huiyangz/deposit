package com.dcits.deposit.step;

import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.facade.bo.ST033InputBO;
import com.dcits.deposit.facade.bo.ST033OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ST033 检查账户余额类型一致性 步骤实现。
 *
 * <p>按子步骤 REQ-001、REQ-002 分别获取转出、转入账户的余额类型，REQ-003 比较两者
 * 一致性：不一致返回错误码 ER0075，一致返回「通过」。</p>
 */
@Service
public class ST033Pbc implements IST033 {

    @Autowired
    private IRbBusAcctBcc rbBusAcctBcc;

    @Override
    public ST033OutputBO execute(ST033InputBO input) {
        // FIXME 业务项:ST033 检查账户余额类型一致性 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:baseAcctNo 与 othBaseAcctNo 为必填输入，输入缺失时的行为未定义 - 影响:当前实现不校验必填输入，输入缺失时仍继续执行查询 - 待确认:必填输入缺失时应返回何种失败结果与错误码
        ST033OutputBO output = new ST033OutputBO();

        // 第 1 步（REQ-001）：获取转出账户余额类型
        // FIXME 业务项:ST033 检查账户余额类型一致性 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:按 baseAcctNo 定位对公存款账户主表记录的实际查询路径未确认，IRbBusAcctBcc 无按账号查询方法，findByEo 的请求条件字段映射未确定 - 影响:当前以空查询条件调用 findByEo 获取转出账户记录 - 待确认:按账号查询 RB_BUS_ACCT 的请求条件字段映射
        RbBusAcctEO outQueryEo = new RbBusAcctEO();
        RbBusAcctEO outAcct = firstRecord(rbBusAcctBcc.findByEo(outQueryEo));
        BalType outBalType = outAcct == null ? null : outAcct.getBalType();

        // 第 2 步（REQ-002）：获取转入账户余额类型
        // FIXME 业务项:ST033 检查账户余额类型一致性 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:按 othBaseAcctNo 定位对公存款账户主表记录的实际查询路径未确认，IRbBusAcctBcc 无按账号查询方法，findByEo 的请求条件字段映射未确定 - 影响:当前以空查询条件调用 findByEo 获取转入账户记录 - 待确认:按对手账号查询 RB_BUS_ACCT 的请求条件字段映射
        RbBusAcctEO inQueryEo = new RbBusAcctEO();
        RbBusAcctEO inAcct = firstRecord(rbBusAcctBcc.findByEo(inQueryEo));
        BalType inBalType = inAcct == null ? null : inAcct.getBalType();

        // 第 3 步（REQ-003）：比较转出与转入账户余额类型，不一致返回 ER0075
        if (outBalType != inBalType) {
            output.setSucceed(false);
            output.setErrorCode("ER0075");
            output.setErrorMessage("ER0075::转账双方账户余额类型不一致");
            return output;
        }

        // 余额类型一致，检查结果「通过」；输出 rbAcctType 非必填
        // FIXME 业务项:ST033 检查账户余额类型一致性 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:输出字段 rbAcctType（存款账户类型）与比较字段 balType（余额类型）的概念关系及 rbAcctType 归属账户未定义 - 影响:当前从转出账户记录赋值 rbAcctType - 待确认:rbAcctType 与 balType 的关系及 rbAcctType 归属账户
        if (outAcct != null) {
            output.setRbAcctType(outAcct.getRbAcctType());
        }
        output.setSucceed(true);
        return output;
    }

    /**
     * 面向单条结果查询：无记录返回空、多条取结果集第一条。
     *
     * @param records 查询结果集
     * @return 结果集第一条记录，无记录时返回 null
     */
    private RbBusAcctEO firstRecord(List<RbBusAcctEO> records) {
        // FIXME 业务项:ST033 检查账户余额类型一致性 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:查询无对公存款账户主表记录时的行为未定义 - 影响:当前无记录时返回空，转出/转入余额类型为 null，是否参与比较与失败均未定义 - 待确认:查询无记录时步骤应返回何种结果
        if (records == null || records.isEmpty()) {
            return null;
        }
        return records.get(0);
    }
}
