package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.enums.RbBusAcctPurpose;
import com.dcits.depsit.facade.bo.ST098InputBO;
import com.dcits.depsit.facade.bo.ST098OutputBO;

/**
 * ST098 检查账户用途 单元测试。
 *
 * <p>用例与 {@code outputs/测试用例.md} 的 ST098-TC001～TC027 一一对应，经被测实例的
 * {@code execute(input)} 验证业务结果，不断言交互次数与顺序。</p>
 *
 * <p>桩说明：本步骤为无状态纯判断——源需求「## 输入」表「来源实体」列均为空，四个值由调用方在
 * 同一次检查中提供，无 BCC、EO、规则、组件内步骤与跨组件客户端依赖，故全部用例均不设桩、不创建
 * Mock，被测步骤按真实逻辑执行。判定只按可观察的 {@code succeed}／{@code errorCode} 断言；
 * {@code errorMessage} 文本源需求未规定，不作等值断言。{@code acctCcy} 取空及「为空」的
 * {@code null}／空字符串形态区分属 Spec「验收范围与明确不覆盖的事项」第 3 项，不构造用例。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST098PbcTest {

    /** 非空核准件编号示例值（Spec 明文标注为示例值，非规范常量） */
    private static final String APPR_LETTER_NO = "APP20261009001";

    @InjectMocks
    private ST098Pbc pbc;

    // TC001 错误码路径：资本项下人民币账户、核准件编号为空，账户属性本会分派至子步骤 6，子步骤 1 先行命中 ER0012 并短路。
    @Test
    void testST098T01() {
        ST098InputBO input = input(AcctCcy.CNY, RbBusAcctPurpose.VALUE_501, null, AcctNatureNo.VALUE_11004);

        ST098OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0012", result.getErrorCode());
    }

    // TC002 错误码路径：子步骤 1、2 的错误条件同时成立（核准件编号与账户属性均为空），返回次序在先者 ER0012。
    @Test
    void testST098T02() {
        ST098InputBO input = input(AcctCcy.CNY, RbBusAcctPurpose.VALUE_501, null, null);

        ST098OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0012", result.getErrorCode());
    }

    // TC003 错误码路径：资本项下人民币账户、核准件编号非空但账户属性为空，子步骤 2 命中 ER0013。
    @Test
    void testST098T03() {
        ST098InputBO input = input(AcctCcy.CNY, RbBusAcctPurpose.VALUE_501, APPR_LETTER_NO, null);

        ST098OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0013", result.getErrorCode());
    }

    // TC004 错误码路径：子步骤 1、2 依次通过后分派至子步骤 4，基本存款账户 + 资本项下用途判定不通过，仅返回 ER0014。
    @Test
    void testST098T04() {
        ST098InputBO input = input(AcctCcy.CNY, RbBusAcctPurpose.VALUE_501, APPR_LETTER_NO, AcctNatureNo.VALUE_11001);

        ST098OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0014", result.getErrorCode());
    }

    // TC005 正常路径：币种非人民币使子步骤 1、2 条件均不成立，账户属性为空按子步骤 3d 返回「通过」。
    @Test
    void testST098T05() {
        ST098InputBO input = input(AcctCcy.USD, RbBusAcctPurpose.VALUE_501, null, null);

        ST098OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // TC006 正常路径：币种为人民币但账户用途非资本项下，子步骤 1、2 条件不成立，账户属性为空返回「通过」（核准件编号为空亦不报错）。
    @Test
    void testST098T06() {
        ST098InputBO input = input(AcctCcy.CNY, RbBusAcctPurpose.VALUE_0, null, null);

        ST098OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // TC007 正常路径：三个非必填输入全部取空、币种为人民币，按子步骤 3d「或为空」返回「通过」。
    @Test
    void testST098T07() {
        ST098InputBO input = input(AcctCcy.CNY, null, null, null);

        ST098OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // TC008 正常路径：三个枚举字段分别按各自枚举成员传入；账户属性为验资户分派至子步骤 5，用途「无特殊用途」属允许集合。
    @Test
    void testST098T08() {
        ST098InputBO input = input(AcctCcy.USD, RbBusAcctPurpose.VALUE_0, null, AcctNatureNo.VALUE_17);

        ST098OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // TC009 跳转路径：账户属性为「临时存款账户」，明文的「其它取值」由子步骤 3d 返回「通过」，不因名称含「临时」分派至子步骤 5。
    @Test
    void testST098T09() {
        ST098InputBO input = input(AcctCcy.USD, null, null, AcctNatureNo.VALUE_11003);

        ST098OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // TC010 跳转路径：账户属性为四类判定成员以外的已定义取值 «0»（无特殊用途·外汇账户性质），子步骤 3d 返回「通过」。
    @Test
    void testST098T10() {
        ST098InputBO input = input(AcctCcy.USD, null, null, AcctNatureNo.VALUE_0);

        ST098OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // TC011 跳转路径：账户属性为四类判定成员以外的已定义取值 «18»（个人外币储蓄户），子步骤 3d 返回「通过」。
    @Test
    void testST098T11() {
        ST098InputBO input = input(AcctCcy.USD, null, null, AcctNatureNo.VALUE_18);

        ST098OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // TC012 跳转路径：基本存款账户分派至子步骤 4，用途「注册验资」不为空且不为「无特殊用途」→ ER0014。
    @Test
    void testST098T12() {
        ST098InputBO input = input(AcctCcy.USD, RbBusAcctPurpose.VALUE_1, null, AcctNatureNo.VALUE_11001);

        ST098OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0014", result.getErrorCode());
    }

    // TC013 正常路径：基本存款账户 + 账户用途为空 → 子步骤 4「否则」分支返回「通过」。
    @Test
    void testST098T13() {
        ST098InputBO input = input(AcctCcy.USD, null, null, AcctNatureNo.VALUE_11001);

        ST098OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // TC014 正常路径：一般户分派至子步骤 4，用途「无特殊用途」→ 返回「通过」。
    @Test
    void testST098T14() {
        ST098InputBO input = input(AcctCcy.USD, RbBusAcctPurpose.VALUE_0, null, AcctNatureNo.VALUE_11002);

        ST098OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // TC015 跳转路径：币种非人民币（子步骤 1、2 条件不成立）、一般户 + 用途「资本项下」→ 子步骤 4 判定不通过 ER0014。
    @Test
    void testST098T15() {
        ST098InputBO input = input(AcctCcy.USD, RbBusAcctPurpose.VALUE_501, null, AcctNatureNo.VALUE_11002);

        ST098OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0014", result.getErrorCode());
    }

    // TC016 边界否定路径：一般户 + 用途「投融资性」（不为空且不为「无特殊用途」）→ ER0014。
    @Test
    void testST098T16() {
        ST098InputBO input = input(AcctCcy.USD, RbBusAcctPurpose.VALUE_5, null, AcctNatureNo.VALUE_11002);

        ST098OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0014", result.getErrorCode());
    }

    // TC017 边界否定路径：一般户 + 用途为空 → 「为空」归「通过」，与 TC016 同一条件另一侧。
    @Test
    void testST098T17() {
        ST098InputBO input = input(AcctCcy.USD, null, null, AcctNatureNo.VALUE_11002);

        ST098OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // TC018 正常路径：验资户 + 用途「注册验资」属允许集合 → 返回「通过」。
    @Test
    void testST098T18() {
        ST098InputBO input = input(AcctCcy.USD, RbBusAcctPurpose.VALUE_1, null, AcctNatureNo.VALUE_17);

        ST098OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // TC019 正常路径：验资户 + 用途「增资验资」属允许集合 → 返回「通过」。
    @Test
    void testST098T19() {
        ST098InputBO input = input(AcctCcy.USD, RbBusAcctPurpose.VALUE_2, null, AcctNatureNo.VALUE_17);

        ST098OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // TC020 错误码路径：子步骤 1、2 依次通过后经子步骤 3b 分派至子步骤 5，用途「资本项下」不属于允许集合 → ER0015。
    @Test
    void testST098T20() {
        ST098InputBO input = input(AcctCcy.CNY, RbBusAcctPurpose.VALUE_501, APPR_LETTER_NO, AcctNatureNo.VALUE_17);

        ST098OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0015", result.getErrorCode());
    }

    // TC021 错误码路径：验资户 + 用途「预算单位专用」不属于子步骤 5 允许集合 → ER0015（对照子步骤 6 该值为允许）。
    @Test
    void testST098T21() {
        ST098InputBO input = input(AcctCcy.USD, RbBusAcctPurpose.VALUE_4, null, AcctNatureNo.VALUE_17);

        ST098OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0015", result.getErrorCode());
    }

    // TC022 边界否定路径：验资户 + 账户用途为空（字段非必填，为空是源需求承认的取值情形）→ 空值不属于允许集合，ER0015。
    @Test
    void testST098T22() {
        ST098InputBO input = input(AcctCcy.USD, null, null, AcctNatureNo.VALUE_17);

        ST098OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0015", result.getErrorCode());
    }

    // TC023 正常路径：专用存款账户分派至子步骤 6，用途「预算单位专用」属允许集合 → 返回「通过」。
    @Test
    void testST098T23() {
        ST098InputBO input = input(AcctCcy.USD, RbBusAcctPurpose.VALUE_4, null, AcctNatureNo.VALUE_11004);

        ST098OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // TC024 正常路径：专用存款账户 + 用途「非预算单位专用」属允许集合 → 返回「通过」。
    @Test
    void testST098T24() {
        ST098InputBO input = input(AcctCcy.USD, RbBusAcctPurpose.VALUE_3, null, AcctNatureNo.VALUE_11004);

        ST098OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // TC025 错误码路径：专用存款账户 + 用途「注册验资」不属于允许集合 → ER0016。
    @Test
    void testST098T25() {
        ST098InputBO input = input(AcctCcy.USD, RbBusAcctPurpose.VALUE_1, null, AcctNatureNo.VALUE_11004);

        ST098OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0016", result.getErrorCode());
    }

    // TC026 错误码路径：子步骤 1、2 通过（核准件编号非空）后经子步骤 3c 分派至子步骤 6，用途「资本项下」不属于允许集合 → ER0016。
    @Test
    void testST098T26() {
        ST098InputBO input = input(AcctCcy.CNY, RbBusAcctPurpose.VALUE_501, APPR_LETTER_NO, AcctNatureNo.VALUE_11004);

        ST098OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0016", result.getErrorCode());
    }

    // TC027 边界否定路径：专用存款账户 + 账户用途为空 → 空值不属于允许集合，返回 ER0016。
    @Test
    void testST098T27() {
        ST098InputBO input = input(AcctCcy.USD, null, null, AcctNatureNo.VALUE_11004);

        ST098OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0016", result.getErrorCode());
    }

    /**
     * 按 Spec「### 输入」表行序构造输入：对公存款账户用途、账户币种、核准件编号、账户属性。
     */
    private ST098InputBO input(AcctCcy acctCcy, RbBusAcctPurpose rbBusAcctPurpose, String apprLetterNo,
            AcctNatureNo acctNatureNo) {
        ST098InputBO input = new ST098InputBO();
        input.setRbBusAcctPurpose(rbBusAcctPurpose);
        input.setAcctCcy(acctCcy);
        input.setApprLetterNo(apprLetterNo);
        input.setAcctNatureNo(acctNatureNo);
        return input;
    }
}
