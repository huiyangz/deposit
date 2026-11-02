package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST042InputBO;
import com.dcits.deposit.facade.bo.ST042OutputBO;
import com.dcits.deposit.facade.components.IRbLimitSumInfoBcc;
import com.dcits.deposit.facade.eo.RbLimitSumInfoEO;

/**
 * ST042 获取累计限额 步骤单元测试。
 *
 * <p>覆盖正式 Spec（ST042）已确认验收场景：REQ-001-S01（输入齐备正常查询）、REQ-002-S01
 * （命中记录返回累计金额与笔数）、REQ-003-S01（输出与记录对应列一致）、REQ-003-S02
 * （记录列为空时相应输出为空）。待确认事项 1、3、4 澄清前，账号到 checkObjVal 映射、
 * 无匹配记录及必填输入缺失行为不作为已确认断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST042PbcTest {

    @Mock
    private IRbLimitSumInfoBcc rbLimitSumInfoBcc;

    @InjectMocks
    private ST042Pbc st042Pbc;

    // 场景 REQ-001-S01：三个必填输入齐备时正常执行查询，步骤成功结束，不产生额外业务错误
    @Test
    void testST042T01() {
        lenient().when(rbLimitSumInfoBcc.findByPrimaryKey("6001010001000001", "S001"))
                .thenReturn(buildEo("CL9999999", "S009", new BigDecimal("1000.00"), Integer.valueOf(5)));

        ST042OutputBO output = st042Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // 场景 REQ-002-S01：存在匹配记录时返回限额累计金额与限额累计笔数
    @Test
    void testST042T02() {
        lenient().when(rbLimitSumInfoBcc.findByPrimaryKey("6001010001000001", "S001"))
                .thenReturn(buildEo("CL9999999", "S009", new BigDecimal("1000.00"), Integer.valueOf(5)));

        ST042OutputBO output = st042Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertEquals(new BigDecimal("1000.00"), output.getLimitSumAmt());
        assertEquals(Integer.valueOf(5), output.get否());
    }

    // 场景 REQ-003-S01：命中记录时输出字段与记录对应列一致（记录 clientNo、limitSceneNo 与输入不同，验证取值取自命中记录而非回显输入）
    @Test
    void testST042T03() {
        lenient().when(rbLimitSumInfoBcc.findByPrimaryKey("6001010001000001", "S001"))
                .thenReturn(buildEo("CL9999999", "S009", new BigDecimal("1000.00"), Integer.valueOf(5)));

        ST042OutputBO output = st042Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertEquals("CL9999999", output.getClientNo());
        assertEquals("S009", output.getLimitSceneNo());
        assertEquals(new BigDecimal("1000.00"), output.getLimitSumAmt());
        assertEquals(Integer.valueOf(5), output.get否());
    }

    // 场景 REQ-003-S02：命中记录对应列 limitSumAmt、限额累计笔数为空时相应输出为空，clientNo、limitSceneNo 取命中记录对应值，步骤仍成功结束
    @Test
    void testST042T04() {
        lenient().when(rbLimitSumInfoBcc.findByPrimaryKey("6001010001000001", "S001"))
                .thenReturn(buildEo("CL9999999", "S009", null, null));

        ST042OutputBO output = st042Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertNull(output.getLimitSumAmt());
        assertNull(output.get否());
        assertEquals("CL9999999", output.getClientNo());
        assertEquals("S009", output.getLimitSceneNo());
    }

    private ST042InputBO buildInput() {
        ST042InputBO input = new ST042InputBO();
        input.setBaseAcctNo("6001010001000001");
        input.setClientNo("CL0000001");
        input.setLimitSceneNo("S001");
        return input;
    }

    private RbLimitSumInfoEO buildEo(String clientNo, String limitSceneNo, BigDecimal limitSumAmt, Integer 否) {
        RbLimitSumInfoEO eo = new RbLimitSumInfoEO();
        eo.setClientNo(clientNo);
        eo.setLimitSceneNo(limitSceneNo);
        eo.setLimitSumAmt(limitSumAmt);
        eo.set否(否);
        return eo;
    }
}
