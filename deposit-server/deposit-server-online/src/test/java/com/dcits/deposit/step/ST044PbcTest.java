package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.facade.bo.ST044InputBO;
import com.dcits.deposit.facade.bo.ST044OutputBO;

/**
 * ST044 设置账户开户日期 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST044-TC001 ~ ST044-TC002）
 */
public class ST044PbcTest {

    // 正常路径：以常规核心运行日期 2026-09-24 作为输入 runDate，完整执行子步骤1（赋值[系统日期]=输入{runDate}）与子步骤2（赋值并返回[账户开户日期]=[系统日期]），预期 succeed=true、acctOpenDate 精确等于该日期、错误字段为 null
    @Test
    public void testST044T01() throws Exception {
        ST044InputBO input = new ST044InputBO();
        input.setRunDate(new SimpleDateFormat("yyyy-MM-dd").parse("2026-09-24"));

        ST044OutputBO output = new ST044Pbc().execute(input);

        assertNotNull(output);
        assertTrue(output.isSucceed());
        assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2026-09-24"), output.getAcctOpenDate());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // 正常路径：以历史核心运行日期 2000-01-01 作为输入 runDate，执行同一唯一路径，验证输出开户日期严格跟随输入日期而非当前系统时钟
    @Test
    public void testST044T02() throws Exception {
        ST044InputBO input = new ST044InputBO();
        input.setRunDate(new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01"));

        ST044OutputBO output = new ST044Pbc().execute(input);

        assertNotNull(output);
        assertTrue(output.isSucceed());
        assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01"), output.getAcctOpenDate());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }
}
