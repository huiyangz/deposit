package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.lenient;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.RcBlackStatus;
import com.dcits.deposit.enums.ResOperateFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST036InputBO;
import com.dcits.deposit.facade.bo.ST036OutputBO;
import com.dcits.deposit.facade.components.IFmServiceDefineBcc;
import com.dcits.deposit.facade.components.IRcAllListBcc;
import com.dcits.deposit.facade.components.IRcListTypeBcc;
import com.dcits.deposit.facade.components.IRcRuleTypeBcc;
import com.dcits.deposit.facade.eo.FmServiceDefineEO;
import com.dcits.deposit.facade.eo.RcAllListEO;
import com.dcits.deposit.facade.eo.RcListTypeEO;
import com.dcits.deposit.facade.eo.RcRuleTypeEO;

/**
 * ST036 检查黑名单 步骤单元测试。
 *
 * <p>依据测试用例 ST036-TC001~TC007。用例构造域内（REQ-001~REQ-004）所有最终可观察
 * 结果均为「通过」（succeed=true、errorCode/errorMessage 为空、dealFlow=null），
 * REQ-004-S01 及 REQ-005~008 路径因 TBD-2 不可构造，未设桩 BCC 按 Mockito 默认返回
 * 空列表 / null（符合用例文档约定，不使用 verify/次数断言）。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST036PbcTest {

    @Mock
    private IFmServiceDefineBcc fmServiceDefineBcc;

    @Mock
    private IRcAllListBcc rcAllListBcc;

    @Mock
    private IRcListTypeBcc rcListTypeBcc;

    @Mock
    private IRcRuleTypeBcc rcRuleTypeBcc;

    @InjectMocks
    private ST036Pbc st036Pbc;

    // ST036-TC001（REQ-001-S01 继续 → REQ-002-S02）：服务定义存在生效/Y-是记录继续，黑名单信息查无记录返回「通过」
    @Test
    void testST036T01() {
        lenient().when(fmServiceDefineBcc.findByEo(argThat(eo -> "CIFDP0001".equals(eo.getMessageCode())
                && "TRD".equals(eo.getMessageType()))))
                .thenReturn(List.of(buildEffectiveServiceDefine()));

        ST036OutputBO result = st036Pbc.execute(buildInput());

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNull(result.getDealFlow());
    }

    // ST036-TC002（REQ-001-S02）：服务定义查无记录，步骤在服务定义检查返回「通过」，不再执行后续子步骤
    @Test
    void testST036T02() {
        lenient().when(fmServiceDefineBcc.findByEo(argThat(eo -> "CIFDP0001".equals(eo.getMessageCode())
                && "TRD".equals(eo.getMessageType()))))
                .thenReturn(Collections.emptyList());

        ST036OutputBO result = st036Pbc.execute(buildInput());

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNull(result.getDealFlow());
    }

    // ST036-TC003（REQ-002-S01 继续 → REQ-003-S02）：命中生效黑名单记录继续，名单类型查无记录返回「通过」
    @Test
    void testST036T03() {
        lenient().when(fmServiceDefineBcc.findByEo(argThat(eo -> "CIFDP0001".equals(eo.getMessageCode())
                && "TRD".equals(eo.getMessageType()))))
                .thenReturn(List.of(buildEffectiveServiceDefine()));
        lenient().when(rcAllListBcc.findByEo(argThat(eo -> "C000000001".equals(eo.getClientNo()))))
                .thenReturn(List.of(buildEffectiveBlackList()));

        ST036OutputBO result = st036Pbc.execute(buildInput());

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNull(result.getDealFlow());
    }

    // ST036-TC004（REQ-002-S02）：黑名单信息查询返回空，步骤返回「通过」，不设置 dealFlow
    @Test
    void testST036T04() {
        lenient().when(fmServiceDefineBcc.findByEo(argThat(eo -> "CIFDP0001".equals(eo.getMessageCode())
                && "TRD".equals(eo.getMessageType()))))
                .thenReturn(List.of(buildEffectiveServiceDefine()));
        lenient().when(rcAllListBcc.findByEo(argThat(eo -> "C000000001".equals(eo.getClientNo()))))
                .thenReturn(Collections.emptyList());

        ST036OutputBO result = st036Pbc.execute(buildInput());

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNull(result.getDealFlow());
    }

    // ST036-TC005（REQ-003-S01 继续 → REQ-004-S02）：取得规则编号继续，名单限制规则查无记录返回「通过」
    @Test
    void testST036T05() {
        lenient().when(fmServiceDefineBcc.findByEo(argThat(eo -> "CIFDP0001".equals(eo.getMessageCode())
                && "TRD".equals(eo.getMessageType()))))
                .thenReturn(List.of(buildEffectiveServiceDefine()));
        lenient().when(rcAllListBcc.findByEo(argThat(eo -> "C000000001".equals(eo.getClientNo()))))
                .thenReturn(List.of(buildEffectiveBlackList()));
        lenient().when(rcListTypeBcc.findByPrimaryKey("BL0001"))
                .thenReturn(buildListType("R000001"));

        ST036OutputBO result = st036Pbc.execute(buildInput());

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNull(result.getDealFlow());
    }

    // ST036-TC006（REQ-003-S02）：名单类型表查无记录，[黑名单检查规则编号] 为空，步骤返回「通过」
    @Test
    void testST036T06() {
        lenient().when(fmServiceDefineBcc.findByEo(argThat(eo -> "CIFDP0001".equals(eo.getMessageCode())
                && "TRD".equals(eo.getMessageType()))))
                .thenReturn(List.of(buildEffectiveServiceDefine()));
        lenient().when(rcAllListBcc.findByEo(argThat(eo -> "C000000001".equals(eo.getClientNo()))))
                .thenReturn(List.of(buildEffectiveBlackList()));
        lenient().when(rcListTypeBcc.findByPrimaryKey("BL0001")).thenReturn(null);

        ST036OutputBO result = st036Pbc.execute(buildInput());

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNull(result.getDealFlow());
    }

    // ST036-TC007（REQ-004-S02）：名单限制规则信息操作标识=ResOperateFlag.C（控制，非检查类），步骤返回「通过」
    @Test
    void testST036T07() {
        lenient().when(fmServiceDefineBcc.findByEo(argThat(eo -> "CIFDP0001".equals(eo.getMessageCode())
                && "TRD".equals(eo.getMessageType()))))
                .thenReturn(List.of(buildEffectiveServiceDefine()));
        lenient().when(rcAllListBcc.findByEo(argThat(eo -> "C000000001".equals(eo.getClientNo()))))
                .thenReturn(List.of(buildEffectiveBlackList()));
        lenient().when(rcListTypeBcc.findByPrimaryKey("BL0001"))
                .thenReturn(buildListType("R000001"));
        RcRuleTypeEO ruleType = new RcRuleTypeEO();
        ruleType.setRuleId("R000001");
        ruleType.setResOperateFlag(ResOperateFlag.C);
        lenient().when(rcRuleTypeBcc.findByPrimaryKey("R000001")).thenReturn(ruleType);

        ST036OutputBO result = st036Pbc.execute(buildInput());

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNull(result.getDealFlow());
    }

    /**
     * 构造 ST036-TC001~TC007 公共输入：全部 15 字段按测试用例 inputConstruction 赋值。
     */
    private ST036InputBO buildInput() {
        ST036InputBO input = new ST036InputBO();
        input.setDocClass(DocClass.DCT);
        input.setBaseAcctNo("RB1000000001");
        input.setAcctBranch(TranBranch.VALUE_351155);
        input.setSourceType(SourceType.CIP);
        input.setProgramId("TRD0001");
        input.setTranType(TranType.VALUE_4308);
        input.setEventType("T01");
        input.setServiceCode("SVC0001");
        input.setMessageType("TRD");
        input.setMessageCode("CIFDP0001");
        input.setBlacklistCheckFlag("Y-是");
        input.setServiceStatus("A-生效");
        input.setClientNo("C000000001");
        input.setDocumentId("999999199001010001");
        input.setDocumentType(DocumentType.VALUE_110001);
        return input;
    }

    /**
     * 构造服务状态=「A-生效」且黑名单检查标志=「Y-是」的核心服务定义记录。
     */
    private FmServiceDefineEO buildEffectiveServiceDefine() {
        FmServiceDefineEO service = new FmServiceDefineEO();
        service.setMessageCode("CIFDP0001");
        service.setMessageType("TRD");
        service.setServiceStatus("A-生效");
        service.setBlacklistCheckFlag("Y-是");
        return service;
    }

    /**
     * 构造黑名单状态=生效（RcBlackStatus.A）、名单类型代码=「BL0001」的黑名单记录。
     */
    private RcAllListEO buildEffectiveBlackList() {
        RcAllListEO black = new RcAllListEO();
        black.setClientNo("C000000001");
        black.setRcBlackStatus(RcBlackStatus.A);
        black.setListType("BL0001");
        return black;
    }

    /**
     * 构造名单类型记录，ruleId 取传入的黑名单检查规则编号。
     */
    private RcListTypeEO buildListType(String ruleId) {
        RcListTypeEO listType = new RcListTypeEO();
        listType.setListType("BL0001");
        listType.setRuleId(ruleId);
        return listType;
    }
}
