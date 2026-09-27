package com.dcits.deposit.step;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST044InputBO;
import com.dcits.deposit.facade.bo.ST044OutputBO;

/**
 * ST044 设置账户开户日期
 */
@Service
public class ST044Pbc implements IST044 {

    @Override
    public ST044OutputBO execute(ST044InputBO input) {
        ST044OutputBO output = new ST044OutputBO();

        // 子步骤1 获取系统日期：赋值[系统日期]为输入{runDate}（当前核心运行日期，来源于系统日期表FM_DATE）
        Date sysDate = input.getRunDate();

        // 子步骤2 设置账户开户日期：赋值并返回[账户开户日期]等于[系统日期]
        output.setAcctOpenDate(sysDate);

        // 本步骤无业务失败场景，正常完成时错误字段保持null
        output.setSucceed(true);
        return output;
    }
}
