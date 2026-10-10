package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST002InputBO;
import com.dcits.depsit.facade.bo.ST002OutputBO;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.eo.RbBusAcctEO;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ST002 检查账户到期日 步骤实现。
 *
 * <p>子步骤 1「获取账户到期日」：按 {@code {账号}}＝{@code baseAcctNo} 检索【账户信息】
 * （实体表 {@code RB_BUS_ACCT}），取账户到期日期；查不到账户记录时返回错误码 {@code ER0048} 并短路。
 * 子步骤 2「检查账户到期日」：到期日期为空 → 检查结果「通过」；早于 {@code {交易日期}}＝{@code tranDate}
 * → 返回错误码 {@code ER0054}；不早于（晚于或等于）→ 检查结果「通过」。
 * 「通过」由 {@code succeed = true} 且错误字段为空承载。
 */
@Service
public class ST002Pbc implements IST002 {

    /** 错误码：账户不存在（子步骤 1 按账号查不到账户记录） */
    private static final String ERROR_CODE_ACCT_NOT_EXIST = "ER0048";
    private static final String ERROR_MESSAGE_ACCT_NOT_EXIST = "ER0048::账户不存在";

    /** 错误码：账户已过期（子步骤 2 账户到期日期早于交易日期） */
    private static final String ERROR_CODE_ACCT_EXPIRED = "ER0054";
    private static final String ERROR_MESSAGE_ACCT_EXPIRED = "ER0054::账户已过期";

    private final IRbBusAcctBcc rbBusAcctBcc;

    public ST002Pbc(IRbBusAcctBcc rbBusAcctBcc) {
        this.rbBusAcctBcc = rbBusAcctBcc;
    }

    @Override
    public ST002OutputBO execute(ST002InputBO input) {
        ST002OutputBO output = new ST002OutputBO();

        // 子步骤 1 获取账户到期日：按 {账号} 检索【账户信息】
        // 源需求以「一个{账号}唯一确定一条账户记录」为业务前提，唯一命中即取该条记录；
        // 表主键为 internalKey、账号为普通列，工程上只能条件检索，故以检索结果首条为该唯一记录。
        RbBusAcctEO query = new RbBusAcctEO();
        query.setBaseAcctNo(input.getBaseAcctNo());
        List<RbBusAcctEO> records = rbBusAcctBcc.findByEo(query);
        if (records == null || records.isEmpty()) {
            // 查不到该账户：返回错误码 ER0048，不执行子步骤 2
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_ACCT_NOT_EXIST);
            output.setErrorMessage(ERROR_MESSAGE_ACCT_NOT_EXIST);
            return output;
        }
        Date acctDueDate = records.get(0).getAcctDueDate();
        output.setAcctDueDate(acctDueDate);

        // 子步骤 2 检查账户到期日：到期日期为空 → 通过（不参与比较）；早于 {交易日期} → ER0054；其余 → 通过
        if (acctDueDate != null && acctDueDate.before(input.getTranDate())) {
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_ACCT_EXPIRED);
            output.setErrorMessage(ERROR_MESSAGE_ACCT_EXPIRED);
            return output;
        }
        output.setSucceed(true);
        return output;
    }
}
