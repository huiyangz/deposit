package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.LostType;
import com.dcits.deposit.enums.VoucherLostStatus;
import com.dcits.deposit.facade.bo.ST001InputBO;
import com.dcits.deposit.facade.bo.ST001OutputBO;
import com.dcits.deposit.facade.components.IRbVoucherLostBcc;
import com.dcits.deposit.facade.eo.RbVoucherLostEO;

/**
 * ST001 检查对手账户凭证状态 步骤实现单元测试。
 *
 * <p>覆盖测试用例 ST001-TC001、ST001-TC002（正式 Spec REQ-001~REQ-003 场景）。
 * 输出表四个业务字段（voucherLostStatus/lostType/lostNo/voucherNo）的赋值与返回路径
 * 属 Spec 待确认事项 1，本套用例不对其断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST001PbcTest {

    @Mock
    private IRbVoucherLostBcc rbVoucherLostBcc;

    @InjectMocks
    private ST001Pbc st001Pbc;

    // ST001-TC001 账号无生效挂失记录：按输入账号与凭证挂失状态"A-生效"查询返回空集合，检查通过、步骤正常完成（REQ-001-S02、REQ-003-S01）
    @Test
    void testST001T01() {
        ST001InputBO input = new ST001InputBO();
        input.setBaseAcctNo("6222020202020202");

        // 在桩响应中捕获 findByEo 收到的查询 EO，用于核对 REQ-001 查询条件
        AtomicReference<RbVoucherLostEO> capturedQueryEo = new AtomicReference<>();
        lenient().when(rbVoucherLostBcc.findByEo(any(RbVoucherLostEO.class)))
                .thenAnswer(invocation -> {
                    capturedQueryEo.set(invocation.getArgument(0));
                    return Collections.emptyList();
                });

        ST001OutputBO result = st001Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());

        RbVoucherLostEO queryEo = capturedQueryEo.get();
        assertNotNull(queryEo);
        assertEquals("6222020202020202", queryEo.getBaseAcctNo());
        assertEquals(VoucherLostStatus.A, queryEo.getVoucherLostStatus());
    }

    // ST001-TC002 账号存在生效挂失记录：按输入账号与凭证挂失状态"A-生效"查询返回非空集合（记录含挂失编号），步骤业务失败并返回错误码 ER0068（REQ-001-S01、REQ-002-S01）
    @Test
    void testST001T02() {
        ST001InputBO input = new ST001InputBO();
        input.setBaseAcctNo("6222020202020202");

        RbVoucherLostEO record = new RbVoucherLostEO();
        record.setBaseAcctNo("6222020202020202");
        record.setVoucherLostStatus(VoucherLostStatus.A);
        record.setLostNo("LS202610010001");
        record.setLostType(LostType.FOR);
        record.setVoucherNo("V202610010001");
        List<RbVoucherLostEO> voucherLostList = new ArrayList<>();
        voucherLostList.add(record);

        // 在桩响应中捕获 findByEo 收到的查询 EO，用于核对 REQ-001 查询条件
        AtomicReference<RbVoucherLostEO> capturedQueryEo = new AtomicReference<>();
        lenient().when(rbVoucherLostBcc.findByEo(any(RbVoucherLostEO.class)))
                .thenAnswer(invocation -> {
                    capturedQueryEo.set(invocation.getArgument(0));
                    return voucherLostList;
                });

        ST001OutputBO result = st001Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0068", result.getErrorCode());
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().startsWith("ER0068::"));

        RbVoucherLostEO queryEo = capturedQueryEo.get();
        assertNotNull(queryEo);
        assertEquals("6222020202020202", queryEo.getBaseAcctNo());
        assertEquals(VoucherLostStatus.A, queryEo.getVoucherLostStatus());
    }
}
