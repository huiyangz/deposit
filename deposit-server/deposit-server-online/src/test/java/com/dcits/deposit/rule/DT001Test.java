package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.RbBusAcctPurpose;

/**
 * 规则 DT001「根据核准类型设置账户状态」单元测试。
 *
 * <p>用例来源：outputs/测试用例.md（DT001-TC001 ~ DT001-TC020），覆盖 SPEC 全部 20 条已定义决策行。</p>
 */
class DT001Test {

    // 场景：基本户·境内·企业客户，命中规则 1a；预期返回“新建”（N）
    @Test
    void test_01() {
        AcctStatus result = DT001.execute(null, AcctNatureNo.VALUE_11001, "是", "境内");
        assertEquals(AcctStatus.N, result);
        assertEquals("N", result.getValue());
    }

    // 场景：基本户·境内·非企业客户，命中规则 1b；预期返回“预开户”（I）
    @Test
    void test_02() {
        AcctStatus result = DT001.execute(null, AcctNatureNo.VALUE_11001, "否", "境内");
        assertEquals(AcctStatus.I, result);
        assertEquals("I", result.getValue());
    }

    // 场景：基本户·境外·企业客户，命中规则 1c；预期返回“预开户”（I）
    @Test
    void test_03() {
        AcctStatus result = DT001.execute(null, AcctNatureNo.VALUE_11001, "是", "境外");
        assertEquals(AcctStatus.I, result);
        assertEquals("I", result.getValue());
    }

    // 场景：基本户·境外·非企业客户，命中规则 1d；预期返回“新建”（N）
    @Test
    void test_04() {
        AcctStatus result = DT001.execute(null, AcctNatureNo.VALUE_11001, "否", "境外");
        assertEquals(AcctStatus.N, result);
        assertEquals("N", result.getValue());
    }

    // 场景：一般户，命中规则 2，境内境外标志与企业标志不参与判断（取样本值）；预期返回“新建”（N）
    @Test
    void test_05() {
        AcctStatus result = DT001.execute(null, AcctNatureNo.VALUE_11002, "是", "境外");
        assertEquals(AcctStatus.N, result);
        assertEquals("N", result.getValue());
    }

    // 场景：专用户·预算单位专用存款户·境内·企业客户，命中规则 3.1a；预期返回“无”（null）
    @Test
    void test_06() {
        AcctStatus result = DT001.execute(RbBusAcctPurpose.VALUE_4, AcctNatureNo.VALUE_11004, "是", "境内");
        assertNull(result);
    }

    // 场景：专用户·预算单位专用存款户·境内·非企业客户，命中规则 3.1b；预期返回“预开户”（I）
    @Test
    void test_07() {
        AcctStatus result = DT001.execute(RbBusAcctPurpose.VALUE_4, AcctNatureNo.VALUE_11004, "否", "境内");
        assertEquals(AcctStatus.I, result);
        assertEquals("I", result.getValue());
    }

    // 场景：专用户·预算单位专用存款户·境外·企业客户，命中规则 3.1c；预期返回“无”（null）
    @Test
    void test_08() {
        AcctStatus result = DT001.execute(RbBusAcctPurpose.VALUE_4, AcctNatureNo.VALUE_11004, "是", "境外");
        assertNull(result);
    }

    // 场景：专用户·预算单位专用存款户·境外·非企业客户，命中规则 3.1d；预期返回“新建”（N）
    @Test
    void test_09() {
        AcctStatus result = DT001.execute(RbBusAcctPurpose.VALUE_4, AcctNatureNo.VALUE_11004, "否", "境外");
        assertEquals(AcctStatus.N, result);
        assertEquals("N", result.getValue());
    }

    // 场景：专用户·非预算单位专用存款户，命中规则 3.2 命名取值，境内境外/企业标志不参与判断（取样本值）；预期返回“新建”（N）
    @Test
    void test_10() {
        AcctStatus result = DT001.execute(RbBusAcctPurpose.VALUE_3, AcctNatureNo.VALUE_11004, "否", "境内");
        assertEquals(AcctStatus.N, result);
        assertEquals("N", result.getValue());
    }

    // 场景：专用户·账户用途为空（非必填字段空值），命中规则 3.2“其他取值（含为空）”；预期返回“新建”（N）
    @Test
    void test_11() {
        AcctStatus result = DT001.execute(null, AcctNatureNo.VALUE_11004, "是", "境外");
        assertEquals(AcctStatus.N, result);
        assertEquals("N", result.getValue());
    }

    // 场景：临时户·境内·企业客户，命中规则 4a；预期返回“新建”（N）
    @Test
    void test_12() {
        AcctStatus result = DT001.execute(null, AcctNatureNo.VALUE_11003, "是", "境内");
        assertEquals(AcctStatus.N, result);
        assertEquals("N", result.getValue());
    }

    // 场景：临时户·境内·非企业客户，命中规则 4b；预期返回“预开户”（I）
    @Test
    void test_13() {
        AcctStatus result = DT001.execute(null, AcctNatureNo.VALUE_11003, "否", "境内");
        assertEquals(AcctStatus.I, result);
        assertEquals("I", result.getValue());
    }

    // 场景：临时户·境外·企业客户，命中规则 4c；预期返回“无”（null）
    @Test
    void test_14() {
        AcctStatus result = DT001.execute(null, AcctNatureNo.VALUE_11003, "是", "境外");
        assertNull(result);
    }

    // 场景：临时户·境外·非企业客户，命中规则 4d；预期返回“新建”（N）
    @Test
    void test_15() {
        AcctStatus result = DT001.execute(null, AcctNatureNo.VALUE_11003, "否", "境外");
        assertEquals(AcctStatus.N, result);
        assertEquals("N", result.getValue());
    }

    // 场景：验资户·境内·企业客户，命中规则 5a；预期返回“新建”（N）
    @Test
    void test_16() {
        AcctStatus result = DT001.execute(null, AcctNatureNo.VALUE_17, "是", "境内");
        assertEquals(AcctStatus.N, result);
        assertEquals("N", result.getValue());
    }

    // 场景：验资户·境内·非企业客户，命中规则 5b；预期返回“新建”（N）
    @Test
    void test_17() {
        AcctStatus result = DT001.execute(null, AcctNatureNo.VALUE_17, "否", "境内");
        assertEquals(AcctStatus.N, result);
        assertEquals("N", result.getValue());
    }

    // 场景：验资户·境外·企业客户，命中规则 5c；预期返回“无”（null）
    @Test
    void test_18() {
        AcctStatus result = DT001.execute(null, AcctNatureNo.VALUE_17, "是", "境外");
        assertNull(result);
    }

    // 场景：验资户·境外·非企业客户，命中规则 5d；预期返回“新建”（N）
    @Test
    void test_19() {
        AcctStatus result = DT001.execute(null, AcctNatureNo.VALUE_17, "否", "境外");
        assertEquals(AcctStatus.N, result);
        assertEquals("N", result.getValue());
    }

    // 场景：账户属性为五种之外取值（样本：对公人民币定期存款账户），命中规则 6 默认行“否则”，标志不参与判断（取样本值）；预期返回“新建”（N）
    @Test
    void test_20() {
        AcctStatus result = DT001.execute(null, AcctNatureNo.VALUE_11005, "是", "境外");
        assertEquals(AcctStatus.N, result);
        assertEquals("N", result.getValue());
    }
}
