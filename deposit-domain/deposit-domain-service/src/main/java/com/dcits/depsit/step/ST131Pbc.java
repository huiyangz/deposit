package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST131InputBO;
import com.dcits.depsit.facade.bo.ST131OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ST131 检查账户限制编号是否存在。
 *
 * <p>步骤由两个动作构成：</p>
 * <ol>
 *   <li>获取限制信息：若 {@code {限制编号}} 不等于空，则根据 {@code {限制编号}} 与
 *       {@code $限制状态$}（码值「A-生效」或「F-未生效」）查询【限制信息】获取 [限制信息]；
 *       {@code {限制编号}} 为空（无值）时不执行查询；</li>
 *   <li>检查账户限制编号是否存在：若 [限制信息] 不为空，则返回检查结果为「限制编号存在」，
 *       否则返回检查结果为「限制编号不存在」。</li>
 * </ol>
 *
 * <p>本步骤为只读检查，不新增、修改或删除数据，不调用其它步骤、规则或外部服务，
 * 无业务失败场景，不产出错误码。</p>
 */
@Service
public class ST131Pbc implements IST131 {

    /** 检查结果规范常量：限制编号存在 */
    private static final String CHECK_RESULT_EXISTS = "限制编号存在";

    /** 检查结果规范常量：限制编号不存在 */
    private static final String CHECK_RESULT_NOT_EXISTS = "限制编号不存在";

    private final IRbBusRestraintsBcc rbBusRestraintsBcc;

    public ST131Pbc(IRbBusRestraintsBcc rbBusRestraintsBcc) {
        this.rbBusRestraintsBcc = rbBusRestraintsBcc;
    }

    @Override
    public ST131OutputBO execute(ST131InputBO input) {
        ST131OutputBO output = new ST131OutputBO();

        // 步骤 1：获取限制信息——{限制编号} 不等于空时，按 {限制编号} 与 $限制状态$ 查询【限制信息】
        List<RbBusRestraintsEO> restraintInfoList = null;
        if (!isEmpty(input.getResSeqNo())) {
            // 查询条件只承载限制编号与限制状态两个字段，不附加其它过滤条件；查询为只读
            RbBusRestraintsEO condition = new RbBusRestraintsEO();
            condition.setResSeqNo(input.getResSeqNo());
            condition.setRestraintsStatus(input.getRestraintsStatus());
            restraintInfoList = rbBusRestraintsBcc.findByEo(condition);
        }

        // 步骤 2：检查账户限制编号是否存在——[限制信息] 不为空返回「限制编号存在」，否则返回「限制编号不存在」
        if (restraintInfoList != null && !restraintInfoList.isEmpty()) {
            output.setCheckResult(CHECK_RESULT_EXISTS);
        } else {
            output.setCheckResult(CHECK_RESULT_NOT_EXISTS);
        }

        output.setSucceed(true);
        return output;
    }

    /**
     * 判断限制编号是否为空（无值）：null 或长度为 0 的空字符串，二者同为「空」。
     */
    private static boolean isEmpty(String resSeqNo) {
        return resSeqNo == null || resSeqNo.isEmpty();
    }
}
