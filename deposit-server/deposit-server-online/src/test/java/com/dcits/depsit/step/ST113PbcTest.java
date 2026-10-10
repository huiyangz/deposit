package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST113InputBO;
import com.dcits.depsit.facade.bo.ST113OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST113 检查有权机关冻结限制 单元测试。
 *
 * <p>用例来源：`outputs/测试用例.md` / `outputs/测试用例.json` 的 ST113-TC001 至 ST113-TC011
 * （`testST113T01`–`T11`），覆盖 Spec REQ-001 至 REQ-008 的已定义分支：单条命中取值并核对查询条件、
 * 零条与仅有非 A 记录的直接返回、逐条按记录自身限制类型取值且不跨记录复用、配置取值为码值 `"N"`／空值
 * 的不表示、该限制类型无 A-生效 配置（无记录／状态非 `"A"`）、多条任一条表示即取该值返回、
 * 全部不表示不赋值、结论与记录顺序无关。REQ-008-S01（依赖调用技术异常向上传播）按技能约定
 * 不构造用例（不模拟 BCC／EO 技术异常），由代码审核静态核对实现未捕获异常。</p>
 *
 * <p>桩说明：`IRbBusRestraintsBcc.findByEo` 用过滤型 {@code thenAnswer} 复现 Spec 的取数条件
 * （账号 + 限制状态码值 `"A"`，REQ-002）并捕获入参 EO，使「按账号与限制状态取数」「非 A 记录被排除」
 * 成为可观察结果；`IRbRestraintTypeBcc.findByRestraintType` 按各记录自身的限制类型分别设桩，
 * 使「逐条以记录自身限制类型为查询键、不跨记录复用取值」可被区分。`$有权机关冻结标志$` 按
 * Spec REQ-004 已确认取值域只取字面码值 `"Y"`（表示属于）、`"N"` 与 null（不表示）。</p>
 *
 * <p>结构性限制：测试不验证交互次数或顺序（不使用 {@code verify}/{@code never}/{@code times}），
 * 故 TC002／TC003 的「不再执行子步骤 2」只能由输出为 null 与「未设该桩」共同佐证；TC009／TC011 的
 * 「命中后不再对其余记录继续取值」在「表示」取值唯一（恒为配置原样的 `"Y"`）时与续跑的输出相同，
 * 无法用状态断言区分。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST113PbcTest {

    /** 公共入参：账号 */
    private static final String BASE_ACCT_NO = "6222020200112233";

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST113Pbc st113Pbc;

    /** 子步骤 1 查询条件的捕获引用：由过滤型桩在每次调用时写入，供查询条件断言之用。 */
    private RbBusRestraintsEO capturedCondition;

    // REQ-001-S01 / REQ-001-S02 / REQ-002-S01 / REQ-002-S03 / REQ-004-S01 / REQ-007-S01
    /** 单条 A-生效 记录、其限制类型有 A-生效 配置且取值为码值 "Y" → 取该值原样赋值返回（ST113-TC001）。 */
    @Test
    void testST113T01() {
        stubRestraints(restraintsRow("R202610100001", RestraintType.VALUE_4, RestraintsStatus.A));
        stubRestraintType(RestraintType.VALUE_4, typeConfig(RestraintType.VALUE_4, Status.A, "Y"));

        ST113OutputBO out = st113Pbc.execute(input());

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("Y", out.getAhBuFlag());
        // 查询条件仅以账号 + 限制状态码值 "A" 限定，未附加其它条件
        assertEquals(BASE_ACCT_NO, capturedCondition.getBaseAcctNo());
        assertEquals(RestraintsStatus.A, capturedCondition.getRestraintsStatus());
        assertNull(capturedCondition.getRestraintType());
        assertNull(capturedCondition.getResSeqNo());
    }

    // REQ-003-S01 / REQ-007-S02
    /** 该账号无任何 A-生效 记录 → 不赋值、不再执行子步骤 2、直接返回（ST113-TC002）。 */
    @Test
    void testST113T02() {
        stubRestraints();

        ST113OutputBO out = st113Pbc.execute(input());

        assertTrue(out.isSucceed());
        assertNull(out.getAhBuFlag());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals(BASE_ACCT_NO, capturedCondition.getBaseAcctNo());
        assertEquals(RestraintsStatus.A, capturedCondition.getRestraintsStatus());
    }

    // REQ-003-S02：兼证 REQ-002 按限制状态收窄
    /** 仅有非 A 限制记录（E 已终止、F 未生效）→ 按 "A" 过滤后结果零条，不赋值、直接返回（ST113-TC003）。 */
    @Test
    void testST113T03() {
        stubRestraints(
                restraintsRow("R202610100002", RestraintType.VALUE_8, RestraintsStatus.E),
                restraintsRow("R202610100003", RestraintType.VALUE_4, RestraintsStatus.F));
        // 预置的非 A 行对应的 A-生效 配置：实现若漏掉限制状态条件会取到 "Y"，本例即在此失败
        stubRestraintType(RestraintType.VALUE_8, typeConfig(RestraintType.VALUE_8, Status.A, "Y"));

        ST113OutputBO out = st113Pbc.execute(input());

        assertTrue(out.isSucceed());
        assertNull(out.getAhBuFlag());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals(RestraintsStatus.A, capturedCondition.getRestraintsStatus());
    }

    // REQ-002-S02 / REQ-004-S02 / REQ-007-S01
    /** 子步骤 1 取回 3 条 A-生效 记录（另 1 条 "E" 记录不在结果内），逐条以记录自身的限制类型为键取值，不跨记录复用（ST113-TC004）。 */
    @Test
    void testST113T04() {
        stubRestraints(
                restraintsRow("R202610100004", RestraintType.VALUE_13, RestraintsStatus.A),
                restraintsRow("R202610100005", RestraintType.VALUE_8, RestraintsStatus.A),
                restraintsRow("R202610100006", RestraintType.VALUE_4, RestraintsStatus.A),
                restraintsRow("R202610100007", RestraintType.VALUE_5, RestraintsStatus.E));
        stubRestraintType(RestraintType.VALUE_13, typeConfig(RestraintType.VALUE_13, Status.A, "N"));
        stubRestraintType(RestraintType.VALUE_8, typeConfig(RestraintType.VALUE_8, Status.A, "N"));
        stubRestraintType(RestraintType.VALUE_4, typeConfig(RestraintType.VALUE_4, Status.A, "Y"));
        // 该桩仅用于暴露「漏掉限制状态条件或误用其它记录的键」的实现：非 A 记录本不应进入子步骤 2
        stubRestraintType(RestraintType.VALUE_5, typeConfig(RestraintType.VALUE_5, Status.A, "Y"));

        ST113OutputBO out = st113Pbc.execute(input());

        assertTrue(out.isSucceed());
        assertEquals("Y", out.getAhBuFlag());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
    }

    // REQ-004-S03 / REQ-007-S02
    /** 唯一 A-生效 记录的限制类型其 A-生效 配置取值为码值 "N" → 判定为不表示、不赋值（ST113-TC005）。 */
    @Test
    void testST113T05() {
        stubRestraints(restraintsRow("R202610100008", RestraintType.VALUE_13, RestraintsStatus.A));
        stubRestraintType(RestraintType.VALUE_13, typeConfig(RestraintType.VALUE_13, Status.A, "N"));

        ST113OutputBO out = st113Pbc.execute(input());

        assertTrue(out.isSucceed());
        assertNull(out.getAhBuFlag());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
    }

    // REQ-004-S04 / REQ-007-S02
    /** 唯一 A-生效 记录的限制类型其 A-生效 配置取值为空值 → 判定为不表示、不赋值、不写默认值（ST113-TC006）。 */
    @Test
    void testST113T06() {
        stubRestraints(restraintsRow("R202610100009", RestraintType.VALUE_13, RestraintsStatus.A));
        stubRestraintType(RestraintType.VALUE_13, typeConfig(RestraintType.VALUE_13, Status.A, null));

        ST113OutputBO out = st113Pbc.execute(input());

        assertTrue(out.isSucceed());
        assertNull(out.getAhBuFlag());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
    }

    // REQ-005-S01（无记录形态）/ REQ-007-S02
    /** 唯一的 A-生效 记录其限制类型在【限制类型表】无任何记录 → 不构成、不按该类型返回值、不赋值、无默认值（ST113-TC007）。 */
    @Test
    void testST113T07() {
        stubRestraints(restraintsRow("R202610100010", RestraintType.VALUE_13, RestraintsStatus.A));
        stubRestraintType(RestraintType.VALUE_13, null);

        ST113OutputBO out = st113Pbc.execute(input());

        assertTrue(out.isSucceed());
        assertNull(out.getAhBuFlag());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
    }

    // REQ-005-S01（状态非 A）/ REQ-007-S02
    /** 唯一的 A-生效 记录其限制类型存在记录但 $状态$ 非 "A"（F 无效）→ 同样不构成、不按该配置取值、不赋值（ST113-TC008）。 */
    @Test
    void testST113T08() {
        stubRestraints(restraintsRow("R202610100011", RestraintType.VALUE_13, RestraintsStatus.A));
        stubRestraintType(RestraintType.VALUE_13, typeConfig(RestraintType.VALUE_13, Status.F, "Y"));

        ST113OutputBO out = st113Pbc.execute(input());

        assertTrue(out.isSucceed());
        assertNull(out.getAhBuFlag());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
    }

    // REQ-005-S02 / REQ-006-S01 / REQ-007-S01
    /** 3 条 A-生效 记录（无 A-生效 配置、表示、不表示）→ 任一条表示即取该值返回，其余不阻止判定也不改写输出（ST113-TC009）。 */
    @Test
    void testST113T09() {
        stubRestraints(
                restraintsRow("R202610100012", RestraintType.VALUE_13, RestraintsStatus.A),
                restraintsRow("R202610100013", RestraintType.VALUE_4, RestraintsStatus.A),
                restraintsRow("R202610100014", RestraintType.VALUE_8, RestraintsStatus.A));
        stubRestraintType(RestraintType.VALUE_13, null);
        stubRestraintType(RestraintType.VALUE_4, typeConfig(RestraintType.VALUE_4, Status.A, "Y"));
        stubRestraintType(RestraintType.VALUE_8, typeConfig(RestraintType.VALUE_8, Status.A, "N"));

        ST113OutputBO out = st113Pbc.execute(input());

        assertTrue(out.isSucceed());
        assertEquals("Y", out.getAhBuFlag());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
    }

    // REQ-005-S02 / REQ-006-S02 / REQ-007-S02
    /** 3 条 A-生效 记录全部不表示（配置取值 "N"、无 A-生效 配置、配置取值为空值）→ 不赋值、无默认值（ST113-TC010）。 */
    @Test
    void testST113T10() {
        stubRestraints(
                restraintsRow("R202610100015", RestraintType.VALUE_8, RestraintsStatus.A),
                restraintsRow("R202610100016", RestraintType.VALUE_13, RestraintsStatus.A),
                restraintsRow("R202610100017", RestraintType.VALUE_6, RestraintsStatus.A));
        stubRestraintType(RestraintType.VALUE_8, typeConfig(RestraintType.VALUE_8, Status.A, "N"));
        stubRestraintType(RestraintType.VALUE_13, null);
        stubRestraintType(RestraintType.VALUE_6, typeConfig(RestraintType.VALUE_6, Status.A, null));

        ST113OutputBO out = st113Pbc.execute(input());

        assertTrue(out.isSucceed());
        assertNull(out.getAhBuFlag());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
    }

    // REQ-006-S01 / REQ-006-S03 / REQ-007-S01
    /** 与 TC009 同记录同配置、表示属于有权机关冻结的记录位于末位 → 结论与位置／遍历顺序无关（ST113-TC011）。 */
    @Test
    void testST113T11() {
        stubRestraints(
                restraintsRow("R202610100014", RestraintType.VALUE_8, RestraintsStatus.A),
                restraintsRow("R202610100012", RestraintType.VALUE_13, RestraintsStatus.A),
                restraintsRow("R202610100013", RestraintType.VALUE_4, RestraintsStatus.A));
        stubRestraintType(RestraintType.VALUE_8, typeConfig(RestraintType.VALUE_8, Status.A, "N"));
        stubRestraintType(RestraintType.VALUE_13, null);
        stubRestraintType(RestraintType.VALUE_4, typeConfig(RestraintType.VALUE_4, Status.A, "Y"));

        ST113OutputBO out = st113Pbc.execute(input());

        assertTrue(out.isSucceed());
        assertEquals("Y", out.getAhBuFlag());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
    }

    /**
     * 按 Spec 的取数条件（账号 + 限制状态码值 "A"）过滤预置记录：入参 EO 中设置了哪个条件就按哪个条件
     * 过滤，实现漏掉条件时结果随之变化，使查询条件可观察；同时把入参 EO 存入
     * {@link #capturedCondition} 供断言。
     */
    private void stubRestraints(RbBusRestraintsEO... rows) {
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenAnswer(invocation -> {
            RbBusRestraintsEO condition = invocation.getArgument(0);
            capturedCondition = condition;
            List<RbBusRestraintsEO> matched = new ArrayList<>();
            for (RbBusRestraintsEO row : rows) {
                if (Objects.equals(condition.getBaseAcctNo(), row.getBaseAcctNo())
                        && condition.getRestraintsStatus() == row.getRestraintsStatus()) {
                    matched.add(row);
                }
            }
            return matched;
        });
    }

    /** 桩【限制类型表】：按账户限制类型主键取单条，无该类型记录时返回 null。 */
    private void stubRestraintType(RestraintType restraintType, RbRestraintTypeEO config) {
        lenient().when(rbRestraintTypeBcc.findByRestraintType(restraintType)).thenReturn(config);
    }

    /** 构造【账户限制信息】预置记录。 */
    private static RbBusRestraintsEO restraintsRow(String resSeqNo, RestraintType restraintType,
            RestraintsStatus restraintsStatus) {
        RbBusRestraintsEO eo = new RbBusRestraintsEO();
        eo.setResSeqNo(resSeqNo);
        eo.setBaseAcctNo(BASE_ACCT_NO);
        eo.setRestraintType(restraintType);
        eo.setRestraintsStatus(restraintsStatus);
        return eo;
    }

    /** 构造【限制类型表】预置配置。 */
    private static RbRestraintTypeEO typeConfig(RestraintType restraintType, Status status, String ahBuFlag) {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(restraintType);
        eo.setStatus(status);
        eo.setAhBuFlag(ahBuFlag);
        return eo;
    }

    /** 构造本步骤入参。 */
    private static ST113InputBO input() {
        ST113InputBO input = new ST113InputBO();
        input.setBaseAcctNo(BASE_ACCT_NO);
        return input;
    }
}
