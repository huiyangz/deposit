package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.TranType;
import com.dcits.depsit.facade.bo.ST121InputBO;
import com.dcits.depsit.facade.bo.ST121OutputBO;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.components.IRbTranDefBcc;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import com.dcits.depsit.facade.eo.RbTranDefEO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST121 检查限制优先级 步骤单元测试。
 *
 * <p>调用签名：{@code ST121OutputBO execute(ST121InputBO input)}。依赖为两个数据服务接口
 * {@link IRbTranDefBcc#findByTranType(TranType)} 与
 * {@link IRbRestraintTypeBcc#findByRestraintType(RestraintType)}（均为按主键查询，无匹配时返回 null），
 * 均以业务输入（{@code TranType.VALUE_1000}／{@code RestraintType.VALUE_5}）为查询键精确设桩，
 * 不使用匹配器；不 mock 被测步骤的 execute，不验证交互次数与顺序，不访问数据库。</p>
 *
 * <p>冻结级别的取值对按 Spec「验收范围与明确不覆盖的事项」第 1 项构造（该比较口径源需求未确定、
 * 已按需求处理流程放行）：采用 Spec 给出的、在数值序与字典序下结论一致的示例取值，
 * 「高于」取 P_tran＝"2"、P_res＝"1"，相等取 "1"/"1"，低于取 P_tran＝"1"、P_res＝"2"；
 * 不使用「10」「9」这类在两种序下结论相异的取值对。这些取值是测试数据，不是规范常量。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST121PbcTest {

    @Mock
    private IRbTranDefBcc rbTranDefBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST121Pbc st121Pbc;

    // ST121-TC001：REQ-001-S01 / REQ-002-S01 / REQ-003-S01 / REQ-005-S01 / REQ-006-S01
    // 两侧均查到记录且冻结级别有值（交易侧 "2" 高于限制侧 "1"），判定「不检查限制」，两侧取值保持回显
    @Test
    void testST121T01() {
        Mockito.lenient().when(rbTranDefBcc.findByTranType(TranType.VALUE_1000))
                .thenReturn(tranDef("2"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_5))
                .thenReturn(restraintType("1"));

        ST121OutputBO output = st121Pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("2", output.getTranResPriority());
        assertEquals("1", output.getRestraintResPriority());
        assertEquals("不检查限制", output.getCheckResult());
    }

    // ST121-TC002：REQ-003-S02 两侧冻结级别均可取到值且相等（"1"／"1"），不构成「高于」，判定「继续检查」
    @Test
    void testST121T02() {
        Mockito.lenient().when(rbTranDefBcc.findByTranType(TranType.VALUE_1000))
                .thenReturn(tranDef("1"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_5))
                .thenReturn(restraintType("1"));

        ST121OutputBO output = st121Pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("1", output.getTranResPriority());
        assertEquals("1", output.getRestraintResPriority());
        assertEquals("继续检查", output.getCheckResult());
    }

    // ST121-TC003：REQ-003-S03 交易侧冻结级别低于限制侧（"1" 低于 "2"），不构成「高于」，判定「继续检查」
    @Test
    void testST121T03() {
        Mockito.lenient().when(rbTranDefBcc.findByTranType(TranType.VALUE_1000))
                .thenReturn(tranDef("1"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_5))
                .thenReturn(restraintType("2"));

        ST121OutputBO output = st121Pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("1", output.getTranResPriority());
        assertEquals("2", output.getRestraintResPriority());
        assertEquals("继续检查", output.getCheckResult());
    }

    // ST121-TC004：REQ-001-S02 / REQ-004-S01 交易侧按主键无对应记录（返回 null），限制侧有取值 "1"，
    // 交易的冻结级别取不到值 → tranResPriority 为空，判定「继续检查」，不设业务错误码
    @Test
    void testST121T04() {
        Mockito.lenient().when(rbTranDefBcc.findByTranType(TranType.VALUE_1000)).thenReturn(null);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_5))
                .thenReturn(restraintType("1"));

        ST121OutputBO output = st121Pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getTranResPriority());
        assertEquals("1", output.getRestraintResPriority());
        assertEquals("继续检查", output.getCheckResult());
    }

    // ST121-TC005：REQ-001-S03 / REQ-004-S01 交易侧记录存在但冻结级别列为 null，交易的冻结级别取不到值
    // → tranResPriority 为 null，判定「继续检查」，限制侧取值照常回显
    @Test
    void testST121T05() {
        Mockito.lenient().when(rbTranDefBcc.findByTranType(TranType.VALUE_1000))
                .thenReturn(tranDef(null));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_5))
                .thenReturn(restraintType("1"));

        ST121OutputBO output = st121Pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getTranResPriority());
        assertEquals("1", output.getRestraintResPriority());
        assertEquals("继续检查", output.getCheckResult());
    }

    // ST121-TC006：REQ-001-S03 / REQ-004-S01 交易侧记录存在但冻结级别列为空字符串，
    // 「取不到值」的另一种承载形态（Spec 不区分 null 与空字符串）→ 判定「继续检查」
    @Test
    void testST121T06() {
        Mockito.lenient().when(rbTranDefBcc.findByTranType(TranType.VALUE_1000))
                .thenReturn(tranDef(""));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_5))
                .thenReturn(restraintType("1"));

        ST121OutputBO output = st121Pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertTrue(output.getTranResPriority() == null || output.getTranResPriority().isEmpty());
        assertEquals("1", output.getRestraintResPriority());
        assertEquals("继续检查", output.getCheckResult());
    }

    // ST121-TC007：REQ-002-S02 / REQ-004-S02 / REQ-005-S02 限制侧按主键无对应记录（返回 null），
    // 交易侧有取值 "2" → restraintResPriority 为空，判定「继续检查」，交易侧取值保持回显
    @Test
    void testST121T07() {
        Mockito.lenient().when(rbTranDefBcc.findByTranType(TranType.VALUE_1000))
                .thenReturn(tranDef("2"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_5)).thenReturn(null);

        ST121OutputBO output = st121Pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("2", output.getTranResPriority());
        assertNull(output.getRestraintResPriority());
        assertEquals("继续检查", output.getCheckResult());
    }

    // ST121-TC008：REQ-002-S03 / REQ-004-S02 / REQ-005-S02 限制侧记录存在但冻结级别列为 null，
    // 限制的冻结级别取不到值 → restraintResPriority 为 null，判定「继续检查」
    @Test
    void testST121T08() {
        Mockito.lenient().when(rbTranDefBcc.findByTranType(TranType.VALUE_1000))
                .thenReturn(tranDef("2"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_5))
                .thenReturn(restraintType(null));

        ST121OutputBO output = st121Pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("2", output.getTranResPriority());
        assertNull(output.getRestraintResPriority());
        assertEquals("继续检查", output.getCheckResult());
    }

    // ST121-TC009：REQ-002-S03 / REQ-004-S02 / REQ-005-S02 限制侧记录存在但冻结级别列为空字符串，
    // 「取不到值」的另一种承载形态（Spec 不区分 null 与空字符串）→ 判定「继续检查」
    @Test
    void testST121T09() {
        Mockito.lenient().when(rbTranDefBcc.findByTranType(TranType.VALUE_1000))
                .thenReturn(tranDef("2"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_5))
                .thenReturn(restraintType(""));

        ST121OutputBO output = st121Pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("2", output.getTranResPriority());
        assertTrue(output.getRestraintResPriority() == null || output.getRestraintResPriority().isEmpty());
        assertEquals("继续检查", output.getCheckResult());
    }

    // ST121-TC010：REQ-004-S03 两侧经按主键查询均无对应记录，两个冻结级别输出均为空，判定「继续检查」，
    // 不产生业务失败结果
    @Test
    void testST121T10() {
        Mockito.lenient().when(rbTranDefBcc.findByTranType(TranType.VALUE_1000)).thenReturn(null);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_5)).thenReturn(null);

        ST121OutputBO output = st121Pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getTranResPriority());
        assertNull(output.getRestraintResPriority());
        assertEquals("继续检查", output.getCheckResult());
    }

    /** 构造步骤输入：交易类型 TranType.VALUE_1000（现金存入，码值 "1000"）、账户限制类型 RestraintType.VALUE_5（统一查控平台冻结，码值 "5"）。 */
    private static ST121InputBO input() {
        ST121InputBO input = new ST121InputBO();
        input.setTranType(TranType.VALUE_1000);
        input.setRestraintType(RestraintType.VALUE_5);
        return input;
    }

    /** 构造【交易定义信息】记录，仅设置本步骤使用的交易类型与冻结级别字段。 */
    private static RbTranDefEO tranDef(String resPriority) {
        RbTranDefEO tranDefInfo = new RbTranDefEO();
        tranDefInfo.setTranType(TranType.VALUE_1000);
        tranDefInfo.setResPriority(resPriority);
        return tranDefInfo;
    }

    /** 构造【限制类型定义信息】记录，仅设置本步骤使用的账户限制类型与冻结级别字段。 */
    private static RbRestraintTypeEO restraintType(String resPriority) {
        RbRestraintTypeEO restraintTypeInfo = new RbRestraintTypeEO();
        restraintTypeInfo.setRestraintType(RestraintType.VALUE_5);
        restraintTypeInfo.setResPriority(resPriority);
        return restraintTypeInfo;
    }
}
