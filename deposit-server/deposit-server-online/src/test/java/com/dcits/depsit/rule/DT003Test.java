package com.dcits.depsit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.enums.RbBusAcctPurpose;
import org.junit.jupiter.api.Test;

/**
 * DT003 根据核准类型设置账户状态 单元测试（决策类规则）。
 *
 * <p>用例来源：`outputs/测试用例.md` DT003-TC001 至 DT003-TC019，覆盖 Spec REQ-001 至 REQ-007 的已定义分支，
 * 含 REQ-003 两个"不设置账户状态"分支与 REQ-007 兜底分支。另按代码审核意见补充 2 个用例（test_20、test_21），
 * 补齐 REQ-002 中（境内×否）与（境外×是）两组组合，使"无条件取新建"与"误复制基本户组合判定"两种实现可区分。</p>
 *
 * <p>REQ-005-S03（临时户、境外、企业标志为"是"）与 REQ-006-S03（验资户、境外、企业标志为"是"）的源需求取值"无"
 * 不是 `com.dcits.depsit.enums.AcctStatus` 的合法成员，Spec 明确该两分支在业务确认取值前不可执行、不作为可断言的
 * 验收结果，候选方案 A（留空）/ B（新建）均未被需求采纳，故本轮不为其生成用例，待确认后补出。</p>
 */
class DT003Test {

    /** 用例样本用途：预算单位专用存款户（代码 4），用于验证非专用户分支不受用途影响。 */
    private static final RbBusAcctPurpose SAMPLE_PURPOSE = RbBusAcctPurpose.VALUE_4;

    // REQ-001 基本户：按境内境外标志与企业标志组合判定
    /** REQ-001-S01 基本户、境内、企业标志＝是 → 新建"新建"（DT003-TC001）。 */
    @Test
    void test_01() {
        assertEquals("N", DT003.execute(AcctNatureNo.VALUE_11001, SAMPLE_PURPOSE, "是", "境内"));
    }

    /** REQ-001-S02 基本户、境内、企业标志＝否 → "预开户"（DT003-TC002）。 */
    @Test
    void test_02() {
        assertEquals("I", DT003.execute(AcctNatureNo.VALUE_11001, SAMPLE_PURPOSE, "否", "境内"));
    }

    /** REQ-001-S03 基本户、境外、企业标志＝是 → "预开户"（DT003-TC003）。 */
    @Test
    void test_03() {
        assertEquals("I", DT003.execute(AcctNatureNo.VALUE_11001, SAMPLE_PURPOSE, "是", "境外"));
    }

    /** REQ-001-S04 基本户、境外、企业标志＝否 → "新建"（DT003-TC004）。 */
    @Test
    void test_04() {
        assertEquals("N", DT003.execute(AcctNatureNo.VALUE_11001, SAMPLE_PURPOSE, "否", "境外"));
    }

    // REQ-002 一般户：无条件"新建"；用途取非 REQ-003 触发值，体现该分支不受其余三项入参影响
    /** REQ-002-S01 一般户、境内、企业标志＝是，用途取"非预算单位专用" → "新建"（DT003-TC005）。 */
    @Test
    void test_05() {
        assertEquals("N", DT003.execute(AcctNatureNo.VALUE_11002, RbBusAcctPurpose.VALUE_3, "是", "境内"));
    }

    /** REQ-002-S02 一般户、境外、企业标志＝否，用途为空 → "新建"，与 TC005 的非空用途取值互补（DT003-TC006）。 */
    @Test
    void test_06() {
        assertEquals("N", DT003.execute(AcctNatureNo.VALUE_11002, null, "否", "境外"));
    }

    // REQ-003 专用户 + 预算单位专用存款户
    /** REQ-003-S01 专用户、用途＝预算单位专用存款户、境内、企业标志＝是 → 不设置账户状态，留空（DT003-TC007）。 */
    @Test
    void test_07() {
        String acctStatus = DT003.execute(AcctNatureNo.VALUE_11004, RbBusAcctPurpose.VALUE_4, "是", "境内");
        assertNull(acctStatus);
        assertNotEquals("N", acctStatus);
        assertNotEquals("I", acctStatus);
    }

    /** REQ-003-S02 专用户、用途＝预算单位专用存款户、境内、企业标志＝否 → "预开户"（DT003-TC008）。 */
    @Test
    void test_08() {
        assertEquals("I", DT003.execute(AcctNatureNo.VALUE_11004, RbBusAcctPurpose.VALUE_4, "否", "境内"));
    }

