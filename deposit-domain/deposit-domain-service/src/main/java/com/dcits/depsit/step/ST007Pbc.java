package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST007InputBO;
import com.dcits.depsit.facade.bo.ST007OutputBO;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.eo.RbBusAcctEO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST007 检查对手账户是否存在 —— 步骤实现。
 *
 * <p>子步骤 1 根据 {对手账号}（入参 {@code othBaseAcctNo}）查询【账户信息】获取
 * [对手账户信息]；子步骤 2 据其是否存在给出检查结论：[对手账户信息] 为空时返回错误码
 * {@code ER0081}，否则返回检查结果为「通过」。两步为固定次序，查询 MUST 先于存在性检查执行。</p>
 *
 * <p>本步骤为只读检查，不新增、修改或删除任何数据，无业务副作用。</p>
 *
 * <p>说明：【账户信息】的数据源（表／实体／接口）未被源需求绑定（Spec 不覆盖事项第 1 项），
 * 此处使用工程内可承载对手账号查询与三个输出字段的账户主数据实体 {@link RbBusAcctEO}
 * 及其数据服务接口 {@link IRbBusAcctBcc}，仅为 Spec「### 依赖调用」所列的非规范性观察，
 * 不构成需求已确认的数据源约束。</p>
 */
@Service
public class ST007Pbc implements IST007 {

    /** [对手账户信息] 为空时的错误码；源需求只指定错误码，业务说明取自错误码资料 ER0081。 */
    private static final String ERROR_CODE_OTH_ACCT_NOT_EXIST = "ER0081";

    /** [对手账户信息] 为空时的错误信息，格式为「错误码::业务说明」。 */
    private static final String ERROR_MESSAGE_OTH_ACCT_NOT_EXIST = "ER0081::对手账户不存在";

    @Autowired
    private IRbBusAcctBcc irBusAcctBcc;

    @Override
    public ST007OutputBO execute(ST007InputBO input) {
        ST007OutputBO output = new ST007OutputBO();

        // 子步骤 1「获取对手账户信息」：根据 {对手账号} 查询【账户信息】获取 [对手账户信息]
        RbBusAcctEO condition = new RbBusAcctEO();
        condition.setBaseAcctNo(input.getOthBaseAcctNo());
        List<RbBusAcctEO> othAcctInfos = irBusAcctBcc.findByEo(condition);

        // 子步骤 2「检查对手账户信息存在性」：[对手账户信息] 为空 → 返回错误码 ER0081
        if (othAcctInfos == null || othAcctInfos.isEmpty()) {
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_OTH_ACCT_NOT_EXIST);
            output.setErrorMessage(ERROR_MESSAGE_OTH_ACCT_NOT_EXIST);
            return output;
        }

        // 子步骤 2 的「否则」分支：[对手账户信息] 非空 → 检查结果为「通过」
        output.setSucceed(true);
        return output;
    }
}
