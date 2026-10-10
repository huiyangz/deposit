package com.dcits.depsit.step;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.depsit.facade.bo.ST109InputBO;
import com.dcits.depsit.facade.bo.ST109OutputBO;
import com.dcits.depsit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.depsit.facade.eo.RbLimitCtrlConfEO;

/**
 * ST109 检查限额场景配置是否有效。
 *
 * <p>整体意图：以 [限额场景编码]（limitSceneNo）、{交易日期}（tranDate）、{交易时间}（tranTimestamp）
 * 为输入，按 [限额场景编码] 查询【限额控制配置】(RB_LIMIT_CTRL_CONF)，判断该限额场景编码在当前
 * 交易日期／交易时间下是否存在有效配置：任一配置记录的控制区间覆盖本次交易即有效，
 * 查无记录或全部记录都未覆盖即无效。</p>
 *
 * <ul>
 *   <li>子步骤 1：以仅置 limitSceneNo 的 {@link RbLimitCtrlConfEO} 调用 {@code findByEo} 查询配置记录
 *       （表主键为「限额机构编码, 限额场景编码」，本步骤无限额机构编码输入，故可查出 0 条或多条）。</li>
 *   <li>子步骤 2：对每条候选记录判定日期侧与时间侧，两侧同时满足才算该记录覆盖本次交易；
 *       有效时返回入参限额场景编码原值并回显命中记录的控制区间值，无效时返回空值。</li>
 * </ul>
 *
 * <p>日期侧以「日」为比较粒度（含起止日期），时间侧以「时刻」为比较粒度（含起止时刻）；
 * 区间某一端未设置时该端不构成限制，两端均未设置视为满足。
 * {交易时间} 的字符串形式未由源需求定义，本实现按 {@link #TRAN_TIMESTAMP_PATTERN} 解析并取其中的时刻；
 * 无法按该形式解析的取值不满足时间侧，不另行制造业务失败分支。</p>
 *
 * <p>本步骤只读，无业务失败场景：无效判定不作为失败，不设置错误码，
 * 技术异常按技术异常向上传播。</p>
 */
@Service
public class ST109Pbc implements IST109 {

    /** 交易时间戳（tranTimestamp）的取值形式。 */
    private static final String TRAN_TIMESTAMP_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /** 一分钟的秒数。 */
    private static final int SECONDS_PER_MINUTE = 60;

    /** 一小时的秒数。 */
    private static final int SECONDS_PER_HOUR = 60 * SECONDS_PER_MINUTE;

    private final IRbLimitCtrlConfBcc rbLimitCtrlConfBcc;

    public ST109Pbc(IRbLimitCtrlConfBcc rbLimitCtrlConfBcc) {
        this.rbLimitCtrlConfBcc = rbLimitCtrlConfBcc;
    }

    @Override
    public ST109OutputBO execute(ST109InputBO input) {
        ST109OutputBO output = new ST109OutputBO();

        // 子步骤1：按 [限额场景编码] 查询【限额控制配置】，查询条件仅含限额场景编码
        RbLimitCtrlConfEO queryEo = new RbLimitCtrlConfEO();
        queryEo.setLimitSceneNo(input.getLimitSceneNo());
        List<RbLimitCtrlConfEO> confList = rbLimitCtrlConfBcc.findByEo(queryEo);

        // 子步骤2：逐条判定控制区间，其中任一条覆盖本次交易即认为该限额场景配置有效
        RbLimitCtrlConfEO coveredConf = null;
        if (confList != null) {
            for (RbLimitCtrlConfEO conf : confList) {
                if (isCovered(conf, input)) {
                    coveredConf = conf;
                    break;
                }
            }
        }

        // 子步骤2（有效）：返回 [限额场景编码] 原值，并按命中记录原值回显四类控制区间
        if (coveredConf != null) {
            output.setLimitSceneNo(input.getLimitSceneNo());
            output.setLimitCtrlBgnDate(coveredConf.getLimitCtrlBgnDate());
            output.setLimitCtrlEndDate(coveredConf.getLimitCtrlEndDate());
            output.setLimitCtrlBgnTime(coveredConf.getLimitCtrlBgnTime());
            output.setLimitCtrlEndTime(coveredConf.getLimitCtrlEndTime());
        }
        // 子步骤2（无效）：查无记录或全部未覆盖时 limitSceneNo 保持空值，不作为业务失败

        output.setSucceed(true);
        return output;
    }

