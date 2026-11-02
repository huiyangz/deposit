package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.WithdrawalType;
import com.dcits.deposit.facade.bo.ST019InputBO;
import com.dcits.deposit.facade.bo.ST019OutputBO;
import com.dcits.deposit.facade.components.IRbBusClientAcctBcc;
import com.dcits.deposit.facade.eo.RbBusClientAcctEO;

/**
 * ST019 检查账户支取方式。
 *
 * <p>步骤描述条目 1：根据{账号}查询【账户信息】获取$支取方式$；条目 2：若[支取方式]为
 * 「凭密码支取」，则跳转至步骤《检查支取密码状态》，否则检查通过。</p>
 *
 * <p>支取方式来源实体按 Spec「输出」表声明为对公客户账户表（RB_BUS_CLIENT_ACCT），
 * 经 {@link IRbBusClientAcctBcc#findByEo(RbBusClientAcctEO)} 按账号查询，取结果集
 * 第一条的支取方式输出。查询目标实体所指（Spec 待确认事项 TBD-1）与凭密码支取的
 * 跳转承载机制（Spec 待确认事项 TBD-4）见 {@link #execute(ST019InputBO)} 中 FIXME。</p>
 */
@Service
public class ST019Pbc implements IST019 {
    @Autowired
    private IRbBusClientAcctBcc rbBusClientAcctBcc;

    @Override
    public ST019OutputBO execute(ST019InputBO input) {
        ST019OutputBO result = new ST019OutputBO();
        // 子步骤1 获取支取方式：根据{账号}查询【账户信息】获取$支取方式$
        // FIXME 业务项:ST019/检查账户支取方式 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:步骤描述称“根据{账号}查询【账户信息】”，requirement-name-mapping 将「账户信息」映射为对公存款账户主表（RB_BUS_ACCT），而「输出」表声明支取方式来源实体为对公客户账户表（RB_BUS_CLIENT_ACCT），查询目标实体所指不一致（Spec 待确认事项 TBD-1） - 影响:当前按「输出」表声明经 IRbBusClientAcctBcc.findByEo 查询对公客户账户表并取结果集第一条的支取方式，若确认实际查询目标为主表则查询实体与 BCC 需调整 - 待确认:本步骤实际查询的目标实体是否为对公客户账户表（RB_BUS_CLIENT_ACCT）
        RbBusClientAcctEO queryEo = new RbBusClientAcctEO();
        queryEo.setBaseAcctNo(input.getBaseAcctNo());
        List<RbBusClientAcctEO> records = rbBusClientAcctBcc.findByEo(queryEo);
        WithdrawalType withdrawalType = null;
        if (records != null && !records.isEmpty()) {
            withdrawalType = records.get(0).getWithdrawalType();
        }
        result.setWithdrawalType(withdrawalType);
        // 子步骤2 检查支取方式：若[支取方式]为「凭密码支取」，则跳转至步骤《检查支取密码状态》，否则检查通过
        if (withdrawalType == WithdrawalType.P) {
            // FIXME 业务项:ST019/检查账户支取方式 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:“凭密码支取”时跳转至步骤《检查支取密码状态》的承载机制未定义（结果字段、路由标记或由流程编排读取步骤结果判定），且 docs/specs/ 中尚无该目标步骤的正式 Spec（Spec 待确认事项 TBD-4） - 影响:当前仅按已确认部分返回本步骤成功及输出支取方式 P，无法表达跳转可观察结果，目标步骤调用待确认后补充 - 待确认:跳转在步骤结果中的表达方式及目标步骤对应任务/正式 Spec
            // 凭密码支取：本步骤不判定为检查失败，流程跳转《检查支取密码状态》的承载机制未确认，当前不产生跳转可观察结果
        }
        // 检查通过：本步骤正常结束（凭密码支取时跳转《检查支取密码状态》不判定为本步骤检查失败）
        result.setSucceed(true);
        return result;
    }
}
