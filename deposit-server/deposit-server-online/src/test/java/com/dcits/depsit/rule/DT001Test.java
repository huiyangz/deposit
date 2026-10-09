package com.dcits.depsit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dcits.depsit.enums.AcctStatus;
import org.junit.jupiter.api.Test;

/**
 * DT001 检查账户是否能够出账 单元测试（决策类规则）。
 *
 * <p>用例来源：`outputs/测试用例.md` DT001-TC001 至 DT001-TC031，覆盖「## 规则描述」分支 a1、a2、a3、c、e、f、
 * g 的既有取值域与兜底 h。</p>
 *
 * <p>DT001-TC017 至 DT001-TC024（分支 d 的“正常”、分支 g 的“销户”）的预期结果由源需求确定，但
 * `com.dcits.depsit.enums.AcctStatus` 无“正常”“销户”对应成员，Spec「验收范围与明确不覆盖的事项」第 1 项
 * 要求按源需求状态词表述、不得以近似成员替代，故这 8 个用例的 `acctStatus` 实参当前无法实例化，本轮不生成；
 * 待需求方补充枚举映射后按 test_17 至 test_24 补出。其余 23 个用例均可执行。</p>
 */
class DT001Test {

    // 分支 a1：新建，两个标志均为“否” → 允许
    /** 分支 a1：新建状态且两个标志均为“否”，命中“允许”出口（DT001-TC001，对应 REQ-003-S01）。 */
    @Test
    void test_01() {
        assertEquals("允许", DT001.execute(AcctStatus.N, "否", "否"));
    }

    // 分支 a2：新建，止付标志为“是” → 不允许
    /** 分支 a2：新建状态、止付标志为“是”、不收不付标志为“否”，返回“不允许”（DT001-TC002，对应 REQ-004-S01）。 */
    @Test
    void test_02() {
        assertEquals("不允许", DT001.execute(AcctStatus.N, "是", "否"));
    }

    // 分支 a3：新建，不收不付标志为“是” → 不允许
    /** 分支 a3：新建状态、止付标志为“否”、不收不付标志为“是”，返回“不允许”（DT001-TC003，对应 REQ-005-S01）。 */
    @Test
    void test_03() {
        assertEquals("不允许", DT001.execute(AcctStatus.N, "否", "是"));
    }

    /** 分支 a2 与 a3 条件同时命中：新建状态、两个标志均为“是”，两分支结果一致为“不允许”（DT001-TC004，对应 REQ-004-S02）。 */
    @Test
    void test_04() {
        assertEquals("不允许", DT001.execute(AcctStatus.N, "是", "是"));
    }

    // 分支 c：待激活，止付为“是”且不收不付为“否” → 不允许
    /** 分支 c：待激活状态、止付标志为“是”、不收不付标志为“否”，返回“不允许”（DT001-TC005，对应 REQ-006-S01）。 */
    @Test
    void test_05() {
        assertEquals("不允许", DT001.execute(AcctStatus.H, "是", "否"));
    }

    // 兜底 h：待激活状态未满足分支 c 的组合
    /** 兜底 h：待激活状态、两个标志均为“否”，不满足分支 c，返回“不允许”（DT001-TC006，对应 REQ-011-S01）。 */
    @Test
    void test_06() {
        assertEquals("不允许", DT001.execute(AcctStatus.H, "否", "否"));
    }

    /** 兜底 h：待激活状态、止付为“否”、不收不付为“是”，不满足分支 c 要求的不收不付为“否”，返回“不允许”（DT001-TC007）。 */
    @Test
    void test_07() {
        assertEquals("不允许", DT001.execute(AcctStatus.H, "否", "是"));
    }

    /** 兜底 h：待激活状态、两个标志均为“是”，不满足分支 c，返回“不允许”（DT001-TC008）。 */
    @Test
    void test_08() {
        assertEquals("不允许", DT001.execute(AcctStatus.H, "是", "是"));
    }

    // 分支 e：久悬，不收不付为“是” → 不允许（与止付标志取值无关）
    /** 分支 e：久悬状态、止付为“否”、不收不付为“是”，返回“不允许”（DT001-TC009，对应 REQ-008-S01）。 */
    @Test
    void test_09() {
        assertEquals("不允许", DT001.execute(AcctStatus.S, "否", "是"));
    }

