package com.dcits;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dcits.depsit.enums.IntType;
import com.dcits.depsit.facade.components.IMbProdDefineBcc;
import com.dcits.depsit.facade.components.IMbProdIntBcc;
import com.dcits.depsit.facade.eo.MbProdDefineEO;
import com.dcits.depsit.facade.eo.MbProdIntEO;

/**
 * 既定外部接口 mock：以本地 8980 的跨组件客户端 ExternalTaskClient 的调用地址与参数为准，
 * 按知识《外部接口清单》的 mock 业务逻辑实现。仅用于联调，不抛业务异常，只打 debug 日志。
 */
@RestController
public class MockExternalTask {

    private static final Logger logger = LoggerFactory.getLogger(MockExternalTask.class);

    /** 账号生成固定前缀（知识：固定前缀 + 交易机构 + 序号）。 */
    private static final String ACCT_NO_PREFIX = "62";

    /** 贷款组件当日累计透支额度固定返回口径（知识：不查表，固定 0.00）。 */
    private static final String FIXED_DAILY_OVERDRAFT_AMT = "0.00";

    /** 账号生成序号，进程内自增。 */
    private final AtomicInteger acctNoSeq = new AtomicInteger();

    /** 产品定义表（MB_PROD_DEFINE）现成表访问组件。 */
    @Autowired
    private IMbProdDefineBcc mbProdDefineBcc;

    /** 产品利率信息表（MB_PROD_INT）现成表访问组件。 */
    @Autowired
    private IMbProdIntBcc mbProdIntBcc;

    /**
     * 产品管理《查询产品信息》：按 产品编号 + ATTR_KEY 查产品定义表取 ATTR_VALUE，查不到返回空串。
     * 出参字段与 attrKey 一一对应，未被查询的字段返回空值。
     */
    @GetMapping("/productManagement/queryProductInfo")
    public Map<String, Object> queryProductInfo(@RequestParam("prodNo") String prodNo,
            @RequestParam("attrKey") String attrKey) {
        Map<String, Object> result = emptyProductInfo();
        try {
            MbProdDefineEO condition = new MbProdDefineEO();
            condition.setProdNo(prodNo);
            condition.setAttrKey(attrKey);
            List<MbProdDefineEO> rows = mbProdDefineBcc.findByEo(condition);
            logger.debug("mock 查询产品信息 prodNo={}, attrKey={}, 命中记录数={}", prodNo, attrKey,
                    rows == null ? 0 : rows.size());
            if (rows != null && !rows.isEmpty() && rows.get(0) != null) {
                String attrValue = rows.get(0).getAttrValue() == null ? "" : rows.get(0).getAttrValue();
                String field = attrKeyToField(attrKey);
                if (field == null) {
                    result.put("attrValue", attrValue);
                } else if (isListField(field)) {
                    result.put(field, new ArrayList<>(List.of(attrValue)));
                } else {
                    result.put(field, attrValue);
                }
            }
        } catch (Exception ex) {
            logger.debug("mock 查询产品信息异常 prodNo={}, attrKey={}", prodNo, attrKey, ex);
        }
        return result;
    }

    /**
     * 产品管理《查询产品利率信息》：按产品编号查产品利率信息表 MB_PROD_INT 取首条记录，
     * 利率类型列表＝全部记录的利率类型，产品利率与最小执行利率＝MIN_RATE，最大执行利率＝MAX_RATE；查不到返回空串。
     */
    @GetMapping("/productManagement/queryProductInterestRate")
    public Map<String, Object> queryProductInterestRate(@RequestParam("prodNo") String prodNo) {
        Map<String, Object> result = emptyProductIntRate();
        try {
            MbProdIntEO condition = new MbProdIntEO();
            condition.setProdNo(prodNo);
            List<MbProdIntEO> rows = mbProdIntBcc.findByEo(condition);
            logger.debug("mock 查询产品利率信息 prodNo={}, 命中记录数={}", prodNo, rows == null ? 0 : rows.size());
            if (rows == null || rows.isEmpty()) {
                return result;
            }
            List<String> intTypeList = new ArrayList<>();
            for (MbProdIntEO row : rows) {
                if (row == null) {
                    continue;
                }
                IntType intType = row.getIntType();
                intTypeList.add(intType == null ? "" : intType.getValue());
            }
            MbProdIntEO first = rows.get(0);
            String minRate = toPlainString(first == null ? null : first.getMinRate());
            String maxRate = toPlainString(first == null ? null : first.getMaxRate());
            result.put("intTypeList", intTypeList);
            result.put("prodIntRate", minRate);
            result.put("minExecRate", minRate);
            result.put("maxExecRate", maxRate);
        } catch (Exception ex) {
            logger.debug("mock 查询产品利率信息异常 prodNo={}", prodNo, ex);
        }
        return result;
    }

