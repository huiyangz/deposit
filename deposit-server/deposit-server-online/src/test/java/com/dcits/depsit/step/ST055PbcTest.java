package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.depsit.enums.Ccy;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.facade.bo.ST055InputBO;
import com.dcits.depsit.facade.bo.ST055OutputBO;
import com.dcits.depsit.facade.components.IFmBranchCcyBcc;
import com.dcits.depsit.facade.eo.FmBranchCcyEO;

/**
 * ST055 检查机构币种交易权限 单元测试。
 *
 * <p>用例来源：`outputs/测试用例.md` ST055-TC001 至 ST055-TC010，覆盖 Spec REQ-001 至 REQ-006 的场景：
 * 步骤 1 按交易机构（{@code tranBranch}，查询条件不含币种）查询【机构币种信息】得到 [机构币种列表]；
 * 步骤 2 判定 {@code tranCcy} 是否属于该列表——属于时 {@code succeed = true} 且错误字段为空，
 * 不属于（含查询无匹配记录、列表为空）时 {@code succeed = false}、{@code errorCode = "ER0047"}。
 *
 * <p>依赖仅为 {@link IFmBranchCcyBcc} 的只读查询 {@code findByEo(FmBranchCcyEO)}；
 * 各用例只对该查询设桩，不触达 Mapper、其它 BCC、规则、跨组件客户端或数据库，
 * 也不使用 {@code verify} / {@code never} / {@code times} / {@code InOrder} 交互断言。
 *
 * <p>未定义行为不生成用例：输入 {@code tranBranch}/{@code tranCcy} 为 null、缺失或超出所绑定枚举成员的处理
 * （Spec「## 验收范围与明确不覆盖的事项」第 4 项），以及输出字段 {@code ccy} 的产生条件与取值
 * （同第 1 项），均无 Spec 依据，不作断言。
 */
@ExtendWith(MockitoExtension.class)
class ST055PbcTest {

    /** 【机构币种信息】数据服务（只读查询入口） */
    @Mock
    private IFmBranchCcyBcc iFmBranchCcyBcc;

    /** 被测步骤实现 */
    @InjectMocks
    private ST055Pbc pbc;

    /** 构造一条机构币种记录（归属机构号 + 币种）。 */
    private static FmBranchCcyEO branchCcyRecord(TranBranch branch, Ccy ccy) {
        FmBranchCcyEO record = new FmBranchCcyEO();
        record.setBranch(branch);
        record.setCcy(ccy);
        return record;
    }

    /** 构造输入 BO。 */
    private static ST055InputBO inputOf(TranBranch tranBranch, Ccy tranCcy) {
        ST055InputBO input = new ST055InputBO();
        input.setTranBranch(tranBranch);
        input.setTranCcy(tranCcy);
        return input;
    }

    // ST055-TC001：REQ-001-S01 / REQ-002-S01 / REQ-003-S01 机构已有 CNY、USD、HKD，待检查 USD 在列表内 → 检查结果“通过”
    @Test
    void testST055T01() {
        lenient().when(iFmBranchCcyBcc.findByEo(any(FmBranchCcyEO.class))).thenReturn(List.of(
                branchCcyRecord(TranBranch.VALUE_351155, Ccy.CNY),
                branchCcyRecord(TranBranch.VALUE_351155, Ccy.USD),
                branchCcyRecord(TranBranch.VALUE_351155, Ccy.HKD)));

        ST055OutputBO output = pbc.execute(inputOf(TranBranch.VALUE_351155, Ccy.USD));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNotEquals("ER0047", output.getErrorCode());
    }

    // ST055-TC002：REQ-003-S02 列表含多个币种时任一命中币种均“通过”，命中项为列表末尾元素
    @Test
    void testST055T02() {
        lenient().when(iFmBranchCcyBcc.findByEo(any(FmBranchCcyEO.class))).thenReturn(List.of(
                branchCcyRecord(TranBranch.VALUE_351155, Ccy.CNY),
                branchCcyRecord(TranBranch.VALUE_351155, Ccy.USD),
                branchCcyRecord(TranBranch.VALUE_351155, Ccy.HKD)));

        ST055OutputBO output = pbc.execute(inputOf(TranBranch.VALUE_351155, Ccy.HKD));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
    }

    // ST055-TC003：REQ-002-S02 列表内容不随待检查币种变化，不被 tranCcy 过滤或裁剪
    @Test
    void testST055T03() {
        lenient().when(iFmBranchCcyBcc.findByEo(any(FmBranchCcyEO.class))).thenReturn(List.of(
                branchCcyRecord(TranBranch.VALUE_351155, Ccy.CNY),
                branchCcyRecord(TranBranch.VALUE_351155, Ccy.USD)));

        ST055OutputBO first = pbc.execute(inputOf(TranBranch.VALUE_351155, Ccy.CNY));
        ST055OutputBO second = pbc.execute(inputOf(TranBranch.VALUE_351155, Ccy.JPY));

        assertTrue(first.isSucceed());
        assertNull(first.getErrorCode());
        assertFalse(second.isSucceed());
        assertEquals("ER0047", second.getErrorCode());
    }

