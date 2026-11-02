package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST002InputBO;
import com.dcits.deposit.facade.bo.ST002OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ST002 检查账户到期日 步骤实现单元测试。
 *
 * <p>用例来源：正式 Spec ST002 与测试用例文档（ST002-TC001～ST002-TC003）。查询路径（TBD-1）
 * 确认前，桩仅绑定已确认数据源 {@link IRbBusAcctBcc}，返回主表记录。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST002PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @InjectMocks
    private ST002Pbc st002Pbc;

    /** 正常成功流：主表记录存在且到期日 2026-12-31 晚于交易日期 2026-10-31，检查通过。 */
    @Test
    void testST002T01() {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setAcctDueDate(new Date(126, 11, 31)); // 2026-12-31
        Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.any(RbBusAcctEO.class)))
                .thenReturn(List.of(record));

        ST002InputBO input = new ST002InputBO();
        input.setBaseAcctNo("1000000001");
        input.setTranDate(new Date(126, 9, 31)); // 2026-10-31

        ST002OutputBO result = st002Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(new Date(126, 11, 31), result.getAcctDueDate());
    }

    /** 错误码路径：到期日 2026-09-30 早于交易日期 2026-10-31，判定账户已过期，返回 ER0054。 */
    @Test
    void testST002T02() {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setAcctDueDate(new Date(126, 8, 30)); // 2026-09-30
        Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.any(RbBusAcctEO.class)))
                .thenReturn(List.of(record));

        ST002InputBO input = new ST002InputBO();
        input.setBaseAcctNo("1000000001");
        input.setTranDate(new Date(126, 9, 31)); // 2026-10-31

        ST002OutputBO result = st002Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0054", result.getErrorCode());
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().contains("ER0054::账户已过期"));
        // 失败路径输出 BO 的 acctDueDate 取值 Spec 未声明，不纳入断言
    }

    /** 边界通过路径：到期日 2026-10-31 等于交易日期 2026-10-31，不满足"小于"，检查通过。 */
    @Test
    void testST002T03() {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setAcctDueDate(new Date(126, 9, 31)); // 2026-10-31
        Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.any(RbBusAcctEO.class)))
                .thenReturn(List.of(record));

        ST002InputBO input = new ST002InputBO();
        input.setBaseAcctNo("1000000001");
        input.setTranDate(new Date(126, 9, 31)); // 2026-10-31

        ST002OutputBO result = st002Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(new Date(126, 9, 31), result.getAcctDueDate());
    }
}
