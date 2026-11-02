package com.dcits.deposit.step;

import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.facade.bo.ST044InputBO;
import com.dcits.deposit.facade.bo.ST044OutputBO;
import com.dcits.deposit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.deposit.facade.components.IRbLimitSumInfoBcc;
import com.dcits.deposit.facade.eo.RbLimitCtrlConfEO;
import com.dcits.deposit.facade.eo.RbLimitSumInfoEO;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ST044 登记累计限额 交易执行步骤实现。
 *
 * <p>依据限额检查结果与累计状态判定是否登记限额累计信息（REQ-001）：当[限额检查结果]
 * 为"未超限"且（[限额累计金额]等于 0 或 [限额累计笔数]等于 0）时，向限额累计信息表
 * （RB_LIMIT_SUM_INFO）登记一条限额累计记录；条件不满足时不登记、不产生输出、正常结束。</p>
 */
@Service
public class ST044Pbc implements IST044 {

    /** 限额累计信息数据服务接口，用于登记限额累计记录（REQ-001 登记写入） */
    private final IRbLimitSumInfoBcc limitSumInfoBcc;

    /** 限额控制配置数据服务接口，用于按限额场景编码定位周期类型与周期值（REQ-004） */
    private final IRbLimitCtrlConfBcc limitCtrlConfBcc;

    public ST044Pbc(IRbLimitSumInfoBcc limitSumInfoBcc, IRbLimitCtrlConfBcc limitCtrlConfBcc) {
        this.limitSumInfoBcc = limitSumInfoBcc;
        this.limitCtrlConfBcc = limitCtrlConfBcc;
    }

    @Override
    @Transactional
    public ST044OutputBO execute(ST044InputBO input) {
        ST044OutputBO output = new ST044OutputBO();

        // 触发条件判定（REQ-001）：限额检查结果为"未超限" 且（限额累计金额等于 0 或 限额累计笔数等于 0）
        // 限额检查结果完整取值域与物理编码见待确认事项 3；非"未超限"一律不登记（REQ-001-S05）
        boolean checkPassed = "未超限".equals(input.get限额检查结果());
        boolean zeroSumAmt = input.getLimitSumAmt() != null
                && input.getLimitSumAmt().compareTo(BigDecimal.ZERO) == 0;
        boolean zeroSumCount = Integer.valueOf(0).equals(input.get否());
        if (!checkPassed || (!zeroSumAmt && !zeroSumCount)) {
            // 不登记路径（REQ-001-S04/S05）：不登记、不产生输出、正常提前结束（REQ-006-S02）
            output.setSucceed(true);
            return output;
        }

        // 登记路径（REQ-001-S01/S02/S03）：向限额累计信息表登记一条限额累计记录
        RbLimitSumInfoEO eo = new RbLimitSumInfoEO();
        // 登记字段（REQ-002）：limitSceneNo 等于输入 limitSceneNo，limitSumAmt 等于交易金额，笔数固定为 1
        eo.setLimitSceneNo(input.getLimitSceneNo());
        eo.setLimitSumAmt(input.getTranAmt());
        eo.set否(Integer.valueOf(1));
        // 生效日期等于系统日期（REQ-004-S01/S02）
        eo.setEffectDate(input.getRunDate());
        eo.setExpireDate(resolveExpireDate(input.getRunDate(), input.getLimitSceneNo()));

        // 限额检查对象值（REQ-003）：按配置的检查对象类型取账号或客户号
        // FIXME 业务项:ST044 登记累计限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:{限额检查对象值按配置的检查对象类型取值，但检查对象类型配置的来源与定位方式未定义：工程限额场景定义表（RB_LIMIT_SCENE_DEF）含 CHECK_OBJ_TYPE 列但当前无 LIMIT_SCENE_NO 列、数据服务接口主键亦不含限额场景编码，无法按输入 limitSceneNo 定位单条配置；需求"限额场景码"与"限额场景编码"是否同一值亦待确认} - 影响:{登记时 checkObjVal 无法确定（ACCT 取账号 baseAcctNo / CUST 取客户号 clientNo），本次实现不产生该值} - 待确认:{检查对象类型配置的实际来源表/字段、按限额场景编码定位的查询条件（含启用标志校验），或改由调用方在步骤输入中直接提供检查对象类型}

        // 其它字段（REQ-005）：按系统规则自动生成，具体规则未定义；EO 中 clientNo、createTimestamp、reference、lastUpdTimestamp 为非空
        // FIXME 业务项:ST044 登记累计限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:{"其它字段"（限额累计描述 limitSumContent、客户号 clientNo、创建时间戳 createTimestamp、原交易参考号 preReference、交易币种 tranCcy、交易参考号 reference、最后修改时间戳 lastUpdTimestamp）按系统规则自动生成的规则未定义；EO 中 clientNo、createTimestamp、reference、lastUpdTimestamp 为非空（@NotNull / 表列 NOT NULL）} - 影响:{本次仅按候选取输入 clientNo 赋值，其余其它字段不赋值，登记记录在真实落库时会违反非空约束} - 待确认:{各其它字段的生成规则（取值来源、时间戳格式等），及客户号字段是直接取输入 clientNo 值还是另有规则}
        eo.setClientNo(input.getClientNo());

        // 登记写入（REQ-002/REQ-005）：写入方法选择与主键重复处理未定义
        // FIXME 业务项:ST044 登记累计限额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:{登记写入方法选择（create / createSelective）与登记前主键（checkObjVal, limitSceneNo）重复的校验及处理需求未定义} - 影响:{本次按用例桩采用 create 写入，主键重复时行为未确定} - 待确认:{写入方法选择及登记前主键重复的校验与处理规则}
        limitSumInfoBcc.create(eo);

        // 输出按写入的登记记录回填（REQ-002~REQ-004）；checkObjVal 依赖检查对象类型配置（见上方 FIXME）
        output.setLimitSceneNo(eo.getLimitSceneNo());
        output.setCheckObjVal(eo.getCheckObjVal());
        output.setLimitSumAmt(eo.getLimitSumAmt());
        output.set否(eo.get否());
        output.setEffectDate(eo.getEffectDate());
        output.setExpireDate(eo.getExpireDate());

        // 成功结束（REQ-006-S01）
        output.setSucceed(true);
        return output;
    }