    /**
     * 判定单条配置记录是否覆盖本次交易：日期侧（REQ-004）与时间侧（REQ-005）同时满足才覆盖（REQ-006）。
     *
     * @param conf  候选配置记录
     * @param input 步骤输入
     * @return true-该记录覆盖本次交易
     */
    private static boolean isCovered(RbLimitCtrlConfEO conf, ST109InputBO input) {
        return isDateSatisfied(conf, input.getTranDate())
                && isTimeSatisfied(conf, input.getTranTimestamp());
    }

    /**
     * 日期侧判定：{交易日期} 不早于 [限额控制开始日期] 且不晚于 [限额控制结束日期]（含起止日期）；
     * 未设置的一端不构成限制，两端均未设置视为满足。
     *
     * @param conf     候选配置记录
     * @param tranDate 交易日期
     * @return true-日期侧满足
     */
    private static boolean isDateSatisfied(RbLimitCtrlConfEO conf, Date tranDate) {
        Date bgnDate = conf.getLimitCtrlBgnDate();
        if (bgnDate != null && toCalendarDay(tranDate).before(toCalendarDay(bgnDate))) {
            return false;
        }
        Date endDate = conf.getLimitCtrlEndDate();
        if (endDate != null && toCalendarDay(tranDate).after(toCalendarDay(endDate))) {
            return false;
        }
        return true;
    }

    /**
     * 时间侧判定：{交易时间} 不早于 [限额控制开始时间] 且不晚于 [限额控制结束时间]（含起止时刻）；
     * 未设置的一端不构成限制，两端均未设置视为满足。
     *
     * @param conf          候选配置记录
     * @param tranTimestamp 交易时间戳
     * @return true-时间侧满足
     */
    private static boolean isTimeSatisfied(RbLimitCtrlConfEO conf, String tranTimestamp) {
        Integer tranTimeOfDay = parseTimeOfDay(tranTimestamp);
        if (tranTimeOfDay == null) {
            // 交易时间无法按已确认的取值形式解释，不能认定落在区间内
            return false;
        }
        Date bgnTime = conf.getLimitCtrlBgnTime();
        if (bgnTime != null && tranTimeOfDay.intValue() < timeOfDay(bgnTime)) {
            return false;
        }
        Date endTime = conf.getLimitCtrlEndTime();
        if (endTime != null && tranTimeOfDay.intValue() > timeOfDay(endTime)) {
            return false;
        }
        return true;
    }

    /**
     * 归一化到日历日（当日 00:00:00.000），用于日期侧按「日」比较。
     *
     * @param date 待归一化的日期
     * @return 该日期所在日历日的零点时刻
     */
    private static Date toCalendarDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 解析交易时间戳，取其时刻（当日 0 时起的秒数），用于时间侧按「时刻」比较。
     *
     * @param tranTimestamp 交易时间戳
     * @return 时刻秒数；无法按确认形式解析时为 null
     */
    private static Integer parseTimeOfDay(String tranTimestamp) {
        if (tranTimestamp == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(TRAN_TIMESTAMP_PATTERN);
        format.setLenient(false);
        try {
            return Integer.valueOf(timeOfDay(format.parse(tranTimestamp)));
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 取日期对象的时刻（当日 0 时起的秒数，忽略毫秒）。
     *
     * @param date 日期对象
     * @return 时刻秒数
     */
    private static int timeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY) * SECONDS_PER_HOUR
                + calendar.get(Calendar.MINUTE) * SECONDS_PER_MINUTE
                + calendar.get(Calendar.SECOND);
    }
}
