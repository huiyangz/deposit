package com.dcits.deposit.step;

import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.facade.bo.ST014InputBO;
import com.dcits.deposit.facade.bo.ST014OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ST014 检查对手账户类型 步骤实现。
 *
 * <p>按对手账号（othBaseAcctNo）查询对公存款账户主表（RB_BUS_ACCT）取得存款账户类型并作为输出
 * rbAcctType；账户类型为「T-定期账户」（RbAcctType.T）或「A-AIO账户」（RbAcctType.A）时步骤失败
 * 并返回错误码 ER0052（业务说明「当前账户不为活期账户」），否则检查通过。</p>
 */
@Service
public class ST014Pbc implements IST014 {
    /** 对公存款账户主表数据服务 */
    @Autowired
    private IRbBusAcctBcc rbBusAcctBcc;

    @Override
    public ST014OutputBO execute(ST014InputBO input) {
        ST014OutputBO output = new ST014OutputBO();
        // 子步骤 1 获取账户类型：根据{对手账号}查询【账户信息】获取$账户类型$
        RbAcctType rbAcctType = queryRbAcctType(input.getOthBaseAcctNo());
        output.setRbAcctType(rbAcctType);
        // 子步骤 2 检查账户类型：若[账户类型]不等于"T-定期账户"或"A-AIO账户"，则返回检查结果为"通过"，否则返回[错误码]"ER0052"
        if (rbAcctType == RbAcctType.T || rbAcctType == RbAcctType.A) {
            output.setSucceed(false);
            output.setErrorCode("ER0052");
            output.setErrorMessage("ER0052::当前账户不为活期账户");
        } else {
            output.setSucceed(true);
        }
        return output;
    }

    /**
     * 查询对手账户的存款账户类型。
     *
     * @param othBaseAcctNo 对手账号
     * @return 存款账户类型；查询无记录或账户类型为空时为 null
     */
    private RbAcctType queryRbAcctType(String othBaseAcctNo) {
        RbBusAcctEO queryEo = new RbBusAcctEO();
        // 对手账号定位到 RB_BUS_ACCT 记录的具体映射机制由实现承接，本 Spec 不将其列为新增契约（Spec「已核对工程约束」）
        // FIXME 业务项:ST014/检查对手账户类型 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:othBaseAcctNo 标记必填，但需求未定义该输入缺失（校验不通过）时步骤的失败行为与错误码（Spec 待确认事项 2） - 影响:当前未做必填校验，缺失时按无记录路径继续执行 - 待确认:是否校验必填，校验不通过时以何种错误码拒绝
        queryEo.setCardNo(othBaseAcctNo);
        List<RbBusAcctEO> records = rbBusAcctBcc.findByEo(queryEo);
        if (records == null || records.isEmpty()) {
            // 面向单条结果的查询：无记录按返回空处理；查询无记录时本步骤的预期结果需求未定义，见 FIXME
            // FIXME 业务项:ST014/检查对手账户类型 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:按 othBaseAcctNo 查询不到对手账户记录时，需求未定义本步骤的预期结果；错误码 ER0081=对手账户不存在 未被需求绑定到本步骤（Spec 待确认事项 1） - 影响:当前按字面规则（无账户类型，既非 T 也非 A）返回检查通过且 rbAcctType=null，未按已确认的业务语义执行 - 待确认:查询无记录是否返回 ER0081 失败，还是按「通过」处理
            return null;
        }
        // 面向单条结果的查询：多条统一取结果集第一条，先判空再取值，不额外排序或遍历
        RbAcctType rbAcctType = records.get(0).getRbAcctType();
        if (rbAcctType == null) {
            // FIXME 业务项:ST014/检查对手账户类型 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:账户类型为空或为 RbAcctType 未收录编码（byValue 返回 null）时，需求未定义本步骤的预期结果（Spec 待确认事项 1） - 影响:当前按字面规则（既非 T 也非 A）返回检查通过且 rbAcctType=null，未按已确认的业务语义执行 - 待确认:空/未知账户类型按「通过」处理还是按失败处理
            return null;
        }
        return rbAcctType;
    }
}
