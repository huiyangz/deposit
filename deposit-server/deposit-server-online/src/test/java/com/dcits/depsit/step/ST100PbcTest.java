package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.depsit.enums.DealFlow;
import com.dcits.depsit.enums.DocClass;
import com.dcits.depsit.enums.DocumentType;
import com.dcits.depsit.enums.LimitBranchRange;
import com.dcits.depsit.enums.RcBlackStatus;
import com.dcits.depsit.enums.ResOperateFlag;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.enums.TranType;
import com.dcits.depsit.facade.bo.ST100InputBO;
import com.dcits.depsit.facade.bo.ST100OutputBO;
import com.dcits.depsit.facade.components.IFmServiceDefineBcc;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.components.IRcAllListBcc;
import com.dcits.depsit.facade.components.IRcListCheckRangeBcc;
import com.dcits.depsit.facade.components.IRcListNotCheckRangeBcc;
import com.dcits.depsit.facade.components.IRcListTypeBcc;
import com.dcits.depsit.facade.components.IRcRuleTypeBcc;
import com.dcits.depsit.facade.eo.FmServiceDefineEO;
import com.dcits.depsit.facade.eo.RbBusAcctEO;
import com.dcits.depsit.facade.eo.RcAllListEO;
import com.dcits.depsit.facade.eo.RcListCheckRangeEO;
import com.dcits.depsit.facade.eo.RcListNotCheckRangeEO;
import com.dcits.depsit.facade.eo.RcListTypeEO;
import com.dcits.depsit.facade.eo.RcRuleTypeEO;

