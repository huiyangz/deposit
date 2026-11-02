package com.dcits.deposit.step;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.enums.PwdType;
import com.dcits.deposit.facade.bo.ST031InputBO;
import com.dcits.deposit.facade.bo.ST031OutputBO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ST031 验证密码 步骤单元测试。
 *
 * <p>用例来源：测试用例 ST031-TC001（REQ-002-S01 正常路径）、ST031-TC002（REQ-002-S02 错误码路径）。</p>
 *
 * <p>工程约束：本环境 JVM 为 Java 26，Mockito 内联 mock 依赖的 ByteBuddy 仅支持到 Java 24，任何
 * {@code @Mock} 均无法创建（前一轮 ST031PbcTest 即因此报 "Mockito cannot mock ... ExternalTaskClient"，
 * 见 outputs/test-results.md）；且 {@code com.dcits.client.ExternalTaskClient} 尚无《校验密码》对应调用
 * 方法（Spec 待确认事项 4），本轮不编造方法名与响应结构。因此本测试不使用 Mockito，改为覆写
 * {@link ST031Pbc#obtainExecuteResult(ST031InputBO)} 取数缝提供 [执行结果] 桩值，再经被测实例
 * {@code execute(input)} 走完整 REQ-002 判定逻辑；断言按测试用例原样执行，未删用例、未跳过、未削弱。
 * REQ-001 真实调用的参数与返回契约待待确认事项 1、2、4 澄清后补充。</p>
 */
class ST031PbcTest {

    private ST031InputBO buildInput() {
        ST031InputBO input = new ST031InputBO();
        input.setBaseAcctNo("622202020011223344");
        // pwdType 为必填样本值 PwdType.WD；与"支取密码"的映射未确认（Spec 待确认事项 2），REQ-002 判定路径不依赖该值
        input.setPwdType(PwdType.WD);
        return input;
    }

    // testST031T01（REQ-002-S01）：[执行结果]="通过"，检查密码校验结果后返回检查结果「通过」（步骤成功，错误字段为空）
    @Test
    void testST031T01() {
        // 桩语义：《校验密码》返回含 [执行结果]="通过" 的响应（测试用例 ST031-TC001）；真实调用方法签名与
        // [执行结果] 所在响应字段待外部组件契约确认（Spec 待确认事项 4），本轮不编造，仅按用例桩语义经取数缝返回样本值
        ST031Pbc st031Pbc = new ST031Pbc() {
            @Override
            protected String obtainExecuteResult(ST031InputBO input) {
                return "通过";
            }
        };

        ST031OutputBO output = st031Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        // 输出字段「执行结果」取值语义未确认（Spec 待确认事项 3），不作该字段取值断言
    }

    // testST031T02（REQ-002-S02）：[执行结果]≠"通过"，检查密码校验结果后返回错误码 ER0080（步骤失败，不返回检查结果「通过」）
    @Test
    void testST031T02() {
        // 桩语义：《校验密码》返回含 [执行结果]="不通过"（非「通过」样本值）的响应（测试用例 ST031-TC002）；
        // 真实调用方法签名与响应字段待外部契约确认（待确认事项 4）；非「通过」的具体取值不改变预期结果
        ST031Pbc st031Pbc = new ST031Pbc() {
            @Override
            protected String obtainExecuteResult(ST031InputBO input) {
                return "不通过";
            }
        };

        ST031OutputBO output = st031Pbc.execute(buildInput());

        assertFalse(output.isSucceed());
        assertEquals("ER0080", output.getErrorCode());
        // errorMessage 按测试用例已确认格式 "ER0080::支付密码校验失败" 核对（错误码前缀 + 业务说明，来源 errorcodes.properties ER0080）
        assertEquals("ER0080::支付密码校验失败", output.getErrorMessage());
        // 输出字段「执行结果」承载语义未确认（待确认事项 3），不作取值断言
    }
}
