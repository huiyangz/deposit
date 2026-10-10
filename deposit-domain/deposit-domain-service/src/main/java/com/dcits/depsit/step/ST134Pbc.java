package com.dcits.depsit.step;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcits.depsit.facade.bo.ST134InputBO;
import com.dcits.depsit.facade.bo.ST134OutputBO;
import com.dcits.depsit.facade.components.IRbBusAcctBalanceBcc;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.eo.RbBusAcctBalanceEO;
import com.dcits.depsit.facade.eo.RbBusAcctEO;

/**
 * ST134 解限更新账户冻结金额 —— 步骤实现。
 *
 * <p>编排（源需求「## 步骤描述」1「先…再…」）：</p>
 * <ol>
 *   <li>按 {账号}（入参 {@code baseAcctNo}）查询【账户信息】取得账户内部键值；</li>
 *   <li>按该账户内部键值把【账户余额信息】的冻结金额 {@code pldAmount} 更新为 0。</li>
 * </ol>
 *
 * <p>业务失败只有一类：查不到账户或该账户没有余额记录，两者均返回错误码 {@code ER0048}
 * （{@code errorcodes.properties}：ER0048=账户不存在）并结束本步骤，不执行更新；其余失败仅由
 * 技术异常传播表达，本实现不捕获、不转换、不重试。</p>
 */
@Service
public class ST134Pbc implements IST134 {

    /** 业务失败错误码：账户不存在（源需求「## 失败处理」）。 */
    private static final String ERROR_CODE_ACCT_NOT_EXIST = "ER0048";

    /** 业务失败错误信息，格式为「错误码::业务说明」。 */
    private static final String ERROR_MSG_ACCT_NOT_EXIST = "ER0048::账户不存在";

    /** 本步骤写入的冻结金额取值：0。 */
    private static final BigDecimal PLD_AMOUNT_ZERO = BigDecimal.ZERO;

    /** 【账户信息】数据服务接口。 */
    @Autowired
    private IRbBusAcctBcc rbBusAcctBcc;

    /** 【账户余额信息】数据服务接口。 */
    @Autowired
    private IRbBusAcctBalanceBcc rbBusAcctBalanceBcc;

    /**
     * 执行本步骤（含本地更新，调用方须在事务内调用）。
     */
    @Override
    @Transactional
    public ST134OutputBO execute(ST134InputBO input) {
        ST134OutputBO output = new ST134OutputBO();

        // ① 按 {账号} 查询【账户信息】取得账户内部键值（REQ-002）
        RbBusAcctEO acctCondition = new RbBusAcctEO();
        acctCondition.setBaseAcctNo(input.getBaseAcctNo());
        List<RbBusAcctEO> acctList = rbBusAcctBcc.findByEo(acctCondition);
        if (acctList == null || acctList.isEmpty()) {
            // 失败情形 (a) 查不到账户：返回 ER0048 并结束本步骤，不执行更新（REQ-005(a)）
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_ACCT_NOT_EXIST);
            output.setErrorMessage(ERROR_MSG_ACCT_NOT_EXIST);
            return output;
        }
        // 同一账号对应多条账户记录时的键值选择口径源需求未定义（Spec 不覆盖事项第 1 项），
        // 本实现取查询结果的第一条记录；该情形不在本轮验收范围内。
        Integer internalKey = acctList.get(0).getInternalKey();

        // ② 按账户内部键值定位【账户余额信息】记录（REQ-003、REQ-005(b)）
        RbBusAcctBalanceEO balance = rbBusAcctBalanceBcc.findByPrimaryKey(internalKey);
        if (balance == null) {
            // 失败情形 (b) 该账户没有余额记录：与 (a) 同一错误码 ER0048，不执行更新（REQ-005(b)）
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_ACCT_NOT_EXIST);
            output.setErrorMessage(ERROR_MSG_ACCT_NOT_EXIST);
            return output;
        }

        // ② 按账户内部键值把冻结金额更新为 0；写入范围仅为冻结金额，定位条件仅为账户内部键值
        RbBusAcctBalanceEO updateEo = new RbBusAcctBalanceEO();
        updateEo.setInternalKey(internalKey);
        updateEo.setPldAmount(PLD_AMOUNT_ZERO);
        rbBusAcctBalanceBcc.modifyByPrimaryKeySelective(updateEo);

        // 输出承载本次写入的冻结金额取值 0（REQ-006），成功路径无业务错误码（REQ-007）
        output.setPldAmount(PLD_AMOUNT_ZERO);
        output.setSucceed(true);
        return output;
    }
}