    /** 分支 e：久悬状态、两个标志均为“是”，止付标志取值不影响 e 的结果，仍返回“不允许”（DT001-TC010，对应 REQ-008-S02）。 */
    @Test
    void test_10() {
        assertEquals("不允许", DT001.execute(AcctStatus.S, "是", "是"));
    }

    // 兜底 h：久悬状态未满足分支 e 的组合
    /** 兜底 h：久悬状态、两个标志均为“否”，不满足分支 e，返回“不允许”（DT001-TC011）。 */
    @Test
    void test_11() {
        assertEquals("不允许", DT001.execute(AcctStatus.S, "否", "否"));
    }

    /** 兜底 h：久悬状态、止付为“是”、不收不付为“否”，不满足分支 e，返回“不允许”（DT001-TC012，对应 REQ-011-S02）。 */
    @Test
    void test_12() {
        assertEquals("不允许", DT001.execute(AcctStatus.S, "是", "否"));
    }

    // 分支 f：转营业外，不收不付为“是” → 不允许（与止付标志取值无关）
    /** 分支 f：转营业外状态、止付为“否”、不收不付为“是”，返回“不允许”（DT001-TC013，对应 REQ-009-S01）。 */
    @Test
    void test_13() {
        assertEquals("不允许", DT001.execute(AcctStatus.O, "否", "是"));
    }

    /** 分支 f：转营业外状态、两个标志均为“是”，止付标志取值不影响 f 的结果，仍返回“不允许”（DT001-TC014，对应 REQ-009-S02）。 */
    @Test
    void test_14() {
        assertEquals("不允许", DT001.execute(AcctStatus.O, "是", "是"));
    }

    // 兜底 h：转营业外状态未满足分支 f 的组合
    /** 兜底 h：转营业外状态、两个标志均为“否”，不满足分支 f，返回“不允许”（DT001-TC015）。 */
    @Test
    void test_15() {
        assertEquals("不允许", DT001.execute(AcctStatus.O, "否", "否"));
    }

    /** 兜底 h：转营业外状态、止付为“是”、不收不付为“否”，不满足分支 f，返回“不允许”（DT001-TC016，对应 REQ-011-S03）。 */
    @Test
    void test_16() {
        assertEquals("不允许", DT001.execute(AcctStatus.O, "是", "否"));
    }

    // 兜底 h：规则描述未列出的 AcctStatus 成员
    /** 兜底 h：账户状态为规则描述未列出的 AcctStatus.A（活动），两个标志均为“否”，返回“不允许”（DT001-TC025，对应 REQ-011-S05）。 */
    @Test
    void test_25() {
        assertEquals("不允许", DT001.execute(AcctStatus.A, "否", "否"));
    }

    /** 兜底 h：账户状态为规则描述未列出的 AcctStatus.C（关闭），止付为“是”、不收不付为“否”，返回“不允许”（DT001-TC026）。 */
    @Test
    void test_26() {
        assertEquals("不允许", DT001.execute(AcctStatus.C, "是", "否"));
    }

    /** 兜底 h：账户状态为规则描述未列出的 AcctStatus.D（睡眠），止付为“否”、不收不付为“是”，返回“不允许”（DT001-TC027）。 */
    @Test
    void test_27() {
        assertEquals("不允许", DT001.execute(AcctStatus.D, "否", "是"));
    }

    /** 兜底 h：账户状态为规则描述未列出的 AcctStatus.I（预开户），两个标志均为“是”，返回“不允许”（DT001-TC028）。 */
    @Test
    void test_28() {
        assertEquals("不允许", DT001.execute(AcctStatus.I, "是", "是"));
    }

    /** 兜底 h：账户状态为规则描述未列出的 AcctStatus.P（逾期），两个标志均为“否”，返回“不允许”（DT001-TC029）。 */
    @Test
    void test_29() {
        assertEquals("不允许", DT001.execute(AcctStatus.P, "否", "否"));
    }

    /** 兜底 h：账户状态为规则描述未列出的 AcctStatus.R（预销户），止付为“是”、不收不付为“否”，返回“不允许”（DT001-TC030）。 */
    @Test
    void test_30() {
        assertEquals("不允许", DT001.execute(AcctStatus.R, "是", "否"));
    }

    /** 兜底 h：账户状态为规则描述未列出的 AcctStatus.U（手工解除），止付为“否”、不收不付为“是”，返回“不允许”（DT001-TC031）。 */
    @Test
    void test_31() {
        assertEquals("不允许", DT001.execute(AcctStatus.U, "否", "是"));
    }
}
