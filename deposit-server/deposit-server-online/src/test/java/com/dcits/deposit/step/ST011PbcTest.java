package com.dcits.deposit.step;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.PasswordStatus;
import com.dcits.deposit.facade.bo.ST011InputBO;
import com.dcits.deposit.facade.bo.ST011OutputBO;
import com.dcits.deposit.facade.components.IRbBusPasswordBcc;
import com.dcits.deposit.facade.eo.RbBusPasswordEO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

/**
 * ST011 检查支取密码状态 步骤单元测试。
 *
 * <p>依据正式 Spec REQ-001~REQ-003 及用例 ST011-TC001~TC003：正常查询并输出密码状态、
 * 密码状态「L-锁定」返回 ER0079 并短路、非锁定正常完成并进入《验证密码》（跳转由流程编排/
 * 步骤框架执行，本 Spec 不定义路由值，单测以正常完成结果验证跳转前置条件）。</p>
 *
 * <p>用例输入中 pwdType 以业务称谓「支取密码」表述，未绑定枚举字面值（Spec 待确认事项
 * TBD-1），本测试不设置 pwdType；查询请求 EO 的定位键来源见 TBD-2，不对请求 EO 字段值做
 * 精确断言；errorMessage 业务说明文本见 TBD-5，不做等值断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST011PbcTest {
    @Mock
    private IRbBusPasswordBcc rbBusPasswordBcc;

    @InjectMocks
    private ST011Pbc st011Pbc;

    /** ST011-TC001（REQ-001-S01）：按账号与「支取密码」类型查询取得密码状态（PasswordStatus.A）并输出，步骤正常完成。 */
    @Test
    void testST011T01() {
        RbBusPasswordEO record = new RbBusPasswordEO();
        record.setPasswordStatus(PasswordStatus.A);
        // 请求 EO 的定位键（internalKey/pwdKey）与 pwdType 字面取值来源见 TBD-2/TBD-1，本用例不对请求 EO 字段值做精确断言
        lenient().when(rbBusPasswordBcc.findByEo(any(RbBusPasswordEO.class))).thenReturn(List.of(record));

        ST011InputBO input = new ST011InputBO();
        input.setBaseAcctNo("6228480012345678");
        // pwdType=「支取密码」对应枚举取值待确认（Spec 待确认事项 TBD-1），按 Spec 以业务称谓表述，不绑定枚举字面值

        ST011OutputBO result = st011Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(PasswordStatus.A, result.getPasswordStatus());
        // 验证记录→输出数据流：输出 passwordStatus 等于查询（桩返回）记录的密码状态
        assertEquals(record.getPasswordStatus(), result.getPasswordStatus());
    }

    /** ST011-TC002（REQ-002-S01）：查询取得的密码状态为「L-锁定」（PasswordStatus.L），步骤业务失败返回错误码 ER0079 并短路。 */
    @Test
    void testST011T02() {
        RbBusPasswordEO record = new RbBusPasswordEO();
        record.setPasswordStatus(PasswordStatus.L);
        // 请求 EO 的定位键（internalKey/pwdKey）与 pwdType 字面取值来源见 TBD-2/TBD-1，本用例不对请求 EO 字段值做精确断言
        lenient().when(rbBusPasswordBcc.findByEo(any(RbBusPasswordEO.class))).thenReturn(List.of(record));

        ST011InputBO input = new ST011InputBO();
        input.setBaseAcctNo("6228480012345678");
        // pwdType=「支取密码」对应枚举取值待确认（Spec 待确认事项 TBD-1），按 Spec 以业务称谓表述，不绑定枚举字面值

        ST011OutputBO result = st011Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0079", result.getErrorCode());
        // errorMessage 业务说明文本依赖 Spec 待确认事项 TBD-5，不做等值断言；短路体现为步骤返回失败结果
    }

    /** ST011-TC003（REQ-003-S01）：查询取得的密码状态为「正常」（PasswordStatus.A），步骤正常完成并输出 passwordStatus，流程继续进入《验证密码》。 */
    @Test
    void testST011T03() {
        RbBusPasswordEO record = new RbBusPasswordEO();
        record.setPasswordStatus(PasswordStatus.A);
        // 请求 EO 的定位键（internalKey/pwdKey）与 pwdType 字面取值来源见 TBD-2/TBD-1，本用例不对请求 EO 字段值做精确断言
        lenient().when(rbBusPasswordBcc.findByEo(any(RbBusPasswordEO.class))).thenReturn(List.of(record));

        ST011InputBO input = new ST011InputBO();
        input.setBaseAcctNo("6228480012345678");
        // pwdType=「支取密码」对应枚举取值待确认（Spec 待确认事项 TBD-1），按 Spec 以业务称谓表述，不绑定枚举字面值

        ST011OutputBO result = st011Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(PasswordStatus.A, result.getPasswordStatus());
        // 步骤正常完成结果是《验证密码》跳转的框架前置条件，跳转目标与路由值由流程编排/步骤框架执行、本 Spec 不定义路由值，不在步骤单测断言
    }
}