/**
 * ST100 检查黑名单 的单元测试。
 *
 * <p>调用签名：{@code ST100OutputBO execute(ST100InputBO input)}；检查结果经唯一输出字段
 * {@code dealFlow} 交付，「通过」时该字段无值。本步骤无业务失败场景，各用例断言
 * {@code isSucceed()} 为 true、错误字段为 null。</p>
 *
 * <p>用例编号与 `outputs/测试用例.md` 的 ST100-TC001～TC016 对应。子步骤 14 的 {交易机构}
 * 取值来源源需求未给出（Spec 放行事项 4），用例集约定以输入 {@code acctBranch} 作为 {交易机构}
 * 取值，与子步骤 13 取回的 $账户开立行行号$ 比较。</p>
 *
 * <p>各 BCC 桩以 {@code thenAnswer} 读取查询 EO，校验 Spec 明文的查询条件后再应答，使「查询条件被
 * 丢弃」的实现得到不同结果而失败；其中子步骤 10 的【名单不检查范围表】桩额外校验查询的事件类型取自
 * 子步骤 9 查得的 [事件类型]，桩记录只在查询事件类型命中时返回，使「丢弃子步骤 9 结果」的实现得到
 * 相反结论。Spec 放行事项与明确不覆盖的事项（子步骤 3 的列绑定与条件组合、子步骤 9 的 {@code eventType}
 * 角色、子步骤 12 的 $介质$ 匹配口径等）不作断言。</p>
 *
 * <p>各「否则」分支用例的下游 BCC 桩一律返回**可命中的相反数据**（见 {@link #stubDownstreamHitChain()}、
 * {@link #stubChainAfterRuleInfo()}、{@link #stubRuleTypeForEmptyRuleId()}）：若被测实现漏掉某条
 * 「否则」分支，执行将顺着判定链走到子步骤 16 并返回该规则的 $处理方式$，与「检查结果为通过」的期望
 * 不同而使断言失败；正确实现在该分支终止时这些桩不被触达（全部为 {@code Mockito.lenient()}）。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST100PbcTest {

    @Mock
    private IFmServiceDefineBcc fmServiceDefineBcc;

    @Mock
    private IRcAllListBcc rcAllListBcc;

    @Mock
    private IRcListTypeBcc rcListTypeBcc;

    @Mock
    private IRcRuleTypeBcc rcRuleTypeBcc;

    @Mock
    private IRcListCheckRangeBcc rcListCheckRangeBcc;

    @Mock
    private IRcListNotCheckRangeBcc rcListNotCheckRangeBcc;

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @InjectMocks
    private ST100Pbc pbc;

    // ST100-TC001：P1 全链路命中，$处理方式$＝B ⇒ 检查结果「拒绝」，dealFlow=DealFlow.B
    @Test
    void testST100T01() {
        stubServiceDefine(List.of(serviceDefine("SVC01", "A", "Y")));
        stubAllList(List.of(allList("RC0001", "LT01")));
        stubListTypes(Map.of("LT01", "R001"));
        stubRuleTypes(Map.of("R001",
                ruleType("R001", ResOperateFlag.E, "CHK", LimitBranchRange.B, DealFlow.B)));
        stubCheckRange(List.of(checkRange("CR01", "EV01"), checkRange("CR02", "EV02")));
        stubNotCheckRange(Set.of("EV01", "EV02"));
        stubAcctInfo(List.of(acctInfo("6222021234567890123", TranBranch.VALUE_351155)));

        ST100OutputBO output = pbc.execute(fullInput());

        assertHit(output, DealFlow.B);
    }

    // ST100-TC002：P1 全链路命中，$处理方式$＝A ⇒ 检查结果「授权」，dealFlow=DealFlow.A
    @Test
    void testST100T02() {
        stubServiceDefine(List.of(serviceDefine("SVC01", "A", "Y")));
        stubAllList(List.of(allList("RC0001", "LT01")));
        stubListTypes(Map.of("LT01", "R001"));
        stubRuleTypes(Map.of("R001",
                ruleType("R001", ResOperateFlag.E, "CHK", LimitBranchRange.B, DealFlow.A)));
        stubCheckRange(List.of(checkRange("CR01", "EV01")));
        stubNotCheckRange(Set.of("EV01"));
        stubAcctInfo(List.of(acctInfo("6222021234567890123", TranBranch.VALUE_351155)));

        ST100OutputBO output = pbc.execute(fullInput());

        assertHit(output, DealFlow.A);
    }

    // ST100-TC003：P1 全链路命中，$处理方式$＝D ⇒ 检查结果「提醒」，dealFlow=DealFlow.D
    @Test
    void testST100T03() {
        stubServiceDefine(List.of(serviceDefine("SVC01", "A", "Y")));
        stubAllList(List.of(allList("RC0001", "LT01")));
        stubListTypes(Map.of("LT01", "R001"));
        stubRuleTypes(Map.of("R001",
                ruleType("R001", ResOperateFlag.E, "CHK", LimitBranchRange.B, DealFlow.D)));
        stubCheckRange(List.of(checkRange("CR01", "EV01")));
        stubNotCheckRange(Set.of("EV01"));
        stubAcctInfo(List.of(acctInfo("6222021234567890123", TranBranch.VALUE_351155)));

        ST100OutputBO output = pbc.execute(fullInput());

        assertHit(output, DealFlow.D);
    }

    // ST100-TC004：P10 多条数据汇总——服务信息任一条命中即继续；R001 在子步骤 8 终止，R002 命中 ⇒ dealFlow=DealFlow.B
    @Test
    void testST100T04() {
        stubServiceDefine(List.of(serviceDefine("SVC01", "A", "N"), serviceDefine("SVC02", "A", "Y")));
        stubAllList(List.of(allList("RC0001", "LT01"), allList("RC0002", "LT02")));
        Map<String, String> ruleIds = new HashMap<>();
        ruleIds.put("LT01", "R001");
        ruleIds.put("LT02", "R002");
        stubListTypes(ruleIds);
        Map<String, RcRuleTypeEO> ruleTypes = new HashMap<>();
        // R001 的 $处理方式$ 取 A：若子步骤 8 的「标识非 E 则该条规则终止」分支被删除，R001 会走完判定链
        // 并返回 A，与期望的 B 不同，使「R001 不得作为结果」这一声称可被证伪
        ruleTypes.put("R001", ruleType("R001", ResOperateFlag.C, "CHK", LimitBranchRange.B, DealFlow.A));
        ruleTypes.put("R002", ruleType("R002", ResOperateFlag.E, "CHK", LimitBranchRange.B, DealFlow.B));
        stubRuleTypes(ruleTypes);
        stubCheckRange(List.of(checkRange("CR01", "EV01")));
        stubNotCheckRange(Set.of("EV01"));
        stubAcctInfo(List.of(acctInfo("6222021234567890123", TranBranch.VALUE_351155)));

        ST100OutputBO output = pbc.execute(fullInput());

        assertHit(output, DealFlow.B);
    }

    // ST100-TC005：P10 全部规则均未命中——LT01 的规则标识为 C、LT02 无规则编号 ⇒ 检查结果「通过」，dealFlow 无值
    @Test
    void testST100T05() {
        stubServiceDefine(List.of(serviceDefine("SVC01", "A", "Y")));
        stubAllList(List.of(allList("RC0001", "LT01"), allList("RC0002", "LT02")));
        stubListTypes(Map.of("LT01", "R001"));
        stubRuleTypes(Map.of("R001",
                ruleType("R001", ResOperateFlag.C, "CHK", LimitBranchRange.B, DealFlow.B)));
        stubCheckRange(List.of(checkRange("CR01", "EV01")));
        stubNotCheckRange(Set.of("EV01"));
        // 下游桩为可命中数据：若子步骤 8 的「标识非 E 则该条规则终止」分支被删除，R001 会走完判定链并返回 B
        stubAcctInfo(List.of(acctInfo("6222021234567890123", TranBranch.VALUE_351155)));

        ST100OutputBO output = pbc.execute(fullInput());

        assertPass(output);
    }

    // ST100-TC006：P2 子步骤 2「否则」——无「服务状态 A 且 黑名单检查标志 Y」的记录 ⇒ 提前返回「通过」
    @Test
    void testST100T06() {
        stubServiceDefine(List.of(serviceDefine("SVC01", "A", "N")));
        // 下游桩为可命中数据：若子步骤 2 的「否则返回通过」分支被删除，执行会走完整条判定链并返回 B
        stubDownstreamHitChain();
        ST100InputBO input = fullInput();
        input.setBlacklistCheckFlag("N");

        ST100OutputBO output = pbc.execute(input);

        assertPass(output);
    }

    // ST100-TC007：P2 边界——[服务信息列表] 为空集合 ⇒ 提前返回「通过」
    @Test
    void testST100T07() {
        stubServiceDefine(Collections.emptyList());
        // 下游桩为可命中数据：若子步骤 2 的「否则返回通过」分支被删除，执行会走完整条判定链并返回 B
        stubDownstreamHitChain();

        ST100OutputBO output = pbc.execute(fullInput());

        assertPass(output);
    }

    // ST100-TC008：P3 子步骤 4「否则」——无「生效」名单记录 ⇒ [黑名单信息] 为空，返回「通过」
    @Test
    void testST100T08() {
        stubServiceDefine(List.of(serviceDefine("SVC01", "A", "Y")));
        stubAllList(Collections.emptyList());

        ST100OutputBO output = pbc.execute(fullInput());

        assertPass(output);
    }

    // ST100-TC009：P4 子步骤 6「否则」——名单类型代码 LT03 在【名单类型表】无记录 ⇒ 该条规则终止，「通过」
    @Test
    void testST100T09() {
        stubServiceDefine(List.of(serviceDefine("SVC01", "A", "Y")));
        stubAllList(List.of(allList("RC0003", "LT03")));
        stubListTypes(Collections.emptyMap());
        // 该路径不得以空规则编号查询【名单限制规则表】；若子步骤 6 的分支被删除，桩会应答可命中规则并返回 B
        stubRuleTypeForEmptyRuleId();
        stubChainAfterRuleInfo();

        ST100OutputBO output = pbc.execute(fullInput());

        assertPass(output);
    }

    // ST100-TC010：P5 子步骤 8「否则」——$黑名单限制操作标识$＝C ⇒ 该条规则终止，「通过」
    @Test
    void testST100T10() {
        stubServiceDefine(List.of(serviceDefine("SVC01", "A", "Y")));
        stubAllList(List.of(allList("RC0001", "LT01")));
        stubListTypes(Map.of("LT01", "R001"));
        stubRuleTypes(Map.of("R001",
                ruleType("R001", ResOperateFlag.C, "CHK", LimitBranchRange.B, DealFlow.B)));
        // 下游桩为可命中数据：若子步骤 8 的「标识非 E 则该条规则终止」分支被删除，执行会走完判定链并返回 B
        stubChainAfterRuleInfo();

        ST100OutputBO output = pbc.execute(fullInput());

        assertPass(output);
    }

    // ST100-TC011：P6 子步骤 11 终止——[名单不检查范围信息] 不为空 ⇒ 该条规则未命中，「通过」
    @Test
    void testST100T11() {
        stubServiceDefine(List.of(serviceDefine("SVC01", "A", "Y")));
        stubAllList(List.of(allList("RC0001", "LT01")));
        stubListTypes(Map.of("LT01", "R001"));
        stubRuleTypes(Map.of("R001",
                ruleType("R001", ResOperateFlag.E, "CHK", LimitBranchRange.B, DealFlow.B)));
        stubCheckRange(List.of(checkRange("CR01", "EV01")));
        stubNotCheckRangeHit(Set.of("EV01"));
        // 下游桩为可命中数据：若子步骤 11 的「不为空则该条规则未命中」分支被删除，执行会走完判定链并返回 B
        stubAcctInfo(List.of(acctInfo("6222021234567890123", TranBranch.VALUE_351155)));

        ST100OutputBO output = pbc.execute(fullInput());

        assertPass(output);
    }

    // ST100-TC012：P7 子步骤 12「否则」——docClass=CHK 不在 $介质$ "CRD" 范围内 ⇒ 该条规则终止，「通过」
    @Test
    void testST100T12() {
        stubServiceDefine(List.of(serviceDefine("SVC01", "A", "Y")));
        stubAllList(List.of(allList("RC0001", "LT01")));
        stubListTypes(Map.of("LT01", "R001"));
        stubRuleTypes(Map.of("R001",
                ruleType("R001", ResOperateFlag.E, "CRD", LimitBranchRange.B, DealFlow.B)));
        stubCheckRange(List.of(checkRange("CR01", "EV01")));
        stubNotCheckRange(Set.of("EV01"));
        // 下游桩为可命中数据：若子步骤 12 的「不在 $介质$ 范围内则该条规则终止」分支被删除，执行会走完判定链并返回 B
        stubAcctInfo(List.of(acctInfo("6222021234567890123", TranBranch.VALUE_351155)));

        ST100OutputBO output = pbc.execute(fullInput());

        assertPass(output);
    }

    // ST100-TC013：P8 子步骤 14「否则」——$限制机构范围$＝C（≠B）⇒ 条件 ① 不成立，该条规则终止
    @Test
    void testST100T13() {
        stubServiceDefine(List.of(serviceDefine("SVC01", "A", "Y")));
        stubAllList(List.of(allList("RC0001", "LT01")));
        stubListTypes(Map.of("LT01", "R001"));
        stubRuleTypes(Map.of("R001",
                ruleType("R001", ResOperateFlag.E, "CHK", LimitBranchRange.C, DealFlow.B)));
        stubCheckRange(List.of(checkRange("CR01", "EV01")));
        stubNotCheckRange(Set.of("EV01"));
        stubAcctInfo(List.of(acctInfo("6222021234567890123", TranBranch.VALUE_351155)));

        ST100OutputBO output = pbc.execute(fullInput());

        assertPass(output);
    }

    // ST100-TC014：P8 子步骤 14「否则」——$限制机构范围$＝B，但账户开立行行号既不等于也不从属 {交易机构} ⇒ 条件 ② 不成立
    @Test
    void testST100T14() {
        stubServiceDefine(List.of(serviceDefine("SVC01", "A", "Y")));
        stubAllList(List.of(allList("RC0001", "LT01")));
        stubListTypes(Map.of("LT01", "R001"));
        stubRuleTypes(Map.of("R001",
                ruleType("R001", ResOperateFlag.E, "CHK", LimitBranchRange.B, DealFlow.B)));
        stubCheckRange(List.of(checkRange("CR01", "EV01")));
        stubNotCheckRange(Set.of("EV01"));
        stubAcctInfo(List.of(acctInfo("6222021234567890123", TranBranch.VALUE_351159)));

        ST100OutputBO output = pbc.execute(fullInput());

        assertPass(output);
    }

    // ST100-TC015：P9 子步骤 16 d——$处理方式$ 为空 ⇒ 该条规则未命中，返回「通过」，不报错
    @Test
    void testST100T15() {
        stubServiceDefine(List.of(serviceDefine("SVC01", "A", "Y")));
        stubAllList(List.of(allList("RC0001", "LT01")));
        stubListTypes(Map.of("LT01", "R001"));
        stubRuleTypes(Map.of("R001",
                ruleType("R001", ResOperateFlag.E, "CHK", LimitBranchRange.B, null)));
        stubCheckRange(List.of(checkRange("CR01", "EV01")));
        stubNotCheckRange(Set.of("EV01"));
        stubAcctInfo(List.of(acctInfo("6222021234567890123", TranBranch.VALUE_351155)));

        ST100OutputBO output = pbc.execute(fullInput());

        assertPass(output);
    }

    // ST100-TC016：P1 空集合边界——【名单检查范围表】无匹配记录（[事件类型] 为空）⇒ 继续执行至子步骤 16 命中 ⇒ dealFlow=DealFlow.B
    @Test
    void testST100T16() {
        stubServiceDefine(List.of(serviceDefine("SVC01", "A", "Y")));
        stubAllList(List.of(allList("RC0001", "LT01")));
        stubListTypes(Map.of("LT01", "R001"));
        stubRuleTypes(Map.of("R001",
                ruleType("R001", ResOperateFlag.E, "CHK", LimitBranchRange.B, DealFlow.B)));
        stubCheckRange(Collections.emptyList());
        stubNotCheckRange(Set.of());
        stubAcctInfo(List.of(acctInfo("6222021234567890123", TranBranch.VALUE_351155)));

        ST100OutputBO output = pbc.execute(fullInput());

        assertHit(output, DealFlow.B);
    }

    /** 构造 15 个字段全量赋值的输入（用例集统一的输入构造）。 */
    private ST100InputBO fullInput() {
        ST100InputBO input = new ST100InputBO();
        input.setMessageCode("MB1001");
        input.setMessageType("RQ");
        input.setServiceCode("SVC01");
        input.setProgramId("PGM1001");
        input.setSourceType(SourceType.AC);
        input.setTranType(TranType.VALUE_31);
        input.setEventType("EV01");
        input.setClientNo("C000000001");
        input.setDocumentId("140101199001011234");
        input.setDocumentType(DocumentType.VALUE_110001);
        input.setBaseAcctNo("6222021234567890123");
        input.setAcctBranch(TranBranch.VALUE_351155);
        input.setDocClass(DocClass.CHK);
        input.setBlacklistCheckFlag("Y");
        input.setServiceStatus("A");
        return input;
    }

    private FmServiceDefineEO serviceDefine(String serviceCode, String serviceStatus, String blacklistCheckFlag) {
        FmServiceDefineEO eo = new FmServiceDefineEO();
        eo.setMessageCode("MB1001");
        eo.setMessageType("RQ");
        eo.setServiceCode(serviceCode);
        eo.setServiceStatus(serviceStatus);
        eo.setBlacklistCheckFlag(blacklistCheckFlag);
        return eo;
    }

    private RcAllListEO allList(String rcSeqNo, String listType) {
        RcAllListEO eo = new RcAllListEO();
        eo.setRcSeqNo(rcSeqNo);
        eo.setListType(listType);
        // 「生效」码值按 Spec 放行事项 1 不断言，此处为桩数据示例值
        eo.setRcBlackStatus(RcBlackStatus.A);
        return eo;
    }

    private RcListTypeEO listType(String listType, String ruleId) {
        RcListTypeEO eo = new RcListTypeEO();
        eo.setListType(listType);
        eo.setRuleId(ruleId);
        return eo;
    }

    private RcRuleTypeEO ruleType(String ruleId, ResOperateFlag resOperateFlag, String cardMedium,
            LimitBranchRange resBranchRange, DealFlow dealFlow) {
        RcRuleTypeEO eo = new RcRuleTypeEO();
        eo.setRuleId(ruleId);
        eo.setResOperateFlag(resOperateFlag);
        eo.setCardMedium(cardMedium);
        eo.setResBranchRange(resBranchRange);
        eo.setDealFlow(dealFlow);
        return eo;
    }

    private RcListCheckRangeEO checkRange(String seqNo, String eventType) {
        RcListCheckRangeEO eo = new RcListCheckRangeEO();
        eo.setSeqNo(seqNo);
        eo.setEventType(eventType);
        return eo;
    }

    private RcListNotCheckRangeEO notCheckRange(String seqNo, String eventType) {
        RcListNotCheckRangeEO eo = new RcListNotCheckRangeEO();
        eo.setSeqNo(seqNo);
        eo.setTranType(TranType.VALUE_31);
        eo.setSourceType(SourceType.AC);
        eo.setProgramId("PGM1001");
        eo.setServiceCode("SVC01");
        eo.setMessageType("RQ");
        eo.setMessageCode("MB1001");
        eo.setEventType(eventType);
        return eo;
    }

    private RbBusAcctEO acctInfo(String baseAcctNo, TranBranch acctBranch) {
        RbBusAcctEO eo = new RbBusAcctEO();
        eo.setBaseAcctNo(baseAcctNo);
        eo.setAcctBranch(acctBranch);
        return eo;
    }

    /** 子步骤 1：应答【核心服务定义表】记录，并校验查询条件为 {接口服务代码}＋{接口服务类型}。 */
    private void stubServiceDefine(List<FmServiceDefineEO> records) {
        Mockito.lenient().when(fmServiceDefineBcc.findByEo(ArgumentMatchers.any())).thenAnswer(invocation -> {
            FmServiceDefineEO query = invocation.getArgument(0);
            assertEquals("MB1001", query.getMessageCode(), "子步骤 1 查询【核心服务定义表】的条件：接口服务代码");
            assertEquals("RQ", query.getMessageType(), "子步骤 1 查询【核心服务定义表】的条件：接口服务类型");
            return records;
        });
    }

    /**
     * 子步骤 3：应答【名单信息表】记录，并校验每次查询携带 {客户号}／{身份证信息}／{账号} 之一为条件值。
     *
     * <p>三个条件与表列的绑定、条件组合口径属 Spec 放行事项 1，此处只校验「查询条件取自输入声明的三个
     * 字段值」，不校验绑定到哪一列、一次查询携带几个条件。</p>
     */
    private void stubAllList(List<RcAllListEO> records) {
        Mockito.lenient().when(rcAllListBcc.findByEo(ArgumentMatchers.any())).thenAnswer(invocation -> {
            RcAllListEO query = invocation.getArgument(0);
            assertTrue(isDeclaredListCondition(query.getClientNo()) || isDeclaredListCondition(query.getDataValue()),
                    "子步骤 3 查询【名单信息表】的条件值应为 {客户号}／{身份证信息}／{账号} 之一；实际 clientNo="
                            + query.getClientNo() + ", dataValue=" + query.getDataValue());
            return records;
        });
    }

    /** 判断取值是否为子步骤 3 声明的三个查询条件值之一。 */
    private boolean isDeclaredListCondition(String value) {
        return "C000000001".equals(value) || "140101199001011234".equals(value)
                || "6222021234567890123".equals(value);
    }

    /** 按查询入参的 $名单类型代码$ 应答【名单类型表】记录；未登记的类型返回空集合。 */
    private void stubListTypes(Map<String, String> ruleIdByListType) {
        Mockito.lenient().when(rcListTypeBcc.findByEo(ArgumentMatchers.any())).thenAnswer(invocation -> {
            RcListTypeEO query = invocation.getArgument(0);
            String ruleId = ruleIdByListType.get(query.getListType());
            return ruleId == null ? Collections.<RcListTypeEO>emptyList() : List.of(listType(query.getListType(), ruleId));
        });
    }

    /** 按查询入参的 $黑名单检查规则编号$ 应答【名单限制规则表】记录；未登记的编号返回空集合。 */
    private void stubRuleTypes(Map<String, RcRuleTypeEO> ruleTypeByRuleId) {
        Mockito.lenient().when(rcRuleTypeBcc.findByEo(ArgumentMatchers.any())).thenAnswer(invocation -> {
            RcRuleTypeEO query = invocation.getArgument(0);
            RcRuleTypeEO found = ruleTypeByRuleId.get(query.getRuleId());
            return found == null ? Collections.<RcRuleTypeEO>emptyList() : List.of(found);
        });
    }

    /**
     * 子步骤 6 的证伪桩：规则编号为空时该条规则必须终止，不得以空规则编号查询【名单限制规则表】。
     *
     * <p>若被测实现漏掉该「否则」分支而继续执行，查询会携带空规则编号；此处对这种查询应答一条可命中的
     * 规则，使错误实现走完判定链返回 {@code DealFlow.B}，与「检查结果为通过」的期望不同而被断言发现。</p>
     */
    private void stubRuleTypeForEmptyRuleId() {
        Mockito.lenient().when(rcRuleTypeBcc.findByEo(ArgumentMatchers.any())).thenAnswer(invocation -> {
            RcRuleTypeEO query = invocation.getArgument(0);
            if (query.getRuleId() == null) {
                return List.of(ruleType("R001", ResOperateFlag.E, "CHK", LimitBranchRange.B, DealFlow.B));
            }
            return Collections.<RcRuleTypeEO>emptyList();
        });
    }

    /**
     * 子步骤 3～13 的「可命中」桩组合，供「否则」分支用例证伪使用。
     *
     * <p>数据使一条规则（`LT01` → `R001`，标识 `E`、$介质$ 命中 {@code DocClass.CHK}、机构关系成立）
     * 能够走完至子步骤 16 并返回 {@code DealFlow.B}；正确实现在进入子步骤 3 之前或之前某条「否则」
     * 分支终止时，这些桩不被触达。</p>
     */
    private void stubDownstreamHitChain() {
        stubAllList(List.of(allList("RC0001", "LT01")));
        stubListTypes(Map.of("LT01", "R001"));
        stubRuleTypes(Map.of("R001",
                ruleType("R001", ResOperateFlag.E, "CHK", LimitBranchRange.B, DealFlow.B)));
        stubChainAfterRuleInfo();
    }

    /**
     * 子步骤 9～13 的「可命中」桩组合，供子步骤 6／8／11／12 的「否则」分支用例证伪使用：
     * 一旦实现错误地继续执行，[事件类型] 可查得、[名单不检查范围信息] 为空、$介质$ 与机构关系成立，
     * 最终返回 {@code DealFlow.B} 而非「通过」。
     */
    private void stubChainAfterRuleInfo() {
        stubCheckRange(List.of(checkRange("CR01", "EV01")));
        stubNotCheckRange(Set.of("EV01"));
        stubAcctInfo(List.of(acctInfo("6222021234567890123", TranBranch.VALUE_351155)));
    }

    /**
     * 子步骤 9：应答【名单检查范围表】记录，并校验六个查询条件。
     *
     * <p>{@code eventType} 入参在该次查询中的角色属 Spec 放行事项 3，此处不作断言。</p>
     */
    private void stubCheckRange(List<RcListCheckRangeEO> records) {
        Mockito.lenient().when(rcListCheckRangeBcc.findByEo(ArgumentMatchers.any())).thenAnswer(invocation -> {
            RcListCheckRangeEO query = invocation.getArgument(0);
            assertEquals(TranType.VALUE_31, query.getTranType(), "子步骤 9 查询【名单检查范围表】的条件：交易类型");
            assertEquals(SourceType.AC, query.getSourceType(), "子步骤 9 查询【名单检查范围表】的条件：渠道类型");
            assertEquals("PGM1001", query.getProgramId(), "子步骤 9 查询【名单检查范围表】的条件：交易代码");
            assertEquals("SVC01", query.getServiceCode(), "子步骤 9 查询【名单检查范围表】的条件：服务代码");
            assertEquals("RQ", query.getMessageType(), "子步骤 9 查询【名单检查范围表】的条件：接口服务类型");
            assertEquals("MB1001", query.getMessageCode(), "子步骤 9 查询【名单检查范围表】的条件：接口服务代码");
            return records;
        });
    }

    /** 子步骤 10、11：查询【名单不检查范围表】未命中记录（[名单不检查范围信息] 为空）。 */
    private void stubNotCheckRange(Set<String> expectedEventTypes) {
        stubNotCheckRange(expectedEventTypes, false);
    }

    /** 子步骤 10、11：查询【名单不检查范围表】命中当前查询事件类型的记录（[名单不检查范围信息] 不为空）。 */
    private void stubNotCheckRangeHit(Set<String> expectedEventTypes) {
        stubNotCheckRange(expectedEventTypes, true);
    }

    /**
     * 子步骤 10：按六个入参＋子步骤 9 查得的 [事件类型] 应答【名单不检查范围表】。
     *
     * @param expectedEventTypes 子步骤 9 查得的 $事件类型$ 集合：查询条件中的事件类型必须取自该集合
     *                           （该集合为空时，查询条件的事件类型应为空）
     * @param hit                true 时仅当查询事件类型属于 {@code expectedEventTypes} 才返回记录，
     *                           使丢弃子步骤 9 结果的实现得到相反结论
     */
    private void stubNotCheckRange(Set<String> expectedEventTypes, boolean hit) {
        Mockito.lenient().when(rcListNotCheckRangeBcc.findByEo(ArgumentMatchers.any())).thenAnswer(invocation -> {
            RcListNotCheckRangeEO query = invocation.getArgument(0);
            assertEquals(TranType.VALUE_31, query.getTranType(), "子步骤 10 查询【名单不检查范围表】的条件：交易类型");
            assertEquals(SourceType.AC, query.getSourceType(), "子步骤 10 查询【名单不检查范围表】的条件：渠道类型");
            assertEquals("PGM1001", query.getProgramId(), "子步骤 10 查询【名单不检查范围表】的条件：交易代码");
            assertEquals("SVC01", query.getServiceCode(), "子步骤 10 查询【名单不检查范围表】的条件：服务代码");
            assertEquals("RQ", query.getMessageType(), "子步骤 10 查询【名单不检查范围表】的条件：接口服务类型");
            assertEquals("MB1001", query.getMessageCode(), "子步骤 10 查询【名单不检查范围表】的条件：接口服务代码");
            String eventType = query.getEventType();
            assertTrue(eventType == null ? expectedEventTypes.isEmpty() : expectedEventTypes.contains(eventType),
                    "子步骤 10 查询【名单不检查范围表】的事件类型条件应取自子步骤 9 查得的 [事件类型]；实际为 " + eventType);
            if (hit && eventType != null) {
                return List.of(notCheckRange("NC001", eventType));
            }
            return Collections.<RcListNotCheckRangeEO>emptyList();
        });
    }

    /** 子步骤 13：应答【账户信息】记录，并校验查询条件为 {账号}。 */
    private void stubAcctInfo(List<RbBusAcctEO> records) {
        Mockito.lenient().when(rbBusAcctBcc.findByEo(ArgumentMatchers.any())).thenAnswer(invocation -> {
            RbBusAcctEO query = invocation.getArgument(0);
            assertEquals("6222021234567890123", query.getBaseAcctNo(), "子步骤 13 查询【账户信息】的条件：账号");
            return records;
        });
    }

    /** 断言检查结果为「通过」：正常完成、dealFlow 无值。 */
    private void assertPass(ST100OutputBO output) {
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getDealFlow());
    }

    /** 断言检查结果为命中，且 dealFlow 为对应枚举取值。 */
    private void assertHit(ST100OutputBO output, DealFlow expected) {
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(expected, output.getDealFlow());
    }
}