    /**
     * 计算失效日期（REQ-004）：系统日期加限额场景编码对应配置的周期类型与周期值所对应的时长。
     * 周期配置按限额场景编码定位，多条取结果集第一条，先判空再取值。
     */
    private Date resolveExpireDate(Date runDate, String limitSceneNo) {
        RbLimitCtrlConfEO query = new RbLimitCtrlConfEO();
        query.setLimitSceneNo(limitSceneNo);
        List<RbLimitCtrlConfEO> configs = limitCtrlConfBcc.findByEo(query);
        // FIXME 业务项:ST044 登记累计限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:{周期类型/周期值按限额场景编码配置定位，但限额控制配置表（RB_LIMIT_CTRL_CONF）主键含限额机构编码（LIMIT_BRANCH_ID）且未列入本步骤输入，同一场景多条配置取舍与启用标志校验未定义} - 影响:{按 limitSceneNo 查询配置并取首条为候选实现，配置定位方式确认前失效日期取值可能与实际不符} - 待确认:{按限额场景编码取周期配置的定位条件（是否需要机构编码、同一场景多条如何取舍、是否校验启用标志）}
        if (configs == null || configs.isEmpty()) {
            return null;
        }
        RbLimitCtrlConfEO conf = configs.get(0);
        TermType periodType = conf.getPeriodType();
        String periodValue = conf.getPeriodValue();
        if (periodType == null || periodValue == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(runDate);
        int value = Integer.parseInt(periodValue);
        switch (periodType) {
            case D:
                calendar.add(Calendar.DAY_OF_MONTH, value);
                break;
            case M:
                calendar.add(Calendar.MONTH, value);
                break;
            // FIXME 业务项:ST044 登记累计限额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:{周期类型 周/季/半年/年（W/Q/H/Y）对应的日历递增口径与跨月末/年末边界舍入规则未定义} - 影响:{周期配置为 W/Q/H/Y 时失效日期计算结果无法唯一确定，本次返回空} - 待确认:{W/Q/H/Y 对应日历递增口径及日历边界舍入规则；已确认 D/M 按 REQ-004-S01/S02 实现}
            default:
                return null;
        }
        return calendar.getTime();
    }
}
