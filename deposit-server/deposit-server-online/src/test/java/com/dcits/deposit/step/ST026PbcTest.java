package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.AllDepInd;
import com.dcits.deposit.facade.bo.ST026InputBO;
import com.dcits.deposit.facade.bo.ST026OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST026 检查对手账户通存标志 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01、REQ-002-S01 已确认场景（测试用例 ST026-TC001、ST026-TC002）。
 * 未覆盖事项：REQ-003-S01 成功路径（「Y-是」与 {@link AllDepInd} 取值映射未确认，TBD-2）、
 * 查询无记录行为（TBD-3）、必填缺失行为（TBD-5）、账号→账户记录解析路径的方法绑定（TBD-4）、
 * 失败条件真实判定口径（TBD-1），见 {@link ST026Pbc} 中 FIXME，待业务确认后补充。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST026PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @InjectMocks
    private ST026Pbc st026Pbc;

    // ST026-TC001（REQ-001-S01、REQ-002-S01）：主表查询返回单条记录 allDepInd=N001，步骤按查询取得并输出该通存标志，检查「N001 不等于 Y-是」不通过 → 业务失败返回 ER0055，不继续执行
    @Test
    void testST026T01() {
        RbBusAcctEO acctEo = new RbBusAcctEO();
        acctEo.setAllDepInd(AllDepInd.N001);
        when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(Collections.singletonList(acctEo));

        ST026InputBO input = new ST026InputBO();
        input.setOthBaseAcctNo("6228480012345678");

        ST026OutputBO result = st026Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0055", result.getErrorCode());
        // errorMessage 采用「ER0055::当前交易机构不是账户的通存机构」（错误码::业务说明）格式，不做文本等值断言
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().startsWith("ER0055::"));
        assertEquals(AllDepInd.N001, result.getAllDepInd());
    }

    // ST026-TC002（REQ-001-S01、REQ-002-S01）：主表查询返回两条记录（第一条 N001、第二条 N004），按单条查询统一约定只取结果集第一条；输出取第一条 N001，第一条不等于「Y-是」→ 业务失败返回 ER0055
    @Test
    void testST026T02() {
        RbBusAcctEO firstEo = new RbBusAcctEO();
        firstEo.setAllDepInd(AllDepInd.N001);
        RbBusAcctEO secondEo = new RbBusAcctEO();
        secondEo.setAllDepInd(AllDepInd.N004);
        when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(Arrays.asList(firstEo, secondEo));

        ST026InputBO input = new ST026InputBO();
        input.setOthBaseAcctNo("6228480012345678");

        ST026OutputBO result = st026Pbc.execute(input);

        // 只使用结果集第一条 N001，未使用第二条 N004
        assertEquals(AllDepInd.N001, result.getAllDepInd());
        assertFalse(result.isSucceed());
        assertEquals("ER0055", result.getErrorCode());
        // errorMessage 采用「ER0055::当前交易机构不是账户的通存机构」（错误码::业务说明）格式，不做文本等值断言
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().startsWith("ER0055::"));
    }
}
