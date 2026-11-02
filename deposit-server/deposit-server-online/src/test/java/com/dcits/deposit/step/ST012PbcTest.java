package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST012InputBO;
import com.dcits.deposit.facade.bo.ST012OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBalanceBcc;
import com.dcits.deposit.facade.eo.RbBusAcctBalanceEO;

/**
 * ST012 检查账户余额 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001~REQ-004 已确认场景（测试用例 ST012-TC001~TC006）。
 * 账号定位映射、查询无记录、多条记录、空输入等未决行为无已确认预期，不作为
 * 本套用例断言，见实现中 FIXME。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST012PbcTest {

    @Mock
    private IRbBusAcctBalanceBcc balanceBcc;

    @InjectMocks
    private ST012Pbc pbc;

    // 场景：ST012-TC001（REQ-001-S01）正常流程返回完整输出，可用余额 1150.00 不小于交易金额 1000.00，跳转《检查现金支取账户限制》
    @Test
    void testST012T01() {
        when(balanceBcc.findByEo(any(RbBusAcctBalanceEO.class))).thenReturn(List.of(buildRecord()));

        ST012OutputBO out = pbc.execute(buildInput("1000.00"));

        assertEquals(true, out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals(new BigDecimal("1000.00"), out.getTotalAmount());
        assertEquals(new BigDecimal("100.00"), out.getPldAmount());
        assertEquals(new BigDecimal("50.00"), out.getFinregAmount());
        assertEquals(new BigDecimal("200.00"), out.getOdAmount());
        assertEquals(new BigDecimal("1150.00"), out.getAcctAvailBal());
        assertEquals("《检查现金支取账户限制》", out.getGotoStepName());
    }

    // 场景：ST012-TC002（REQ-002-S01）账号对应余额记录存在时取得四项金额，作为账户可用余额计算输入
    @Test
    void testST012T02() {
        when(balanceBcc.findByEo(any(RbBusAcctBalanceEO.class))).thenReturn(List.of(buildRecord()));

        ST012OutputBO out = pbc.execute(buildInput("1000.00"));

        assertEquals(true, out.isSucceed());
        assertEquals(new BigDecimal("1000.00"), out.getTotalAmount());
        assertEquals(new BigDecimal("100.00"), out.getPldAmount());
        assertEquals(new BigDecimal("50.00"), out.getFinregAmount());
        assertEquals(new BigDecimal("200.00"), out.getOdAmount());
    }

    // 场景：ST012-TC003（REQ-003-S01）按公式计算账户可用余额：1000.00-100.00+50.00+200.00=1150.00
    @Test
    void testST012T03() {
        when(balanceBcc.findByEo(any(RbBusAcctBalanceEO.class))).thenReturn(List.of(buildRecord()));

        ST012OutputBO out = pbc.execute(buildInput("1000.00"));

        assertEquals(new BigDecimal("1150.00"), out.getAcctAvailBal());
        assertEquals(true, out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
    }

    // 场景：ST012-TC004（REQ-004-S01）可用余额 1150.00 小于交易金额 1200.00，跳转《检查法透标志》，步骤结果保持成功
    @Test
    void testST012T04() {
        when(balanceBcc.findByEo(any(RbBusAcctBalanceEO.class))).thenReturn(List.of(buildRecord()));

        ST012OutputBO out = pbc.execute(buildInput("1200.00"));

        assertEquals("《检查法透标志》", out.getGotoStepName());
        assertEquals(true, out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
    }

    // 场景：ST012-TC005（REQ-004-S02 边界）可用余额 1150.00 等于交易金额 1150.00（不小于，含相等），跳转《检查现金支取账户限制》
    @Test
    void testST012T05() {
        when(balanceBcc.findByEo(any(RbBusAcctBalanceEO.class))).thenReturn(List.of(buildRecord()));

        ST012OutputBO out = pbc.execute(buildInput("1150.00"));

        assertEquals("《检查现金支取账户限制》", out.getGotoStepName());
        assertEquals(true, out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
    }

    // 场景：ST012-TC006（REQ-004-S03）可用余额 1150.00 大于交易金额 1000.00（不小于），跳转《检查现金支取账户限制》
    @Test
    void testST012T06() {
        when(balanceBcc.findByEo(any(RbBusAcctBalanceEO.class))).thenReturn(List.of(buildRecord()));

        ST012OutputBO out = pbc.execute(buildInput("1000.00"));

        assertEquals("《检查现金支取账户限制》", out.getGotoStepName());
        assertEquals(true, out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
    }

    private RbBusAcctBalanceEO buildRecord() {
        RbBusAcctBalanceEO record = new RbBusAcctBalanceEO();
        record.setInternalKey(10001);
        record.setTotalAmount(new BigDecimal("1000.00"));
        record.setPldAmount(new BigDecimal("100.00"));
        record.setFinregAmount(new BigDecimal("50.00"));
        record.setOdAmount(new BigDecimal("200.00"));
        return record;
    }

    private ST012InputBO buildInput(String tranAmt) {
        ST012InputBO input = new ST012InputBO();
        input.setBaseAcctNo("622200001234");
        input.setTranAmt(new BigDecimal(tranAmt));
        return input;
    }
}
