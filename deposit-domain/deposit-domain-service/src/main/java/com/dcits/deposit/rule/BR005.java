package com.dcits.deposit.rule;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * BR005 计算到期日期（计算类）
 *
 * a. 若期限类型是"日"：到期日期 = 核心运行日期 + 存期期限天。
 * b. 若期限类型是"月"：到期日期 = 核心运行日期 + 存期期限月；自然顺延口径，
 *    仅加月后无对应日时（如31日加到2月），将到期日期的"日"调整为该月最后一天
 *    （4月30日存入存1个月到期日为5月30日）。
 * c. 若期限类型是"年"：到期日期 = 核心运行日期 + 存期期限年；核心运行日期是
 *    2月29日且到期年份不是闰年时，将到期日期调整为2月28日。
 */
public final class BR005 {

    private BR005() {
    }

    /**
     * 计算到期日期
     *
     * @param runDate 核心运行日期
     * @param term 存期期限（正整数，单位由期限类型决定）
     * @param periodType 期限类型，取值：日、月、年（中文字面），其他取值为非法输入
     * @return 到期日期
     */
    public static Date execute(Date runDate, Integer term, String periodType) {
        LocalDate baseDate = runDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate maturityDate;
        if ("日".equals(periodType)) {
            maturityDate = baseDate.plusDays(term);
        } else if ("月".equals(periodType)) {
            // plusMonths 即自然顺延口径：加月后无对应日时钳制到该月最后一天
            maturityDate = baseDate.plusMonths(term);
        } else if ("年".equals(periodType)) {
            // plusYears 对 2月29日加年到非闰年时钳制为 2月28日，闰年保持 2月29日
            maturityDate = baseDate.plusYears(term);
        } else {
            throw new IllegalArgumentException("期限类型非法：" + periodType);
        }

        return Date.from(maturityDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
