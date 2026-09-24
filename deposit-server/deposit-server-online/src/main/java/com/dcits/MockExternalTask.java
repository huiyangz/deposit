package com.dcits;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dcits.deposit.facade.components.IMbProdDefineBcc;
import com.dcits.deposit.facade.components.IMbProdIntBcc;
import com.dcits.deposit.facade.eo.MbProdDefineEO;
import com.dcits.deposit.facade.eo.MbProdIntEO;

/**
 * 既定外部系统接口 mock：暴露与 {@code ExternalTaskClient} 调用地址一致的 GET 路径。
 * 查表经工程内表访问组件（Bcc），查不到返回空串；只 logger.debug，不抛异常。
 */
@RestController
public class MockExternalTask {

    private static final Logger logger = LoggerFactory.getLogger(MockExternalTask.class);

    /** 生成账号 mock：固定前缀 + 交易机构 + 序号 */
    private static final String ACCT_NO_PREFIX = "AC";
    private static final AtomicLong ACCT_NO_SEQ = new AtomicLong();

    /** attrKey 与出参字段的对应关系（产品定义表 ATTR_KEY → 查询产品信息出参） */
    private static final Map<String, String> ATTR_KEY_FIELD_MAP = Map.of(
            "CLIENT_TYPE", "clientType",
            "ACCT_TYPE", "acctType",
            "INLAND_OFFSHORE", "inlandOffshoreFlag",
            "PROD_BRANCH", "branchList",
            "ACCT_NATURE", "acctAttr",
            "ALL_DEP_FLAG", "allDepFlag",
            "ALL_DRA_FLAG", "allDraFlag",
            "WITHDRAWAL_TYPE", "withdrawalTypeList",
            "CCY", "ccyList",
            "ALLOW_SUSPEND_FLAG", "allowSuspendFlag");

    /** 集合类出参（ATTR_VALUE 按逗号拆分为列表，查不到返回空列表） */
    private static final List<String> LIST_FIELDS = List.of("branchList", "withdrawalTypeList", "ccyList");

    private final IMbProdDefineBcc mbProdDefineBcc;
    private final IMbProdIntBcc mbProdIntBcc;

    public MockExternalTask(IMbProdDefineBcc mbProdDefineBcc, IMbProdIntBcc mbProdIntBcc) {
        this.mbProdDefineBcc = mbProdDefineBcc;
        this.mbProdIntBcc = mbProdIntBcc;
    }

    /**
     * 产品管理·查询产品信息 mock：按产品编号 + ATTR_KEY 查产品定义表 MB_PROD_DEFINE 取属性值 ATTR_VALUE。
     */
    @GetMapping("/productManagement/queryProductInfo")
    public Map<String, Object> queryProductInfo(@RequestParam String prodNo, @RequestParam String attrKey) {
        logger.debug("queryProductInfo mock prodNo={}, attrKey={}", prodNo, attrKey);
        Map<String, Object> body = new HashMap<>();
        String field = ATTR_KEY_FIELD_MAP.get(attrKey);
        if (field == null) {
            logger.debug("queryProductInfo mock unknown attrKey={}", attrKey);
            return body;
        }
        try {
            MbProdDefineEO eo = new MbProdDefineEO();
            eo.setProdNo(prodNo);
            eo.setAttrKey(attrKey);
            List<MbProdDefineEO> rows = mbProdDefineBcc.findByEo(eo);
            String attrValue = rows.isEmpty() || rows.get(0).getAttrValue() == null ? "" : rows.get(0).getAttrValue();
            body.put(field, LIST_FIELDS.contains(field) ? splitToList(attrValue) : attrValue);
        } catch (Exception ex) {
            logger.debug("queryProductInfo mock query failed: {}", ex.getMessage());
            body.put(field, LIST_FIELDS.contains(field) ? List.of() : "");
        }
        return body;
    }

    /**
     * 产品管理·查询产品利率信息 mock：按产品编号查产品利率信息表 MB_PROD_INT 取首条记录；
     * 利率类型列表取全部记录的利率类型，产品利率无表内字段、以最小执行利率占位。
     */
    @GetMapping("/productManagement/queryProductInterestRate")
    public Map<String, Object> queryProductInterestRate(@RequestParam String prodNo) {
        logger.debug("queryProductInterestRate mock prodNo={}", prodNo);
        Map<String, Object> body = new HashMap<>();
        try {
            MbProdIntEO eo = new MbProdIntEO();
            eo.setProdNo(prodNo);
            List<MbProdIntEO> rows = mbProdIntBcc.findByEo(eo);
            List<String> intTypeList = new ArrayList<>();
            for (MbProdIntEO row : rows) {
                if (row.getIntType() != null) {
                    intTypeList.add(row.getIntType().name());
                }
            }
            MbProdIntEO first = rows.isEmpty() ? null : rows.get(0);
            body.put("intTypeList", intTypeList);
            body.put("prodIntRate", first == null ? "" : rateToStr(first.getMinRate()));
            body.put("maxExecRate", first == null ? "" : rateToStr(first.getMaxRate()));
            body.put("minExecRate", first == null ? "" : rateToStr(first.getMinRate()));
        } catch (Exception ex) {
            logger.debug("queryProductInterestRate mock query failed: {}", ex.getMessage());
            body.put("intTypeList", List.of());
            body.put("prodIntRate", "");
            body.put("maxExecRate", "");
            body.put("minExecRate", "");
        }
        return body;
    }

    /**
     * 基础公共·生成账号 mock：不查表，按固定前缀 + 交易机构 + 序号拼装账号。
     */
    @GetMapping("/basicCommon/genAcctNo")
    public Map<String, Object> genAcctNo(@RequestParam String acctGenRuleType, @RequestParam String branch,
            @RequestParam(required = false) String prodNo) {
        logger.debug("genAcctNo mock acctGenRuleType={}, branch={}, prodNo={}", acctGenRuleType, branch, prodNo);
        String acctNo = ACCT_NO_PREFIX + branch + String.format("%010d", ACCT_NO_SEQ.incrementAndGet());
        return Map.of("acctNo", acctNo);
    }

    /**
     * 贷款·计算账号当日放款金额合计 mock：贷款组件不提供真实口径，按账号返回固定值 0.00。
     */
    @GetMapping("/loan/calcAcctDailyLoanAmt")
    public Map<String, Object> calcAcctDailyLoanAmt(@RequestParam String acctNo) {
        logger.debug("calcAcctDailyLoanAmt mock acctNo={}", acctNo);
        return Map.of("dailyOverdraftAmt", "0.00");
    }

    private List<String> splitToList(String attrValue) {
        if (attrValue == null || attrValue.isEmpty()) {
            return List.of();
        }
        return Arrays.asList(attrValue.split(","));
    }

    private String rateToStr(BigDecimal rate) {
        return rate == null ? "" : rate.toPlainString();
    }
}
