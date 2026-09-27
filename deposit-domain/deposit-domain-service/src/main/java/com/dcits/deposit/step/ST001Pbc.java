package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST001InputBO;
import com.dcits.deposit.facade.bo.ST001OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ST001 检查账户到期日
 *
 * 1.获取账户到期日：根据{账号}获取【账户信息】获取$账户到期日期$；{账号}唯一对应一条【账户信息】记录，未查询到记录时返回业务失败
 * 2.检查账户到期日：若[账户到期日期]为空，跳过到期检查，返回检查结果为"通过"；若[账户到期日期]小于{交易日期}，则返回[错误码]"ER0054"，否则返回检查结果为"通过"
 */
@Service
public class ST001Pbc implements IST001 {

    private final IRbBusAcctBcc rbBusAcctBcc;

    public ST001Pbc(IRbBusAcctBcc rbBusAcctBcc) {
        this.rbBusAcctBcc = rbBusAcctBcc;
    }

    @Override
    public ST001OutputBO execute(ST001InputBO input) {
        ST001OutputBO output = new ST001OutputBO();

        // 子步骤1 获取账户到期日：根据{账号}查询【账户信息】，读取$账户到期日期$
        RbBusAcctEO acctInfo = findAcctInfo(input.getBaseAcctNo());
        if (acctInfo == null) {
            // 未查询到记录，返回业务失败（SPEC 未提供该失败路径错误码，errorCode 留空待补码）
            output.setErrorMessage("根据账号未查询到账户信息记录");
            return output;
        }
        Date acctDueDate = acctInfo.getAcctDueDate();
        output.setAcctDueDate(acctDueDate);

        // 子步骤2 检查账户到期日：到期日期为空时跳过到期检查，返回通过
        if (acctDueDate == null) {
            output.setSucceed(true);
            return output;
        }
        // 子步骤2 检查账户到期日：到期日期小于交易日期，返回错误码 ER0054
        if (acctDueDate.before(input.getTranDate())) {
            output.setErrorCode("ER0054");
            output.setErrorMessage("ER0054::账户到期日期小于交易日期");
            return output;
        }
        // 子步骤2 检查账户到期日：到期日期不小于交易日期，返回通过
        output.setSucceed(true);
        return output;
    }

    /**
     * 子步骤1 获取账户到期日：按{账号}查询【账户信息】（RB_BUS_ACCT）
     *
     * @param baseAcctNo 账号，唯一对应一条【账户信息】记录
     * @return 账户信息记录；未查询到记录返回 null
     */
    private RbBusAcctEO findAcctInfo(String baseAcctNo) {
        RbBusAcctEO condition = new RbBusAcctEO();
        condition.setBaseAcctNo(baseAcctNo);
        List<RbBusAcctEO> records = rbBusAcctBcc.findByEo(condition);
        if (records == null || records.isEmpty()) {
            return null;
        }
        return records.get(0);
    }
}
