package com.dcits.deposit.step;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST012InputBO;
import com.dcits.deposit.facade.bo.ST012OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBalanceBcc;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctBalanceEO;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.lenient;

/**
 * ST012 更新存入后账户余额 单元测试
 * 用例来源：outputs/测试用例.md（ST012-TC001～TC004）
 * SPEC 声明本步骤无业务失败场景，故仅设计成功路径与边界用例；桩值角分精度下加法不改变 scale，数值断言使用 equals。
 */
@ExtendWith(MockitoExtension.class)
class ST012PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;
    @Mock
    private IRbBusAcctBalanceBcc rbBusAcctBalanceBcc;

    @InjectMocks
    private ST012Pbc st012Pbc;

    // 场景：正常存入带角分金额，账户可用余额与汇总金额取值不同，验证更新汇总金额与可用余额按记录透传；预期 succeed=true、totalAmount=6000.50、acctAvailBal=4500.00
    @Test
    void testST012T01() {
        RbBusAcctEO acctEO = new RbBusAcctEO();
        acctEO.setBaseAcctNo("2000010000001");
        acctEO.setInternalKey(88001);
        lenient().when(rbBusAcctBcc.findByEo(argThat(e -> "2000010000001".equals(e.getBaseAcctNo()))))
                .thenReturn(Collections.singletonList(acctEO));
        RbBusAcctBalanceEO balanceEO = new RbBusAcctBalanceEO();
        balanceEO.setInternalKey(88001);
        balanceEO.setTotalAmount(new BigDecimal("5000.00"));
        balanceEO.setAcctAvailBal(new BigDecimal("4500.00"));
        lenient().when(rbBusAcctBalanceBcc.findByPrimaryKey(88001)).thenReturn(balanceEO);
        RbBusAcctBalanceEO[] updatedEO = new RbBusAcctBalanceEO[1];
        lenient().doAnswer(invocation -> {
                    updatedEO[0] = invocation.getArgument(0);
                    return 1;
                }).when(rbBusAcctBalanceBcc).modifyByPrimaryKeySelective(org.mockito.ArgumentMatchers.any(RbBusAcctBalanceEO.class));

        ST012InputBO input = new ST012InputBO();
        input.setBaseAcctNo("2000010000001");
        input.setTranAmt(new BigDecimal("1000.50"));

        ST012OutputBO output = st012Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(new BigDecimal("6000.50"), output.getTotalAmount());
        assertEquals(new BigDecimal("4500.00"), output.getAcctAvailBal());
        assertEquals(Integer.valueOf(88001), updatedEO[0].getInternalKey());
        assertEquals(new BigDecimal("6000.50"), updatedEO[0].getTotalAmount());
    }

    // 场景：首笔存入，余额记录原汇总金额为 0.00，存入后汇总金额等于交易金额；预期 succeed=true、totalAmount=500.00、acctAvailBal=0.00
    @Test
    void testST012T02() {
        RbBusAcctEO acctEO = new RbBusAcctEO();
        acctEO.setBaseAcctNo("2000010000002");
        acctEO.setInternalKey(88002);
        lenient().when(rbBusAcctBcc.findByEo(argThat(e -> "2000010000002".equals(e.getBaseAcctNo()))))
                .thenReturn(Collections.singletonList(acctEO));
        RbBusAcctBalanceEO balanceEO = new RbBusAcctBalanceEO();
        balanceEO.setInternalKey(88002);
        balanceEO.setTotalAmount(new BigDecimal("0.00"));
        balanceEO.setAcctAvailBal(new BigDecimal("0.00"));
        lenient().when(rbBusAcctBalanceBcc.findByPrimaryKey(88002)).thenReturn(balanceEO);
        RbBusAcctBalanceEO[] updatedEO = new RbBusAcctBalanceEO[1];
        lenient().doAnswer(invocation -> {
                    updatedEO[0] = invocation.getArgument(0);
                    return 1;
                }).when(rbBusAcctBalanceBcc).modifyByPrimaryKeySelective(org.mockito.ArgumentMatchers.any(RbBusAcctBalanceEO.class));

        ST012InputBO input = new ST012InputBO();
        input.setBaseAcctNo("2000010000002");
        input.setTranAmt(new BigDecimal("500.00"));

        ST012OutputBO output = st012Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(new BigDecimal("500.00"), output.getTotalAmount());
        assertEquals(new BigDecimal("0.00"), output.getAcctAvailBal());
        assertEquals(Integer.valueOf(88002), updatedEO[0].getInternalKey());
        assertEquals(new BigDecimal("500.00"), updatedEO[0].getTotalAmount());
    }

    // 场景：交易金额为零的零值边界，公式仍执行、汇总金额数值不变，属成功路径而非失败；预期 succeed=true、totalAmount=888.88、acctAvailBal=888.88
    @Test
    void testST012T03() {
        RbBusAcctEO acctEO = new RbBusAcctEO();
        acctEO.setBaseAcctNo("2000010000003");
        acctEO.setInternalKey(88003);
        lenient().when(rbBusAcctBcc.findByEo(argThat(e -> "2000010000003".equals(e.getBaseAcctNo()))))
                .thenReturn(Collections.singletonList(acctEO));
        RbBusAcctBalanceEO balanceEO = new RbBusAcctBalanceEO();
        balanceEO.setInternalKey(88003);
        balanceEO.setTotalAmount(new BigDecimal("888.88"));
        balanceEO.setAcctAvailBal(new BigDecimal("888.88"));
        lenient().when(rbBusAcctBalanceBcc.findByPrimaryKey(88003)).thenReturn(balanceEO);
        RbBusAcctBalanceEO[] updatedEO = new RbBusAcctBalanceEO[1];
        lenient().doAnswer(invocation -> {
                    updatedEO[0] = invocation.getArgument(0);
                    return 1;
                }).when(rbBusAcctBalanceBcc).modifyByPrimaryKeySelective(org.mockito.ArgumentMatchers.any(RbBusAcctBalanceEO.class));

        ST012InputBO input = new ST012InputBO();
        input.setBaseAcctNo("2000010000003");
        input.setTranAmt(new BigDecimal("0.00"));

        ST012OutputBO output = st012Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(new BigDecimal("888.88"), output.getTotalAmount());
        assertEquals(new BigDecimal("888.88"), output.getAcctAvailBal());
        assertEquals(Integer.valueOf(88003), updatedEO[0].getInternalKey());
        assertEquals(new BigDecimal("888.88"), updatedEO[0].getTotalAmount());
    }

    // 场景：最小货币单位进位边界，0.01 存入使汇总金额 999.99 进位为 1000.00，验证加法精度且可用余额不随存入变动；预期 succeed=true、totalAmount=1000.00、acctAvailBal=999.99
    @Test
    void testST012T04() {
        RbBusAcctEO acctEO = new RbBusAcctEO();
        acctEO.setBaseAcctNo("2000010000004");
        acctEO.setInternalKey(88004);
        lenient().when(rbBusAcctBcc.findByEo(argThat(e -> "2000010000004".equals(e.getBaseAcctNo()))))
                .thenReturn(Collections.singletonList(acctEO));
        RbBusAcctBalanceEO balanceEO = new RbBusAcctBalanceEO();
        balanceEO.setInternalKey(88004);
        balanceEO.setTotalAmount(new BigDecimal("999.99"));
        balanceEO.setAcctAvailBal(new BigDecimal("999.99"));
        lenient().when(rbBusAcctBalanceBcc.findByPrimaryKey(88004)).thenReturn(balanceEO);
        RbBusAcctBalanceEO[] updatedEO = new RbBusAcctBalanceEO[1];
        lenient().doAnswer(invocation -> {
                    updatedEO[0] = invocation.getArgument(0);
                    return 1;
                }).when(rbBusAcctBalanceBcc).modifyByPrimaryKeySelective(org.mockito.ArgumentMatchers.any(RbBusAcctBalanceEO.class));

        ST012InputBO input = new ST012InputBO();
        input.setBaseAcctNo("2000010000004");
        input.setTranAmt(new BigDecimal("0.01"));

        ST012OutputBO output = st012Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(new BigDecimal("1000.00"), output.getTotalAmount());
        assertEquals(new BigDecimal("999.99"), output.getAcctAvailBal());
        assertEquals(Integer.valueOf(88004), updatedEO[0].getInternalKey());
        assertEquals(new BigDecimal("1000.00"), updatedEO[0].getTotalAmount());
    }
}
