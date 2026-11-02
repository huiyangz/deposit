package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.lenient;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST040InputBO;
import com.dcits.deposit.facade.bo.ST040OutputBO;
import com.dcits.deposit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.deposit.facade.eo.RbLimitCtrlConfEO;

/**
 * ST040 检查限额 单元测试。
 */
@ExtendWith(MockitoExtension.class)
class ST040PbcTest {

    @Mock
    private IRbLimitCtrlConfBcc limitCtrlConfBcc;

    @InjectMocks
    private ST040Pbc step;

    /** 限额控制配置命中记录：limitSceneNo=S001，限额控制金额 800.00，限额控制笔数 5 */
    private RbLimitCtrlConfEO conf;

    @BeforeEach
    void setUp() {
        conf = new RbLimitCtrlConfEO();
        conf.setLimitSceneNo("S001");
        conf.setLimitCtrlAmt(new BigDecimal("800.00"));
        conf.setLimitCtrlNum(Integer.valueOf(5));
    }

    /** 公共桩：findByEo 命中 limitSceneNo=S001 的记录，返回 800.00/5 */
    private void stubFindByEoHit() {
        lenient().when(limitCtrlConfBcc.findByEo(argThat(query -> "S001".equals(query.getLimitSceneNo()))))
                .thenReturn(Collections.singletonList(conf));
    }

    /** 构造步骤输入：限额场景编码、限额累计金额、限额累计笔数 */
    private ST040InputBO buildInput(String limitSceneNo, String limitSumAmt, int limitSumNum) {
        ST040InputBO input = new ST040InputBO();
        input.setLimitSceneNo(limitSceneNo);
        input.setLimitSumAmt(new BigDecimal(limitSumAmt));
        input.setLimitSumNum(Integer.valueOf(limitSumNum));
        return input;
    }

    // REQ-001-S01 接收必填输入并输出声明字段（ST040-TC001）：输出四类字段，累计值按输入承接
    @Test
    void testST040T01() {
        stubFindByEoHit();
        ST040InputBO input = buildInput("S001", "1000.00", 10);

        ST040OutputBO result = step.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(0, result.getLimitCtrlAmt().compareTo(new BigDecimal("800.00")));
        assertEquals(Integer.valueOf(5), result.getLimitCtrlNum());
        assertEquals(0, result.getLimitSumAmt().compareTo(new BigDecimal("1000.00")));
        assertEquals(Integer.valueOf(10), result.getLimitSumNum());
    }

    // REQ-002-S01 命中限额控制配置取得控制值（ST040-TC002）：限额控制值来源为查询命中记录
    @Test
    void testST040T02() {
        stubFindByEoHit();
        ST040InputBO input = buildInput("S001", "1000.00", 10);

        ST040OutputBO result = step.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(0, result.getLimitCtrlAmt().compareTo(new BigDecimal("800.00")));
        assertEquals(Integer.valueOf(5), result.getLimitCtrlNum());
    }

    // REQ-003-S01 限额累计金额超限返回超限（ST040-TC003）：金额 1000.00>800.00 成立、笔数 5 不大于 5，返回「超限」
    @Test
    void testST040T03() {
        stubFindByEoHit();
        ST040InputBO input = buildInput("S001", "1000.00", 5);

        ST040OutputBO result = step.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(0, result.getLimitCtrlAmt().compareTo(new BigDecimal("800.00")));
        assertEquals(Integer.valueOf(5), result.getLimitCtrlNum());
        assertEquals(0, result.getLimitSumAmt().compareTo(new BigDecimal("1000.00")));
        assertEquals(Integer.valueOf(5), result.getLimitSumNum());
        assertEquals("超限", result.getLimitCheckResult());
    }

    // REQ-003-S02 限额累计笔数超限返回超限（ST040-TC004）：笔数 10>5 成立、金额 500.00 不大于 800.00，返回「超限」
    @Test
    void testST040T04() {
        stubFindByEoHit();
        ST040InputBO input = buildInput("S001", "500.00", 10);

        ST040OutputBO result = step.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(0, result.getLimitCtrlAmt().compareTo(new BigDecimal("800.00")));
        assertEquals(Integer.valueOf(5), result.getLimitCtrlNum());
        assertEquals(0, result.getLimitSumAmt().compareTo(new BigDecimal("500.00")));
        assertEquals(Integer.valueOf(10), result.getLimitSumNum());
        assertEquals("超限", result.getLimitCheckResult());
    }

    // REQ-003-S03 金额与笔数均超限返回超限（ST040-TC005）：1000.00>800.00 且 10>5，返回「超限」
    @Test
    void testST040T05() {
        stubFindByEoHit();
        ST040InputBO input = buildInput("S001", "1000.00", 10);

        ST040OutputBO result = step.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(0, result.getLimitCtrlAmt().compareTo(new BigDecimal("800.00")));
        assertEquals(Integer.valueOf(5), result.getLimitCtrlNum());
        assertEquals(0, result.getLimitSumAmt().compareTo(new BigDecimal("1000.00")));
        assertEquals(Integer.valueOf(10), result.getLimitSumNum());
        assertEquals("超限", result.getLimitCheckResult());
    }

    // REQ-003-S04 均未超限返回未超限（ST040-TC006）：500.00 不大于 800.00 且 5 不大于 5，返回「未超限」
    @Test
    void testST040T06() {
        stubFindByEoHit();
        ST040InputBO input = buildInput("S001", "500.00", 5);

        ST040OutputBO result = step.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(0, result.getLimitCtrlAmt().compareTo(new BigDecimal("800.00")));
        assertEquals(Integer.valueOf(5), result.getLimitCtrlNum());
        assertEquals(0, result.getLimitSumAmt().compareTo(new BigDecimal("500.00")));
        assertEquals(Integer.valueOf(5), result.getLimitSumNum());
        assertEquals("未超限", result.getLimitCheckResult());
    }

    // REQ-003-S05 相等边界返回未超限（ST040-TC007）：800.00 等于控制金额、5 等于控制笔数，严格「大于」不成立，返回「未超限」
    @Test
    void testST040T07() {
        stubFindByEoHit();
        ST040InputBO input = buildInput("S001", "800.00", 5);

        ST040OutputBO result = step.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(0, result.getLimitCtrlAmt().compareTo(new BigDecimal("800.00")));
        assertEquals(Integer.valueOf(5), result.getLimitCtrlNum());
        assertEquals(0, result.getLimitSumAmt().compareTo(new BigDecimal("800.00")));
        assertEquals(Integer.valueOf(5), result.getLimitSumNum());
        assertEquals("未超限", result.getLimitCheckResult());
    }
}
