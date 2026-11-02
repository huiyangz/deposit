package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.common.step.GotoStepCondition;
import com.dcits.deposit.facade.bo.ST010InputBO;
import com.dcits.deposit.facade.bo.ST010OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST010 检查资金管控标识 步骤实现。
 *
 * <p>实现正式 Spec REQ-001~REQ-003：依据必填输入账号 {@code baseAcctNo} 查询对公存款
 * 账户主表（RB_BUS_ACCT）账户信息，取得贷款资金管控标志（{@code loanFundFlag}）作为
 * 检查标识；为「Y-是」时本步骤正常结束并跳转至候选步骤《检查账户客户一致性》（不返回
 * 「通过」）；不为「Y-是」时返回检查结果「通过」且不发生跳转。</p>
 *
 * <p>查询结果多条记录时按面向单条结果的查询统一约定取结果集第一条记录判定。</p>
 *
 * <p>正式 Spec 待确认事项 2~5（「Y-是」物理编码、查询无记录、必填输入缺失、
 * {@code loanFundFlag} 空值归属）及以账号定位账户记录的查询入参字段映射未决，见
 * {@link #execute(ST010InputBO)} 中 FIXME；未确认分支当前按占位处理，不伪造错误码。</p>
 */
@Service
@GotoStepCondition(candidateSteps = {"检查账户客户一致性"})
public class ST010Pbc implements IST010 {

    private final IRbBusAcctBcc rbBusAcctBcc;

    @Autowired
    public ST010Pbc(IRbBusAcctBcc rbBusAcctBcc) {
        this.rbBusAcctBcc = rbBusAcctBcc;
    }

    @Override
    public ST010OutputBO execute(ST010InputBO input) {
        ST010OutputBO output = new ST010OutputBO();

                                                                                                                                                                                             
                                                           
        String baseAcctNo = input.getBaseAcctNo();

        // 构造按账号定位账户记录的查询 EO；承载 baseAcctNo 的具体属性 Spec 未预设，以工程存在的卡号字段 CARD_NO 承载账号
                                                                                                                                                                                                                                                                                          
                                                           
        RbBusAcctEO queryEo = new RbBusAcctEO();
        queryEo.setCardNo(baseAcctNo);

        // REQ-001 查询路径：依据 baseAcctNo 查询对公存款账户主表账户信息
        List<RbBusAcctEO> acctList = rbBusAcctBcc.findByEo(queryEo);

        // 查询无账户记录：处理需求未定义，当前按占位返回（succeed 保持默认 false、错误字段为空），不伪造错误码
                                                                                                                                                                                                                                                          
                                                           
        if (acctList == null || acctList.isEmpty()) {
            return output;
        }

        // 多条记录按面向单条结果的查询统一约定取结果集第一条记录判定
        RbBusAcctEO acct = acctList.get(0);
        output.setLoanFundFlag(acct.getLoanFundFlag());

        // 检查资金管控标识：为「Y-是」时正常结束并跳转《检查账户客户一致性》，不返回「通过」（REQ-002）
                                                                                                                                                                                                                        
                                                                                                                                                                                                                                    
                                                           
                                                           
        if ("Y-是".equals(output.getLoanFundFlag())) {
            output.setGotoStepName("检查账户客户一致性");
        }

        // 本步骤正常结束：跳转分支（REQ-002）与「通过」分支（REQ-003）均以正常结果返回
        output.setSucceed(true);
        return output;
    }
}
