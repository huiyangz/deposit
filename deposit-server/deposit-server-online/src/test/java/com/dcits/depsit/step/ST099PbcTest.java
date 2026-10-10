package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.depsit.enums.SettleAcctClass;
import com.dcits.depsit.facade.bo.ST099InputBO;
import com.dcits.depsit.facade.bo.ST099OutputBO;

/**
 * ST099 检查利息资本化标志的单元测试。
 *
 * <p>调用签名：{@code ST099OutputBO execute(ST099InputBO input)}；本步骤为纯入参判定，
 * 无 BCC/EO、规则或跨组件调用，故全部用例不设桩，直接以真实实例执行。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST099PbcTest {

    @InjectMocks
    private ST099Pbc pbc;

    // ST099-TC001：REQ-001-S01 标志不等于「N-否」（"Y"）且结算账户类型为付款账户时返回「通过」，子步骤 1 即结束
    @Test
    void testST099T01() {
        ST099InputBO input = new ST099InputBO();
        input.setIntCapFlag("Y");
        input.setSettleAcctClass(SettleAcctClass.PAY);

        ST099OutputBO out = pbc.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
    }

    // ST099-TC002：REQ-001-S02 标志不等于「N-否」时即便结算账户类型为利息入账账户仍返回「通过」，判定不依赖该入参
    @Test
    void testST099T02() {
        ST099InputBO input = new ST099InputBO();
        input.setIntCapFlag("Y");
        input.setSettleAcctClass(SettleAcctClass.INT);

        ST099OutputBO out = pbc.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
    }

    // ST099-TC003：REQ-003-S01／REQ-005-S01／REQ-004-S01 标志取码值 "N" 判定为等于「N-否」，结算账户类型为 INT 时检查通过
    @Test
    void testST099T03() {
        ST099InputBO input = new ST099InputBO();
        input.setIntCapFlag("N");
        input.setSettleAcctClass(SettleAcctClass.INT);

        ST099OutputBO out = pbc.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
    }

    // ST099-TC004：REQ-002-S01 标志为「N-否」且结算账户类型为付款账户时返回错误码 ER0034，不返回「通过」
    @Test
    void testST099T04() {
        ST099InputBO input = new ST099InputBO();
        input.setIntCapFlag("N");
        input.setSettleAcctClass(SettleAcctClass.PAY);

        ST099OutputBO out = pbc.execute(input);

        assertFalse(out.isSucceed());
        assertEquals("ER0034", out.getErrorCode());
    }

    // ST099-TC005：REQ-002-S02 结算账户类型为中文注释含「利息入账账户」字样的其它成员时仍返回 ER0034
    @Test
    void testST099T05() {
        ST099InputBO input = new ST099InputBO();
        input.setIntCapFlag("N");
        input.setSettleAcctClass(SettleAcctClass.CON);

        ST099OutputBO out = pbc.execute(input);

        assertFalse(out.isSucceed());
        assertEquals("ER0034", out.getErrorCode());
    }

    // ST099-TC006：REQ-004-S02 码值不等于 "INT" 的成员（以本金入账账户为例）一律判定为不为「INT-利息入账账户」，返回 ER0034
    @Test
    void testST099T06() {
        ST099InputBO input = new ST099InputBO();
        input.setIntCapFlag("N");
        input.setSettleAcctClass(SettleAcctClass.PRI);

        ST099OutputBO out = pbc.execute(input);

        assertFalse(out.isSucceed());
        assertEquals("ER0034", out.getErrorCode());
    }

    // ST099-TC007：REQ-004 枚举取值域穷尽，标志为「N-否」时遍历全部成员，仅 INT 得「通过」，其余一律得 ER0034
    @Test
    void testST099T07() {
        for (SettleAcctClass member : SettleAcctClass.values()) {
            ST099InputBO input = new ST099InputBO();
            input.setIntCapFlag("N");
            input.setSettleAcctClass(member);

            ST099OutputBO out = pbc.execute(input);

            if (member == SettleAcctClass.INT) {
                assertTrue(out.isSucceed(), member.name());
                assertNull(out.getErrorCode(), member.name());
                assertNull(out.getErrorMessage(), member.name());
            } else {
                assertFalse(out.isSucceed(), member.name());
                assertEquals("ER0034", out.getErrorCode(), member.name());
            }
        }
    }
}