    /**
     * 基础公共《生成账号》：不查表，按 账号生成规则类型 + 交易机构 + 产品编号 拼装账号（固定前缀 + 交易机构 + 序号）。
     */
    @GetMapping("/basicCommon/genAcctNo")
    public Map<String, Object> genAcctNo(@RequestParam("acctGenRuleType") String acctGenRuleType,
            @RequestParam("branch") String branch,
            @RequestParam(value = "prodNo", required = false) String prodNo) {
        Map<String, Object> result = new HashMap<>();
        String acctNo = "";
        try {
            acctNo = ACCT_NO_PREFIX + (branch == null ? "" : branch)
                    + String.format("%06d", this.acctNoSeq.incrementAndGet());
            logger.debug("mock 生成账号 acctGenRuleType={}, branch={}, prodNo={}, acctNo={}", acctGenRuleType, branch,
                    prodNo, acctNo);
        } catch (Exception ex) {
            logger.debug("mock 生成账号异常 acctGenRuleType={}, branch={}, prodNo={}", acctGenRuleType, branch, prodNo, ex);
        }
        result.put("acctNo", acctNo);
        return result;
    }

    /**
     * 贷款《计算账号当日放款金额合计》：不查表，按账号返回固定值 0.00。
     */
    @GetMapping("/loan/calcAcctDailyLoanAmt")
    public Map<String, Object> calcAcctDailyLoanAmt(@RequestParam("acctNo") String acctNo) {
        Map<String, Object> result = new HashMap<>();
        logger.debug("mock 计算账号当日放款金额合计 acctNo={}，返回固定值 {}", acctNo, FIXED_DAILY_OVERDRAFT_AMT);
        result.put("dailyOverdraftAmt", FIXED_DAILY_OVERDRAFT_AMT);
        return result;
    }

    /** 查询产品信息的空出参骨架：集合类字段为空列表，其余为空串。 */
    private static Map<String, Object> emptyProductInfo() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("acctType", "");
        result.put("withdrawalTypeList", new ArrayList<>());
        result.put("ccyList", new ArrayList<>());
        result.put("allowSuspendFlag", "");
        result.put("allDepFlag", "");
        result.put("allDraFlag", "");
        result.put("clientType", "");
        result.put("inlandOffshoreFlag", "");
        result.put("branchList", new ArrayList<>());
        result.put("acctAttr", "");
        return result;
    }

    /** 查询产品利率信息的空出参骨架。 */
    private static Map<String, Object> emptyProductIntRate() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("intTypeList", new ArrayList<>());
        result.put("prodIntRate", "");
        result.put("maxExecRate", "");
        result.put("minExecRate", "");
        return result;
    }

    /** 参数 KEY 值（ATTR_KEY）到出参字段的对应关系。 */
    private static String attrKeyToField(String attrKey) {
        if (attrKey == null) {
            return null;
        }
        return switch (attrKey) {
            case "CLIENT_TYPE" -> "clientType";
            case "ACCT_TYPE" -> "acctType";
            case "INLAND_OFFSHORE" -> "inlandOffshoreFlag";
            case "PROD_BRANCH" -> "branchList";
            case "ACCT_NATURE" -> "acctAttr";
            case "ALL_DEP_FLAG" -> "allDepFlag";
            case "ALL_DRA_FLAG" -> "allDraFlag";
            case "WITHDRAWAL_TYPE" -> "withdrawalTypeList";
            case "CCY" -> "ccyList";
            case "ALLOW_SUSPEND_FLAG" -> "allowSuspendFlag";
            default -> null;
        };
    }

    /** 出参中为集合的字段。 */
    private static boolean isListField(String field) {
        return "branchList".equals(field) || "withdrawalTypeList".equals(field) || "ccyList".equals(field);
    }

    /** BigDecimal 转字符串，空值返回空串。 */
    private static String toPlainString(BigDecimal value) {
        return value == null ? "" : value.toPlainString();
    }
}
