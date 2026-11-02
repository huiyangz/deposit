package com.dcits.deposit.step;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.common.step.GotoStepCondition;
import com.dcits.deposit.facade.bo.ST012InputBO;
import com.dcits.deposit.facade.bo.ST012OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBalanceBcc;
import com.dcits.deposit.facade.eo.RbBusAcctBalanceEO;

/**
 * ST012 检查账户余额 步骤实现。
 *
 * <p>按正式 Spec ST012「步骤描述」第 1-3 条依次执行：按账号查询对公存款账户余额表
 * （RB_BUS_ACCT_BALANCE）取得汇总金额、冻结金额、系统内理财余额、透支金额；按公式
 * 计算账户可用余额（汇总金额-冻结金额+系统内理财余额+透支金额）；将账户可用余额与
 * 交易金额比较，小于交易金额跳转《检查法透标志》，否则（含相等）跳转《检查现金支取
 * 账户限制》。需求未声明业务失败场景，本步骤不定义业务失败分支与错误码；未决行为见
 * 待确认事项对应 FIXME。</p>
 */
@Service
@GotoStepCondition(candidateSteps = {"《检查法透标志》", "《检查现金支取账户限制》"})
public class ST012Pbc implements IST012 {

    @Autowired
    private IRbBusAcctBalanceBcc rbBusAcctBalanceBcc;

    @Override
    public ST012OutputBO execute(ST012InputBO input) {
        ST012OutputBO output = new ST012OutputBO();

                                                                                                                                                                      

        // 子步骤 1（获取账户余额信息，REQ-002）：根据{账号}查询【账户余额信息】（对公存款账户余额表）
                                                                                                                                                                                                                                   
                                                           
                                                           
        List<RbBusAcctBalanceEO> balanceList = rbBusAcctBalanceBcc.findByEo(new RbBusAcctBalanceEO());

                                                                                                                                                                                                                         
                                                           
        if (balanceList == null || balanceList.isEmpty()) {
            return output;
        }

                                                                                                                                                                    
                                                           
        RbBusAcctBalanceEO balance = balanceList.get(0);

        output.setTotalAmount(balance.getTotalAmount());
        output.setPldAmount(balance.getPldAmount());
        output.setFinregAmount(balance.getFinregAmount());
        output.setOdAmount(balance.getOdAmount());

        // 子步骤 2（计算账户可用余额，REQ-003）：[账户可用余额]=[汇总金额]-[冻结金额]+[系统内理财余额]+[透支金额]
        BigDecimal acctAvailBal = balance.getTotalAmount()
                .subtract(balance.getPldAmount())
                .add(balance.getFinregAmount())
                .add(balance.getOdAmount());
        output.setAcctAvailBal(acctAvailBal);

        // 子步骤 3（检查可用余额，REQ-004）：若[账户可用余额]小于{交易金额}，跳转《检查法透标志》，否则跳转《检查现金支取账户限制》
        if (acctAvailBal.compareTo(input.getTranAmt()) < 0) {
            output.setGotoStepName("《检查法透标志》");
        } else {
            output.setGotoStepName("《检查现金支取账户限制》");
        }

        output.setSucceed(true);
        return output;
    }
}
