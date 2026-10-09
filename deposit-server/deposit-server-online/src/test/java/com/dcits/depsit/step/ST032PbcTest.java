package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.depsit.facade.bo.ST032InputBO;
import com.dcits.depsit.facade.bo.ST032OutputBO;

/**
 * ST032 检查交易金额的单元测试。
 *
 * <p>调用签名：{@code ST032OutputBO execute(ST032InputBO input)}。
 * 本步骤无 BCC、EO、规则、枚举与跨组件客户端依赖，全部用例由真实步骤实例执行，不设任何桩。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST032PbcTest {

    @InjectMocks
    private ST032Pbc st032Pbc;

    // ST032-TC001：REQ-001-S01 交易金额恰为 0，命中「小于等于」的等于边界，返回 ER0050
    @Test
    void testST032T01() {
        ST032InputBO input = new ST032InputBO();
        input.setTranAmt(new BigDecimal("0"));

        ST032OutputBO output = st032Pbc.execute(input);

        assertFalse(output.isSucceed());
        assertEquals("ER0050", output.getErrorCode());
    }

    // ST032-TC002：REQ-001-S02 交易金额为紧邻分界的小负值 -0.01，返回 ER0050
    @Test
    void testST032T02() {
        ST032InputBO input = new ST032InputBO();
        input.setTranAmt(new BigDecimal("-0.01"));

        ST032OutputBO output = st032Pbc.execute(input);

        assertFalse(output.isSucceed());
        assertEquals("ER0050", output.getErrorCode());
    }

    // ST032-TC003：REQ-001-S03 交易金额为较大负值 -1000000.00，负值绝对金额大小不改变判定，仍返回 ER0050
    @Test
    void testST032T03() {
        ST032InputBO input = new ST032InputBO();
        input.setTranAmt(new BigDecimal("-1000000.00"));

        ST032OutputBO output = st032Pbc.execute(input);

        assertFalse(output.isSucceed());
        assertEquals("ER0050", output.getErrorCode());
    }

    // ST032-TC004：REQ-002-S01 交易金额为大于 0 的最小边界值 0.01，检查通过且不产出 ER0050
    @Test
    void testST032T04() {
        ST032InputBO input = new ST032InputBO();
        input.setTranAmt(new BigDecimal("0.01"));

        ST032OutputBO output = st032Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST032-TC005：REQ-002-S02 交易金额为典型正值 100.00，检查通过
    @Test
    void testST032T05() {
        ST032InputBO input = new ST032InputBO();
        input.setTranAmt(new BigDecimal("100.00"));

        ST032OutputBO output = st032Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
    }

    // ST032-TC006：REQ-003-S01 交易金额为 0.00（数值等于 0、标度为 2），判定与取值为 0 时一致，返回 ER0050；
    // 该断言同时证明判定为数值比较而非 BigDecimal.equals 语义（equals 语义下 0.00 会落入大于 0 分支）
    @Test
    void testST032T06() {
        ST032InputBO input = new ST032InputBO();
        input.setTranAmt(new BigDecimal("0.00"));

        ST032OutputBO output = st032Pbc.execute(input);

        assertFalse(output.isSucceed());
        assertEquals("ER0050", output.getErrorCode());
    }

    // ST032-TC007：REQ-003-S02 交易金额为带尾随零的 1.0 与等值整数 1，两次判定一致，均为检查通过
    @Test
    void testST032T07() {
        ST032InputBO inputA = new ST032InputBO();
        inputA.setTranAmt(new BigDecimal("1.0"));
        ST032InputBO inputB = new ST032InputBO();
        inputB.setTranAmt(new BigDecimal("1"));

        ST032OutputBO outputA = st032Pbc.execute(inputA);
        ST032OutputBO outputB = st032Pbc.execute(inputB);

        assertTrue(outputA.isSucceed());
        assertNull(outputA.getErrorCode());
        assertTrue(outputB.isSucceed());
        assertNull(outputB.getErrorCode());
    }

    // ST032-TC008：REQ-003-S03 交易金额为 0.0001（标度为 4），判定不做舍入或精度规整，检查通过，
    // 且入参在步骤执行前后数值与标度保持不变
    @Test
    void testST032T08() {
        ST032InputBO input = new ST032InputBO();
        input.setTranAmt(new BigDecimal("0.0001"));

        ST032OutputBO output = st032Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals(0, input.getTranAmt().compareTo(new BigDecimal("0.0001")));
        assertEquals(4, input.getTranAmt().scale());
    }
}
