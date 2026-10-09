package com.dcits.depsit.rule;

import java.util.Calendar;
import java.util.Date;

import com.dcits.depsit.enums.TermType;

/**
 * BR007 计算到期日期
 *
 * <p>以核心运行日期（{@code runDate}，规则描述中的「系统日期」）为基准，按期限类型（{@code periodType}）
 * 与期限（{@code term}）推算到期日期（{@code maturityDate}）。</p>
 *
 * <p>本规则为纯计算规则，无外部实体读写，不涉及账务处理与状态变更。</p>
 */
public class BR007 {

    /**
     * 计算到期日期。
     *
     * @param runDate    核心运行日期，到期日期的计算基准
     * @param term       存期期限，即期限数量
     * @param periodType 期限类型，决定采用哪一条计算分支
     * @return 到期日期
     */
    public static Date execute(Date runDate, String term, TermType periodType) {
        int termValue = Integer.parseInt(term);
        switch (periodType) {
            case D:
                // a. 期限类型为「日」：基准日期加 term 天
                return addDays(runDate, termValue);
            case W:
                // d. 期限类型为「周」：基准日期加 term × 7 天
                return addDays(runDate, termValue * 7);
            case M:
                // b. 期限类型为「月」：基准日期加 term 个月
                return addMonths(runDate, termValue);
            case Q:
                // e. 期限类型为「季」：基准日期加 term × 3 个月
                return addMonths(runDate, termValue * 3);
            case H:
                // f. 期限类型为「半年」：基准日期加 term × 6 个月
                return addMonths(runDate, termValue * 6);
            case Y:
                // c. 期限类型为「年」：基准日期加 term 年
                return addYears(runDate, termValue);
            default:
                // periodType 非 TermType 取值的行为源需求未规定，本 Spec 不作约束
                return null;
        }
    }

    /**
     * 按天数推算到期日期（「日」「周」类型）。
     */
    private static Date addDays(Date runDate, int days) {
        Calendar result = Calendar.getInstance();
        result.setTime(runDate);
        result.add(Calendar.DAY_OF_MONTH, days);
        return result.getTime();
    }

    /**
     * 按月数推算到期日期（「月」「季」「半年」类型）。
     *
     * <p>年月部分取基准日期加月后的年月，日期部分默认取基准日期的「日」；若基准日期是其所在月的最后一天，
     * 或按基准日期的「日」加月后的日期无效，则将到期日期的「日」调整为加月后所在月的最后一天。</p>
     */
    private static Date addMonths(Date runDate, int months) {
        Calendar base = Calendar.getInstance();
        base.setTime(runDate);
        int baseDayOfMonth = base.get(Calendar.DAY_OF_MONTH);
        boolean baseIsMonthEnd = baseDayOfMonth == base.getActualMaximum(Calendar.DAY_OF_MONTH);

        Calendar result = Calendar.getInstance();
        result.setTime(runDate);
        result.add(Calendar.MONTH, months);

        int targetLastDayOfMonth = result.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (baseIsMonthEnd || baseDayOfMonth > targetLastDayOfMonth) {
            result.set(Calendar.DAY_OF_MONTH, targetLastDayOfMonth);
        } else {
            result.set(Calendar.DAY_OF_MONTH, baseDayOfMonth);
        }
        return result.getTime();
    }

    /**
     * 按年数推算到期日期（「年」类型）。
     *
     * <p>月、日保持不变；若基准日期为 2 月 29 日且加年后的到期年份不是闰年，则将到期日期调整为该年的 2 月 28 日。</p>
     */
    private static Date addYears(Date runDate, int years) {
        Calendar base = Calendar.getInstance();
        base.setTime(runDate);
        int baseMonth = base.get(Calendar.MONTH);
        int baseDayOfMonth = base.get(Calendar.DAY_OF_MONTH);

        Calendar result = Calendar.getInstance();
        result.setTime(runDate);
        result.add(Calendar.YEAR, years);

        if (baseMonth == Calendar.FEBRUARY && baseDayOfMonth == 29
                && result.getActualMaximum(Calendar.DAY_OF_MONTH) < 29) {
            result.set(Calendar.DAY_OF_MONTH, 28);
        }
        return result.getTime();
    }
}
