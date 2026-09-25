package com.dcits.deposit.rule;

import java.util.Calendar;
import java.util.Date;

import com.dcits.deposit.enums.TermType;

/**
 * BR005 计算到期日期
 *
 * <p>规则类型：计算类。</p>
 *
 * <p>a. 若期限类型是“日”：到期日期 = 核心运行日期 + 存期期限天。</p>
 *
 * <p>b. 若期限类型是“月”：到期日期 = 核心运行日期 + 存期期限月；若核心运行日期是月末
 * 或加月后日期无效（如 31 日加到 2 月），将到期日期的“日”调整为该月的最后一天。</p>
 *
 * <p>c. 若期限类型是“年”：到期日期 = 核心运行日期 + 存期期限年；若核心运行日期是
 * 2 月 29 日且到期年份不是闰年，将到期日期调整为 2 月 28 日。</p>
 *
 * <p>d. 若期限类型是“周”“季”“半年”：属于非法输入，直接报错，不计算到期日期。</p>
 */
public class BR005 {

    /**
     * 计算到期日期。
     *
     * <p>期限类型为 周/季/半年 时属于非法输入（SPEC 分支 d），直接报错，不计算到期日期。</p>
     *
     * @param runDate 核心运行日期
     * @param term 存期期限（纯数字字符串，解析为非负整数参与日期加法）
     * @param periodType 期限类型（日/月/年；周/季/半年为非法输入，直接报错）
     * @return 到期日期
     */
    public static Date execute(Date runDate, String term, TermType periodType) {
        int amount = Integer.parseInt(term);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(runDate);
        switch (periodType) {
            case D:
                calendar.add(Calendar.DAY_OF_MONTH, amount);
                break;
            case M:
                addMonths(calendar, amount);
                break;
            case Y:
                addYears(calendar, amount);
                break;
            case W, Q, H:
                // SPEC 分支 d：周/季/半年属于非法输入，直接报错，不计算到期日期。
                throw new IllegalArgumentException("期限类型非法，不计算到期日期：" + periodType);
        }
        return calendar.getTime();
    }

    /**
     * 加月：先归一到 1 日完成月份进位，再按 SPEC 分支 b 恢复“日”——
     * 核心运行日期是月末，或原“日”在到期月份无效时，取该月最后一天。
     */
    private static void addMonths(Calendar calendar, int amount) {
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        boolean monthEnd = day == calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, amount);
        int lastDayOfTargetMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, monthEnd || day > lastDayOfTargetMonth ? lastDayOfTargetMonth : day);
    }

    /**
     * 加年：先归一到 1 日完成年份进位，再按 SPEC 分支 c 恢复“日”——
     * 核心运行日期是 2 月 29 日且到期年份不是闰年时，取该年 2 月最后一天（2 月 28 日）；
     * 其余日期在任意年份均有效，保持原“日”不变。
     */
    private static void addYears(Calendar calendar, int amount) {
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        boolean february29 = calendar.get(Calendar.MONTH) == Calendar.FEBRUARY && day == 29;
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.YEAR, amount);
        calendar.set(Calendar.DAY_OF_MONTH, february29 ? calendar.getActualMaximum(Calendar.DAY_OF_MONTH) : day);
    }
}
