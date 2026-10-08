package com.dcits;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dcits.depsit.facade.components.IMbProdDefineBcc;
import com.dcits.depsit.facade.components.IMbProdIntBcc;
import com.dcits.depsit.facade.eo.MbProdDefineEO;
import com.dcits.depsit.facade.eo.MbProdIntEO;

/**
 * 既定外部接口 mock：按知识《外部接口清单》的地址与出参模拟产品管理、基础公共、贷款三个外部系统。
 * 查询类接口走工程现成的 Bcc 表访问组件，查不到返回空串/空列表；只记录 debug 日志，不抛业务异常。
 */
@RestController
public class MockExternalTask {

    private static final Logger logger = LoggerFactory.getLogger(MockExternalTask.class);

    /** 生成账号的固定前缀（公共功能《生成账号》不查表，按入参拼装）。 */
    private static final String ACCT_NO_PREFIX = "ACCT";

    /** 贷款组件不提供当日累计透支额度的真实口径，mock 返回固定值。 */
    private static final String DAILY_OVERDRAFT_AMT = "0.00";

    /** 账号生成序号，mock 进程内自增。 */
    private static final AtomicLong ACCT_NO_SEQ = new AtomicLong();

    /**
     * 参数KEY值 → 查询产品信息的出参字段，取自知识《外部接口清单》两处取值的一一对应关系。
     */
    private static final Map<String, String> ATTR_KEY_FIELDS = attrKeyFields();

    @Autowired
    private IMbProdDefineBcc mbProdDefineBcc;

    @Autowired
    private IMbProdIntBcc mbProdIntBcc;

    /**
     * 产品管理《查询产品信息》：按产品编号 + 参数KEY值查产品定义表 MB_PROD_DEFINE 取属性值。
     */
    @GetMapping("/productManagement/queryProductInfo")
    public Map<String, Object> queryProductInfo(@RequestParam(required = false) String prodNo,
                                                @RequestParam(required = false) String attrKey) {
        Map<String, Object> result = new HashMap<>();
        String field = attrKey == null ? null : ATTR_KEY_FIELDS.get(attrKey);
        if (field == null) {
            logger.debug("查询产品信息 mock 未识别的参数KEY值：prodNo={}，attrKey={}", prodNo, attrKey);
            return result;
        }
        String attrValue = "";
        try {
            if (prodNo != null && !prodNo.isBlank()) {
                MbProdDefineEO condition = new MbProdDefineEO();
                condition.setProdNo(prodNo);
                condition.setAttrKey(attrKey);
                List<MbProdDefineEO> rows = mbProdDefineBcc.findByEo(condition);
                if (rows != null && !rows.isEmpty() && rows.get(0).getAttrValue() != null) {
                    attrValue = rows.get(0).getAttrValue();
                }
            }
        } catch (Exception ex) {
            logger.debug("查询产品信息 mock 查询失败：prodNo={}，attrKey={}，原因={}", prodNo, attrKey, ex.getMessage());
        }
        logger.debug("查询产品信息 mock 返回：prodNo={}，attrKey={}，{}={}", prodNo, attrKey, field, attrValue);
        result.put(field, attrValue);
        return result;
    }

