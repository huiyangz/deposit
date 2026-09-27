package com.dcits;

import java.util.ArrayList;
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

import com.dcits.deposit.facade.components.IMbProdDefineBcc;
import com.dcits.deposit.facade.components.IMbProdIntBcc;
import com.dcits.deposit.facade.eo.MbProdDefineEO;
import com.dcits.deposit.facade.eo.MbProdIntEO;

/**
 * 既定外部系统 mock：按知识《外部接口清单》逐条实现，暴露与
 * {@link com.dcits.client.ExternalTaskClient} 调用地址一致的 GET 路径。
 *
 * 查表接口经工程内表访问组件（Bcc）查询；查不到返回空串；
 * 不查表的按清单返回拼装值或固定值；只 logger.debug、不抛异常。
 */
@RestController
public class MockExternalTask {

    private static final Logger logger = LoggerFactory.getLogger(MockExternalTask.class);

    /** 生成账号 mock 的固定前缀 */
    private static final String ACCT_NO_PREFIX = "AC";

    /** 生成账号 mock 的自增序号 */
    private static final AtomicLong ACCT_NO_SEQ = new AtomicLong();

    @Autowired
    private IMbProdDefineBcc mbProdDefineBcc;

    @Autowired
    private IMbProdIntBcc mbProdIntBcc;

    /**
     * 产品管理·查询产品信息：按「产品编号 + 参数KEY值」查产品定义表 MB_PROD_DEFINE 取属性值。
     * 查不到返回空串。
     */
    @GetMapping("/productManagement/queryProductInfo")
    public String queryProductInfo(@RequestParam String prodNo, @RequestParam String attrKey) {
        logger.debug("mock queryProductInfo prodNo={}, attrKey={}", prodNo, attrKey);
        MbProdDefineEO probe = new MbProdDefineEO();
        probe.setProdNo(prodNo);
        probe.setAttrKey(attrKey);
        List<MbProdDefineEO> records = mbProdDefineBcc.findByEo(probe);
        if (records == null || records.isEmpty()) {
            logger.debug("mock queryProductInfo no record found, return empty string");
            return "";
        }
        String attrValue = records.get(0).getAttrValue();
        logger.debug("mock queryProductInfo attrValue={}", attrValue);
        return attrValue == null ? "" : attrValue;
    }

    /**
     * 产品管理·查询产品利率信息：按产品编号查产品利率信息表 MB_PROD_INT。
     * 利率类型列表＝全部记录的利率类型；产品利率＝首条最小执行利率占位；
     * 最小执行利率＝首条 MIN_RATE；最大执行利率＝首条 MAX_RATE。查不到返回空串。
     */
    @GetMapping("/productManagement/queryProductInterestRate")
    public Map<String, Object> queryProductInterestRate(@RequestParam String prodNo) {
        logger.debug("mock queryProductInterestRate prodNo={}", prodNo);
        Map<String, Object> result = new LinkedHashMap<>();
        List<String> intTypeList = new ArrayList<>();
        result.put("intTypeList", intTypeList);
        result.put("prodIntRate", "");
        result.put("minExecRate", "");
        result.put("maxExecRate", "");
        MbProdIntEO probe = new MbProdIntEO();
        probe.setProdNo(prodNo);
        List<MbProdIntEO> records = mbProdIntBcc.findByEo(probe);
        if (records == null || records.isEmpty()) {
            logger.debug("mock queryProductInterestRate no record found, return empty values");
            return result;
        }
        for (MbProdIntEO record : records) {
            if (record.getIntType() != null) {
                intTypeList.add(record.getIntType().name());
            }
        }
        MbProdIntEO first = records.get(0);
        result.put("prodIntRate", first.getMinRate() == null ? "" : first.getMinRate().toPlainString());
        result.put("minExecRate", first.getMinRate() == null ? "" : first.getMinRate().toPlainString());
        result.put("maxExecRate", first.getMaxRate() == null ? "" : first.getMaxRate().toPlainString());
        logger.debug("mock queryProductInterestRate result={}", result);
        return result;
    }

    /**
     * 基础公共·生成账号：不查表，按固定前缀 + 交易机构 + 序号拼装账号返回。
     */
    @GetMapping("/basicCommon/genAcctNo")
    public String genAcctNo(@RequestParam String acctGenRuleType, @RequestParam String branch,
            @RequestParam(required = false) String prodNo) {
        logger.debug("mock genAcctNo acctGenRuleType={}, branch={}, prodNo={}", acctGenRuleType, branch, prodNo);
        String acctNo = ACCT_NO_PREFIX + branch + String.format("%06d", ACCT_NO_SEQ.incrementAndGet());
        logger.debug("mock genAcctNo acctNo={}", acctNo);
        return acctNo;
    }

    /**
     * 贷款·计算账号当日放款金额合计：不查表，按账号返回固定值 0.00。
     * 本组件外部依赖未引用该接口，仅按《外部接口清单》提供 mock。
     */
    @GetMapping("/loan/calcAcctDailyLoanAmt")
    public String calcAcctDailyLoanAmt(@RequestParam String acctNo) {
        logger.debug("mock calcAcctDailyLoanAmt acctNo={}", acctNo);
        return "0.00";
    }
}
