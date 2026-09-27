package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST024InputBO;
import com.dcits.deposit.facade.bo.ST024OutputBO;
import com.dcits.deposit.facade.components.ITbCashBalanceBcc;
import com.dcits.deposit.facade.components.ITbTailboxBcc;
import com.dcits.deposit.facade.eo.TbCashBalanceEO;
import com.dcits.deposit.facade.eo.TbTailboxEO;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ST024 更新现金存入后现金尾箱
 *
 * <p>现金存入后更新柜员尾箱现金余额：按{柜员号}、{尾箱属性}等值查询【尾箱基本信息表】取得尾箱编号；
 * 按[尾箱编号]查询【尾箱现金余额】唯一记录的金额（本步骤按单币种处理）；
 * [尾箱余额]=[金额]+{交易金额}后更新回【尾箱现金余额】。
 *
 * <p>本步骤无业务失败场景，失败仅由技术异常传播表达。
 */
@Service
public class ST024Pbc implements IST024 {

    @Autowired
    private ITbTailboxBcc tbTailboxBcc;

    @Autowired
    private ITbCashBalanceBcc tbCashBalanceBcc;

    /**
     * 更新现金存入后现金尾箱。
     *
     * @param input 输入BO，assignUserId、tailboxProperty、tranAmt 均必填
     * @return tailboxId 为子步骤1查询获得的尾箱编号，tailboxBalance 为更新后的尾箱现金余额
     */
    @Override
    @Transactional
    public ST024OutputBO execute(ST024InputBO input) {
        ST024OutputBO output = new ST024OutputBO();

        // 子步骤1 获取柜员现金尾箱编号：根据{柜员号}、{尾箱属性}等值查询【尾箱基本信息表】获取$尾箱编号$
        TbTailboxEO tailboxQuery = new TbTailboxEO();
        tailboxQuery.setAssignUserId(input.getAssignUserId());
        tailboxQuery.setTailboxProperty(input.getTailboxProperty());
        List<TbTailboxEO> tailboxRecords = tbTailboxBcc.findByEo(tailboxQuery);
        String tailboxId = tailboxRecords.get(0).getTailboxId();
        output.setTailboxId(tailboxId);

        // 子步骤2 获取尾箱现金余额：根据[尾箱编号]查询【尾箱现金余额】获取$金额$（尾箱编号对应唯一记录）
        TbCashBalanceEO balanceQuery = new TbCashBalanceEO();
        balanceQuery.setTailboxId(tailboxId);
        List<TbCashBalanceEO> balanceRecords = tbCashBalanceBcc.findByEo(balanceQuery);
        BigDecimal amount = balanceRecords.get(0).getAmount();

        // 子步骤3 计算尾箱现金余额：[尾箱余额]=[金额]+{交易金额}
        BigDecimal tailboxBalance = amount.add(input.getTranAmt());
        output.setTailboxBalance(tailboxBalance);

        // 子步骤4 更新尾箱现金余额：根据[尾箱编号]更新【尾箱现金余额】的$金额$为[尾箱余额]
        TbCashBalanceEO balanceUpdate = new TbCashBalanceEO();
        balanceUpdate.setTailboxId(tailboxId);
        balanceUpdate.setAmount(tailboxBalance);
        tbCashBalanceBcc.modifyByPrimaryKeySelective(balanceUpdate);

        output.setSucceed(true);
        return output;
    }
}
