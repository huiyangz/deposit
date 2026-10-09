package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST129InputBO;
import com.dcits.depsit.facade.bo.ST129OutputBO;
import org.springframework.stereotype.Service;

/**
 * ST129 检查增加限制起始日期（交易执行步骤）。
 *
 * <p>判定规则（步骤描述第 1 条）：若上送的「开始日期」小于「系统日期」或者大于「结束日期」，
 * 则返回检查结果为「不通过」，否则返回「通过」。两个不通过条件为「或者」关系，任一成立即不通过，
 * 结果唯一；「小于」「大于」均为严格关系，相等不构成不通过条件。</p>
 *
 * <p>本步骤为纯入参判定，不访问数据库、不调用规则与组件接口、无写入与事务，
 * 因而不产生业务失败场景，失败仅由技术异常向上层传播；源需求未给出错误码，
 * 本步骤不以错误码表达判定结果。</p>
 */
@Service
public class ST129Pbc implements IST129 {

    /**
     * 执行检查增加限制起始日期的判定。
     *
     * @param input 判定入参
     * @return 检查结果：succeed=true 为「通过」、succeed=false 为「不通过」；错误字段保持 null
     */
    @Override
    public ST129OutputBO execute(ST129InputBO input) {
        ST129OutputBO output = new ST129OutputBO();

        // 判定：startDate 早于 runDate（严格小于）或者 startDate 晚于 endDate（严格大于），任一成立即「不通过」
        if (input.getStartDate().before(input.getRunDate())
                || input.getStartDate().after(input.getEndDate())) {
            output.setSucceed(false);
            return output;
        }

        // 否则（startDate 不早于 runDate 且不晚于 endDate）返回「通过」
        output.setSucceed(true);
        return output;
    }
}