    /**
     * 产品管理《查询产品利率信息》：按产品编号查产品利率信息表 MB_PROD_INT 取首条记录。
     */
    @GetMapping("/productManagement/queryProductInterestRate")
    public Map<String, Object> queryProductInterestRate(@RequestParam(required = false) String prodNo) {
        List<String> intTypeList = new ArrayList<>();
        String prodIntRate = "";
        String minExecRate = "";
        String maxExecRate = "";
        try {
            if (prodNo != null && !prodNo.isBlank()) {
                MbProdIntEO condition = new MbProdIntEO();
                condition.setProdNo(prodNo);
                List<MbProdIntEO> rows = mbProdIntBcc.findByEo(condition);
                if (rows != null && !rows.isEmpty()) {
                    for (MbProdIntEO row : rows) {
                        if (row.getIntType() != null) {
                            intTypeList.add(row.getIntType().getValue());
                        }
                    }
                    MbProdIntEO first = rows.get(0);
                    // 产品利率表内无对应字段，按知识取最小执行利率 MIN_RATE 占位。
                    prodIntRate = plain(first.getMinRate());
                    minExecRate = plain(first.getMinRate());
                    maxExecRate = plain(first.getMaxRate());
                }
            }
        } catch (Exception ex) {
            logger.debug("查询产品利率信息 mock 查询失败：prodNo={}，原因={}", prodNo, ex.getMessage());
        }
        logger.debug("查询产品利率信息 mock 返回：prodNo={}，intTypeList={}，prodIntRate={}，minExecRate={}，maxExecRate={}",
                prodNo, intTypeList, prodIntRate, minExecRate, maxExecRate);
        Map<String, Object> result = new HashMap<>();
        result.put("intTypeList", intTypeList);
        result.put("prodIntRate", prodIntRate);
        result.put("maxExecRate", maxExecRate);
        result.put("minExecRate", minExecRate);
        return result;
    }

    /**
     * 基础公共《生成账号》：不查表，按固定前缀 + 交易机构 + 序号拼装账号。
     */
    @GetMapping("/basicCommon/genAcctNo")
    public Map<String, Object> genAcctNo(@RequestParam(required = false) String acctGenRuleType,
                                         @RequestParam(required = false) String branch,
                                         @RequestParam(required = false) String prodNo) {
        String acctNo = "";
        try {
            acctNo = ACCT_NO_PREFIX + blankToEmpty(branch) + String.format("%06d", ACCT_NO_SEQ.incrementAndGet());
        } catch (Exception ex) {
            logger.debug("生成账号 mock 拼装失败：原因={}", ex.getMessage());
        }
        logger.debug("生成账号 mock 返回：acctGenRuleType={}，branch={}，prodNo={}，acctNo={}",
                acctGenRuleType, branch, prodNo, acctNo);
        Map<String, Object> result = new HashMap<>();
        result.put("acctNo", acctNo);
        return result;
    }

    /**
     * 贷款《计算账号当日放款金额合计》：不查表，按账号返回固定值。
     */
    @GetMapping("/loan/calcAcctDailyLoanAmt")
    public Map<String, Object> calcAcctDailyLoanAmt(@RequestParam(required = false) String acctNo) {
        logger.debug("计算账号当日放款金额合计 mock 返回：acctNo={}，dailyOverdraftAmt={}", acctNo, DAILY_OVERDRAFT_AMT);
        Map<String, Object> result = new HashMap<>();
        result.put("dailyOverdraftAmt", DAILY_OVERDRAFT_AMT);
        return result;
    }

    /** 参数KEY值到出参字段的对应关系，顺序同知识《外部接口清单》的参数KEY值取值。 */
    private static Map<String, String> attrKeyFields() {
        Map<String, String> fields = new LinkedHashMap<>();
        fields.put("CLIENT_TYPE", "clientType");
        fields.put("ACCT_TYPE", "acctType");
        fields.put("INLAND_OFFSHORE", "inlandOffshoreFlag");
        fields.put("PROD_BRANCH", "branchList");
        fields.put("ACCT_NATURE", "acctAttr");
        fields.put("ALL_DEP_FLAG", "allDepFlag");
        fields.put("ALL_DRA_FLAG", "allDraFlag");
        fields.put("WITHDRAWAL_TYPE", "withdrawalTypeList");
        fields.put("CCY", "ccyList");
        fields.put("ALLOW_SUSPEND_FLAG", "allowSuspendFlag");
        return fields;
    }

    /** 金额转字符串，为空时返回空串。 */
    private static String plain(BigDecimal value) {
        return value == null ? "" : value.toPlainString();
    }

    /** 入参为空时返回空串，避免 mock 结果出现 null。 */
    private static String blankToEmpty(String value) {
        return value == null ? "" : value.trim();
    }
}
