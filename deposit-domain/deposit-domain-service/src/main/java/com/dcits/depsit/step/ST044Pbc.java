package com.dcits.depsit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.depsit.facade.bo.ST044InputBO;
import com.dcits.depsit.facade.bo.ST044OutputBO;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.eo.RbBusAcctEO;

/**
 * ST044 检查账户存在性 步骤实现。
 *
 * <p>控制流（与正式 Spec 的两个子步骤一致）：</p>
 * <ol>
 *   <li>子步骤 1「获取账户信息」：以入参 {@code baseAcctNo} 为查询条件查询【账户信息】，取得 [账户信息]
 *       （该账号对应的账户记录集合）。该查询恒先于子步骤 2 执行，其结果是子步骤 2 判定的唯一依据。</li>
 *   <li>子步骤 2「检查账户存在性」：查询结果为空（无记录）即 [账户信息] 不存在，返回错误码 {@code ER0048}；
 *       否则返回检查结果为「通过」（{@code succeed = true}）。两个分支互斥且穷尽。</li>
 * </ol>
 *
 * <p>【账户信息】的数据源在正式 Spec 中未绑定（「## 验收范围与明确不覆盖的事项」第 1 项），
 * 此处选用工程内既有的对公存款账户主表数据服务 {@link IRbBusAcctBcc#findByEo(RbBusAcctEO)}
 * 作为查询承载，仅为本步骤可执行所需，不代表该绑定已由需求确认。</p>
 *
 * <p>本步骤为只读检查，不新增、修改或删除任何数据，故不声明事务，也不捕获或包装技术异常
 * （查询调用本身失败的语义源需求未定义，交由上层统一处理）。</p>
 */
@Service
public class ST044Pbc implements IST044 {

    /** 错误码：账户不存在（[账户信息] 不存在时的业务失败码） */
    private static final String ERROR_CODE_ACCT_NOT_EXIST = "ER0048";

    /** 错误信息：已确认错误码资料中的业务说明，按「错误码::业务说明」格式组装 */
    private static final String ERROR_MESSAGE_ACCT_NOT_EXIST = "ER0048::账户不存在";

    /** 【账户信息】的数据服务（本地实体读取入口） */
    @Autowired
    private IRbBusAcctBcc iRbBusAcctBcc;

    @Override
    public ST044OutputBO execute(ST044InputBO input) {
        ST044OutputBO output = new ST044OutputBO();

        // 子步骤 1「获取账户信息」：根据 {账号}（即入参 baseAcctNo）查询【账户信息】获取 [账户信息]。
        RbBusAcctEO queryEo = new RbBusAcctEO();
        queryEo.setBaseAcctNo(input.getBaseAcctNo());
        List<RbBusAcctEO> acctList = iRbBusAcctBcc.findByEo(queryEo);

        // 子步骤 2「检查账户存在性」：若 [账户信息] 不存在，则返回 [错误码]"ER0048"，否则返回检查结果为"通过"。
        // 查询结果为「空（无记录）」即不存在；判定只依据是否存在记录，不读取记录的其它字段取值。
        if (acctList == null || acctList.isEmpty()) {
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_ACCT_NOT_EXIST);
            output.setErrorMessage(ERROR_MESSAGE_ACCT_NOT_EXIST);
            return output;
        }

        output.setSucceed(true);
        return output;
    }
}
