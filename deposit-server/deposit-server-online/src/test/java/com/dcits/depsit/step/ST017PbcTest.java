package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.Ccy;
import com.dcits.depsit.facade.bo.ST017InputBO;
import com.dcits.depsit.facade.bo.ST017OutputBO;

/**
 * ST017 检查币种一致性 单元测试。
 *
 * <p>调用签名：{@code ST017OutputBO execute(ST017InputBO input)}。本步骤依赖契约为“不适用”，
 * 无可设桩的 BCC、Mapper、外部客户端或规则，故各用例直接构造 {@link ST017Pbc} 真实执行 {@code execute}，
 * 不创建 Mockito 桩，也不使用 {@code verify} / {@code never} / {@code times} / {@code InOrder} 交互断言。
 */
@ExtendWith(MockitoExtension.class)
class ST017PbcTest {

    // ST017-TC001：REQ-001-S01 / REQ-002-S01 / REQ-003-S01 同一币种代码 CNY 跨 Ccy 与 AcctCcy 两个枚举类型判定为一致，返回“通过”
    @Test
    void testST017T01() {
        ST017InputBO input = new ST017InputBO();
        input.setTranCcy(Ccy.CNY);
        input.setAcctCcy(AcctCcy.CNY);

        ST017OutputBO output = new ST017Pbc().execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNotEquals("ER0051", output.getErrorCode());
    }

    // ST017-TC002：REQ-003-S02 非人民币币种 EUR 一致时同样返回“通过”，不因币种非人民币而改变结果
    @Test
    void testST017T02() {
        ST017InputBO input = new ST017InputBO();
        input.setTranCcy(Ccy.EUR);
        input.setAcctCcy(AcctCcy.EUR);

        ST017OutputBO output = new ST017Pbc().execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST017-TC003：REQ-002-S03 非人民币非美元代码 HKD 同样按币种代码比较，判定为一致，不受枚举声明顺序影响
    @Test
    void testST017T03() {
        ST017InputBO input = new ST017InputBO();
        input.setTranCcy(Ccy.HKD);
        input.setAcctCcy(AcctCcy.HKD);

        ST017OutputBO output = new ST017Pbc().execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST017-TC004：REQ-001-S02 输入分别绑定各自枚举类（tranCcy 为 Ccy、acctCcy 为 AcctCcy），仅该两个字段即完成检查
    @Test
    void testST017T04() {
        ST017InputBO input = new ST017InputBO();
        input.setTranCcy(Ccy.USD);
        input.setAcctCcy(AcctCcy.USD);

        ST017OutputBO output = new ST017Pbc().execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST017-TC005：REQ-002-S02 / REQ-004-S01 不同币种代码（CNY / USD）判定为不一致，返回错误码 ER0051，不返回“通过”
    @Test
    void testST017T05() {
        ST017InputBO input = new ST017InputBO();
        input.setTranCcy(Ccy.CNY);
        input.setAcctCcy(AcctCcy.USD);

        ST017OutputBO output = new ST017Pbc().execute(input);

        assertFalse(output.isSucceed());
        assertEquals("ER0051", output.getErrorCode());
    }

    // ST017-TC006：REQ-004-S02 不一致的方向不影响结果，与 TC005 互为反向的组合（USD / CNY）同样返回 ER0051
    @Test
    void testST017T06() {
        ST017InputBO input = new ST017InputBO();
        input.setTranCcy(Ccy.USD);
        input.setAcctCcy(AcctCcy.CNY);

        ST017OutputBO output = new ST017Pbc().execute(input);

        assertFalse(output.isSucceed());
        assertEquals("ER0051", output.getErrorCode());
    }

    // ST017-TC007：REQ-004-S03 不一致路径（GBP / JPY）错误码恰为注册表登记的 ER0051，不使用 ER0023 / ER0047 / ER0094
    @Test
    void testST017T07() {
        ST017InputBO input = new ST017InputBO();
        input.setTranCcy(Ccy.GBP);
        input.setAcctCcy(AcctCcy.JPY);

        ST017OutputBO output = new ST017Pbc().execute(input);

        assertFalse(output.isSucceed());
        assertEquals("ER0051", output.getErrorCode());
        assertNotEquals("ER0023", output.getErrorCode());
        assertNotEquals("ER0047", output.getErrorCode());
        assertNotEquals("ER0094", output.getErrorCode());
    }

    // ST017-TC008：REQ-005-S01 遍历 12 × 12 = 144 种组合，逐一断言每个组合恰得“通过”或 ER0051 之一（同代码 12 通过 / 异代码 132 失败）
    @Test
    void testST017T08() {
        int total = 0;
        int passCount = 0;
        int failCount = 0;

        for (Ccy tranCcy : Ccy.values()) {
            for (AcctCcy acctCcy : AcctCcy.values()) {
                ST017InputBO input = new ST017InputBO();
                input.setTranCcy(tranCcy);
                input.setAcctCcy(acctCcy);

                ST017OutputBO output = new ST017Pbc().execute(input);

                total++;
                if (tranCcy.getValue().equals(acctCcy.getValue())) {
                    passCount++;
                    assertTrue(output.isSucceed());
                    assertNull(output.getErrorCode());
                } else {
                    failCount++;
                    assertFalse(output.isSucceed());
                    assertEquals("ER0051", output.getErrorCode());
                }
            }
        }

        assertEquals(144, total);
        assertEquals(12, passCount);
        assertEquals(132, failCount);
    }

    // ST017-TC009：REQ-005-S02 一致路径（GBP / GBP）除返回检查结果外不产生任何副作用，步骤无可注入的外部协作者
    @Test
    void testST017T09() {
        ST017InputBO input = new ST017InputBO();
        input.setTranCcy(Ccy.GBP);
        input.setAcctCcy(AcctCcy.GBP);

        ST017OutputBO output = new ST017Pbc().execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }
}
