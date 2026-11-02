package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST046InputBO;
import com.dcits.deposit.facade.bo.ST046OutputBO;
import com.dcits.deposit.facade.components.IRbLimitSumInfoBcc;
import com.dcits.deposit.facade.eo.RbLimitSumInfoEO;

/**
 * ST046 更新累计限额 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01~S04、REQ-002-S01（用例 ST046-TC001~TC005）。更新记录定位键
 * （待确认事项 1）与输出 limitSumAmt 返回语义（待确认事项 2）未确认，断言仅落在已确认的写入值
 * limitSumAmt 与步骤结果状态上，不把未确认行为写为已确认结果。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST046PbcTest {

    @Mock
    private IRbLimitSumInfoBcc rbLimitSumInfoBcc;

    @InjectMocks
    private ST046Pbc st046Pbc;

    // 场景 REQ-001-S01 / ST046-TC001：限额检查结果="未超限"、限额累计金额=100.00（>0）、限额累计笔数=0，
    // 触发条件成立（金额分支），更新入参 limitSumAmt=100.00，步骤正常成功
    @Test
    void testST046T01() {
        ST046InputBO input = new ST046InputBO();
        input.set限额检查结果("未超限");
        input.setBaseAcctNo("6222020200012345678");
        input.setLimitSceneNo("LS001");
        input.setClientNo("C10001");
        input.setLimitSumAmt(new BigDecimal("100.00"));
        input.set否(0);

        ArgumentCaptor<RbLimitSumInfoEO> captor = ArgumentCaptor.forClass(RbLimitSumInfoEO.class);
        when(rbLimitSumInfoBcc.modifyByPrimaryKeySelective(captor.capture())).thenReturn(1);

        ST046OutputBO result = st046Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(0, captor.getValue().getLimitSumAmt().compareTo(new BigDecimal("100.00")));
    }

    // 场景 REQ-001-S02 / ST046-TC002：限额检查结果="未超限"、限额累计金额=0.00（不大于0）、
    // 限额累计笔数=5（>0），触发条件成立（OR 分支·笔数），LIMIT_SUM_AMT 写入 0.00，步骤正常成功
    @Test
    void testST046T02() {
        ST046InputBO input = new ST046InputBO();
        input.set限额检查结果("未超限");
        input.setBaseAcctNo("6222020200012345678");
        input.setLimitSceneNo("LS001");
        input.setClientNo("C10001");
        input.setLimitSumAmt(new BigDecimal("0.00"));
        input.set否(5);

        ArgumentCaptor<RbLimitSumInfoEO> captor = ArgumentCaptor.forClass(RbLimitSumInfoEO.class);
        when(rbLimitSumInfoBcc.modifyByPrimaryKeySelective(captor.capture())).thenReturn(1);

        ST046OutputBO result = st046Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(0, captor.getValue().getLimitSumAmt().compareTo(BigDecimal.ZERO));
    }

    // 场景 REQ-002-S01 / ST046-TC003：触发条件满足（"未超限"、限额累计金额=200.50>0、限额累计笔数=4>0），
    // 定位记录累计限额字段（LIMIT_SUM_AMT）更新为 200.50，与输入一致，步骤正常成功
    @Test
    void testST046T03() {
        ST046InputBO input = new ST046InputBO();
        input.set限额检查结果("未超限");
        input.setBaseAcctNo("6222020200012345678");
        input.setLimitSceneNo("LS001");
        input.setClientNo("C10001");
        input.setLimitSumAmt(new BigDecimal("200.50"));
        input.set否(4);

        ArgumentCaptor<RbLimitSumInfoEO> captor = ArgumentCaptor.forClass(RbLimitSumInfoEO.class);
        when(rbLimitSumInfoBcc.modifyByPrimaryKeySelective(captor.capture())).thenReturn(1);

        ST046OutputBO result = st046Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(0, captor.getValue().getLimitSumAmt().compareTo(new BigDecimal("200.50")));
    }

    // 场景 REQ-001-S03 / ST046-TC004：限额检查结果="未超限"、限额累计金额=0.00、限额累计笔数=0，
    // 触发条件不成立（金额不大于0且笔数不大于0），不执行任何累计限额更新，步骤正常完成、无业务失败
    @Test
    void testST046T04() {
        ST046InputBO input = new ST046InputBO();
        input.set限额检查结果("未超限");
        input.setBaseAcctNo("6222020200012345678");
        input.setLimitSceneNo("LS001");
        input.setClientNo("C10001");
        input.setLimitSumAmt(new BigDecimal("0.00"));
        input.set否(0);

        ST046OutputBO result = st046Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // 场景 REQ-001-S04 / ST046-TC005：限额检查结果="超限"（不等于"未超限"的示例取值），
    // 即使限额累计金额=100.00>0、限额累计笔数=3>0，触发条件仍不成立，不执行更新，步骤正常完成、无业务失败
    @Test
    void testST046T05() {
        ST046InputBO input = new ST046InputBO();
        input.set限额检查结果("超限");
        input.setBaseAcctNo("6222020200012345678");
        input.setLimitSceneNo("LS001");
        input.setClientNo("C10001");
        input.setLimitSumAmt(new BigDecimal("100.00"));
        input.set否(3);

        ST046OutputBO result = st046Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }
}
