package com.dcits.depsit.step;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dcits.depsit.enums.DealFlow;
import com.dcits.depsit.enums.DocClass;
import com.dcits.depsit.enums.LimitBranchRange;
import com.dcits.depsit.enums.RcBlackStatus;
import com.dcits.depsit.enums.ResOperateFlag;
import com.dcits.depsit.enums.TranBranch;
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
 * ST100 检查黑名单 步骤实现。
 *
 * <p>行为主线（正式 Spec {@code docs/specs/ST100.md} 子步骤 1～16）：先按 {接口服务代码}、{接口服务类型}
 * 读【核心服务定义表】判定该接口是否允许做黑名单检查；允许时按 {客户号}／{身份证信息}／{账号}
 * 读【名单信息表】取得「生效」的 $名单类型代码$，逐个名单类型代码查【名单类型表】取得
 * $黑名单检查规则编号$，再对每一条规则依次执行「规则编号非空 → 检查类标识 → 检查范围 →
 * 不检查范围 → 介质 → 机构」六个判定，最后由该规则的 $处理方式$ 给出检查结果；任一规则命中即按
 * 该规则的处理方式返回，全部规则未命中时返回「通过」。</p>
 *
 * <p>本步骤为只读检查，无业务失败场景、不定义业务错误码；「通过」为正常完成的检查结果，
 * 此时 {@code dealFlow} 无值、{@code succeed} 为 true、错误字段保持 null。</p>
 */
@Service
public class ST100Pbc implements IST100 {

    private static final Logger LOGGER = LoggerFactory.getLogger(ST100Pbc.class);

    /** $服务状态$ 判定码值：A-生效。 */
    private static final String SERVICE_STATUS_EFFECTIVE = "A";

    /** $黑名单检查标志$ 判定码值：Y-是。 */
    private static final String BLACKLIST_CHECK_FLAG_YES = "Y";

    /** $黑名单状态$「生效」对应的枚举取值（`RcBlackStatus.A`，源码注释为「生效」）。 */
    private static final RcBlackStatus RC_BLACK_STATUS_EFFECTIVE = RcBlackStatus.A;

    /** $介质$ 多值时的分隔符（源需求未写明取值形式，此处兼容单值与分隔符集合两种书写）。 */
    private static final String MEDIUM_SEPARATOR = "[,;|/\\s]+";

    private final IFmServiceDefineBcc fmServiceDefineBcc;

    private final IRcAllListBcc rcAllListBcc;

    private final IRcListTypeBcc rcListTypeBcc;

    private final IRcRuleTypeBcc rcRuleTypeBcc;

    private final IRcListCheckRangeBcc rcListCheckRangeBcc;

    private final IRcListNotCheckRangeBcc rcListNotCheckRangeBcc;

    private final IRbBusAcctBcc rbBusAcctBcc;

    public ST100Pbc(IFmServiceDefineBcc fmServiceDefineBcc, IRcAllListBcc rcAllListBcc,
            IRcListTypeBcc rcListTypeBcc, IRcRuleTypeBcc rcRuleTypeBcc,
            IRcListCheckRangeBcc rcListCheckRangeBcc, IRcListNotCheckRangeBcc rcListNotCheckRangeBcc,
            IRbBusAcctBcc rbBusAcctBcc) {
        this.fmServiceDefineBcc = fmServiceDefineBcc;
        this.rcAllListBcc = rcAllListBcc;
        this.rcListTypeBcc = rcListTypeBcc;
        this.rcRuleTypeBcc = rcRuleTypeBcc;
        this.rcListCheckRangeBcc = rcListCheckRangeBcc;
        this.rcListNotCheckRangeBcc = rcListNotCheckRangeBcc;
        this.rbBusAcctBcc = rbBusAcctBcc;
    }

