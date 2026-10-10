package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.TermType;
import com.dcits.depsit.facade.bo.ST130InputBO;
import com.dcits.depsit.facade.bo.ST130OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST130 登记账户限制信息 单元测试。
 *
 * <p>用例来源：`outputs/测试用例.md` ST130-TC001 至 ST130-TC006，覆盖 Spec REQ-001 至 REQ-005
 * 中可断言的 9 个场景（REQ-003-S02 枚举外码值与 REQ-005-S02 技术异常传播按 Spec
 * 「验收范围与明确不覆盖的事项」第 3 项及技能约束不作可断言用例）。本步骤只有 1 个平铺步骤、
 * 无分支、无循环、无跳转、无提前返回，全部用例走同一条执行路径：8 个输入字段 →
 * 一次登记写入 → 成功结果，差异只在输入取值与断言侧重。</p>
 *
 * <p>桩点：本步骤唯一的数据访问依赖是 {@link IRbBusRestraintsBcc} 的登记写入能力，
 * 用例对 {@code create(RbBusRestraintsEO)} 与 {@code createSelective(RbBusRestraintsEO)}
 * 都作捕获（实现择一即被记录，另一处用 {@code lenient()} 避免未使用桩失败），
 * 以登记簿列表作为业务可观察数据。{@link RbBusRestraintsEO} 未实现 {@code equals}，
 * 故用 {@code thenAnswer} 取 {@code getArgument(0)} 捕获写入对象，不按对象等值匹配。
 * 查询、更新、删除方法与 {@code tranDate}／{@code runDate} 的落库均不在本步骤业务范围内
 * （Spec「### 依赖调用」与「验收范围与明确不覆盖的事项」第 4 项），不为其设桩、不作断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST130PbcTest {

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @InjectMocks
    private ST130Pbc pbc;

    /**
     * 对登记写入设桩：把实现构造的登记对象收进登记簿列表并返回影响行数 1。
     *
     * <p>{@code create} 与 {@code createSelective} 两种写入方法都捕获，实现择一即被记录；
     * 二者都被调用时登记簿会出现 2 条记录，由各用例的条数断言发现。</p>
     *
     * @return 登记簿桩：本步骤写入的记录集合
     */
    private List<RbBusRestraintsEO> stubRegister() {
        List<RbBusRestraintsEO> records = new ArrayList<>();
        lenient().when(rbBusRestraintsBcc.create(any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    records.add(invocation.getArgument(0));
                    return 1;
                });
        lenient().when(rbBusRestraintsBcc.createSelective(any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    records.add(invocation.getArgument(0));
                    return 1;
                });
        return records;
    }

    /**
     * 按 Spec REQ-001-S01 的示例构造 8 个输入字段。
     *
     * @return 示例输入 BO
     */
    private ST130InputBO sampleInput() {
        ST130InputBO input = new ST130InputBO();
        input.setBaseAcctNo("1100101001000000123");
        input.setRestraintType(RestraintType.VALUE_6);
        input.setStartDate(Timestamp.valueOf("2026-10-10 09:00:00.000"));
        input.setEndDate(Timestamp.valueOf("2027-10-10 09:00:00.000"));
        input.setTerm("12");
        input.setTermType(TermType.M);
        input.setTranDate(Timestamp.valueOf("2026-10-10 09:00:00.000"));
        input.setRunDate(Timestamp.valueOf("2026-10-10 00:00:00.000"));
        return input;
    }

    /** REQ-001-S01、REQ-002-S01、REQ-002-S03、REQ-003-S01、REQ-004-S01、REQ-005-S01：示例 8 字段登记为一条记录，6 个业务列逐位一致（ST130-TC001）。 */
    @Test
    void testST130T01() {
        List<RbBusRestraintsEO> records = stubRegister();
        ST130InputBO input = sampleInput();

        ST130OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());

        // 单次调用只登记这一条记录，正文列举且存在输入对应的 6 项全部落列、无遗漏、无表外字段
        assertEquals(1, records.size());
        RbBusRestraintsEO written = records.get(0);
        assertEquals("1100101001000000123", written.getBaseAcctNo());
        assertSame(RestraintType.VALUE_6, written.getRestraintType());
        assertEquals("6", written.getRestraintType().getValue());
        assertEquals(Timestamp.valueOf("2026-10-10 09:00:00.000"), written.getStartDate());
        assertEquals(Timestamp.valueOf("2027-10-10 09:00:00.000"), written.getEndDate());
        assertEquals("12", written.getTerm());
        assertSame(TermType.M, written.getTermType());
        assertEquals("M", written.getTermType().getValue());

        // 输入侧承载口径：4 个日期字段为 java.util.Date，两个枚举字段以枚举常量承载
        assertInstanceOf(Date.class, input.getStartDate());
        assertInstanceOf(Date.class, input.getEndDate());
        assertInstanceOf(Date.class, input.getTranDate());
        assertInstanceOf(Date.class, input.getRunDate());
        assertSame(RestraintType.VALUE_6, input.getRestraintType());
        assertSame(TermType.M, input.getTermType());
    }

    /** REQ-002-S02：登记簿已有同一账号、限制类型 13 的其它记录时，仅新增本笔、既有记录不被改写（ST130-TC002）。 */
    @Test
    void testST130T02() {
        List<RbBusRestraintsEO> records = stubRegister();
        RbBusRestraintsEO existing = new RbBusRestraintsEO();
        existing.setBaseAcctNo("1100101001000000123");
        existing.setRestraintType(RestraintType.VALUE_13);
        existing.setStartDate(Timestamp.valueOf("2026-01-10 09:00:00.000"));
        existing.setEndDate(Timestamp.valueOf("2026-12-31 09:00:00.000"));
        existing.setTerm("6");
        existing.setTermType(TermType.M);
        records.add(existing);

        ST130OutputBO result = pbc.execute(sampleInput());

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());

        // 记录条数由 1 变为 2：只新增本次登记，未更新或删除既有记录
        assertEquals(2, records.size());
        RbBusRestraintsEO kept = records.get(0);
        assertSame(existing, kept);
        assertEquals("1100101001000000123", kept.getBaseAcctNo());
        assertSame(RestraintType.VALUE_13, kept.getRestraintType());
        assertEquals(Timestamp.valueOf("2026-01-10 09:00:00.000"), kept.getStartDate());
        assertEquals(Timestamp.valueOf("2026-12-31 09:00:00.000"), kept.getEndDate());
        assertEquals("6", kept.getTerm());
        assertSame(TermType.M, kept.getTermType());

        // 新增记录的 6 项取值等于本次输入
        RbBusRestraintsEO added = records.get(1);
        assertEquals("1100101001000000123", added.getBaseAcctNo());
        assertSame(RestraintType.VALUE_6, added.getRestraintType());
        assertEquals(Timestamp.valueOf("2026-10-10 09:00:00.000"), added.getStartDate());
        assertEquals(Timestamp.valueOf("2027-10-10 09:00:00.000"), added.getEndDate());
        assertEquals("12", added.getTerm());
        assertSame(TermType.M, added.getTermType());
    }

    /** REQ-001-S02：只提供「## 输入」表 8 个字段即可完成登记，登记内容全部可追溯到这 8 个字段（ST130-TC003）。 */
    @Test
    void testST130T03() {
        List<RbBusRestraintsEO> records = stubRegister();
        ST130InputBO input = sampleInput();

        ST130OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());

        assertEquals(1, records.size());
        RbBusRestraintsEO written = records.get(0);
        assertEquals(input.getBaseAcctNo(), written.getBaseAcctNo());
        assertSame(input.getRestraintType(), written.getRestraintType());
        assertEquals(input.getStartDate(), written.getStartDate());
        assertEquals(input.getEndDate(), written.getEndDate());
        assertEquals(input.getTerm(), written.getTerm());
        assertSame(input.getTermType(), written.getTermType());
    }

    /** REQ-004-S02：存期期限按原值登记，不补零、不截断、不因周期类型 M 被联动换算（ST130-TC004）。 */
    @Test
    void testST130T04() {
        List<RbBusRestraintsEO> records = stubRegister();
        ST130InputBO input = sampleInput();
        input.setTerm("36");

        ST130OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());

        assertEquals(1, records.size());
        RbBusRestraintsEO written = records.get(0);
        assertEquals("36", written.getTerm());
        assertSame(TermType.M, written.getTermType());
        assertEquals("M", written.getTermType().getValue());
    }

    /** REQ-003-S01、REQ-004-S01、REQ-004-S02：非数值码值 DX1 与域边界 D 按常量码值原样登记，不转中文、不映射（ST130-TC005）。 */
    @Test
    void testST130T05() {
        List<RbBusRestraintsEO> records = stubRegister();
        ST130InputBO input = new ST130InputBO();
        input.setBaseAcctNo("1100101001000000999");
        input.setRestraintType(RestraintType.DX1);
        input.setStartDate(Timestamp.valueOf("2026-10-05 14:45:00.000"));
        input.setEndDate(Timestamp.valueOf("2026-10-06 14:45:00.000"));
        input.setTerm("1");
        input.setTermType(TermType.D);
        input.setTranDate(Timestamp.valueOf("2026-10-05 14:45:00.000"));
        input.setRunDate(Timestamp.valueOf("2026-10-05 00:00:00.000"));

        ST130OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());

        assertEquals(1, records.size());
        RbBusRestraintsEO written = records.get(0);
        assertSame(RestraintType.DX1, written.getRestraintType());
        assertEquals("DX1", written.getRestraintType().getValue());
        assertSame(TermType.D, written.getTermType());
        assertEquals("D", written.getTermType().getValue());
        assertEquals("1", written.getTerm());
    }

    /** REQ-005-S01：第二组合法取值（限制类型 52、周期类型 Y）下同样正常完成，成功状态不由具体取值决定（ST130-TC006）。 */
    @Test
    void testST130T06() {
        List<RbBusRestraintsEO> records = stubRegister();
        ST130InputBO input = new ST130InputBO();
        input.setBaseAcctNo("6222020202000000456");
        input.setRestraintType(RestraintType.VALUE_52);
        input.setStartDate(Timestamp.valueOf("2026-12-01 00:00:00.000"));
        input.setEndDate(Timestamp.valueOf("2028-12-01 00:00:00.000"));
        input.setTerm("2");
        input.setTermType(TermType.Y);
        input.setTranDate(Timestamp.valueOf("2026-12-01 00:00:00.000"));
        input.setRunDate(Timestamp.valueOf("2026-12-01 00:00:00.000"));

        ST130OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());

        assertEquals(1, records.size());
        RbBusRestraintsEO written = records.get(0);
        assertEquals("6222020202000000456", written.getBaseAcctNo());
        assertEquals("52", written.getRestraintType().getValue());
        assertEquals(Timestamp.valueOf("2026-12-01 00:00:00.000"), written.getStartDate());
        assertEquals(Timestamp.valueOf("2028-12-01 00:00:00.000"), written.getEndDate());
        assertEquals("2", written.getTerm());
        assertEquals("Y", written.getTermType().getValue());
    }
}
