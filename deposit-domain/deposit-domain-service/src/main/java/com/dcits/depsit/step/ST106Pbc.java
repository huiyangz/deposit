package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST106InputBO;
import com.dcits.depsit.facade.bo.ST106OutputBO;
import com.dcits.depsit.facade.components.IRbLimitSumInfoBcc;
import com.dcits.depsit.facade.eo.RbLimitSumInfoEO;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

/**
 * ST106 获取累计限额 步骤实现。
 *
 * <p>本步骤只有一次数据访问动作：以 {账号}（入参 {@code baseAcctNo}）作为限额检查对象值，连同
 * [限额场景编码]（入参 {@code limitSceneNo}）定位【限额累计信息表 RB_LIMIT_SUM_INFO】中同时满足
 * 两键的记录；命中时取该记录的 $限额累计金额$、$限额累计笔数$ 作为输出 {@code limitSumAmt}、
 * {@code limitSumNum}，查无记录时两值均为数值 0。</p>
 *
 * <p>定位条件为两键的合取，不使用入参 {@code clientNo}；本步骤为纯读取动作，不修改、新增或删除
 * 记录，故不加事务。本步骤无业务失败场景，失败仅由技术异常传播表达。</p>
 */
@Service
public class ST106Pbc implements IST106 {

    private final IRbLimitSumInfoBcc rbLimitSumInfoBcc;

    public ST106Pbc(IRbLimitSumInfoBcc rbLimitSumInfoBcc) {
        this.rbLimitSumInfoBcc = rbLimitSumInfoBcc;
    }

    @Override
    public ST106OutputBO execute(ST106InputBO input) {
        ST106OutputBO output = new ST106OutputBO();

        // 本步骤唯一动作：以「限额检查对象值＝账号」与「限额场景编码」两键合取查询【限额累计信息表】并取值
        RbLimitSumInfoEO limitSumInfo = rbLimitSumInfoBcc.findByPrimaryKey(
                input.getBaseAcctNo(), input.getLimitSceneNo());

        if (limitSumInfo == null) {
            // 查无记录：限额累计金额与限额累计笔数均为 0，属正常取值路径而非业务失败
            output.setLimitSumAmt(BigDecimal.ZERO);
            output.setLimitSumNum(0);
        } else {
            // 命中记录：取该记录的限额累计金额、限额累计笔数本身作为输出取值
            output.setLimitSumAmt(limitSumInfo.getLimitSumAmt());
            output.setLimitSumNum(limitSumInfo.get否());
        }

        output.setSucceed(true);
        return output;
    }
}
