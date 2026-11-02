package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.facade.bo.ST033InputBO;
import com.dcits.deposit.facade.bo.ST033OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST033 检查账户余额类型一致性 单元测试。
 *
 * <p>覆盖正式 Spec 已确认子步骤行为：REQ-001-S01 转出账户余额类型获取（单条与多条
 * 取第一条）、REQ-002-S01 转入账户余额类型获取（单条与多条取第一条）、REQ-003-S01
 * 余额类型一致返回通过、REQ-003-S02 不一致返回 ER0075、REQ-004-S01 输出 rbAcctType
 * 契约。测试用例 ST033-TC001~TC005。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST033PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @InjectMocks
    private ST033Pbc st033Pbc;

    /** 构造输入：baseAcctNo='1000000001'、othBaseAcctNo='1000000002' */
    private ST033InputBO buildInput() {
        ST033InputBO input = new ST033InputBO();
        input.setBaseAcctNo("1000000001");
        input.setOthBaseAcctNo("1000000002");
        return input;
    }

    /**
     * 账户信息查询桩：按调用顺序，第一次 findByEo 返回转出账户查询结果，第二次返回
     * 转入账户查询结果（按账号定位的实际查询路径见 TBD-3，桩只确认返回数据）。
     */
    private void stubFindByEo(List<RbBusAcctEO> outRecords, List<RbBusAcctEO> inRecords) {
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class)))
                .thenReturn(outRecords, inRecords);
    }

    // 场景：ST033-TC001，转出 CA（钞余额）与转入 TT（汇余额）不一致，步骤失败返回 ER0075
    @Test
    void testST033T01() {
        RbBusAcctEO out = new RbBusAcctEO();
        out.setBalType(BalType.CA);
        RbBusAcctEO in = new RbBusAcctEO();
        in.setBalType(BalType.TT);
        stubFindByEo(List.of(out), List.of(in));

        ST033OutputBO output = st033Pbc.execute(buildInput());

        assertFalse(output.isSucceed());
        assertEquals("ER0075", output.getErrorCode());
        assertNotNull(output.getErrorMessage());
        assertTrue(output.getErrorMessage().startsWith("ER0075::"));
        assertTrue(output.getErrorMessage().contains("转账双方账户余额类型不一致"));
    }

    // 场景：ST033-TC002，转出与转入余额类型均 CA，一致返回「通过」，错误字段为空
    @Test
    void testST033T02() {
        RbBusAcctEO out = new RbBusAcctEO();
        out.setBalType(BalType.CA);
        RbBusAcctEO in = new RbBusAcctEO();
        in.setBalType(BalType.CA);
        stubFindByEo(List.of(out), List.of(in));

        ST033OutputBO output = st033Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // 场景：ST033-TC003，转出查询返回两条 [CA, TT] 取第一条 CA，转入 CA，一致返回「通过」
    @Test
    void testST033T03() {
        RbBusAcctEO outCa = new RbBusAcctEO();
        outCa.setBalType(BalType.CA);
        RbBusAcctEO outTt = new RbBusAcctEO();
        outTt.setBalType(BalType.TT);
        RbBusAcctEO in = new RbBusAcctEO();
        in.setBalType(BalType.CA);
        stubFindByEo(List.of(outCa, outTt), List.of(in));

        ST033OutputBO output = st033Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // 场景：ST033-TC004，转入查询返回两条 [TT, CA] 取第一条 TT，转出 CA，不一致返回 ER0075
    @Test
    void testST033T04() {
        RbBusAcctEO out = new RbBusAcctEO();
        out.setBalType(BalType.CA);
        RbBusAcctEO inTt = new RbBusAcctEO();
        inTt.setBalType(BalType.TT);
        RbBusAcctEO inCa = new RbBusAcctEO();
        inCa.setBalType(BalType.CA);
        stubFindByEo(List.of(out), List.of(inTt, inCa));

        ST033OutputBO output = st033Pbc.execute(buildInput());

        assertFalse(output.isSucceed());
        assertEquals("ER0075", output.getErrorCode());
        assertNotNull(output.getErrorMessage());
        assertTrue(output.getErrorMessage().startsWith("ER0075::"));
        assertTrue(output.getErrorMessage().contains("转账双方账户余额类型不一致"));
    }

    // 场景：ST033-TC005，两账户余额类型一致且记录携带 rbAcctType，输出 rbAcctType 被赋值且取值属于 {A,C,S,T}（归属账户不锁定，见 TBD-1、TBD-2）
    @Test
    void testST033T05() {
        RbBusAcctEO out = new RbBusAcctEO();
        out.setBalType(BalType.CA);
        out.setRbAcctType(RbAcctType.C);
        RbBusAcctEO in = new RbBusAcctEO();
        in.setBalType(BalType.CA);
        in.setRbAcctType(RbAcctType.S);
        stubFindByEo(List.of(out), List.of(in));

        ST033OutputBO output = st033Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertNotNull(output.getRbAcctType());
        assertNotNull(RbAcctType.byValue(output.getRbAcctType().getValue()));
    }
}