    @Override
    public ST100OutputBO execute(ST100InputBO input) {
        ST100OutputBO output = new ST100OutputBO();

        // 子步骤 1：按 {接口服务代码}＋{接口服务类型} 查询【核心服务定义表】，取回 [服务信息列表]
        List<FmServiceDefineEO> serviceInfoList = queryServiceInfoList(input);

        // 子步骤 2：存在 $服务状态$＝A-生效 且 $黑名单检查标志$＝Y-是 的记录才继续，否则返回「通过」
        if (!existsBlacklistCheckService(serviceInfoList)) {
            LOGGER.debug("ST100 子步骤 2：无 $服务状态$＝A 且 $黑名单检查标志$＝Y 的服务定义记录，检查结果为通过");
            return pass(output);
        }

        // 子步骤 3：按三个条件查询【名单信息表】，取「生效」记录的 $名单类型代码$ 赋值给 [黑名单信息]
        List<String> blacklistInfo = queryEffectiveListTypes(input);

        // 子步骤 4：[黑名单信息] 为空时返回「通过」，不再查询【名单类型表】
        if (blacklistInfo.isEmpty()) {
            LOGGER.debug("ST100 子步骤 4：[黑名单信息] 为空，检查结果为通过");
            return pass(output);
        }

        // 子步骤 5：逐个名单类型代码取规则编号，逐条执行子步骤 6～16，任一规则命中即按其 $处理方式$ 返回
        for (String listType : blacklistInfo) {
            DealFlow dealFlow = executeRuleChain(input, listType);
            if (dealFlow != null) {
                output.setDealFlow(dealFlow);
                output.setSucceed(true);
                return output;
            }
        }

        // 子步骤 5：全部规则均未命中限制，检查结果为「通过」
        LOGGER.debug("ST100 子步骤 5：全部规则均未命中限制，检查结果为通过");
        return pass(output);
    }

    /**
     * 设置「通过」结果：无业务失败，错误字段保持 null，$处理方式$ 无值。
     */
    private ST100OutputBO pass(ST100OutputBO output) {
        output.setSucceed(true);
        return output;
    }

    /**
     * 子步骤 1：按 {接口服务代码}（messageCode）与 {接口服务类型}（messageType）查询【核心服务定义表】，
     * 取回 [服务信息列表]（0 条、1 条或多条，不取舍、不报错）。
     */
    private List<FmServiceDefineEO> queryServiceInfoList(ST100InputBO input) {
        FmServiceDefineEO query = new FmServiceDefineEO();
        query.setMessageCode(input.getMessageCode());
        query.setMessageType(input.getMessageType());
        return safeList(fmServiceDefineBcc.findByEo(query));
    }

