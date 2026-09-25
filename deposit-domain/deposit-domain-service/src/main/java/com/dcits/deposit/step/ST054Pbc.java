package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST054InputBO;
import com.dcits.deposit.facade.bo.ST054OutputBO;

/**
 * ST054 设置账户执行利率 步骤实现。
 *
 * <p>来源：《ST054 设置账户执行利率》门禁通过版 SPEC。</p>
 */
@Service
public class ST054Pbc implements IST054 {

    /**
     * 设置账户执行利率。
     *
     * <p>子步骤 1“设置账户执行利率”：赋值账户$执行利率$为[执行利率]，
     * 即将输入 realRate 原样赋给输出 realRate。唯一正常出口。</p>
     *
     * @param input 输入BO（realRate 必填）
     * @return 输出BO，succeed=true，realRate 与输入一致
     */
    @Override
    public ST054OutputBO execute(ST054InputBO input) {
        // 子步骤 1 设置账户执行利率：赋值账户$执行利率$为[执行利率]
        ST054OutputBO output = new ST054OutputBO();
        output.setRealRate(input.getRealRate());
        output.setSucceed(true);
        return output;
    }
}
