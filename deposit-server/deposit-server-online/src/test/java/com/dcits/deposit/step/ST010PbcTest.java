package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST010InputBO;
import com.dcits.deposit.facade.bo.ST010OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST010 检查资金管控标识 步骤实现单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01、REQ-002-S01、REQ-003-S01 及查询结果多条取第一条的
 * 统一约定（测试用例 ST010-TC001~TC004）。查询条件 EO 承载账号的具体属性 Spec 未预设，
 * 用例不绑定查询条件 EO 的具体属性名，按 {@code IRbBusAcctBcc#findByEo} 组合查询约定设桩。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST010PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @InjectMocks
    private ST010Pbc st010Pbc;

    // 场景：REQ-001-S01（ST010-TC001），账号存在且 loanFundFlag=「Y-是」，步骤取得该值作为检查标识，正常结束
    @Test
    void testST010T01() {
        ST010InputBO input = new ST010InputBO();
        input.setBaseAcctNo("6228480012345678");

        RbBusAcctEO acct = new RbBusAcctEO();
        acct.setLoanFundFlag("Y-是");
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(Collections.singletonList(acct));

        ST010OutputBO output = st010Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("Y-是", output.getLoanFundFlag());
    }

    // 场景：REQ-002-S01（ST010-TC002），loanFundFlag=「Y-是」时正常结束并跳转《检查账户客户一致性》，不返回「通过」
    @Test
    void testST010T02() {
        ST010InputBO input = new ST010InputBO();
        input.setBaseAcctNo("6228480012345678");

        RbBusAcctEO acct = new RbBusAcctEO();
        acct.setLoanFundFlag("Y-是");
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(Collections.singletonList(acct));

        ST010OutputBO output = st010Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("检查账户客户一致性", output.getGotoStepName());
    }

    // 场景：REQ-003-S01（ST010-TC003），loanFundFlag=「N-否」≠「Y-是」时返回「通过」，不发生跳转
    @Test
    void testST010T03() {
        ST010InputBO input = new ST010InputBO();
        input.setBaseAcctNo("6228480012345678");

        RbBusAcctEO acct = new RbBusAcctEO();
        acct.setLoanFundFlag("N-否");
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(Collections.singletonList(acct));

        ST010OutputBO output = st010Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getGotoStepName());
        assertEquals("N-否", output.getLoanFundFlag());
    }

    // 场景：查询返回多条记录（ST010-TC004），按统一约定取结果集第一条「N-否」判定，返回「通过」，不因第二条「Y-是」跳转
    @Test
    void testST010T04() {
        ST010InputBO input = new ST010InputBO();
        input.setBaseAcctNo("6228480012345678");

        RbBusAcctEO first = new RbBusAcctEO();
        first.setLoanFundFlag("N-否");
        RbBusAcctEO second = new RbBusAcctEO();
        second.setLoanFundFlag("Y-是");
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(Arrays.asList(first, second));

        ST010OutputBO output = st010Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getGotoStepName());
        assertEquals("N-否", output.getLoanFundFlag());
    }
}
