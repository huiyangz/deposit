package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.AllDepInd;
import com.dcits.deposit.facade.bo.ST026InputBO;
import com.dcits.deposit.facade.bo.ST026OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST026 检查对手账户通存标志。
 *
 * <p>已确认行为（正式 Spec REQ-001~REQ-003）：按对手账号查询账户信息（对公存款账户主表
 * RB_BUS_ACCT）获取通存标志并输出 {@link ST026OutputBO#getAllDepInd()}；通存标志不等于
 * 「Y-是」时业务失败并返回错误码 ER0055（errorMessage 采用「ER0055::当前交易机构不是账户
 * 的通存机构」格式），等于「Y-是」时正常完成并继续。</p>
 *
 * <p>账号→账户记录解析路径（TBD-4）、「Y-是」与 {@link AllDepInd} 枚举取值映射（TBD-2）、
 * 查询无记录行为（TBD-3）、必填缺失行为（TBD-5）待业务确认，见 {@link #execute} 中 FIXME。</p>
 */
@Service
public class ST026Pbc implements IST026 {

    /** 错误码 ER0055 */
    private static final String ERROR_CODE_ER0055 = "ER0055";
    /** 错误码 ER0055 业务说明 */
    private static final String ERROR_MESSAGE_ER0055 = "当前交易机构不是账户的通存机构";
    /** 通存标志「Y-是」取值（业务正文字面量，REQ-003-S01 样例值「Y」） */
    private static final String ALL_DEP_IND_YES_VALUE = "Y";

    @Autowired
    private IRbBusAcctBcc rbBusAcctBcc;

    @Override
    public ST026OutputBO execute(ST026InputBO input) {
        ST026OutputBO output = new ST026OutputBO();

        // FIXME 业务项:ST026/检查对手账户通存标志 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:必填输入 othBaseAcctNo 缺失/为空时的行为（是否校验报错、错误码与信息）未定义，输入表「来源实体」列为空，对手账号来源实体未声明（Spec 待确认事项 TBD-5） - 影响:当前未执行必填非空校验，对手账号缺失或为空时直接进入查询与检查流程 - 待确认:othBaseAcctNo 缺失/为空时的校验与报错行为、错误码及来源实体

        // 按对手账号查询账户信息（对公存款账户主表 RB_BUS_ACCT），获取通存标志
        // FIXME 业务项:ST026/检查对手账户通存标志 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:按对手账号查询账户信息的账号→账户记录解析路径未确认（对公存款账户主表主键为 clientNo+internalKey，RbBusAcctEO 无账号字段，Spec 待确认事项 TBD-4） - 影响:当前以 IRbBusAcctBcc.findByEo 传入空查询条件查询对公存款账户主表并取结果集第一条作为临时口径，查询条件未按对手账号 othBaseAcctNo 过滤 - 待确认:账号→账户记录的查询口径（如经对公客户账户表 baseAcctNo 定位）及应绑定的 BCC 方法与查询条件
        RbBusAcctEO queryEo = new RbBusAcctEO();
        List<RbBusAcctEO> acctList = rbBusAcctBcc.findByEo(queryEo);

        AllDepInd allDepInd = null;
        if (acctList != null && !acctList.isEmpty()) {
            // 多条结果按单条查询统一约定取结果集第一条，先判空再取值
            allDepInd = acctList.get(0).getAllDepInd();
        } else {
            // FIXME 业务项:ST026/检查对手账户通存标志 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:按对手账号查询无匹配记录时的行为（是否业务失败、错误码与信息）未定义（Spec 待确认事项 TBD-3） - 影响:当前按「无记录返回空」约定使 allDepInd 保持为空并进入通存标志检查，空值不等于「Y-是」→ 失败 ER0055，无记录失败路径待确认 - 待确认:查询无记录时的既定行为及错误码/信息
        }
        output.setAllDepInd(allDepInd);

        // 检查通存标志：等于「Y-是」时正常完成并继续；不等于「Y-是」时业务失败返回 ER0055，不继续执行
        // FIXME 业务项:ST026/检查对手账户通存标志 - 问题大类:业务 - 问题分类:枚举业务定义缺失 - 问题描述:检查条件「Y-是」与输出枚举 AllDepInd（取值 N001~N004，无「Y」）的对应关系未确认（Spec 待确认事项 TBD-2） - 影响:当前以业务正文字面量「Y」与 allDepInd.getValue() 比较作为临时口径，等于「Y-是」的 REQ-003 成功路径当前不可达，成功用例未覆盖 - 待确认:「Y-是」对应的实际编码及与 AllDepInd 取值的映射关系
        if (allDepInd == null || !ALL_DEP_IND_YES_VALUE.equals(allDepInd.getValue())) {
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_ER0055);
            output.setErrorMessage(ERROR_CODE_ER0055 + "::" + ERROR_MESSAGE_ER0055);
            return output;
        }

        output.setSucceed(true);
        return output;
    }
}