    // ST055-TC004：REQ-004-S01 / REQ-004-S02 机构已配 CNY、USD，待检查 JPY 不在列表内 → errorCode 恰为 "ER0047"
    @Test
    void testST055T04() {
        lenient().when(iFmBranchCcyBcc.findByEo(any(FmBranchCcyEO.class))).thenReturn(List.of(
                branchCcyRecord(TranBranch.VALUE_351155, Ccy.CNY),
                branchCcyRecord(TranBranch.VALUE_351155, Ccy.USD)));

        ST055OutputBO output = pbc.execute(inputOf(TranBranch.VALUE_351155, Ccy.JPY));

        assertFalse(output.isSucceed());
        assertEquals("ER0047", output.getErrorCode());
    }

    // ST055-TC005：REQ-005-S02 机构无币种配置（查询无匹配记录，列表为空集）→ 返回 ER0047，不抛异常、不以“通过”兜底
    @Test
    void testST055T05() {
        lenient().when(iFmBranchCcyBcc.findByEo(any(FmBranchCcyEO.class))).thenReturn(List.of());

        ST055OutputBO output = assertDoesNotThrow(() -> {
            return pbc.execute(inputOf(TranBranch.VALUE_351156, Ccy.CNY));
        });

        assertFalse(output.isSucceed());
        assertEquals("ER0047", output.getErrorCode());
    }

    // ST055-TC006：REQ-002-S01 查询条件为归属机构号 = tranBranch 且不含币种，未把待检查币种当作查询条件
    @Test
    void testST055T06() {
        AtomicReference<FmBranchCcyEO> captured = new AtomicReference<>();
        lenient().when(iFmBranchCcyBcc.findByEo(any(FmBranchCcyEO.class))).thenAnswer(invocation -> {
            captured.set(invocation.getArgument(0));
            return List.of(branchCcyRecord(TranBranch.VALUE_351155, Ccy.CNY));
        });

        ST055OutputBO output = pbc.execute(inputOf(TranBranch.VALUE_351155, Ccy.CNY));

        assertEquals(TranBranch.VALUE_351155, captured.get().getBranch());
        assertNull(captured.get().getCcy());
        assertTrue(output.isSucceed());
    }

    // ST055-TC007：REQ-005-S01 遍历 Ccy 全部 12 个成员逐一检查，结果完备且互斥（2 通过 + 10 失败）
    @Test
    void testST055T07() {
        lenient().when(iFmBranchCcyBcc.findByEo(any(FmBranchCcyEO.class))).thenReturn(List.of(
                branchCcyRecord(TranBranch.VALUE_351155, Ccy.CNY),
                branchCcyRecord(TranBranch.VALUE_351155, Ccy.USD)));

        List<Ccy> configured = List.of(Ccy.CNY, Ccy.USD);
        int passCount = 0;
        int failCount = 0;
        for (Ccy tranCcy : Ccy.values()) {
            ST055OutputBO output = pbc.execute(inputOf(TranBranch.VALUE_351155, tranCcy));
            if (configured.contains(tranCcy)) {
                assertTrue(output.isSucceed());
                assertNull(output.getErrorCode());
                passCount++;
            } else {
                assertFalse(output.isSucceed());
                assertEquals("ER0047", output.getErrorCode());
                failCount++;
            }
        }

        assertEquals(2, passCount);
        assertEquals(10, failCount);
    }

    // ST055-TC008：REQ-004-S01 列表规模下界（恰 1 条记录）的匹配与不匹配两个方向
    @Test
    void testST055T08() {
        lenient().when(iFmBranchCcyBcc.findByEo(any(FmBranchCcyEO.class))).thenReturn(List.of(
                branchCcyRecord(TranBranch.VALUE_351155, Ccy.USD)));

        ST055OutputBO first = pbc.execute(inputOf(TranBranch.VALUE_351155, Ccy.USD));
        ST055OutputBO second = pbc.execute(inputOf(TranBranch.VALUE_351155, Ccy.CNY));

        assertTrue(first.isSucceed());
        assertNull(first.getErrorCode());
        assertFalse(second.isSucceed());
        assertEquals("ER0047", second.getErrorCode());
    }

    // ST055-TC009：REQ-006-S01 / REQ-006-S02 输出字段 ccy 的名称与类型与输出表一致，检查结果以结果状态表达
    @Test
    void testST055T09() throws NoSuchFieldException {
        lenient().when(iFmBranchCcyBcc.findByEo(any(FmBranchCcyEO.class))).thenReturn(List.of(
                branchCcyRecord(TranBranch.VALUE_351155, Ccy.CNY)));

        ST055OutputBO output = pbc.execute(inputOf(TranBranch.VALUE_351155, Ccy.CNY));

        assertInstanceOf(ST055OutputBO.class, output);
        assertEquals(Ccy.class, ST055OutputBO.class.getDeclaredField("ccy").getType());
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
    }

    // ST055-TC010：REQ-002-S01 列表规模上界（12 条记录全部匹配）时任一 tranCcy 均通过
    @Test
    void testST055T10() {
        List<FmBranchCcyEO> allRecords = new ArrayList<>();
        for (Ccy ccy : Ccy.values()) {
            allRecords.add(branchCcyRecord(TranBranch.VALUE_351155, ccy));
        }
        lenient().when(iFmBranchCcyBcc.findByEo(any(FmBranchCcyEO.class))).thenReturn(allRecords);

        ST055OutputBO output = pbc.execute(inputOf(TranBranch.VALUE_351155, Ccy.EUR));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }
}
