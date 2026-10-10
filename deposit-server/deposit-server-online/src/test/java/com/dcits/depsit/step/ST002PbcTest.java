package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.depsit.facade.bo.ST002InputBO;
import com.dcits.depsit.facade.bo.ST002OutputBO;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.eo.RbBusAcctEO;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST002 检查账户到期日 步骤单元测试。
 *
 * <p>按 Spec 与用例覆盖四条路径：命中且到期日为空 → 通过（且结论与交易日期取值无关）、
 * 命中且到期日早于交易日期 → ER0054、命中且到期日不早于交易日期（晚于／等于）→ 通过、
 * 查不到账户 → ER0048 且不执行子步骤 2。断言只依据业务结果，不验证交互次数或顺序。
 */
@ExtendWith(MockitoExtension.class)
class ST002PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @InjectMocks
    private ST002Pbc step;

    // 子步骤 1 按账号唯一命中，取到到期日 2026-10-20 00:00:00；子步骤 2 判定晚于交易日期，返回「通过」（TC001）
    @Test
    void testST002T01() throws Exception {
        ArgumentCaptor<RbBusAcctEO> captor = ArgumentCaptor.forClass(RbBusAcctEO.class);
        RbBusAcctEO record = new RbBusAcctEO();
        record.setBaseAcctNo("6217000000000001");
        record.setAcctDueDate(Timestamp.valueOf("2026-10-20 00:00:00"));
        Mockito.lenient().when(rbBusAcctBcc.findByEo(captor.capture())).thenReturn(List.of(record));

        ST002InputBO input = new ST002InputBO();
        input.setBaseAcctNo("6217000000000001");
        input.setTranDate(Timestamp.valueOf("2026-10-10 00:00:00"));

        ST002OutputBO out = step.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals(Timestamp.valueOf("2026-10-20 00:00:00"), out.getAcctDueDate());
        // {账号} 绑定：以入参账号条件检索
        assertEquals("6217000000000001", captor.getValue().getBaseAcctNo());
        // 输出字段名与类型：acctDueDate 为 java.util.Date
        assertEquals(Date.class, ST002OutputBO.class.getMethod("getAcctDueDate").getReturnType());
    }

    // 命中记录的到期日与交易日期完全相等，「小于」不成立（等于边界），返回「通过」（TC002）
    @Test
    void testST002T02() {
        ArgumentCaptor<RbBusAcctEO> captor = ArgumentCaptor.forClass(RbBusAcctEO.class);
        RbBusAcctEO record = new RbBusAcctEO();
        record.setBaseAcctNo("6217000000000001");
        record.setAcctDueDate(Timestamp.valueOf("2026-10-10 00:00:00"));
        Mockito.lenient().when(rbBusAcctBcc.findByEo(captor.capture())).thenReturn(List.of(record));

        ST002InputBO input = new ST002InputBO();
        input.setBaseAcctNo("6217000000000001");
        input.setTranDate(Timestamp.valueOf("2026-10-10 00:00:00"));

        ST002OutputBO out = step.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals(Timestamp.valueOf("2026-10-10 00:00:00"), out.getAcctDueDate());
    }

    // 命中记录的到期日 2026-10-09 早于交易日期一个自然日，子步骤 2 以子步骤 1 取到的值为左值判定「早于」，返回 ER0054（TC003）
    @Test
    void testST002T03() {
        ArgumentCaptor<RbBusAcctEO> captor = ArgumentCaptor.forClass(RbBusAcctEO.class);
        RbBusAcctEO record = new RbBusAcctEO();
        record.setBaseAcctNo("6217000000000001");
        record.setAcctDueDate(Timestamp.valueOf("2026-10-09 00:00:00"));
        Mockito.lenient().when(rbBusAcctBcc.findByEo(captor.capture())).thenReturn(List.of(record));

        ST002InputBO input = new ST002InputBO();
        input.setBaseAcctNo("6217000000000001");
        input.setTranDate(Timestamp.valueOf("2026-10-10 00:00:00"));

        ST002OutputBO out = step.execute(input);

        assertFalse(out.isSucceed());
        assertEquals("ER0054", out.getErrorCode());
    }

    // 命中记录的到期日 2020-01-01 远早于交易日期，返回 ER0054（TC004）
    @Test
    void testST002T04() {
        ArgumentCaptor<RbBusAcctEO> captor = ArgumentCaptor.forClass(RbBusAcctEO.class);
        RbBusAcctEO record = new RbBusAcctEO();
        record.setBaseAcctNo("6217000000000001");
        record.setAcctDueDate(Timestamp.valueOf("2020-01-01 00:00:00"));
        Mockito.lenient().when(rbBusAcctBcc.findByEo(captor.capture())).thenReturn(List.of(record));

        ST002InputBO input = new ST002InputBO();
        input.setBaseAcctNo("6217000000000001");
        input.setTranDate(Timestamp.valueOf("2026-10-10 00:00:00"));

        ST002OutputBO out = step.execute(input);

        assertFalse(out.isSucceed());
        assertEquals("ER0054", out.getErrorCode());
    }

    // 按账号查不到【账户信息】记录，子步骤 1 立即返回 ER0048；子步骤 2 不执行，既不产生「通过」也不产生 ER0054（TC005）
    @Test
    void testST002T05() {
        ArgumentCaptor<RbBusAcctEO> captor = ArgumentCaptor.forClass(RbBusAcctEO.class);
        Mockito.lenient().when(rbBusAcctBcc.findByEo(captor.capture())).thenReturn(Collections.emptyList());

        ST002InputBO input = new ST002InputBO();
        input.setBaseAcctNo("6217000000009999");
        input.setTranDate(Timestamp.valueOf("2026-10-10 00:00:00"));

        ST002OutputBO out = step.execute(input);

        assertFalse(out.isSucceed());
        assertEquals("ER0048", out.getErrorCode());
        // 失败路径仍以给定账号检索
        assertEquals("6217000000009999", captor.getValue().getBaseAcctNo());
    }

    // 唯一命中记录存在但到期日为空，子步骤 2 走「为空 → 通过」出口且不参与「小于」比较（TC006）
    @Test
    void testST002T06() {
        ArgumentCaptor<RbBusAcctEO> captor = ArgumentCaptor.forClass(RbBusAcctEO.class);
        RbBusAcctEO record = new RbBusAcctEO();
        record.setBaseAcctNo("6217000000000002");
        Mockito.lenient().when(rbBusAcctBcc.findByEo(captor.capture())).thenReturn(List.of(record));

        ST002InputBO input = new ST002InputBO();
        input.setBaseAcctNo("6217000000000002");
        input.setTranDate(Timestamp.valueOf("2026-10-10 00:00:00"));

        ST002OutputBO out = step.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertNull(out.getAcctDueDate());
        assertEquals("6217000000000002", captor.getValue().getBaseAcctNo());
    }

    // 到期日为空时以最小交易日期 1970-01-01 执行，结论仍为「通过」，证明空值分支不参与比较（TC007）
    @Test
    void testST002T07() {
        ArgumentCaptor<RbBusAcctEO> captor = ArgumentCaptor.forClass(RbBusAcctEO.class);
        RbBusAcctEO record = new RbBusAcctEO();
        record.setBaseAcctNo("6217000000000002");
        Mockito.lenient().when(rbBusAcctBcc.findByEo(captor.capture())).thenReturn(List.of(record));

        ST002InputBO input = new ST002InputBO();
        input.setBaseAcctNo("6217000000000002");
        input.setTranDate(Timestamp.valueOf("1970-01-01 00:00:00"));

        ST002OutputBO out = step.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertNull(out.getAcctDueDate());
    }

    // 到期日为空时以极大交易日期 2999-12-31 执行，结论仍为「通过」，与 TC007 共同证明空值分支结论与交易日期无关（TC008）
    @Test
    void testST002T08() {
        ArgumentCaptor<RbBusAcctEO> captor = ArgumentCaptor.forClass(RbBusAcctEO.class);
        RbBusAcctEO record = new RbBusAcctEO();
        record.setBaseAcctNo("6217000000000002");
        Mockito.lenient().when(rbBusAcctBcc.findByEo(captor.capture())).thenReturn(List.of(record));

        ST002InputBO input = new ST002InputBO();
        input.setBaseAcctNo("6217000000000002");
        input.setTranDate(Timestamp.valueOf("2999-12-31 00:00:00"));

        ST002OutputBO out = step.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertNull(out.getAcctDueDate());
    }
}
