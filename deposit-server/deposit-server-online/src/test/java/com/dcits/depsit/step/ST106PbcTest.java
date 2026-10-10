package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

import com.dcits.depsit.facade.bo.ST106InputBO;
import com.dcits.depsit.facade.bo.ST106OutputBO;
import com.dcits.depsit.facade.components.IRbLimitSumInfoBcc;
import com.dcits.depsit.facade.eo.RbLimitSumInfoEO;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST106 获取累计限额 的单元测试。
 *
 * <p>调用签名：{@code ST106OutputBO execute(ST106InputBO input)}；本步骤只有一次数据访问动作，
 * 定位方法固定为 {@code IRbLimitSumInfoBcc.findByPrimaryKey(限额检查对象值, 限额场景编码)}。
 * 本步骤无业务失败场景，查无记录按正常路径返回 0 值。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST106PbcTest {

    @Mock
    private IRbLimitSumInfoBcc rbLimitSumInfoBcc;

    @InjectMocks
    private ST106Pbc st106Pbc;

    // ST106-TC001：REQ-002-S01、REQ-004-S01、REQ-005-S01（命中支）命中记录时取该记录的限额累计金额与限额累计笔数
    @Test
    void testST106T01() {
        RbLimitSumInfoEO alpha = limitSumInfo("1100602112345678", "LSN0001", "C0000001234",
                new BigDecimal("1000.00"), 5);
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(eq("1100602112345678"), eq("LSN0001")))
                .thenReturn(alpha);

        ST106InputBO input = input("1100602112345678", "C0000001234", "LSN0001");
        ST106OutputBO output = st106Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        // 取值来自命中记录该两列本身，非入参值、非 0；金额用 compareTo 比较，不依赖 Spec 未规定的 scale
        assertNotNull(output.getLimitSumAmt());
        assertEquals(0, new BigDecimal("1000.00").compareTo(output.getLimitSumAmt()));
        assertEquals(Integer.valueOf(5), output.getLimitSumNum());
        // 回显字段 clientNo／limitSceneNo 的取值口径源需求未定义（Spec 不覆盖第 1 项），此处只核对字段可访问，不作取值断言
        output.getClientNo();
        output.getLimitSceneNo();
    }

    // ST106-TC002：REQ-002-S02 定位条件为「限额检查对象值＝账号」与「限额场景编码」的合取，仅同对象值或仅同场景编码的记录不被取用
    @Test
    void testST106T02() {
        // 概念表中另存在 β（同对象值、异场景编码）与 γ（异对象值、同场景编码），二者非本次两键对应的记录
        RbLimitSumInfoEO alpha = limitSumInfo("1100602112345678", "LSN0001", "C0000001234",
                new BigDecimal("1000.00"), 5);
        String[] capturedKeys = new String[2];
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(anyString(), anyString()))
                .thenAnswer(invocation -> {
                    capturedKeys[0] = invocation.getArgument(0);
                    capturedKeys[1] = invocation.getArgument(1);
                    return "1100602112345678".equals(capturedKeys[0])
                            && "LSN0001".equals(capturedKeys[1]) ? alpha : null;
                });

        ST106InputBO input = input("1100602112345678", "C0000001234", "LSN0001");
        ST106OutputBO output = st106Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        // 输出取自记录 α，不含 β 的 777.00／7 与 γ 的 888.00／8
        assertEquals(0, new BigDecimal("1000.00").compareTo(output.getLimitSumAmt()));
        assertEquals(Integer.valueOf(5), output.getLimitSumNum());
        // 实际查询入参两键取自 baseAcctNo／limitSceneNo，未以单键扩大或改写命中范围
        assertEquals("1100602112345678", capturedKeys[0]);
        assertEquals("LSN0001", capturedKeys[1]);
    }

    // ST106-TC003：REQ-002-S03 定位不使用入参 clientNo，入参 clientNo 与命中记录的客户号不一致时仍命中
    @Test
    void testST106T03() {
        RbLimitSumInfoEO gamma2 = limitSumInfo("1100602112345678", "LSN0001", "C0000009999",
                new BigDecimal("1200.00"), 6);
        String[] capturedKeys = new String[2];
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(anyString(), anyString()))
                .thenAnswer(invocation -> {
                    capturedKeys[0] = invocation.getArgument(0);
                    capturedKeys[1] = invocation.getArgument(1);
                    return gamma2;
                });

        ST106InputBO input = input("1100602112345678", "C0000001234", "LSN0001");
        ST106OutputBO output = st106Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals(0, new BigDecimal("1200.00").compareTo(output.getLimitSumAmt()));
        assertEquals(Integer.valueOf(6), output.getLimitSumNum());
        // 定位键为账号与场景编码，不含 clientNo
        assertEquals("1100602112345678", capturedKeys[0]);
        assertEquals("LSN0001", capturedKeys[1]);
    }

    // ST106-TC004：REQ-003-S01、REQ-004-S02、REQ-005-S01（查无支）查无记录时两值均为数值 0，且步骤正常结束、不返回业务错误码
    @Test
    void testST106T04() {
        String[] capturedKeys = new String[2];
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(anyString(), anyString()))
                .thenAnswer(invocation -> {
                    capturedKeys[0] = invocation.getArgument(0);
                    capturedKeys[1] = invocation.getArgument(1);
                    return null;
                });

        ST106InputBO input = input("1100609999999999", "C0000005678", "LSN0001");
        ST106OutputBO output = st106Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        // 查无记录时两值为 0，不为空值、不为其它数值；「查无记录」按正常取值路径处理而非业务失败
        assertNotNull(output.getLimitSumAmt());
        assertEquals(0, BigDecimal.ZERO.compareTo(output.getLimitSumAmt()));
        assertEquals(Integer.valueOf(0), output.getLimitSumNum());
        assertEquals("1100609999999999", capturedKeys[0]);
        assertEquals("LSN0001", capturedKeys[1]);
    }

    // ST106-TC005：REQ-003-S02 查无记录且表中存在同场景编码的其它对象值记录时，仍置 0 且查询条件未被改写为单键或其它键
    @Test
    void testST106T05() {
        // 概念表中存在记录 δ（限额检查对象值 1100602112345678、限额场景编码 LSN0001、1000.00／5），
        // 其场景编码与本例入参相同但对象值不同，按两键定位仍无匹配记录
        String[] capturedKeys = new String[2];
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(anyString(), anyString()))
                .thenAnswer(invocation -> {
                    capturedKeys[0] = invocation.getArgument(0);
                    capturedKeys[1] = invocation.getArgument(1);
                    return null;
                });

        ST106InputBO input = input("1100609999999999", "C0000005678", "LSN0001");
        ST106OutputBO output = st106Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        // 不以仅匹配其中一键的记录（δ 的 1000.00／5）替代命中结果，也不以空值或其它默认值替代 0
        assertNotNull(output.getLimitSumAmt());
        assertEquals(0, BigDecimal.ZERO.compareTo(output.getLimitSumAmt()));
        assertEquals(Integer.valueOf(0), output.getLimitSumNum());
        assertEquals("1100609999999999", capturedKeys[0]);
        assertEquals("LSN0001", capturedKeys[1]);
    }

    // ST106-TC006：REQ-002 取值约束、REQ-004-S03 命中记录而该记录两列均为 0 的零值边界，取值仍为该记录列的取值本身，不因 0 转为失败
    @Test
    void testST106T06() {
        RbLimitSumInfoEO delta = limitSumInfo("1100602112345680", "LSN0003", "C0000001234",
                new BigDecimal("0.00"), 0);
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(eq("1100602112345680"), eq("LSN0003")))
                .thenReturn(delta);

        ST106InputBO input = input("1100602112345680", "C0000001234", "LSN0003");
        ST106OutputBO output = st106Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNotNull(output.getLimitSumAmt());
        assertEquals(0, BigDecimal.ZERO.compareTo(output.getLimitSumAmt()));
        assertEquals(Integer.valueOf(0), output.getLimitSumNum());
    }

    /** 构造步骤输入：三个必填输入按「## 输入」表字段名与顺序赋值。 */
    private ST106InputBO input(String baseAcctNo, String clientNo, String limitSceneNo) {
        ST106InputBO input = new ST106InputBO();
        input.setBaseAcctNo(baseAcctNo);
        input.setClientNo(clientNo);
        input.setLimitSceneNo(limitSceneNo);
        return input;
    }

    /** 构造【限额累计信息表】记录：两定位键、记录客户号、限额累计金额与限额累计笔数（库列／属性名 `否`）。 */
    private RbLimitSumInfoEO limitSumInfo(String checkObjVal, String limitSceneNo, String clientNo,
                                          BigDecimal limitSumAmt, Integer limitSumNum) {
        RbLimitSumInfoEO eo = new RbLimitSumInfoEO();
        eo.setCheckObjVal(checkObjVal);
        eo.setLimitSceneNo(limitSceneNo);
        eo.setClientNo(clientNo);
        eo.setLimitSumAmt(limitSumAmt);
        eo.set否(limitSumNum);
        return eo;
    }
}
