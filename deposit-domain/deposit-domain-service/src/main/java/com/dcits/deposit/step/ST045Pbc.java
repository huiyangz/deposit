package com.dcits.deposit.step;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST045InputBO;
import com.dcits.deposit.facade.bo.ST045OutputBO;
import com.dcits.deposit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.deposit.facade.eo.RbLimitCtrlConfEO;

/**
 * ST045 检查限额场景配置是否有效。
 *
 * <p>子步骤 1（REQ-001）：按输入限额场景编码查询【限额控制配置】（RB_LIMIT_CTRL_CONF），
 * 输出限额控制开始/结束日期与开始/结束时间四个控制区间字段。</p>
 *
 * <p>子步骤 2（REQ-002）：判定交易日期与交易时间相对控制区间的位置，交易落在控制区间内时
 * 输出限额场景编码非空，否则为空。区间判定组合口径、边界包含语义、交易时间戳格式与比较口径、
 * 必填输入缺失行为及输出空值物理表示为 Spec 待确认事项，本实现按既有场景结论一致的处理落实，
 * 见各 FIXME。</p>
 *
 * <p>本步骤无已声明业务失败场景（Spec「输入、输出及依赖契约」），正常结果统一 {@code succeed=true}。
 * 查询无记录/多条记录的取用按项目数据访问约定处理（无记录按空结果、多条取结果集第一条）。</p>
 */
@Service
public class ST045Pbc implements IST045 {

    private final IRbLimitCtrlConfBcc limitCtrlConfBcc;

    public ST045Pbc(IRbLimitCtrlConfBcc limitCtrlConfBcc) {
        this.limitCtrlConfBcc = limitCtrlConfBcc;
    }

    @Override
    public ST045OutputBO execute(ST045InputBO input) {
        ST045OutputBO outputBO = new ST045OutputBO();
        // FIXME 业务项:ST045/检查限额场景配置是否有效 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:输入 tranDate、tranTimestamp、limitSceneNo 标记必填，缺失或无效值时的行为需求未定义（Spec 待确认事项 6） - 影响:当前实现不做必填校验，缺失输入沿后续取值路径产生 null 引用或时间格式解析异常，属未定义行为 - 待确认:必填输入缺失/无效时步骤应正常结束、返回业务失败还是技术异常
        // 子步骤 1（REQ-001）：按输入限额场景编码查询限额控制配置
        RbLimitCtrlConfEO queryEo = new RbLimitCtrlConfEO();
        queryEo.setLimitSceneNo(input.getLimitSceneNo());
        List<RbLimitCtrlConfEO> confList = limitCtrlConfBcc.findByEo(queryEo);
        if (confList == null || confList.isEmpty()) {
            // 查询无记录：四个控制区间字段与 limitSceneNo 保持为空，正常结束（项目数据访问约定：无记录按空结果处理，不视为业务失败）
            outputBO.setSucceed(true);
            return outputBO;
        }
        // 同一限额场景编码可能命中多条记录，按项目数据访问约定取结果集第一条
        RbLimitCtrlConfEO record = confList.get(0);
        outputBO.setLimitCtrlBgnDate(record.getLimitCtrlBgnDate());
        outputBO.setLimitCtrlEndDate(record.getLimitCtrlEndDate());
        outputBO.setLimitCtrlBgnTime(record.getLimitCtrlBgnTime());
        outputBO.setLimitCtrlEndTime(record.getLimitCtrlEndTime());

        // 子步骤 2（REQ-002）：判定交易日期与交易时间相对控制区间的位置
        boolean withinDate = !input.getTranDate().before(record.getLimitCtrlBgnDate())
                && !input.getTranDate().after(record.getLimitCtrlEndDate());
        Date tranTime = parseTranTime(input.getTranTimestamp());
        boolean withinTime = !tranTime.before(record.getLimitCtrlBgnTime())
                && !tranTime.after(record.getLimitCtrlEndTime());
        // FIXME 业务项:ST045/检查限额场景配置是否有效 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:交易日期与交易时间相对控制区间的判定组合口径未确认，「{交易日期}或者{交易时间}在...范围内」存在同时满足/任一满足/合并交易时刻整体判定三种解释（Spec 待确认事项 1） - 影响:仅日期在区间内或仅时间在区间内的混合组合，当前实现按「日期与时间同时落在各自区间」判定为区间外，若按「任一满足」解释结论相反 - 待确认:区间判定应同时满足还是任一满足，以及交易日期/交易时间各自的比较边界
        // FIXME 业务项:ST045/检查限额场景配置是否有效 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:区间边界包含语义未确认，「在...范围内」是否包含开始/结束边界值需求未声明（Spec 待确认事项 2） - 影响:交易日期/时间等于开始或结束边界值时，当前实现按边界包含（视为区间内）处理，若确认边界不包含则结论相反 - 待确认:等于开始日期/时间、等于结束日期/时间时视为区间内还是区间外
        if (withinDate && withinTime) {
            // 交易落在控制区间内：输出限额场景编码（与查询条件一致，来源于限额控制配置记录）
            outputBO.setLimitSceneNo(record.getLimitSceneNo());
        }
        // FIXME 业务项:ST045/检查限额场景配置是否有效 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:区间外「返回限额场景编码为空」的物理表示（null 还是空字符串）需求未定义（Spec 待确认事项 7） - 影响:当前实现不设置 limitSceneNo 字段，物理表示为 null，若确认应为空字符串则输出表示需调整 - 待确认:区间外 limitSceneNo 输出的物理表示应为 null 还是空字符串
        outputBO.setSucceed(true);
        return outputBO;
    }

    /**
     * 将交易时间戳解析为时间，用于与限额控制开始/结束时间比较。
     */
    private Date parseTranTime(String tranTimestamp) {
        // FIXME 业务项:ST045/检查限额场景配置是否有效 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:交易时间戳 tranTimestamp 的格式（HH:mm:ss、HH:mm 或含日期时间）及与时间类型边界（java.util.Date）的比较口径未确认（Spec 待确认事项 3） - 影响:当前按用例示例格式 HH:mm:ss 解析为当日时间与时间边界比较，若格式或比较口径（当日时间比较/完整时间戳比较）不同则判定结果可能改变 - 待确认:交易时间戳的格式与解析规则、与限额控制开始/结束时间的比较口径
        try {
            return new SimpleDateFormat("HH:mm:ss").parse(tranTimestamp);
        } catch (ParseException e) {
            // 交易时间戳格式无效：业务未定义该行为（见 execute 中必填/无效输入 FIXME），按技术异常向上传播
            throw new IllegalArgumentException("交易时间戳格式无效: " + tranTimestamp, e);
        }
    }
}
