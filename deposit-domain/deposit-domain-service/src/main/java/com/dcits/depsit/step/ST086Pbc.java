package com.dcits.depsit.step;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.dcits.depsit.facade.bo.ST086InputBO;
import com.dcits.depsit.facade.bo.ST086OutputBO;

/**
 * ST086 设置账户开户日期 步骤实现。
 *
 * <p>按源需求「## 步骤描述」的两步依次执行，单次调用中各执行恰好一次，无分支、无循环、无重试：
 * <ol>
 * <li>获取系统日期：赋值 [系统日期] 为当前系统日期；该值取自入参 {@code runDate}
 * （核心运行日期，即核心系统当前所处的营业日期），不读取执行时刻的机器日历日，也不查询系统日期表。</li>
 * <li>设置账户开户日期：赋值 [账户开户日期] 等于 [系统日期]，并作为输出字段 {@code acctOpenDate} 返回；
 * 原值传递，不做日期归一化、截断、时区转换或格式化。</li>
 * </ol>
 *
 * <p>本步骤为无状态赋值，不查询任何实体、不发起外部调用、不产生任何写入，因此不声明事务。
 * 源需求「## 失败处理」明确本步骤无业务失败场景，故不设置业务错误码与业务失败分支；
 * 技术异常按工程既有方式向上传播，不吞掉也不转换为兜底取值。源需求未定义 {@code runDate}
 * 为空（null）时的行为，本实现不为其制造分支。
 */
@Service
public class ST086Pbc implements IST086 {

    @Override
    public ST086OutputBO execute(ST086InputBO input) {
        ST086OutputBO output = new ST086OutputBO();

        // 步骤 1 获取系统日期（REQ-002）：赋值 [系统日期] 为当前系统日期，取值来源唯一确定为入参 runDate
        Date systemDate = input.getRunDate();

        // 步骤 2 设置账户开户日期（REQ-003）：赋值并返回 [账户开户日期] 等于步骤 1 的 [系统日期]，原值传递
        output.setAcctOpenDate(systemDate);

        // REQ-005：正常完成，步骤结果为成功状态，错误码与错误信息保持为 null
        output.setSucceed(true);
        return output;
    }
}
