package com.dcits.deposit.step;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcits.deposit.facade.bo.ST012InputBO;
import com.dcits.deposit.facade.bo.ST012OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBalanceBcc;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctBalanceEO;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST012 更新存入后账户余额
 *
 * 子步骤1 获取资金入账账户的账户余额：根据账号查询对公存款账户主表获取账户内部键值，
 * 再根据账户内部键值查询账户余额表获取原汇总金额；
 * 子步骤2 更新资金入账账户的账户余额：将账号对应的账户余额表汇总金额更新为原汇总金额+交易金额。
 * 本步骤无业务失败场景，失败仅由技术异常传播表达。
 */
@Service
public class ST012Pbc implements IST012 {

    private final IRbBusAcctBcc rbBusAcctBcc;
    private final IRbBusAcctBalanceBcc rbBusAcctBalanceBcc;

    public ST012Pbc(IRbBusAcctBcc rbBusAcctBcc, IRbBusAcctBalanceBcc rbBusAcctBalanceBcc) {
        this.rbBusAcctBcc = rbBusAcctBcc;
        this.rbBusAcctBalanceBcc = rbBusAcctBalanceBcc;
    }

    /**
     * {@inheritDoc}
     *
     * 事务要求：更新本地账户余额表（RB_BUS_ACCT_BALANCE），方法内开启 Spring 声明式事务。
     */
    @Override
    @Transactional
    public ST012OutputBO execute(ST012InputBO input) {
        // 子步骤1 获取资金入账账户的账户余额：根据{账号}查询【对公存款账户主表】获取[账户内部键值]
        RbBusAcctEO acctQuery = new RbBusAcctEO();
        acctQuery.setBaseAcctNo(input.getBaseAcctNo());
        RbBusAcctEO busAcct = rbBusAcctBcc.findByEo(acctQuery).get(0);
        // 子步骤1 再根据[账户内部键值]查询【账户余额】获取$汇总金额$
        RbBusAcctBalanceEO balance = rbBusAcctBalanceBcc.findByPrimaryKey(busAcct.getInternalKey());

        // 子步骤2 更新资金入账账户的账户余额：汇总金额 = 原汇总金额 + {交易金额}
        BigDecimal newTotalAmount = balance.getTotalAmount().add(input.getTranAmt());
        RbBusAcctBalanceEO balanceUpdate = new RbBusAcctBalanceEO();
        balanceUpdate.setInternalKey(busAcct.getInternalKey());
        balanceUpdate.setTotalAmount(newTotalAmount);
        rbBusAcctBalanceBcc.modifyByPrimaryKeySelective(balanceUpdate);

        ST012OutputBO output = new ST012OutputBO();
        output.setTotalAmount(newTotalAmount);
        // 账户可用余额按余额记录透传，本步骤未定义可用余额计算
        output.setAcctAvailBal(balance.getAcctAvailBal());
        output.setSucceed(true);
        return output;
    }
}
