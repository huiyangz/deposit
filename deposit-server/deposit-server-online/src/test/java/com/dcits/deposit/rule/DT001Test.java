package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.enums.RbBusAcctPurpose;

/**
 * DT001 根据核准类型设置账户状态 单元测试
 */
public class DT001Test {

    // 场景：基本户、境内、企业标志“是”，命中 SPEC 1.a，预期返回“新建”
    @Test
    public void test_01() {
        assertEquals("新建", DT001.execute(RbBusAcctPurpose.VALUE_6, "基本户", "是", "境内"));
    }

    // 场景：基本户、境内、企业标志“否”，命中 SPEC 1.b，预期返回“预开户”
    @Test
    public void test_02() {
        assertEquals("预开户", DT001.execute(RbBusAcctPurpose.VALUE_6, "基本户", "否", "境内"));
    }

    // 场景：基本户、境外、企业标志“是”，命中 SPEC 1.c，预期返回“预开户”
    @Test
    public void test_03() {
        assertEquals("预开户", DT001.execute(RbBusAcctPurpose.VALUE_6, "基本户", "是", "境外"));
    }

    // 场景：基本户、境外、企业标志“否”，命中 SPEC 1.d，预期返回“新建”
    @Test
    public void test_04() {
        assertEquals("新建", DT001.execute(RbBusAcctPurpose.VALUE_6, "基本户", "否", "境外"));
    }

    // 场景：一般户，不判断账户用途、企业标志、境内境外标志，命中 SPEC 2，预期返回“新建”
    @Test
    public void test_05() {
        assertEquals("新建", DT001.execute(RbBusAcctPurpose.VALUE_6, "一般户", "是", "境内"));
    }

    // 场景：专用户、用途“预算单位专用存款户”（VALUE_4）、境内、企业标志“是”，命中 SPEC 3.1.a，预期返回“无”
    @Test
    public void test_06() {
        assertEquals("无", DT001.execute(RbBusAcctPurpose.VALUE_4, "专用户", "是", "境内"));
    }

    // 场景：专用户、用途“预算单位专用存款户”（VALUE_4）、境内、企业标志“否”，命中 SPEC 3.1.b，预期返回“预开户”
    @Test
    public void test_07() {
        assertEquals("预开户", DT001.execute(RbBusAcctPurpose.VALUE_4, "专用户", "否", "境内"));
    }

    // 场景：专用户、用途“预算单位专用存款户”（VALUE_4）、境外、企业标志“是”，命中 SPEC 3.1.c，预期返回“无”
    @Test
    public void test_08() {
        assertEquals("无", DT001.execute(RbBusAcctPurpose.VALUE_4, "专用户", "是", "境外"));
    }

    // 场景：专用户、用途“预算单位专用存款户”（VALUE_4）、境外、企业标志“否”，命中 SPEC 3.1.d，预期返回“新建”
    @Test
    public void test_09() {
        assertEquals("新建", DT001.execute(RbBusAcctPurpose.VALUE_4, "专用户", "否", "境外"));
    }

    // 场景：专用户、用途“非预算单位专用存款户”（VALUE_3），不判断企业标志、境内境外标志，命中 SPEC 3.2，预期返回“新建”
    @Test
    public void test_10() {
        assertEquals("新建", DT001.execute(RbBusAcctPurpose.VALUE_3, "专用户", "是", "境内"));
    }

    // 场景：临时户、境内、企业标志“是”，命中 SPEC 4.a，预期返回“新建”
    @Test
    public void test_11() {
        assertEquals("新建", DT001.execute(RbBusAcctPurpose.VALUE_6, "临时户", "是", "境内"));
    }

    // 场景：临时户、境内、企业标志“否”，命中 SPEC 4.b，预期返回“预开户”
    @Test
    public void test_12() {
        assertEquals("预开户", DT001.execute(RbBusAcctPurpose.VALUE_6, "临时户", "否", "境内"));
    }

    // 场景：临时户、境外、企业标志“是”，命中 SPEC 4.c，预期返回“无”
    @Test
    public void test_13() {
        assertEquals("无", DT001.execute(RbBusAcctPurpose.VALUE_6, "临时户", "是", "境外"));
    }

    // 场景：临时户、境外、企业标志“否”，命中 SPEC 4.d，预期返回“新建”
    @Test
    public void test_14() {
        assertEquals("新建", DT001.execute(RbBusAcctPurpose.VALUE_6, "临时户", "否", "境外"));
    }

    // 场景：验资户、境内、企业标志“是”，命中 SPEC 5.a，预期返回“新建”
    @Test
    public void test_15() {
        assertEquals("新建", DT001.execute(RbBusAcctPurpose.VALUE_6, "验资户", "是", "境内"));
    }

    // 场景：验资户、境内、企业标志“否”，命中 SPEC 5.b（与基本户同组合结果不同，验证验资户分支独立性），预期返回“新建”
    @Test
    public void test_16() {
        assertEquals("新建", DT001.execute(RbBusAcctPurpose.VALUE_6, "验资户", "否", "境内"));
    }

    // 场景：验资户、境外、企业标志“是”，命中 SPEC 5.c，预期返回“无”
    @Test
    public void test_17() {
        assertEquals("无", DT001.execute(RbBusAcctPurpose.VALUE_6, "验资户", "是", "境外"));
    }

    // 场景：验资户、境外、企业标志“否”，命中 SPEC 5.d，预期返回“新建”
    @Test
    public void test_18() {
        assertEquals("新建", DT001.execute(RbBusAcctPurpose.VALUE_6, "验资户", "否", "境外"));
    }

    // 场景：账户属性为 SPEC 五种命名值之外的取值（“其他”为样本值），命中默认行 SPEC 6“否则”，预期返回“新建”
    @Test
    public void test_19() {
        assertEquals("新建", DT001.execute(RbBusAcctPurpose.VALUE_6, "其他", "是", "境内"));
    }
}
