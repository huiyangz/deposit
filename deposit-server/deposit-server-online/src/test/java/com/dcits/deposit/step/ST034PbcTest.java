package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST034InputBO;
import com.dcits.deposit.facade.bo.ST034OutputBO;
import com.dcits.deposit.facade.bo.ST036InputBO;
import com.dcits.deposit.facade.bo.ST036OutputBO;
import com.dcits.deposit.facade.components.ITbVoucherDefBcc;
import com.dcits.deposit.facade.eo.TbVoucherDefEO;

/**
 * ST034 检查对手账户黑名单 步骤单元测试。
 *
 * <p>依据测试用例 ST034-TC001~TC008。桩 1 按 docType 返回凭证类型定义表记录
 * （docClass=DocClass.DCT）；桩 2 以组件内步骤调用方式设桩 IST036.execute，按用例返回成功
 * （succeed=true）与指定 dealFlow，并记录收到的 ST036InputBO 供参数核对。baseAcctNo/acctBranch
 * 等 ST036 输入字段映射未确认（TBD-2），不作为断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST034PbcTest {

    @Mock
    private ITbVoucherDefBcc tbVoucherDefBcc;

    @Mock
    private IST036 st036;

    @InjectMocks
    private ST034Pbc st034Pbc;

    /** 桩 2 记录收到的 ST036 输入，供调用参数核对 */
    private ST036InputBO capturedSt036Input;

    // 场景：ST034-TC001（REQ-001-S01），第 1 步按 docType 查询 TB_VOUCHER_DEF 取得 docClass，作为输出字段及 ST036 [凭证种类] 参数
    @Test
    void testST034T01() {
        stubFindByDocType();
        stubSt036(null);

        ST034OutputBO output = st034Pbc.execute(buildInput());

        assertEquals(DocClass.DCT, output.getDocClass());
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(DocClass.DCT, capturedSt036Input.getDocClass());
    }

    // 场景：ST034-TC002（REQ-002-S01），第 2 步赋值事件类型为 "CRET"，作为输出字段 eventType 及 ST036 [事件类型] 参数
    @Test
    void testST034T02() {
        stubFindByDocType();
        stubSt036(null);

        ST034OutputBO output = st034Pbc.execute(buildInput());

        assertEquals("CRET", output.getEventType());
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("CRET", capturedSt036Input.getEventType());
    }

    // 场景：ST034-TC003（REQ-003-S01），第 3 步按 9 项参数以组件内步骤调用方式访问 ST036 取得「提醒」，作为第 4 步分支判断依据
    @Test
    void testST034T03() {
        stubFindByDocType();
        stubSt036(DealFlow.D);

        ST034OutputBO output = st034Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(DocClass.DCT, capturedSt036Input.getDocClass());
        assertEquals("CRET", capturedSt036Input.getEventType());
        assertEquals(TranType.VALUE_4308, capturedSt036Input.getTranType());
        assertEquals("SVC0001", capturedSt036Input.getServiceCode());
        assertEquals("CIFDP0001", capturedSt036Input.getMessageCode());
        assertEquals("TRD", capturedSt036Input.getMessageType());
        assertEquals(SourceType.CIP, capturedSt036Input.getSourceType());
    }

    // 场景：ST034-TC004（REQ-004-S01），执行结果为「通过」，第 4 步 a 分支继续执行，本步骤正常结束
    @Test
    void testST034T04() {
        stubFindByDocType();
        stubSt036(null);

        ST034OutputBO output = st034Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // 场景：ST034-TC005（REQ-004-S02），执行结果为「提醒」（DealFlow.D），第 4 步 a 分支继续执行，本步骤正常结束
    @Test
    void testST034T05() {
        stubFindByDocType();
        stubSt036(DealFlow.D);

        ST034OutputBO output = st034Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // 场景：ST034-TC006（REQ-004-S03），执行结果为「授权」（DealFlow.A），第 4 步 b 分支输出授权标志="是"并正常结束
    @Test
    void testST034T06() {
        stubFindByDocType();
        stubSt036(DealFlow.A);

        ST034OutputBO output = st034Pbc.execute(buildInput());

        assertEquals("是", output.getAuthFlag());
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // 场景：ST034-TC007（REQ-004-S04），执行结果为「拒绝」（DealFlow.B），第 4 步 c 分支业务失败，返回错误码 ER0057
    @Test
    void testST034T07() {
        stubFindByDocType();
        stubSt036(DealFlow.B);

        ST034OutputBO output = st034Pbc.execute(buildInput());

        assertFalse(output.isSucceed());
        assertEquals("ER0057", output.getErrorCode());
        assertNotNull(output.getErrorMessage());
        assertTrue(output.getErrorMessage().startsWith("ER0057::"));
        assertTrue(output.getErrorMessage().contains("黑名单账户，拒绝交易"));
    }

    // 场景：ST034-TC008（REQ-005-S01），输出字段契约：eventType="CRET"、docClass=DocClass.DCT、授权标志="是"、dealFlow 为 DealFlow（透传关系见 TBD-6，不作强断言）
    @Test
    void testST034T08() {
        stubFindByDocType();
        stubSt036(DealFlow.A);

        ST034OutputBO output = st034Pbc.execute(buildInput());

        assertEquals("CRET", output.getEventType());
        assertEquals(DocClass.DCT, output.getDocClass());
        assertEquals("是", output.getAuthFlag());
        assertNotNull(output.getDealFlow());
        assertTrue(output.getDealFlow() instanceof DealFlow);
    }

    /**
     * 构造 ST034-TC001~TC008 公共输入：8 项字段按用例 inputConstruction 赋值。
     */
    private ST034InputBO buildInput() {
        ST034InputBO input = new ST034InputBO();
        input.setDocType(DocType.VALUE_737);
        input.setOthBaseAcctNo("RB1000000001");
        input.setTranBranch(TranBranch.VALUE_351155);
        input.setTranType(TranType.VALUE_4308);
        input.setServiceCode("SVC0001");
        input.setMessageCode("CIFDP0001");
        input.setMessageType("TRD");
        input.setSourceType(SourceType.CIP);
        return input;
    }

    /**
     * 桩 1：按 docType 返回凭证类型定义表记录（docClass=DocClass.DCT，对应 DocType.VALUE_737）。
     */
    private void stubFindByDocType() {
        TbVoucherDefEO voucherDef = new TbVoucherDefEO();
        voucherDef.setDocType(DocType.VALUE_737);
        voucherDef.setDocClass(DocClass.DCT);
        lenient().when(tbVoucherDefBcc.findByDocType(any(DocType.class))).thenReturn(voucherDef);
    }

    /**
     * 桩 2：设桩 IST036.execute，返回成功（succeed=true）与指定 dealFlow（null 表示「通过」），
     * 并记录收到的 ST036 输入供参数核对。
     *
     * @param dealFlow ST036 检查结果对应处理方式，「通过」时传 null
     */
    private void stubSt036(DealFlow dealFlow) {
        ST036OutputBO result = new ST036OutputBO();
        result.setSucceed(true);
        result.setDealFlow(dealFlow);
        lenient().when(st036.execute(any(ST036InputBO.class)))
                .thenAnswer(invocation -> {
                    capturedSt036Input = invocation.getArgument(0);
                    return result;
                });
    }
}
