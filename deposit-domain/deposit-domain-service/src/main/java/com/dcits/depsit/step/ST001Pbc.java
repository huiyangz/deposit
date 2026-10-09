package com.dcits.depsit.step;

import com.dcits.depsit.enums.VoucherLostStatus;
import com.dcits.depsit.facade.bo.ST001InputBO;
import com.dcits.depsit.facade.bo.ST001OutputBO;
import com.dcits.depsit.facade.components.IRbVoucherLostBcc;
import com.dcits.depsit.facade.eo.RbVoucherLostEO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST001 检查对手账户凭证状态 —— 步骤实现。
 *
 * <p>子步骤 1 根据 {账号}（入参 {@code othBaseAcctNo}）查询【凭证挂失信息】，由查询结果
 * 确定 [凭证挂失状态] 并写入输出字段 {@code voucherLostStatus}；子步骤 2 以该值判定：
 * 为 {@code USE}（使用）时返回错误码 {@code ER0068}，否则（含 {@code CAN} 与空值）返回
 * 检查结果为「通过」。两步为固定次序，查询 MUST 先于判定执行，判定 MUST NOT 再次查询。</p>
 *
 * <p>本步骤为只读检查，不新增、修改或删除任何数据，无业务副作用。</p>
 */
@Service
public class ST001Pbc implements IST001 {

    /** [凭证挂失状态] 为 USE（使用）时的错误码；文案取自错误码资料 ER0068。 */
    private static final String ERROR_CODE_VOUCHER_LOST = "ER0068";

    /** [凭证挂失状态] 为 USE（使用）时的错误信息，格式为「错误码::业务说明」。 */
    private static final String ERROR_MESSAGE_VOUCHER_LOST = "ER0068::账户凭证挂失不能支取";

    /** 【凭证挂失信息】数据服务（实体表 RB_VOUCHER_LOST） */
    @Autowired
    private IRbVoucherLostBcc rbVoucherLostBcc;

    @Override
    public ST001OutputBO execute(ST001InputBO input) {
        ST001OutputBO output = new ST001OutputBO();

        // 子步骤 1「获取凭证挂失状态」：根据 {账号} 查询【凭证挂失信息】，
        // 按 REQ-002 的取值规则确定 [凭证挂失状态] 并写入输出字段（REQ-001、REQ-002、REQ-003）
        RbVoucherLostEO condition = new RbVoucherLostEO();
        condition.setBaseAcctNo(input.getOthBaseAcctNo());
        List<RbVoucherLostEO> voucherLostRecords = rbVoucherLostBcc.findByEo(condition);
        output.setVoucherLostStatus(resolveVoucherLostStatus(voucherLostRecords));

        // 子步骤 2「检查凭证挂失状态」：[凭证挂失状态] 为 USE-使用 → 返回错误码 ER0068（REQ-004-S01）
        if (VoucherLostStatus.USE.equals(output.getVoucherLostStatus())) {
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_VOUCHER_LOST);
            output.setErrorMessage(ERROR_MESSAGE_VOUCHER_LOST);
            return output;
        }

        // 子步骤 2 的「否则」分支：非 USE（含 CAN 与空值）→ 检查结果为「通过」（REQ-004-S02、REQ-004-S03）
        output.setSucceed(true);
        return output;
    }

    /**
     * 按 Spec REQ-002 的取值规则由查询结果确定凭证挂失状态。
     *
     * <p>查询无记录时为空（REQ-002-S03）；查询为单条记录时取该记录的凭证挂失状态
     * （REQ-002-S01 的一般取值规则）；查询为多条记录时取处于挂失生效状态
     * （{@link VoucherLostStatus#USE}，使用）的那条记录的状态（REQ-002-S02），
     * 不受非生效记录与记录顺序影响。</p>
     *
     * <p>多条记录但无任何记录处于挂失生效状态时的具体取值，源需求未规定、Spec 不臆造
     * （「## 验收范围与明确不覆盖的事项」第 1 项），故此处不取值，保持为空——空值属
     * REQ-003 允许的合法结果；该情形下子步骤 2 仍走「否则」分支返回通过（REQ-004-S02 口径说明）。</p>
     *
     * @param records 按账号查询【凭证挂失信息】返回的挂失登记记录，可能为 {@code null}
     * @return 确定的凭证挂失状态，可能为 {@code null}
     */
    private VoucherLostStatus resolveVoucherLostStatus(List<RbVoucherLostEO> records) {
        if (records == null || records.isEmpty()) {
            return null;
        }
        for (RbVoucherLostEO record : records) {
            if (VoucherLostStatus.USE.equals(record.getVoucherLostStatus())) {
                return VoucherLostStatus.USE;
            }
        }
        if (records.size() == 1) {
            return records.get(0).getVoucherLostStatus();
        }
        return null;
    }
}
