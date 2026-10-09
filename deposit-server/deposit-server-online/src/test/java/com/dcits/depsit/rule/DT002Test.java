package com.dcits.depsit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.depsit.enums.AcctStatus;
import org.junit.jupiter.api.Test;

/**
 * DT002 检查账户是否能够入账 单元测试。
 *
 * 期望结果取自正式 Spec 的分支 a–f 决策行与需求场景，不根据实现反推。
 * 用例覆盖分支 a–e 的正常出口、不匹配所列分支时由默认分支 f 兜底的否定场景，
 * 以及输出取值域限定。
 */
class DT002Test {

    // DT002-TC001 正常路径：新建状态、两个标志均为“否”，命中分支 a，返回“允许”。
    @Test
    void test_01() {
        assertEquals("允许", DT002.execute(AcctStatus.N, "N", "N"));
    }

    // DT002-TC002 边界否定路径：新建状态、两个标志均为“是”，分支 a 不含标志条件，仍返回“允许”。
    @Test
    void test_02() {
        assertEquals("允许", DT002.execute(AcctStatus.N, "Y", "Y"));
    }

    // DT002-TC003 正常路径：待激活且止付=是、不收不付=否，命中分支 b，返回“允许”。
    @Test
    void test_03() {
        assertEquals("允许", DT002.execute(AcctStatus.H, "Y", "N"));
    }

    // DT002-TC004 正常路径：活动且两个标志均为“否”，命中分支 c，返回“允许”。
    @Test
    void test_04() {
        assertEquals("允许", DT002.execute(AcctStatus.A, "N", "N"));
    }

    // DT002-TC005 正常路径：久悬且不收不付=否，命中分支 d，返回“不允许”。
    @Test
    void test_05() {
        assertEquals("不允许", DT002.execute(AcctStatus.S, "N", "N"));
    }

    // DT002-TC006 边界否定路径：久悬且不收不付=是，不匹配分支 d，由默认分支 f 返回“不允许”。
    @Test
    void test_06() {
        assertEquals("不允许", DT002.execute(AcctStatus.S, "Y", "Y"));
    }

    // DT002-TC007 正常路径：转营业外且不收不付=否，命中分支 e，返回“不允许”。
    @Test
    void test_07() {
        assertEquals("不允许", DT002.execute(AcctStatus.O, "N", "N"));
    }

    // DT002-TC008 边界否定路径：转营业外且不收不付=是，不匹配分支 e，由默认分支 f 返回“不允许”。
    @Test
    void test_08() {
        assertEquals("不允许", DT002.execute(AcctStatus.O, "Y", "Y"));
    }

    // DT002-TC009 边界否定路径：待激活且止付=否，不匹配分支 b（要求止付="Y"），由默认分支 f 返回“不允许”。
    @Test
    void test_09() {
        assertEquals("不允许", DT002.execute(AcctStatus.H, "N", "N"));
    }

    // DT002-TC010 边界否定路径：待激活且不收不付=是，不匹配分支 b（要求不收不付="N"），由默认分支 f 返回“不允许”。
    @Test
    void test_10() {
        assertEquals("不允许", DT002.execute(AcctStatus.H, "Y", "Y"));
    }

    // DT002-TC011 边界否定路径：活动且止付=是，不匹配分支 c（要求止付="N"），由默认分支 f 返回“不允许”。
    @Test
    void test_11() {
        assertEquals("不允许", DT002.execute(AcctStatus.A, "Y", "N"));
    }

    // DT002-TC012 边界否定路径：活动且不收不付=是，不匹配分支 c（要求不收不付="N"），由默认分支 f 返回“不允许”。
    @Test
    void test_12() {
        assertEquals("不允许", DT002.execute(AcctStatus.A, "N", "Y"));
    }

    // DT002-TC013 边界否定路径：待激活在输入域内剩余的标志组合（止付=否、不收不付=是），由默认分支 f 返回“不允许”。
    @Test
    void test_13() {
        assertEquals("不允许", DT002.execute(AcctStatus.H, "N", "Y"));
    }

    // DT002-TC014 边界否定路径：活动在输入域内剩余的标志组合（两标志均为“是”），由默认分支 f 返回“不允许”。
    @Test
    void test_14() {
        assertEquals("不允许", DT002.execute(AcctStatus.A, "Y", "Y"));
    }

    // DT002-TC015 边界否定路径：关闭状态未被分支 a–e 引用，按默认分支 f 返回“不允许”。
    @Test
    void test_15() {
        assertEquals("不允许", DT002.execute(AcctStatus.C, "N", "N"));
    }

    // DT002-TC016 边界否定路径：睡眠状态未被分支 a–e 引用，按默认分支 f 返回“不允许”。
    @Test
    void test_16() {
        assertEquals("不允许", DT002.execute(AcctStatus.D, "Y", "N"));
    }

    // DT002-TC017 边界否定路径：预开户状态未被分支 a–e 引用，按默认分支 f 返回“不允许”。
    @Test
    void test_17() {
        assertEquals("不允许", DT002.execute(AcctStatus.I, "N", "Y"));
    }

    // DT002-TC018 边界否定路径：逾期状态未被分支 a–e 引用，按默认分支 f 返回“不允许”。
    @Test
    void test_18() {
        assertEquals("不允许", DT002.execute(AcctStatus.P, "Y", "Y"));
    }

    // DT002-TC019 边界否定路径：预销户状态未被分支 a–e 引用，按默认分支 f 返回“不允许”。
    @Test
    void test_19() {
        assertEquals("不允许", DT002.execute(AcctStatus.R, "N", "N"));
    }

    // DT002-TC020 边界否定路径：手工解除状态未被分支 a–e 引用，按默认分支 f 返回“不允许”。
    @Test
    void test_20() {
        assertEquals("不允许", DT002.execute(AcctStatus.U, "Y", "N"));
    }

    // DT002-TC021 边界否定路径：输出取值域限定，返回值属于 {"允许","不允许"}，非 null、非空字符串。
    @Test
    void test_21() {
        String result = DT002.execute(AcctStatus.N, "Y", "N");
        assertEquals("允许", result);
        assertNotNull(result);
        assertTrue("允许".equals(result) || "不允许".equals(result));
    }
}
