package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST035InputBO;
import com.dcits.deposit.facade.bo.ST035OutputBO;
import com.dcits.deposit.facade.bo.ST036InputBO;
import com.dcits.deposit.facade.bo.ST036OutputBO;
import com.dcits.deposit.facade.components.ITbVoucherDefBcc;
import com.dcits.deposit.facade.eo.TbVoucherDefEO;

/**
 * ST035 检查支取账户黑名单 单元测试。
 *
 * <p>按正式 Spec 用例 ST035-TC001~TC004 覆盖已确认场景：REQ-001-S01 按凭证类型查询取得
 * 凭证种类、REQ-002-S01 赋值事件类型为 DEBT、REQ-003-S01 以九参数调用组件内步骤 ST036
 * 并核对已确认映射字段、REQ-004-S01~S04 通过/提醒/授权/拒绝四种执行结果分支。{交易机构}
 * →ST036 输入映射（TBD-1）、ST036 其余输入组装（TBD-2）、授权等待编排（TBD-3）、凭证
 * 种类取得边界（TBD-4、TBD-5）及必填输入缺失行为（TBD-6）无已确认预期，不作为断言，
 * 见 {@link ST035Pbc} 中对应 FIXME。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST035PbcTest {

    @Mock
    private ITbVoucherDefBcc tbVoucherDefBcc;

    @Mock
    private IST036 ist036;

    @InjectMocks
    private ST035Pbc st035Pbc;

    /** 构造完整合法输入：clientNo="C000000001"、docType=VALUE_778、baseAcctNo="1000000001"、tranBranch=VALUE_351155、tranType=VALUE_1003、serviceCode="SVC0001"、messageCode="CIFDP0001"、messageType="TRD"、sourceType=CIP */
    private ST035InputBO buildInput() {
        ST035InputBO input = new ST035InputBO();
        input.setClientNo("C000000001");
        input.setDocType(DocType.VALUE_778);
        input.setBaseAcctNo("1000000001");
        input.setTranBranch(TranBranch.VALUE_351155);
        input.setTranType(TranType.VALUE_1003);
        input.setServiceCode("SVC0001");
        input.setMessageCode("CIFDP0001");
        input.setMessageType("TRD");
        input.setSourceType(SourceType.CIP);
        return input;
    }

    /** 第 1 步查询桩：按凭证类型 DocType.VALUE_778 返回 docType=VALUE_778、docClass=DocClass.DCT 的凭证类型定义记录 */
    private void stubFindByDocType() {
        TbVoucherDefEO voucherDef = new TbVoucherDefEO();
        voucherDef.setDocType(DocType.VALUE_778);
        voucherDef.setDocClass(DocClass.DCT);
        lenient().when(tbVoucherDefBcc.findByDocType(DocType.VALUE_778)).thenReturn(voucherDef);
    }

    /** 第 3 步调用桩：以 ArgumentCaptor 捕获 ST036 收到的 ST036InputBO，返回正常结束（succeed=true）且按参数设置 dealFlow 的输出（null 表示「通过」不设置 dealFlow） */
    private void stubExecute(ArgumentCaptor<ST036InputBO> captor, DealFlow dealFlow) {
        ST036OutputBO st036Output = new ST036OutputBO();
        st036Output.setSucceed(true);
        if (dealFlow != null) {
            st036Output.setDealFlow(dealFlow);
        }
        lenient().when(ist036.execute(captor.capture())).thenReturn(st036Output);
    }

    // 场景 ST035-TC001（REQ-004-S01）：ST036 执行结果为「通过」（succeed=true 且不设置 dealFlow），第 4 步继续执行，
    // 本步骤正常结束：succeed=true、错误字段为 null、docClass=DCT、eventType=DEBT、授权标志未赋值；
    // 核对 ST036 收到的输入中八个已确认映射字段（{交易机构}→ST036 映射未确认，不作为断言）
    @Test
    void testST035T01() {
        stubFindByDocType();
        ArgumentCaptor<ST036InputBO> captor = ArgumentCaptor.forClass(ST036InputBO.class);
        stubExecute(captor, null);

        ST035OutputBO output = st035Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(DocClass.DCT, output.getDocClass());
        assertEquals("DEBT", output.getEventType());
        assertNull(output.get授权标志());

        ST036InputBO st036Input = captor.getValue();
        assertEquals("1000000001", st036Input.getBaseAcctNo());
        assertEquals(TranType.VALUE_1003, st036Input.getTranType());
        assertEquals("DEBT", st036Input.getEventType());
        assertEquals("SVC0001", st036Input.getServiceCode());
        assertEquals("CIFDP0001", st036Input.getMessageCode());
        assertEquals("TRD", st036Input.getMessageType());
        assertEquals(SourceType.CIP, st036Input.getSourceType());
        assertEquals(DocClass.DCT, st036Input.getDocClass());
    }

    // 场景 ST035-TC002（REQ-004-S02）：ST036 执行结果为「提醒」（dealFlow=DealFlow.D），第 4 步继续执行，
    // 本步骤正常结束：succeed=true、错误字段为 null、docClass=DCT、eventType=DEBT、授权标志未赋值；
    // 核对第 1、2 步结果（docClass、eventType）传入第 3 步调用 ST036 的输入
    @Test
    void testST035T02() {
        stubFindByDocType();
        ArgumentCaptor<ST036InputBO> captor = ArgumentCaptor.forClass(ST036InputBO.class);
        stubExecute(captor, DealFlow.D);

        ST035OutputBO output = st035Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(DocClass.DCT, output.getDocClass());
        assertEquals("DEBT", output.getEventType());
        assertNull(output.get授权标志());

        ST036InputBO st036Input = captor.getValue();
        assertEquals(DocClass.DCT, st036Input.getDocClass());
        assertEquals("DEBT", st036Input.getEventType());
    }

    // 场景 ST035-TC003（REQ-004-S03）：ST036 执行结果为「授权」（dealFlow=DealFlow.A），第 4 步授权分支正常结束
    // 并返回授权标志="是"：succeed=true、错误字段为 null、docClass=DCT、eventType=DEBT；
    // 「等待授权结果后再执行后续步骤」的编排机制（TBD-3）不作为断言
    @Test
    void testST035T03() {
        stubFindByDocType();
        ArgumentCaptor<ST036InputBO> captor = ArgumentCaptor.forClass(ST036InputBO.class);
        stubExecute(captor, DealFlow.A);

        ST035OutputBO output = st035Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("是", output.get授权标志());
        assertEquals(DocClass.DCT, output.getDocClass());
        assertEquals("DEBT", output.getEventType());
    }

    // 场景 ST035-TC004（REQ-004-S04）：ST036 执行结果为「拒绝」（dealFlow=DealFlow.B，ST036 正常结束的业务结论），
    // 第 4 步拒绝分支本步骤业务失败：succeed=false、errorCode=ER0057、errorMessage 按「错误码::业务说明」格式
    // 为 "ER0057::黑名单账户，拒绝交易"（不对 errorMessage 做等值断言），授权标志未赋值
    @Test
    void testST035T04() {
        stubFindByDocType();
        ArgumentCaptor<ST036InputBO> captor = ArgumentCaptor.forClass(ST036InputBO.class);
        stubExecute(captor, DealFlow.B);

        ST035OutputBO output = st035Pbc.execute(buildInput());

        assertFalse(output.isSucceed());
        assertEquals("ER0057", output.getErrorCode());
        assertNotNull(output.getErrorMessage());
        assertTrue(output.getErrorMessage().startsWith("ER0057::"));
        assertTrue(output.getErrorMessage().contains("黑名单账户，拒绝交易"));
        assertNull(output.get授权标志());
    }
}
