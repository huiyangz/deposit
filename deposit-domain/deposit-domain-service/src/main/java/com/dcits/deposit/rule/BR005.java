package com.dcits.deposit.rule;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.dcits.deposit.enums.TermType;

/**
 * BR005 计算到期日期
 *
 * <p>按期限类型在核心运行日期基础上计算到期日期：
 * a.日：到期日期 = runDate + term天；
 * b.月：到期日期 = runDate + term月，若 runDate 是月末或加月后日期无效（如31日加到2月），则“日”调整为目标月最后一天；
 * c.年：到期日期 = runDate + term年，若 runDate 是2月29日且到期年份不是闰年，则调整为2月28日；
 * d.周：到期日期 = runDate + term周（按 term×7 天计算）；
 * e.季：到期日期 = runDate + term季（按 term×3 个月计算，月末调整规则同b）；
 * f.半年：到期日期 = runDate + term半年（按 term×6 个月计算，月末调整规则同b）。
 */
public class BR005 {

    /**
     * 计算到期日期。
     *
     * @param runDate 核心运行日期
     * @param term 存期期限，纯整数字符串（仅数字字符），不允许小数、负数及带单位写法
     * @param periodType 期限类型
     * @return 到期日期
     */
    public static Date execute(Date runDate, String term, TermType periodType) {
        int amount = Integer.parseInt(term);
        return switch (periodType) {
            case D -> plusDays(runDate, amount);
            case W -> plusDays(runDate, amount * 7);
            case M -> plusMonths(runDate, amount);
            case Q -> plusMonths(runDate, amount * 3);
            case H -> plusMonths(runDate, amount * 6);
            case Y -> plusYears(runDate, amount);
        };
    }

    /** 分支a/d：加天计算，周按 term×7 天折算 */
    private static Date plusDays(Date runDate, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(runDate);
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }

    /** 分支b/e/f：加月计算；runDate 是月末或加月后“日”无效时，到期日期的“日”调整为目标月最后一天 */
    private static Date plusMonths(Date runDate, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(runDate);
        int originDay = cal.get(Calendar.DAY_OF_MONTH);
        boolean originMonthEnd = originDay == cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, months);
        if (originMonthEnd) {
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        } else {
            cal.set(Calendar.DAY_OF_MONTH, Math.min(originDay, cal.getActualMaximum(Calendar.DAY_OF_MONTH)));
        }
        return cal.getTime();
    }

    /** 分支c：加年计算；runDate 是2月29日且到期年份不是闰年时，到期日期调整为2月28日 */
    private static Date plusYears(Date runDate, int years) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(runDate);
        boolean feb29 = cal.get(Calendar.MONTH) == Calendar.FEBRUARY
                && cal.get(Calendar.DAY_OF_MONTH) == 29;
        cal.add(Calendar.YEAR, years);
        if (feb29 && !new GregorianCalendar().isLeapYear(cal.get(Calendar.YEAR))) {
            cal.set(Calendar.MONTH, Calendar.FEBRUARY);
            cal.set(Calendar.DAY_OF_MONTH, 28);
        }
        return cal.getTime();
    }
}
