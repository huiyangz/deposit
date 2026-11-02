package com.dcits.deposit.step;

import com.dcits.common.step.GotoStepCondition;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.facade.bo.ST028InputBO;
import com.dcits.deposit.facade.bo.ST028OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ST028 检查支取账户属性 步骤实现。
 *
 * <p>子步骤1（REQ-001 获取账户属性）：根据必填输入 baseAcctNo（账号）获取【账户信息】
 * （对公存款账户主表 RB_BUS_ACCT），取得账户属性 acctNatureNo 并作为本步骤输出返回。</p>
 * <p>子步骤2（REQ-002 检查账户属性）：账户属性为「验资户」（{@link AcctNatureNo#VALUE_17}，
 * 取值 "17"）时以跳转至步骤《检查账户到期日》结束（正常提前结束、非业务失败、不返回「通过」）；
 * 为其它已确认取值时返回检查结果为「通过」，不触发跳转，步骤正常完成。「临时户」对应枚举取值
 * 待确认（Spec 待确认事项 TBD-1），确认前不绑定未确认枚举常量。</p>
 *
 * <p>未决内容（Spec 待确认事项）：按账号获取账户信息的查询路径（TBD-2）、baseAcctNo 为空/非规范值
 * 及查无记录行为（TBD-3）、acctNatureNo 为空时判定（TBD-4）、「通过」承载方式（TBD-5）、
 * 「临时户」与枚举取值对应（TBD-1），见 {@link #execute(ST028InputBO)} 与
 * {@link #queryRbBusAcct(String)} 中 FIXME。</p>
 */
@Service
@GotoStepCondition(candidateSteps = {"检查账户到期日"})
public class ST028Pbc implements IST028 {

    @Autowired
    private IRbBusAcctBcc rbBusAcctBcc;

    @Override
    public ST028OutputBO execute(ST028InputBO input) {
        ST028OutputBO output = new ST028OutputBO();

        // 子步骤1（REQ-001 获取账户属性）：根据必填输入 baseAcctNo 获取【账户信息】（对公存款账户主表 RB_BUS_ACCT），
        // 取得账户属性 acctNatureNo 并作为本步骤输出返回。
        // FIXME 业务项:ST028/检查支取账户属性 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:baseAcctNo 标记必填，需求未定义其为空、非规范值时的步骤行为（是否业务失败、错误码及返回）（Spec 待确认事项 TBD-3） - 影响:输入缺失/非规范值分支无已确认失败条件与返回，当前不设置校验失败返回，按正常入参路径自然执行 - 待确认:baseAcctNo 为空/非规范值时应返回的结果（通过/失败/其他）及失败条件
        RbBusAcctEO rbBusAcct = queryRbBusAcct(input.getBaseAcctNo());
        if (rbBusAcct != null) {
            output.setAcctNatureNo(rbBusAcct.getAcctNatureNo());
        }

        // 子步骤2（REQ-002 检查账户属性）：账户属性为「验资户」或「临时户」时跳转至《检查账户到期日》
        // （正常提前结束、非业务失败、不返回「通过」）；为其它取值时返回检查结果「通过」，不触发跳转，步骤正常完成。
        if (output.getAcctNatureNo() == null) {
            // FIXME 业务项:ST028/检查支取账户属性 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:acctNatureNo 输出标记非必填，需求未定义账户属性为空（null，账户主表无属性取值）时「检查账户属性」的结果（按「通过」处理还是业务失败）（Spec 待确认事项 TBD-4） - 影响:空属性分支无已确认判定结果，当前按「通过」占位返回，不作为已确认业务行为 - 待确认:acctNatureNo 为 null 时应判定通过还是失败
            // 占位返回：账户属性为空（含主表无记录未取到属性的情况）时判定结果未确认，
            // 此处返回值仅用于满足返回要求，不作为已确认业务行为；待 TBD-2/TBD-4 确认后按确认结果实现。
            output.setSucceed(true);
            return output;
        }
        if (AcctNatureNo.VALUE_17 == output.getAcctNatureNo()) {
            // 账户属性为「验资户」（AcctNatureNo.VALUE_17，取值 "17"）：跳转至步骤《检查账户到期日》，
            // 正常提前结束（显式成功、错误字段为 null），不返回「通过」。
            // FIXME 业务项:ST028/检查支取账户属性 - 问题大类:业务 - 问题分类:枚举业务定义缺失 - 问题描述:需求跳转条件含「临时户」，枚举 AcctNatureNo 无「临时户」同名取值，业务名最接近 VALUE_11003（"11003"，临时存款账户），对应关系未确认；「验资户」对应 VALUE_17（"17"）是否唯一亦待确认（Spec 待确认事项 TBD-1） - 影响:「临时户」→跳转《检查账户到期日》的分支当前未绑定未确认枚举常量，仅实现已确认的「验资户」（VALUE_17）跳转分支 - 待确认:「临时户」是否即 AcctNatureNo.VALUE_11003（临时存款账户），以及「验资户」对应 VALUE_17（"17"）是否唯一
            output.setGotoStepName("检查账户到期日");
            output.setSucceed(true);
            return output;
        }

        // 账户属性为「验资户」「临时户」之外的取值：返回检查结果「通过」，不触发跳转，步骤正常完成。
        // FIXME 业务项:ST028/检查支取账户属性 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:需求输出表仅声明 acctNatureNo，未声明承载"检查结果为『通过』"的业务输出字段，「通过」以步骤正常完成状态表达还是需显式业务输出字段未确认（Spec 待确认事项 TBD-5） - 影响:若「通过」应另有业务输出字段承载，当前 OutputBO 缺少该字段 - 待确认:「通过」是否另有业务输出字段承载，字段名与取值
        output.setSucceed(true);
        return output;
    }

    /**
     * 子步骤1（REQ-001 获取账户属性）的数据访问：按账号获取对公存款账户主表记录。
     *
     * @param baseAcctNo 账号
     * @return 对公存款账户主表记录；无对应记录时返回 null
     */
    private RbBusAcctEO queryRbBusAcct(String baseAcctNo) {
        // FIXME 业务项:ST028/检查支取账户属性 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:需求要求根据必填输入 baseAcctNo 获取【账户信息】（对公存款账户主表 RB_BUS_ACCT），但 IRbBusAcctBcc 未提供按账号 baseAcctNo 查询账户主表的方法（仅有按主键 clientNo+internalKey 的 findByPrimaryKey 及按 EO 属性组合的 findByEo），按账号获取账户信息的实际调用路径未确认（Spec 待确认事项 TBD-2） - 影响:当前实现对已确认数据源 IRbBusAcctBcc 以空查询条件 EO 调用 findByEo 作占位绑定，查询条件未携带 baseAcctNo，REQ-001 按账号取数的路径与请求字段映射待确认后调整 - 待确认:按账号获取账户主表记录的具体查询方法/路径及请求字段映射
        RbBusAcctEO query = new RbBusAcctEO();
        List<RbBusAcctEO> accts = rbBusAcctBcc.findByEo(query);
        if (accts == null || accts.isEmpty()) {
            // FIXME 业务项:ST028/检查支取账户属性 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:按该账号在对公存款账户主表查无账户记录时需求未定义步骤行为（是否业务失败、错误码及返回）（Spec 待确认事项 TBD-3） - 影响:无记录分支无已确认失败条件与返回，不推断为查询无记录即业务失败，当前按"未取到账户属性"（null）继续子步骤2 - 待确认:主表无记录时应返回的结果（通过/失败/其他）及失败条件
            return null;
        }
        // 面向单条结果的查询，多条统一取结果集第一条（本项目约定）。
        return accts.get(0);
    }
}