    /** REQ-003-S03 专用户、用途＝预算单位专用存款户、境外、企业标志＝是 → 不设置账户状态，留空（DT003-TC009）。 */
    @Test
    void test_09() {
        String acctStatus = DT003.execute(AcctNatureNo.VALUE_11004, RbBusAcctPurpose.VALUE_4, "是", "境外");
        assertNull(acctStatus);
        assertNotEquals("N", acctStatus);
        assertNotEquals("I", acctStatus);
    }

    /** REQ-003-S04 专用户、用途＝预算单位专用存款户、境外、企业标志＝否 → "新建"（DT003-TC010）。 */
    @Test
    void test_10() {
        assertEquals("N", DT003.execute(AcctNatureNo.VALUE_11004, RbBusAcctPurpose.VALUE_4, "否", "境外"));
    }

    // REQ-004 专用户 + 用途不为预算单位专用存款户
    /** REQ-004-S01 专用户、用途＝非预算单位专用（其它枚举取值）→ "新建"，不适用留空分支（DT003-TC011）。 */
    @Test
    void test_11() {
        assertEquals("N", DT003.execute(AcctNatureNo.VALUE_11004, RbBusAcctPurpose.VALUE_3, "是", "境内"));
    }

    /** REQ-004-S02 专用户、用途为空（未上送）→ "新建"，空用途不进入 REQ-003 分支（DT003-TC012）。 */
    @Test
    void test_12() {
        assertEquals("N", DT003.execute(AcctNatureNo.VALUE_11004, null, "是", "境外"));
    }

    // REQ-005 临时户
    /** REQ-005-S01 临时户、境内、企业标志＝是 → "新建"（DT003-TC013）。 */
    @Test
    void test_13() {
        assertEquals("N", DT003.execute(AcctNatureNo.VALUE_11003, SAMPLE_PURPOSE, "是", "境内"));
    }

    /** REQ-005-S02 临时户、境内、企业标志＝否 → "预开户"（DT003-TC014）。 */
    @Test
    void test_14() {
        assertEquals("I", DT003.execute(AcctNatureNo.VALUE_11003, SAMPLE_PURPOSE, "否", "境内"));
    }

    /** REQ-005-S04 临时户、境外、企业标志＝否 → "新建"（DT003-TC015）。 */
    @Test
    void test_15() {
        assertEquals("N", DT003.execute(AcctNatureNo.VALUE_11003, SAMPLE_PURPOSE, "否", "境外"));
    }

    // REQ-006 验资户
    /** REQ-006-S01 验资户、境内、企业标志＝是 → "新建"（DT003-TC016）。 */
    @Test
    void test_16() {
        assertEquals("N", DT003.execute(AcctNatureNo.VALUE_17, SAMPLE_PURPOSE, "是", "境内"));
    }

    /** REQ-006-S02 验资户、境内、企业标志＝否 → "新建"（DT003-TC017）。 */
    @Test
    void test_17() {
        assertEquals("N", DT003.execute(AcctNatureNo.VALUE_17, SAMPLE_PURPOSE, "否", "境内"));
    }

    /** REQ-006-S04 验资户、境外、企业标志＝否 → "新建"（DT003-TC018）。 */
    @Test
    void test_18() {
        assertEquals("N", DT003.execute(AcctNatureNo.VALUE_17, SAMPLE_PURPOSE, "否", "境外"));
    }

    // REQ-007 兜底
    /** REQ-007-S01 账户属性＝对公人民币定期存款账户（不属前五类）、用途为空、境外、企业标志＝是 → "新建"（DT003-TC019）。 */
    @Test
    void test_19() {
        assertEquals("N", DT003.execute(AcctNatureNo.VALUE_11005, null, "是", "境外"));
    }

    // REQ-002 补充组合（代码审核 M1）：覆盖"误复制基本户（REQ-001）组合判定"的错误实现会返回"预开户"的两组取值
    /**
     * REQ-002 补充 一般户、境内、企业标志＝否 → "新建"，用途取"非预算单位专用"。
     * 该组合为区分性数据：误复制基本户组合判定的实现在此返回"预开户"（代码 I），本用例即失败。
     */
    @Test
    void test_20() {
        assertEquals("N", DT003.execute(AcctNatureNo.VALUE_11002, RbBusAcctPurpose.VALUE_3, "否", "境内"));
    }

    /**
     * REQ-002 补充 一般户、境外、企业标志＝是 → "新建"，用途为空。
     * 同为区分性数据：误复制基本户组合判定的实现在此返回"预开户"（代码 I），本用例即失败。
     */
    @Test
    void test_21() {
        assertEquals("N", DT003.execute(AcctNatureNo.VALUE_11002, null, "是", "境外"));
    }
}
