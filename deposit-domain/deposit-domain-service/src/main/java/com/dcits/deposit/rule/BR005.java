package com.dcits.deposit.rule;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * BR005 计算到期日期（计算类）
 *
 * 期限类型仅考虑"日"、"月"、"年"：
 * a. 期限类型为"日"：到期日期 = 系统日期 + 期限天；
 * b. 期限类型为"月"：到期日期 = 系统日期 + 期限月，若系统日期是月末或加月后日期无效（如31日加到2月），
 *    将到期日期的"日"调整为该月的最后一天；
 * c. 期限类型为"年"：到期日期 = 系统日期 + 期限年，若系统日期是2月29日且到期年份不是闰年，
 *    将到期日期调整为2月28日。
 */
public class BR005 {

    /** 期限类型：日 */
    private static final String PERIOD_TYPE_DAY = "日";

    /** 期限类型：月 */
    private static final String PERIOD_TYPE_MONTH = "月";

    /** 期限类型：年 */
    private static final String PERIOD_TYPE_YEAR = "年";

    /**
     * 计算到期日期
     *
     * @param runDate 系统日期（核心运行日期）
     * @param term 存期期限
     * @param periodType 期限类型，仅支持"日"、"月"、"年"
     * @return 到期日期
     */
    public static Date execute(Date runDate, String term, String periodType) {
        Calendar base = new GregorianCalendar();
        base.setTime(runDate);
        int year = base.get(Calendar.YEAR);
        int month = base.get(Calendar.MONTH);
        int day = base.get(Calendar.DAY_OF_MONTH);
        int amount = Integer.parseInt(term);

        if (PERIOD_TYPE_DAY.equals(periodType)) {
            // a. 到期日期 = 系统日期 + 期限天
            Calendar result = new GregorianCalendar(year, month, day);
            result.add(Calendar.DAY_OF_MONTH, amount);
            return result.getTime();
        }

        if (PERIOD_TYPE_MONTH.equals(periodType)) {
            // b. 到期日期 = 系统日期 + 期限月
            int totalMonths = year * 12 + month + amount;
            int targetYear = Math.floorDiv(totalMonths, 12);
            int targetMonth = Math.floorMod(totalMonths, 12);
            int lastDayOfTargetMonth = lastDayOfMonth(targetYear, targetMonth);
            boolean runDateIsMonthEnd = day == lastDayOfMonth(year, month);
            boolean targetDayInvalid = day > lastDayOfTargetMonth;
            // 系统日期是月末或加月后日期无效，将到期日期的"日"调整为该月的最后一天
            int targetDay = (runDateIsMonthEnd || targetDayInvalid) ? lastDayOfTargetMonth : day;
            return new GregorianCalendar(targetYear, targetMonth, targetDay).getTime();
        }

        if (PERIOD_TYPE_YEAR.equals(periodType)) {
            // c. 到期日期 = 系统日期 + 期限年
            int targetYear = year + amount;
            if (month == Calendar.FEBRUARY && day == 29 && !new GregorianCalendar().isLeapYear(targetYear)) {
                // 系统日期是2月29日且到期年份不是闰年，调整为2月28日
                return new GregorianCalendar(targetYear, Calendar.FEBRUARY, 28).getTime();
            }
            return new GregorianCalendar(targetYear, month, day).getTime();
        }

        // SPEC 仅定义期限类型为"日"、"月"、"年"的分支，其他取值属于输入域外，直接明确报错
        throw new IllegalArgumentException("期限类型仅支持\"日\"、\"月\"、\"年\"，当前取值：" + periodType);
    }

    /**
     * 计算指定年月的天数（该月最后一天的日号）
     *
     * @param year 年
     * @param month 月，{@link Calendar} 月份常量（0 起）
     * @return 该月最后一天
     */
    private static int lastDayOfMonth(int year, int month) {
        Calendar calendar = new GregorianCalendar(year, month, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