    /**
     * 子步骤 2：判定 [服务信息列表] 中是否存在「$服务状态$＝A-生效 且 $黑名单检查标志$＝Y-是」的记录，
     * 存在任一条即视为该接口允许做黑名单检查。
     */
    private boolean existsBlacklistCheckService(List<FmServiceDefineEO> serviceInfoList) {
        for (FmServiceDefineEO serviceInfo : serviceInfoList) {
            if (SERVICE_STATUS_EFFECTIVE.equals(serviceInfo.getServiceStatus())
                    && BLACKLIST_CHECK_FLAG_YES.equals(serviceInfo.getBlacklistCheckFlag())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 子步骤 3：以 {客户号}、{身份证信息} 或 {账号} 为条件查询【名单信息表】，
     * 取回其中 $黑名单状态$ 为「生效」记录的 $名单类型代码$（多条全部取回）。
     *
     * <p>源需求未写明三个条件与【名单信息表】列的绑定与条件组合口径（Spec 放行事项 1），
     * 本实现按「任一命中」处理：{客户号} 用该表的客户号列，{身份证信息} 与 {账号} 用该表的通用
     * 数据值列（该表无证件号码列与账号列），逐个非空条件查询后按顺序合并结果。</p>
     */
    private List<String> queryEffectiveListTypes(ST100InputBO input) {
        List<RcAllListEO> records = new ArrayList<>();
        if (!isEmpty(input.getClientNo())) {
            RcAllListEO query = new RcAllListEO();
            query.setClientNo(input.getClientNo());
            records.addAll(safeList(rcAllListBcc.findByEo(query)));
        }
        if (!isEmpty(input.getDocumentId())) {
            RcAllListEO query = new RcAllListEO();
            query.setDataValue(input.getDocumentId());
            records.addAll(safeList(rcAllListBcc.findByEo(query)));
        }
        if (!isEmpty(input.getBaseAcctNo())) {
            RcAllListEO query = new RcAllListEO();
            query.setDataValue(input.getBaseAcctNo());
            records.addAll(safeList(rcAllListBcc.findByEo(query)));
        }

        List<String> listTypes = new ArrayList<>();
        for (RcAllListEO record : records) {
            if (RC_BLACK_STATUS_EFFECTIVE == record.getRcBlackStatus() && !isEmpty(record.getListType())) {
                listTypes.add(record.getListType());
            }
        }
        return listTypes;
    }

    /**
     * 子步骤 5～16：对单个 $名单类型代码$ 执行一条规则的完整判定链。
     *
     * @return 该条规则命中的 $处理方式$（`A`／`B`／`D`）；该条规则未命中限制时返回 {@code null}
     */
    private DealFlow executeRuleChain(ST100InputBO input, String listType) {
        // 子步骤 5：按 $名单类型代码$ 查询【名单类型表】取得 [黑名单检查规则编号]
        String ruleId = queryRuleId(listType);

        // 子步骤 6：规则编号为空时该条规则未命中限制（逐条语义，不终止整个步骤）
        if (isEmpty(ruleId)) {
            LOGGER.debug("ST100 子步骤 6：名单类型代码 {} 无 $黑名单检查规则编号$，该条规则未命中", listType);
            return null;
        }

        // 子步骤 7：按规则编号查询【名单限制规则表】取得 [名单限制规则信息]
        RcRuleTypeEO ruleInfo = queryRuleInfo(ruleId);

        // 子步骤 8：$黑名单限制操作标识$＝E-检查类 才继续，否则该条规则未命中限制
        if (ruleInfo == null || ResOperateFlag.E != ruleInfo.getResOperateFlag()) {
            LOGGER.debug("ST100 子步骤 8：规则 {} 的 $黑名单限制操作标识$ 非 E，该条规则未命中", ruleId);
            return null;
        }

        // 子步骤 9：按七个条件查询【名单检查范围表】取得 [事件类型]
        List<String> eventTypes = queryEventTypes(input);

        // 子步骤 10：按六个入参＋[事件类型] 查询【名单不检查范围表】取得 [名单不检查范围信息]
        List<RcListNotCheckRangeEO> notCheckRanges = queryNotCheckRanges(input, eventTypes);

        // 子步骤 11：[名单不检查范围信息] 不为空时该条规则未命中限制
        if (!notCheckRanges.isEmpty()) {
            LOGGER.debug("ST100 子步骤 11：规则 {} 命中 [名单不检查范围信息]，该条规则未命中", ruleId);
            return null;
        }

        // 子步骤 12：{凭证种类} 不在 $介质$ 范围内时该条规则未命中限制
        if (!isDocClassInMedium(input.getDocClass(), ruleInfo.getCardMedium())) {
            LOGGER.debug("ST100 子步骤 12：规则 {} 的 $介质$ 与上送 {凭证种类} 不匹配，该条规则未命中", ruleId);
            return null;
        }

        // 子步骤 13：按 {账号} 查询【账户信息】取得 $账户开立行行号$
        TranBranch acctBranch = queryAcctBranch(input.getBaseAcctNo());

        // 子步骤 14：检查机构（$限制机构范围$＝B-下级机构 且 [账户开立行行号] 满足机构关系）不成立时该条规则未命中
        if (!isBranchMatched(ruleInfo.getResBranchRange(), acctBranch, input.getAcctBranch())) {
            LOGGER.debug("ST100 子步骤 14：规则 {} 的 $限制机构范围$ 或机构关系不成立，该条规则未命中", ruleId);
            return null;
        }

        // 子步骤 15：按规则编号查询【名单限制规则表】取得 $处理方式$
        DealFlow dealFlow = queryDealFlow(ruleId);

        // 子步骤 16：按 $处理方式$ 给出该条规则的检查结果
        if (DealFlow.B == dealFlow || DealFlow.A == dealFlow || DealFlow.D == dealFlow) {
            LOGGER.debug("ST100 子步骤 16：规则 {} 命中，检查结果为 {}", ruleId, dealFlow);
            return dealFlow;
        }
        // 子步骤 16 d：$处理方式$ 为空或不属于 A／B／D 时该条规则检查结果为「通过」
        LOGGER.debug("ST100 子步骤 16 d：规则 {} 的 $处理方式$ 为空或域外取值，该条规则检查结果为通过", ruleId);
        return null;
    }

    /**
     * 子步骤 5：按 $名单类型代码$ 查询【名单类型表】取得 $黑名单检查规则编号$（无记录时返回 null）。
     */
    private String queryRuleId(String listType) {
        RcListTypeEO query = new RcListTypeEO();
        query.setListType(listType);
        List<RcListTypeEO> records = safeList(rcListTypeBcc.findByEo(query));
        return records.isEmpty() ? null : records.get(0).getRuleId();
    }

    /**
     * 子步骤 7：按 [黑名单检查规则编号] 查询【名单限制规则表】取得 [名单限制规则信息]。
     */
    private RcRuleTypeEO queryRuleInfo(String ruleId) {
        List<RcRuleTypeEO> records = safeList(rcRuleTypeBcc.findByEo(buildRuleTypeQuery(ruleId)));
        return records.isEmpty() ? null : records.get(0);
    }

    /**
     * 子步骤 15：按 [黑名单检查规则编号] 查询【名单限制规则表】取得 $处理方式$（无记录时返回 null）。
     */
    private DealFlow queryDealFlow(String ruleId) {
        List<RcRuleTypeEO> records = safeList(rcRuleTypeBcc.findByEo(buildRuleTypeQuery(ruleId)));
        return records.isEmpty() ? null : records.get(0).getDealFlow();
    }

    private RcRuleTypeEO buildRuleTypeQuery(String ruleId) {
        RcRuleTypeEO query = new RcRuleTypeEO();
        query.setRuleId(ruleId);
        return query;
    }

    /**
     * 子步骤 9：按 {事件类型}、{交易类型}、{渠道类型}、{交易码}、{服务代码}、{接口服务类型}、
     * {接口服务代码} 查询【名单检查范围表】，取得该表 $事件类型$ 的取值集合，作为子步骤 10 的 [事件类型]。
     *
     * <p>{@code eventType} 入参在源需求中同时被写作查询条件与查得结果（Spec 放行事项 3），
     * 本实现按正文照常作为查询条件上送，子步骤 10 使用本子步骤查得的结果。</p>
     */
    private List<String> queryEventTypes(ST100InputBO input) {
        RcListCheckRangeEO query = new RcListCheckRangeEO();
        query.setTranType(input.getTranType());
        query.setSourceType(input.getSourceType());
        query.setProgramId(input.getProgramId());
        query.setServiceCode(input.getServiceCode());
        query.setMessageType(input.getMessageType());
        query.setMessageCode(input.getMessageCode());
        query.setEventType(input.getEventType());

        List<String> eventTypes = new ArrayList<>();
        for (RcListCheckRangeEO record : safeList(rcListCheckRangeBcc.findByEo(query))) {
            eventTypes.add(record.getEventType());
        }
        return eventTypes;
    }

    /**
     * 子步骤 10：按 {交易类型}、{渠道类型}、{交易码}、{服务代码}、{接口服务类型}、{接口服务代码}
     * 以及子步骤 9 取得的 [事件类型] 查询【名单不检查范围表】，取回 [名单不检查范围信息]。
     *
     * <p>[事件类型] 为集合时逐个取值查询后合并结果；取得空集合时按六个入参查询一次。</p>
     */
    private List<RcListNotCheckRangeEO> queryNotCheckRanges(ST100InputBO input, List<String> eventTypes) {
        List<RcListNotCheckRangeEO> records = new ArrayList<>();
        if (eventTypes.isEmpty()) {
            records.addAll(safeList(rcListNotCheckRangeBcc.findByEo(buildNotCheckRangeQuery(input, null))));
            return records;
        }
        for (String eventType : eventTypes) {
            records.addAll(safeList(rcListNotCheckRangeBcc.findByEo(buildNotCheckRangeQuery(input, eventType))));
        }
        return records;
    }

    private RcListNotCheckRangeEO buildNotCheckRangeQuery(ST100InputBO input, String eventType) {
        RcListNotCheckRangeEO query = new RcListNotCheckRangeEO();
        query.setTranType(input.getTranType());
        query.setSourceType(input.getSourceType());
        query.setProgramId(input.getProgramId());
        query.setServiceCode(input.getServiceCode());
        query.setMessageType(input.getMessageType());
        query.setMessageCode(input.getMessageCode());
        query.setEventType(eventType);
        return query;
    }

    /**
     * 子步骤 12：判定输入 {凭证种类} 是否落在 [名单限制规则信息] 的 $介质$ 范围内。
     *
     * <p>源需求未写明 $介质$ 的取值形式与「在范围内」的匹配口径（Spec 不覆盖事项 5），
     * 本实现按码值比较，$介质$ 含分隔符时按集合逐个比较。</p>
     */
    private boolean isDocClassInMedium(DocClass docClass, String cardMedium) {
        if (docClass == null || docClass.getValue() == null || isEmpty(cardMedium)) {
            return false;
        }
        for (String medium : cardMedium.split(MEDIUM_SEPARATOR)) {
            if (docClass.getValue().equals(medium)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 子步骤 13：按 {账号} 查询【账户信息】取得 $账户开立行行号$。
     */
    private TranBranch queryAcctBranch(String baseAcctNo) {
        if (isEmpty(baseAcctNo)) {
            return null;
        }
        RbBusAcctEO query = new RbBusAcctEO();
        query.setBaseAcctNo(baseAcctNo);
        List<RbBusAcctEO> records = safeList(rbBusAcctBcc.findByEo(query));
        return records.isEmpty() ? null : records.get(0).getAcctBranch();
    }

    /**
     * 子步骤 14：检查机构。① [名单限制规则信息] 的 $限制机构范围$ 等于 B-下级机构；
     * ② [账户开立行行号] 等于当前 {交易机构}，或者等于当前 {交易机构} 的下级机构。
     *
     * <p>{交易机构} 的取值来源与「下级机构」的判定依据源需求均未给出（Spec 放行事项 4）：
     * 本实现以契约内唯一的机构类输入 {@code acctBranch} 作为当前 {交易机构} 取值，
     * 并以「相等」判定条件 ②；机构上下级归属资料不在本步骤允许查询的实体范围内，无法判定，故不作断言。</p>
     */
    private boolean isBranchMatched(LimitBranchRange resBranchRange, TranBranch acctBranch, TranBranch tranBranch) {
        // ① $限制机构范围$ 等于 B-下级机构
        if (LimitBranchRange.B != resBranchRange) {
            return false;
        }
        // ② [账户开立行行号] 等于当前 {交易机构}
        if (acctBranch == null || tranBranch == null) {
            return false;
        }
        return acctBranch == tranBranch;
    }

    /**
     * BCC 查询结果按空集合处理（null 与空集合同为「无记录」）。
     */
    private <T> List<T> safeList(List<T> records) {
        return records == null ? new ArrayList<T>() : records;
    }

    /**
     * 判断字符串是否为空（无值）：null 或长度为 0 的空字符串。
     */
    private boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
