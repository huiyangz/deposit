package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST123InputBO;
import com.dcits.depsit.facade.bo.ST123OutputBO;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ST123 检查账户是否存在不允许销户的限制。
 *
 * <p>遍历本次执行提供的 [账户限制信息]，对每一条记录以其自身的账户限制类型
 * （{@code $账户限制类型$}）为查询键查询【限制类型信息】，取得 {@code $销户标志$} 后：</p>
 * <ol>
 *   <li>查询不到【限制类型信息】：该限制类型不影响销户，继续遍历；</li>
 *   <li>{@code $销户标志$} 为「N-否」：返回 [允许销户标志] 为「不允许销户」并中断遍历；</li>
 *   <li>{@code $销户标志$} 不为「N-否」：继续遍历；</li>
 *   <li>遍历结束（未发生中断）：返回 [允许销户标志] 为「允许销户」。</li>
 * </ol>
 *
 * <p>本步骤为只读检查，不新增、修改或删除数据，无业务失败场景，不产出错误码。</p>
 */
@Service
public class ST123Pbc implements IST123 {

    /** 销户标志的判定码值：N-否 */
    private static final String CLOSE_ACCT_FLAG_NO = "N";

    /** [允许销户标志] 规范常量：允许销户 */
    private static final String ALLOW_CLOSE_ACCT = "允许销户";

    /** [允许销户标志] 规范常量：不允许销户 */
    private static final String NOT_ALLOW_CLOSE_ACCT = "不允许销户";

    private final IRbRestraintTypeBcc rbRestraintTypeBcc;

    public ST123Pbc(IRbRestraintTypeBcc rbRestraintTypeBcc) {
        this.rbRestraintTypeBcc = rbRestraintTypeBcc;
    }

    @Override
    public ST123OutputBO execute(ST123InputBO input) {
        ST123OutputBO output = new ST123OutputBO();

        List<ST123InputBO.RestraintRecord> restraintList = input.getAccountRestraintInfoList();
        if (restraintList != null) {
            for (ST123InputBO.RestraintRecord record : restraintList) {
                // 步骤 1）前半：按当前记录的 $账户限制类型$ 查询【限制类型信息】获取 $销户标志$
                RbRestraintTypeEO restraintTypeInfo =
                        rbRestraintTypeBcc.findByRestraintType(record.getRestraintType());
                // 步骤 1）后半：查询不到【限制类型信息】，该限制类型不影响销户，继续遍历
                if (restraintTypeInfo == null) {
                    continue;
                }
                // 步骤 2）前半：$销户标志$ 为「N-否」，返回「不允许销户」并中断遍历
                if (CLOSE_ACCT_FLAG_NO.equals(restraintTypeInfo.getCloseAcctFlag())) {
                    output.setAllowCloseAcctFlag(NOT_ALLOW_CLOSE_ACCT);
                    output.setSucceed(true);
                    return output;
                }
                // 步骤 2）后半：$销户标志$ 不为「N-否」，继续遍历
            }
        }

        // 末行：结束遍历，返回 [允许销户标志] 为「允许销户」
        output.setAllowCloseAcctFlag(ALLOW_CLOSE_ACCT);
        output.setSucceed(true);
        return output;
    }
}
